package com.sazuha.test;

import com.sazuha.dao.CourseDao;
import com.sazuha.dao.impl.CourseDaoImpl;
import com.sazuha.pojo.Course;
import org.junit.Test;

import java.sql.SQLOutput;

import static org.junit.Assert.*;

/**
 * @author ASUS
 */
public class CourseDaoImplTest {
    private CourseDao courseDao = new CourseDaoImpl();
    @Test
    public void addCourse() {
        System.out.println(courseDao.addCourse(new Course(null,"cou3",3,0,150,"tea3","A103")));
    }

    @Test
    public void delCourse() {
        System.out.println(courseDao.delCourse(5));
    }

    @Test
    public void searchCourseById() {
        System.out.println(courseDao.searchCourseById(1));
    }

    @Test
    public void searchCourseByName() {
        System.out.println(courseDao.searchCourseByName("cou1"));
    }

    @Test
    public void searchCourseByTeacher() {
        System.out.println(courseDao.searchCourseByTeacher("tea1"));
    }

    @Test
    public void chooseCourse() {
    }

    @Test
    public void updateCourse() {
        System.out.println(courseDao.updateCourse(new Course(1,"cou1",1,1,150,"tea1","A101")));
    }

    @Test
    public void searchCourse() {
    }
}