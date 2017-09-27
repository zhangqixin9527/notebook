/*
 * 文件名称: Bean.java
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
public class Bean {
    @TableColumnAnnotation
    private String id;

    @TableColumnAnnotation(name = "o_name")
    private String name;

    @TableColumnAnnotation(name = "o_age", type = FieldType.INTEGER)
    private int age;

    @TableColumnAnnotation(name = "o_sex", type = FieldType.BOOLEAN)
    private boolean sex;

    @TableColumnAnnotation(name = "o_money", type = FieldType.FLOAT)
    private float money;

    private String who;
    private String operation;
    private int count;

    public Bean setId(String id) {
        this.id = id;
        return this;
    }

    public Bean setName(String name) {
        this.name = name;
        return this;
    }

    public Bean setAge(int age) {
        this.age = age;
        return this;
    }

    public Bean setSex(boolean sex) {
        this.sex = sex;
        return this;
    }

    public Bean setMoney(float money) {
        this.money = money;
        return this;
    }

    public Bean setWho(String who) {
        this.who = who;
        return this;
    }

    public Bean setOperation(String operation) {
        this.operation = operation;
        return this;
    }

    public Bean setCount(int count) {
        this.count = count;
        return this;
    }
}
