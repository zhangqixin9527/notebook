package com.hengba.test.common.annotation;

/**
 * @author Kevin created on 2017/4/14.
 * @since framework 1.0
 */
public class A {
    private static A ourInstance = new A();

    public static A getInstance() {
        return ourInstance;
    }

    private A() {
    }
}
