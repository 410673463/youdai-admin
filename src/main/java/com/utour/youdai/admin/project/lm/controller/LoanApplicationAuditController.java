package com.utour.youdai.admin.project.lm.controller;

import com.alibaba.fastjson.JSONObject;
import com.utour.youdai.admin.framework.aspectj.lang.annotation.Log;
import com.utour.youdai.admin.framework.aspectj.lang.enums.BusinessType;
import com.utour.youdai.admin.framework.web.controller.BaseController;
import com.utour.youdai.admin.framework.web.domain.AjaxResult;
import com.utour.youdai.admin.framework.web.page.TableDataInfo;
import com.utour.youdai.admin.project.lm.domain.LoanApplicationAudit;
import com.utour.youdai.admin.project.lm.service.ILoanApplicationAuditService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 贷款申请-审核(记录审核情况，一级审批完成后，创建下一级审批申请的数据，直到申请的状态为 财务审核)Controller
 *
 * @author zh
 * @date 2020-08-08
 */
@RestController
@RequestMapping("/lm/application/audit")
public class LoanApplicationAuditController extends BaseController {
    private final ILoanApplicationAuditService loanApplicationAuditService;

    public LoanApplicationAuditController(ILoanApplicationAuditService loanApplicationAuditService) {
        this.loanApplicationAuditService = loanApplicationAuditService;
    }

    /**
     * 查询贷款申请-审核(记录审核情况，一级审批完成后，创建下一级审批申请的数据，直到申请的状态为 财务审核)列表
     */
    @PreAuthorize("@ss.hasPermi('lm:application:audit:list')")
    @GetMapping("/list")
    public TableDataInfo list(LoanApplicationAudit loanApplicationAudit) {
        startPage();
        List<LoanApplicationAudit> list = loanApplicationAuditService.selectLoanApplicationAuditList(loanApplicationAudit);
        return getDataTable(list);
    }


    /**
     * 获取贷款申请-审核(记录审核情况，一级审批完成后，创建下一级审批申请的数据，直到申请的状态为 财务审核)详细信息
     */
    @PreAuthorize("@ss.hasPermi('lm:application:audit:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        List<LoanApplicationAudit> list = loanApplicationAuditService.selectAuditByLaId(id);
        return AjaxResult.success(list);
    }

    /**
     * 新增贷款申请-审核(记录审核情况，一级审批完成后，创建下一级审批申请的数据，直到申请的状态为 财务审核)
     */
    @PreAuthorize("@ss.hasPermi('lm:application:audit:add')")
    @Log(title = "贷款申请-审核(记录审核情况，一级审批完成后，创建下一级审批申请的数据，直到申请的状态为 财务审核)", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody JSONObject jsonObject) {
        return toAjax(loanApplicationAuditService.insertLoanApplicationAudit(jsonObject));
    }

    /**
     * 修改贷款申请-审核(记录审核情况，一级审批完成后，创建下一级审批申请的数据，直到申请的状态为 财务审核)
     */
    @PreAuthorize("@ss.hasPermi('lm:application:audit:edit')")
    @Log(title = "贷款申请-审核(记录审核情况，一级审批完成后，创建下一级审批申请的数据，直到申请的状态为 财务审核)", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody LoanApplicationAudit loanApplicationAudit) {
        return toAjax(loanApplicationAuditService.updateLoanApplicationAudit(loanApplicationAudit));
    }

    /**
     * 删除贷款申请-审核(记录审核情况，一级审批完成后，创建下一级审批申请的数据，直到申请的状态为 财务审核)
     */
    @PreAuthorize("@ss.hasPermi('lm:application:audit:remove')")
    @Log(title = "贷款申请-审核(记录审核情况，一级审批完成后，创建下一级审批申请的数据，直到申请的状态为 财务审核)", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(loanApplicationAuditService.deleteLoanApplicationAuditByIds(ids));
    }
}
