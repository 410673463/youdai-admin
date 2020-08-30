package com.utour.youdai.admin.project.fi.domain;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.utour.youdai.admin.framework.aspectj.lang.annotation.Excel;
import com.utour.youdai.admin.framework.web.domain.BaseEntity;

/**
 * 实际还款对象 fi_loan_repayment_actual
 *
 * @author zh
 * @date 2020-08-29
 */
public class LoanRepaymentActual extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * $column.columnComment
     */
    private Long id;

    /**
     * 实际还款日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "实际还款日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date actualDate;

    /**
     * 实际还款金额合计
     */
    @Excel(name = "实际还款金额合计")
    private BigDecimal actualMoneySum;

    /**
     * 实际还款还款本金
     */
    @Excel(name = "实际还款还款本金")
    private BigDecimal actualPrincipalMoney;

    /**
     * 实际还款利息
     */
    @Excel(name = "实际还款利息")
    private BigDecimal actualInterestMoney;

    /**
     * 免除金额
     */
    private BigDecimal exemptMoney;

    /**
     * 罚息
     */
    private BigDecimal penaltyInterest;

    /**
     * 违约金
     */
    private BigDecimal penalty;

    /**
     * 服务费
     */
    private BigDecimal serviceCharge;

    /**
     * 其他费用
     */
    private BigDecimal otherCharge;

    /**
     * 还款计划表id
     */
    private Long lrpId;

    /**
     * 贷款申请主表Id
     */
    private Long laId;

    /**
     * 数据推送状态: 0、推送失败 1、待推送 2、推送中 3、推送成功
     */
    @Excel(name = "数据推送状态: 0、推送失败 1、待推送 2、推送中 3、推送成功 ")
    private Integer pushStatus;

    /**
     * 序号、第几期
     */
    @Excel(name = "序号、第几期")
    private Integer indexNo;

    /**
     * 到账状态: 0未到账 1已到账 2 水单 到账
     */
    @Excel(name = "到账状态: 0未到账 1已到账 2 水单 到账 ")
    private Integer moneyStatus;


    private String createUser;


    private Long createUserId;

    private String applicationCode;

    private Date planDate;

    private String productTitle;

    private String borrowerName;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setActualDate(Date actualDate) {
        this.actualDate = actualDate;
    }

    public Date getActualDate() {
        return actualDate;
    }

    public void setActualMoneySum(BigDecimal actualMoneySum) {
        this.actualMoneySum = actualMoneySum;
    }

    public BigDecimal getActualMoneySum() {
        return actualMoneySum;
    }

    public void setActualPrincipalMoney(BigDecimal actualPrincipalMoney) {
        this.actualPrincipalMoney = actualPrincipalMoney;
    }

    public BigDecimal getActualPrincipalMoney() {
        return actualPrincipalMoney;
    }

    public void setActualInterestMoney(BigDecimal actualInterestMoney) {
        this.actualInterestMoney = actualInterestMoney;
    }

    public BigDecimal getActualInterestMoney() {
        return actualInterestMoney;
    }

    public void setExemptMoney(BigDecimal exemptMoney) {
        this.exemptMoney = exemptMoney;
    }

    public BigDecimal getExemptMoney() {
        return exemptMoney;
    }


    public void setPenalty(BigDecimal penalty) {
        this.penalty = penalty;
    }

    public BigDecimal getPenalty() {
        return penalty;
    }

    public BigDecimal getPenaltyInterest() {
        return penaltyInterest;
    }

    public void setPenaltyInterest(BigDecimal penaltyInterest) {
        this.penaltyInterest = penaltyInterest;
    }

    public BigDecimal getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(BigDecimal serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    public BigDecimal getOtherCharge() {
        return otherCharge;
    }

    public void setOtherCharge(BigDecimal otherCharge) {
        this.otherCharge = otherCharge;
    }

    public void setLrpId(Long lrpId) {
        this.lrpId = lrpId;
    }

    public Long getLrpId() {
        return lrpId;
    }

    public void setLaId(Long laId) {
        this.laId = laId;
    }

    public Long getLaId() {
        return laId;
    }

    public void setPushStatus(Integer pushStatus) {
        this.pushStatus = pushStatus;
    }

    public Integer getPushStatus() {
        return pushStatus;
    }

    public void setIndexNo(Integer indexNo) {
        this.indexNo = indexNo;
    }

    public Integer getIndexNo() {
        return indexNo;
    }

    public void setMoneyStatus(Integer moneyStatus) {
        this.moneyStatus = moneyStatus;
    }

    public Integer getMoneyStatus() {
        return moneyStatus;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public String getApplicationCode() {
        return applicationCode;
    }

    public void setApplicationCode(String applicationCode) {
        this.applicationCode = applicationCode;
    }

    public Date getPlanDate() {
        return planDate;
    }

    public void setPlanDate(Date planDate) {
        this.planDate = planDate;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }
}
