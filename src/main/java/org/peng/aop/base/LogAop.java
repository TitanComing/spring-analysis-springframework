package org.peng.aop.base;

import org.aspectj.lang.JoinPoint;

/**
 * Create by peng on 2021/4/30.
 */
public class LogAop {

    public void addLogBefore() {
        System.out.println("添加日志 Before...");
    }

    public void addLogAfter() {
        System.out.println("添加日志记录 After...");
    }

    public void addLogAfterReturning() {
        System.out.println("添加日志记录 AfterReturning...");
    }

    public void addLogAfterThrowing() {
        System.out.println("添加日志记录 AfterThrowing...");
    }

    public void addLogAround(JoinPoint joinPoint) {
        System.out.println("添加日志记录 AfterAround start...");
        System.out.println(joinPoint.getTarget());
        System.out.println("添加日志记录 AfterAround end...");
    }
}
