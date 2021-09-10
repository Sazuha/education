package com.sazuha.service.impl;

import com.sazuha.dao.StudentsDao;
import com.sazuha.dao.impl.StudentDaoImpl;
import com.sazuha.pojo.Students;
import com.sazuha.service.StudentService;

/**
 * @author Sazuha
 */
public class StudentServiceImpl implements StudentService {
    private StudentsDao studentDao = new StudentDaoImpl();
    @Override
    public Students studentLogin(Students students) {
        return studentDao.studentLogin(students.getId(),students.getPassword());
    }

    @Override
    public int changePassword(int id, String password, String newPassword) {
        return studentDao.studentChangePassword(id,password,newPassword);
    }

    @Override
    public int chooseCourse(int id, int courseId) {
        return studentDao.studentChooseClass(id,courseId);
    }

    @Override
    public int studentDoNotChooseCourse(int id, int courseId) {
        return studentDao.studentDoNotChooseClass(id,courseId);
    }



}
