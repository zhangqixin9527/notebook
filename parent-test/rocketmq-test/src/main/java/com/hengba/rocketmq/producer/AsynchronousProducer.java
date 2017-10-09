package com.hengba.rocketmq.producer;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;

/**
 * 异步生产
 *
 * @author Kevin created on 2017/9/28
 */
public class AsynchronousProducer {

    @Test
    void sendAsyncMsg() throws MQClientException, UnsupportedEncodingException, RemotingException, InterruptedException {
        DefaultMQProducer producer = new DefaultMQProducer("test001");
        producer.setNamesrvAddr("localhost:9876");
        producer.start();
        for (int i = 0; i < 10; i++) {
            Message message = new Message("testTopic001", ("Hi rocketMQ " + i).getBytes(RemotingHelper.DEFAULT_CHARSET));
            producer.send(message, new SendCallback() {
                @Override
                public void onSuccess(SendResult sendResult) {
                    System.out.println("ASYNC == " + sendResult);
                }

                @Override
                public void onException(Throwable e) {

                }
            });
        }
        producer.shutdown();
    }
}
