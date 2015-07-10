package com.jdbc;

import org.apache.derby.iapi.sql.ResultSet;
import org.apache.derby.iapi.sql.Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by c263 on 10.07.2015.
 */
public class JdbcBasicCon {
    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection("jdbc:derby:C://Users//c263//db");
            java.sql.Statement stmt = con.createStatement();
            java.sql.ResultSet rs = stmt.executeQuery("SELECT name, charge FROM merchant");
            while (rs.next()) {
                String nm = rs.getString("name");
                double p = rs.getDouble(2);
                System.out.format("%1$25s %2$5.2f\n", nm, p);
            }
            con.close();
        } catch (SQLException ex) {
            System.out.println("Error " + ex.getMessage());
        }
    }
}
