package com.utour.youdai.admin.common.utils;


import org.apache.commons.lang3.RandomStringUtils;

/**
 * 编码生成器
 * 时间戳+x位随机数
 */
public class CodeGeneratorFactory {

    /**
     * 生成编码
     * 规则:前缀 + 时间戳 + x位随机数
     * 例:  BO202007292012395629
     * @param prefix 编码前缀
     * @param count  随机位数
     * @return
     */
    public static String getCode(String prefix, int count) {
        String time = DateUtils.dateTimeNow();
        String random = RandomStringUtils.randomNumeric(4);
        return prefix + time + random;
    }

}
