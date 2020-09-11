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

    /**
     * 推送 还款记录
     * @param lraId
     * @return
     */
    String pushRepayActual(Long lraId);

    /**
     * 推送放款记录
     * @param id
     * @return
     */
    String pushLoanRecords(Long id);

    /**
     * 推送展期记录
     * @param laId
     * @return
     */
    String pushExtensionApplicationData(Long laId);
}
