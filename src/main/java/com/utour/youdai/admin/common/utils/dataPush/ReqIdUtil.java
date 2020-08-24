package com.utour.youdai.admin.common.utils.dataPush;


import org.springframework.beans.factory.annotation.Value;

/**
 *  	reqId生成工具类
 *
 */
public class ReqIdUtil {

    private static String CUSCC;
    @Value("dataPush.CUSCC")
    public static void setCUSCC(String CUSCC) {
        ReqIdUtil.CUSCC = CUSCC;
    }
}
