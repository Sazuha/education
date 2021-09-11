package com.sazuha.dao.impl;

import com.sazuha.dao.AdminDao;
import com.sazuha.pojo.Admin;
import com.sazuha.pojo.Students;

import java.util.List;

/**
 * @author ASUS
 */
public class AdminDaoImpl extends BaseDao implements AdminDao {

    private List<Admin> admin;
    @Override
    public Admin adminLogin(int id, String password) {
        String sql = "select * from t_admin where id=?";
        admin = search(Admin.class, sql, id);
        if (admin.size() > 0) {
            if (admin.get(0).getPassword().equals(password)) {
                return admin.get(0);
            } else {
                return null;
            }
        }else{
            return null;
        }
    }

    @Override
    public int adminChangePassword(int id, String password, String newPassword) {
        Admin admin = adminLogin(id,password);
        if(admin!=null){
            String sql = "update t_admin set password=? where id=?";
            return update(sql,newPassword,id);
        }else{
            return -1;
        }
    }
}
