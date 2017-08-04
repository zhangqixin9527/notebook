/*
 * 文件名称: KafkaConsumerService.java
 * 版权信息: Copyright 2016-2020 technology Co., LTD. All right reserved.
 * ----------------------------------------------------------------------------------------------
 * 修改历史:
 * ----------------------------------------------------------------------------------------------
 * 修改原因: 新增
 * 修改人员: Kevin
 * 修改日期: 2017/8/2
 * 修改内容: 
 */
package com.hengba.kafka;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Collections;
import java.util.Properties;

import static com.hengba.kafka.Constants.*;
import static org.apache.kafka.clients.consumer.ConsumerConfig.*;

/**
 * @author Kevin created on 2017/8/2.
 * @since framework 1.0
 */
public class KafkaConsumerService {
    private KafkaConsumer<String, String> consumer;

    public void init(){
        Properties properties = new Properties();
        properties.put(BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
        properties.put(KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put(VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put(GROUP_ID_CONFIG, GROUP_ID);
        consumer = new KafkaConsumer(properties);
    }

    public void subscribe(String topic){
        consumer.subscribe(Collections.singletonList(topic));
        while(true){
            consumer.poll(100000).forEach(a-> {
                System.out.println(a.key()+"\t"+a.value());
            });
        }
    }

    public static void main(String[] args) {
        KafkaConsumerService service = new KafkaConsumerService();
        service.init();
        service.subscribe(TOPIC);
    }
}
