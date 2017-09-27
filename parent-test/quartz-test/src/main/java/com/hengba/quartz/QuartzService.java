/*
 * 文件名称: QuartzService.java
 * 版权信息: Copyright 2016-2020 technology Co., LTD. All right reserved.
 * ----------------------------------------------------------------------------------------------
 * 修改历史:
 * ----------------------------------------------------------------------------------------------
 * 修改原因: 新增
 * 修改人员: Kevin
 * 修改日期: 2017/9/13
 * 修改内容: 
 */
package com.hengba.quartz;

/**
 * @author Kevin created on 2017/9/13.
 * @since framework 1.0
 */
public class QuartzService {
    private int accumulator = -1;

    public void accumulate() {
        accumulator++;
    }

    public void service() {
        System.out.println(accumulator);
        System.out.println("咕噜咕噜");
        if (0 == accumulator % 5) {
            System.out.println("呜呜呜呜呜");
        }
    }
}
