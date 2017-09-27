/*
 * 文件名称: TestRuntime.java
 * 版权信息: Copyright 2016-2020 technology Co., LTD. All right reserved.
 * ----------------------------------------------------------------------------------------------
 * 修改历史:
 * ----------------------------------------------------------------------------------------------
 * 修改原因: 新增
 * 修改人员: Kevin
 * 修改日期: 2017/9/14
 * 修改内容: 
 */
package com.hengba.zookeeper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author Kevin created on 2017/9/14.
 * @since framework 1.0
 */
public class TestRuntime {
    public static void main(String[] args) throws IOException, InterruptedException {
        Process process = Runtime.getRuntime().exec("cmd /c dir");
        InputStream stdin = process.getInputStream();
        InputStreamReader isr = new InputStreamReader(stdin, "GBK");
        BufferedReader br = new BufferedReader(isr);
        String line = null;
        System.out.println("<OUTPUT>");
        while ( (line = br.readLine()) != null)
            System.out.println(line);
        System.out.println("</OUTPUT>");
        System.out.println(process.waitFor());
    }
}
