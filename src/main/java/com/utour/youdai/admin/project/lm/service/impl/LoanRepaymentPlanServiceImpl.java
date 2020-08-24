package com.utour.youdai.admin.project.lm.service.impl;

import com.utour.youdai.admin.common.utils.DecimalUtils;
import com.utour.youdai.admin.common.utils.loan.AverageCapitalPlusInterestUtils;
import com.utour.youdai.admin.common.utils.loan.AverageCapitalUtils;
import com.utour.youdai.admin.project.lm.domain.LoanApplication;
import com.utour.youdai.admin.project.lm.domain.LoanRepaymentPlan;
import com.utour.youdai.admin.project.lm.mapper.LoanRepaymentPlanMapper;
import com.utour.youdai.admin.project.lm.service.ILoanRepaymentPlanService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import java.math.RoundingMode;
import java.util.*;

/**
 * 还款计划Service业务层处理
 *
 * @author zh
 * @date 2020-08-14
 */
@Service
public class LoanRepaymentPlanServiceImpl implements ILoanRepaymentPlanService {
    private final LoanRepaymentPlanMapper loanRepaymentPlanMapper;

    public LoanRepaymentPlanServiceImpl(LoanRepaymentPlanMapper loanRepaymentPlanMapper) {
        this.loanRepaymentPlanMapper = loanRepaymentPlanMapper;
    }

    /**
     * 查询还款计划
     *
     * @param id 还款计划ID
     * @return 还款计划
     */
    @Override
    public LoanRepaymentPlan selectLoanRepaymentPlanById(Long id) {
        return loanRepaymentPlanMapper.selectLoanRepaymentPlanById(id);
    }

    /**
     * 查询还款计划列表
     *
     * @param loanRepaymentPlan 还款计划
     * @return 还款计划
     */
    @Override
    public List<LoanRepaymentPlan> selectLoanRepaymentPlanList(LoanRepaymentPlan loanRepaymentPlan) {
        return loanRepaymentPlanMapper.selectLoanRepaymentPlanList(loanRepaymentPlan);
    }

    /**
     * 新增还款计划
     *
     * @param loanRepaymentPlan 还款计划
     * @return 结果
     */
    @Override
    public int insertLoanRepaymentPlan(LoanRepaymentPlan loanRepaymentPlan) {
        return loanRepaymentPlanMapper.insertLoanRepaymentPlan(loanRepaymentPlan);
    }

    /**
     * 修改还款计划
     *
     * @param loanRepaymentPlan 还款计划
     * @return 结果
     */
    @Override
    public int updateLoanRepaymentPlan(LoanRepaymentPlan loanRepaymentPlan) {
        return loanRepaymentPlanMapper.updateLoanRepaymentPlan(loanRepaymentPlan);
    }

    /**
     * 批量删除还款计划
     *
     * @param ids 需要删除的还款计划ID
     * @return 结果
     */
    @Override
    public int deleteLoanRepaymentPlanByIds(Long[] ids) {
        return loanRepaymentPlanMapper.deleteLoanRepaymentPlanByIds(ids);
    }

    /**
     * 删除还款计划信息
     *
     * @param id 还款计划ID
     * @return 结果
     */
    @Override
    public int deleteLoanRepaymentPlanById(Long id) {
        return loanRepaymentPlanMapper.deleteLoanRepaymentPlanById(id);
    }

    @Override
    public int deletePlanByLaId(Long laId) {
        return loanRepaymentPlanMapper.deletePlanByLaId(laId);
    }

    @Override
    public List<LoanRepaymentPlan> getPlanList(Long laId) {
        return loanRepaymentPlanMapper.getPlanList(laId);
    }

    @Override
    public int createRepayPlan(LoanApplication apply) {
        List<LoanRepaymentPlan> list = new ArrayList<LoanRepaymentPlan>();
        Date start = apply.getApplyStartDate();
        Date end = apply.getApplyEndDate();
        int applyExpires = apply.getApplyExpires();
        String applyExpiresUnit = apply.getApplyExpiresUnit();
        if (applyExpiresUnit.equals("年")) {//贷款期限单位 年转为月
            applyExpires = 12 * applyExpires;
        }
        BigDecimal applyRate = apply.getApplyRate();
        //利率单位
        String applyRateUnit = apply.getApplyRateUnit();
        BigDecimal applyMoney = apply.getApplyMoney();
        Long laId = apply.getId();
        /**
         * 年利率
         */
        BigDecimal yearRate = this.changeRateToYear(applyRateUnit, applyRate);
        //1:等额本息 2:等额本金 3:一次性到期还本付息 4:按月分期付息、到期还本 5:自由还款
        if (apply.getRepayType().intValue() == 1) {//
            list = this.equalInstallmentPayment(applyMoney, applyExpires, yearRate, start, laId, applyExpiresUnit);
        } else if (apply.getRepayType().intValue() == 2) {//
            list = this.averageCapital(applyMoney, applyExpires, yearRate, start, laId, applyExpiresUnit);
        } else if (apply.getRepayType().intValue() == 3) {//
            list = this.monthInterestPayment(applyMoney, applyExpires, applyRate, start, laId, applyExpiresUnit);
        } else if (apply.getRepayType().intValue() == 4) {//
            list = this.oneTimeRepay(applyMoney, applyRate, applyExpires, end, laId);
        }
        int n = loanRepaymentPlanMapper.batchInsert(list);
        return n;
    }

    /**
     * 日期转换
     *
     * @param inputDate 起始日期
     * @param number    增加量
     * @param unit      增加单位
     * @return
     */
    private Date changeDateAfter(Date inputDate, int number, String unit) {
        Calendar c = Calendar.getInstance();
        c.setTime(inputDate);
        if (unit.equals("月")) {
            c.add(Calendar.MONTH, number);
        } else if (unit.equals("年")) {
            c.add(Calendar.YEAR, number);
        } else if (unit.equals("日")) {
            c.add(Calendar.DAY_OF_MONTH, number);
        }
        return c.getTime();
    }

    /**
     * 利率全部转换为年利率
     *
     * @return
     */
    private BigDecimal changeRateToYear(String unit, BigDecimal rate) {
        BigDecimal monthRate = new BigDecimal(0);
        BigDecimal d100 = new BigDecimal(100);
        if (unit.equals("年")) {
            monthRate = rate.divide(d100, 2, BigDecimal.ROUND_HALF_UP);
        } else if (unit.equals("月")) {
            monthRate = rate.multiply(new BigDecimal(12)).divide(d100, 2, BigDecimal.ROUND_HALF_UP);
        } else if (unit.equals("日")) {
            monthRate = rate.multiply(new BigDecimal(360)).divide(d100, 2, BigDecimal.ROUND_HALF_UP);
        }
        return monthRate;
    }

    /**
     * 等额本息
     * 等额本息：每月还款金额 =〔贷款本金×月利率×（1＋月利率）＾还款月数〕÷〔（1＋月利率）＾还款月数－1〕
     * 每月应还利息 =  （本金 - 已还本金） * 利率
     * 每月应还本金 = 月还款 - 每月利息
     *
     * @param applyExpires  还款期数
     * @param applyMoney    贷款本金
     * @param rate          利率
     * @param start         贷款起始日期
     * @param laId          贷款申请主表id
     * @param applyRateUnit 利率单位
     * @return
     */
    private List<LoanRepaymentPlan> equalInstallmentPayment(BigDecimal applyMoney, int applyExpires,
                                                            BigDecimal rate, Date start, long laId,
                                                            String applyRateUnit) {
        List<LoanRepaymentPlan> list = new ArrayList<>();
        double monthRepay = AverageCapitalPlusInterestUtils.getPerMonthPrincipalInterest(applyMoney.doubleValue(), rate.doubleValue(), applyExpires);
        Map<Integer, BigDecimal> mapInterest = AverageCapitalPlusInterestUtils.getPerMonthInterest(applyMoney.doubleValue(), rate.doubleValue(), applyExpires);
        Map<Integer, BigDecimal> mapPrincipal = AverageCapitalPlusInterestUtils.getPerMonthPrincipal(applyMoney.doubleValue(), rate.doubleValue(), applyExpires);
        for (int i = 0; i < applyExpires; i++) {
            LoanRepaymentPlan plan = new LoanRepaymentPlan();
            //计算 期数对应的 还款日期
            Date planDate = changeDateAfter(start, i, applyRateUnit);
            plan.setPlanDate(planDate);
            plan.setLaId(laId);
            plan.setIndexNo(i + 1);
            plan.setPlanMoneySum(new BigDecimal(monthRepay));
            plan.setPlanInterestMoney(mapInterest.get(i + 1));
            plan.setPlanPrincipalMoney(mapPrincipal.get(i + 1));
            plan.setPushStatus(1);//默认待推送 状态
            list.add(plan);
        }
        return list;
    }

    /**
     * 等额本金
     * 每月还款金额 = （贷款本金 / 还款月数）+（本金 — 已归还本金累计额）×每月利率
     * 每月应还本金=贷款本金÷还款月数
     * 每月应还利息=剩余本金×月利率=(贷款本金-已归还本金累计额)×月利率
     *
     * @param applyExpires  还款期数
     * @param applyMoney    贷款本金
     * @param rate          利率
     * @param start         贷款起始日期
     * @param laId          贷款申请主表id
     * @param applyRateUnit 利率单位
     * @return
     */
    private List<LoanRepaymentPlan> averageCapital(BigDecimal applyMoney, int applyExpires,
                                                   BigDecimal rate, Date start, long laId,
                                                   String applyRateUnit) {
        List<LoanRepaymentPlan> list = new ArrayList<>();
        BigDecimal repaid = new BigDecimal(0);
        //每月应还本金
        BigDecimal principalMoney = new BigDecimal(AverageCapitalUtils.getPerMonthPrincipal(applyMoney.doubleValue(), applyExpires));
        //每月应还 本息
        Map<Integer, Double> mapMonthRepay = AverageCapitalUtils.getPerMonthPrincipalInterest(applyMoney.doubleValue(), rate.doubleValue(), applyExpires);
        Map<Integer, Double> mapInterest = AverageCapitalUtils.getPerMonthInterest(applyMoney.doubleValue(), rate.doubleValue(), applyExpires);
        for (int i = 0; i < applyExpires; i++) {
            LoanRepaymentPlan plan = new LoanRepaymentPlan();
            //计算 期数对应的 还款日期
            Date planDate = changeDateAfter(start, i, applyRateUnit);
            plan.setPlanDate(planDate);
            plan.setLaId(laId);
            plan.setIndexNo(i + 1);
            plan.setPlanInterestMoney(new BigDecimal(mapInterest.get(i + 1)));
            plan.setPlanPrincipalMoney(principalMoney);
            plan.setPlanMoneySum(new BigDecimal(mapMonthRepay.get(i + 1)));
            plan.setPushStatus(1);//默认待推送 状态
            list.add(plan);
        }
        return list;
    }

    /**
     * 按月付息，到期还本
     * 每月还款金额＝本金×存期×利率（月利率）
     * 到期日还款金额=本金+最后一个月的利息。
     *
     * @param applyExpires  还款期数
     * @param applyMoney    贷款本金
     * @param rate          利率
     * @param start         贷款起始日期
     * @param laId          贷款申请主表id
     * @param applyRateUnit 利率单位
     * @return
     */
    private List<LoanRepaymentPlan> monthInterestPayment(BigDecimal applyMoney, int applyExpires,
                                                         BigDecimal rate, Date start, long laId,
                                                         String applyRateUnit) {
        List<LoanRepaymentPlan> list = new ArrayList<>();
        BigDecimal interestMoney = applyMoney.multiply(rate.divide(new BigDecimal(100), 2, BigDecimal.ROUND_HALF_UP)).setScale(0, RoundingMode.HALF_DOWN);
        for (int i = 0; i < applyExpires; i++) {
            LoanRepaymentPlan plan = new LoanRepaymentPlan();
            //计算 期数对应的 还款日期
            Date planDate = changeDateAfter(start, i, applyRateUnit);
            //System.out.println(planDate);
            plan.setPlanDate(planDate);
            plan.setLaId(laId);
            plan.setIndexNo(i + 1);
            plan.setPlanInterestMoney(interestMoney);
            //System.out.println("  利息:" + interestMoney);
            BigDecimal principalMoney = null;
            if (i != applyExpires - 1) {
                principalMoney = new BigDecimal(0);
            } else {
                principalMoney = applyMoney;
            }
            plan.setPlanPrincipalMoney(principalMoney);
            //System.out.println(" 本金:" + principalMoney);
            BigDecimal monthRepay = interestMoney.add(principalMoney).setScale(2, RoundingMode.HALF_DOWN);
            plan.setPlanMoneySum(monthRepay);
            //System.out.println("还款共计:" + monthRepay);
            plan.setPushStatus(1);//默认待推送 状态
            list.add(plan);
        }
        return list;
    }

    /**
     * 一次性还本付息s
     *
     * @param applyExpires 还款期数
     * @param applyMoney   贷款本金
     * @param rate         利率
     * @param end          贷款结束日期
     * @param laId         贷款申请主表id
     * @return
     */
    public List<LoanRepaymentPlan> oneTimeRepay(BigDecimal applyMoney,
                                                BigDecimal rate, int applyExpires,
                                                Date end, long laId) {
        List<LoanRepaymentPlan> list = new ArrayList<>();
        LoanRepaymentPlan plan = new LoanRepaymentPlan();
        //利息
        BigDecimal interestMoney = applyMoney.multiply(rate.divide(new BigDecimal(100), 2, BigDecimal.ROUND_HALF_UP)).multiply(new BigDecimal(applyExpires)).setScale(2, RoundingMode.HALF_DOWN);
        plan.setPlanDate(end);
        plan.setLaId(laId);
        plan.setIndexNo(1);
        plan.setPlanInterestMoney(interestMoney);
        plan.setPlanPrincipalMoney(applyMoney);
        plan.setPlanMoneySum(interestMoney.add(interestMoney));
        plan.setPushStatus(1);//默认待推送 状态
        list.add(plan);
        return list;
    }
}
