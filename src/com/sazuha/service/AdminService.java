package com.sazuha.service;

import com.sazuha.pojo.Admin;
import com.sazuha.pojo.Students;
import com.sazuha.pojo.Teacher;

import java.util.List;

/**
 * @author ASUS
 */
public interface AdminService {
    /**
     * 登录
     * @param admin
     * @return
     */
    public Admin adminLogin(Admin admin);

    /**
     *改密码
     * @param id
     * @param password
     * @param newPassword
     * @return
     */
    public int changePassword(int id,String password,String newPassword);

    /**
     * 添加学生
     * @param student
     * @return
     */
    public int addStudent(Students student);

    /**
     * 删除学生
     * @param id
     * @return
     */
    public int delStudent(int id);

    /**
     * 修改学生
     * @param student
     * @return
     */
    public int updateStudent(Students student);

    /**
     * 列出所有
     * @return
     */
    public List<Students> listStudent();

    /**
     * 列出班级学生
     * @param id
     * @return
     */
    public List<Students> listStudentByClass(int id);

    /**
     * 添加教师
     * @param teacher
     * @return
     */
    public int addTeacher(Teacher teacher);

    /**
     * 删除教师
     * @param id
     * @return
     */
    public int delTeacher(int id);

    /**
     * 更改教师
     * @param teacher
     * @return
     */
    public int updateTeacher(Teacher teacher);

    /**
     * 列出所有
     * @return
     */
    public List<Teacher> listTeacher();
}
