package org.example.datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MariaDbConnection {

    static Connection connection = null;

    public static Connection getConnection() throws SQLException {
        if (connection != null) {
            return connection;
        }

        String url = "jdbc:mariadb://localhost:3306/currency?user=appuser&password=password";

        connection = DriverManager.getConnection(url);

        return connection;
    }

    public static void terminate() throws SQLException {
        getConnection().close();
        connection = null;
    }
}
