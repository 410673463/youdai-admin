package com.utour.youdai.admin.project.dp.controller;

import com.utour.youdai.admin.framework.web.controller.BaseController;
import com.utour.youdai.admin.framework.web.domain.AjaxResult;
import com.utour.youdai.admin.project.dp.service.IDataPushService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.web.bind.annotation.*;

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
        String resultCode = dataPushService.pushApplicationData(laId);
        if (resultCode.equals("0")) {
            return AjaxResult.success();
        } else {
            return AjaxResult.error(resultCode);
        }
    }

    @DeleteMapping("/application/{laId}")
    public AjaxResult deleteApplicationData(@PathVariable Long laId) {
        String resultCode = dataPushService.deleteApplicationData(laId);
        if (resultCode.equals("0")) {
            return AjaxResult.success();
        } else {
            return AjaxResult.error(resultCode);
        }
    }

    @PostMapping("/repayActual")
    public AjaxResult pushRepayActual( Long lraId){
        String resultCode = dataPushService.pushRepayActual(lraId);
        if (resultCode.equals("0")) {
            return AjaxResult.success();
        } else {
            return AjaxResult.error(resultCode);
        }
    }
}
