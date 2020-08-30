package com.utour.youdai.admin.project.dp.service;

public interface IDataPushService {

    /**
     * 推送 贷款申请 数据
     * @param laId
     * @return resultCode
     */
   String pushApplicationData(Long laId);


    /**
     * 删除 贷款申请 推送记录
     * @param laId
     * @return
     */
    String deleteApplicationData(Long laId);
}
