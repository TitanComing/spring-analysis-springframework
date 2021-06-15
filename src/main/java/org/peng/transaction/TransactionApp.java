package org.peng.transaction;

import org.peng.transaction.service.TeacherService;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * Create by peng on 2021/6/15.
 */
@ComponentScan
@Configurable
public class TransactionApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TransactionApp.class);
        TeacherService teacherService = context.getBean(TeacherService.class);
        teacherService.queryTeachers();
        //该事务会出错
        try {
            teacherService.updateTeachersAgeByName("张老师");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        //该事务可以正常进行
        try {
            teacherService.updateTeachersAgeByName("李老师");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        teacherService.queryTeachers();
    }
}
