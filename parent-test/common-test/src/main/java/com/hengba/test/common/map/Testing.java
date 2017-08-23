/*
 * 文件名称: Testing.java
 * 版权信息: Copyright 2016-2020 technology Co., LTD. All right reserved.
 * ----------------------------------------------------------------------------------------------
 * 修改历史:
 * ----------------------------------------------------------------------------------------------
 * 修改原因: 新增
 * 修改人员: Kevin
 * 修改日期: 2017/8/15
 * 修改内容: 
 */
package com.hengba.test.common.map;

import java.util.*;

/**
 * @author Kevin created on 2017/8/15.
 * @since framework 1.0
 */
public class Testing {
    public static void main(String[] args) {


        HashMap<String, Integer> map = new HashMap<>();
        /*
         * 构造比较器
         * 这边体现了TreeMap自定义比较器的一个局限性
         * 就拿此例举例：（根据value值大小按降序排）
         * 由于TreeMap构造器中传的Comparator只能获取key的值，想要满足value排序，那么我们要定制一个排序模板。
         * 1. 匿名内部类或者单独写的公共类实现Comparator接口，加入排序模板map,其实就是TreeMap中要存入的数据
         * 2. 实现其compare方法时，根据map和key找到对应value -> 比较排序
         *
         * 总结：这边的排序是事先知道要存的数据，这样就是要额外定义一个map开销内存，putAll数据转移开销计算，此法不可取
         */
        ValueComparator bvc = new ValueComparator(map);
        /*
         * TreeMap是有序的，可以通过构造行数传递排序规则
         * 但是这种有序是内部存储的数据有序，对外提供的遍历API很是奇葩
         * No1. 遍历keySet,根据key获取value，那么得到的还是原来的顺序，因为keySet是无序的
         * No2. 同上一样直接调用foreach函数
         * No3. 通过pollFirstEntry || pollLastEntry这样可以获取有效顺序，缺点是破坏了原来map的数据
         */
        TreeMap<String, Integer> sorted_map = new TreeMap<>(bvc);
        map.put("A", 99);
        map.put("B", 67);
        map.put("C", 68);
        map.put("D", 88);
        System.out.println("unsorted map: " + map);
        /*
         * 笨拙的排序方法，需要先遍历一遍插入到有序的列表中 -> 列表排序 -> 输出列表
         * 总结：此法和上面的一样，额外list开销内存，遍历赋值开销计算，亦不可取
         */
        List<Map.Entry<String, Integer>> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()){
            list.add(entry);
        }
        Collections.sort(list, (a1, a2) -> a2.getValue() - a1.getValue());
        System.out.println("unsorted map change: " + list);

        // 添加数据
        sorted_map.putAll(map);
//        System.out.println("results: " + sorted_map);
//        Map.Entry<String, Integer> sample;
//        while ((sample = sorted_map.pollFirstEntry()) != null){
//            System.out.println("***"+sample.getKey() + " = " +sample.getValue());
//        }

        Iterator ir=sorted_map.keySet().iterator();//获取hashMap的键值，并进行遍历
        while(ir.hasNext()){

            Object key= ir.next();
            System.out.println("键为"+key+"所对应的值为"+map.get(key));
        }

//        Map<String, Integer> sortedMap = new TreeMap<String, Integer>(new Comparator<String, Integer>() {
//            @Override
//            public int compare(String o1, String o2) {
//                System.out.println("o1: "+o1+", o2: "+o2);
//                return 0;
//            }
//        });
//        sortedMap.putAll(map);
    }
}

class ValueComparator implements Comparator<String> {

    Map<String, Integer> base;

    //这里需要将要比较的map集合传进来
    public ValueComparator(Map<String, Integer> base) {
        this.base = base;
    }

    // Note: this comparator imposes orderings that are inconsistent with equals.
    //比较的时候，传入的两个参数应该是map的两个key，根据上面传入的要比较的集合base，可以获取到key对应的value，然后按照value进行比较
    public int compare(String a, String b) {
        if (base.get(a) >= base.get(b)) {
            return -1;
        } else {
            return 1;
        } // returning 0 would merge keys
    }
}
