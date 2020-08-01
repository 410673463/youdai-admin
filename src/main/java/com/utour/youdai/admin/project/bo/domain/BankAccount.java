package com.utour.youdai.admin.project.bo.domain;

import com.utour.youdai.admin.framework.aspectj.lang.annotation.Excel;
import com.utour.youdai.admin.framework.web.domain.BaseEntity;

import java.util.Date;

/**
 * 借款人-银行账户信息对象 bo_bank_account
 *
 * @author zh
 * @date 2020-08-01
 */
public class BankAccount extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * $column.columnComment
     */
    private Long id;

    /**
     * 主表ID
     */
    private Long boId;

    /**
     * 开户行
     */
    @Excel(name = "开户行")
    private String bankName;

    /**
     * 银行账号
     */
    @Excel(name = "银行账号")
    private String account;

    /**
     * 备注
     */
    private String note;

    /**
     * $column.columnComment
     */
    private Date createDate;

    /**
     * $column.columnComment
     */
    private Date modifyDate;

    /**
     * 账户名称
     */
    @Excel(name = "账户名称")
    private String accountName;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setBoId(Long boId) {
        this.boId = boId;
    }

    public Long getBoId() {
        return boId;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAccount() {
        return account;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getNote() {
        return note;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
}
