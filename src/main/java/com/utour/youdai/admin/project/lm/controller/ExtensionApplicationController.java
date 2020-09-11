package com.utour.youdai.admin.project.lm.controller;


import com.utour.youdai.admin.framework.web.controller.BaseController;
import com.utour.youdai.admin.framework.web.page.TableDataInfo;
import com.utour.youdai.admin.project.lm.domain.LoanApplication;
import com.utour.youdai.admin.project.lm.service.ILoanApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 延期 贷款
 */
@RestController
@RequestMapping("/lm/extension")
public class ExtensionApplicationController extends BaseController {
    @Autowired
    private ILoanApplicationService loanApplicationService;

    /**
     * 查询贷款管理-贷款申请列表
     */
    @PreAuthorize("@ss.hasPermi('lm:extension:list')")
    @GetMapping("/list")
    public TableDataInfo list(LoanApplication loanApplication) {
        startPage();
        List<LoanApplication> list = loanApplicationService.selectExtensionLoanApplicationList(loanApplication);
        return getDataTable(list);
    }

}
