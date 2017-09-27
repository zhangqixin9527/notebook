/*
 * 文件名称: QuartzJob.java
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

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author Kevin created on 2017/9/13.
 * @since framework 1.0
 */
public class QuartzJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        QuartzService service = (QuartzService) context.getMergedJobDataMap().get("service");
        service.accumulate();
        service.service();
    }
}
