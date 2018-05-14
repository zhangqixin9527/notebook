package com.hengba.test.common;

import org.junit.jupiter.api.Test;

/**
 * @author Kevin created on 2018/4/9
 */
public class StringTest {
    @Test
    void testStringFormat(){
        String template = "abc %1$s fg %2$s jklm %3$s";
        String template1 = String.format(template, "de", "%2$s", "%3$s");
        System.out.println(template1);
        String template2 = String.format(template1, "", "ghi", "%3$s");
        System.out.println(template2);
        System.out.println(String.format(template2, null,"","nopqrstuvwxyz"));
    }
}
