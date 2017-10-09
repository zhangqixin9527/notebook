package com.hengba.rocketmq.consumer;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.junit.jupiter.api.Test;

/**
 * @author Kevin created on 2017/10/9
 */
public class Consumer {
    /**
     * push方式消费
     */
    @Test
    void defaultPushConsumer() throws MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("test001");
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        consumer.setNamesrvAddr("localhost:9876");
        consumer.subscribe("testTopic001", "*");
        /*
         * 注册回调函数(如果fetch from broker到message则执行回调)
         */
        consumer.registerMessageListener((MessageListenerConcurrently) (msgs, context) -> {
            System.out.printf(Thread.currentThread().getName() + " receive: " + msgs + "%n");
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        });
        /*
         * 发射消费实例
         */
        consumer.start();
        System.out.println("consumer start ... ");
        while (true){}
    }
}
