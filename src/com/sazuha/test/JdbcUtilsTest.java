package com.sazuha.test;

import com.sazuha.utils.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;


/**
 * @author Sazuha
 */
public class JdbcUtilsTest {
    @Test
    public void testJdbcUtils() {
        for(int i=1;i<100;i++) {
            Connection connection = JdbcUtils.getConnection();
            System.out.println(connection);
            JdbcUtils.close(connection);
        }
    }
}
