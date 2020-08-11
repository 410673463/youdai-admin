package com.utour.youdai.admin.project.lm.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.utour.youdai.admin.framework.aspectj.lang.annotation.Excel;
import com.utour.youdai.admin.framework.web.domain.BaseEntity;

import java.util.Date;

/**
 * 贷款申请-审核(记录审核情况，一级审批完成后，创建下一级审批申请的数据，直到申请的状态为 财务审核)对象 lm_loan_application_audit
 *
 * @author zh
 * @date 2020-08-08
 */
public class LoanApplicationAudit extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * $column.columnComment
     */
    private Long id;

    /**
     * 贷款申请主表ID
     */
    @Excel(name = "贷款申请主表ID")
    private Long laId;

    /**
     * 审核人员ID
     */
    @Excel(name = "审核人员ID")
    private Long auditUserId;

    /**
     * 审核人员姓名
     */
    @Excel(name = "审核人员姓名")
    private String auditUserName;

    /**
     * 上一级审核人员ID
     */
    @Excel(name = "上一级审核人员ID")
    private Long superUserId;

    /**
     * 上一级审核人员姓名
     */
    @Excel(name = "上一级审核人员姓名")
    private String superUserName;

    /**
     * 审核意见
     */
    @Excel(name = "审核意见")
    private String auditOpinion;

    /**
     * 审核状态：1通过、-1不通过 0 待审核
     */
    @Excel(name = "审核状态：1通过、-1不通过 0 待审核")
    private Integer auditStatus;

    /**
     * 审核时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @Excel(name = "审核时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm ")
    private Date auditTime;

    /**
     * 审核记录创建时的申请状态
     */
    @Excel(name = "审核序号")
    private Integer auditSort;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Long getLaId() {
        return laId;
    }

    public void setLaId(Long laId) {
        this.laId = laId;
    }

    public void setAuditUserId(Long auditUserId) {
        this.auditUserId = auditUserId;
    }

    public Long getAuditUserId() {
        return auditUserId;
    }

    public void setAuditUserName(String auditUserName) {
        this.auditUserName = auditUserName;
    }

    public String getAuditUserName() {
        return auditUserName;
    }

    public void setSuperUserId(Long superUserId) {
        this.superUserId = superUserId;
    }

    public Long getSuperUserId() {
        return superUserId;
    }

    public void setSuperUserName(String superUserName) {
        this.superUserName = superUserName;
    }

    public String getSuperUserName() {
        return superUserName;
    }

    public void setAuditOpinion(String auditOpinion) {
        this.auditOpinion = auditOpinion;
    }

    public String getAuditOpinion() {
        return auditOpinion;
    }

    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

    public Integer getAuditStatus() {
        return auditStatus;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    public Date getAuditTime() {
        return auditTime;
    }

    public Integer getAuditSort() {
        return auditSort;
    }

    public void setAuditSort(Integer auditSort) {
        this.auditSort = auditSort;
    }
}
