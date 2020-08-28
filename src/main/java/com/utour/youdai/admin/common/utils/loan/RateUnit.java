package com.utour.youdai.admin.common.utils.loan;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 利率转换工具
 */
public class RateUnit {
    /**
     * 利率全部转换为年利率
     *
     * @return
     */
    public static final BigDecimal changeRateToYear(String unit, BigDecimal rate) {
        BigDecimal monthRate = new BigDecimal(0);
        BigDecimal d100 = new BigDecimal(100);
        if (unit.equals("年")) {
            monthRate = rate.divide(d100, 2, RoundingMode.HALF_UP);
        } else if (unit.equals("月")) {
            monthRate = rate.multiply(new BigDecimal(12)).divide(d100, 2, RoundingMode.HALF_UP);
        } else if (unit.equals("日")) {
            monthRate = rate.multiply(new BigDecimal(360)).divide(d100, 2, RoundingMode.HALF_UP);
        }
        return monthRate;
    }

}
