/*
 * 文件名称: ConfiguationTest.java
 * 版权信息: Copyright 2016-2020 technology Co., LTD. All right reserved.
 * ----------------------------------------------------------------------------------------------
 * 修改历史:
 * ----------------------------------------------------------------------------------------------
 * 修改原因: 新增
 * 修改人员: Kevin
 * 修改日期: 2017/4/25
 * 修改内容: 
 */
package com.hengba.test.common.configuartion;

/**
 * @author Kevin created on 2017/4/25.
 * @since framework 1.0
 */
public class ConfigurationTest {
    public static void main(String[] args) throws InterruptedException {
        while(true) {
            Thread.sleep(3000L);
            System.out.println("warehouse.url: " + Commons.CONF.get("warehouse.url"));
        }
    }
}
