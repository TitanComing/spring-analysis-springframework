package org.peng.task.base;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Create by peng on 2021/6/11.
 */
@Component
public class Tasks {
    /**
     * 定时计算。每天凌晨 01:00 执行一次
     */
    @Scheduled(cron = "0 0 1 * * *")
    public void show() {
        System.out.println("show method 2");
    }

    /**
     * 启动时执行一次，之后每隔2秒执行一次
     */
    @Scheduled(fixedRate = 1000*2)
    public void print() {
        System.out.println("print method 2");
    }
}
