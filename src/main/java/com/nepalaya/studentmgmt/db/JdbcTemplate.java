package com.nepalaya.studentmgmt.db;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JdbcTemplate<T> {

    private final DatabaseHelper databaseHelper = new DatabaseHelper();

    public List<T> getAll(String sql, RowMapper<T> mapper) throws Exception {
        try {
            databaseHelper.connect();
            databaseHelper.initialize(sql);
            ResultSet resultSet = databaseHelper.execute();
            List<T> rows = new ArrayList<>();
            while (resultSet.next()) {
                rows.add(mapper.map(resultSet));
            }
            return rows;
        } finally {
//            databaseHelper.close();
        }
    }

    public Optional<T> getOneByObject(String sql, Object[] parameters, RowMapper<T> mapper) throws Exception {
        try {
            databaseHelper.connect();
            PreparedStatement preparedStatement = databaseHelper.initialize(sql);
            addParameter(preparedStatement, parameters);
            ResultSet resultSet = databaseHelper.execute();
            while (resultSet.next()) {
                return Optional.of(mapper.map(resultSet));
            }
            return Optional.empty();
        } finally {
//            databaseHelper.close();
        }
    }

    public int update(String sql, Object[] parameters) throws Exception {
        try {
            databaseHelper.connect();
            PreparedStatement preparedStatement = databaseHelper.initialize(sql);
            addParameter(preparedStatement, parameters);
            return databaseHelper.update();
        } finally {
//            databaseHelper.close();
        }
    }

    public void addParameter(PreparedStatement preparedStatement, Object[] parameters) throws Exception {
        int index = 1;
        for (Object parameter : parameters) {
            preparedStatement.setObject(index++, parameter);
        }
    }
}
