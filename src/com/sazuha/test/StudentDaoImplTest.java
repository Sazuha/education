package com.sazuha.test;

import com.sazuha.dao.StudentsDao;
import com.sazuha.dao.impl.StudentDaoImpl;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author ASUS
 */
public class StudentDaoImplTest {
    StudentsDao studentsDao = new StudentDaoImpl();
    @Test
    public void studentLogin() {
        System.out.print(studentsDao.studentLogin(1,"11111111"));
    }

    @Test
    public void studentChangePassword() {
        System.out.println(studentsDao.studentChangePassword(1,"111111","11111111"));
    }

    @Test
    public void studentChooseClass() {
        System.out.println(studentsDao.studentChooseClass(1,2));
    }
}