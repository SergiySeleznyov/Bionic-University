package com.jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Properties;

/**
 * Created by c263 on 10.07.2015.
 */
public class MerchantCharge {
    public static void main(String[] args) throws IOException, SQLException{
        Connection conn = getConnection();
        Statement stmt = conn.createStatement();
        String sql = "select m.name, sum(p.charge) as charge from payment p, merchant m where m.id=p.merchantId group by m.name";
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()){
            System.out.format("%1$25s  %2$8.2f \n", rs.getString("name"), rs.getDouble("charge"));
        }
        conn.close();
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
