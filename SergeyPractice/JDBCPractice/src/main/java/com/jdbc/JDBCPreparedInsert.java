package com.jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Properties;

/**
 * Created by c263 on 10.07.2015.
 */
public class JDBCPreparedInsert {
    public static void main(String[] args) throws SQLException, IOException{
        java.util.Date dt1 = new GregorianCalendar(2014, Calendar.FEBRUARY, 15).getTime();
        java.sql.Date dt = new java.sql.Date(dt1.getTime());
        addCustomer("Willy Nest", "Mountain View, California", "wnest@alpha.com",
                "54664423893279", "Visa", dt);
        printCustomers();
    }

    public static void addCustomer(String name, String address, String email,
                                   String ccNo, String ccType, java.sql.Date dt)
            throws SQLException, IOException{
        Connection con = getConnection();
        String sql = "INSERT INTO customer (name, address, email, ccNo, ccType, maturity) " +
                "values(?,?,?,?,?,?)";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, name);
        stmt.setString(2, address);
        stmt.setString(3, email);
        stmt.setString(4, ccNo);
        stmt.setString(5, ccType);
        stmt.setDate(6, dt);
        stmt.executeUpdate();
        con.close();
    }

    public static void printCustomers() throws IOException, SQLException {
        Connection con = getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT name, address, email FROM customer");
        while (rs.next()){
            String nm = rs.getString("name");
            String addr = rs.getString(2);
            String email = rs.getString("email");
            String txt = String.format("%1$15s   %2$35s   %3$20s", nm, addr, email);
            System.out.println(txt);
        }
        con.close();
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
