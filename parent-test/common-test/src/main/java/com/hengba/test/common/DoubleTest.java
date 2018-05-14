package com.hengba.test.common;


import org.junit.jupiter.api.Test;

/**
 * @author Kevin created on 2018/4/9
 */
public class DoubleTest {
    @Test
    void test2String() {
        Double a = new Double(2.222);
        double a1 = 3.333;
        String a2String = a.toString();
        String aOfString = String.valueOf(a);
        System.out.println("a2String: " + a2String + ", aOfString: " + aOfString);
    }
}
