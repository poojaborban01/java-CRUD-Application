package com.medicine.app.repository;

import com.medicine.app.config.DBConnection;
import com.medicine.app.entity.MediEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MediRepo {


    public static void saveMedi(MediEntity medi)
    {    Connection con = DBConnection.getConnection();
        String query = "INSERT INTO mediEntity(name,price,quantity) values(?,?,?)";

        try
        {
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1,medi.getName() );
            ps.setDouble(2,medi.getPrice() );
            ps.setInt(3,medi.getQuantity() );

            ps.executeUpdate();
        }


        catch(Exception e)
        {
            e.printStackTrace();
        }

    }


    public static MediEntity fetchMedi(int id)
    {
        Connection con = DBConnection.getConnection();
        String query = "SELECT*FROM mediEntity WHERE id=?";

        try{

            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1,id);

            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                String name = rs.getString("name");
                double price=rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                System.out.println(name + " " + price + " " + quantity);
            }


        }

        catch(Exception e)
        {
            e.printStackTrace();
        }
    }



    public static void deleteMedi(int id)
    {  Connection con = DBConnection.getConnection();
        String query = "DELETE FROM mediEntity WHERE id=?";
        try{

            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1,id);
            ps.executeUpdate();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }


    public static void UpdateMedi(int id, MediEntity medi)
    {  Connection con = DBConnection.getConnection();
        String query =  "UPDATE mediEntity SET name=?, price=?, quantity=? WHERE id=?";
        try{
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(4,id);
            ps.setString(1,medi.getName());
            ps.setDouble(2,medi.getPrice());
            ps.setInt(3, medi.getQuantity());

            ps.executeUpdate();
        }

        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}









