package com.utour.youdai.admin.project.bo.controller;

import com.utour.youdai.admin.common.utils.poi.ExcelUtil;
import com.utour.youdai.admin.framework.aspectj.lang.annotation.Log;
import com.utour.youdai.admin.framework.aspectj.lang.enums.BusinessType;
import com.utour.youdai.admin.framework.web.controller.BaseController;
import com.utour.youdai.admin.framework.web.domain.AjaxResult;
import com.utour.youdai.admin.framework.web.page.TableDataInfo;
import com.utour.youdai.admin.project.bo.domain.BankAccount;
import com.utour.youdai.admin.project.bo.service.IBankAccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 借款人-银行账户信息Controller
 *
 * @author zh
 * @date 2020-08-01
 */
@RestController
@RequestMapping("/bo/account")
public class BankAccountController extends BaseController {
    private final IBankAccountService bankAccountService;

    public BankAccountController(IBankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    /**
     * 查询借款人-银行账户信息列表
     */
    @GetMapping("/list")
    public TableDataInfo list(BankAccount bankAccount) {
        startPage();
        List<BankAccount> list = bankAccountService.selectBankAccountList(bankAccount);
        return getDataTable(list);
    }

    /**
     * 查询借款人-银行账户信息列表
     */
    @GetMapping("/accounts/{boId}")
    public AjaxResult getAccountsByBoId(@PathVariable Long boId) {
        List<BankAccount> list = bankAccountService.getAccountsByBoId(boId);
        return AjaxResult.success(list);
    }


    /**
     * 导出借款人-银行账户信息列表
     */
    @Log(title = "借款人-银行账户信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BankAccount bankAccount) {
        List<BankAccount> list = bankAccountService.selectBankAccountList(bankAccount);
        ExcelUtil<BankAccount> util = new ExcelUtil<BankAccount>(BankAccount.class);
        return util.exportExcel(list, "account");
    }

    /**
     * 获取借款人-银行账户信息详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(bankAccountService.selectBankAccountById(id));
    }

    /**
     * 新增借款人-银行账户信息
     */
    @Log(title = "借款人-银行账户信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BankAccount bankAccount) {
        return toAjax(bankAccountService.insertBankAccount(bankAccount));
    }

    /**
     * 修改借款人-银行账户信息
     */
    @Log(title = "借款人-银行账户信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BankAccount bankAccount) {
        return toAjax(bankAccountService.updateBankAccount(bankAccount));
    }

    /**
     * 删除借款人-银行账户信息
     */
    @Log(title = "借款人-银行账户信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(bankAccountService.deleteBankAccountByIds(ids));
    }
}
