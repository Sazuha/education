package com.sazuha.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Sazuha
 */
public class DbUtils {

    public static int dmlSql(Connection conn,String sql) {
        Statement stmt = null;
        int result=0;
        try{
        stmt = conn.createStatement();
        result = stmt.executeUpdate(sql);
        }catch (SQLException e){
            result = -1;
        }finally {
            close(conn,stmt,null,null);
            return result;
        }
    }

    public static <T> List<T> queryForList(Connection conn,Class<T> type,String sql,Object ... args){
        List<T> list = new ArrayList<>();

        PreparedStatement preparedStatement = null;
        ResultSet resultSet =null;

        try {
            preparedStatement = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }
            resultSet = preparedStatement.executeQuery();
            List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            Map<String, Object> map = null;

            while (resultSet.next()) {
                map = new HashMap<String, Object>();
                for (int i = 0; i < resultSetMetaData.getColumnCount(); i++) {
                    String columnLabel = resultSetMetaData.getColumnLabel(i + 1);
                    Object columnValue = resultSet.getObject(columnLabel);
                    map.put(columnLabel, columnValue);
                }

                mapList.add(map);
            }
                T bean = null;
                if (mapList.size() > 0) {
                    for (Map<String, Object> m : mapList) {
                        bean = type.newInstance();
                        for (Map.Entry<String, Object> entry : m.entrySet()) {
                            String key = entry.getKey();
                            Object value = entry.getValue();
                            BeanUtils.setProperty(bean, key, value);
                        }
                        list.add(bean);
                    }
                }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            close(conn,null,preparedStatement,resultSet);
        }
        return list;
    }



    private static void close(Connection conn,Statement stmt,PreparedStatement ps,ResultSet rs){
        try {
            if (rs != null) {
                rs.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        try {
            if (ps != null) {
                ps.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        try {
            if (stmt != null) {
                stmt.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }


        if (conn != null) {
            JdbcUtils.close(conn);
        }

    }

    public static int updateSql(Connection conn,String sql,Object ... args) {
        PreparedStatement preparedStatement = null;
        int result=0;
        try{
            preparedStatement = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }
            result = preparedStatement.executeUpdate();
        }catch (SQLException e){
            result = -1;
        }finally {
            close(conn,null,preparedStatement,null);
            return result;
        }
    }
}
