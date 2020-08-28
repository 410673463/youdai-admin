package com.utour.youdai.admin.project.dp.controller;

import com.utour.youdai.admin.common.utils.poi.ExcelUtil;
import com.utour.youdai.admin.framework.aspectj.lang.annotation.Log;
import com.utour.youdai.admin.framework.aspectj.lang.enums.BusinessType;
import com.utour.youdai.admin.framework.web.controller.BaseController;
import com.utour.youdai.admin.framework.web.domain.AjaxResult;
import com.utour.youdai.admin.framework.web.page.TableDataInfo;
import com.utour.youdai.admin.project.dp.domain.DataPushRecords;
import com.utour.youdai.admin.project.dp.service.IDataPushRecordsService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 数据推送记录Controller
 *
 * @author zh
 * @date 2020-08-25
 */
@RestController
@RequestMapping("/dp/records")
public class DataPushRecordsController extends BaseController {
    private final IDataPushRecordsService dataPushRecordsService;
    public DataPushRecordsController(IDataPushRecordsService dataPushRecordsService) {
        this.dataPushRecordsService = dataPushRecordsService;
    }


    /**
     * 查询数据推送记录列表
     */
    @PreAuthorize("@ss.hasPermi('com:records:list')")
    @GetMapping("/list")
    public TableDataInfo list(DataPushRecords dataPushRecords) {
        startPage();
        List<DataPushRecords> list = dataPushRecordsService.selectDataPushRecordsList(dataPushRecords);
        return getDataTable(list);
    }

    /**
     * 导出数据推送记录列表
     */
    @PreAuthorize("@ss.hasPermi('com:records:export')")
    @Log(title = "数据推送记录", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(DataPushRecords dataPushRecords) {
        List<DataPushRecords> list = dataPushRecordsService.selectDataPushRecordsList(dataPushRecords);
        ExcelUtil<DataPushRecords> util = new ExcelUtil<DataPushRecords>(DataPushRecords.class);
        return util.exportExcel(list, "records");
    }

    /**
     * 获取数据推送记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('com:records:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(dataPushRecordsService.selectDataPushRecordsById(id));
    }
}
