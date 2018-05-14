package com.hengba.test.common.map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @auther Kevin created on 2017/9/19
 */
public class MapApiTest {
    /**
     * 1.8新增API
     */
    @ParameterizedTest
    @ValueSource(strings = {"hello"})
    void map(String arg) {
        Map<String, String> map = new HashMap<>();
        /*
         * 测试证明此方法是要是缺席就计算，因此这种判断没有才做的逻辑适合与有就不做对应，很适合内存缓存场景
         */
        String before = map.computeIfAbsent("1", a -> arg);
        System.out.println("before: " + before + " , get: " + map.get("1"));
        String beforeA = map.computeIfAbsent("1", a -> "beforeA");
        System.out.println("beforeA: " + beforeA + " , get: " + map.get("1"));

        /*
         * 与computeIfAbsent类似，只不过这个是要是缺席就添加(区别就在于参数直传和参数加工后传)
         */
        String before2 = map.putIfAbsent("2", arg);
        System.out.println("before2: " + before2 + " , get: " + map.get("2"));
        String before2A = map.putIfAbsent("2", "beforeA");
        System.out.println("before2A: " + before2A + " , get: " + map.get("2"));

        /*
         * 与前面两个对立，要是呈现就计算
         */
        String before3 = map.computeIfPresent("2", (k, v) -> "aaa");
        System.out.println("before3: " + before3);
        System.out.println("before3 map: " + map.get("2"));

        String before4 = map.computeIfAbsent("2", a -> "bbb");
        System.out.println("before4: " + before4);
        System.out.println("before4 map: " + map.get("2"));
    }

    @Test
    void testTime() throws ParseException {
        System.out.println("    " + System.currentTimeMillis());
        System.out.println("1 = " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")
                .parse("2017-09-21 14:12:00.000").getTime());
        System.out.println("3 = " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")
                .parse("2017-09-21 11:26:00.000").getTime());
        System.out.println("2 = " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")
                .parse("2017-09-21 11:27:00.000").getTime());
        System.out.println("4 = " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")
                .parse("2017-09-21 11:28:00.000").getTime());
        System.out.println("5 = " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")
                .parse("2017-09-21 11:29:00.000").getTime());
    }

    @Test
    void testFU() {
        A a = new A();
        a.setA(10);
        int result = -a.getA() + 2;
        System.out.println("result: " + result);
    }

    class A {
        int a;

        public int getA() {
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }
    }

    @Test
    void testKeySetAdd(){
        Map<String, Integer> map = new HashMap<>();
//        map.keySet().addAll(Arrays.asList("123","234"));
        map.put("123", 123);
        map.put("234", 234);
//        map.keySet().addAll(Arrays.asList("1123","1234"));
        map.keySet().add("1123");
        System.out.println("aaaaa");
    }

    @Test
    void testNull() {
        Map<String, Integer> map = new HashMap<>();
        map.put("123", 123);
        map.put("234", 234);
        map.put("222", null);
        map.putAll(null);
    }
}
