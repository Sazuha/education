package com.sazuha.dao.impl;

import com.sazuha.dao.CourseDao;
import com.sazuha.pojo.Course;
import com.sazuha.pojo.Students;

import java.util.List;

/**
 * @author Sazuha
 */
public class CourseDaoImpl extends BaseDao implements CourseDao {
    @Override
    public int addCourse(Course course) {
        String sql = "insert into t_course (cname,time,stunum,maxnum,teacher,classroom) values(?,?,0,?,?,?)";
        return update(sql,course.getCname(),course.getTime(),course.getMaxnum(),course.getTeacher(),course.getClassroom());
    }

    @Override
    public int delCourse(int id) {
        String sql = "delete from t_course where id=?";
        return update(sql,id);
    }

    @Override
    public Course searchCourseById(int id) {
        String sql = "select * from t_course where id=?";
        List<Course> courses = search(Course.class,sql,id);
        if(courses.size()>0){
            return courses.get(0);
        }else{
            return null;
        }

    }

    @Override
    public List<Course> searchCourseByName(String cname) {
        String sql = "select * from t_course where cname=?";
        return search(Course.class,sql,cname);
    }

    @Override
    public List<Course> searchCourseByTeacher(String teacher) {
        String sql = "select * from t_course where teacher=?";
        return search(Course.class,sql,teacher);
    }

    @Override
    public int chooseCourse(int id) {
        String sql = "update t_course set stunum=stunum+1 where id=?";
        return update(sql,id);
    }

    @Override
    public int doNotChooseCourse(int id) {
        String sql = "update t_course set stunum=stunum-1 where id=?";
        return update(sql,id);
    }

    @Override
    public int updateCourse(Course course) {
        String sql = "update t_course set cname=?,time=?,stunum=?,maxnum=?,teacher=?,classroom=? where id=?";
        return update(sql,course.getCname(),course.getTime(),course.getStunum(),course.getMaxnum(),course.getTeacher(),course.getClassroom(),course.getId());
    }

    @Override
    public List<Course> searchCourse() {
        String sql = "select * from t_course";
        return search(Course.class,sql);
    }

}
