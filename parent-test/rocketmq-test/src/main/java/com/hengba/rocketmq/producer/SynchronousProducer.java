package com.hengba.rocketmq.producer;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;

/**
 * 同步生产
 * @author Kevin created on 2017/9/28
 */
public class SynchronousProducer {

    @Test
    void syncSendMsg() throws MQClientException, UnsupportedEncodingException, RemotingException, InterruptedException, MQBrokerException {
        DefaultMQProducer producer = new DefaultMQProducer("123-456-789");
        producer.setNamesrvAddr("localhost:9876");
        producer.start();
        for (int i = 0; i < 10; i++) {
            Message message = new Message("TopicTest","TagA", ("Hello rocketMQ " + i).getBytes(RemotingHelper.DEFAULT_CHARSET));
            SendResult result = producer.send(message);
            System.out.println("== " + result);
        }
        producer.shutdown();
    }
}
