/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsc.Databases;

import dsc.users;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ahmed
 */
public class Databases {
       
    public Connection connect() 
      {
        Connection con = null;
          try {
              con= DriverManager.getConnection("jdbc:sqlite:DSC");
              System.out.println("System is connted");
          } catch (SQLException ex) {
              System.out.println(ex.getMessage());
          }
           
        return con;
    }
    
    public void create(){
        Connection con = connect();
        try {
           java.sql.PreparedStatement ps = con.prepareStatement
                ("CREATE TABLE users (name TEXT,age INTEGER,Addresse TEXT )");
            System.out.println("Table is created");
            
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void insert(String name ,int age ,String Addresse){
        Connection con =connect();
         try {
           java.sql.PreparedStatement ps = con.prepareStatement
                ("INSERT into users values (?,?,?)");
            System.out.println("Table is created");
            
            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, Addresse);
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void update(String name,int age,String Addresse){
        
        Connection con =connect();
          try {
           java.sql.PreparedStatement ps = con.prepareStatement
                ("UPDATE users set age =? ,Addresse = ? WHERE name =?");
            System.out.println("Table is created");
            ps.setInt(1, age);
            ps.setString(2, Addresse);
            ps.setString(3, name);
            System.out.println(" table is updated");
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
    public void Delete(String name){
           Connection con =connect();
          try {
           java.sql.PreparedStatement ps = con.prepareStatement
                ("Delete FROM users WHERE name =?");
            ps.setString(1, name);
            System.out.println(" row is deleted");
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public ArrayList<users> getusers(){
        ArrayList<users> arrayList =new ArrayList<>();
        Connection c =connect();
        try {
            java.sql.PreparedStatement ps =c.prepareStatement("SELECT * FROM users");
            
            ResultSet resultSet =ps.executeQuery();
            while (resultSet.next()) {                
                arrayList.add(new users
          (resultSet.getString("name"), resultSet.getString("age"), resultSet.getString("Addresse")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return arrayList;
    }
    
}