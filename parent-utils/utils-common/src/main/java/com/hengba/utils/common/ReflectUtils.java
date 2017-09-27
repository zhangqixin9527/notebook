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

import org.apache.commons.lang3.reflect.FieldUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.*;

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

    /**
     * 获取某X类型某个对象，被注释过的成员变量的名字-值映射Map
     * 1. clazz类型
     * 2. annotation注释类型
     * 3. clazz类型的对象 target
     * 4. 返回 Map
     *
     * @param clazz      指定类
     * @param annotation 注释类
     * @param target     目标对象
     * @return 名字(类成员变量名)、值 映射map
     */
    public static Map<String, Object> getAnnotationNameValueMap(Class<?> clazz, Class<? extends Annotation> annotation, Object target) {
        Map<String, Object> result = new HashMap<>();
        getAnnotationFields(clazz, annotation).forEach(a ->
            result.computeIfAbsent(a.getName(), b -> {
                try {
                    return FieldUtils.readField(a, target, true);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                return null;
            }));
        return result;
    }
}
