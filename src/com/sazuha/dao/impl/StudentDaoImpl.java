package com.sazuha.dao.impl;

import com.sazuha.dao.StudentsDao;
import com.sazuha.pojo.Students;

import java.util.List;

/**
 * @author Sazuha
 */
public class StudentDaoImpl extends BaseDao implements StudentsDao {

    private List<Students> students;

    @Override
    public Students studentLogin(int id, String password) {
        String sql = "select * from t_students where id=?";
        students = search(Students.class, sql, id);
        if (students.size() > 0) {
            if (students.get(0).getPassword().equals(password)) {
                return students.get(0);
            } else {
                return null;
            }
        }else{
            return null;
        }
    }


    @Override
    public int studentChangePassword(int id, String password, String newPassword) {
        Students student = studentLogin(id,password);
        if(student!=null){
            String sql = "update t_students set password=? where id=?";
            return update(sql,newPassword,id);
        }else{
            return -1;
        }
    }

    @Override
    public int studentChooseClass(int id, int courseId) {
        String sql = "select * from t_students where id=?";
        Students student = search(Students.class,sql,id).get(0);
        if (student.getCou1()==0){
            sql = "update t_students set cou1=? where id=?";
            return update(sql,courseId,id);
        }else if(student.getCou2()==0){
            sql = "update t_students set cou2=? where id=?";
            return update(sql,courseId,id);
        }else{
            return -1;
        }
    }

    @Override
    public int studentDoNotChooseClass(int id, int courseId) {
        String sql = "select * from t_students where id=?";
        Students student = search(Students.class,sql,id).get(0);
        if (student.getCou1()==courseId){
            sql = "update t_students set cou1=0 where id=?";
            return update(sql,id);
        }else if(student.getCou2()==courseId){
            sql = "update t_students set cou2=0 where id=?";
            return update(sql,id);
        }else{
            return -1;
        }
    }

    @Override
    public void isExist(int courseId) {
        String sql = "select * from t_students where (cou1=?) or (cou2=?)";
        List<Students> students = search(Students.class,sql,courseId,courseId);
        for(int i=0;i< students.size();i++){
            studentDoNotChooseClass(students.get(i).getId(),courseId);
        }
    }
}
