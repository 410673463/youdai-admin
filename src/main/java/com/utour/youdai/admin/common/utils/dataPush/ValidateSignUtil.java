package com.utour.youdai.admin.common.utils.dataPush;


import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.foxinmy.weixin4j.util.MapUtil;
import org.apache.commons.codec.digest.DigestUtils;
import java.util.HashMap;
import java.util.Map;

/**
 * 生成签名 工具类
 */

public class ValidateSignUtil {
    private static Log log = LogFactory.get();




    public static final String validateSign(Object param,String appKey) {
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
        map.put("clientId", "2478912407278593");
        map.put("contractNumber", "LM-202008311842116192");
        map.put("interest","253.64");
        map.put("money","1579.95");
        map.put("otherCharge","1.00");
        map.put("penalty", "1.00");
        map.put("penaltyInterest", "1.00");
        map.put("repayTime", "2020-10-31");

        map.put("reqId", "1234567890-79538678f52f4fedb3c7860be7321a21");
        map.put("roundStr", "7469220985");
        map.put("serviceCharge", "1.00");

        map.put("token", "67bd8db3f9a097f90b5d9b4f520424a3");

        String sign = validateSign(map,"g7mogtr59fvoptps");
        System.out.println(sign);

    }
}
