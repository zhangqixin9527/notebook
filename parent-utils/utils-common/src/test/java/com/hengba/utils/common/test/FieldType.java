/*
 * 文件名称: TableEnum.java
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

/**
 * @author Kevin created on 2017/4/14.
 * @since framework 1.0
 */
public enum FieldType {
    BOOLEAN("boolean", 1, "布尔类型"),
    INTEGER("integer", 2, "整形"),
    FLOAT("float", 3, "浮点类型"),
    STRING("string", 4, "字符串类型");


    FieldType(String s, int i, String 布尔类型) {
        this.kind = s;
        this.code = i;
        this.description = 布尔类型;
    }

    private String kind;

    private int code;

    private String description;

    public String getKind() {
        return kind;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
