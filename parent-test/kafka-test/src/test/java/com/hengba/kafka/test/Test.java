/*
 * 文件名称: Test.java
 * 版权信息: Copyright 2016-2020 technology Co., LTD. All right reserved.
 * ----------------------------------------------------------------------------------------------
 * 修改历史:
 * ----------------------------------------------------------------------------------------------
 * 修改原因: 新增
 * 修改人员: Kevin
 * 修改日期: 2017/8/3
 * 修改内容: 
 */
package com.hengba.kafka.test;

import com.hengba.kafka.AdminUtilsService;
import com.hengba.kafka.KafkaProducerService;

/**
 * @author Kevin created on 2017/8/3.
 * @since framework 1.0
 */
public class Test {

    @org.junit.Test
    public void selectTopic(){
        AdminUtilsService service = new AdminUtilsService();
        service.selectTopics();
    }

    @org.junit.Test
    public void sendMessage(){
        KafkaProducerService service = new KafkaProducerService();
        service.init();
        service.send("ce", "1339080");
        while (true){}
    }
}
