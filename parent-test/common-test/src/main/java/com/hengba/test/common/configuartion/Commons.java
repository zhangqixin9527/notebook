/*
 * 文件名称: Commons.java
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

import commons.configure.Configuration;
import commons.configure.SourceLoader;
import commons.configure.xml.XmlConf;

/**
 * @author Kevin created on 2017/4/25.
 * @since framework 1.0
 */
public class Commons {
    public static final Configuration CONF = new XmlConf();
    public static final String CONF_FILE = "common-conf.xml";

    static {
        SourceLoader.loadSingle(CONF, CONF_FILE);
    }
}
