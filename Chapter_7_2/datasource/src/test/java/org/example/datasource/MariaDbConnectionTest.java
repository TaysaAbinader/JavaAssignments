package org.example.datasource;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

public class MariaDbConnectionTest {

    @Test
    public void testConnection() throws SQLException {
        MariaDbConnection mariaDbConnection = new MariaDbConnection();
        Connection connection = mariaDbConnection.getConnection();
        assertNotNull(connection);
        mariaDbConnection.terminate();
        assertTrue(connection.isClosed());
        assertNull(mariaDbConnection.connection);
    }
}