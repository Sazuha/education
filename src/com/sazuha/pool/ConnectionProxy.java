package com.sazuha.pool;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;

/**
 * @author ASUS
 */
public class ConnectionProxy implements InvocationHandler {

    private Connection realConnection;
    private Connection proxyConnection;
    private MyDataSource myDataSource;

    public Connection getRealConnection() {
        return realConnection;
    }

    public void setRealConnection(Connection realConnection) {
        this.realConnection = realConnection;
    }

    public Connection getProxyConnection() {
        return proxyConnection;
    }

    public void setProxyConnection(Connection proxyConnection) {
        this.proxyConnection = proxyConnection;
    }

    public MyDataSource getMyDataSource() {
        return myDataSource;
    }

    public void setMyDataSource(MyDataSource myDataSource) {
        this.myDataSource = myDataSource;
    }

    public ConnectionProxy(Connection realConnection, MyDataSource myDataSource) {
        this.realConnection = realConnection;
        this.myDataSource = myDataSource;
        this.proxyConnection = (Connection) Proxy.newProxyInstance(Connection.class.getClassLoader(),new Class<?>[]{Connection.class},this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        if("close".equalsIgnoreCase(methodName)){
            myDataSource.closeConnection(this);
            return  null;
        }else{
            return method.invoke(realConnection,args);
        }
    }
}
