/*
 * 文件名称: ReflectUtils.java
 * 版权信息: Copyright 2016-2020 technology Co., LTD. All right reserved.
 * ----------------------------------------------------------------------------------------------
 * 修改历史:
 * ----------------------------------------------------------------------------------------------
 * 修改原因: 新增
 * 修改人员: Kevin
 * 修改日期: 2017/4/14
 * 修改内容: 
 */
package com.hengba.utils.common;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Kevin created on 2017/4/14.
 * @since framework 1.0
 */
public class ReflectUtils {
    /**
     * 获取所有Field（包括父类）
     *
     * @param clazz 类型
     * @return Field列表
     */
    public static List<Field> getAllDeclaredFields(Class<?> clazz) {
        List<Field> list = new ArrayList<>();
        Collections.addAll(list, clazz.getDeclaredFields());
        Class<?> superClass = clazz.getSuperclass();
        if (null != superClass) {
            list.addAll(getAllDeclaredFields(superClass));
        }
        return list;
    }

    /**
     * 获取所有指定注释类型注释过的Field（包括父类）
     *
     * @param clazz      类型
     * @param annotation 注释类型
     * @return Field列表
     */
    public static List<Field> getAnnotationFields(Class<?> clazz, Class<? extends Annotation> annotation) {
        List<Field> result = new ArrayList<>();
        getAllDeclaredFields(clazz).forEach(a -> {
            for (Annotation e : a.getAnnotations()) {
                if (e.annotationType().equals(annotation)) {
                    result.add(a);
                }
            }
        });
        return result;
    }
}
