/*
 * 文件名称: TestSame.java
 * 版权信息: Copyright 2016-2020 technology Co., LTD. All right reserved.
 * ----------------------------------------------------------------------------------------------
 * 修改历史:
 * ----------------------------------------------------------------------------------------------
 * 修改原因: 新增
 * 修改人员: Kevin
 * 修改日期: 2017/5/19
 * 修改内容: 
 */
package com.hengba.test.common;

import commons.utils.NetUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Kevin created on 2017/5/19.
 * @since framework 1.0
 */
public class TestSame {
    public static void main(String[] args) {
        String[] ips = NetUtils.getLocalIpS();
        for (String ip : ips) {
            System.out.println("==> " + ip);
        }
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date(1497515017251L)));
    }
}
