package com.sazuha.dao;

import com.sazuha.pojo.Students;

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

}
