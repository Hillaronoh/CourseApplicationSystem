/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package myproject;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.Properties;
import java.util.UUID;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
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
    //confirm ranking
    PreparedStatement pst30=null;
    //degree cs vet
    PreparedStatement pst31=null;
    //degree it vet
    PreparedStatement pst33=null;
    //degree informatics vet
    PreparedStatement pst34=null;
    //degree cf vet
    PreparedStatement pst35=null;
    //diploma cs vet
    PreparedStatement pst36=null;
    //diploma it vet
    PreparedStatement pst37=null;
    //diploma informatics vet
    PreparedStatement pst38=null;
    //diploma cf vet
    PreparedStatement pst39=null;
    //cert it vet
    PreparedStatement pst40=null;
    //cert cf vet
    PreparedStatement pst41=null;
    //cert is vet
    PreparedStatement pst42=null;
    //cert hm vet
    PreparedStatement pst43=null;
    //compare ranks
    PreparedStatement pst32=null;
    //get courses while checking cluster limit
    PreparedStatement pst44=null;
    //get campus name given id
    PreparedStatement pst45=null;
    //confirm degree, diploma and cert ranking
    PreparedStatement pst46=null;
    //get course levels one applied for
    PreparedStatement pst47=null;
    //check legibility
    PreparedStatement pst48=null;
    //insert temp user
    PreparedStatement pst49=null;
    //get key of temp user
    PreparedStatement pst50=null;
    //move temp user to permanent table
    PreparedStatement pst51=null;
    //delete temp user
    PreparedStatement pst52=null;
    //check course status
    PreparedStatement pst53=null;
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
            pst4=conn.prepareStatement("UPDATE education_background SET Eng_Grade=?, Kisw_Grade=?, Math_Grade=?, Physics_Grade=?, Group2_Grade=?, Group3_Grade=?, Grp4or5_Grade=?, Aggregate_Points=?, Cluster_Points=? WHERE Email_Address=?");
            pst5=conn.prepareStatement("INSERT INTO course_details(Email_Address, Level_id, Course_id, Mode_Of_Study, Campus) VALUES(?,?,?,?,?)");
            pst6=conn.prepareStatement("SELECT * FROM campuses");
            pst7=conn.prepareStatement("SELECT * FROM courses WHERE Level_id=?");
            pst8=conn.prepareStatement("SELECT Course_id FROM courses WHERE Course_Name=?");
            pst9=conn.prepareStatement("SELECT Level_id FROM course_levels WHERE Level_Name=?");
            check1=conn.prepareStatement("SELECT Email_Address FROM education_background WHERE Email_Address=?");
            check2=conn.prepareStatement("SELECT * FROM education_background WHERE Email_Address=? AND Physics_Grade IS NOT NULL");
            //announcements
            confirmAnn=conn.prepareStatement("SELECT * FROM announcements");
            //details
            pst13=conn.prepareStatement("SELECT * FROM applicants_details WHERE Email_Address=?");
            pst14=conn.prepareStatement("SELECT * FROM education_background WHERE Email_Address=?");
            pst15=conn.prepareStatement("SELECT * FROM course_details WHERE Email_Address=?");
            pst16=conn.prepareStatement("SELECT Level_Name FROM course_levels WHERE Level_id=?");
            pst17=conn.prepareStatement("SELECT * FROM courses WHERE Course_id=?");
            pst18=conn.prepareStatement("UPDATE applicants_details SET DoB=?, Gender=?, Postal_Address=?, Mobile=?, Country=? WHERE Email_Address=?");
            pst19=conn.prepareStatement("UPDATE education_background SET Eng_Grade=?, Kisw_Grade=?, Math_Grade=?, Physics_Grade=?, Group2_Grade=?, Group3_Grade=?, Grp4or5_Grade=?, Aggregate_Points=?, Cluster_Points=? WHERE Email_Address=?");
            pst20=conn.prepareStatement("UPDATE course_details SET Level_id=?, Course_id=?, Mode_Of_Study=?, Campus=? WHERE (Email_Address=? AND Level_id=? AND Course_id=?)");
            pst21=conn.prepareStatement("SELECT Level_id FROM course_levels WHERE Level_Name=?");
            pst22=conn.prepareStatement("SELECT Course_id FROM courses WHERE Course_Name=?");
            pst23=conn.prepareStatement("SELECT * FROM campuses");
            pst24=conn.prepareStatement("SELECT * FROM courses");
            pst25=conn.prepareStatement("SELECT * FROM course_levels WHERE Level_id>=?");
            confirmDet=conn.prepareStatement("SELECT * FROM applicants_details WHERE Email_Address=?");
            check3=conn.prepareStatement("SELECT * FROM course_details WHERE Email_Address=?");
            //inquiries
            pst27=conn.prepareStatement("INSERT INTO inquiries(Sender,Message,Sent_Date) VALUES(?,?,now())");
            pst28=conn.prepareStatement("SELECT * FROM inquiries WHERE Sender=?");
            //change pwd
            pst29=conn.prepareStatement("UPDATE registration SET Password=? WHERE Email_Address=? AND Password=?");
            //confirm ranking
            pst30=conn.prepareStatement("SELECT * FROM ranking");
            //degree cs vet
            pst31=conn.prepareStatement("SELECT * FROM degree_cs WHERE Email_Address=?");
            //degree it vet
            pst33=conn.prepareStatement("SELECT * FROM degree_it WHERE Email_Address=?");
            //degree informatics vet
            pst34=conn.prepareStatement("SELECT * FROM degree_informatics WHERE Email_Address=?");
            //degree cf vet
            pst35=conn.prepareStatement("SELECT * FROM degree_cf WHERE Email_Address=?");
            //diploma cs vet
            pst36=conn.prepareStatement("SELECT * FROM dip_cs WHERE Email_Address=?");
            //diploma it vet
            pst37=conn.prepareStatement("SELECT * FROM dip_it WHERE Email_Address=?");
            //diploma informatics vet
            pst38=conn.prepareStatement("SELECT * FROM dip_informatics WHERE Email_Address=?");
            //diploma cf vet
            pst39=conn.prepareStatement("SELECT * FROM dip_cf WHERE Email_Address=?");
            //cert it vet
            pst40=conn.prepareStatement("SELECT * FROM cert_it WHERE Email_Address=?");
            //cert cf vet
            pst41=conn.prepareStatement("SELECT * FROM cert_cf WHERE Email_Address=?");
            //cert is vet
            pst42=conn.prepareStatement("SELECT * FROM cert_is WHERE Email_Address=?");
            //cert hm vet
            pst43=conn.prepareStatement("SELECT * FROM cert_hm WHERE Email_Address=?");
            //compare ranks
            pst32=conn.prepareStatement("SELECT * FROM ranking WHERE Level_id=? AND Course_id=? AND Required_Number>=?");
            //get courses while checking cluster limit
            pst44=conn.prepareStatement("SELECT * FROM courses WHERE Level_id=? and Cluster_Limit<=?");
            //get campus name given id
            pst45=conn.prepareStatement("SELECT * FROM campuses WHERE Campus_id=?");
            //confirm degree, diploma and cert ranking
            pst46=conn.prepareStatement("SELECT * FROM ranking WHERE Level_id=?");
            //get course levels one applied for
            pst47=conn.prepareStatement("SELECT DISTINC Level_id FROM course_details WHERE Email_Address=?");
            //check legibility
            pst48=conn.prepareStatement("SELECT * FROM education_background");
            //insert temp user
            pst49=conn.prepareStatement("INSERT INTO temp_users VALUES(?,?,?,?,?,?)");
            //get key of temp user
            pst50=conn.prepareStatement("SELECT * FROM temp_users WHERE Activation_Key=?");
            //move temp user to permanent table
            pst51=conn.prepareStatement("INSERT INTO registration VALUES(?,?,?,?,?,?)");
            //delete temp user
            pst52=conn.prepareStatement("DELETE FROM temp_users WHERE Activation_Key=?");
            //check course status
            pst53=conn.prepareStatement("SELECT Status FROM course_status WHERE Level_id=?");
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
    public int setEducationBackground(String engGrade, String kiswGrade, String mathsGrade, String physicsGrade, String grp2Grade, String grp3Grade, String grp4or5Grade, double aggregatePoints, double clusterPoints, String email){
        int j=0;
        try{
            pst4.setString(1, engGrade);
            pst4.setString(2, kiswGrade);
            pst4.setString(3, mathsGrade);
            pst4.setString(4, physicsGrade);
            pst4.setString(5, grp2Grade);
            pst4.setString(6, grp3Grade);
            pst4.setString(7, grp4or5Grade);
            pst4.setDouble(8, aggregatePoints);
            pst4.setDouble(9, clusterPoints);
            pst4.setString(10, email);
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
    public int setCourseDetails(String email, int levelId, int courseId, String mos, int campus){
        int k=0;
        try{
            pst5.setString(1, email);
            pst5.setInt(2, levelId);
            pst5.setInt(3, courseId);
            pst5.setString(4, mos);
            pst5.setInt(5, campus);
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
    //calculate aggregate points
    public double calculateAggregatePoints(double eng, double kisw, double maths, double grp2Sub1, double grp2Sub2, double grp3, double grp4or5){
        double aggregatePoints=(eng+kisw+maths+grp2Sub1+grp2Sub2+grp3+grp4or5);
        return aggregatePoints;
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
    //get campuses name given id
    public ResultSet getCampusName(int campusId){
        ResultSet rs=null;
        try{
            pst45.setInt(1, campusId);
            rs=pst45.executeQuery();
        }
        catch(SQLException e){
            e.printStackTrace(System.out);
        }
        return rs;
    }
    //get courses from db
    public ResultSet getCourses(int li){
        ResultSet rs=null;
        try{
            pst7.setInt(1, li);
            rs=pst7.executeQuery();
        }
        catch(SQLException e){
            e.printStackTrace(System.out);
        }
        return rs;
    }
    //get course levels from db
    public ResultSet getLevels(int levelId){
        ResultSet rs=null;
        try{
            pst25.setInt(1, levelId);
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
    public int editEducationBackground(String eng, String kisw, String maths, String physics, String grp2, String grp3, String grp4or5, double aggPoints, double clusterPoints, String email){
        int j=0;
        try{
            pst19.setString(1, eng);
            pst19.setString(2, kisw);
            pst19.setString(3, maths);
            pst19.setString(4, physics);
            pst19.setString(5, grp2);
            pst19.setString(6, grp3);
            pst19.setString(7, grp4or5);
            pst19.setDouble(8, aggPoints);
            pst19.setDouble(9, clusterPoints);
            pst19.setString(10, email);
            j=pst19.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace(System.out);
        }
        return j;
    }
    //updates course details after editing
    public int editCourseDetails(int level,int name,String mos, int campusId, String email, int levelId, int courseId){
        int j=0;
        try{
            pst20.setInt(1, level);
            pst20.setInt(2, name);
            pst20.setString(3, mos);
            pst20.setInt(4, campusId);
            pst20.setString(5, email);
            pst20.setInt(6, levelId);
            pst20.setInt(7, courseId);
            // pst20.setString(8, m);
            // pst20.setString(9, c);
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
    //confirm ranking
    public ResultSet confirmRanking(){
        ResultSet rs=null;
        try{
            rs=pst30.executeQuery();
        }
        catch(SQLException e){
            e.printStackTrace(System.out);
        }
        return rs;
    }
    //get degree cs rank
    public ResultSet getDegCsRank(String email){
        ResultSet rs=null;
        try{
            pst31.setString(1, email);
            rs=pst31.executeQuery();
        }
        catch(SQLException e){
            e.printStackTrace(System.out);
        }
        return rs;
    }
    //get degree it rank
    public ResultSet getDegItRank(String email){
        ResultSet rs=null;
        try{
            pst33.setString(1, email);
            rs=pst33.executeQuery();
        }
        catch(SQLException e){
            e.printStackTrace(System.out);
        }
        return rs;
    }
    //get degree informatics rank
    public ResultSet getDegInfoRank(String email){
        ResultSet rs=null;
        try{
            pst34.setString(1, email);
            rs=pst34.executeQuery();
        }
        catch(SQLException e){
            e.printStackTrace(System.out);
        }
        return rs;
    }
    //get degree cf rank
    public ResultSet getDegCfRank(String email){
        ResultSet rs=null;
        try{
            pst35.setString(1, email);
            rs=pst35.executeQuery();
        }
        catch(SQLException e){
            e.printStackTrace(System.out);
        }
        return rs;
    }
    //get diploma cs rank
    public ResultSet getDipCsRank(String email){
        ResultSet rs=null;
        try{
            pst36.setString(1, email);
            rs=pst36.executeQuery();
        }
        catch(SQLException e){
            e.printStackTrace(System.out);
        }
        return rs;
    }
    //get diploma it rank
    public ResultSet getDipItRank(String email){
        ResultSet rs=null;
        try{
            pst37.setString(1, email);
            rs=pst37.executeQuery();
        }
        catch(SQLException e){
            e.printStackTrace(System.out);
        }
        return rs;
    }
    //get diploma informatics rank
    public ResultSet getDipInfoRank(String email){
        ResultSet rs=null;
        try{
            pst38.setString(1, email);
            rs=pst38.executeQuery();
        }
        catch(SQLException e){
            e.printStackTrace(System.out);
        }
        return rs;
    }
    //get diploma cf rank
    public ResultSet getDipCfRank(String email){
        ResultSet rs=null;
        try{
            pst39.setString(1, email);
            rs=pst39.executeQuery();
        }
        catch(SQLException e){
            e.printStackTrace(System.out);
        }
        return rs;
    }
    //get cert it rank
    public ResultSet getCertItRank(String email){
        ResultSet rs=null;
        try{
            pst40.setString(1, email);
            rs=pst40.executeQuery();
        }
        catch(SQLException e){
            e.printStackTrace(System.out);
        }
        return rs;
    }
    //get cert cf rank
    public ResultSet getCertCfRank(String email){
        ResultSet rs=null;
        try{
            pst41.setString(1, email);
            rs=pst41.executeQuery();
        }
        catch(SQLException e){
            e.printStackTrace(System.out);
        }
        return rs;
    }
    //get cert is rank
    public ResultSet getCertIsRank(String email){
        ResultSet rs=null;
        try{
            pst42.setString(1, email);
            rs=pst42.executeQuery();
        }
        catch(SQLException e){
            e.printStackTrace(System.out);
        }
        return rs;
    }
    //get cert hm rank
    public ResultSet getCertHmRank(String email){
        ResultSet rs=null;
        try{
            pst43.setString(1, email);
            rs=pst43.executeQuery();
        }
        catch(SQLException e){
            e.printStackTrace(System.out);
        }
        return rs;
    }
    //compare ranks
    public ResultSet compareRank(int levelId, int courseId, int rank){
        ResultSet rs=null;
        try{
            pst32.setInt(1, levelId);
            pst32.setInt(2, courseId);
            pst32.setInt(3, rank);
            rs=pst32.executeQuery();
        }
        catch(SQLException e){
            e.printStackTrace(System.out);
        }
        return rs;
    }
    //get courses while checking cluster limit
    public ResultSet getCoursesOverClusterLimit(int levelId, double clusterPoints){
        ResultSet rs=null;
        try{
            pst44.setInt(1, levelId);
            pst44.setDouble(2, clusterPoints);
            rs=pst44.executeQuery();
        }
        catch(SQLException e){
            e.printStackTrace(System.out);
        }
        return rs;
    }
    //confirm degree, diploma and cert ranking
    public ResultSet checkRankingPerLevel(int level){
        ResultSet rs=null;
        try{
            pst46.setInt(1, level);
            rs=pst46.executeQuery();
        }
        catch(SQLException e){
            e.printStackTrace(System.out);
        }
        return rs;
    }
    //get course levels of courses applied for
    public ResultSet getLevelIdsOfCoursesApplied(String email){
        ResultSet rs=null;
        try{
            pst47.setString(1, email);
            rs=pst47.executeQuery();
        }
        catch(SQLException e){
            e.printStackTrace(System.out);
        }
        return rs;
    }
    //get age
    public long calculateAge(Date dob, Date curDate){
        long difference = curDate.getTime() - dob.getTime();
        long days = (difference / (1000*60*60*24));
        long age=days/365;
        return age;
    }
    //get age
    public ResultSet checkLegibility(){
        ResultSet rs=null;
        try{
            rs=pst48.executeQuery();
        }
        catch(SQLException e){
            e.printStackTrace(System.out);
        }
        return rs;
    }
    //send activation links to emails
    public void sendMail(String email, String actKey, String urlKey) throws UnsupportedEncodingException{
        final String username = "ronokip55@gmail.com";
        final String password = "HILLARYHILLARY";
        
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        
        Session session = Session.getInstance(props,new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        
        try {
            //String q = "random word £500 bank $";
            // String html = "http://localhost:8080/Project1c/Login.jsp/%20query?q=" + URLEncoder.encode(actKey, "UTF-8");
            String html = "Thank You For Identifying MMUST, The University Of Choice.\nClick on the link below to activate your account.<a href=http://localhost:8080/Project1c/index.jsp?u="+actKey+">mmust"+urlKey+"accountactivation</a>";
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("ronokip55@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            message.setSubject("Account Activation");
            message.setText(html, "UTF-8", "html");
            
            Transport.send(message);
            
            // System.out.println("Done");
            
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
    //generate random key
    public String keyGen() throws NoSuchAlgorithmException{
        String uuid = UUID.randomUUID().toString();
        return uuid;
    }
    //generate random string for url
    public String keyGen2() throws NoSuchAlgorithmException{
        String uuid = UUID.randomUUID().toString();
        return uuid;
    }
    //insert temp user
    public int insertTempUser(String fn, String mn, String ln, String email, String pwd, String key){
        int j=0;
        try{
            pst49.setString(1, fn);
            pst49.setString(2, mn);
            pst49.setString(3, ln);
            pst49.setString(4, email);
            pst49.setString(5, pwd);
            pst49.setString(6, key);
            j=pst49.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace(System.out);
        }
        return j;
    }
    //get key of temp user
    public ResultSet getKey(String key){
        ResultSet rs=null;
        try{
            pst50.setString(1, key);
            rs=pst50.executeQuery();
        }
        catch(SQLException e){
            e.printStackTrace(System.out);
        }
        return rs;
    }
    //move temp user to permanent table
    public int insertTempUser(String fname, String mname, String lname, String email, String pwd, int ri){
        int j=0;
        try{
            pst51.setString(1, fname);
            pst51.setString(2, mname);
            pst51.setString(3, lname);
            pst51.setString(4, email);
            pst51.setString(5, pwd);
            pst51.setInt(6, ri);
            j=pst51.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace(System.out);
        }
        return j;
    }
    //delete temp user
    public int deleteTempUser(String key){
        int j=0;
        try{
            pst52.setString(1, key);
            j=pst52.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace(System.out);
        }
        return j;
    }
    //send emailfor password reset
    public void sendMailPwd(String email, String urlKey){
        final String username = "ronokip55@gmail.com";
        final String password = "HILLARYHILLARY";
        
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        
        Session session = Session.getInstance(props,new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        
        try {
            // String html = "http://localhost:8080/Project1c/Login.jsp/%20query?q=" + URLEncoder.encode(actKey, "UTF-8");
            String html = "Click on the link below to reset your password.\n<a href=http://localhost:8080/Project1c/Applicants/PasswordReset.jsp?u="+email+">mmust"+urlKey+"passwordrecovery</a>";
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("ronokip55@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            message.setSubject("Password Recovery");
            message.setText(html, "UTF-8", "html");
            
            Transport.send(message);
            
            // System.out.println("Done");
            
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
    //check course status
    public ResultSet checkSatus(int levelId){
        ResultSet rs=null;
        try{
            pst53.setInt(1, levelId);
            rs=pst53.executeQuery();
        }
        catch(SQLException e){
            e.printStackTrace(System.out);
        }
        return rs;
    }
}