/*
 * 文件名称: Test001.java
 * 版权信息: Copyright 2016-2020 technology Co., LTD. All right reserved.
 * ----------------------------------------------------------------------------------------------
 * 修改历史:
 * ----------------------------------------------------------------------------------------------
 * 修改原因: 新增
 * 修改人员: Kevin
 * 修改日期: 2017/4/14
 * 修改内容: 
 */
package com.hengba.utils.common.test;

import com.hengba.utils.common.ArithUtils;
import com.hengba.utils.common.ReflectUtils;
import org.junit.Test;

/**
 * @author Kevin created on 2017/4/14.
 * @since framework 1.0
 */
public class Test001 {
    @Test
    public void getAllDeclaredFieldsTest(){
        ReflectUtils.getAllDeclaredFields(Icebox.class).forEach(a -> {
            System.out.println("==name: "+a.getName()+" ,type "+a.getType());
        });
    }

    @Test
    public void getAnnotationFieldsTest(){
        ReflectUtils.getAnnotationFields(Bean.class, TableColumnAnnotation.class).forEach(a -> {
            System.out.println("==name: "+a.getName()+", type: "+a.getType());
        });
    }

    @Test
    public void arith(){
        System.out.println(ArithUtils.divide(12, 24, 2));
    }
}
