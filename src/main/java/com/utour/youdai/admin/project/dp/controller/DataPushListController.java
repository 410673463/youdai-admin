package com.utour.youdai.admin.project.dp.controller;


import com.alibaba.fastjson.JSONObject;
import com.utour.youdai.admin.framework.web.controller.BaseController;
import com.utour.youdai.admin.framework.web.domain.AjaxResult;
import com.utour.youdai.admin.framework.web.page.TableDataInfo;
import com.utour.youdai.admin.project.dp.service.IDataPushRecordsService;
import com.utour.youdai.admin.project.lm.domain.LoanApplication;
import com.utour.youdai.admin.project.lm.service.ILoanApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 数据推送 所有相关查询 Controller
 */
@RestController
@RequestMapping("/dp/data")
public class DataPushListController extends BaseController {
    @Autowired
    private ILoanApplicationService loanApplicationService;
    @Autowired
    private IDataPushRecordsService dataPushRecordsService;

    /**
     * 查询贷款申请 推送列表
     *
     * @param loanApplication
     * @return
     */
    @GetMapping("/loanApplicationList")
    public TableDataInfo getLoanApplicationPushList(LoanApplication loanApplication) {
        startPage();
        List<LoanApplication> list = loanApplicationService.getLoanApplicationPushList(loanApplication);
        return getDataTable(list);
    }

    @RequestMapping(value = "/records", method = RequestMethod.GET)
    public AjaxResult getRecordList(@RequestParam(value = "primaryId", required = true) Long primaryId,
                                    @RequestParam(value = "dataTable", required = true) String dataTable,
                                    @RequestParam(value = "path", required = false) String path,
                                    @RequestParam(value = "method", required = false) String method) {
        List<LoanApplication> list = dataPushRecordsService.getRecordList(primaryId, dataTable, path, method);
        return AjaxResult.success(list);
    }
}
