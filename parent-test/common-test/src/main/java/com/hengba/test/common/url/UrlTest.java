/*
 * 文件名称: UrlTest.java
 * 版权信息: Copyright 2016-2020 technology Co., LTD. All right reserved.
 * ----------------------------------------------------------------------------------------------
 * 修改历史:
 * ----------------------------------------------------------------------------------------------
 * 修改原因: 新增
 * 修改人员: Kevin
 * 修改日期: 2017/4/1
 * 修改内容: 
 */
package com.hengba.test.common.url;

import java.io.IOException;
import java.net.URL;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

/**
 * @author Kevin created on 2017/4/1.
 * @since framework 1.0
 */
public class UrlTest {
    public static void main(String[] args) throws IOException {
        Class<?> clazz = com.mysql.jdbc.Driver.class;
        String classContainer = clazz.getProtectionDomain().getCodeSource().getLocation().toString();
        URL url = new URL("jar:"+classContainer+"!/META-INF/MANIFEST.MF");
        Manifest manifest = new Manifest(url.openStream());
        Attributes attributes = manifest.getMainAttributes();
        attributes.keySet().stream().forEach(a -> System.out.println(a + " *** " + attributes.get(a)));
    }
}
