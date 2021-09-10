package com.sazuha.test;

import com.sazuha.dao.impl.BaseDao;
import com.sazuha.dao.impl.StudentDaoImpl;
import com.sazuha.utils.DbUtils;
import com.sazuha.utils.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;
import java.util.List;

/**
 * @author ASUS
 */
public class DbUtilsTest {
    @Test
    public void testDbUtils() {
        String sql = "select * from dept where deptno > ?";
        StudentDaoImpl studentDao = new StudentDaoImpl();
        List<Test1> list_test1 = studentDao.search(Test1.class, sql, 10);
        System.out.println(list_test1.get(1));

        String sql2 = "insert into t_course (cname,time,stunum,maxnum,teacher,classroom) values(?,?,0,?,?,?)";
        Connection conn = JdbcUtils.getConnection();
        System.out.println(DbUtils.updateSql(conn,sql2,"cou2",2,150,"tea2","A102"));
    }
}
