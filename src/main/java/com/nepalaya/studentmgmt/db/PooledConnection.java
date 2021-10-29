package com.nepalaya.studentmgmt.db;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;

public class PooledConnection {
    private BasicDataSource basicDataSource = null;
    private static PooledConnection pooledConnection = null;

    static {
        pooledConnection = new PooledConnection();
    }

    private PooledConnection(){
        basicDataSource = new BasicDataSource();
        //Set database driver name
        basicDataSource.setDriverClassName(DatabaseConfig.DRIVER_NAME);
        //Set database url
        basicDataSource.setUrl(DatabaseConfig.URL);
        //Set database user
        basicDataSource.setUsername(DatabaseConfig.USERNAME);
        //Set database password
        basicDataSource.setPassword(DatabaseConfig.PASSWORD);
        //Set the connection pool size
        basicDataSource.setInitialSize(10);
        basicDataSource.setMinIdle(100);
        basicDataSource.setMaxIdle(1000);
        basicDataSource.setMaxTotal(1000);
    }

    public static PooledConnection getInstance(){
        return pooledConnection;
    }

    public Connection getConnection() throws Exception {
        System.out.println("Num of active: " + basicDataSource.getNumActive());
        return basicDataSource.getConnection();
    }
}
