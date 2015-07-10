package com.jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Properties;

/**
 * Created by c263 on 10.07.2015.
 */
public class JDBCBasicConInsert {
    public static void main(String[] args) {
        try{
            Connection con = getConnection();
            String sql="INSERT INTO customer (name, address, email, ccNo, ccType, maturity) values('Clar Nelis', 'Vosselaar st. 19, Trnaut, Belgium', 'Clar@adw.com',  '11345694671231', 'MasterCard', '2014-07-31')";
            Statement stmt = con.createStatement();
            stmt.executeUpdate(sql);
            ResultSet rs = stmt.executeQuery("SELECT name, ADDRESS  FROM CUSTOMER");
            while (rs.next()){
                String nm = rs.getString("name");
                String p = rs.getString("address");
                String txt = String.format("%1$25s   %2$35s", nm, p);
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
