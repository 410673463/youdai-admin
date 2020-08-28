package com.utour.youdai.admin.project.bo.domain;

import com.utour.youdai.admin.framework.web.domain.BaseEntity;

import java.util.Date;

/**
 * 借款人-个人信息对象 bo_personal_info
 *
 * @author zh
 * @date 2020-07-31
 */
public class PersonalInfo extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * $column.columnComment
     */
    private Long id;

    /**
     * 借款人基本信息ID
     */
    private Long boId;

    /**
     * 证件类别
     */
    private String identityType;

    /**
     * 证件号码
     */
    private String identityNo;

    /**
     * 证件到期日
     */
    private Date expiryDate;

    /**
     * 户籍类别
     */
    private String householdRegistrationCategory;

    /**
     * 性别
     */
    private String gender;

    /**
     * 年龄
     */
    private Long age;

    /**
     * 出生日期
     */
    private Date birthday;

    /**
     * 学历
     */
    private String educationLevel;

    /**
     * 联系电话1
     */
    private String phoneno1;

    /**
     * 联系电话2
     */
    private String phoneno2;

    /**
     * 护照号
     */
    private String passportNo;

    /**
     * 毕业院校
     */
    private String graduatedSchool;

    /**
     * 户籍地址
     */
    private String householdRegistrationAddress;

    /**
     * 签发机构
     */
    private String issuingAgency;

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

    public void setIdentityType(String identityType) {
        this.identityType = identityType;
    }

    public String getIdentityType() {
        return identityType;
    }

    public String getIdentityNo() {
        return identityNo;
    }

    public void setIdentityNo(String identityNo) {
        this.identityNo = identityNo;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setHouseholdRegistrationCategory(String householdRegistrationCategory) {
        this.householdRegistrationCategory = householdRegistrationCategory;
    }

    public String getHouseholdRegistrationCategory() {
        return householdRegistrationCategory;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public Long getAge() {
        return age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }

    public String getEducationLevel() {
        return educationLevel;
    }

    public void setPhoneno1(String phoneno1) {
        this.phoneno1 = phoneno1;
    }

    public String getPhoneno1() {
        return phoneno1;
    }

    public void setPhoneno2(String phoneno2) {
        this.phoneno2 = phoneno2;
    }

    public String getPhoneno2() {
        return phoneno2;
    }

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }

    public String getPassportNo() {
        return passportNo;
    }

    public void setGraduatedSchool(String graduatedSchool) {
        this.graduatedSchool = graduatedSchool;
    }

    public String getGraduatedSchool() {
        return graduatedSchool;
    }

    public void setHouseholdRegistrationAddress(String householdRegistrationAddress) {
        this.householdRegistrationAddress = householdRegistrationAddress;
    }

    public String getHouseholdRegistrationAddress() {
        return householdRegistrationAddress;
    }

    public void setIssuingAgency(String issuingAgency) {
        this.issuingAgency = issuingAgency;
    }

    public String getIssuingAgency() {
        return issuingAgency;
    }


}
