<%-- 
    Document   : Details
    Created on : Jul 15, 2015, 15:32:23 PM
    Author     : Kipngetich
--%>

<%@page import="java.sql.*" %>
<%Class.forName("com.mysql.jdbc.Driver");%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Applicant's Details</title>
        <!--start announcement box-->
        <link href="mycss/chatbox/bootstrap.css" rel="stylesheet" style type="text/css">
        <link href="mycss/chatbox/chatbox.css" rel="stylesheet" style type="text/css">
        <!--end announcement box-->
        <!--start navigation menus-->
        <link rel="stylesheet" href="mycss/glyphicons/css/bootstrap.min.css">
        <link rel="stylesheet" style type="text/css" href="mycss/navMenus.css">
        <!--end navigation menus-->
        <!-- Core CSS - Include with every page -->
        <link href="assets/plugins/bootstrap/bootstrap.css" rel="stylesheet" />
        <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
        <link href="assets/plugins/pace/pace-theme-big-counter.css" rel="stylesheet" />
        <link href="assets/css/style.css" rel="stylesheet" />
        <link href="assets/css/main-style.css" rel="stylesheet" />
        <link rel="stylesheet" type="text/css" href="mycss/style2.css">
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
            String db="jdbc:mysql:///project1c";
            String username="root";
            String password="";
            
            public Applicant(){
                try{
                   conn=DriverManager.getConnection(db,username,password);
                   pst=conn.prepareStatement("SELECT First_Name FROM registration WHERE Email_Address=? AND Role_id=?");
                   pst1=conn.prepareStatement("SELECT * FROM applicants_details WHERE Email_Address=?");
                   pst2=conn.prepareStatement("SELECT * FROM education_background WHERE Email_Address=?");
                   pst3=conn.prepareStatement("SELECT * FROM course_details WHERE Email_Address=?");
                   pst4=conn.prepareStatement("SELECT Level_Name FROM course_levels WHERE Level_id=?");
                   pst5=conn.prepareStatement("SELECT Course_Name FROM courses WHERE Course_id=?");
                }
                catch(SQLException e){
                    e.printStackTrace();
                }
            }
            
            public ResultSet getApplicant(String email){
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
            
            public ResultSet getPersonalDetails(String email){
                ResultSet rs=null;
                try{
                  pst1.setString(1, email);
                  rs=pst1.executeQuery();
                }
                catch(SQLException e){
                    e.printStackTrace();
                }
                return rs;
            }
            
            public ResultSet getEducationBackground(String email){
                ResultSet rs=null;
                try{
                  pst2.setString(1, email);
                  rs=pst2.executeQuery();
                }
                catch(SQLException e){
                    e.printStackTrace();
                }
                return rs;
            }
            
            public ResultSet getCourseDetails(String email){
                ResultSet rs=null;
                try{
                  pst3.setString(1, email);
                  rs=pst3.executeQuery();
                }
                catch(SQLException e){
                    e.printStackTrace();
                }
                return rs;
            }
            
            public ResultSet getLevelName(int levelId){
                ResultSet rs=null;
                try{
                  pst4.setInt(1, levelId);
                  rs=pst4.executeQuery();
                }
                catch(SQLException e){
                    e.printStackTrace();
                }
                return rs;
            }
            
            public ResultSet getCourseName(int courseId){
                ResultSet rs=null;
                try{
                  pst5.setInt(1, courseId);
                  rs=pst5.executeQuery();
                }
                catch(SQLException e){
                    e.printStackTrace();
                }
                return rs;
            }
        }
        %>
        
        <%
           Applicant user=new Applicant();
           String firstName=new String();
                     
           ResultSet results=user.getApplicant(applicantId); 
           
           if(results.next()){
               firstName=results.getString("First_Name");
           }
           
           ResultSet results1=user.getPersonalDetails(applicantId);
           ResultSet results2=user.getEducationBackground(applicantId);
           ResultSet results3=user.getCourseDetails(applicantId);
           
           String fName=new String();
           String mName=new String();
           String lName=new String();
           String dob=new String();
           String gender=new String();
           String address=new String();
           String mobile=new String();
           String country=new String();
           
           String physicsGrade=new String();
           String mathsGrade=new String();
           String subj3Grade=new String();
           String subj4Grade=new String();
           String meanGrade=new String();
           String aggregatePoints=new String();
           String clusterPoints=new String();
           
           String []levelNames=new String[100];
           String []courseNames=new String[100];
           %>
        
        <jsp:include page="Header.jsp"></jsp:include>
        <div class="container">
            
            <div class="row1" style="margin-top: 0px;">
                
                <div class="col-md-4 col-md-offset-4" style="width: 1082px; margin-left: 43px;">
                    
                    <div class="login-panel panel panel-default"> 
                        <!--start navigation menus-->
                        <div id="navMenu" style="margin-top: 2px;">
                            <ul>
                                <li><a href="UserAccount.jsp"><button class="btn btn-info" style="width: 148px; height: 38px; padding-top: 0px; margin-top: -5px;"><i class="fa fa-home"></i>Home</button></a>
                                </li>
                            </ul>
                            <ul>
                                <li><a href="#"><button class="btn btn-info" style="width: 148px; height: 38px; padding-top: 0px; margin-top: -5px;"><i class="fa fa-arrow-down"></i>Apply Course</button></a>
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
                                <li><a href="#"><button class="btn btn-info" style="width: 148px; height: 38px; padding-top: 0px; margin-top: -5px; background-color: #428BCA;"><i class="fa fa-archive"></i>My Details</button></a>     
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
                            <h2 class="panel-title" style="font-size: 20px; color: green;">These are your details</h2>
                        </div>
                        
                        <div class="panel-body">
                            <div class="container" style="padding-top: 5px;">
                                
                                <fieldset>
                                    <legend style="width: 300px;">Personal Information</legend>
                                </fieldset>
                                <table class="table table-bordered" style="width: 800px;height: 5px; margin-left: 80px;">
                                    
                                    <thead>
                                        <tr>
                                            <th>First Name</th>
                                            <th>Middle Name</th>
                                            <th>Last Name</th>
                                            <th>Date of Birth</th>
                                            <th>Gender</th>
                                            <th>Postal Address</th>
                                            <th>Mobile</th>
                                            <th>Nationality</th>
                                            <th>Action</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <%if(results1.next()){
                                            fName=results1.getString("First_Name");
                                            mName=results1.getString("Middle_Name");
                                            lName=results1.getString("Last_Name");
                                            dob=results1.getString("DoB");
                                            gender=results1.getString("Gender");
                                            address=results1.getString("Postal_Address");
                                            mobile=results1.getString("Mobile");
                                            country=results1.getString("Country");
                                            %>
                                            <td><%=fName%></td>
                                            <td><%=mName%></td> 
                                            <td><%=lName%></td>
                                            <td><%=dob%></td>
                                            <td><%=gender%></td>
                                            <td><%=address%></td>
                                            <td><%=mobile%></td>
                                            <td><%=country%></td>
                                            <td style="width: 68px;"><a href="#personalDetails" data-toggle="modal" style="background-color:#E6E2EB; padding:10px 12px; margin-left: -8px; outline: none;"><i class="fa fa-edit">Edit</i></a></td>
                                            <%}%>
                                        </tr>
                                    </tbody>
                                </table>
                                
                                <fieldset>
                                    <legend style="width: 300px;">Academic Qualifications</legend>
                                </fieldset>
                                <table class="table table-bordered" style="width: 800px;height: 5px; margin-left: 80px;">
                                    
                                    <thead>
                                        <tr>
                                            <th>Physics Grade</th>
                                            <th>Maths Grade</th>
                                            <th>Group II/Group III Grade</th>
                                            <th>Group II/Group III/Group IV/Group V Grade</th>
                                            <th>Mean Grade</th>
                                            <th>Aggregate Points</th>
                                            <th>Cluster Points</th>
                                            <th>Action</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <%if(results2.next()){
                                            physicsGrade=results2.getString("Physics_Grade");
                                            mathsGrade=results2.getString("Maths_Grade");
                                            subj3Grade=results2.getString("Subject3_Grade");
                                            subj4Grade=results2.getString("Subject4_Grade");
                                            meanGrade=results2.getString("Mean_Grade");
                                            aggregatePoints=results2.getString("Aggregate_Points");
                                            clusterPoints=results2.getString("Cluster_Points");
                                            %>
                                            <td><%=physicsGrade%></td>
                                            <td><%=mathsGrade%></td>
                                            <td><%=subj3Grade%></td>
                                            <td><%=subj4Grade%></td>
                                            <td><%=meanGrade%></td>
                                            <td><%=aggregatePoints%></td>
                                            <td><%=clusterPoints%></td>
                                            <td style="width: 68px;"><a href="#academicQualifications" data-toggle="modal" style="background-color:#E6E2EB; padding:10px 12px; margin-left: -8px; outline: none;"><i class="fa fa-edit">Edit</i></a></td>
                                            <%}%>
                                        </tr>
                                    </tbody>
                                </table>
                                
                                <fieldset>
                                    <legend style="width: 300px;">Course Details</legend>
                                </fieldset>
                                <table class="table table-bordered" style="width: 800px;height: 5px; margin-left: 80px;">
                                    
                                    <thead>
                                        <tr>
                                            <th>Programme Level</th>
                                            <th>Programme Name</th>
                                            <th>Mode of Study</th>
                                            <th>Campus/Study Center</th>
                                            <th>Action</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%
                                         int i=0;
                                         int j=0;
                                         int check=1;
                                        while(results3.next()){
                                        ResultSet results4=user.getLevelName(results3.getInt("Level_id"));
                                        ResultSet results5=user.getCourseName(results3.getInt("Course_id"));
                                        %>
                                        <tr>
                                           <% if(results4.next()){
                                               levelNames[i]=results4.getString("Level_Name");
                                           %>
                                            <td><%=results4.getString("Level_Name")%></td>
                                            <%} if(results5.next()){
                                                courseNames[j]=results5.getString("Course_Name");
                                            %>
                                            <td><%=results5.getString("Course_Name")%></td>
                                            <%}%>
                                            <td><%=results3.getString("Mode_Of_Study")%></td>
                                            <td><%=results3.getString("Campus")%></td>
                                            <td style="width: 68px;"><a href="#courseDetails<%=check%>" data-toggle="modal" style="background-color:#E6E2EB; padding:10px 12px; margin-left: -8px; outline: none;"><i class="fa fa-edit">Edit</i></a></td>
                                        </tr>
                                        <div class="modal fade" id="courseDetails<%=check%>" role="dialog">
                                            <div class="modal-dialog">
                                                <div class="modal-content">
                                                    <div class="modal-header">
                                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                                        <h4 class="modal-title" >Edit Course Details<%=results3.getString("Mode_Of_Study")%></h4>
                                                    </div>
                                                    <div class="modal-body">
                                                        
                                                        <form method="post" action="">
                                                            
                                                            <div class="form-group">
                                                                <label for="programmeLevel">Programme Level</label>
                                                                <input type="text" class="form-control" id="programmeLevel" placeholder="Programme Level" name="programmeLevel" value="<%=levelNames[i]%>">
                                                            </div>
                                                            <div class="form-group">
                                                                <label for="programmeName">Programme Name</label>
                                                                <input type="text" class="form-control" id="programmeNamee" placeholder="Programme Name" name="programmeName" value="<%=courseNames[j]%>">
                                                            </div>
                                                            <div class="form-group">
                                                                <label for="modeOfStudy">Mode of Study</label>
                                                                <input type="text" class="form-control" id="modeOfStudy" placeholder="Mode of Study" name="modeOfStudy" value="<%=results3.getString("Mode_Of_Study")%>">
                                                            </div>
                                                            <div class="form-group">
                                                                <label for="campus">Campus/Study Center</label>
                                                                <input type="text" class="form-control" id="campus" placeholder="Campus/Study Center" name="campus" value="<%=results3.getString("Campus")%>">
                                                            </div>                           
                                                            <div class="well modal-footer">
                                                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                                                <input type="submit" class="btn btn-primary" name="save" value="Save changes" />
                                                            </div>
                                                                
                                                        </form>
                                                            
                                                    </div>
                                                        
                                                </div><!-- /.modal-content -->
                                            </div><!-- /.modal-dialog -->
                                        </div><!-- /.modal -->
                                        <%
                                        i++;
                                        j++;
                                        check++;
                                        }%>
                                    </tbody>
                                </table>
                                
                            </div>
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
        
        <div class="modal fade" id="personalDetails" role="dialog">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" >Edit Personal Details</h4>
                    </div>
                    <div class="modal-body">
                        
                        <form method="post" action="">
                            <div class="form-group">
                                <label for="firstName">First Name</label>
                                <input type="text" class="form-control" id="firstName" placeholder="First Name" name="firstName" value="<%=fName%>" readonly>
                            </div>
                            <div class="form-group">
                                <label for="middleName">Middle Name</label>
                                <input type="text" class="form-control" id="middleName" placeholder="Middle Name" name="middleName" value="<%=mName%>" readonly>
                            </div>
                            <div class="form-group">
                                <label for="lastName">Last Name</label>
                                <input type="text" class="form-control" id="lastName" placeholder="Last Name" name="lastName" value="<%=lName%>" readonly>
                            </div>
                            <div class="form-group">
                                <label for="dob">Date Of Birth</label>
                                <input type="text" class="form-control" id="dob" placeholder="Date of Birth" name="dob" value="<%=dob%>">
                            </div>
                            <div class="form-group">
                                <label for="gender">Gender</label>
                                <input type="text" class="form-control" id="gender" placeholder="Gender" name="gender" value="<%=gender%>">
                            </div>
                            <div class="form-group">
                                <label for="gender">Postal Address</label>
                                <input type="text" class="form-control" id="address" placeholder="Postal Address" name="address" value="<%=address%>">
                            </div>
                            <div class="form-group">
                                <label for="gender">Mobile</label>
                                <input type="text" class="form-control" id="mobile" placeholder="Mobile" name="mobile" value="<%=mobile%>">
                            </div>
                            <div class="form-group">
                                <label for="country">Nationality</label>
                                <input type="text" class="form-control" id="country" placeholder="Nationality" name="country" value="<%=country%>">
                            </div>
                            
                            <div class="well modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                <input type="submit" class="btn btn-primary" name="save" value="Save changes" />
                            </div>
                        </form>
                    </div>
                    
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->
        
        <div class="modal fade" id="academicQualifications" role="dialog">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" >Edit Academic Credentials</h4>
                    </div>
                    <div class="modal-body">
                        
                        <form method="post" action="">
                            <div class="form-group">
                                <label for="physicsGrade">Physics Grade</label>
                                <input type="text" class="form-control" id="physicsGrade" placeholder="Physics Grade" name="physicsGrade" value="<%=physicsGrade%>">
                            </div>
                            <div class="form-group">
                                <label for="mathsGrade">Maths Grade</label>
                                <input type="text" class="form-control" id="mathsGrade" placeholder="Maths Grade" name="mathsGrade" value="<%=mathsGrade%>">
                            </div>
                            <div class="form-group">
                                <label for="subj3Grade">Group II/Group III Grade</label>
                                <input type="text" class="form-control" id="subj3Grade" placeholder="Subject3 Grade" name="subj3Grade" value="<%=subj3Grade%>">
                            </div>
                            <div class="form-group">
                                <label for="subj4Grade">Group II/Group III/Group IV/Group V Grade</label>
                                <input type="text" class="form-control" id="subj4Grade" placeholder="subject4 Grade" name="subj4Grade" value="<%=subj4Grade%>">
                            </div>
                            <div class="form-group">
                                <label for="meanGrade">Mean Grade</label>
                                <input type="text" class="form-control" id="meanGrade" placeholder="Mean Grade" name="meanGrade" value="<%=meanGrade%>">
                            </div>
                            <div class="form-group">
                                <label for="aggregatePoints">Aggregate Points</label>
                                <input type="text" class="form-control" id="aggregatePoints" placeholder="Aggregate Points" name="aggregatePoints" value="<%=aggregatePoints%>">
                            </div>
                            
                            <div class="form-group">
                                <label for="clusterPoints">Cluster Points</label>
                                <input type="text" class="form-control" id="clusterPoints" placeholder="Cluster Points" name="clusterPoints" value="<%=clusterPoints%>" readonly="readonly">
                            </div>
                            
                            <div class="well modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                <input type="submit" class="btn btn-primary" name="save" value="Save changes" />
                            </div>
                        </form>
                    </div>
                    
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->
                 
        <script type="text/javascript" src="mycss/modal/jquery.minCust.js"></script>
        <script type="text/javascript" src="mycss/modal/bootstrapJsCust.js"></script>
    </body>
</html>
