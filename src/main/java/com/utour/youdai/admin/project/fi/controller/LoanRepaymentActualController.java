package com.utour.youdai.admin.project.fi.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.utour.youdai.admin.common.utils.poi.ExcelUtil;
import com.utour.youdai.admin.framework.aspectj.lang.annotation.Log;
import com.utour.youdai.admin.framework.aspectj.lang.enums.BusinessType;
import com.utour.youdai.admin.framework.web.controller.BaseController;
import com.utour.youdai.admin.framework.web.domain.AjaxResult;
import com.utour.youdai.admin.framework.web.page.TableDataInfo;
import com.utour.youdai.admin.project.fi.domain.LoanRepaymentActual;
import com.utour.youdai.admin.project.fi.service.ILoanRepaymentActualService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 实际还款Controller
 *
 * @author zh
 * @date 2020-08-29
 */
@RestController
@RequestMapping("/fi/repay/actual")
public class LoanRepaymentActualController extends BaseController {
    private final ILoanRepaymentActualService loanRepaymentActualService;

    public LoanRepaymentActualController(ILoanRepaymentActualService loanRepaymentActualService) {
        this.loanRepaymentActualService = loanRepaymentActualService;
    }

    /**
     * 查询实际还款列表
     */
    @PreAuthorize("@ss.hasPermi('fi:repay:actual:list')")
    @GetMapping("/list")
    public TableDataInfo list(LoanRepaymentActual loanRepaymentActual) {
        startPage();
        List<LoanRepaymentActual> list = loanRepaymentActualService.selectLoanRepaymentActualList(loanRepaymentActual);
        return getDataTable(list);
    }

    /**
     * 导出实际还款列表
     */
    @PreAuthorize("@ss.hasPermi('fi:repay:actual:export')")
    @Log(title = "实际还款", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(LoanRepaymentActual loanRepaymentActual) {
        List<LoanRepaymentActual> list = loanRepaymentActualService.selectLoanRepaymentActualList(loanRepaymentActual);
        ExcelUtil<LoanRepaymentActual> util = new ExcelUtil<LoanRepaymentActual>(LoanRepaymentActual.class);
        return util.exportExcel(list, "actual");
    }

    /**
     * 获取实际还款详细信息
     */
    @PreAuthorize("@ss.hasPermi('fi:repay:actual:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(loanRepaymentActualService.selectLoanRepaymentActualById(id));
    }

    /**
     * 新增实际还款
     */
    @PreAuthorize("@ss.hasPermi('fi:repay:actual:add')")
    @Log(title = "实际还款", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody JSONObject jsonObject) {
        return AjaxResult.success(loanRepaymentActualService.save(jsonObject));
    }

    /**
     * 修改实际还款
     */
    @PreAuthorize("@ss.hasPermi('fi:repay:actual:edit')")
    @Log(title = "实际还款", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody LoanRepaymentActual loanRepaymentActual) {
        return toAjax(loanRepaymentActualService.updateLoanRepaymentActual(loanRepaymentActual));
    }

    /**
     * 删除实际还款
     */
    @PreAuthorize("@ss.hasPermi('fi:repay:actual:remove')")
    @Log(title = "实际还款", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(loanRepaymentActualService.deleteLoanRepaymentActualByIds(ids));
    }

    /**
     * 查询还款计划下的所有实际还款
     *
     * @return
     * @
     */
    @GetMapping(value = "/list/lrpId/{lrpId}")
    public AjaxResult getActualListByPlanLrpId(@PathVariable Long lrpId) {
        List<LoanRepaymentActual> list = loanRepaymentActualService.getActualListByPlanLrpId(lrpId);
        return AjaxResult.success(list);
    }
    @GetMapping(value = "/list/laId/{laId}")
    public AjaxResult selectActualListWithExtensionByPlanLaId(@PathVariable Long laId){
        JSONArray data = loanRepaymentActualService.selectActualListWithExtensionByPlanLaId(laId);
        return AjaxResult.success(data);
    }
}
