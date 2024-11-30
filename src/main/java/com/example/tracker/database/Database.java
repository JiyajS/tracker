package com.example.tracker.database;

import java.sql.*;

import static com.example.tracker.database.Const.*;
import static com.example.tracker.database.DBConst.*;

/**
 * This class sets up the database using Singleton Design Pattern:
 * - Ensures a single shared connection to the database
 * - Automatically creates tables if they do not exist
 */
public class Database {

    // Singleton instance
    private static Database instance;
    private Connection connection;

    // Private constructor
    private Database() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost/" + DB_NAME +
                                    "?serverTimezone=UTC",
                            DB_USER,
                            DB_PASS);
            System.out.println("Database connection established!");

            // Create tables
            createTable(DBConst.TABLE_USER, CREATE_TABLE_USER, connection);
            createTable(DBConst.TABLE_ALLOCATION, CREATE_TABLE_ALLOCATION, connection);
            createTable(DBConst.TABLE_SAVINGS, CREATE_TABLE_SAVINGS, connection);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Get Singleton instance
    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }
    public Connection getConnection(){return connection;};

    // Create table method
    public void createTable(String tableName, String tableQuery, Connection connection) throws SQLException {
        Statement createTable;
        DatabaseMetaData metadata = connection.getMetaData();
        ResultSet resultSet = metadata.getTables(DB_NAME, null, tableName, null);
        if (resultSet.next()) {
            System.out.println(tableName + " table already exists");
        } else {
            createTable = connection.createStatement();
            createTable.execute(tableQuery);
            System.out.println("The " + tableName + " table has been created");
        }
    }
}
