package com.utour.youdai.admin.project.bo.controller;

import java.util.List;

import com.utour.youdai.admin.project.bo.domain.Contacts;
import com.utour.youdai.admin.project.bo.service.IContactsService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.utour.youdai.admin.framework.aspectj.lang.annotation.Log;
import com.utour.youdai.admin.framework.aspectj.lang.enums.BusinessType;

import com.utour.youdai.admin.framework.web.controller.BaseController;
import com.utour.youdai.admin.framework.web.domain.AjaxResult;
import com.utour.youdai.admin.common.utils.poi.ExcelUtil;
import com.utour.youdai.admin.framework.web.page.TableDataInfo;

/**
 * 借款人-联系人信息Controller
 *
 * @author zh
 * @date 2020-07-29
 */
@RestController
@RequestMapping("/com/contacts")
public class ContactsController extends BaseController {
    private final IContactsService contactsService;

    public ContactsController(IContactsService contactsService) {
        this.contactsService = contactsService;
    }

    /**
     * 查询借款人-联系人信息列表
     */
    @GetMapping("/list")
    public TableDataInfo list(Contacts contacts) {
        startPage();
        List<Contacts> list = contactsService.selectContactsList(contacts);
        return getDataTable(list);
    }

    /**
     * 导出借款人-联系人信息列表
     */
    @Log(title = "借款人-联系人信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(Contacts contacts) {
        List<Contacts> list = contactsService.selectContactsList(contacts);
        ExcelUtil<Contacts> util = new ExcelUtil<Contacts>(Contacts.class);
        return util.exportExcel(list, "contacts");
    }

    /**
     * 获取借款人-联系人信息详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(contactsService.selectContactsById(id));
    }

    /**
     * 新增借款人-联系人信息
     */
    @Log(title = "借款人-联系人信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Contacts contacts) {
        return toAjax(contactsService.insertContacts(contacts));
    }

    /**
     * 修改借款人-联系人信息
     */
    @Log(title = "借款人-联系人信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Contacts contacts) {
        return toAjax(contactsService.updateContacts(contacts));
    }

    /**
     * 删除借款人-联系人信息
     */
    @Log(title = "借款人-联系人信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(contactsService.deleteContactsByIds(ids));
    }
}
