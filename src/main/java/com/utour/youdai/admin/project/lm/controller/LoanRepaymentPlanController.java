package com.utour.youdai.admin.project.lm.controller;

import com.utour.youdai.admin.framework.web.controller.BaseController;
import com.utour.youdai.admin.framework.web.domain.AjaxResult;
import com.utour.youdai.admin.project.lm.domain.LoanRepaymentPlan;
import com.utour.youdai.admin.project.lm.service.ILoanRepaymentPlanService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 还款计划Controller
 *
 * @author zh
 * @date 2020-08-14
 */
@RestController
@RequestMapping("/lm/repayPlan")
public class LoanRepaymentPlanController extends BaseController {
    private final ILoanRepaymentPlanService loanRepaymentPlanService;

    public LoanRepaymentPlanController(ILoanRepaymentPlanService loanRepaymentPlanService) {
        this.loanRepaymentPlanService = loanRepaymentPlanService;
    }


    /**
     * 查询还款计划
     */
    @GetMapping(value = "/list/{laId}")
    public AjaxResult getPlanList(@PathVariable("laId") Long laId) {
        List<LoanRepaymentPlan> list = loanRepaymentPlanService.getPlanList(laId);
        return AjaxResult.success(list);
    }

    /**
     * 新增还款计划
     */
   /* @PreAuthorize("@ss.hasPermi('lm:repayPlan:add')")
    @Log(title = "还款计划", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody LoanRepaymentPlan loanRepaymentPlan) {
        return toAjax(loanRepaymentPlanService.insertLoanRepaymentPlan(loanRepaymentPlan));
    }*/

    /**
     * 修改还款计划
     */
    /*@PreAuthorize("@ss.hasPermi('lm:repayPlan:edit')")
    @Log(title = "还款计划", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody LoanRepaymentPlan loanRepaymentPlan) {
        return toAjax(loanRepaymentPlanService.updateLoanRepaymentPlan(loanRepaymentPlan));
    }*/

    /**
     * 删除还款计划
     */
   /* @PreAuthorize("@ss.hasPermi('lm:repayPlan:remove')")
    @Log(title = "还款计划", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(loanRepaymentPlanService.deleteLoanRepaymentPlanByIds(ids));
    }*/
}
