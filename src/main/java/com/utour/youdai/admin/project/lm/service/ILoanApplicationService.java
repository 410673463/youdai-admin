package com.utour.youdai.admin.project.lm.service;

import com.alibaba.fastjson.JSONArray;
import com.utour.youdai.admin.project.lm.domain.LoanApplication;

import java.util.List;

/**
 * 贷款管理-贷款申请Service接口
 *
 * @author zh
 * @date 2020-08-02
 */
public interface ILoanApplicationService {
    /**
     * 查询贷款管理-贷款申请
     *
     * @param id 贷款管理-贷款申请ID
     * @return 贷款管理-贷款申请
     */
    public LoanApplication selectLoanApplicationById(Long id);

    /**
     * 查询贷款管理-贷款申请列表
     *
     * @param loanApplication 贷款管理-贷款申请
     * @return 贷款管理-贷款申请集合
     */
    public List<LoanApplication> selectLoanApplicationList(LoanApplication loanApplication);

    /**
     * 新增贷款管理-贷款申请
     *
     * @param loanApplication 贷款管理-贷款申请
     * @return 结果
     */
    public int insertLoanApplication(LoanApplication loanApplication);

    /**
     * 修改贷款管理-贷款申请
     *
     * @param loanApplication 贷款管理-贷款申请
     * @return 结果
     */
    public int updateLoanApplication(LoanApplication loanApplication);

    /**
     * 批量删除贷款管理-贷款申请
     *
     * @param ids 需要删除的贷款管理-贷款申请ID
     * @return 结果
     */
    public int deleteLoanApplicationByIds(Long[] ids);

    /**
     * 删除贷款管理-贷款申请信息
     *
     * @param id 贷款管理-贷款申请ID
     * @return 结果
     */
    public int deleteLoanApplicationById(Long id);

    /**
     * 更新申请状态，创建审核表数据
     * @param status
     * @param ids
     * @return
     */
    int updateApplyStatus(int status, JSONArray ids);
}
