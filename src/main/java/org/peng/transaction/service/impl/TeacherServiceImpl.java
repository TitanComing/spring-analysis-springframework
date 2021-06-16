package org.peng.transaction.service.impl;

import org.peng.transaction.base.Teacher;
import org.peng.transaction.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * Create by peng on 2021/6/15.
 */
@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void queryTeachers() {
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

    @Override
    @Transactional
    public void updateTeachersAgeByName(String name) {
//        //原生写法
//        try (Connection connection = dataSource.getConnection();
//             PreparedStatement statement = connection.prepareStatement("update teacher set age = age + 1 where name = ?")
//        ) {
//            statement.setString(1, name);
//            statement.executeUpdate();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
        //jdbc直接写法
        jdbcTemplate.update("update teacher set age = age + 1 where name = ?",name);
        if(name.equals("张老师")){
            throw new RuntimeException("模拟事务进行一半出错了:如果入参为’张老师‘,则抛出错误，事务应该回滚");
        }
        jdbcTemplate.update("update teacher set name = ? where name = ?", name + "-updated",name);

        System.out.println("更新数据结束: " + name);

    }
}
