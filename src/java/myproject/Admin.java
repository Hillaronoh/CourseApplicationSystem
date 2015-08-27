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
    //deletes announcement
    PreparedStatement pst26=null;
    //get CS degree applicants for display
    PreparedStatement pst27=null;
    //get IT degree applicants for display
    PreparedStatement pst28=null;
    //get Informatics degree applicants for display
    PreparedStatement pst29=null;
    //get CF degree applicants for display
    PreparedStatement pst30=null;
    //get CS diploma applicants for display
    PreparedStatement pst31=null;
    //get IT diploma applicants for display
    PreparedStatement pst32=null;
    //get Informatics diploma applicants for display
    PreparedStatement pst33=null;
    //get CF diploma applicants for display
    PreparedStatement pst34=null;
    //get IT cert applicants for display
    PreparedStatement pst35=null;
    //get CF cert applicants for display
    PreparedStatement pst36=null;
    //get IS cert applicants for display
    PreparedStatement pst37=null;
    //get HM cert applicants for display
    PreparedStatement pst38=null;
    //rank applicants
    PreparedStatement pst39=null;
    //undo ranking
    PreparedStatement pst40=null;
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
            pst23=conn.prepareStatement("SELECT count(*) FROM course_details WHERE Level_id=5 AND Course_id=5");
            //display total number of cert informatics applicants
            pst24=conn.prepareStatement("SELECT count(*) FROM course_details WHERE Level_id=5 AND Course_id=6");
            //display total number of cert computer forensics applicants
            pst25=conn.prepareStatement("SELECT count(*) FROM course_details WHERE Level_id=5 AND Course_id=4");
            //deletes announcement
            pst26=conn.prepareStatement("DELETE FROM announcements WHERE id=?");
            //get CS degree applicants for display
            pst27=conn.prepareStatement("SELECT a.First_Name, a.Last_Name, c.Email_Address, c.Cluster_Points,"
                    + "(SELECT count(*) FROM course_details WHERE Cluster_Points>c.Cluster_Points AND Level_id=3 AND Course_id=1)+1 AS Rank "
                    + "FROM applicants_details a, course_details c WHERE c.Level_id=3 AND c.Course_id=1 AND a.Email_Address=c.Email_address ORDER BY c.Cluster_Points DESC");
           //get IT degree applicants for display
            pst28=conn.prepareStatement("SELECT a.First_Name, a.Last_Name, c.Email_Address, c.Cluster_Points,"
                    + "(SELECT count(*) FROM course_details WHERE Cluster_Points>c.Cluster_Points AND Level_id=3 AND Course_id=2)+1 AS Rank "
                    + "FROM applicants_details a, course_details c WHERE c.Level_id=3 AND c.Course_id=2 AND a.Email_Address=c.Email_address ORDER BY c.Cluster_Points DESC");
            //get Informatics degree applicants for display
            pst29=conn.prepareStatement("SELECT a.First_Name, a.Last_Name, c.Email_Address, c.Cluster_Points,"
                    + "(SELECT count(*) FROM course_details WHERE Cluster_Points>c.Cluster_Points AND Level_id=3 AND Course_id=3)+1 AS Rank "
                    + "FROM applicants_details a, course_details c WHERE c.Level_id=3 AND c.Course_id=3 AND a.Email_Address=c.Email_address ORDER BY c.Cluster_Points DESC");
           //get CF degree applicants for display
            pst30=conn.prepareStatement("SELECT a.First_Name, a.Last_Name, c.Email_Address, c.Cluster_Points,"
                    + "(SELECT count(*) FROM course_details WHERE Cluster_Points>c.Cluster_Points AND Level_id=3 AND Course_id=4)+1 AS Rank "
                    + "FROM applicants_details a, course_details c WHERE c.Level_id=3 AND c.Course_id=4 AND a.Email_Address=c.Email_address ORDER BY c.Cluster_Points DESC");
            //get CS diploma applicants for display
            pst31=conn.prepareStatement("SELECT a.First_Name, a.Last_Name, c.Email_Address, c.Cluster_Points,"
                    + "(SELECT count(*) FROM course_details WHERE Cluster_Points>c.Cluster_Points AND Level_id=4 AND Course_id=1)+1 AS Rank "
                    + "FROM applicants_details a, course_details c WHERE c.Level_id=4 AND c.Course_id=1 AND a.Email_Address=c.Email_address ORDER BY c.Cluster_Points DESC");
           //get IT diploma applicants for display
            pst32=conn.prepareStatement("SELECT a.First_Name, a.Last_Name, c.Email_Address, c.Cluster_Points,"
                    + "(SELECT count(*) FROM course_details WHERE Cluster_Points>c.Cluster_Points AND Level_id=4 AND Course_id=2)+1 AS Rank "
                    + "FROM applicants_details a, course_details c WHERE c.Level_id=4 AND c.Course_id=2 AND a.Email_Address=c.Email_address ORDER BY c.Cluster_Points DESC");
            //get Informatics diploma applicants for display
            pst33=conn.prepareStatement("SELECT a.First_Name, a.Last_Name, c.Email_Address, c.Cluster_Points,"
                    + "(SELECT count(*) FROM course_details WHERE Cluster_Points>c.Cluster_Points AND Level_id=4 AND Course_id=3)+1 AS Rank "
                    + "FROM applicants_details a, course_details c WHERE c.Level_id=4 AND c.Course_id=3 AND a.Email_Address=c.Email_address ORDER BY c.Cluster_Points DESC");
           //get CF diploma applicants for display
            pst34=conn.prepareStatement("SELECT a.First_Name, a.Last_Name, c.Email_Address, c.Cluster_Points,"
                    + "(SELECT count(*) FROM course_details WHERE Cluster_Points>c.Cluster_Points AND Level_id=4 AND Course_id=4)+1 AS Rank "
                    + "FROM applicants_details a, course_details c WHERE c.Level_id=4 AND c.Course_id=4 AND a.Email_Address=c.Email_address ORDER BY c.Cluster_Points DESC");
            //get IT cert applicants for display
            pst35=conn.prepareStatement("SELECT a.First_Name, a.Last_Name, c.Email_Address, c.Cluster_Points,"
                    + "(SELECT count(*) FROM course_details WHERE Cluster_Points>c.Cluster_Points AND Level_id=5 AND Course_id=2)+1 AS Rank "
                    + "FROM applicants_details a, course_details c WHERE c.Level_id=5 AND c.Course_id=2 AND a.Email_Address=c.Email_address ORDER BY c.Cluster_Points DESC");
           //get CF cert applicants for display
            pst36=conn.prepareStatement("SELECT a.First_Name, a.Last_Name, c.Email_Address, c.Cluster_Points,"
                    + "(SELECT count(*) FROM course_details WHERE Cluster_Points>c.Cluster_Points AND Level_id=5 AND Course_id=4)+1 AS Rank "
                    + "FROM applicants_details a, course_details c WHERE c.Level_id=5 AND c.Course_id=4 AND a.Email_Address=c.Email_address ORDER BY c.Cluster_Points DESC");
            //get IS cert applicants for display
            pst37=conn.prepareStatement("SELECT a.First_Name, a.Last_Name, c.Email_Address, c.Cluster_Points,"
                    + "(SELECT count(*) FROM course_details WHERE Cluster_Points>c.Cluster_Points AND Level_id=5 AND Course_id=5)+1 AS Rank "
                    + "FROM applicants_details a, course_details c WHERE c.Level_id=5 AND c.Course_id=5 AND a.Email_Address=c.Email_address ORDER BY c.Cluster_Points DESC");
           //get HM cert applicants for display
            pst38=conn.prepareStatement("SELECT a.First_Name, a.Last_Name, c.Email_Address, c.Cluster_Points,"
                    + "(SELECT count(*) FROM course_details WHERE Cluster_Points>c.Cluster_Points AND Level_id=5 AND Course_id=6)+1 AS Rank "
                    + "FROM applicants_details a, course_details c WHERE c.Level_id=5 AND c.Course_id=6 AND a.Email_Address=c.Email_address ORDER BY c.Cluster_Points DESC");
            //rank applicants
            pst39=conn.prepareStatement("INSERT INTO ranking VALUES(?,?,?)");
            //undo ranking
            pst40=conn.prepareStatement("DELETE FROM ranking WHERE Level_id=?");
           
            /*pst27=conn.prepareStatement("SELECT    Email_Address,\n" +
            "              Physics_Grade,\n" +
            "              Cluster_Points,\n" +
            "              IF(Cluster_Points=@_last_age,@curRank:=@curRank,@curRank:=@_sequence) AS rank,\n" +
            "              @_sequence:=@_sequence+1,@_last_age:=Cluster_Points\n" +
            "    FROM      education_background, (SELECT @curRank := 1, @_sequence:=1, @_last_age:=0) r\n" +
            "     ORDER BY  Cluster_Points DESC;");*/
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
    public ResultSet getCertIsApplicants(){
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
    public ResultSet getCertHmApplicants(){
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
    //deletes announcements
    public int deleteAnn(int id){
        int i=0;
        try{
           pst26.setInt(1, id); 
           i=pst26.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace(System.out);
        }
        return i;
    }
    //display CS degree applicants
    public ResultSet displayCsDegApplicants(){
        ResultSet rs=null;
        try{
            rs=pst27.executeQuery();
        }
        catch(SQLException e){
            e.printStackTrace(System.out);
        }
        return rs;
    }
    //display IT degree applicants
    public ResultSet displayItDegApplicants(){
        ResultSet rs=null;
        try{
            rs=pst28.executeQuery();
        }
        catch(SQLException e){
            e.printStackTrace(System.out);
        }
        return rs;
    }
    //display Informatics degree applicants
    public ResultSet displayInfoDegApplicants(){
        ResultSet rs=null;
        try{
            rs=pst29.executeQuery();
        }
        catch(SQLException e){
            e.printStackTrace(System.out);
        }
        return rs;
    }
    //display CF degree applicants
    public ResultSet displayCfDegApplicants(){
        ResultSet rs=null;
        try{
            rs=pst30.executeQuery();
        }
        catch(SQLException e){
            e.printStackTrace(System.out);
        }
        return rs;
    }
     //display CS diploma applicants
    public ResultSet displayCsDipApplicants(){
        ResultSet rs=null;
        try{
            rs=pst31.executeQuery();
        }
        catch(SQLException e){
            e.printStackTrace(System.out);
        }
        return rs;
    }
    //display IT diploma applicants
    public ResultSet displayItDipApplicants(){
        ResultSet rs=null;
        try{
            rs=pst32.executeQuery();
        }
        catch(SQLException e){
            e.printStackTrace(System.out);
        }
        return rs;
    }
    //display Informatics diploma applicants
    public ResultSet displayInfoDipApplicants(){
        ResultSet rs=null;
        try{
            rs=pst33.executeQuery();
        }
        catch(SQLException e){
            e.printStackTrace(System.out);
        }
        return rs;
    }
    //display CF diploma applicants
    public ResultSet displayCfDipApplicants(){
        ResultSet rs=null;
        try{
            rs=pst34.executeQuery();
        }
        catch(SQLException e){
            e.printStackTrace(System.out);
        }
        return rs;
    }
    //display IT cert applicants
    public ResultSet displayItCertApplicants(){
        ResultSet rs=null;
        try{
            rs=pst35.executeQuery();
        }
        catch(SQLException e){
            e.printStackTrace(System.out);
        }
        return rs;
    }
    //display CF cert applicants
    public ResultSet displayCfCertApplicants(){
        ResultSet rs=null;
        try{
            rs=pst36.executeQuery();
        }
        catch(SQLException e){
            e.printStackTrace(System.out);
        }
        return rs;
    }
    //display IS cert applicants
    public ResultSet displayIsCertApplicants(){
        ResultSet rs=null;
        try{
            rs=pst37.executeQuery();
        }
        catch(SQLException e){
            e.printStackTrace(System.out);
        }
        return rs;
    }
    //display HM cert applicants
    public ResultSet displayHmCertApplicants(){
        ResultSet rs=null;
        try{
            rs=pst38.executeQuery();
        }
        catch(SQLException e){
            e.printStackTrace(System.out);
        }
        return rs;
    }
    //ranking
    public int ranking(int levelId, int crsId, int requiredNumber){
        int i=0;
        try{
        pst39.setInt(1, levelId);
        pst39.setInt(2, crsId);
        pst39.setInt(3, requiredNumber);
        i=pst39.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace(System.out);
        }
        return i;
    }
    //undo ranking
    public int undoRanking(int levelId){
        int i=0;
        try{
        pst40.setInt(1, levelId);
        i=pst40.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace(System.out);
        }
        return i;
    }
}