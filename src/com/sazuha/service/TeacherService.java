package com.sazuha.service;

import com.sazuha.pojo.Course;
import com.sazuha.pojo.Teacher;

/**
 * @author ASUS
 */
public interface TeacherService {
    /**
     * 登录
     * @param teacher
     * @return
     */
    public Teacher teacherLogin(Teacher teacher);

    /**
     * 改密码
     * @param id
     * @param password
     * @param newPassword
     */
    public void changePassword(int id,String password,String newPassword);

    /**
     * 发布课程
     * @param course
     * @return
     */
    public int newCourse(Course course);

    /**
     * 下架课程
     * @param id
     * @return
     */
    public int delCourse(int id);

    /**
     * 修改课程
     * @param course
     * @return
     */
    public int updateCourse(Course course);

    /**
     * 删除不存在课程
     * @param courseId
     */
    public void isExistCourse(int courseId);

}
