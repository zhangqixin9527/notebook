/*
 * 文件名称: ShiftingTest.java
 * 版权信息: Copyright 2016-2020 technology Co., LTD. All right reserved.
 * ----------------------------------------------------------------------------------------------
 * 修改历史:
 * ----------------------------------------------------------------------------------------------
 * 修改原因: 新增
 * 修改人员: Kevin
 * 修改日期: 2017/3/30
 * 修改内容: 
 */
package com.hengba.test.common;

/**
 * <<算术左移、>>算术右移、>>>逻辑右移
 * x << y  is  x * (2的y次方)
 * x >> y  is  x / (2的y次方)
 * x >>> y  is abc(x / (2的y次方)), 由于符号位补的是0所以始终为正数
 * @author Kevin created on 2017/3/30.
 * @since framework 1.0
 */
public class ShiftingTest {
    public static void main(String[] args) {
        int a = 10;
        System.out.println(a << 2);
        System.out.println(a >>> 1);
        System.out.println(a >>> 2);
        System.out.println(a >>> 3);
        System.out.println(a >>> 4);
        System.out.println(a >>> 5);
        System.out.println("<<<<<<<<<<<");
        for(int i = 1;i<50;i++){
            System.out.println("i:"+i+", "+ (a << i));
        }
    }
}
