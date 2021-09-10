package com.sazuha.service.impl;

import com.sazuha.dao.CourseDao;
import com.sazuha.dao.StudentsDao;
import com.sazuha.dao.TeacherDao;
import com.sazuha.dao.impl.CourseDaoImpl;
import com.sazuha.dao.impl.StudentDaoImpl;
import com.sazuha.dao.impl.TeacherDaoImpl;
import com.sazuha.pojo.Course;
import com.sazuha.pojo.Students;
import com.sazuha.pojo.Teacher;
import com.sazuha.service.TeacherService;

/**
 * @author ASUS
 */
public class TeacherServiceImpl implements TeacherService {
    TeacherDao teacherDao = new TeacherDaoImpl();
    CourseDao courseDao = new CourseDaoImpl();
    StudentsDao studentsDao = new StudentDaoImpl();
    @Override
    public Teacher teacherLogin(Teacher teacher) {
        return teacherDao.teacherLogin(teacher.getId(),teacher.getPassword());
    }

    @Override
    public void changePassword(int id, String password, String newPassword) {
        teacherDao.teacherChangePassword(id,password,newPassword);
    }

    @Override
    public int newCourse(Course course) {
        return courseDao.addCourse(course);
    }

    @Override
    public int delCourse(int id) {
        return courseDao.delCourse(id);
    }

    @Override
    public int updateCourse(Course course) {
        return courseDao.updateCourse(course);
    }

    @Override
    public void isExistCourse(int courseId) {
        studentsDao.isExist(courseId);
    }
}
