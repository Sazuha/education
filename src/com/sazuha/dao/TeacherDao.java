package com.sazuha.dao;

import com.sazuha.pojo.Students;
import com.sazuha.pojo.Teacher;

import java.util.List;

/**
 * @author Sazuha
 */
public interface TeacherDao {
    /**
     * 登录
     * @param id
     * @param password
     * @return
     */
    Teacher teacherLogin(int id, String password);

    /**
     *改密码
     * @param id
     * @param password
     * @param newPassword
     * @return
     */
    public int teacherChangePassword(int id,String password,String newPassword);

    /**
     * 添加
     * @param teacher
     * @return
     */
    public int addTeacher(Teacher teacher);

    /**
     * 删除
     * @param id
     * @return
     */
    public int delTeacher(int id);

    /**
     * 修改
     * @param teacher
     * @return
     */
    public int updateTeacher(Teacher teacher);

    /**
     * 列出
     * @return
     */
    public List<Teacher> listTeacher();

}
