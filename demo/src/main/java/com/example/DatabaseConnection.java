package com.example;

import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    // Load environment variables
    private static final Dotenv dotenv = Dotenv.configure()
            .directory("./demo")
            .ignoreIfMissing()
            .load();
    
    // Database credentials from environment variables
    private static final String URL = dotenv.get("DB_URL", "jdbc:mysql://localhost:3306/vls_database");
    private static final String USER = dotenv.get("DB_USER", "root");
    private static final String PASSWORD = dotenv.get("DB_PASSWORD", "");

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
