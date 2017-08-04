/*
 * 文件名称: Mini.java
 * 版权信息: Copyright 2016-2020 technology Co., LTD. All right reserved.
 * ----------------------------------------------------------------------------------------------
 * 修改历史:
 * ----------------------------------------------------------------------------------------------
 * 修改原因: 新增
 * 修改人员: Kevin
 * 修改日期: 2017/8/2
 * 修改内容: 
 */
package com.hengba.test.common.interfaces;

/**
 * @author Kevin created on 2017/8/2.
 * @since framework 1.0
 */
public abstract class Mini {

    abstract void mi(String name, int value);

    void ni(String name){
        System.out.println("I'm "+name);
    }

    void nni(int value){
        System.out.println("** "+value);
    }
}
