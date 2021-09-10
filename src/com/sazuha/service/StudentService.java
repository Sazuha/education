package com.sazuha.service;

import com.sazuha.pojo.Students;

/**
 * @author Sazuha
 */
public interface StudentService {
    /**
     * 登录
     * @param students
     * @return
     */
    public Students studentLogin(Students students);

    /**
     * 改密码
     * @param id
     * @param password
     * @param newPassword
     */
    public int changePassword(int id, String password, String newPassword);

    /**
     * 选课
     * @param id
     * @param courseId
     * @return
     */
    public int chooseCourse(int id,int courseId);

    /**
     * 退选
     * @param id
     * @param courseId
     * @return
     */
    public int studentDoNotChooseCourse(int id,int courseId);



}
