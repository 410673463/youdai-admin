package com.utour.youdai.admin.project.bo.controller;

import com.utour.youdai.admin.framework.aspectj.lang.annotation.Log;
import com.utour.youdai.admin.framework.aspectj.lang.enums.BusinessType;
import com.utour.youdai.admin.framework.web.controller.BaseController;
import com.utour.youdai.admin.framework.web.domain.AjaxResult;
import com.utour.youdai.admin.project.bo.domain.CorporateInfo;
import com.utour.youdai.admin.project.bo.service.ICorporateInfoService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * 借款人-公司详细信息Controller
 *
 * @author zh
 * @date 2020-08-01
 */
@RestController
@RequestMapping("/bo/corporate/info")
public class CorporateInfoController extends BaseController {
    private final ICorporateInfoService corporateInfoService;

    public CorporateInfoController(ICorporateInfoService corporateInfoService) {
        this.corporateInfoService = corporateInfoService;
    }

    /**
     * 导出借款人-公司详细信息列表
     */

    @Log(title = "借款人-公司详细信息", businessType = BusinessType.EXPORT)
    @GetMapping("/getInfoByBoId/{boId}")
    public AjaxResult getInfoByBoId(@PathVariable("boId")Long boId) {
        return AjaxResult.success(corporateInfoService.getInfoByBoId(boId));
    }

    /**
     * 获取借款人-公司详细信息详细信息
     */

    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(corporateInfoService.selectCorporateInfoById(id));
    }

    /**
     * 新增借款人-公司详细信息
     */
    @Log(title = "借款人-公司详细信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CorporateInfo corporateInfo) {
        return toAjax(corporateInfoService.insertCorporateInfo(corporateInfo));
    }

    /**
     * 修改借款人-公司详细信息
     */
    @PreAuthorize("@ss.hasPermi('com:info:edit')")
    @Log(title = "借款人-公司详细信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CorporateInfo corporateInfo) {
        return toAjax(corporateInfoService.updateCorporateInfo(corporateInfo));
    }

    /**
     * 删除借款人-公司详细信息
     */
    @PreAuthorize("@ss.hasPermi('com:info:remove')")
    @Log(title = "借款人-公司详细信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(corporateInfoService.deleteCorporateInfoByIds(ids));
    }
}
