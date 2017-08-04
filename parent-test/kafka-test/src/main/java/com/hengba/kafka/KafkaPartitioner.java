/*
 * 文件名称: KafkaPartitioner.java
 * 版权信息: Copyright 2016-2020 technology Co., LTD. All right reserved.
 * ----------------------------------------------------------------------------------------------
 * 修改历史:
 * ----------------------------------------------------------------------------------------------
 * 修改原因: 新增
 * 修改人员: Kevin
 * 修改日期: 2017/7/13
 * 修改内容: 
 */
package com.hengba.kafka;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;

import java.util.Map;

/**
 * @author Kevin created on 2017/7/13.
 * @since framework 1.0
 */
public class KafkaPartitioner implements Partitioner {

    @Override
    public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {
        Integer partitionNum = cluster.partitionCountForTopic(topic);
        if (null != partitionNum) {
            return Math.abs(value.hashCode()) % partitionNum;
        } else {
            return 0;
        }
    }

    @Override
    public void close() {

    }

    @Override
    public void configure(Map<String, ?> map) {

    }

}
