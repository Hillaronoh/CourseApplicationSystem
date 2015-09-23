/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package myproject;

import java.sql.*;

/**
 *
 * @author hillary
 */
public class Common {
    static Connection conn=null;
    String db="jdbc:mysql:///project1c";
    String user="root";
    String password="";
    static PreparedStatement pst11=null;
    PreparedStatement pst=null;
    
    public Common() throws ClassNotFoundException{
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(db,user,password);
            pst11=conn.prepareStatement("SELECT * FROM announcements");
            pst=conn.prepareStatement("SELECT * FROM registration WHERE Email_Address=? AND Password=?");
        }
        catch(SQLException e){
            e.printStackTrace(System.out);
        }
    }
    //get posted announcements
    public static ResultSet getAnnouncements(){
        ResultSet rs=null;
        try{
            rs=pst11.executeQuery();
        }
        catch(SQLException e){
            e.printStackTrace(System.out);
        }
        return rs;
    }
    //login
    public ResultSet login(String email, String password){
        ResultSet rs=null;
        try{
            pst.setString(1, email);
            pst.setString(2, password);
            rs=pst.executeQuery();
        }
        catch(SQLException e){
            e.printStackTrace(System.out);
        }
        return rs;
    }
}

