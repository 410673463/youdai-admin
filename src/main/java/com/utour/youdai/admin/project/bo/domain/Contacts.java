package com.utour.youdai.admin.project.bo.domain;

import com.utour.youdai.admin.framework.aspectj.lang.annotation.Excel;
import com.utour.youdai.admin.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 借款人-联系人信息对象 bo_contacts
 *
 * @author zh
 * @date 2020-07-29
 */
public class Contacts extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * $column.columnComment
     */
    private Long id;

    /**
     * 借款人基本信息表ID
     */
    private Long boid;

    /**
     * $column.columnComment
     */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String name;

    /**
     * $column.columnComment
     */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String phone1;

    /**
     * $column.columnComment
     */
    private String phone2;

    /**
     * $column.columnComment
     */
    private Date birthday;

    /**
     * $column.columnComment
     */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String relationship;

    /**
     * 是否为紧急联系人
     */
    @Excel(name = "是否为紧急联系人")
    private Integer emergencycontactyet;

    /**
     * 工作单位全称
     */
    private String companyname;

    /**
     * 职位
     */
    private String position;

    /**
     * 单位电话
     */
    private String workphone;

    /**
     * 月薪
     */
    private String monthlysalary;

    /**
     * $column.columnComment
     */
    private String email;

    /**
     * $column.columnComment
     */
    private String qq;

    /**
     * $column.columnComment
     */
    private String note;

    /**
     * $column.columnComment
     */
    private Date createdate;

    /**
     * $column.columnComment
     */
    private Date modifydate;

    /**
     * 证件号码
     */
    @Excel(name = "证件号码")
    private Long idnum;

    /**
     * 证件类别
     */
    @Excel(name = "证件类别")
    private String idcategory;

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

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setEmergencycontactyet(Integer emergencycontactyet) {
        this.emergencycontactyet = emergencycontactyet;
    }

    public Integer getEmergencycontactyet() {
        return emergencycontactyet;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void setWorkphone(String workphone) {
        this.workphone = workphone;
    }

    public String getWorkphone() {
        return workphone;
    }

    public void setMonthlysalary(String monthlysalary) {
        this.monthlysalary = monthlysalary;
    }

    public String getMonthlysalary() {
        return monthlysalary;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getQq() {
        return qq;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getNote() {
        return note;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setModifydate(Date modifydate) {
        this.modifydate = modifydate;
    }

    public Date getModifydate() {
        return modifydate;
    }

    public void setIdnum(Long idnum) {
        this.idnum = idnum;
    }

    public Long getIdnum() {
        return idnum;
    }

    public void setIdcategory(String idcategory) {
        this.idcategory = idcategory;
    }

    public String getIdcategory() {
        return idcategory;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("boid", getBoid())
                .append("name", getName())
                .append("phone1", getPhone1())
                .append("phone2", getPhone2())
                .append("birthday", getBirthday())
                .append("relationship", getRelationship())
                .append("emergencycontactyet", getEmergencycontactyet())
                .append("companyname", getCompanyname())
                .append("position", getPosition())
                .append("workphone", getWorkphone())
                .append("monthlysalary", getMonthlysalary())
                .append("email", getEmail())
                .append("qq", getQq())
                .append("note", getNote())
                .append("createby", getCreateBy())
                .append("createdate", getCreatedate())
                .append("modifydate", getModifydate())
                .append("idnum", getIdnum())
                .append("idcategory", getIdcategory())
                .toString();
    }
}
