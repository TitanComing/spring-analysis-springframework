package org.peng.core;

import org.peng.core.base.SimpleBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class CoreApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("core-beans.xml");
        SimpleBean simpleBean = context.getBean(SimpleBean.class);
        simpleBean.send();
        context.close();
    }
}
