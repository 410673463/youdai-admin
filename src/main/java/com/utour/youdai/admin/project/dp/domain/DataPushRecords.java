package com.utour.youdai.admin.project.dp.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.utour.youdai.admin.framework.aspectj.lang.annotation.Excel;
import com.utour.youdai.admin.framework.web.domain.BaseEntity;

import java.util.Date;

/**
 * 数据推送记录对象 dp_data_push_records
 *
 * @author zh
 * @date 2020-08-25
 */
public class DataPushRecords extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * $column.columnComment
     */
    private Long id;

    /**
     * 关联表主键id
     */
    @Excel(name = "关联表主键id")
    private Long primaryId;

    /**
     * 推送表名
     */
    @Excel(name = "推送表名")
    private String dataTable;

    /**
     * 请求路径
     */
    @Excel(name = "请求路径")
    private String path;

    /**
     * 业务主键
     */
    @Excel(name = "业务主键")
    private String reqId;

    /**
     * 签名
     */
    @Excel(name = "签名")
    private String sign;

    /**
     * $column.columnComment
     */
    @Excel(name = "token")
    private String token;

    /**
     * 随机字符串
     */
    @Excel(name = "随机字符串")
    private String roundStr;

    /**
     * 请求入参
     */
    @Excel(name = "请求入参")
    private String param;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date requestTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date responseTime;
    private String responseResult;
    private String requestMethod;

    private String createUser;
    private Long createUserId;

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

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setPrimaryId(Long primaryId) {
        this.primaryId = primaryId;
    }

    public Long getPrimaryId() {
        return primaryId;
    }

    public void setDataTable(String dataTable) {
        this.dataTable = dataTable;
    }

    public String getDataTable() {
        return dataTable;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    public String getReqId() {
        return reqId;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getSign() {
        return sign;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setRoundStr(String roundStr) {
        this.roundStr = roundStr;
    }

    public String getRoundStr() {
        return roundStr;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public String getParam() {
        return param;
    }

    public Date getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(Date requestTime) {
        this.requestTime = requestTime;
    }

    public Date getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(Date responseTime) {
        this.responseTime = responseTime;
    }

    public String getResponseResult() {
        return responseResult;
    }

    public void setResponseResult(String responseResult) {
        this.responseResult = responseResult;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }
}
