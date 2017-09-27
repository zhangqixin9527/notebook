/*
 * 文件名称: FileSomething.java
 * 版权信息: Copyright 2016-2020 technology Co., LTD. All right reserved.
 * ----------------------------------------------------------------------------------------------
 * 修改历史:
 * ----------------------------------------------------------------------------------------------
 * 修改原因: 新增
 * 修改人员: Kevin
 * 修改日期: 2017/8/30
 * 修改内容: 
 */
package com.hengba;

import java.io.File;

/**
 * @author Kevin created on 2017/8/30.
 * @since framework 1.0
 */
public class FileSomething {
    public static void main(String[] args) {
        System.out.println("File.separator: " + File.separator);
        System.out.println("File.separatorChar: " + File.separatorChar);
        System.out.println("File.pathSeparator: " + File.pathSeparator);
        System.out.println("File.pathSeparatorChar: " + File.pathSeparatorChar);
    }
}
