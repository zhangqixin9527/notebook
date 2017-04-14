/*
 * 文件名称: ArithUtils.java
 * 版权信息: Copyright 2016-2020 technology Co., LTD. All right reserved.
 * ----------------------------------------------------------------------------------------------
 * 修改历史:
 * ----------------------------------------------------------------------------------------------
 * 修改原因: 新增
 * 修改人员: Kevin
 * 修改日期: 2017/3/29
 * 修改内容: 
 */
package com.hengba.utils.common;

import java.math.BigDecimal;

/**
 * @author Kevin created on 2017/3/29.
 * @since framework 1.0
 */
public class ArithUtils {

    /**
     * 除法
     * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指定精度，以后的数字四舍五入。
     * @param dividend 被除数
     * @param divisor 除数
     * @param scale 表示需要精确到小数点以后几位。
     * @return 两个参数的商
     */
    public static String divide(int dividend, int divisor, int scale){
        return divide((double) dividend, (double) divisor, scale);
    }

    /**
     * 除法
     * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指定精度，以后的数字四舍五入。
     * @param dividend 被除数
     * @param divisor 除数
     * @param scale 表示需要精确到小数点以后几位。
     * @return
     */
    public static String divide(double dividend, double divisor, int scale){
       return divideB(dividend, divisor, scale).toString();
    }

    /**
     * 除法
     * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指定精度，以后的数字四舍五入。
     * @param dividend 被除数
     * @param divisor 除数
     * @param scale 表示需要精确到小数点以后几位。
     * @return 两个参数的商
     */
    public static BigDecimal divideB(double dividend, double divisor, int scale){
        if(scale < 0)
            throw new IllegalArgumentException("The argument 'scale' must be positive integer or zero");
        if(0 == divisor)
            throw new IllegalArgumentException("The argument 'divisor' can not be zero");
        BigDecimal d1 = new BigDecimal(dividend);
        BigDecimal d2 = new BigDecimal(divisor);
        return d1.divide(d2, scale, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 百分比
     * 提供（相对）精确的百分比字符串，当发生除不尽的情况时，精确到小数点以后scale位，以后的数字四舍五入。
     * 如: percent(1,4,1) 1除4的百分比,取一位小数: 25.0%
     * @param v1 被除数
     * @param v2 除数
     * @param scale 表示需要精确到小数点以后几位。
     * @return 两参数的百分比
     */
    public static String percent(double v1, double v2, int scale){
        BigDecimal quotient = divideB(v1, v2, scale + 2);
        BigDecimal product = quotient.multiply(new BigDecimal(100));
        return product.setScale(scale).toString()+"%";
    }

    /**
     * 百分比
     * 提供（相对）精确的百分比字符串，当发生除不尽的情况时，精确到小数点以后scale位，以后的数字四舍五入。
     * 如: percent(1,4,1) 1除4的百分比,取一位小数: 25.0%
     * @param v1 被除数
     * @param v2 除数
     * @param scale 表示需要精确到小数点以后几位。
     * @return 两参数的百分比
     */
    public static String percent(int v1, int v2, int scale){
        return percent((double)v1, (double)v2, scale);
    }


    /**
     * 字符串对应数值设置精度 (取舍：四舍五入)
     * @param value 字符串对象
     * @param length 精度(小数点后)
     * @return 拥有制定精度的字符串
     */
    public static String stringScale(String value, int length){
        Double valueB = new Double(value);
        return new BigDecimal(valueB).setScale(length, BigDecimal.ROUND_HALF_UP).toString();
    }

    public static void main(String[] args) {
        System.out.println(divide(1,3,4));
        System.out.println(1.3*2.0);
        System.out.println(percent(2.2,1,1));
        System.out.println(stringScale("1.00", 3));
    }
}
