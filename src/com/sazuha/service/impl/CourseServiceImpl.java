package com.sazuha.service.impl;

import com.sazuha.dao.CourseDao;
import com.sazuha.dao.impl.CourseDaoImpl;
import com.sazuha.pojo.Course;
import com.sazuha.service.CourseService;

import java.util.List;

/**
 * @author Sazuha
 */
public class CourseServiceImpl implements CourseService {
    private CourseDao courseDao = new CourseDaoImpl();
    @Override
    public void addCourse(Course course) {
        courseDao.addCourse(course);
    }

    @Override
    public void delCourse(Integer id) {
        courseDao.delCourse(id);
    }

    @Override
    public void updateCourse(Course course) {
        courseDao.updateCourse(course);
    }

    @Override
    public Course searchCourseById(Integer id) {
        return courseDao.searchCourseById(id);
    }

    @Override
    public List<Course> searchCourseByName(String cname) {
        return courseDao.searchCourseByName(cname);
    }

    @Override
    public List<Course> searchCourseByTeacher(String teacher) {
        return courseDao.searchCourseByTeacher(teacher);
    }

    @Override
    public List<Course> searchCourse() {
        return courseDao.searchCourse();
    }

    @Override
    public void chooseCourse(Integer id){
        courseDao.chooseCourse(id);
    }

    @Override
    public void doNotChooseCourse(Integer id) {
        courseDao.doNotChooseCourse(id);
    }
}
