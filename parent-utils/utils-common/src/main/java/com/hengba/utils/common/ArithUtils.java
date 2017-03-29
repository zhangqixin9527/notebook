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
     * @param dividend
     * @param divisor
     * @param scale
     * @return
     */
    public static String divide(int dividend, int divisor, int scale){
        return divide((double) dividend, (double) divisor, scale);
    }

    /**
     * 除法
     * @param dividend
     * @param divisor
     * @param scale
     * @return
     */
    public static String divide(double dividend, double divisor, int scale){
       return divideB(dividend, divisor, scale).toString();
    }

    /**
     * 除法
     * @param dividend
     * @param divisor
     * @param scale
     * @return
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
     * @param v1
     * @param v2
     * @param scale
     * @return
     */
    public static String percent(double v1, double v2, int scale){
        BigDecimal quotient = divideB(v1, v2, scale + 2);
        BigDecimal product = quotient.multiply(new BigDecimal(100));
        return product.setScale(scale).toString()+"%";
    }

    /**
     * 百分比
     * @param v1
     * @param v2
     * @param scale
     * @return
     */
    public static String percent(int v1, int v2, int scale){
        return percent((double)v1, (double)v2, scale);
    }

    public static void main(String[] args) {
        System.out.println(divide(1,3,4));
        System.out.println(1.3*2.0);
        System.out.println(percent(2.2,1,1));
    }
}
