package com.utour.youdai.admin.common.utils;

import java.math.BigDecimal;

/**
 * 百分比 工具类
 */
public class DecimalUtils {

    public static final BigDecimal percentageToDecimal(BigDecimal percentage) {
        return percentage.divide(new BigDecimal(100), 4, BigDecimal.ROUND_HALF_DOWN);
    }

    public static final BigDecimal decimalToPercentage(BigDecimal decimal) {
        return decimal.multiply(new BigDecimal(100));
    }
}
