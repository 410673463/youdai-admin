package com.utour.youdai.admin.project.fi.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.utour.youdai.admin.framework.aspectj.lang.annotation.Excel;
import com.utour.youdai.admin.framework.web.domain.BaseEntity;
import com.utour.youdai.admin.project.bo.domain.BankAccount;
import com.utour.youdai.admin.project.bo.domain.Borrower;
import com.utour.youdai.admin.project.lm.domain.LoanApplication;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 放款记录对象 fi_loan_records
 *
 * @author zh
 * @date 2020-09-02
 */
public class LoanRecords extends BaseEntity {
    private static final long serialVersionUID = 1L;


    private Long id;

    /**
     * 贷款申请主表ID
     */
    @Excel(name = "贷款申请主表ID")
    private Long laId;

    /**
     * 借款人ID
     */
    @Excel(name = "借款人ID")
    private Long boId;

    /**
     * 借款人账户ID
     */
    @Excel(name = "借款人账户ID")
    private Long baId;

    /**
     * $column.columnComment
     */
    @Excel(name = "放款金额")
    private BigDecimal money;

    /**
     * 放款时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "放款时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date loanTime;

    /**
     * 贷款开始日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "贷款开始日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startDate;

    /**
     * 贷款结束日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "贷款结束日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endDate;

    /**
     * 财务审核状态
     */
    @Excel(name = "财务审核状态")
    private Integer fiAuditStatus;

    @Excel(name = "财务审核人")
    private String fiAuditUser;


    private Long fiAuditUserId;

    /**
     * $column.columnComment
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "财务审核状态", width = 30, dateFormat = "yyyy-MM-dd")
    private Date fiAuditTime;


    @Excel(name = "出纳审核状态")
    private Integer caAuditStatus;


    @Excel(name = "出纳审核人")
    private String caAuditUser;
    private Long caAuditUserId;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "出纳审核时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date caAuditTime;


    private String createUser;


    private Long createUserId;

    /**
     * 借款人
     */
    @Excel(name = "借款人")
    private String borrowerName;

    /**
     * 放款账户
     */
    @Excel(name = "放款账户")
    private String bankAccountNo;

    /**
     * 开户行
     */
    @Excel(name = "开户行")
    private String bankName;

    /**
     * 申请编码
     */
    @Excel(name = "申请编码")
    private String applyCode;

    private LoanApplication loanApplication;
    private Borrower borrower;
    private BankAccount bankAccount;
    private Integer pushStatus;

    public Integer getPushStatus() {
        return pushStatus;
    }

    public void setPushStatus(Integer pushStatus) {
        this.pushStatus = pushStatus;
    }

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

    public Long getBoId() {
        return boId;
    }

    public void setBoId(Long boId) {
        this.boId = boId;
    }

    public Long getBaId() {
        return baId;
    }

    public void setBaId(Long baId) {
        this.baId = baId;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public void setLoanTime(Date loanTime) {
        this.loanTime = loanTime;
    }

    public Date getLoanTime() {
        return loanTime;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setFiAuditStatus(Integer fiAuditStatus) {
        this.fiAuditStatus = fiAuditStatus;
    }

    public Integer getFiAuditStatus() {
        return fiAuditStatus;
    }

    public void setFiAuditUser(String fiAuditUser) {
        this.fiAuditUser = fiAuditUser;
    }

    public String getFiAuditUser() {
        return fiAuditUser;
    }

    public void setFiAuditUserId(Long fiAuditUserId) {
        this.fiAuditUserId = fiAuditUserId;
    }

    public Long getFiAuditUserId() {
        return fiAuditUserId;
    }

    public void setFiAuditTime(Date fiAuditTime) {
        this.fiAuditTime = fiAuditTime;
    }

    public Date getFiAuditTime() {
        return fiAuditTime;
    }

    public void setCaAuditStatus(Integer caAuditStatus) {
        this.caAuditStatus = caAuditStatus;
    }

    public Integer getCaAuditStatus() {
        return caAuditStatus;
    }

    public void setCaAuditUser(String caAuditUser) {
        this.caAuditUser = caAuditUser;
    }

    public String getCaAuditUser() {
        return caAuditUser;
    }

    public void setCaAuditUserId(Long caAuditUserId) {
        this.caAuditUserId = caAuditUserId;
    }

    public Long getCaAuditUserId() {
        return caAuditUserId;
    }

    public void setCaAuditTime(Date caAuditTime) {
        this.caAuditTime = caAuditTime;
    }

    public Date getCaAuditTime() {
        return caAuditTime;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    public LoanApplication getLoanApplication() {
        return loanApplication;
    }

    public void setLoanApplication(LoanApplication loanApplication) {
        this.loanApplication = loanApplication;
    }

    public Borrower getBorrower() {
        return borrower;
    }

    public void setBorrower(Borrower borrower) {
        this.borrower = borrower;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void setBankAccountNo(String bankAccountNo) {
        this.bankAccountNo = bankAccountNo;
    }

    public String getBankAccountNo() {
        return bankAccountNo;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setApplyCode(String applyCode) {
        this.applyCode = applyCode;
    }

    public String getApplyCode() {
        return applyCode;
    }


}
