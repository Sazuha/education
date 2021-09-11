package com.sazuha.dao;

import com.sazuha.pojo.Students;

import java.util.List;

/**
 * @author Sazuha
 */
public interface StudentsDao {

    /**
     * 学生登录
     * @param id 学生id号
     * @param password 密码
     * @return
     */
        public Students studentLogin(int id, String password);
    /**
     * 学生密码修改
     * @param id 学生id号
     * @param password 密码
     * @param newPassword 新密码
     * @return
     */
        public int studentChangePassword(int id,String password,String newPassword);

    /**
     * 学生密码修改
     * @param id 学生id号
     * @param courseId 课程
     * @return
     */
        public int studentChooseClass(int id,int courseId);

    /**
     * 退选
     * @param id
     * @param courseId
     * @return
     */
    public int studentDoNotChooseClass(int id,int courseId);

    /**
     * 删除不存在课程
     * @param courseId
     */
    public void isExist(int courseId);

    /**
     * 添加学生
     * @param students
     * @return
     */
    public int addStudent(Students students);

    /**
     * 删除学生
     * @param id
     * @return
     */
    public int delStudent(int id);

    /**
     * 修改学生
     * @param students
     * @return
     */
    public int updateStudent(Students students);

    /**
     * 列出所有
     * @return
     */
    public List<Students> listStudents();

    /**
     * 班级学生列出
     * @param id
     * @return
     */
    public List<Students> listStudentsByClass(int id);


}
