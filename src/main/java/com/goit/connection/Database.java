package com.goit.connection;

import org.h2.Driver;

import java.sql.*;

public class Database {
//    private static final String H2_URL = "jdbc:h2:mem:local";
    private static final String H2_URL = "jdbc:h2:~/test7";
    private final Connection connection;

    private Database() throws SQLException {
        DriverManager.registerDriver(new Driver());
        connection = DriverManager.getConnection(H2_URL);
    }

    public static Database getInstance () {
        try {
            return new Database();
        } catch (Exception e) {
            throw new DatabaseException("Database instantiation was failed", e);
        }
    }

    public Connection getConnection () {
        return connection;
    }

    public int executeUpdate(String sql) {
        try (Statement st = connection.createStatement()) {
            return st.executeUpdate(sql);
        } catch (SQLException e) {
            throw new DatabaseException("Sql execute failed" , e);
        }
    }

    public ResultSet executeQuery(String sql) {
        try {
            Statement st = connection.createStatement();
            return st.executeQuery(sql);
        } catch (SQLException e) {
            throw new DatabaseException("Sql execute failed" , e);
        }
    }
}
