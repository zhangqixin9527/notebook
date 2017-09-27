package com.hengba.test.common.annotation.inner;

/**
 * 接口不是父类
 * @author Kevin created on 2017/9/27
 */
public interface BeanIface {
    @BabiAnno(name = "abc", fieldType = FieldType.INTEGER)
    int abc = 10;

    void sayABC();
}
