package com.hengba.test.common.reflect;

import commons.utils.CharacterUtils;

import java.util.List;

public class Clazz {
    public static void main(String[] args) {
        testClassMethod();
        testPrintWriter();
    }

    public static void testClassMethod() {
        Class<?> clazz = Clazz.class;
        String classContainer = clazz.getProtectionDomain().getCodeSource()
                .getLocation().toString();
        System.out.println("==>"+classContainer);
    }

    public static void testPrintWriter() {
        List<String> list = null;
        try{
            list.add("test");
        } catch (Throwable e){
            System.out.println(CharacterUtils.printStackTrace(e));
        }
    }
}
