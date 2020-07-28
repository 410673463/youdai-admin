package com.utour.youdai.admin.project.bo.controller;

import com.utour.youdai.admin.common.utils.poi.ExcelUtil;
import com.utour.youdai.admin.framework.aspectj.lang.annotation.Log;
import com.utour.youdai.admin.framework.aspectj.lang.enums.BusinessType;
import com.utour.youdai.admin.framework.web.controller.BaseController;
import com.utour.youdai.admin.framework.web.domain.AjaxResult;
import com.utour.youdai.admin.framework.web.page.TableDataInfo;
import com.utour.youdai.admin.project.bo.domain.Borrower;
import com.utour.youdai.admin.project.bo.service.IBorrowerService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 借款人-基本信息(主)Controller
 *
 * @author zh
 * @date 2020-07-28
 */
@RestController
@RequestMapping("/bo/borrower")
public class BorrowerController extends BaseController {
    private final IBorrowerService borrowerService;

    public BorrowerController(IBorrowerService borrowerService) {
        this.borrowerService = borrowerService;
    }

    /**
     * 查询借款人-基本信息(主)列表
     */
    @PreAuthorize("@ss.hasPermi('bo:borrower:list')")
    @GetMapping("/list")
    public TableDataInfo list(Borrower borrower) {
        startPage();
        List<Borrower> list = borrowerService.selectBorrowerList(borrower);
        return getDataTable(list);
    }

    /**
     * 导出借款人-基本信息(主)列表
     */
    @PreAuthorize("@ss.hasPermi('bo:borrower:export')")
    @Log(title = "借款人-基本信息(主)", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(Borrower Borrower) {
        List<Borrower> list = borrowerService.selectBorrowerList(Borrower);
        ExcelUtil<Borrower> util = new ExcelUtil<Borrower>(Borrower.class);
        return util.exportExcel(list, "borrower");
    }

    /**
     * 获取借款人-基本信息(主)详细信息
     */
    @PreAuthorize("@ss.hasPermi('bo:borrower:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(borrowerService.selectBorrowerById(id));
    }

    /**
     * 新增借款人-基本信息(主)
     */
    @PreAuthorize("@ss.hasPermi('bo:borrower:add')")
    @Log(title = "借款人-基本信息(主)", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Borrower Borrower) {
        return toAjax(borrowerService.insertBorrower(Borrower));
    }

    /**
     * 修改借款人-基本信息(主)
     */
    @PreAuthorize("@ss.hasPermi('bo:borrower:edit')")
    @Log(title = "借款人-基本信息(主)", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Borrower Borrower) {
        return toAjax(borrowerService.updateBorrower(Borrower));
    }

    /**
     * 删除借款人-基本信息(主)
     */
    @PreAuthorize("@ss.hasPermi('bo:borrower:remove')")
    @Log(title = "借款人-基本信息(主)", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(borrowerService.deleteBorrowerByIds(ids));
    }
}
