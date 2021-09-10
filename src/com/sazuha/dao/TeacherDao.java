package com.sazuha.dao;

import com.sazuha.pojo.Teacher;

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
}
