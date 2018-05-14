/*
 * 文件名称: ByteIOTest.java
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

import commons.io.bytes.BytesIO;
import commons.io.bytes.impl.BytesWritableIO;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * @author Kevin created on 2017/3/30.
 * @since framework 1.0
 */
public class ByteIOTest {
    public static void main(String[] args) {
        byte[] aa= null;
        try {
            BytesIO.instance(BytesWritableIO.class).read(aa);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void byteDefault(){
        A cc = new A();
        System.out.println("a == b: "+ (cc.a == cc.b) + " , a = ? :"+ cc.a);
    }

    class  A {
        byte a;
        byte b = 0;
    }
}
