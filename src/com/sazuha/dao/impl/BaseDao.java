package com.sazuha.dao.impl;

import com.sazuha.pojo.Students;
import com.sazuha.test.Test1;
import com.sazuha.utils.DbUtils;
import com.sazuha.utils.JdbcUtils;

import java.sql.Connection;
import java.util.List;

/**
 * @author Sazuha
 */
public abstract class BaseDao {


    public int update(String sql,Object ... args){
        Connection conn = JdbcUtils.getConnection();
        return DbUtils.updateSql(conn,sql,args);
    }

    public <T> List<T> search(Class<T> type,String sql,Object ... args){
        Connection conn = JdbcUtils.getConnection();
        return DbUtils.queryForList(conn, type,sql,args);
    }
}
