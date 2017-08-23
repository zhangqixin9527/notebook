/*
 * 文件名称: SetCommon.java
 * 版权信息: Copyright 2016-2020 technology Co., LTD. All right reserved.
 * ----------------------------------------------------------------------------------------------
 * 修改历史:
 * ----------------------------------------------------------------------------------------------
 * 修改原因: 新增
 * 修改人员: Kevin
 * 修改日期: 2017/8/22
 * 修改内容: 
 */
package com.hengba.test.common.set;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Kevin created on 2017/8/22.
 * @since framework 1.0
 */
public class SetCommon {
    public static void main(String[] args) {
        Set<String> set001 = new HashSet<>();
        set001.add("123");
        set001.add("234");
        set001.add("345");
        System.out.println("set001: "+set001);
        set001.add("234");
        System.out.println("after adding 234, set001: "+set001);
    }
}
