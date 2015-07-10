package com.jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Properties;

/**
 * Created by c263 on 10.07.2015.
 */
public class AddPayment {
    public static void main(String[] args) throws IOException, SQLException{
        Connection conn = getConnection();
        int merchantId = 4;
        int customerId = 1;
        java.util.Date dt = new java.util.Date();
        String goods = "NOD32 Antivirus";
        double total = 33.80;
        addPayment(conn, dt, customerId, merchantId, goods, total);
        conn.close();
        System.out.println("Payment was added");
    }

    public static void addPayment(Connection conn, java.util.Date dt, int customerId, int merchantId, String goods, double total) throws SQLException {

        conn.setAutoCommit(false);
        double charge = getCharge(conn, merchantId);
        if (charge < 0.0) return;

        // Insert new record into PAYMENT table
        String sqlIns = "insert into payment(dt, customerId, merchantId, goods, total, charge) values(?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt1 = conn.prepareStatement(sqlIns);
        Date dt1 = new Date(dt.getTime());
        stmt1.setDate(1, dt1);
        stmt1.setInt(2, customerId);
        stmt1.setInt(3, merchantId);
        stmt1.setString(4, goods);
        stmt1.setDouble(5, total);
        double p = Math.round(total * charge) / 100.0;
        stmt1.setDouble(6, p);
        stmt1.executeUpdate();

        // Update corresponding record in MERCHANT table
        String sqlUpdt = "update merchant set total = total + ? where id = ?";
        PreparedStatement stmt2 = conn.prepareStatement(sqlUpdt);
        double s = total - p;
        stmt2.setDouble(1, s);
        stmt2.setInt(2, merchantId);
        stmt2.executeUpdate();
        conn.commit();
    }

    public static double getCharge(Connection conn, int merchantId) throws SQLException{
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT charge FROM merchant where id = " + merchantId);
        if (rs.next() == false) return -1.0;
        double ret = rs.getDouble("charge");
        rs.close();
        stmt.close();
        return ret;
    }

    public static Connection getConnection() throws IOException, SQLException{
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
