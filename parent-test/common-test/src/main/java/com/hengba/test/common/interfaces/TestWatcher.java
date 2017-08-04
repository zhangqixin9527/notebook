/*
 * 文件名称: TestWatcher.java
 * 版权信息: Copyright 2016-2020 technology Co., LTD. All right reserved.
 * ----------------------------------------------------------------------------------------------
 * 修改历史:
 * ----------------------------------------------------------------------------------------------
 * 修改原因: 新增
 * 修改人员: Kevin
 * 修改日期: 2017/8/1
 * 修改内容: 
 */
package com.hengba.test.common.interfaces;

/**
 * @author Kevin created on 2017/8/1.
 * @since framework 1.0
 */
public class TestWatcher {

    public void doIt(String name, int value){
        Watcher watcher = (a, b) -> {
            System.out.println("name: "+a+", value: "+b);
        };
        watcher.process(name, value*2);
    }

    public void doThat(String name, int value){
        System.out.println("now mini do ni and then nni: ");
        Mini a = new Mini(){
            @Override
            void mi(String name, int value) {
                System.out.println("do mi:");
                ni(name);
                nni(value);
            }
        };
        a.mi(name, value);
    }

    public static void main(String[] args) {
        TestWatcher testWatcher = new TestWatcher();
        testWatcher.doIt("zqx", 10);
        testWatcher.doThat("zyh", 3);
    }
}
