package com.utour.youdai.admin.project.bo.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.utour.youdai.admin.framework.web.domain.BaseEntity;

import java.util.Date;

/**
 * 借款人-公司详细信息对象 bo_corporate_info
 *
 * @author zh
 * @date 2020-08-01
 */
public class CorporateInfo extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * $column.columnComment
     */
    private Long id;

    /**
     * 借款人基础信息Id
     */
    private Long boId;

    /**
     * 企业性质:有限责任、股份制、私营、独资、合资
     */
    private String type;

    /**
     * 股东数量
     */
    private Long shareholderNum;

    /**
     * 注册地址
     */
    private String address;

    /**
     * 注册资金
     */
    private String registeredCapital;

    /**
     * 企业规模
     */
    private String scale;

    /**
     * 法人类别
     */
    private String legalPersonType;
    /**
     * 营业执照号
     */
    private String businessLicenseCode;
    /**
     * 营业执照有效截止日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date businessLicenseEndDate;
    /**
     * 法人姓名
     */
    private String legalPersonName;

    /**
     * 法人身份证号
     */
    private String legalPersonIdNo;

    /**
     * 法人联系电话
     */
    private String legalPersonPhone;

    /**
     * 注册类型
     */
    private String registrationType;

    /**
     * 统一社会信用代码
     */
    private String uniformSocialCreditCode;

    /**
     * 税号
     */
    private String taxNo;

    /**
     * 登记机关
     */
    private String registrationAuthority;

    /**
     * 从业人数
     */
    private Long employeeNum;

    /**
     * 经营范围
     */
    private String enterpriseScope;

    /**
     * 成立背景
     */
    private String foundExplain;

    /**
     * 发展过程
     */
    private String devDourse;

    /**
     * 管理结构
     */
    private String manageStructure;

    /**
     * 主要产品
     */
    private String productExplain;

    /**
     * 相关行业政策
     */
    private String industryPolicy;

    /**
     * 市场竞争关系
     */
    private String bazaarExplain;

    /**
     * 未来发展计划
     */
    private String futurePlan;

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

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setShareholderNum(Long shareholderNum) {
        this.shareholderNum = shareholderNum;
    }

    public Long getShareholderNum() {
        return shareholderNum;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setRegisteredCapital(String registeredCapital) {
        this.registeredCapital = registeredCapital;
    }

    public String getRegisteredCapital() {
        return registeredCapital;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    public String getScale() {
        return scale;
    }

    public void setLegalPersonType(String legalPersonType) {
        this.legalPersonType = legalPersonType;
    }

    public String getLegalPersonType() {
        return legalPersonType;
    }

    public void setLegalPersonName(String legalPersonName) {
        this.legalPersonName = legalPersonName;
    }

    public String getLegalPersonName() {
        return legalPersonName;
    }

    public void setLegalPersonIdNo(String legalPersonIdNo) {
        this.legalPersonIdNo = legalPersonIdNo;
    }

    public String getLegalPersonIdNo() {
        return legalPersonIdNo;
    }

    public void setLegalPersonPhone(String legalPersonPhone) {
        this.legalPersonPhone = legalPersonPhone;
    }

    public String getLegalPersonPhone() {
        return legalPersonPhone;
    }

    public void setRegistrationType(String registrationType) {
        this.registrationType = registrationType;
    }

    public String getRegistrationType() {
        return registrationType;
    }

    public void setUniformSocialCreditCode(String uniformSocialCreditCode) {
        this.uniformSocialCreditCode = uniformSocialCreditCode;
    }

    public String getUniformSocialCreditCode() {
        return uniformSocialCreditCode;
    }

    public void setTaxNo(String taxNo) {
        this.taxNo = taxNo;
    }

    public String getTaxNo() {
        return taxNo;
    }

    public void setRegistrationAuthority(String registrationAuthority) {
        this.registrationAuthority = registrationAuthority;
    }

    public String getRegistrationAuthority() {
        return registrationAuthority;
    }

    public void setEmployeeNum(Long employeeNum) {
        this.employeeNum = employeeNum;
    }

    public Long getEmployeeNum() {
        return employeeNum;
    }

    public void setEnterpriseScope(String enterpriseScope) {
        this.enterpriseScope = enterpriseScope;
    }

    public String getEnterpriseScope() {
        return enterpriseScope;
    }

    public void setFoundExplain(String foundExplain) {
        this.foundExplain = foundExplain;
    }

    public String getFoundExplain() {
        return foundExplain;
    }

    public void setDevDourse(String devDourse) {
        this.devDourse = devDourse;
    }

    public String getDevDourse() {
        return devDourse;
    }

    public void setManageStructure(String manageStructure) {
        this.manageStructure = manageStructure;
    }

    public String getManageStructure() {
        return manageStructure;
    }

    public void setProductExplain(String productExplain) {
        this.productExplain = productExplain;
    }

    public String getProductExplain() {
        return productExplain;
    }

    public void setIndustryPolicy(String industryPolicy) {
        this.industryPolicy = industryPolicy;
    }

    public String getIndustryPolicy() {
        return industryPolicy;
    }

    public void setBazaarExplain(String bazaarExplain) {
        this.bazaarExplain = bazaarExplain;
    }

    public String getBazaarExplain() {
        return bazaarExplain;
    }

    public void setFuturePlan(String futurePlan) {
        this.futurePlan = futurePlan;
    }

    public String getFuturePlan() {
        return futurePlan;
    }

    public String getBusinessLicenseCode() {
        return businessLicenseCode;
    }

    public void setBusinessLicenseCode(String businessLicenseCode) {
        this.businessLicenseCode = businessLicenseCode;
    }

    public Date getBusinessLicenseEndDate() {
        return businessLicenseEndDate;
    }

    public void setBusinessLicenseEndDate(Date businessLicenseEndDate) {
        this.businessLicenseEndDate = businessLicenseEndDate;
    }
}
