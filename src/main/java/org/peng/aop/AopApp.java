package org.peng.aop;

import org.peng.aop.base.User;
import org.springframework.aop.config.AopNamespaceHandler;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Create by peng on 2021/4/30.
 */
public class AopApp {
    public static void main(String[] args) {
        //测试aop装配
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("aop-beans.xml");
        User user = context.getBean(User.class);
        user.sayHello();
        //aop解析入口,通过命名空间解析器处理
        AopNamespaceHandler aopNamespaceHandler = new AopNamespaceHandler();
        context.close();
    }
}
