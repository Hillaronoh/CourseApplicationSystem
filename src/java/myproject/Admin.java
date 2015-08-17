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
    //display total number of applicants
    PreparedStatement pst10=null;
    //display total number of degree applicants
    PreparedStatement pst11=null;
    //display total number of diploma applicants
    PreparedStatement pst12=null;
    //display total number of certificate applicants
    PreparedStatement pst13=null;
    //display total number of degree computer science applicants
    PreparedStatement pst14=null;
    //display total number of degree IT applicants
    PreparedStatement pst15=null;
    //display total number of degree informatics applicants
    PreparedStatement pst16=null;
    //display total number of degree computer forensics applicants
    PreparedStatement pst17=null;
    //display total number of diploma computer science applicants
    PreparedStatement pst18=null;
    //display total number of diploma IT applicants
    PreparedStatement pst19=null;
    //display total number of diploma informatics applicants
    PreparedStatement pst20=null;
    //display total number of diploma computer forensics applicants
    PreparedStatement pst21=null;
    //display total number of cert computer science applicants
    PreparedStatement pst22=null;
    //display total number of cert IT applicants
    PreparedStatement pst23=null;
    //display total number of cert informatics applicants
    PreparedStatement pst24=null;
    //display total number of cert computer forensics applicants
    PreparedStatement pst25=null;
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
            pst7=conn.prepareStatement("UPDATE inquiries SET Reply=?, Reply_Date=(now()) WHERE Sender=? AND Message=?");
            pst8=conn.prepareStatement("SELECT * FROM inquiries WHERE Sender=? AND Reply IS NOT NULL");
            pst9=conn.prepareStatement("UPDATE inquiries SET Reply=? WHERE Sender=? AND Message=?");
            //display total number of applicants
            pst10=conn.prepareStatement("SELECT count(*) FROM course_details");
            //display total number of degree applicants
            pst11=conn.prepareStatement("SELECT count(*) FROM course_details WHERE Level_id=3");
            //display total number of diploma applicants
            pst12=conn.prepareStatement("SELECT count(*) FROM course_details WHERE Level_id=4");
            //display total number of certificate applicants
            pst13=conn.prepareStatement("SELECT count(*) FROM course_details WHERE Level_id=5");
            //display total number of degree computer science applicants
            pst14=conn.prepareStatement("SELECT count(*) FROM course_details WHERE Level_id=3 AND Course_id=1");
            //display total number of degree IT applicants
            pst15=conn.prepareStatement("SELECT count(*) FROM course_details WHERE Level_id=3 AND Course_id=2");
            //display total number of degree informatics applicants
            pst16=conn.prepareStatement("SELECT count(*) FROM course_details WHERE Level_id=3 AND Course_id=3");
            //display total number of degree computer forensics applicants
            pst17=conn.prepareStatement("SELECT count(*) FROM course_details WHERE Level_id=3 AND Course_id=4");
            //display total number of degree computer science applicants
            pst18=conn.prepareStatement("SELECT count(*) FROM course_details WHERE Level_id=4 AND Course_id=1");
            //display total number of diploma IT applicants
            pst19=conn.prepareStatement("SELECT count(*) FROM course_details WHERE Level_id=4 AND Course_id=2");
            //display total number of diploma informatics applicants
            pst20=conn.prepareStatement("SELECT count(*) FROM course_details WHERE Level_id=4 AND Course_id=3");
            //display total number of diploma informatics applicants
            pst21=conn.prepareStatement("SELECT count(*) FROM course_details WHERE Level_id=4 AND Course_id=4");
            //display total number of cert computer science applicants
            pst22=conn.prepareStatement("SELECT count(*) FROM course_details WHERE Level_id=5 AND Course_id=1");
            //display total number of cert IT applicants
            pst23=conn.prepareStatement("SELECT count(*) FROM course_details WHERE Level_id=5 AND Course_id=2");
            //display total number of cert informatics applicants
            pst24=conn.prepareStatement("SELECT count(*) FROM course_details WHERE Level_id=5 AND Course_id=3");
            //display total number of cert computer forensics applicants
            pst25=conn.prepareStatement("SELECT count(*) FROM course_details WHERE Level_id=5 AND Course_id=4");
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
    //display total number of applicants
    public ResultSet getTotalApplicants(){
        ResultSet rs=null;
        try{
           rs=pst10.executeQuery();
        }
        catch(SQLException e){
            e.printStackTrace(System.out);
        }
        return rs;
    }
    //display total number of degree applicants
    public ResultSet getDegreeApplicants(){
        ResultSet rs=null;
        try{
           rs=pst11.executeQuery();
        }
        catch(SQLException e){
            e.printStackTrace(System.out);
        }
        return rs;
    }
    //display total number of diploma applicants
    public ResultSet getDiplomaApplicants(){
        ResultSet rs=null;
        try{
           rs=pst12.executeQuery();
        }
        catch(SQLException e){
            e.printStackTrace(System.out);
        }
        return rs;
    }
    //display total number of certificate applicants
    public ResultSet getCertApplicants(){
        ResultSet rs=null;
        try{
           rs=pst13.executeQuery();
        }
        catch(SQLException e){
            e.printStackTrace(System.out);
        }
        return rs;
    }
    //display total number of degree computer science applicants
    public ResultSet getDegCsApplicants(){
        ResultSet rs=null;
        try{
           rs=pst14.executeQuery();
        }
        catch(SQLException e){
            e.printStackTrace(System.out);
        }
        return rs;
    }
    //display total number of degree IT applicants
    public ResultSet getDegItApplicants(){
        ResultSet rs=null;
        try{
           rs=pst15.executeQuery();
        }
        catch(SQLException e){
            e.printStackTrace(System.out);
        }
        return rs;
    }
    //display total number of degree informatics applicants
    public ResultSet getDegInfoApplicants(){
        ResultSet rs=null;
        try{
           rs=pst16.executeQuery();
        }
        catch(SQLException e){
            e.printStackTrace(System.out);
        }
        return rs;
    }
    //display total number of degree computer forensic applicants
    public ResultSet getDegCfApplicants(){
        ResultSet rs=null;
        try{
           rs=pst17.executeQuery();
        }
        catch(SQLException e){
            e.printStackTrace(System.out);
        }
        return rs;
    }
    //display total number of diploma computer science applicants
    public ResultSet getDipCsApplicants(){
        ResultSet rs=null;
        try{
            rs=pst18.executeQuery();
        }
        catch(SQLException e){
            e.printStackTrace(System.out);
        }
        return rs;
    }
    //display total number of diploma IT applicants
    public ResultSet getDipItApplicants(){
        ResultSet rs=null;
        try{
            rs=pst19.executeQuery();
        }
        catch(SQLException e){
            e.printStackTrace(System.out);
        }
        return rs;
    }
    //display total number of diploma informatics applicants
    public ResultSet getDipInfoApplicants(){
        ResultSet rs=null;
        try{
            rs=pst20.executeQuery();
        }
        catch(SQLException e){
            e.printStackTrace(System.out);
        }
        return rs;
    }
    //display total number of diploma computer forensics applicants
    public ResultSet getDipCfApplicants(){
        ResultSet rs=null;
        try{
            rs=pst21.executeQuery();
        }
        catch(SQLException e){
            e.printStackTrace(System.out);
        }
        return rs;
    }
    //display total number of cert computer science applicants
    public ResultSet getCertCsApplicants(){
        ResultSet rs=null;
        try{
            rs=pst22.executeQuery();
        }
        catch(SQLException e){
            e.printStackTrace(System.out);
        }
        return rs;
    }
    //display total number of cert IT applicants
    public ResultSet getCertItApplicants(){
        ResultSet rs=null;
        try{
            rs=pst23.executeQuery();
        }
        catch(SQLException e){
            e.printStackTrace(System.out);
        }
        return rs;
    }
    //display total number of cert informatics applicants
    public ResultSet getCertInfoApplicants(){
        ResultSet rs=null;
        try{
            rs=pst24.executeQuery();
        }
        catch(SQLException e){
            e.printStackTrace(System.out);
        }
        return rs;
    }
    //display total number of cert computer forensics applicants
    public ResultSet getCertCfApplicants(){
        ResultSet rs=null;
        try{
            rs=pst25.executeQuery();
        }
        catch(SQLException e){
            e.printStackTrace(System.out);
        }
        return rs;
    }
}