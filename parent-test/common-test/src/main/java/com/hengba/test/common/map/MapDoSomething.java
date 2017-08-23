/*
 * 文件名称: MapDoSomething.java
 * 版权信息: Copyright 2016-2020 technology Co., LTD. All right reserved.
 * ----------------------------------------------------------------------------------------------
 * 修改历史:
 * ----------------------------------------------------------------------------------------------
 * 修改原因: 新增
 * 修改人员: Kevin
 * 修改日期: 2017/8/18
 * 修改内容: 
 */
package com.hengba.test.common.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Kevin created on 2017/8/18.
 * @since framework 1.0
 */
public class MapDoSomething {
    public static void main(String[] args) {
        /*
         * 遍历map把其value值都加1
         */
        Map<String, Integer> map001 = new HashMap<>();
        map001.put("张三", 22);
        map001.put("李四", 26);
        map001.put("王五", 31);
        map001.put("赵六", 25);
        map001.forEach((k, v) -> System.out.println(k+" = "+v));
        map001.entrySet().forEach(a -> a.setValue(a.getValue() + 1));
        System.out.println("============= 分隔线 =============");
        map001.forEach((k, v) -> System.out.println(k+" = "+v));

        System.out.println("============= 大分隔线 =============");
        /*
         * 创建一个新的map，key由原来的key组成，value类型改变
         */
        Map<String, String> map002 = new HashMap<>();
        map001.forEach((k, v) -> map002.computeIfAbsent(k, s -> String.valueOf(v) + "XX"));
        map002.forEach((k, v) -> System.out.println(k+" = "+v));

        System.out.println("============= 大分隔线 =============");
        Map<String, String> map003 = new HashMap<>();
        map003.put("aa", "22");
        map003.put("bb", "21");
        map003.put("cc", "29");
        map003.putAll(map002);
        map003.putAll(map002);
        map003.clear();
        map003.forEach((k, v) -> System.out.println(k+" = "+v));
    }
}
