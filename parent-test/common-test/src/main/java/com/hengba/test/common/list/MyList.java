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

import commons.utils.DateUtils;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;

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

        List<Integer> list002 = new ArrayList<>();
        list002.sort((a1, a2) -> a1 - a2);
        System.out.println(list002);
        list002.add(1);
        list002.sort((a1, a2) -> a1 - a2);
        System.out.println(list002);
        list002.add(3);
        list002.add(2);
        list002.sort((a1, a2) -> a1 - a2);
        System.out.println(list002);

        System.out.println(String.format("Batch matchId:%1$s write to mongo, use time: %2$d", "12138", (System.currentTimeMillis() - 0L)));
    }

    @Test
    void testSort(){
        List<Integer> list001 = new ArrayList<>();

        list001.add(10);
        list001.add(1);
        list001.add(2);
        list001.add(5);
        list001.add(7);
        list001.add(3);
        list001.add(4);
        list001.add(9);
        list001.add(8);
        list001.add(6);
        list001.forEach(a -> System.out.println(a));
        System.out.println("===========================");

        list001.sort(Comparator.comparingInt(a -> -a));
        System.out.println(list001);
        List<Integer> subList = list001.stream().limit(5).collect(Collectors.toList());
        System.out.println(subList);

        List<Integer> subList2 = list001.stream().limit(12).collect(Collectors.toList());
        System.out.println(subList2);
    }

    @Test
    void testSortTime(){
        List<String> list001 = new ArrayList<>();

        list001.add("2017-11-13 12:12:12");
        list001.add("2017-11-11 12:12:12");
        list001.add("2017-11-13 12:12:12");
        list001.add("2017-11-13 11:12:12");
        list001.add("2017-10-13 12:12:12");
        list001.add("2017-11-13 12:22:12");
        list001.add("2017-12-13 12:12:12");
        list001.add("2017-11-13 12:12:14");
        list001.add("2017-11-03 12:12:12");
        list001.add("2017-11-13 12:12:13");
        list001.forEach(a -> System.out.println(a));
        System.out.println("===========================");
        String a = list001.stream().max((a1, a2) -> {
            try {
                return Long.compare(DateUtils.parseDate(a1, "yyyy-MM-dd HH:mm:ss").getTime(), DateUtils.parseDate(a2, "yyyy-MM-dd HH:mm:ss").getTime());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return 0;
        }).get();
        System.out.println(a);
    }

    @Test
    void testListPoints(){
        List<Long> maxMids = new ArrayList<>();
        List<Long> currentMids = new ArrayList<>();
        List<Long> tempContinoustMids = new ArrayList<>();

        tempContinoustMids.add(1L);
        tempContinoustMids.add(2L);
        tempContinoustMids.add(3L);

        currentMids = tempContinoustMids;
        maxMids = tempContinoustMids;

        System.out.println("===== temp =====");
        tempContinoustMids.forEach(a-> System.out.println(a));
        System.out.println("===== currentMids pointed =====");
        currentMids.forEach(a -> System.out.println(a));
        System.out.println("===== maxMids pointed =====");
        maxMids.forEach(a -> System.out.println(a));

        System.out.println("===== now temp point changed =====");
        tempContinoustMids.clear();
        System.out.println("===== now currentMids =====");
        currentMids.forEach(a -> System.out.println(a));
        System.out.println("===== now maxMids =====");
        maxMids.forEach(a -> System.out.println(a));
        System.out.println("===== temp =====");
        tempContinoustMids.forEach(a-> System.out.println(a));
    }
}
