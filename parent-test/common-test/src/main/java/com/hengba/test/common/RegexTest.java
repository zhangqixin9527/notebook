/*
 * 文件名称: RegTest.java
 * 版权信息: Copyright 2016-2020 technology Co., LTD. All right reserved.
 * ----------------------------------------------------------------------------------------------
 * 修改历史:
 * ----------------------------------------------------------------------------------------------
 * 修改原因: 新增
 * 修改人员: Kevin
 * 修改日期: 2017/5/3
 * 修改内容: 
 */
package com.hengba.test.common;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @author Kevin created on 2017/5/3.
 * @since framework 1.0
 */
public class RegexTest {
    public static void main(String[] args) {
        CharSequence string = null;
        try {
            if (Pattern.compile("^\\d+\\:\\d+$").matcher(string).matches()) {
                System.out.println("match");
            } else {
                System.out.println("not match");
            }
        }catch (Throwable e){
            System.out.println("error!");
        }
    }
}
