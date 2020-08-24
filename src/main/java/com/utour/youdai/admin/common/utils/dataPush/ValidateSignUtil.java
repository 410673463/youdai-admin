package com.utour.youdai.admin.common.utils.dataPush;


import cn.hutool.core.util.RandomUtil;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.foxinmy.weixin4j.util.MapUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Value;

import java.util.HashMap;
import java.util.Map;

/**
 * 生成签名 工具类
 */

public class ValidateSignUtil {
    private static Log log = LogFactory.get();


    private static String appKey;

    @Value("dataPush.appKey")
    public static void setAppKey(String appKey) {
        ValidateSignUtil.appKey = appKey;
    }

    public static final String validateSign(Object param) {
        String validateString = MapUtil.toJoinString(param,
                false, false) + "&appKey=" + appKey;
        log.info("参与签名的字符串---" + validateString);
        String validateSign = DigestUtils.md5Hex(validateString)
                .toLowerCase();
        log.info("生成的签 名---" + validateSign);
        return validateSign;
    }

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("cardNumber", "E342847");
        map.put("cardType", "2");
        map.put("clientId", "5971046406121460");
        map.put("executiveFlag", "1");
        map.put("name", "测试");
        map.put("position", "产品经理");
        map.put("reqId", "84678456-61755606");
        String randomStr = RandomUtil.randomNumbers(6);
        map.put("roundStr", randomStr);
        map.put("sex", "1");
        map.put("token", "c647291b0fc66bc07e8d641fd37e08ab");
        String sign = validateSign(map);
        System.out.println(TokenUtil.getToken(randomStr));
        System.out.println(sign);

    }
}
