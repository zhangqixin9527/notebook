/*
 * 文件名称: TestLog.java
 * 版权信息: Copyright 2016-2020 technology Co., LTD. All right reserved.
 * ----------------------------------------------------------------------------------------------
 * 修改历史:
 * ----------------------------------------------------------------------------------------------
 * 修改原因: 新增
 * 修改人员: Kevin
 * 修改日期: 2017/6/15
 * 修改内容: 
 */
package com.hengba.test.common.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Kevin created on 2017/6/15.
 * @since framework 1.0
 */
public class TestLog {
    public static final Logger logger = LoggerFactory.getLogger(TestLog.class);

    public static void main(String[] args) throws InterruptedException {
        while (true) {
            Thread.sleep(3000L);
            long begin = System.currentTimeMillis();
            logger.info("test test");
            System.out.println(System.currentTimeMillis() - begin);
        }
    }
}
