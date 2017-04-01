/*
 * 文件名称: NetTest.java
 * 版权信息: Copyright 2016-2020 technology Co., LTD. All right reserved.
 * ----------------------------------------------------------------------------------------------
 * 修改历史:
 * ----------------------------------------------------------------------------------------------
 * 修改原因: 新增
 * 修改人员: Kevin
 * 修改日期: 2017/3/30
 * 修改内容: 
 */
package com.hengba.test.common;

import commons.utils.NetUtils;
import commons.utils.SystemUtils;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author Kevin created on 2017/3/30.
 * @since framework 1.0
 */
public class NetTest {
    public static void main(String[] args) {
        for(String ip : NetUtils.getLocalIpS()) {
            System.out.println(ip);
        }
        System.out.println("================");
        try {
            String ip = InetAddress.getLocalHost().getHostAddress();
            System.out.println(ip);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
