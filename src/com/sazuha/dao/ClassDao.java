package com.sazuha.dao;

import com.sazuha.pojo.Class_;

import java.util.List;

/**
 * @author ASUS
 */
public interface ClassDao{
    /**
     * 添加班级
     * @param class_
     * @return
     */
    public int addClass(Class_ class_);

    /**
     * 删除班级
     * @param id
     * @return
     */
    public int delClass(int id);

    /**
     * 修改班级
     * @param class_
     * @return
     */
    public int updateClass(Class_ class_);

    /**
     * 查找班级
     * @param id
     * @return
     */
    public Class_ searchClass(int id);

    /**
     * 列出所有
     * @return
     */
    public List<Class_> listClass();
}
