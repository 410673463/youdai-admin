package com.utour.youdai.admin.project.dp.controller;

import com.utour.youdai.admin.framework.web.controller.BaseController;
import com.utour.youdai.admin.framework.web.domain.AjaxResult;
import com.utour.youdai.admin.project.dp.service.IDataPushService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 数据推送 Controller
 */
@RestController
@RequestMapping("/dp/push/")
public class DataPushController extends BaseController {
    private final IDataPushService dataPushService;

    public DataPushController(IDataPushService dataPushService) {
        this.dataPushService = dataPushService;
    }

    /**
     * 推送 贷款申请 数据
     *
     * @return
     */
    @PostMapping("/application")
    public AjaxResult pushApplicationData(Long laId) {
        dataPushService.pushApplicationData(laId);
        return toAjax(2);
    }

}
