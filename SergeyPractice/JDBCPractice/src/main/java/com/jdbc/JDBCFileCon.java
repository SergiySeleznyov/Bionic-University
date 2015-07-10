package com.jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Properties;

/**
 * Created by c263 on 10.07.2015.
 */
public class JDBCFileCon {

    public static void main(String[] args) {
        try{
            Connection con = getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT name, charge FROM merchant");
            while (rs.next()){
                String nm = rs.getString("name");
                double p = rs.getDouble(2);
                String txt = String.format("%1$25s   %2$5.2f", nm, p);
                System.out.println(txt);
            }
            con.close();
        }
        catch(Exception ex){
            System.out.println("Error " + ex.getMessage());
        }
    }

    public static Connection getConnection() throws IOException, SQLException {
        Connection conn = null;
        Properties props = new Properties();
        InputStreamReader in = new InputStreamReader(new FileInputStream("appProperties.txt"), "UTF-8");
        props.load(in);
        in.close();

        String connString = props.getProperty("DBConnectionString");
        conn = DriverManager.getConnection(connString);
        return conn;
    }

}

