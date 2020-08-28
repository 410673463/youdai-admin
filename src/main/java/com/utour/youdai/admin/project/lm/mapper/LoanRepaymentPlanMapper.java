package com.utour.youdai.admin.project.lm.mapper;


import com.utour.youdai.admin.project.lm.domain.LoanRepaymentPlan;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

/**
 * 还款计划Mapper接口
 *
 * @author zh
 * @date 2020-08-14
 */
@Mapper
@Repository
public interface LoanRepaymentPlanMapper {
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
     * 删除还款计划
     *
     * @param id 还款计划ID
     * @return 结果
     */
    public int deleteLoanRepaymentPlanById(Long id);

    /**
     * 批量删除还款计划
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteLoanRepaymentPlanByIds(Long[] ids);

    /**
     * 贷款申请Id查询还款计划
     * @param laId
     * @return
     */
    List<LoanRepaymentPlan> getPlanList(Long laId);

    int deletePlanByLaId(Long laId);

    int batchInsert(List<LoanRepaymentPlan> list);

    int updatePricipalMoney(@Param("id") Long id,@Param("newPrincipalMoney") BigDecimal newPrincipalMoney);
}
