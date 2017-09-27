package com.hengba.test.common.annotation.inner;

/**
 * 字段类型
 * @author Kevin created on 2017/9/27
 */
public enum FieldType {
    STRING(1, "string", "字符串"),
    INTEGER(2, "integer", "整型"),
    DOUBLE(3, "double", "浮点型"),
    BOOLEAN(4, "boolean", "布尔型");

    FieldType(int code, String type, String desc){
        this.code = code;
        this.type = type;
        this.desc = desc;
    }

    int code;
    String type;
    String desc;
}
