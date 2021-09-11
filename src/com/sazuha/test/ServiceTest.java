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


    }
}
