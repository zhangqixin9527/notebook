/*
 * 文件名称: JZ.java
 * 版权信息: Copyright 2016-2020 technology Co., LTD. All right reserved.
 * ----------------------------------------------------------------------------------------------
 * 修改历史:
 * ----------------------------------------------------------------------------------------------
 * 修改原因: 新增
 * 修改人员: Kevin
 * 修改日期: 2017/8/15
 * 修改内容: 
 */
package com.hengba.schema.factory.sim;

/**
 * @author Kevin created on 2017/8/15.
 * @since framework 1.0
 */
public class JZ implements Lottery{

    @Override
    public String rule() {
        return "竞彩足球";
    }
}
