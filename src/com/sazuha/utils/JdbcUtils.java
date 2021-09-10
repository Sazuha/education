package com.sazuha.utils;
import com.sazuha.pool.MyDataSource;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author Sazuha
 */
public class JdbcUtils {
    private static MyDataSource dataSource = new MyDataSource();
    static {
        Properties prop = new Properties();
        try {
            prop.load(JdbcUtils.class.getResourceAsStream("/jdbc.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        dataSource.setDriver(prop.getProperty("driver"));
        dataSource.setPassword(prop.getProperty("password"));
        dataSource.setUrl(prop.getProperty("url"));
        dataSource.setUser(prop.getProperty("user"));
    }

    public static Connection getConnection(){
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void close(Connection conn){
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void setDataSource(MyDataSource dataSource) {
        JdbcUtils.dataSource = dataSource;
    }
}
