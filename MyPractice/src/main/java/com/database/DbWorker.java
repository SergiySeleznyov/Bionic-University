package com.database;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Sergiy on 05.07.2015.
 */
public class DbWorker {
    private static final String URL="jdbc:mysql://localhost:3306/mydbtest";
    private static final String USERNAME="root";
    private static final String PASSWORD="root";

    private Connection connection;

    private DbWorker(){
        try {
            Driver driver=new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            System.err.println("Error with downloading driver");
        }
    }


}
