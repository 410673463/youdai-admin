package com.utour.youdai.admin.common.utils.dataPush;


import cn.hutool.crypto.digest.DigestUtil;
import org.springframework.beans.factory.annotation.Value;

public class TokenUtil {

    private static String appKey;

    private static String clientId;
    @Value("dataPush.appKey")
    public static void setAppKey(String appKey) {
        TokenUtil.appKey = appKey;
    }
    @Value("dataPush.clientId")
    public static void setClientId(String clientId) {
        TokenUtil.clientId = clientId;
    }

    /**
     * 生成TOKEN
     *
     * @param roundStr 随机字符串
     * @return
     */
    public static final String getToken(String roundStr) {
        String data = "clientId=" + clientId + "&roundStr=" + roundStr + "&appKey=" + appKey;
        return DigestUtil.md5Hex(data);
    }
}
