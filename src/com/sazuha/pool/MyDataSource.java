package com.sazuha.pool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Sazuha
 */
public class MyDataSource extends MyAbstractDataSource{

    private final List<ConnectionProxy> idleConnections = new ArrayList<ConnectionProxy>();

    private final List<ConnectionProxy> activeConnections = new ArrayList<ConnectionProxy>();

    /**
     * 最大活动连接数
     */
    private int poolMaxActiveConnection = 10;
    /**
     * 最大空闲连接数
     */
    private int poolMaxIdleConnection = 5;
    /**
     * 最大等待时间（ms）
     */
    private int poolTimeToWait = 30000;

    private final Object monitor = new Object();

    @Override
    public Connection getConnection() throws SQLException {

        ConnectionProxy connectionProxy = getConnectionProxy(super.getUser(),super.getPassword());
        return connectionProxy.getProxyConnection();
    }

    public ConnectionProxy getConnectionProxy(String username,String password) throws SQLException {
        boolean wait = false;
        ConnectionProxy connectionProxy = null;
        while (connectionProxy == null){

            synchronized (monitor){
                if(!idleConnections.isEmpty()){
                    connectionProxy = idleConnections.remove(0);
                }else{
                    if(activeConnections.size() < poolMaxActiveConnection){
                        connectionProxy = new ConnectionProxy(super.getConnection(),this);
                    }

                }
            }
            if(!wait){
                wait = true;
            }

            if(connectionProxy == null){
                try {
                    synchronized (monitor) {
                        monitor.wait(poolTimeToWait);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }

        }
        if(connectionProxy != null){
            activeConnections.add(connectionProxy);
        }

        return connectionProxy;
    }

    public void closeConnection(ConnectionProxy connectionProxy){
        synchronized (monitor){
            activeConnections.remove(connectionProxy);

            if(idleConnections.size() < poolMaxIdleConnection){
                idleConnections.add(connectionProxy);
            }
            monitor.notify();
        }
    }
}
