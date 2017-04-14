/*
 * 文件名称: TestMain.java
 * 版权信息: Copyright 2016-2020 technology Co., LTD. All right reserved.
 * ----------------------------------------------------------------------------------------------
 * 修改历史:
 * ----------------------------------------------------------------------------------------------
 * 修改原因: 新增
 * 修改人员: Kevin
 * 修改日期: 2017/4/14
 * 修改内容: 
 */
package com.hengba.test.common.annotation;

import commons.utils.ReflectUtils;

import java.lang.reflect.Field;
import java.util.List;

/**
 * @author Kevin created on 2017/4/14.
 * @since framework 1.0
 */
public class TestMain {
    public static void main(String[] args) {
        List<Field> list = ReflectUtils.getAnnotationField(Bean.class, TableColumnAnnotation.class);
        list.forEach(a -> {
            System.out.println(a.getName());
            TableColumnAnnotation annotation = a.getAnnotation(TableColumnAnnotation.class);
            System.out.println("name: "+ annotation.name()+ ",type: " +annotation.type().getKind()+"-"+annotation.type().getCode()+"-"+annotation.type().getDescription());
            System.out.println("======");
        });
    }
}
