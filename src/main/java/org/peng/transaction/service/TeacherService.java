package org.peng.transaction.service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Create by peng on 2021/6/15.
 */
public interface TeacherService {

    //查询教师信息
    void queryTeachers();

    //分两次更新教师年龄和姓名，如果为“张老师”两次更新之间抛错
    @Transactional
    void updateTeachersAgeByName(String name);
}
