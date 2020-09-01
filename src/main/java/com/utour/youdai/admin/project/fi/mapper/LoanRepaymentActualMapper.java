package com.utour.youdai.admin.project.fi.mapper;

import com.utour.youdai.admin.project.fi.domain.LoanRepaymentActual;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 实际还款Mapper接口
 *
 * @author zh
 * @date 2020-08-29
 */
@Mapper
@Repository
public interface LoanRepaymentActualMapper {
    /**
     * 查询实际还款
     *
     * @param id 实际还款ID
     * @return 实际还款
     */
    public LoanRepaymentActual selectLoanRepaymentActualById(Long id);
    /**
     * 查询实际还款包含 申请字段
     *
     * @param id 实际还款ID
     * @return 实际还款
     */
    public LoanRepaymentActual selectRepayActualWithApplyInfoById(Long id);

    /**
     * 查询实际还款列表
     *
     * @param loanRepaymentActual 实际还款
     * @return 实际还款集合
     */
    public List<LoanRepaymentActual> selectLoanRepaymentActualList(LoanRepaymentActual loanRepaymentActual);

    /**
     * 新增实际还款
     *
     * @param loanRepaymentActual 实际还款
     * @return 结果
     */
    public int insertLoanRepaymentActual(LoanRepaymentActual loanRepaymentActual);

    /**
     * 修改实际还款
     *
     * @param loanRepaymentActual 实际还款
     * @return 结果
     */
    public int updateLoanRepaymentActual(LoanRepaymentActual loanRepaymentActual);

    /**
     * 删除实际还款
     *
     * @param id 实际还款ID
     * @return 结果
     */
    public int deleteLoanRepaymentActualById(Long id);

    /**
     * 批量删除实际还款
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteLoanRepaymentActualByIds(Long[] ids);

    /**
     * 查询实际还款列表，返回结果集包含 申请字段
     * @param loanRepaymentActual
     * @return
     */
    public List<LoanRepaymentActual> selectRepayActualListWithApplyInfo(LoanRepaymentActual loanRepaymentActual);
}
