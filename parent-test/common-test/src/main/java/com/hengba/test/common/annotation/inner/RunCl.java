package com.hengba.test.common.annotation.inner;

import org.apache.commons.lang.reflect.FieldUtils;
import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 目标是测试根据注释自动读取  类对象上的注释过的成员变量的信息（名字，类型，值...)
 *
 * @author Kevin created on 2017/9/27
 */
public class RunCl {
    /**
     * 获取所有被注解过的field列表
     *
     * @param target 目标对象类
     * @param anno   注解类
     * @return field列表
     */
    public static List<Field> getAnnotationField(Class target, Class anno) {
        // 所有field的列表
        List<Field> list = new ArrayList<>();
        // 可以递归方法也可以循环调用
        while (null != target) {
            // 获取所有field的列表，包括目标对象类的父类
            Collections.addAll(list, target.getDeclaredFields());//把数组加到指定集合当中
            target = target.getSuperclass();
        }
        // 过滤哪些field是被指定注解注释过
        return list.stream().filter(a -> {
            for (Annotation an : a.getAnnotations()) {
                if (an.annotationType().equals(anno)) {
                    return true;
                }
            }
            return false;
        }).collect(Collectors.toList());
    }

    /**
     * 这才是第一步
     * 获取了某个类的指定注释的field信息
     */
    @Test
    void showYiXia() {
        getAnnotationField(Bean.class, BabiAnno.class).forEach(a -> {
            BabiAnno b = a.getAnnotation(BabiAnno.class);
            System.out.println(a.getName() + "," + b.name() + "," + b.fieldType().type);
        });
    }

    /**
     * 这才是最终一步
     * 获取 类对象上的注释过的成员变量的信息（名字，类型，值...)
     */
    @Test
    void showLiangXia() {
        Bean bean = new Bean(false, true, false, "18512345678", "Alibaba", 1, "Kevin", 29, true, "ZheJiang");
        getAnnotationField(Bean.class, BabiAnno.class).forEach(a -> {
            try {
                Object obj = FieldUtils.readField(a, bean, true);
                BabiAnno b = a.getAnnotation(BabiAnno.class);
                System.out.println("名字:" + a.getName() + ", 类型:" + b.fieldType().type + ", 值:" + obj);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });
    }
}
