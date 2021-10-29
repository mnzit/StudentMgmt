package com.nepalaya.studentmgmt.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DatabaseHelper {

    private Connection connection;
    private PreparedStatement preparedStatement;

    public void connect() throws Exception {
        connection = PooledConnection.getInstance().getConnection();
        System.out.println("Connection: " + connection);
    }

    public PreparedStatement initialize(String sql) throws Exception {
        preparedStatement = connection.prepareStatement(sql);
        return preparedStatement;
    }

    public int update() throws Exception {
        return preparedStatement.executeUpdate();
    }

    public ResultSet execute() throws Exception {
        return preparedStatement.executeQuery();
    }

    public void close() throws Exception {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
        if (preparedStatement != null && !preparedStatement.isClosed()) {
            preparedStatement.close();
        }

        connection = null;
        preparedStatement = null;
    }
}
