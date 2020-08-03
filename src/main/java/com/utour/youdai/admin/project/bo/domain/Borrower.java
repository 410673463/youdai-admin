package com.utour.youdai.admin.project.bo.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.utour.youdai.admin.framework.aspectj.lang.annotation.Excel;
import com.utour.youdai.admin.framework.web.domain.BaseEntity;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 借款人-基本信息(主)对象 bo_borrower
 *
 * @author zh
 * @date 2020-07-28
 */
public class Borrower extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * $column.columnComment
     */
    private Long id;

    /**
     * 借款主体
     */
    @Excel(name = "借款主体")
    private String name;

    /**
     * 借款人编码,系统生成
     */
    @Excel(name = "借款人编码")
    private String code;

    /**
     * 借款人类别:个人、机构
     */
    @Excel(name = "借款人类别")
    private String type;

    /**
     * 业务人员
     */
    @Excel(name = "业务人员")
    private String operatorusername;

    /**
     * $column.columnComment
     */
    @Excel(name = "业务人员")
    private Long operatoruserid;

    /**
     * 所属区域
     */
    @Excel(name = "所属区域")
    private String areas;

    /**
     * 所属行业
     */
    @Excel(name = "所属行业")
    private String industrys;

    /**
     * 借款人来源:个人、公司、中介
     */
    @Excel(name = "借款人来源")
    private String source;

    /**
     * 借款人来源名称
     */
    @Excel(name = "借款人来源名称")
    private String sourcename;

    /**
     * 客户分类:银行、融资、借款人、担保人
     */
    @Excel(name = "借款人分类")
    private String category;

    /**
     * $column.columnComment
     */
    @Excel(name = "备注")
    private String note;

    /**
     * $column.columnComment
     */
    @Excel(name = "创建人")
    private String createusername;

    /**
     * $column.columnComment
     */
    private Long createuserid;

    /**
     * $column.columnComment
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "创建日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createdate;

    /**
     * $column.columnComment
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "修改日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date modifydate;

    private String dataSource;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setOperatorusername(String operatorusername) {
        this.operatorusername = operatorusername;
    }

    public String getOperatorusername() {
        return operatorusername;
    }

    public void setOperatoruserid(Long operatoruserid) {
        this.operatoruserid = operatoruserid;
    }

    public Long getOperatoruserid() {
        return operatoruserid;
    }

    public void setAreas(String areas) {
        this.areas = areas;
    }

    public String getAreas() {
        return areas;
    }

    public void setIndustrys(String industrys) {
        this.industrys = industrys;
    }

    public String getIndustrys() {
        return industrys;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSource() {
        return source;
    }

    public void setSourcename(String sourcename) {
        this.sourcename = sourcename;
    }

    public String getSourcename() {
        return sourcename;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setCreateusername(String createusername) {
        this.createusername = createusername;
    }

    public String getCreateusername() {
        return createusername;
    }

    public void setCreateuserid(Long createuserid) {
        this.createuserid = createuserid;
    }

    public Long getCreateuserid() {
        return createuserid;
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

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("name", getName())
                .append("code", getCode())
                .append("type", getType())
                .append("operatorusername", getOperatorusername())
                .append("operatoruserid", getOperatoruserid())
                .append("areas", getAreas())
                .append("industrys", getIndustrys())
                .append("source", getSource())
                .append("sourcename", getSourcename())
                .append("category", getCategory())
                .append("note", getNote())
                .append("createusername", getCreateusername())
                .append("createuserid", getCreateuserid())
                .append("createdate", getCreatedate())
                .append("modifydate", getModifydate())
                .toString();
    }
}
