/*
 * 文件名称: ATest.java
 * 版权信息: Copyright 2016-2020 technology Co., LTD. All right reserved.
 * ----------------------------------------------------------------------------------------------
 * 修改历史:
 * ----------------------------------------------------------------------------------------------
 * 修改原因: 新增
 * 修改人员: Kevin
 * 修改日期: 2017/9/6
 * 修改内容: 
 */
package com.hengba.test.common.staticC;

/**
 * @author Kevin created on 2017/9/6.
 * @since framework 1.0
 */
public class ATest {
    public static void main(String[] args) {
        A a = new A();
        A.B b = new A.B();
        b.setB(99);
        System.out.println("B b: "+b.getB());
    }
}