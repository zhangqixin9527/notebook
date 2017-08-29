/*
 * 文件名称: Test001.java
 * 版权信息: Copyright 2016-2020 technology Co., LTD. All right reserved.
 * ----------------------------------------------------------------------------------------------
 * 修改历史:
 * ----------------------------------------------------------------------------------------------
 * 修改原因: 新增
 * 修改人员: Kevin
 * 修改日期: 2017/4/1
 * 修改内容: 
 */
package com.hengba.test.common;

import commons.utils.CharacterUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author Kevin created on 2017/4/1.
 * @since framework 1.0
 */
public class Test001 {
    public static void main(String[] args) {
//        testClassMethod();
//        testPrintWriter();
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date(1503302695860L)));
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date(1503389162027L)));

        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date(1503905109418L)));

        System.out.println(System.currentTimeMillis());
        System.out.println(System.currentTimeMillis());
        System.out.println(System.currentTimeMillis());

    }

    public static void testClassMethod() {
        Class<?> clazz = Test001.class;
        String classContainer = clazz.getProtectionDomain().getCodeSource()
                .getLocation().toString();
        System.out.println("==>"+classContainer);
    }

    public static void testPrintWriter() {
        List<String> list = null;
        try{
            list.add("test");
        } catch (Throwable e){
            CharacterUtils.printStackTrace(e);
        }
    }
}
