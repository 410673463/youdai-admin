package com.utour.youdai.admin.project.fi.controller;

import java.util.List;

import com.utour.youdai.admin.project.fi.domain.LoanRecords;
import com.utour.youdai.admin.project.fi.service.ILoanRecordsService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
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
 * 放款记录Controller
 *
 * @author zh
 * @date 2020-09-02
 */
@RestController
@RequestMapping("/fi/loan/records")
public class LoanRecordsController extends BaseController {
    @Autowired
    private ILoanRecordsService loanRecordsService;

    /**
     * 查询放款记录列表
     */
    @PreAuthorize("@ss.hasPermi('com:records:list')")
    @GetMapping("/list")
    public TableDataInfo list(LoanRecords loanRecords) {
        startPage();
        List<LoanRecords> list = loanRecordsService.selectLoanRecordsList(loanRecords);
        return getDataTable(list);
    }

    /**
     * 导出放款记录列表
     */
    @PreAuthorize("@ss.hasPermi('com:records:export')")
    @Log(title = "放款记录", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(LoanRecords loanRecords) {
        List<LoanRecords> list = loanRecordsService.selectLoanRecordsList(loanRecords);
        ExcelUtil<LoanRecords> util = new ExcelUtil<LoanRecords>(LoanRecords.class);
        return util.exportExcel(list, "records");
    }

    /**
     * 获取放款记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('com:records:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(loanRecordsService.selectLoanRecordsById(id));
    }

    /**
     * 新增放款记录
     */
    @PreAuthorize("@ss.hasPermi('com:records:add')")
    @Log(title = "放款记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody LoanRecords loanRecords) {
        return AjaxResult.success(loanRecordsService.insertLoanRecords(loanRecords));
    }

    /**
     * 修改放款记录
     */
    @PreAuthorize("@ss.hasPermi('com:records:edit')")
    @Log(title = "放款记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody LoanRecords loanRecords) {
        return toAjax(loanRecordsService.updateLoanRecords(loanRecords));
    }

    /**
     * 删除放款记录
     */
    @PreAuthorize("@ss.hasPermi('com:records:remove')")
    @Log(title = "放款记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(loanRecordsService.deleteLoanRecordsByIds(ids));
    }
}
