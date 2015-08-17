/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package myproject;
import java.sql.*;
import java.text.DecimalFormat;
/**
 *
 * @author hillary
 */
public class Applicant {
    Connection conn=Common.conn;
    
    PreparedStatement pst=null;
    PreparedStatement pst1=null;
    //application
    PreparedStatement pst2=null;
    PreparedStatement pst3=null;
    PreparedStatement pst4=null;
    PreparedStatement pst5=null;
    PreparedStatement pst6=null;
    PreparedStatement pst7=null;
    PreparedStatement pst8=null;
    PreparedStatement pst9=null;
    PreparedStatement check1=null;
    PreparedStatement check2=null;
    //announcements
    PreparedStatement pst11=null;
    PreparedStatement confirmAnn=null;
    //details
    PreparedStatement pst13=null;
    PreparedStatement pst14=null;
    PreparedStatement pst15=null;
    PreparedStatement pst16=null;
    PreparedStatement pst17=null;
    PreparedStatement pst18=null;
    PreparedStatement pst19=null;
    PreparedStatement pst20=null;
    PreparedStatement pst21=null;
    PreparedStatement pst22=null;
    PreparedStatement pst23=null;
    PreparedStatement pst24=null;
    PreparedStatement pst25=null;
    PreparedStatement confirmDet=null;
    PreparedStatement check3=null;
    //inquiries
    PreparedStatement pst27=null;
    PreparedStatement pst28=null;
    //change pwd
    PreparedStatement pst29=null;
    //constructor
    public Applicant() throws ClassNotFoundException{
        Common connection=new Common();
        try{
            //registration
            pst = conn.prepareStatement("INSERT INTO registration VALUES(?,?,?,?,?,?)");
            pst1 = conn.prepareStatement("SELECT * FROM registration WHERE Email_Address=?");
            //application
            pst2=conn.prepareStatement("SELECT First_Name,Middle_Name,Last_Name FROM registration WHERE Email_Address=? AND Role_id=?");
            pst3=conn.prepareStatement("INSERT INTO applicants_details VALUES(?,?,?,?,?,?,?,?,?)");
            pst4=conn.prepareStatement("UPDATE education_background SET Physics_Grade=?, Maths_Grade=?, Subject3_Grade=?, Subject4_Grade=?, Mean_Grade=?, Aggregate_Points=?, Cluster_Points=? WHERE Email_Address=?");
            pst5=conn.prepareStatement("INSERT INTO course_details VALUES(?,?,?,?,?)");
            pst6=conn.prepareStatement("SELECT * FROM campuses");
            pst7=conn.prepareStatement("SELECT * FROM courses");
            pst8=conn.prepareStatement("SELECT Course_id FROM courses WHERE Course_Name=?");
            pst9=conn.prepareStatement("SELECT Level_id FROM course_levels WHERE Level_Name=?");
            check1=conn.prepareStatement("SELECT Email_Address FROM education_background WHERE Email_Address=?");
            check2=conn.prepareStatement("SELECT * FROM education_background WHERE Email_Address=? AND Physics_Grade IS NOT NULL");
            //announcements
            pst11=conn.prepareStatement("SELECT * FROM announcements");
            confirmAnn=conn.prepareStatement("SELECT * FROM announcements");
            //details
            pst13=conn.prepareStatement("SELECT * FROM applicants_details WHERE Email_Address=?");
            pst14=conn.prepareStatement("SELECT * FROM education_background WHERE Email_Address=?");
            pst15=conn.prepareStatement("SELECT * FROM course_details WHERE Email_Address=?");
            pst16=conn.prepareStatement("SELECT Level_Name FROM course_levels WHERE Level_id=?");
            pst17=conn.prepareStatement("SELECT Course_Name FROM courses WHERE Course_id=?");
            pst18=conn.prepareStatement("UPDATE applicants_details SET DoB=?, Gender=?, Postal_Address=?, Mobile=?, Country=? WHERE Email_Address=?");
            pst19=conn.prepareStatement("UPDATE education_background SET Physics_Grade=?, Maths_Grade=?, Subject3_Grade=?, Subject4_Grade=?, Mean_Grade=?, Aggregate_Points=?, Cluster_Points=? WHERE Email_Address=?");
            pst20=conn.prepareStatement("UPDATE course_details SET Level_id=?, Course_id=?, Mode_Of_Study=?, Campus=? WHERE (Email_Address=? AND Level_id=? AND Course_id=? AND Mode_Of_Study=? AND Campus=?)");
            pst21=conn.prepareStatement("SELECT Level_id FROM course_levels WHERE Level_Name=?");
            pst22=conn.prepareStatement("SELECT Course_id FROM courses WHERE Course_Name=?");
            pst23=conn.prepareStatement("SELECT * FROM campuses");
            pst24=conn.prepareStatement("SELECT * FROM courses");
            pst25=conn.prepareStatement("SELECT * FROM course_levels");
            confirmDet=conn.prepareStatement("SELECT * FROM applicants_details WHERE Email_Address=?");
            check3=conn.prepareStatement("SELECT * FROM course_details WHERE Email_Address=?");
            //inquiries
            pst27=conn.prepareStatement("INSERT INTO inquiries(Sender,Message,Sent_Date) VALUES(?,?,now())");
            pst28=conn.prepareStatement("SELECT * FROM inquiries WHERE Sender=?");
            //change pwd
            pst29=conn.prepareStatement("UPDATE registration SET Password=? WHERE Email_Address=? AND Password=?");
        }catch(SQLException e){
            e.printStackTrace(System.out);
        }
    }
    //check if email provided is already registered
    public ResultSet checkIfRegistered(String email){
        ResultSet rs1=null;
        try{
            pst1.setString(1, email);
            rs1=pst1.executeQuery();
        }catch(SQLException e){
            e.printStackTrace(System.out);
        }
        return rs1;
    }
    //set applicants..insertion
    public int setUsers(String fname, String mname, String lname, String email, String pwd, int roleId){
        int rs2=0;
        try{
            pst.setString(1, fname);
            pst.setString(2, mname);
            pst.setString(3, lname);
            pst.setString(4, email);
            pst.setString(5, pwd);
            pst.setInt(6, roleId);
            rs2=pst.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace(System.out);
        }
        return rs2;
    }
    //get applicant's details...for profiling
    public ResultSet getApplicantDetails(String email){
        ResultSet rs=null;
        try{
            pst2.setString(1, email);
            pst2.setInt(2, 2);
            rs=pst2.executeQuery();
        }
        catch(SQLException e){
            e.printStackTrace(System.out);
        }
        return rs;
    }
    //set applicants..inserts personal details
    public int setApplicants(String email, String fName, String mName, String lName, String dob, String gender,String pAddress, String mobile, String country){
        int i=0;
        try{
            pst3.setString(1, email);
            pst3.setString(2, fName);
            pst3.setString(3, mName);
            pst3.setString(4, lName);
            pst3.setString(5, dob);
            pst3.setString(6, gender);
            pst3.setString(7, pAddress);
            pst3.setString(8, mobile);
            pst3.setString(9, country);
            i=pst3.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace(System.out);
        }
        return i;
    }
    //checks if section A has been filled..b4 section B
    public ResultSet checkSectionA(String email){
        ResultSet rs=null;
        try{
            check1.setString(1, email);
            rs=check1.executeQuery();
        }
        catch(SQLException e){
            e.printStackTrace(System.out);
        }
        return rs;
    }
    //inserts education background details
    public int setEducationBackground(String physicsGrade, String mathsGrade, String subj3Grade, String subj4Grade, String meanGrade,double aggregatePoints, double clusterPoints, String email){
        int j=0;
        try{
            pst4.setString(1, physicsGrade);
            pst4.setString(2, mathsGrade);
            pst4.setString(3, subj3Grade);
            pst4.setString(4, subj4Grade);
            pst4.setString(5, meanGrade);
            pst4.setDouble(6, aggregatePoints);
            pst4.setDouble(7, clusterPoints);
            pst4.setString(8, email);
            j=pst4.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace(System.out);
        }
        return j;
    }
    //checks if section B has been filled..b4 section C
    public ResultSet checkSectionB(String email){
        ResultSet rs=null;
        try{
            check2.setString(1, email);
            rs=check2.executeQuery();
        }
        catch(SQLException e){
            e.printStackTrace(System.out);
        }
        return rs;
    }
    //inserts course details
    public int setCourseDetails(String email, int levelId, int courseId, String mos, String campus){
        int k=0;
        try{
            pst5.setString(1, email);
            pst5.setInt(2, levelId);
            pst5.setInt(3, courseId);
            pst5.setString(4, mos);
            pst5.setString(5, campus);
            k=pst5.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace(System.out);
        }
        return k;
    }
     //checks if section C has been filled..for display/editing
    public ResultSet checkSectionC(String email){
        ResultSet rs=null;
        try{
            check3.setString(1, email);
            rs=check3.executeQuery();
        }
        catch(SQLException e){
            e.printStackTrace(System.out);
        }
        return rs;
    }
    //calculates cluster points
    public double calculateClusterPoints(double physics, double maths, double subj3, double subj4, double aggregatePoints){
        double res1=(physics+maths+subj3+subj4);
        double res2=(res1/48);
        double res3=(aggregatePoints/84);
        double res4=(res2*res3);
        double res5=(Math.sqrt(res4));
        double w=(res5*48);
        DecimalFormat df = new DecimalFormat("#.##");
        String w1 = df.format(w);
        return Double.parseDouble(w1);
    }
    //get campuses from db
    public ResultSet getCampuses(){
        ResultSet rs=null;
        try{
            rs=pst6.executeQuery();
        }
        catch(SQLException e){
            e.printStackTrace(System.out);
        }
        return rs;
    }
    //get courses from db
    public ResultSet getCourses(){
        ResultSet rs=null;
        try{
            rs=pst7.executeQuery();
        }
        catch(SQLException e){
            e.printStackTrace(System.out);
        }
        return rs;
    }
    //get course levels from db
    public ResultSet getLevels(){
        ResultSet rs=null;
        try{
            rs=pst25.executeQuery();
        }
        catch(SQLException e){
            e.printStackTrace(System.out);
        }
        return rs;
    }
    //get course id given course name
    public ResultSet getCourseId(String courseName){
        ResultSet rs=null;
        try{
            pst8.setString(1, courseName);
            rs=pst8.executeQuery();
        }
        catch(SQLException e){
            e.printStackTrace(System.out);
        }
        return rs;
    }
    //get course name given course id
    public ResultSet getCourseName(int courseId){
        ResultSet rs=null;
        try{
            pst17.setInt(1, courseId);
            rs=pst17.executeQuery();
        }
        catch(SQLException e){
            e.printStackTrace(System.out);
        }
        return rs;
    }
    //get level id given level name
    public ResultSet getLevelId(String levelName){
        ResultSet rs=null;
        try{
            pst9.setString(1, levelName);
            rs=pst9.executeQuery();
        }
        catch(SQLException e){
            e.printStackTrace(System.out);
        }
        return rs;
    }
    //get level name given level id
    public ResultSet getLevelName(int levelId){
        ResultSet rs=null;
        try{
            pst16.setInt(1, levelId);
            rs=pst16.executeQuery();
        }
        catch(SQLException e){
            e.printStackTrace(System.out);
        }
        return rs;
    }
    //get grade equivalent points
    public double convertGradestoPoints(String grade){
        double points=0.00;
        switch (grade) {
            case "A":
                points=12;
                break;
            case "A-":
                points=11;
                break;
            case "B+":
                points=10;
                break;
            case "B":
                points=9;
                break;
            case "B-":
                points=8;
                break;
            case "C+":
                points=7;
                break;
            case "C":
                points=6;
                break;
            case "C-":
                points=5;
                break;
            case "D+":
                points=4;
                break;
            default:
                points=3;
                break;
        }
        return points;
    }
    //get posted announcements
    public ResultSet getAnnouncements(){
        ResultSet rs=null;
        try{
            rs=pst11.executeQuery();
        }
        catch(SQLException e){
            e.printStackTrace(System.out);
        }
        return rs;
    }
    //confirms if any announcement is available
    public ResultSet confirmAnnouncements(){
        ResultSet rs=null;
        try{
            rs=confirmAnn.executeQuery();
        }
        catch(SQLException e){
            e.printStackTrace(System.out);
        }
        return rs;
    }
    //get personal details for display/editing
    public ResultSet getPersonalDetails(String email){
        ResultSet rs=null;
        try{
            pst13.setString(1, email);
            rs=pst13.executeQuery();
        }
        catch(SQLException e){
            e.printStackTrace(System.out);
        }
        return rs;
    }
    
    public ResultSet confirmDetails(String email){
        ResultSet rs=null;
        try{
            confirmDet.setString(1, email);
            rs=confirmDet.executeQuery();
        }
        catch(SQLException e){
            e.printStackTrace(System.out);
        }
        return rs;
    }
    //get education details for display/editing
    public ResultSet getEducationBackground(String email){
        ResultSet rs=null;
        try{
            pst14.setString(1, email);
            rs=pst14.executeQuery();
        }
        catch(SQLException e){
            e.printStackTrace(System.out);
        }
        return rs;
    }
    //get course details for display/editing
    public ResultSet getCourseDetails(String email){
        ResultSet rs=null;
        try{
            pst15.setString(1, email);
            rs=pst15.executeQuery();
        }
        catch(SQLException e){
            e.printStackTrace(System.out);
        }
        return rs;
    }
    //updates personal details after editing
    public int editPersonalDetails(String dob,String gender,String address, String mobile, String country,String email){
        int i=0;
        try{
            pst18.setString(1, dob);
            pst18.setString(2, gender);
            pst18.setString(3, address);
            pst18.setString(4, mobile);
            pst18.setString(5, country);
            pst18.setString(6, email);
            i=pst18.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace(System.out);
        }
        return i;
    }
    //updates education background after editing
    public int editEducationBackground(String physics,String maths,String subj3, String subj4, String mean, double aggPoints, double clusterPoints, String email){
        int j=0;
        try{
            pst19.setString(1, physics);
            pst19.setString(2, maths);
            pst19.setString(3, subj3);
            pst19.setString(4, subj4);
            pst19.setString(5, mean);
            pst19.setDouble(6, aggPoints);
            pst19.setDouble(7, clusterPoints);
            pst19.setString(8, email);
            j=pst19.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace(System.out);
        }
        return j;
    }
    //updates course details after editing
    public int editCourseDetails(int level,int name,String mos, String campus, String email, int levelId, int courseId,String m, String c){
        int j=0;
        try{
            pst20.setInt(1, level);
            pst20.setInt(2, name);
            pst20.setString(3, mos);
            pst20.setString(4, campus);
            pst20.setString(5, email);
            pst20.setInt(6, levelId);
            pst20.setInt(7, courseId);
            pst20.setString(8, m);
            pst20.setString(9, c);
            j=pst20.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace(System.out);
        }
        return j;
    }
    //set inquiries..insertion
    public int setInquiries(String email, String message){
        int i=0;
        try{
            pst27.setString(1, email);
            pst27.setString(2, message);
            i=pst27.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace(System.out);
        }
        return i;
    }
    //get message...to be displayed on chats
    public ResultSet getMessage(String email){
        ResultSet rs=null;
        try{
            pst28.setString(1, email);
            rs=pst28.executeQuery();
        }
        catch(SQLException e){
            e.printStackTrace(System.out);
        }
        return rs;
    }
    //for changing pwd
    public int changePwd(String newPwd, String email, String oldPwd){
       int i=0;
       try{
          pst29.setString(1, newPwd);
          pst29.setString(2, email);
          pst29.setString(3, oldPwd);
          i=pst29.executeUpdate();
       }
       catch(SQLException e){
           e.printStackTrace(System.out);
       }
       return i;
    }
}