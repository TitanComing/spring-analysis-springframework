package org.peng.task.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

/**
 * Create by peng on 2021/6/11.
 * 初始化TaskScheduler/ScheduledExecutorService，spring-task调用自身的默认任务调度器会打印debug信息提示
 */
@Configuration
public class TaskSchedulerConfig {

    @Bean
    public TaskScheduler scheduledExecutorService(){
        ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
        threadPoolTaskScheduler.setPoolSize(10);
        threadPoolTaskScheduler.setThreadNamePrefix("ThreadPoolTaskScheduler");

        return threadPoolTaskScheduler;
    }

}
