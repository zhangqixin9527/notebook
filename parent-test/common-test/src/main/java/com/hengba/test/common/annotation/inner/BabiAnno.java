package com.hengba.test.common.annotation.inner;

import java.lang.annotation.*;

/**
 * 注释
 * @author Kevin created on 2017/9/27
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface BabiAnno {
    String name() default "id";

    FieldType fieldType() default FieldType.STRING;
}
