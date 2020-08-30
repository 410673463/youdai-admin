package com.utour.youdai.admin.project.fi.domain;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.utour.youdai.admin.framework.aspectj.lang.annotation.Excel;
import com.utour.youdai.admin.framework.web.domain.BaseEntity;

/**
 * 还款计划对象 fi_loan_repayment_plan
 *
 * @author zh
 * @date 2020-08-14
 */
public class LoanRepaymentPlan extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * $column.columnComment
     */
    private Long id;

    /**
     * 贷款申请id
     */
    private Long laId;

    /**
     * 计划还款日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "计划还款日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date planDate;

    /**
     * 计划还款金额合计
     */
    @Excel(name = "计划还款金额合计")
    private BigDecimal planMoneySum;

    /**
     * 计划还款本金
     */
    @Excel(name = "计划还款本金")
    private BigDecimal planPrincipalMoney;

    /**
     * 计划还款利息
     */
    @Excel(name = "计划还款利息")
    private BigDecimal planInterestMoney;

    /**
     * 序号、第几期
     */
    @Excel(name = "序号、第几期")
    private Integer indexNo;

    /**
     * 数据推送状态: 0、推送失败 1、待推送 2、推送中 3、推送成功
     */
    private Integer pushStatus;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setLaId(Long laId) {
        this.laId = laId;
    }

    public Long getLaId() {
        return laId;
    }

    public void setPlanDate(Date planDate) {
        this.planDate = planDate;
    }

    public Date getPlanDate() {
        return planDate;
    }

    public void setPlanMoneySum(BigDecimal planMoneySum) {
        this.planMoneySum = planMoneySum;
    }

    public BigDecimal getPlanMoneySum() {
        return planMoneySum;
    }

    public void setPlanPrincipalMoney(BigDecimal planPrincipalMoney) {
        this.planPrincipalMoney = planPrincipalMoney;
    }

    public BigDecimal getPlanPrincipalMoney() {
        return planPrincipalMoney;
    }

    public void setPlanInterestMoney(BigDecimal planInterestMoney) {
        this.planInterestMoney = planInterestMoney;
    }

    public BigDecimal getPlanInterestMoney() {
        return planInterestMoney;
    }

    public Integer getIndexNo() {
        return indexNo;
    }

    public void setIndexNo(Integer indexNo) {
        this.indexNo = indexNo;
    }

    public void setPushStatus(Integer pushStatus) {
        this.pushStatus = pushStatus;
    }

    public Integer getPushStatus() {
        return pushStatus;
    }


}
