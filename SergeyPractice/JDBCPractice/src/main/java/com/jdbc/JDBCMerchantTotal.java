package com.jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Properties;

/**
 * Created by c263 on 10.07.2015.
 */
public class JDBCMerchantTotal {
    public static void main(String[] args) throws IOException, SQLException{
        int len=args.length;
        if(len==0) return;
        int id=Integer.valueOf(args[0]);
        Connection con=getConnection();
        String sql="select sum(total) from Payment where merchantId=?";
        PreparedStatement stmt=con.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        rs.next();
        double sum=rs.getDouble(1);
        con.close();
        System.out.println(sum);
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
