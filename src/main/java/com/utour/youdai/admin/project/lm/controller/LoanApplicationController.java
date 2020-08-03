package com.utour.youdai.admin.project.lm.controller;

import java.util.List;

import com.utour.youdai.admin.project.lm.domain.LoanApplication;
import com.utour.youdai.admin.project.lm.service.ILoanApplicationService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.utour.youdai.admin.framework.aspectj.lang.annotation.Log;
import com.utour.youdai.admin.framework.aspectj.lang.enums.BusinessType;

import com.utour.youdai.admin.framework.web.controller.BaseController;
import com.utour.youdai.admin.framework.web.domain.AjaxResult;
import com.utour.youdai.admin.common.utils.poi.ExcelUtil;
import com.utour.youdai.admin.framework.web.page.TableDataInfo;

/**
 * 贷款管理-贷款申请Controller
 *
 * @author zh
 * @date 2020-08-02
 */
@RestController
@RequestMapping("/lm/application")
public class LoanApplicationController extends BaseController {
    private final ILoanApplicationService loanApplicationService;

    public LoanApplicationController(ILoanApplicationService loanApplicationService) {
        this.loanApplicationService = loanApplicationService;
    }

    /**
     * 查询贷款管理-贷款申请列表
     */
    @PreAuthorize("@ss.hasPermi('lm:application:list')")
    @GetMapping("/list")
    public TableDataInfo list(LoanApplication loanApplication) {
        startPage();
        List<LoanApplication> list = loanApplicationService.selectLoanApplicationList(loanApplication);
        return getDataTable(list);
    }

    /**
     * 导出贷款管理-贷款申请列表
     */
    @PreAuthorize("@ss.hasPermi('lm:application:export')")
    @Log(title = "贷款管理-贷款申请", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(LoanApplication loanApplication) {
        List<LoanApplication> list = loanApplicationService.selectLoanApplicationList(loanApplication);
        ExcelUtil<LoanApplication> util = new ExcelUtil<LoanApplication>(LoanApplication.class);
        return util.exportExcel(list, "application");
    }

    /**
     * 获取贷款管理-贷款申请详细信息
     */
    @PreAuthorize("@ss.hasPermi('lm:application:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(loanApplicationService.selectLoanApplicationById(id));
    }

    /**
     * 新增贷款管理-贷款申请
     */
    @PreAuthorize("@ss.hasPermi('lm:application:add')")
    @Log(title = "贷款管理-贷款申请", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody LoanApplication loanApplication) {
        return toAjax(loanApplicationService.insertLoanApplication(loanApplication));
    }

    /**
     * 修改贷款管理-贷款申请
     */
    @PreAuthorize("@ss.hasPermi('lm:application:edit')")
    @Log(title = "贷款管理-贷款申请", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody LoanApplication loanApplication) {
        return toAjax(loanApplicationService.updateLoanApplication(loanApplication));
    }

    /**
     * 删除贷款管理-贷款申请
     */
    @PreAuthorize("@ss.hasPermi('lm:application:remove')")
    @Log(title = "贷款管理-贷款申请", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(loanApplicationService.deleteLoanApplicationByIds(ids));
    }
}
