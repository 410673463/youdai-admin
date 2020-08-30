package com.utour.youdai.admin.project.fi.service;

import com.utour.youdai.admin.project.lm.domain.LoanApplication;
import com.utour.youdai.admin.project.fi.domain.LoanRepaymentPlan;

import java.math.BigDecimal;
import java.util.List;


/**
 * 还款计划Service接口
 *
 * @author zh
 * @date 2020-08-14
 */
public interface ILoanRepaymentPlanService {
    /**
     * 查询还款计划
     *
     * @param id 还款计划ID
     * @return 还款计划
     */
    public LoanRepaymentPlan selectLoanRepaymentPlanById(Long id);

    /**
     * 查询还款计划列表
     *
     * @param loanRepaymentPlan 还款计划
     * @return 还款计划集合
     */
    public List<LoanRepaymentPlan> selectLoanRepaymentPlanList(LoanRepaymentPlan loanRepaymentPlan);

    /**
     * 新增还款计划
     *
     * @param loanRepaymentPlan 还款计划
     * @return 结果
     */
    public int insertLoanRepaymentPlan(LoanRepaymentPlan loanRepaymentPlan);

    /**
     * 修改还款计划
     *
     * @param loanRepaymentPlan 还款计划
     * @return 结果
     */
    public int updateLoanRepaymentPlan(LoanRepaymentPlan loanRepaymentPlan);

    /**
     * 批量删除还款计划
     *
     * @param ids 需要删除的还款计划ID
     * @return 结果
     */
    public int deleteLoanRepaymentPlanByIds(Long[] ids);

    /**
     * 删除还款计划信息
     *
     * @param id 还款计划ID
     * @return 结果
     */
    public int deleteLoanRepaymentPlanById(Long id);

    /**
     * 根据贷款申请laID删除还款计划
     * @param laId
     * @return
     */
    int deletePlanByLaId(Long laId);

    /**
     * 贷款申请id查询还款计划
     * @param laId
     * @return
     */
    List<LoanRepaymentPlan> getPlanList(Long laId);

    /**
     * 贷款申请创建还款计划
     * @param apply
     * @return
     */
    int createRepayPlan(LoanApplication apply);

    /**
     * 调整本金
     * @param id
     * @param newPrincipalMoney
     * @return
     */
    int updatePricipalMoney(Long id, BigDecimal newPrincipalMoney);
}
