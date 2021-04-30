package org.peng.aop;

import org.peng.aop.base.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Create by peng on 2021/4/30.
 */
public class AopApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("aop-beans.xml");
        User user = (User) context.getBean("User");
        user.sayHello();
        context.close();
    }
}
