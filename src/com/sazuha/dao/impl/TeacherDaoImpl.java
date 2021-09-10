package com.sazuha.dao.impl;

import com.sazuha.dao.TeacherDao;
import com.sazuha.pojo.Students;
import com.sazuha.pojo.Teacher;

import java.util.List;

/**
 * @author ASUS
 */
public class TeacherDaoImpl extends BaseDao implements TeacherDao {
    private List<Teacher> teacher;
    @Override
    public Teacher teacherLogin(int id, String password) {
        String sql = "select * from t_teacher where id=?";
        teacher = search(Teacher.class,sql,id);
        if(teacher.size()>0){
            if(teacher.get(0).getPassword().equals(password)){
                return teacher.get(0);
            }
            else {
                return null;
            }
        }else {
            return null;
        }

    }

    @Override
    public int teacherChangePassword(int id, String password, String newPassword) {
        Teacher teacher = teacherLogin(id,password);
        if(teacher!=null){
            String sql = "update t_teacher set password=? where id=?";
            return update(sql,newPassword,id);
        }else{
            return -1;
        }
    }
}
