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
public class Admin {
    Connection conn=Common.conn;
    PreparedStatement pst=null;
    PreparedStatement pst1=null;
    //constructor
    public Admin() throws ClassNotFoundException{
        Common connection=new Common();
        try{
           
            pst=conn.prepareStatement("SELECT First_Name FROM registration WHERE Email_Address=? AND Role_id=?");
            pst1=conn.prepareStatement("INSERT INTO announcements(Title,Body) VALUES(?,?)");
        }
        catch(SQLException e)
        {
            e.printStackTrace(System.out);
        }
    }
    //get admin details for profiling
    public ResultSet getAdmin(String email){
        ResultSet rs=null;
        try{
            pst.setString(1, email);
            pst.setInt(2, 1);
            rs=pst.executeQuery();
        }
        catch(SQLException e){
            e.printStackTrace(System.out);
        }
        return rs;
    }
    
    public int setAnnouncement(String title, String body){
        int i=0;
        try{
            pst1.setString(1, title);
            pst1.setString(2, body);
            i=pst1.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace(System.out);
        }
        return i;
    }
}
