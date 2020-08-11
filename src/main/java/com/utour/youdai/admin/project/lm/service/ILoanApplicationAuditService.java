package com.utour.youdai.admin.project.lm.service;

import com.alibaba.fastjson.JSONObject;
import com.utour.youdai.admin.project.lm.domain.LoanApplicationAudit;

import java.util.List;

/**
 * 贷款申请-审核(记录审核情况，一级审批完成后，创建下一级审批申请的数据，直到申请的状态为 财务审核)Service接口
 *
 * @author zh
 * @date 2020-08-08
 */
public interface ILoanApplicationAuditService {
    /**
     * 查询贷款申请-审核(记录审核情况，一级审批完成后，创建下一级审批申请的数据，直到申请的状态为 财务审核)
     *
     * @param id 贷款申请-审核(记录审核情况，一级审批完成后，创建下一级审批申请的数据，直到申请的状态为 财务审核)ID
     * @return 贷款申请-审核(记录审核情况，一级审批完成后，创建下一级审批申请的数据，直到申请的状态为 财务审核)
     */
    public LoanApplicationAudit selectLoanApplicationAuditById(Long id);

    /**
     * 查询贷款申请-审核(记录审核情况，一级审批完成后，创建下一级审批申请的数据，直到申请的状态为 财务审核)列表
     *
     * @param loanApplicationAudit 贷款申请-审核(记录审核情况，一级审批完成后，创建下一级审批申请的数据，直到申请的状态为 财务审核)
     * @return 贷款申请-审核(记录审核情况，一级审批完成后，创建下一级审批申请的数据，直到申请的状态为 财务审核)集合
     */
    public List<LoanApplicationAudit> selectLoanApplicationAuditList(LoanApplicationAudit loanApplicationAudit);

    /**
     * 新增贷款申请-审核(记录审核情况，一级审批完成后，创建下一级审批申请的数据，直到申请的状态为 财务审核)
     *
     * @param loanApplicationAudit 贷款申请-审核(记录审核情况，一级审批完成后，创建下一级审批申请的数据，直到申请的状态为 财务审核)
     * @return 结果
     */
    public int insertLoanApplicationAudit(JSONObject jsonObject);

    /**
     * 修改贷款申请-审核(记录审核情况，一级审批完成后，创建下一级审批申请的数据，直到申请的状态为 财务审核)
     *
     * @param loanApplicationAudit 贷款申请-审核(记录审核情况，一级审批完成后，创建下一级审批申请的数据，直到申请的状态为 财务审核)
     * @return 结果
     */
    public int updateLoanApplicationAudit(LoanApplicationAudit loanApplicationAudit);

    /**
     * 批量删除贷款申请-审核(记录审核情况，一级审批完成后，创建下一级审批申请的数据，直到申请的状态为 财务审核)
     *
     * @param ids 需要删除的贷款申请-审核(记录审核情况，一级审批完成后，创建下一级审批申请的数据，直到申请的状态为 财务审核)ID
     * @return 结果
     */
    public int deleteLoanApplicationAuditByIds(Long[] ids);

    /**
     * 删除贷款申请-审核(记录审核情况，一级审批完成后，创建下一级审批申请的数据，直到申请的状态为 财务审核)信息
     *
     * @param id 贷款申请-审核(记录审核情况，一级审批完成后，创建下一级审批申请的数据，直到申请的状态为 财务审核)ID
     * @return 结果
     */
    public int deleteLoanApplicationAuditById(Long id);

    /**
     * 根据申请主表查询审核流程
     * @param id
     * @return
     */
    List<LoanApplicationAudit> selectAuditByLaId(Long id);
}
