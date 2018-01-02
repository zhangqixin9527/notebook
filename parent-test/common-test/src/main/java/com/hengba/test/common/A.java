package com.hengba.test.common;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.BitSet;

/**
 * @author Kevin created on 2017/10/11
 */
public class A {
    @Test
    void test001(){
        int i=0;
        while (i++ < 10){
            System.out.println(i);
        }
    }

    @Test
    void test002(){
        int i=0;
        while (true){
            if(i++ == 10) {
                break;
            }
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

    @Test
    void test004() throws ParseException {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse("2017-12-06 00:00:00.000").getTime());
    }



    public static void main(String[] args) {
        int [] array = new int [] {1,2,3,22,0,3};
        BitSet bitSet  = new BitSet(6);
        //将数组内容组bitmap
        for(int i=0;i<array.length;i++)
        {
            bitSet.set(array[i], true);
        }
        System.out.println(bitSet.size());
        System.out.println(bitSet.get(4));
        System.out.println(bitSet.get(3));
    }
}
