package com.sazuha.test;

import com.sazuha.pojo.Admin;
import com.sazuha.pojo.Students;
import com.sazuha.pojo.Teacher;
import com.sazuha.service.AdminService;
import com.sazuha.service.impl.AdminServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class AdminServiceImplTest {
    AdminService adminService = new AdminServiceImpl();
    @Test
    public void adminLogin() {
        Admin admin = adminService.adminLogin(new Admin(1,"11111111"));
        System.out.println(admin);
    }

    @Test
    public void changePassword() {
        System.out.println(adminService.changePassword(1,"11111111","111111"));
    }

    @Test
    public void addStudent() {
        System.out.println(adminService.addStudent(new Students(null,"stu4","44444444",0,0,2)));
    }

    @Test
    public void delStudent() {
        System.out.println(adminService.delStudent(4));
    }

    @Test
    public void updateStudent() {
        System.out.println(adminService.updateStudent(new Students(5,"stu5","555555",0,0,2)));
    }

    @Test
    public void listStudent() {
        System.out.println(adminService.listStudent());
    }

    @Test
    public void listStudentByClass() {
        System.out.println(adminService.listStudentByClass(2));
    }

    @Test
    public void addTeacher() {
        System.out.println(adminService.addTeacher(new Teacher(null,"tea5","55555555")));
    }

    @Test
    public void delTeacher() {
        System.out.println(adminService.delTeacher(3));
    }

    @Test
    public void updateTeacher() {
        System.out.println(adminService.updateTeacher(new Teacher(2,"tea2","222222")));
    }

    @Test
    public void listTeacher() {
        System.out.println(adminService.listTeacher());
    }
}