package com.utour.youdai.admin.project.lm.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.utour.youdai.admin.framework.aspectj.lang.annotation.Excel;

import java.util.Date;

/**
 * 展期申请中间对象 lm_extension_apply
 *
 * @author zh
 * @date 2020-09-08
 */
public class ExtensionApply {
    private static final long serialVersionUID = 1L;

    /**
     * $column.columnComment
     */
    private Long id;

    /**
     * 展期申请id
     */
    @Excel(name = "展期申请id")
    private Long extensionId;

    /**
     * 展期申请CODE
     */
    @Excel(name = "展期申请CODE")
    private String extensionCode;

    /**
     * 原申请id
     */
    @Excel(name = "原申请id")
    private Long applyId;

    /**
     * 原申请code
     */
    @Excel(name = "原申请code")
    private String applyCode;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setExtensionId(Long extensionId) {
        this.extensionId = extensionId;
    }

    public Long getExtensionId() {
        return extensionId;
    }

    public void setExtensionCode(String extensionCode) {
        this.extensionCode = extensionCode;
    }

    public String getExtensionCode() {
        return extensionCode;
    }

    public void setApplyId(Long applyId) {
        this.applyId = applyId;
    }

    public Long getApplyId() {
        return applyId;
    }

    public void setApplyCode(String applyCode) {
        this.applyCode = applyCode;
    }

    public String getApplyCode() {
        return applyCode;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
