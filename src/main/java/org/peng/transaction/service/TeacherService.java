package org.peng.transaction.service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Create by peng on 2021/6/15.
 */
public interface TeacherService {

    //查询教师信息
    void queryTeachers();

    //更新教师年龄,所有人年龄+1
    @Transactional
    void updateTeachersAgeByName(String name);
}
