/*
 * 文件名称: Constants.java
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

/**
 * @author Kevin created on 2017/8/2.
 * @since framework 1.0
 */
public class Constants {
//    public static final String BOOTSTRAP_SERVERS = "10.33.97.191:9092";
    public static final String BOOTSTRAP_SERVERS = "192.168.137.82:9092,192.168.137.87:9092,192.168.137.89:9092,192.168.137.90:9092";
    public static final String ACKS = "all";
    public static final String RETRIES = "0";
    public static final String LINGER_MS = "1";
    public static final String GROUP_ID = "group1";
//    public static final String TOPIC = "WoLong";
//    public static final String ZOOKEEPER_URL = "10.33.97.191:2181";
    public static final String TOPIC = "test01";
    public static final String ZOOKEEPER_URL = "192.168.137.87:2181,192.168.137.89:2181,192.168.137.90:2181/kafka";
    public static final int ZOOKEEPER_SESSION_TIMEOUT = 30000;
    public static final int ZOOKEEPER_CONNECTION_TIMEOUT = 30000;

    public static final int KAFKA_PARTITIONS = 3;
    public static final int KAFKA_REPLICATIONS = 1;
}
