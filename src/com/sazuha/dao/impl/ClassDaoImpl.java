package com.sazuha.dao.impl;

import com.sazuha.dao.ClassDao;
import com.sazuha.pojo.Class_;
import com.sazuha.pojo.Course;

import java.util.List;

public class ClassDaoImpl extends BaseDao implements ClassDao {
    @Override
    public int addClass(Class_ class_) {
        String sql = "insert into t_class (className) values(?)";
        return update(sql,class_.getClassName());
    }

    @Override
    public int delClass(int id) {
        String sql = "delete from t_class where id=?";
        return update(sql,id);
    }

    @Override
    public int updateClass(Class_ class_) {
        String sql = "update t_class set className=? where id=?";
        return update(sql,class_.getClassName(),class_.getId());
    }

    @Override
    public Class_ searchClass(int id) {
        String sql = "select * from t_class where id=?";
        List<Class_> class_ = search(Class_.class,sql,id);
        if(class_.size()>0){
            return class_.get(0);
        }else{
            return null;
        }
    }

    @Override
    public List<Class_> listClass() {
        String sql = "select * from t_class";
        return search(Class_.class,sql);
    }
}
