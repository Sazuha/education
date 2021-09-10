package com.sazuha.dao;

import com.sazuha.pojo.Course;

import java.util.List;

/**
 * @author Sazuha
 */
public interface CourseDao {
    /**
     * 添加课程
     * @param course 课程
     * @return
     */
    public int addCourse(Course course);

    /**
     * 删除课程
     * @param id 课程id
     * @return
     */
    public int delCourse(int id);

    /**
     * 通过id查找
     * @param id 课程id
     * @return
     */
    public Course searchCourseById(int id);

    /**
     * 通过课程名查找
     * @param cname 课程名
     * @return
     */
    public List<Course> searchCourseByName(String cname);

    /**
     * 通过教师查找
     * @param teacher 教师
     * @return
     */
    public List<Course> searchCourseByTeacher(String teacher);

    /**
     * 选择课程
     * @param id 课程id
     * @return
     */
    public int chooseCourse(int id);

    /**
     * 退选
     * @param id
     * @return
     */
    public int doNotChooseCourse(int id);

    /**
     * 修改信息
     * @param course 课程
     * @return
     */
    public int updateCourse(Course course);

    /**
     * 查找多个
     * @return
     */
    public List<Course> searchCourse();




}
