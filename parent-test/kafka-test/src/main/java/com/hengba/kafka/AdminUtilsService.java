/*
 * 文件名称: AdminUtilsService.java
 * 版权信息: Copyright 2016-2020 technology Co., LTD. All right reserved.
 * ----------------------------------------------------------------------------------------------
 * 修改历史:
 * ----------------------------------------------------------------------------------------------
 * 修改原因: 新增
 * 修改人员: Kevin
 * 修改日期: 2017/8/3
 * 修改内容: 
 */
package com.hengba.kafka;

import kafka.admin.AdminUtils;
import kafka.server.ConfigType;
import kafka.utils.ZkUtils;
import org.apache.kafka.common.security.JaasUtils;
import org.slf4j.Logger;
import scala.Function1;
import scala.Tuple2;

import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import static com.hengba.kafka.Constants.*;

/**
 * @author Kevin created on 2017/8/3.
 * @since framework 1.0
 */
public class AdminUtilsService {
    public void createTopic() {
        ZkUtils zkUtils = ZkUtils.apply(ZOOKEEPER_URL, ZOOKEEPER_SESSION_TIMEOUT, ZOOKEEPER_CONNECTION_TIMEOUT, JaasUtils.isZkSecurityEnabled());
        if(!AdminUtils.topicExists(zkUtils, TOPIC)) {
            AdminUtils.createTopic(zkUtils, TOPIC, KAFKA_PARTITIONS, KAFKA_REPLICATIONS, new Properties());
        }
        zkUtils.close();
    }

    public void deleteTopic() {
        ZkUtils zkUtils = ZkUtils.apply(ZOOKEEPER_URL, ZOOKEEPER_SESSION_TIMEOUT, ZOOKEEPER_CONNECTION_TIMEOUT, JaasUtils.isZkSecurityEnabled());
        AdminUtils.deleteTopic(zkUtils, TOPIC);
        zkUtils.close();
    }

    public void selectTopics(){
        ZkUtils zkUtils = ZkUtils.apply(ZOOKEEPER_URL, ZOOKEEPER_SESSION_TIMEOUT, ZOOKEEPER_CONNECTION_TIMEOUT, JaasUtils.isZkSecurityEnabled());
//        Properties properties = AdminUtils.fetchEntityConfig(zkUtils, ConfigType.Topic(), TOPIC);
//        // 查询topic level属性
//        Iterator iterator = properties.entrySet().iterator();
//        while(iterator.hasNext()){
//            Map.Entry entry = (Map.Entry)iterator.next();
//            Object key = entry.getKey();
//            Object value = entry.getValue();
//            System.out.println(key + " = "+ value);
//        }

        scala.collection.Map<String, Properties> map =  AdminUtils.fetchAllTopicConfigs(zkUtils);
        String[] aa = new String[map.keys().size()];
        map.keys().copyToArray(aa);
        for(String a : aa){
            System.out.println(a);
        }
    }
}
