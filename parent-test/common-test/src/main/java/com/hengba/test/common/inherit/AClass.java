/*
 * 文件名称: AClass.java
 * 版权信息: Copyright 2016-2020 technology Co., LTD. All right reserved.
 * ----------------------------------------------------------------------------------------------
 * 修改历史:
 * ----------------------------------------------------------------------------------------------
 * 修改原因: 新增
 * 修改人员: Kevin
 * 修改日期: 2017/4/11
 * 修改内容: 
 */
package com.hengba.test.common.inherit;

/**
 * @author Kevin created on 2017/4/11.
 * @since framework 1.0
 */
public class AClass extends Abstract {
    @Override
    public void run() {
        System.out.println("***"+a);
        System.out.println("==>"+this.useMoney());
    }

    public static void main(String[] args) {
        new AClass().run();
    }
}
