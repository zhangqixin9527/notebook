/*
 * 文件名称: QuartzMain.java
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

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author Kevin created on 2017/9/13.
 * @since framework 1.0
 */
public class QuartzMain {
    public static void main(String[] args) {
        try {
            QuartzService service = new QuartzService();
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.start();
            JobDetail job = JobBuilder.newJob(QuartzJob.class).withIdentity("zqx", "zqx").build();
            job.getJobDataMap().put("service", service);
            Trigger trigger = TriggerBuilder.newTrigger().withIdentity("zqx", "zqx")
                    .startNow().withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(1)).build();
            scheduler.scheduleJob(job, trigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
