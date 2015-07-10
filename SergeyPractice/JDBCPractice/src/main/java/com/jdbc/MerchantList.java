package com.jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

/**
 * Created by c263 on 10.07.2015.
 */
public class MerchantList {
    public static void main(String[] args) throws IOException, SQLException{
        Connection conn = getConnection();
        ArrayList<Merchant> list = getMerchants(conn);
        for (Merchant m : list){
            System.out.println(m.getStringForPrint());
        }
    }

    public static ArrayList<Merchant> getMerchants(Connection conn) throws SQLException{
        ArrayList<Merchant> ret = new ArrayList<Merchant>();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT id, name, charge, period, total FROM merchant");
        while (rs.next()){
            Merchant m = new Merchant();
            m.setId(rs.getInt("id"));
            m.setName(rs.getString("name"));
            m.setCharge(rs.getDouble("charge"));
            m.setPeriod(rs.getInt("period"));
            m.setTotal(rs.getDouble("total"));
            ret.add(m);
        }
        return ret;
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
