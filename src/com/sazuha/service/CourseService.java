package com.sazuha.service;

import com.sazuha.pojo.Course;

import java.util.List;

/**
 * @author ASUS
 */
public interface CourseService {
    /**
     * 添加课程
     * @param course 课程类
     */
    public void addCourse(Course course);

    /**
     * 删除课程
     * @param id 课程id
     */
    public void delCourse(Integer id);

    /**
     * 修改课程
     * @param course
     */
    public void updateCourse(Course course);

    /**
     * 通过id搜索
     * @param id 课程id
     * @return
     */
    public Course searchCourseById(Integer id);

    /**
     * 通过课程名搜索
     * @param cname 课程名
     * @return
     */
    public List<Course> searchCourseByName(String cname);

    /**
     * 通过教师搜索
     * @param teacher 教师
     * @return
     */
    public List<Course> searchCourseByTeacher(String teacher);

    /**
     * 搜索课程
     * @return
     */
    public List<Course> searchCourse();

    /**
     * 选择课程
     * @param id 课程id
     */
    public void chooseCourse(Integer id);

    /**
     * 退选
     * @param id
     */
    public void doNotChooseCourse(Integer id);

}
