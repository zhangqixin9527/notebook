/*
 * 文件名称: TypeDistinguish.java
 * 版权信息: Copyright 2016-2020 technology Co., LTD. All right reserved.
 * ----------------------------------------------------------------------------------------------
 * 修改历史:
 * ----------------------------------------------------------------------------------------------
 * 修改原因: 新增
 * 修改人员: Kevin
 * 修改日期: 2017/4/25
 * 修改内容: 
 */
package com.hengba.test.common;

/**
 * @author Kevin created on 2017/4/25.
 * @since framework 1.0
 */
public class TypeDistinguish {
    public static void main(String[] args) {
        int a = 2;
        Integer aa = 3;
        Object c = a;
        boolean d = true;
        Object dd = d;
        if(c instanceof java.lang.Integer){
            System.out.println("a instance Integer");
        }
        if(c.getClass() == Integer.TYPE){
            System.out.println("a is Integer");
        }
        if(dd instanceof java.lang.Boolean){
            System.out.println("dd instance Boolean");
        }
        if(dd.getClass() == Boolean.TYPE){
            System.out.println("dd is Boolean");
        }

        System.out.println("=============================");
        test(Integer.parseInt("1"));
        test(Integer.valueOf("1"));
    }

    public static void test(int a){
        System.out.println("==: "+a);
    }
}
