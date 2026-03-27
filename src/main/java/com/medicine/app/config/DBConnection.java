package com.medicine.app.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {


    static String url = "jdbc:mysql://localhost:3306/dbTest";
    static String user = "root";
    static String password = "PB98@study";

    public static Connection getConnection()
    {
        Connection con=null;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded ✅");
            con= DriverManager.getConnection(url,user,password);
            System.out.println("Connection Success ✅");

        }

        catch(Exception e)
        {
            e.printStackTrace();
        }
        return con;
    }
}


