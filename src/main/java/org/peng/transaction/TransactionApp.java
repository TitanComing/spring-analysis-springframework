package org.peng.transaction;

import org.peng.transaction.base.Teacher;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * Create by peng on 2021/6/15.
 */
@ComponentScan
@Configurable
public class TransactionApp {

    public static void main(String[] args){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TransactionApp.class);
        JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);
        String selectSql = "select * from teacher";
        List<Teacher> query = jdbcTemplate.query(selectSql, (resultSet, i) -> {
            Teacher teacher = new Teacher();
            teacher.setId(resultSet.getInt(1));
            teacher.setName(resultSet.getString(2));
            teacher.setAge(resultSet.getInt(3));
            return teacher;
        });
        query.forEach(System.out::println);
    }

}
