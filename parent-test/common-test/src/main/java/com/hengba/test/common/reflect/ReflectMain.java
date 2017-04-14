/*
 * 文件名称: ReflectMain.java
 * 版权信息: Copyright 2016-2020 technology Co., LTD. All right reserved.
 * ----------------------------------------------------------------------------------------------
 * 修改历史:
 * ----------------------------------------------------------------------------------------------
 * 修改原因: 新增
 * 修改人员: Kevin
 * 修改日期: 2017/4/14
 * 修改内容: 
 */
package com.hengba.test.common.reflect;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Kevin created on 2017/4/14.
 * @since framework 1.0
 */
public class ReflectMain {
    public static void main(String[] args) {
        for(Field field : Icebox.class.getDeclaredFields()){
            System.out.println("==>"+field.getName()+", type is:"+field.getType());
        }
        System.out.println("===============================");
        getAllDeclaredFields(Icebox.class).forEach(a -> {
            System.out.println("==>"+a.getName()+", type is:"+a.getType());
        });
        System.out.println("===============================");
        getAllDeclaredFields(NullClass.class).forEach(a -> {
            System.out.println("==>"+a.getName()+", type is:"+a.getType());
        });
    }

    public static List<Field> getAllDeclaredFields(Class<?> clazz){
        List<Field> list = new ArrayList<>();
        Collections.addAll(list, clazz.getDeclaredFields());
        Class<?> superClass = clazz.getSuperclass();
        if(null != superClass){
            list.addAll(getAllDeclaredFields(superClass));
        }
        return list;
    }
}
