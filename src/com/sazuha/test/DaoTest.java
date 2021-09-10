package com.sazuha.test;

import com.sazuha.dao.StudentsDao;
import com.sazuha.dao.impl.StudentDaoImpl;
import com.sazuha.pojo.Students;
import org.junit.Test;

/**
 * @author Sazuha
 */
public class DaoTest {

    @Test
    public void testDao(){
        StudentsDao studentsDao = new StudentDaoImpl();
        System.out.println(studentsDao.studentLogin(1,"11111111"));
        System.out.println(studentsDao.studentLogin(2,"22222222"));
        System.out.println(studentsDao.studentLogin(3,"33333333"));
    }
}
