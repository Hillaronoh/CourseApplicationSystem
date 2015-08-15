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
    //announcements
    PreparedStatement pst1=null;
    //replied inquiries
    PreparedStatement pst2=null;
    PreparedStatement pst3=null;
    PreparedStatement pst4=null;
    //unreplied inquiries
    PreparedStatement pst5=null;
    PreparedStatement pst6=null;
    PreparedStatement pst7=null;
    PreparedStatement pst8=null;
    PreparedStatement pst9=null;
    //constructor
    public Admin() throws ClassNotFoundException{
        Common connection=new Common();
        try{
            
            pst=conn.prepareStatement("SELECT First_Name FROM registration WHERE Email_Address=? AND Role_id=?");
            //announcements
            pst1=conn.prepareStatement("INSERT INTO announcements(Title,Body,Post_Date) VALUES(?,?,now())");
            //replied inquiries
            pst2=conn.prepareStatement("SELECT * FROM inquiries WHERE Reply IS NOT NULL");
            pst3=conn.prepareStatement("DELETE FROM inquiries WHERE Sender=? AND Message=? AND Reply=?");
            //unreplied inquiries
            pst5=conn.prepareStatement("SELECT * FROM inquiries");
            pst6=conn.prepareStatement("SELECT First_Name, Last_Name FROM applicants_details WHERE Email_Address=?");
            pst7=conn.prepareStatement("UPDATE inquiries SET Reply=?, Reply_Date=now() WHERE Sender=? AND Message=?");
            pst8=conn.prepareStatement("SELECT Message, Sent_Date, Reply FROM inquiries WHERE Sender=?");
            pst9=conn.prepareStatement("UPDATE inquiries SET Reply=? WHERE Sender=? AND Message=?");
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
    //inserts announcements.
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
    //gets replied inquiries for display
    public ResultSet getRepliedInquiries(){
        ResultSet rs=null;
        try{
            rs=pst2.executeQuery();
        }
        catch(SQLException e){
            e.printStackTrace(System.out);
        }
        return rs;
    }
    //deletes an inquiry
    public int deleteInquiry(String email, String message, String reply){
        int i=0;
        try{
            pst3.setString(1, email);
            pst3.setString(2, message);
            pst3.setString(3, reply);
            i=pst3.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace(System.out);
        }
        return i;
    }
    //get unreplied inquiries for display
    public ResultSet getUnrepliedInquiries(){
        ResultSet rs=null;
        try{
            rs=pst5.executeQuery();
        }
        catch(SQLException e){
            e.printStackTrace(System.out);
        }
        return rs;
    }
    //gets the sender of the inquiry
    public ResultSet getSender(String email){
        ResultSet rs=null;
        try{
            pst6.setString(1, email);
            rs=pst6.executeQuery();
        }
        catch(SQLException e){
            e.printStackTrace(System.out);
        }
        return rs;
    }
    //inserts reply
    public int setReply(String reply,String email,String message){
        int i=0;
        try{
            pst7.setString(1, reply);
            pst7.setString(2, email);
            pst7.setString(3, message);
            i=pst7.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace(System.out);
        }
        return i;
    }
    //set reply=ignored
    public int setIgnore(String reply,String email,String message){
        int i=0;
        try{
            pst7.setString(1, reply);
            pst7.setString(2, email);
            pst7.setString(3, message);
            i=pst7.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace(System.out);
        }
        return i;
    }
    //get previous+present chats
    public ResultSet getChats(String email){
        ResultSet rs=null;
        try{
            pst8.setString(1, email);
            rs=pst8.executeQuery();
        }
        catch(SQLException e){
            e.printStackTrace(System.out);
        }
        return rs;
    }
}