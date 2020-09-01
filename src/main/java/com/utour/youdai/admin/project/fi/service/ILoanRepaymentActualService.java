package com.utour.youdai.admin.project.fi.service;


import com.alibaba.fastjson.JSONObject;
import com.utour.youdai.admin.project.fi.domain.LoanRepaymentActual;

import java.util.List;

/**
 * 实际还款Service接口
 *
 * @author zh
 * @date 2020-08-29
 */
public interface ILoanRepaymentActualService {
    /**
     * 查询实际还款
     *
     * @param id 实际还款ID
     * @return 实际还款
     */
    public LoanRepaymentActual selectLoanRepaymentActualById(Long id);

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
     * 批量删除实际还款
     *
     * @param ids 需要删除的实际还款ID
     * @return 结果
     */
    public int deleteLoanRepaymentActualByIds(Long[] ids);

    /**
     * 删除实际还款信息
     *
     * @param id 实际还款ID
     * @return 结果
     */
    public int deleteLoanRepaymentActualById(Long id);

    Long save(JSONObject jsonObject);
}
