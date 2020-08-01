package com.utour.youdai.admin.project.bo.controller;


import com.utour.youdai.admin.framework.aspectj.lang.annotation.Log;
import com.utour.youdai.admin.framework.aspectj.lang.enums.BusinessType;
import com.utour.youdai.admin.framework.web.controller.BaseController;
import com.utour.youdai.admin.framework.web.domain.AjaxResult;
import com.utour.youdai.admin.project.bo.domain.PersonalInfo;
import com.utour.youdai.admin.project.bo.service.IPersonalInfoService;
import org.springframework.web.bind.annotation.*;

/**
 * 借款人-个人信息Controller
 *
 * @author zh
 * @date 2020-07-31
 */
@RestController
@RequestMapping("/bo/person/info")
public class PersonalInfoController extends BaseController {
    private final IPersonalInfoService personalInfoService;

    public PersonalInfoController(IPersonalInfoService personalInfoService) {
        this.personalInfoService = personalInfoService;
    }


    /**
     * 获取借款人-个人信息详细信息
     */
    @GetMapping(value = "/getInfoByBoId/{boId}")
    public AjaxResult getInfoByBoId(@PathVariable("boId") Long boId) {
        return AjaxResult.success(personalInfoService.getInfoByBoId(boId));
    }

    /**
     * 新增借款人-个人信息
     */
    @Log(title = "借款人-个人信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PersonalInfo personalInfo) {
        return toAjax(personalInfoService.insertPersonalInfo(personalInfo));
    }

    /**
     * 修改借款人-个人信息
     */
    @Log(title = "借款人-个人信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PersonalInfo personalInfo) {
        return toAjax(personalInfoService.updatePersonalInfo(personalInfo));
    }
}
