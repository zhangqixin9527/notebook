package com.hengba.utils.common.test;

import java.lang.annotation.*;

/**
 * @author Kevin created on 2017/4/14.
 * @since framework 1.0
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TableColumnAnnotation {
    String name() default "id";

    FieldType type() default FieldType.STRING;
}
