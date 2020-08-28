package com.utour.youdai.admin.project.lm.domain;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.utour.youdai.admin.framework.aspectj.lang.annotation.Excel;
import com.utour.youdai.admin.framework.web.domain.BaseEntity;

/**
 * 贷款管理-贷款申请对象 lm_loan_application
 *
 * @author zh
 * @date 2020-08-02
 */
public class LoanApplication extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * $column.columnComment
     */
    private Long id;

    /**
     * 客户基础信息表ID
     */
    private Long boid;

    /**
     * 产品ID(保留字段)
     */
    private Long productId;

    /**
     * 贷款申请编号
     */
    private String code;

    /**
     * 申请名称
     */
    @Excel(name = "申请名称")
    private String applicationName;

    /**
     * 产品名称
     */
    @Excel(name = "产品名称")
    private String productTitle;

    /**
     * 客户名称
     */
    @Excel(name = "客户名称")
    private String borrowerName;

    /**
     * 客户经理
     */
    @Excel(name = "经办人")
    private String borrowerManager;

    /**
     * 经办人Id
     */
    private Integer boManagerId;

    /**
     * 贷款性质: 1新项目、2还旧借新、3展期项目
     */
    private Integer applyNature;

    /**
     * 贷款金额
     */
    @Excel(name = "贷款金额")
    private BigDecimal applyMoney;

    /**
     * 贷款期限
     */
    @Excel(name = "贷款期限")
    private Integer applyExpires;

    /**
     * 贷款期限单位:年、月、日
     */
    private String applyExpiresUnit;

    /**
     * 贷款开始日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date applyStartDate;

    /**
     * 贷款结束日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date applyEndDate;

    /**
     * 贷款利率
     */
    @Excel(name = "贷款利率")
    private BigDecimal applyRate;

    /**
     * 贷款利率单位:年、月、日
     */
    private String applyRateUnit;

    /**
     * 咨询费率
     */
    private BigDecimal applyConsultingRate;

    /**
     * 咨询费率单位：年、月、日
     */
    private String applyConsultingRateUnit;

    /**
     * 还款方式: 1:等额本息 2:等额本金 3:一次性到期还本付息 4:按月分期付息、到期还本 5:自由还款
     */
    private Integer repayType;

    /**
     * 咨询费计算方式：1:按实际天数计算 2:按整期计算 3：首期不足一期，也按照一期30天计算；其他按天计算
     */
    private Integer applyConsultationRepayType;

    /**
     * 签约方式: 1、面签 2、网签
     */
    private Integer contractSignWay;

    /**
     * 利息上浮比例
     */
    private BigDecimal interestRateIncrease;

    /**
     * 申请来源：1、微信 2、app 3、网站 4、手动录入 5、外部推送
     */
    private Integer applySource;

    /**
     * 是否担保项目
     */
    private Integer whetherGuaranteeApply;

    /**
     * 担保方式: 抵押、质押、保证、信用、其他
     */
    private String guaranteeApplyType;

    /**
     * 备注
     */
    private String note;

    /**
     * 状态: -1、审核终止 0、申请创建  1、创建审批流程 2、提交审核 3、业务经理审核 4、风控经理审核 5、上会 审核  6、总经理审核 7 财务审核(负值代表审核未通过) 8合同签订 9 历史数据补录
     */
    @Excel(name = "状态")
    private Integer status;

    /**
     * 数据推送状态: 0、推送失败 1、待推送 2、推送中 3、推送成功
     */
    @Excel(name = "数据推送状态: 0、推送失败 1、待推送 2、推送中 3、推送成功 ")
    private Integer pushStatus;

    /**
     * 是否已经生成还款计划
     */
    private Integer createRepayPlan;

    /**
     * 是否受托支付
     */
    @Excel(name = "是否受托支付")
    private Integer whetherEntrust;

    /**
     * 贷款用途：1）流动资金贷款  2）固定资产投资贷款  3）其他）
     */
    @Excel(name = "贷款用途")
    private Integer purpose;

    /**
     * 投向行业：1）居民服务和其他服务业,2）建筑业, 3）交通运输、仓储和邮政业, 4）农、林、牧、渔业, 5）采矿业, 6）制造业, 7）电力、燃气及水的生产和供应业, 8）信息传输、计算机服务和软件业, 9）批发和零售业,10）住宿和餐饮业, 11）房地产业, 12）租赁和商务服务业, 13）其他
     */
    @Excel(name = "投向行业")
    private Integer business;

    /**
     * 还款来源
     */
    @Excel(name = "还款来源")
    private String repaySource;

    /**
     * 平台费
     */
    @Excel(name = "平台费")
    private BigDecimal platformCost;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setBoid(Long boid) {
        this.boid = boid;
    }

    public Long getBoid() {
        return boid;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public void setBorrowerManager(String borrowerManager) {
        this.borrowerManager = borrowerManager;
    }

    public String getBorrowerManager() {
        return borrowerManager;
    }

    public void setApplyNature(Integer applyNature) {
        this.applyNature = applyNature;
    }

    public Integer getApplyNature() {
        return applyNature;
    }

    public void setApplyMoney(BigDecimal applyMoney) {
        this.applyMoney = applyMoney;
    }

    public BigDecimal getApplyMoney() {
        return applyMoney;
    }

    public Integer getApplyExpires() {
        return applyExpires;
    }

    public void setApplyExpires(Integer applyExpires) {
        this.applyExpires = applyExpires;
    }

    public void setApplyExpiresUnit(String applyExpiresUnit) {
        this.applyExpiresUnit = applyExpiresUnit;
    }

    public String getApplyExpiresUnit() {
        return applyExpiresUnit;
    }

    public void setApplyStartDate(Date applyStartDate) {
        this.applyStartDate = applyStartDate;
    }

    public Date getApplyStartDate() {
        return applyStartDate;
    }

    public void setApplyEndDate(Date applyEndDate) {
        this.applyEndDate = applyEndDate;
    }

    public Date getApplyEndDate() {
        return applyEndDate;
    }

    public void setApplyRate(BigDecimal applyRate) {
        this.applyRate = applyRate;
    }

    public BigDecimal getApplyRate() {
        return applyRate;
    }

    public void setApplyRateUnit(String applyRateUnit) {
        this.applyRateUnit = applyRateUnit;
    }

    public String getApplyRateUnit() {
        return applyRateUnit;
    }

    public void setApplyConsultingRate(BigDecimal applyConsultingRate) {
        this.applyConsultingRate = applyConsultingRate;
    }

    public BigDecimal getApplyConsultingRate() {
        return applyConsultingRate;
    }

    public void setApplyConsultingRateUnit(String applyConsultingRateUnit) {
        this.applyConsultingRateUnit = applyConsultingRateUnit;
    }

    public String getApplyConsultingRateUnit() {
        return applyConsultingRateUnit;
    }

    public void setRepayType(Integer repayType) {
        this.repayType = repayType;
    }

    public Integer getRepayType() {
        return repayType;
    }

    public void setApplyConsultationRepayType(Integer applyConsultationRepayType) {
        this.applyConsultationRepayType = applyConsultationRepayType;
    }

    public Integer getApplyConsultationRepayType() {
        return applyConsultationRepayType;
    }

    public void setContractSignWay(Integer contractSignWay) {
        this.contractSignWay = contractSignWay;
    }

    public Integer getContractSignWay() {
        return contractSignWay;
    }

    public void setInterestRateIncrease(BigDecimal interestRateIncrease) {
        this.interestRateIncrease = interestRateIncrease;
    }

    public BigDecimal getInterestRateIncrease() {
        return interestRateIncrease;
    }

    public void setApplySource(Integer applySource) {
        this.applySource = applySource;
    }

    public Integer getApplySource() {
        return applySource;
    }

    public void setWhetherGuaranteeApply(Integer whetherGuaranteeApply) {
        this.whetherGuaranteeApply = whetherGuaranteeApply;
    }

    public Integer getWhetherGuaranteeApply() {
        return whetherGuaranteeApply;
    }

    public void setGuaranteeApplyType(String guaranteeApplyType) {
        this.guaranteeApplyType = guaranteeApplyType;
    }

    public String getGuaranteeApplyType() {
        return guaranteeApplyType;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getNote() {
        return note;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }

    public void setPushStatus(Integer pushStatus) {
        this.pushStatus = pushStatus;
    }

    public Integer getPushStatus() {
        return pushStatus;
    }

    public void setCreateRepayPlan(Integer createRepayPlan) {
        this.createRepayPlan = createRepayPlan;
    }

    public Integer getCreateRepayPlan() {
        return createRepayPlan;
    }

    public Integer getBoManagerId() {
        return boManagerId;
    }

    public void setBoManagerId(Integer boManagerId) {
        this.boManagerId = boManagerId;
    }

    public Integer getWhetherEntrust() {
        return whetherEntrust;
    }

    public void setWhetherEntrust(Integer whetherEntrust) {
        this.whetherEntrust = whetherEntrust;
    }

    public Integer getPurpose() {
        return purpose;
    }

    public void setPurpose(Integer purpose) {
        this.purpose = purpose;
    }

    public Integer getBusiness() {
        return business;
    }

    public void setBusiness(Integer business) {
        this.business = business;
    }

    public String getRepaySource() {
        return repaySource;
    }

    public void setRepaySource(String repaySource) {
        this.repaySource = repaySource;
    }

    public BigDecimal getPlatformCost() {
        return platformCost;
    }

    public void setPlatformCost(BigDecimal platformCost) {
        this.platformCost = platformCost;
    }
}
