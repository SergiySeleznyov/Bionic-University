package com.database;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.beans.Statement;
import java.net.URI;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Sergiy on 04.07.2015.
 */
public class Main {

    private static final String URL="jdbc:mysql://localhost:3306/mydbtest";
    private static final String USERNAME="root";
    private static final String PASSWORD="root";

    public static void main(String[] args){



        try {
            Connection connection=DriverManager.getConnection(URL,USERNAME, PASSWORD);
            java.sql.Statement statement= connection.createStatement();
            statement.addBatch("INSERT INTO animal(anim_name, anim_desk) VALUES ('batch1','desk');");
            statement.addBatch("INSERT INTO animal(anim_name, anim_desk) VALUES ('batch2','desk');");
            statement.addBatch("INSERT INTO animal(anim_name, anim_desk) VALUES ('batch3','desk');");
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
