package com.utour.youdai.admin.common.utils.dataPush;


import cn.hutool.crypto.digest.DigestUtil;

public class TokenUtil {

    /**
     * 生成TOKEN
     *
     * @param roundStr 随机字符串
     * @return
     */
    public static final String getToken(String roundStr, String clientId, String appKey) {
        String data = "clientId=" + clientId + "&roundStr=" + roundStr + "&appKey=" + appKey;
        return DigestUtil.md5Hex(data);
    }
}
