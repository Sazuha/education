package com.sazuha.test;

import com.sazuha.pojo.Students;
import com.sazuha.service.StudentService;
import com.sazuha.service.impl.StudentServiceImpl;
import org.junit.Test;

import java.sql.SQLOutput;

/**
 * @author ASUS
 */
public class ServiceTest {
    @Test
    public void testService(){
        StudentService studentService = new StudentServiceImpl();

        System.out.println(studentService.studentLogin(new Students(1,"stu1","11111111",0,0)));
        Students loginUser = studentService.studentLogin(new Students(1,"stu1","11111111",0,0));
        System.out.println(loginUser);
    }
}
