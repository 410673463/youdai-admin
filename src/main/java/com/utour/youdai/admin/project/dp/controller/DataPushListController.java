package com.utour.youdai.admin.project.dp.controller;


import com.utour.youdai.admin.framework.web.controller.BaseController;
import com.utour.youdai.admin.framework.web.page.TableDataInfo;
import com.utour.youdai.admin.project.lm.domain.LoanApplication;
import com.utour.youdai.admin.project.lm.service.ILoanApplicationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 数据推送 所有相关查询 Controller
 */
@RestController
@RequestMapping("/dp/data")
public class DataPushListController  extends BaseController {

    private final ILoanApplicationService loanApplicationService;

    public DataPushListController(ILoanApplicationService loanApplicationService) {
        this.loanApplicationService = loanApplicationService;
    }

    /**
     * 查询贷款申请 推送列表
     * @param loanApplication
     * @return
     */
    @GetMapping("/loanApplicationList")
    public TableDataInfo getLoanApplicationPushList(LoanApplication loanApplication){
        startPage();
        List<LoanApplication> list = loanApplicationService.getLoanApplicationPushList(loanApplication);
        return getDataTable(list);
    }
}
