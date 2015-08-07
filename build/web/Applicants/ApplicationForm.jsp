<%-- 
    Document   : UserLogin
    Created on : Jun 13, 2015, 9:41:48 PM
    Author     : Kipngetich
--%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.sql.*" %>
<%Class.forName("com.mysql.jdbc.Driver"); %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Application Form|mmust</title>
        
        <!--start date picker-->
        <link rel="stylesheet" type="text/css" media="all" href="jsDatePick_ltr.min.css" />
        <script type="text/javascript" src="jsDatePick.min.1.3.js"></script>
        
        <script type="text/javascript">
            window.onload = function(){
                new JsDatePick({
                    useMode:2,
                    target:"dob",
                    dateFormat:"%Y-%m-%d"
                    /*selectedDate:{				This is an example of what the full configuration offers.
                                        day:5,						For full documentation about these settings please see the full version of the code.
                                        month:9,
                                        year:2006
                                },
                                yearsRange:[1978,2020],
                                limitToToday:false,
                                cellColorScheme:"beige",
                                dateFormat:"%m-%d-%Y",
                                imgPath:"img/",
                                weekStartDay:1*/
                });
            };
        </script>        
        <!--end date picker--> 
        
        <!--start navigation menus-->
        <link rel="stylesheet" href="mycss/glyphicons/css/bootstrap.min.css">
        <link rel="stylesheet" style type="text/css" href="mycss/navMenus.css">
        <!--end navigation menus-->
        <!-- accordions -->
        <link rel="stylesheet" type="text/css" href="mycss/accordion1/defaults.css">
        <link rel="stylesheet" type="text/css" href="mycss/accordion1/demo.css">
        <script type="text/javascript" src="mycss/accordion1/jquery.min.js"></script>
        <script type="text/javascript" src="mycss/accordion1/accordion.js"></script>
        
        <!--form elements--><link rel="stylesheet" href="layout/bootstrap/css/bootstrap.css" type="text/css">
        <!-- Core CSS - Include with every page -->
        <link href="assets/plugins/bootstrap/bootstrap.css" rel="stylesheet" />
        <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
        <link href="assets/plugins/pace/pace-theme-big-counter.css" rel="stylesheet" />
        <link href="assets/css/style.css" rel="stylesheet" />
        <link href="assets/css/main-style.css" rel="stylesheet" />
        <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.css">
        
        
        <script type="text/javascript" src="mycss/dateValidater.js"></script>
        <script type="text/javascript" src="mycss/pDetailsValidate.js"></script>
        <script type="text/javascript" src="mycss/eBackgroundValidate.js"></script>
        <script type="text/javascript" src="mycss/cApplicationDetailsValidate.js"></script>
        
        <style>
            .error{
                color: red;
            }
        </style>
    </head>
    <body style="overflow-x: hidden; background-color: #EFEEEE;"> 
        
        <%
            String applicantId=new String(); 
            if(session.getAttribute("applicantId")==null||(session.getAttribute("applicantId")==""))
            {
                
             response.sendRedirect("../Login.jsp"); 

            }
            else
            { 
            applicantId=(String)session.getAttribute("applicantId");          
            }
       
            %>
            
            <%!
        public class Applicant{
            Connection conn=null;
            PreparedStatement pst=null;
            PreparedStatement pst1=null;
            PreparedStatement pst2=null;
            PreparedStatement pst3=null;
            PreparedStatement pst4=null;
            PreparedStatement pst5=null;
            PreparedStatement pst6=null;
            PreparedStatement pst7=null; 
            String db="jdbc:mysql:///project1c";
            String username="root";
            String password="";
            
            public Applicant(){
                try{
                   conn=DriverManager.getConnection(db,username,password);
                   pst=conn.prepareStatement("SELECT First_Name,Middle_Name,Last_Name FROM registration WHERE Email_Address=? AND Role_id=?");
                   pst1=conn.prepareStatement("INSERT INTO applicants_details VALUES(?,?,?,?,?,?,?,?,?)");
                   pst2=conn.prepareStatement("UPDATE education_background SET Physics_Grade=?, Maths_Grade=?, Subject3_Grade=?, Subject4_Grade=?, Mean_Grade=?, Aggregate_Points=?, Cluster_Points=? WHERE Email_Address=?");
                   pst3=conn.prepareStatement("INSERT INTO course_details VALUES(?,?,?,?,?)");
                   pst4=conn.prepareStatement("SELECT * FROM campuses");
                   pst5=conn.prepareStatement("SELECT * FROM courses");
                   pst6=conn.prepareStatement("SELECT Course_id FROM courses WHERE Course_Name=?");
                   pst7=conn.prepareStatement("SELECT Level_id FROM course_levels WHERE Level_Name=?");
                }
                catch(SQLException e){
                    e.printStackTrace();
                }
            }
                       
            public ResultSet getApplicantDetails(String email){
                ResultSet rs=null;
                try{
                pst.setString(1, email);
                pst.setInt(2, 2);
                rs=pst.executeQuery();
                }
                catch(SQLException e){
                    e.printStackTrace();
                }
                return rs;
            }
            
            public int setApplicants(String email, String fName, String mName, String lName, String dob, String gender,String pAddress, String mobile, String country){
                int i=0;
                try{
                pst1.setString(1, email);
                pst1.setString(2, fName);
                pst1.setString(3, mName);
                pst1.setString(4, lName);
                pst1.setString(5, dob);
                pst1.setString(6, gender);
                pst1.setString(7, pAddress);
                pst1.setString(8, mobile);
                pst1.setString(9, country);
                i=pst1.executeUpdate();
                }
                catch(SQLException e){
                    e.printStackTrace();
                }
                return i;
            }
            
            public int setEducationBackground(String physicsGrade, String mathsGrade, String subj3Grade, String subj4Grade, String meanGrade,double aggregatePoints, double clusterPoints, String email){
                int j=0;
                try{
                pst2.setString(1, physicsGrade);
                pst2.setString(2, mathsGrade);
                pst2.setString(3, subj3Grade);
                pst2.setString(4, subj4Grade);
                pst2.setString(5, meanGrade);
                pst2.setDouble(6, aggregatePoints);
                pst2.setDouble(7, clusterPoints);
                pst2.setString(8, email);
                j=pst2.executeUpdate();
                }
                catch(SQLException e){
                    e.printStackTrace();
                }
                return j;
            }
            
            public int setCourseDetails(String email, int levelId, int courseId, String mos, String campus){
                int k=0;
                try{
                pst3.setString(1, email);
                pst3.setInt(2, levelId);
                pst3.setInt(3, courseId);
                pst3.setString(4, mos);
                pst3.setString(5, campus);
                k=pst3.executeUpdate();
                }
                catch(SQLException e){
                    e.printStackTrace();
                }
                return k;
            }
            
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
             
             public ResultSet getCampuses(){
                ResultSet rs=null;
                try{
                rs=pst4.executeQuery();
                }
                catch(SQLException e){
                    e.printStackTrace();
                }
                return rs;
            }
             
             public ResultSet getCourses(){
                ResultSet rs=null;
                try{
                rs=pst5.executeQuery();
                }
                catch(SQLException e){
                    e.printStackTrace();
                }
                return rs;
            }
             
             public ResultSet getCourseId(String courseName){
                ResultSet rs=null;
                try{
                 pst6.setString(1, courseName);
                 rs=pst6.executeQuery();
                }
                catch(SQLException e){
                    e.printStackTrace();
                }
                return rs;
            }
             
             public ResultSet getLevelId(String levelName){
                ResultSet rs=null;
                try{
                 pst7.setString(1, levelName);
                 rs=pst7.executeQuery();
                }
                catch(SQLException e){
                    e.printStackTrace();
                }
                return rs;
            }
             
             public double convertGradestoPoints(String grade){ 
               double points=0.00;  
                if(grade.equals("A")){
                    points=12;
                }
                else if(grade.equals("A-")){
                    points=11;
                }
                else if(grade.equals("B+")){
                    points=10;
                }
                else if(grade.equals("B")){
                    points=9;
                }
                else if(grade.equals("B-")){
                    points=8; 
                }
                else if(grade.equals("C+")){
                    points=7;
                }
                else if(grade.equals("C")){
                    points=6;
                }
                else if(grade.equals("C-")){
                    points=5;
                }
                else if(grade.equals("D+")){
                    points=4;
                }
                else{
                    points=3; 
                }
                return points;
            }
        }
         
        %>
        
        <%
           Applicant user=new Applicant();
           String firstName=new String();
           String middleName=new String();
           String lastName=new String();
                      
           ResultSet results=user.getApplicantDetails(applicantId); 
                      
           if(results.next()){
               firstName=results.getString("First_Name");
               middleName=results.getString("Middle_Name");
               lastName=results.getString("Last_Name");
           }
           %>
        
        <jsp:include page="Header.jsp"></jsp:include>
        
        <div class="container">
            
            <div class="row1" style="margin-top: 0px;">
                
                <div class="col-md-4 col-md-offset-4" style="width: 1082px; margin-left: 43px;">
                    
                    <div class="login-panel panel panel-default"> 
                        <!--start navigation menus-->
                        <div id="navMenu" style="margin-top: 5px;">
                            <ul>
                                <li><a href="UserAccount.jsp"><button class="btn btn-info" style="width: 148px; height: 38px; padding-top: 0px; margin-top: -5px;"><i class="fa fa-home"></i>Home</button></a>
                                </li>
                            </ul>
                            <ul>
                                <li><a href="#"><button class="btn btn-info" style="width: 148px; height: 38px; padding-top: 0px; margin-top: -5px; background-color: #428BCA;"><i class="fa fa-arrow-down"></i>Apply Course</button></a>
                                    <ul>
                                        <li><a href="ApplicationForm.jsp">Under Graduate</a></li>
                                        <li><a href="#">Post Graduate</a></li>
                                    </ul>
                                </li>
                            </ul>
                            <ul>
                                <li><a href="Announcements.jsp"><button class="btn btn-info" style="width: 148px; height: 38px; padding-top: 0px; margin-top: -5px;"><i class="fa fa-bell"></i>Announcements</button></a>
                                    
                                </li>
                            </ul>
                            <ul>
                                <li><a href="Details.jsp"><button class="btn btn-info" style="width: 148px; height: 38px; padding-top: 0px; margin-top: -5px;"><i class="fa fa-archive"></i>My Details</button></a>
                                </li>
                            </ul>
                            <ul>
                                <li><a href="Messaging.jsp"><button class="btn btn-info" style="width: 148px; height: 38px; padding-top: 0px; margin-top: -5px;"><i class="fa fa-inbox"></i>Inquiries</button></a>
                                </li>
                            </ul>
                            <ul>
                                <li><a href="#ApplicationStatus" data-toggle="modal"><button class="btn btn-info" style="width: 148px; height: 38px; padding-top: 0px; margin-top: -5px;"><i class="fa fa-star"></i>Application Status</button></a>
                                </li>
                            </ul>
                            <ul>
                                <li><a href="#"><button class="btn btn-info" style="width: 148px; height: 38px; padding-top: 0px; margin-top: -5px;"><i class="fa fa-user"></i><%=firstName%></button></a>
                                    <ul>
                                        <li><a href="ChangePwd.jsp"><i class="fa fa-dropbox"></i>Change Password</a></li>
                                        <li><a href="UserLogout.jsp"><i class="fa fa-sign-out"></i>Logout</a></li>
                                    </ul>
                                </li>
                            </ul>
                            
                        </div>
                        <!--end navigation menus-->
                        <div class="panel-heading" style="margin-top: 56px;border-top: 1px solid;">
                            <h3 class="panel-title">Provide The required Information in the Sections Below.</h3>
                        </div>
                        
                        <div class="panel-body">
                            
                            <!--start accordion A-->
                            <div class="main">
                                <div class="accordion">
                                    <div class="accordion-section">
                                        <%
                                       if(request.getParameter("submit1")!=null){
                                       
                                           String fName=request.getParameter("fname");
                                           String mName=request.getParameter("mname");
                                           String lName=request.getParameter("lname");
                                           String dob=request.getParameter("dob");
                                           String gender=request.getParameter("gender");
                                           String pAddress=request.getParameter("address");
                                           String mobile=request.getParameter("mobile");
                                           String country=request.getParameter("country");
           
                                           int results2=user.setApplicants(applicantId, fName, mName, lName, dob, gender, pAddress, mobile, country);    
                                       
                                        if(results2>0){%> 
                                        <a class="accordion-section-title alert alert-success" style="margin-bottom:0px;" href="#accordion-1"><i class="fa fa-check-circle"></i>Your Personal Details has been saved successfully..Proceed to the next section.</a>
                                        <%}
                                        else{%>
                                        <a class="accordion-section-title alert alert-error" style="margin-bottom:0px;" href="#accordion-1"><i class="fa fa-exclamation-triangle"></i>There was an error saving your details..Please try again.</a>
                                        <%}} else{%>
                                        <a class="accordion-section-title" href="#accordion-1">SECTION A: Applicant's Personal Details.</a>
                                        <%}%>
                                        <div id="accordion-1" class="accordion-section-content"> 
                                            
                                            <form method="post" action="" id="myForm1" onsubmit="return validatePersonaldetailsForm1(this)">
                                                <fieldset>
                                                    
                                                    <div class="row" id="firstNameRow">   
                                                        <div class="form-group col-sm-3">
                                                            <label for="fname">First Name:<span style="color:red"> *</span></label>
                                                            <input type="text" class="form-control input" id="fname" name="fname" value="<%=firstName%>" placeholder="First Name" readonly="readonly"/>
                                                        </div>
                                                        
                                                        <div class="form-group col-sm-3">
                                                            <label for="mname">Middle Name:</label>
                                                            <input type="text" class="form-control input" id="mname" name="mname" value="<%=middleName%>" placeholder="Middle Name" readonly="readonly"/>
                                                        </div>
                                                        
                                                        <div class="form-group col-sm-3">
                                                            <label for="fname">Last Name:<span style="color:red"> *</span></label>
                                                            <input type="text" class="form-control input" id="lname" name="lname" value="<%=lastName%>" placeholder="Last Name" readonly="readonly"/>
                                                        </div>
                                                        
                                                        <div class="form-group col-sm-3">
                                                            <label for="dob">Date of Birth:<span style="color:red"> *</span></label>
                                                            <input type="text" class="form-control input" id="dob" name="dob" placeholder="yyyy-mm-dd"/>
                                                        </div>
                                                        
                                                    </div>
                                                    
                                                    <div class="row" id="dobRow"> 
                                                        <div class="form-group col-sm-3">
                                                            <label for="gender">Gender:<span style="color:red"> *</span></label>
                                                            <select id="gender" name="gender" class="form-control input">
                                                                <option value="" selected>I am...</option> 
                                                                <option value="Male">Male</option>
                                                                <option value="Female">Female</option>
                                                            </select>
                                                        </div>
                                                        
                                                        <div class="form-group col-sm-3">
                                                            <label for="address">Postal Address:<span style="color:red"> *</span></label>
                                                            <input type="text" class="form-control input" id="address" name="address" placeholder="e.g. P.O Box 48, Chebunyo"/>
                                                        </div>
                                                        
                                                        <div class="form-group col-sm-3">
                                                            <label for="mobile">Mobile:<span style="color:red"> *</span></label>
                                                            <input type="text" class="form-control input" id="mobile" name="mobile" placeholder="07...."/>
                                                        </div>
                                                        
                                                        <div class="form-group col-sm-3">
                                                            <label for="country">Nationality:<span style="color:red"> *</span></label>
                                                            <input type="text" class="form-control input" id="country" name="country" placeholder="country of residence"/>
                                                        </div>     
                                                    </div>
                                                    
                                                    <div class="row" id="buttons1">
                                                        <div class="col-sm-4"></div>
                                                        <div class="form-group col-sm-2">
                                                            <button type="submit" name="submit1" class="btn btn-success" style="width: 120px;">Submit</button>
                                                        </div>
                                                        <div class="form-group col-sm-2">
                                                            <button type="reset" name="reset" class="btn btn-info pull-right" style="width: 120px;">Reset</button>
                                                        </div>
                                                        <div class="col-sm-4"></div>
                                                    </div>
                                                    
                                                    
                                                </fieldset>
                                            </form>
                                        </div><!--end .accordion-section-content-->
                                    </div><!--end .accordion-section-->
                                </div><!--end .accordion-->
                            </div>
                            <!--end accordion A-->
                            
                            <!--start accordion B-->
                            <div class="main">
                                <div class="accordion">
                                    <div class="accordion-section">
                                        <%
                                       if(request.getParameter("submit2")!=null){
                                       
                                           String physicsGrade=request.getParameter("physics");
                                           String mathsGrade=request.getParameter("maths");
                                           String subj3Grade =request.getParameter("subj3");
                                           String subj4Grade=request.getParameter("subj4");
                                           String meanGrade=request.getParameter("meanGrade");
                                           String aggregatePointsString=request.getParameter("aggregatePoints");
                                           double aggregatePointsDouble=Double.parseDouble(aggregatePointsString); 
                                                                                                                                 
                                           double physicsConverted=user.convertGradestoPoints(physicsGrade);
                                           double mathsConverted=user.convertGradestoPoints(mathsGrade);
                                           double subj3Converted=user.convertGradestoPoints(subj3Grade);
                                           double subj4Converted=user.convertGradestoPoints(subj4Grade); 
                                           double clusterPoints=user.calculateClusterPoints(physicsConverted, mathsConverted, subj3Converted, subj4Converted, aggregatePointsDouble);  
                                           
                                           int results3=user.setEducationBackground(physicsGrade, mathsGrade, subj3Grade, subj4Grade, meanGrade, aggregatePointsDouble, clusterPoints, applicantId); 
                                           if(results3>0){
                                           %>
                                           <a class="accordion-section-title alert alert-success" style="margin-bottom:0px;" href="#accordion-2"><i class="fa fa-check-circle"></i>Your details has been saved successfully..Proceed to the next section.</a>
                                           <%} else{%>
                                           <a class="accordion-section-title alert alert-error" style="margin-bottom:0px;" href="#accordion-2"><i class="fa fa-exclamation-triangle"></i>There was an error saving your details..Please try again.</a>
                                           <%}} else{%>
                                           <a class="accordion-section-title" href="#accordion-2">SECTION B: Applicant's Education Background.</a>
                                           <%}%>
                                           <div id="accordion-2" class="accordion-section-content">
                                            
                                               <form role="form" method="post" action="" id="myForm2" onsubmit="return validateEducationBackgroundForm1(this)">
                                                   <fieldset>
                                                    
                                                    <div class="row" id="physicsRow">
                                                        <div class="form-group col-sm-4">
                                                            <label for="physics">K.C.S.E Physics Grade:<span style="color:red"> *</span></label>
                                                            <select id="physics" name="physics" class="form-control input">
                                                                <option value="" selected>~select grade~</option> 
                                                                <option value="A">A</option>
                                                                <option value="A-">A-</option>
                                                                <option value="B+">B+</option>
                                                                <option value="B">B</option>
                                                                <option value="B-">B-</option>
                                                                <option value="C+">C+</option>
                                                                <option value="C">C</option>
                                                                <option value="C-">C-</option>
                                                                <option value="D+">D+</option>
                                                                <option value="D">D</option>
                                                                <option value="D-">D-</option>
                                                                <option value="E">E</option>
                                                            </select>
                                                        </div>
                                                        
                                                        <div class="form-group col-sm-4">
                                                            <label for="maths">K.C.S.E Maths Grade:<span style="color:red"> *</span></label>
                                                            <select id="maths" name="maths" class="form-control input">
                                                                <option value="" selected>~select grade~</option> 
                                                                <option value="A">A</option>
                                                                <option value="A-">A-</option>
                                                                <option value="B+">B+</option>
                                                                <option value="B">B</option>
                                                                <option value="B-">B-</option>
                                                                <option value="C+">C+</option>
                                                                <option value="C">C</option>
                                                                <option value="C-">C-</option>
                                                                <option value="D+">D+</option>
                                                                <option value="D">D</option>
                                                                <option value="D-">D-</option>
                                                                <option value="E">E</option>
                                                            </select>
                                                        </div>
                                                        
                                                        <div class="form-group col-sm-4">
                                                            <label for="subj3">Group II or any Group III Grade:<span style="color:red"> *</span></label>
                                                            <select id="subj3" name="subj3" class="form-control input">
                                                                <option value="" selected>~select grade~</option> 
                                                                <option value="A">A</option>
                                                                <option value="A-">A-</option>
                                                                <option value="B+">B+</option>
                                                                <option value="B">B</option>
                                                                <option value="B-">B-</option>
                                                                <option value="C+">C+</option>
                                                                <option value="C">C</option>
                                                                <option value="C-">C-</option>
                                                                <option value="D+">D+</option>
                                                                <option value="D">D</option>
                                                                <option value="D-">D-</option>
                                                                <option value="E">E</option>
                                                            </select>
                                                        </div>
                                                    </div>
                                                    
                                                    <div class="row" id="subj4Row">
                                                        <div class="form-group col-sm-4">
                                                            <label for="subj4">Group II/Group III/Group IV/Group V Grade:<span style="color:red"> *</span></label>
                                                            <select id="subj4" name="subj4" class="form-control input">
                                                                <option value="" selected>~select grade~</option> 
                                                                <option value="A">A</option>
                                                                <option value="A-">A-</option>
                                                                <option value="B+">B+</option>
                                                                <option value="B">B</option>
                                                                <option value="B-">B-</option>
                                                                <option value="C+">C+</option>
                                                                <option value="C">C</option>
                                                                <option value="C-">C-</option>
                                                                <option value="D+">D+</option>
                                                                <option value="D">D</option>
                                                                <option value="D-">D-</option>
                                                                <option value="E">E</option>
                                                            </select>
                                                        </div>
                                                        
                                                        <div class="form-group col-sm-4">
                                                            <label for="meanGrade">K.C.S.E Mean Grade:<span style="color:red"> *</span></label>
                                                            <select id="meanGrade" name="meanGrade" class="form-control input">
                                                                <option value="" selected>~select grade~</option> 
                                                                <option value="A">A</option>
                                                                <option value="A-">A-</option>
                                                                <option value="B+">B+</option>
                                                                <option value="B">B</option>
                                                                <option value="B-">B-</option>
                                                                <option value="C+">C+</option>
                                                                <option value="C">C</option>
                                                                <option value="C-">C-</option>
                                                                <option value="D+">D+</option>
                                                                <option value="D">D</option>
                                                                <option value="D-">D-</option>
                                                                <option value="E">E</option>
                                                            </select>
                                                        </div>
                                                        
                                                        <div class="form-group col-sm-4">
                                                            <label for="aggregatePoints">K.C.S.E Aggregate Points:<span style="color:red"> *</span></label>
                                                            <input type="text" class="form-control input" id="aggregatePoints" name="aggregatePoints" placeholder="Total Aggregate Points"/>
                                                        </div>
                                                    </div>
                                                    
                                                    <div class="row" id="buttons2">
                                                        <div class="col-sm-4"></div>
                                                        <div class="form-group col-sm-2">
                                                            <button type="submit" name="submit2" class="btn btn-success" style="width: 120px;">Submit</button>
                                                        </div>
                                                        <div class="form-group col-sm-2">
                                                            <button type="reset" name="reset" class="btn btn-info pull-right" style="width: 120px;">Reset</button>
                                                        </div>
                                                        <div class="col-sm-4"></div>
                                                    </div>
                                                    
                                                </fieldset>
                                            </form>
                                            
                                        </div><!--end .accordion-section-content-->
                                    </div><!--end .accordion-section-->
                                </div><!--end .accordion-->
                            </div>
                            <!--end accordion B-->
                            
                            <!--start accordion C-->
                            <div class="main">
                                <div class="accordion">
                                    <div class="accordion-section">
                                        <%
                                       int courseId=0;
                                       int levelId=0;
                                       ResultSet results5=user.getCampuses();
                                       ResultSet results6=user.getCourses();
                                       if(request.getParameter("submit3")!=null){
                                           String courseName=request.getParameter("programmeName");
                                           String levelName=request.getParameter("programmeLevel");
                                           
                                           ResultSet results7=user.getCourseId(courseName);
                                           if(results7.next()){
                                               courseId=results7.getInt("Course_id");
                                           }
                                           
                                            ResultSet results8=user.getLevelId(levelName);
                                           if(results8.next()){
                                               levelId=results8.getInt("Level_id");
                                           }
                                           String mos=request.getParameter("modeOfStudy");
                                           String campus=request.getParameter("campus");
                                           
                                           int results4=user.setCourseDetails(applicantId, levelId, courseId, mos, campus);
                                       
                                        if(results4>0){%> 
                                        <a class="accordion-section-title alert alert-success" style="margin-bottom:0px;" href="#accordion-3"><i class="fa fa-check-circle"></i>Your details has been saved successfully..Proceed to the next section.</a>
                                        <%} else{%>
                                        <a class="accordion-section-title alert alert-error" style="margin-bottom:0px;" href="#accordion-3"><i class="fa fa-exclamation-triangle"></i>There was an error saving your details..Please try again.</a>
                                        <%} 
                                       } else{%>
                                        <a class="accordion-section-title" href="#accordion-3">SECTION C: Course Application Details.</a>
                                        <%}%>
                                        <div id="accordion-3" class="accordion-section-content">
                                            
                                            <form role="form" method="post" action="" id="myForm3" onsubmit="return validateCourseApplicationDetailsForm1(this)">
                                                <fieldset>
                                                    
                                                    <div class="row" id="programmeLevelRow">
                                                        <div class="col-sm-2"></div>
                                                        <div class="form-group col-sm-4">
                                                            <label for="level">Programme Level:<span style="color:red"> *</span></label>
                                                            <select id="programmeLevel" name="programmeLevel" class="form-control input">
                                                                <option value="" selected>~select programme level~</option> 
                                                                <option value="Degree">Degree</option>
                                                                <option value="Diploma">Diploma</option>
                                                                <option value="Certificate">Certificate</option>
                                                            </select>
                                                        </div>
                                                        
                                                        
                                                        <div class="form-group col-sm-4">
                                                            <label for="programmeName">Programme Name:<span style="color:red"> *</span></label>
                                                            <select id="programmeName" name="programmeName" class="form-control input">
                                                                <option value="" selected>~select programme name~</option> 
                                                                <%while(results6.next()){%>
                                                                <option value="<%=results6.getString("course_Name")%>"><%=results6.getString("course_Name")%></option>
                                                                <%}%>
                                                            </select>
                                                        </div>
                                                        <div class="col-sm-2"></div>
                                                    </div>
                                                    
                                                    <div class="row" id="modeOfStudyRow">
                                                        <div class="col-sm-2"></div>
                                                        <div class="form-group col-sm-4">
                                                            <label for="modeOfStudy">Mode of Study:<span style="color:red"> *</span></label>
                                                            <select id="modeOfStudy" name="modeOfStudy" class="form-control input">
                                                                <option value="" selected>~select mode of study~</option> 
                                                                <option value="Full Time">Full Time</option>
                                                                <option value="Part Time">Part Time</option>
                                                                <option value="Evening Classes">Evening Classes</option>
                                                                <option value="Weekend Classes">Weekend Classes</option>
                                                            </select>
                                                        </div>
                                                        
                                                        <div class="form-group col-sm-4">
                                                            <label for="campus">Campus/Study Center:<span style="color:red"> *</span></label>
                                                            <select id="campus" name="campus" class="form-control input">
                                                                <option value="" selected>~select campus~</option> 
                                                                <%while(results5.next()){%>
                                                                <option value="<%=results5.getString("campus_Name")%>"><%=results5.getString("campus_Name")%></option>
                                                                <%}%>
                                                            </select>
                                                        </div>
                                                        <div class="col-sm-2"></div>
                                                    </div>
                                                    
                                                    <div class="row" id="buttons3">
                                                        <div class="col-sm-4"></div>
                                                        <div class="form-group col-sm-2">
                                                            <button type="submit" name="submit3" class="btn btn-success" style="width: 120px;">Submit</button>
                                                        </div>
                                                        <div class="form-group col-sm-2">
                                                            <button type="reset" name="reset" class="btn btn-info pull-right" style="width: 120px;">Reset</button>
                                                        </div>
                                                        <div class="col-sm-4"></div>
                                                    </div>
                                                    
                                                </fieldset>
                                            </form>
                                            
                                        </div><!--end .accordion-section-content-->
                                    </div><!--end .accordion-section-->
                                </div><!--end .accordion-->
                            </div>
                            <!--end accordion C-->
                            
                            <!--start accordion D-->
                            <div class="main">
                                <div class="accordion">
                                    <div class="accordion-section">
                                        <a class="accordion-section-title" href="#accordion-4">SECTION D: Print Your Form.</a>
                                        <div id="accordion-4" class="accordion-section-content">
                                            
                                            
                                            <a href="PdfGenerator.jsp" class="btn btn-success btn-lg">
                                                <span><img src="image/printer.png" alt="printer" style="width: 30px; height: 30px;"></span> Print 
                                            </a>
                                            
                                            
                                        </div><!--end .accordion-section-content-->
                                    </div><!--end .accordion-section-->
                                </div><!--end .accordion-->
                            </div>
                            <!--end accordion D-->
                            
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="modal fade" id="ApplicationStatus" role="dialog">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title">Application Status</h4>
                    </div>
                    <div class="modal-body">
                        <p>You successfully secured a placement in bachelor of science in computer science
                        </p>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-danger" data-dismiss="modal">close</button>
                    </div>
                </div>
            </div>
        </div>
        <!-- Core Scripts - Include with every page -->
        <script src="assets/plugins/jquery-1.10.2.js"></script>
        <script src="assets/plugins/bootstrap/bootstrap.min.js"></script>
        <script src="assets/plugins/metisMenu/jquery.metisMenu.js"></script>
        <script src="mycss/dateValidator.js"></script> 
        <script type="text/javascript" src="mycss/modal/jquery.minCust.js"></script>
        <script type="text/javascript" src="mycss/modal/bootstrapJsCust.js"></script>
        <script type="text/javascript" src="mycss/validation/jquery.js"></script>
        <script type="text/javascript" src="mycss/validation/jquery.validate.js"></script>
        <script type="text/javascript" src="mycss/validation/additional-methods.js"></script>
        <script src="mycss/validation/custom.js"></script>
    </body>
</html>
