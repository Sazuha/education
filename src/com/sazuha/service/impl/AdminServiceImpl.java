package com.sazuha.service.impl;

import com.sazuha.dao.AdminDao;
import com.sazuha.dao.ClassDao;
import com.sazuha.dao.StudentsDao;
import com.sazuha.dao.TeacherDao;
import com.sazuha.dao.impl.AdminDaoImpl;
import com.sazuha.dao.impl.ClassDaoImpl;
import com.sazuha.dao.impl.StudentDaoImpl;
import com.sazuha.dao.impl.TeacherDaoImpl;
import com.sazuha.pojo.Admin;
import com.sazuha.pojo.Class_;
import com.sazuha.pojo.Students;
import com.sazuha.pojo.Teacher;
import com.sazuha.service.AdminService;

import java.util.List;

/**
 * @author ASUS
 */
public class AdminServiceImpl implements AdminService {
    private AdminDao adminDao = new AdminDaoImpl();
    private StudentsDao studentsDao = new StudentDaoImpl();
    private TeacherDao teacherDao = new TeacherDaoImpl();
    private ClassDao classDao = new ClassDaoImpl();
    @Override
    public Admin adminLogin(Admin admin) {
        return adminDao.adminLogin(admin.getId(),admin.getPassword());
    }

    @Override
    public int changePassword(int id, String password, String newPassword) {
        return adminDao.adminChangePassword(id,password,newPassword);
    }

    @Override
    public int addStudent(Students student) {
        return studentsDao.addStudent(student);
    }

    @Override
    public int delStudent(int id) {
        return studentsDao.delStudent(id);
    }

    @Override
    public int updateStudent(Students student) {
        return studentsDao.updateStudent(student);
    }

    @Override
    public List<Students> listStudent() {
        return studentsDao.listStudents();
    }

    @Override
    public List<Students> listStudentByClass(int id) {
        return studentsDao.listStudentsByClass(id);
    }

    @Override
    public int addTeacher(Teacher teacher) {
        return teacherDao.addTeacher(teacher);
    }

    @Override
    public int delTeacher(int id) {
        return teacherDao.delTeacher(id);
    }

    @Override
    public int updateTeacher(Teacher teacher) {
        return teacherDao.updateTeacher(teacher);
    }

    @Override
    public List<Teacher> listTeacher() {
        return teacherDao.listTeacher();
    }

    @Override
    public int addClass(Class_ class_) {
        return classDao.addClass(class_);
    }

    @Override
    public int updateClass(Class_ class_) {
        return classDao.updateClass(class_);
    }

    @Override
    public int delClass(int id) {
        return classDao.delClass(id);
    }

    @Override
    public Class_ searchClass(int id) {
        return classDao.searchClass(id);
    }

    @Override
    public List<Class_> listClass() {
        return classDao.listClass();
    }
}
