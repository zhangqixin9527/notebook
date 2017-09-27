/*
 * 文件名称: A.java
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
public class A {
    private int a;

    public int getA() {
        return a;
    }

    public A setA(int a) {
        this.a = a;
        return this;
    }

    public static class B{
        private int b;

        public int getB() {
            return b;
        }

        public B setB(int b) {
            this.b = b;
            return this;
        }
    }
}
