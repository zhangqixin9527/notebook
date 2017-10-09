package com.hengba.rocketmq.producer;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;

/**
 * 单路生产  发送给单个broker
 *
 * @author Kevin created on 2017/9/28
 */
public class OneWayTranProducer {
    @Test
    void sendOneWay() throws MQClientException, UnsupportedEncodingException, RemotingException, InterruptedException {
        DefaultMQProducer producer = new DefaultMQProducer("test002");
        producer.setNamesrvAddr("localhost:9876");
        producer.start();
        for (int i = 0; i < 10; i++) {
            Message message = new Message("testTopic002", ("Ni hao " + i).getBytes("UTF-8"));
            producer.sendOneway(message);
            System.out.println();
        }
        producer.shutdown();
    }
}
