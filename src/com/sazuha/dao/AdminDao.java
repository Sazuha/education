package com.sazuha.dao;

import com.sazuha.pojo.Admin;

/**
 * @author ASUS
 */
public interface AdminDao{
    /**
     * 登录
     * @param id
     * @param password
     * @return
     */
    public Admin adminLogin(int id,String password);

    /**
     * 改密码
     * @param id
     * @param password
     * @param newPassword
     * @return
     */
    public int adminChangePassword(int id,String password,String newPassword);

}
