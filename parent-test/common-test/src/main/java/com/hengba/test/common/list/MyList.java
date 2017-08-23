/*
 * 文件名称: MyList.java
 * 版权信息: Copyright 2016-2020 technology Co., LTD. All right reserved.
 * ----------------------------------------------------------------------------------------------
 * 修改历史:
 * ----------------------------------------------------------------------------------------------
 * 修改原因: 新增
 * 修改人员: Kevin
 * 修改日期: 2017/8/21
 * 修改内容: 
 */
package com.hengba.test.common.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kevin created on 2017/8/21.
 * @since framework 1.0
 */
public class MyList {
    public static void main(String[] args) {
        List<String> list001 = new ArrayList<>();
        list001.add("1");
        list001.add("2");
        list001.add("3");
        list001.add("4");
        list001.add("5");
        list001.add("6");
        list001.add("7");
        list001.add("8");
        list001.add("9");
        list001.add("10");

        list001.forEach(a -> System.out.println(a));
        System.out.println("===========================");
        list001.stream().forEachOrdered(a -> System.out.println(a));
    }
}
