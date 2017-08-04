/*
 * 文件名称: Test.java
 * 版权信息: Copyright 2016-2020 technology Co., LTD. All right reserved.
 * ----------------------------------------------------------------------------------------------
 * 修改历史:
 * ----------------------------------------------------------------------------------------------
 * 修改原因: 新增
 * 修改人员: Kevin
 * 修改日期: 2017/7/26
 * 修改内容: 
 */
package com.hengba.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;

import java.util.concurrent.TimeUnit;

/**
 * @author Kevin created on 2017/7/26.
 * @since framework 1.0
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
//        String a="";a += "bb";
//        System.out.println(a);
        AdminUtilsService adminUtilsService = new AdminUtilsService();
        adminUtilsService.createTopic();
//        KafkaConsumerService consumerService = new KafkaConsumerService();
//        consumerService.init();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                consumerService.subscribe(Constants.TOPIC);
//            }
//        }).start();
        KafkaProducerService producerService = new KafkaProducerService();
        producerService.init();

        for(int i=0;i<10;i++){
            producerService.send("zyh", "ababababaab");
        }
        while (true){}
    }
}
