/*
 * 文件名称: BarWork2.java
 * 版权信息: Copyright 2016-2020 technology Co., LTD. All right reserved.
 * ----------------------------------------------------------------------------------------------
 * 修改历史:
 * ----------------------------------------------------------------------------------------------
 * 修改原因: 新增
 * 修改人员: Kevin
 * 修改日期: 2017/7/18
 * 修改内容: 
 */
package com.hengba.test.common;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author Kevin created on 2017/7/18.
 * @since framework 1.0
 */
public class BarWorker2 implements Runnable {

    private static AtomicBoolean exists = new AtomicBoolean(false);


    private String name;

    public BarWorker2(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        if (exists.compareAndSet(false, true)) {

            System.out.println(name + " enter");
            try {
                System.out.println(name + " working");
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                // do nothing
            }
            System.out.println(name + " leave");
            exists.set(false);
        } else {
            System.out.println(name + " give up");
        }

    }


    public static void main(String[] args) {

        BarWorker2 bar1 = new BarWorker2("bar1");
        BarWorker2 bar2 = new BarWorker2("bar2");
        BarWorker2 bar3 = new BarWorker2("bar3");
        new Thread(bar1).start();
        new Thread(bar2).start();
        Thread bar33 = new Thread(bar3);
        try {
            bar33.sleep(3000L);
            bar33.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


}
