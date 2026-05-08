package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    // Database credentials
    private static final String URL = "jdbc:mysql://localhost:3306/vls_database";
    private static final String USER = "root";
    private static final String PASSWORD = "DatabasePass@33"; // Use the password you set

    public static Connection getConnection() {
        Connection connection = null;
        try {
            // Load the driver (not always strictly required in newer Java, but good practice)
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ Connected to the VLS Database successfully!");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("❌ Connection Failed!");
            e.printStackTrace();
        }
        return connection;
    }
}
