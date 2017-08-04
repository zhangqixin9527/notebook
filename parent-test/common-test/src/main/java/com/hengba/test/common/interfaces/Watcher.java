package com.hengba.test.common.interfaces;

/**
 * @author Kevin created on 2017/8/1.
 * @since framework 1.0
 */
@FunctionalInterface
public interface Watcher {
    void process(String name, int value);

//    void processPP(String name, int value);
//    @FunctionalInterface
//    enum A{
//        A,B,C
//    }
//
//    @FunctionalInterface
//    abstract class AA{
//        private String A;
//
//        abstract void show();
//    }
}
