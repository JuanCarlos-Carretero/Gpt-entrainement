package com.entrainement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionBdd {

    private static Connection connection = null;

    private ConnectionBdd() {
    }

    public static Connection getConnection() {
        if (connection == null) {
            try {
                String url = "jdbc:oracle:thin:@localhost:1521/FREEPDB1";
                String user = "hr";
                String password = "oracle";
                connection = DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println(e);
            }
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println(e);
            }
        }
    }
}