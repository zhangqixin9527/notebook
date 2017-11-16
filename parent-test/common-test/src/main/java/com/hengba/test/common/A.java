package com.hengba.test.common;

import org.junit.jupiter.api.Test;

/**
 * @author Kevin created on 2017/10/11
 */
public class A {
    @Test
    void test001(){
        int i=0,j=0;
        while (i++ < 10){
            System.out.println(i);
        }
    }

    @Test
    void test002(){
        int i=0;
        while (true){
            if(i++ == 10)break;
            System.out.println(i);
        }
    }

    @Test
    void test003(){
        String a = "-96470.45";
        String b = "-96470";
        System.out.println(a.split("\\.")[0]);
        System.out.println(b.split("\\.")[0]);
    }
}
