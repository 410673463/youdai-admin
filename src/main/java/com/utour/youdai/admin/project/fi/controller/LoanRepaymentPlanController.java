package com.utour.youdai.admin.project.fi.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.utour.youdai.admin.framework.web.controller.BaseController;
import com.utour.youdai.admin.framework.web.domain.AjaxResult;
import com.utour.youdai.admin.project.fi.domain.LoanRepaymentPlan;
import com.utour.youdai.admin.project.fi.service.ILoanRepaymentPlanService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * 还款计划Controller
 *
 * @author zh
 * @date 2020-08-14
 */
@RestController
@RequestMapping("/fi/repay/plan")
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
     * 查询申请下所有还款计划 包含 展期 计划
     * @return
     */
    @GetMapping(value = "/list/all/{laId}")
    public AjaxResult getPlanListWithExtension(@PathVariable Long laId){
        JSONArray data = loanRepaymentPlanService.getPlanListWithExtension(laId);
        return AjaxResult.success(data);
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
    @PutMapping("/pricipalMoney")
    public AjaxResult updatePricipalMoney(@RequestBody JSONObject jsonObject) {
        Long id = jsonObject.getLongValue("updateId");
        BigDecimal newPrincipalMoney = jsonObject.getBigDecimal("newPrincipalMoney");
        return toAjax(loanRepaymentPlanService.updatePricipalMoney(id, newPrincipalMoney));
    }
}
