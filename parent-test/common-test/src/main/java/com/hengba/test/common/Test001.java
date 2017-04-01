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

/**
 * @author Kevin created on 2017/4/1.
 * @since framework 1.0
 */
public class Test001 {
    public static void main(String[] args) {
        Class<?> clazz = Test001.class;
        String classContainer = clazz.getProtectionDomain().getCodeSource()
                .getLocation().toString();
        System.out.println("==>"+classContainer);
    }
}
