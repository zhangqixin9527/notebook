/*
 * 文件名称: KafkaProducerService.java
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

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

import static com.hengba.kafka.Constants.*;
import static org.apache.kafka.clients.producer.ProducerConfig.*;

/**
 * @author Kevin created on 2017/8/2.
 * @since framework 1.0
 */
public class KafkaProducerService {
    private Producer<String, String> producer;

    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", BOOTSTRAP_SERVERS);
        properties.put("acks", "all");
        properties.put("retries", "0");
        properties.put("linger.ms", "1");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("partitioner.class", KafkaPartitioner.class);
        Producer<String, String> producer = new KafkaProducer<>(properties);
        producer.send(new ProducerRecord<String, String>(TOPIC, "ahjkll", "olololololol"));
        while (true){}
    }

    public void init(){
        Properties properties = new Properties();
        properties.put(BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
        properties.put(ACKS_CONFIG, ACKS);
        properties.put(RETRIES_CONFIG, RETRIES);
        properties.put(LINGER_MS_CONFIG, LINGER_MS);
        properties.put(KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(PARTITIONER_CLASS_CONFIG, KafkaPartitioner.class);
        producer = new KafkaProducer(properties);
    }


    public void send(String key, String value){
        producer.send(new ProducerRecord(TOPIC,  key, value));
    }
}
