package org.peng.task;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Create by peng on 2021/6/11.
 */
@Configurable
@ComponentScan
@EnableScheduling
public class TaskApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(TaskApp.class);
        //注册 org.springframework.beans.factory.xml.NamespaceHandlerSupport
    }
}
