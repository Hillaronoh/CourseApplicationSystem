<%-- 
    Document   : Details
    Created on : Jul 15, 2015, 15:32:23 PM
    Author     : Kipngetich
--%>
<%@page import="java.text.DecimalFormat"%> 
<%@page import="java.sql.*" %>
<%@page import="myproject.*" %> 
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
            
        <style>
            .error{
                color: red;
            }
        </style>
            
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
                   
            <%
            Applicant user=new Applicant();
            String firstName=new String();
           
            ResultSet results=user.getApplicantDetails(applicantId);
           
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
           
            int resultsE=0;
            if(request.getParameter("save1")!=null){
                String dobE=request.getParameter("dob");
                String genderE=request.getParameter("gender");
                String addressE=request.getParameter("address");
                String mobileE=request.getParameter("mobile");
                String countryE=request.getParameter("country");
                resultsE=user.editPersonalDetails(dobE, genderE, addressE, mobileE, countryE, applicantId); 
            }
           
            int resultsE1=0;
            if(request.getParameter("save2")!=null){              
                String physics=request.getParameter("physicsGrade");
                String maths=request.getParameter("mathsGrade");
                String subj3 =request.getParameter("subj3Grade");
                String subj4=request.getParameter("subj4Grade");
                String mean=request.getParameter("meanGrade");
                String aggregatePointsString=request.getParameter("aggregatePoints");
                double aggregatePointsDouble=Double.parseDouble(aggregatePointsString); 
                                                                                                                                 
                double physicsConverted=user.convertGradestoPoints(physics);
                double mathsConverted=user.convertGradestoPoints(maths);
                double subj3Converted=user.convertGradestoPoints(subj3);
                double subj4Converted=user.convertGradestoPoints(subj4); 
                double clusterPointsE=user.calculateClusterPoints(physicsConverted, mathsConverted, subj3Converted, subj4Converted, aggregatePointsDouble); 
               
                resultsE1=user.editEducationBackground(physics, maths, subj3, subj4, mean, aggregatePointsDouble, clusterPointsE, applicantId);
            } 
           
            ResultSet results99=user.getCampuses();       
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
                                                        int li=results3.getInt("Level_id");
                                                        int ci=results3.getInt("Course_id");
                                                        String mo=results3.getString("Mode_Of_Study");
                                                        String ca=results3.getString("Campus");
                                                        ResultSet results4=user.getLevelName(li);
                                                        ResultSet results5=user.getCourseName(ci);
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
                                                            <h4 class="modal-title" >Edit Course Details</h4>
                                                        </div>
                                                        <div class="modal-body">
                                                            <form method="post" action="">
                                                                
                                                                <div class="form-group">
                                                                    <label for="programmeLevel">Programme Level</label>
                                                                    <select id="programmeLevel" name="programmeLevel" class="form-control input">
                                                                        <option value="<%=results4.getString("Level_Name")%>" selected><%=results4.getString("Level_Name")%></option> 
                                                                        <%ResultSet results13=user.getLevels();
                                                                while(results13.next()){%>
                                                                        <option value="<%=results13.getString("Level_Name")%>"><%=results13.getString("Level_Name")%></option>
                                                                        <%}%>
                                                                    </select>
                                                                </div>
                                                                <div class="form-group">
                                                                    <label for="programmeName">Programme Name</label>
                                                                    <select id="programmeName" name="programmeName" class="form-control input">
                                                                        <option value="<%=results5.getString("Course_Name")%>" selected><%=results5.getString("Course_Name")%></option> 
                                                                        <%ResultSet results12=user.getCourses();
                                                                        while(results12.next()){%>
                                                                        <option value="<%=results12.getString("course_Name")%>"><%=results12.getString("course_Name")%></option>
                                                                        <%}%>
                                                                    </select>
                                                                        
                                                                </div>
                                                                <div class="form-group">
                                                                    <label for="modeOfStudy">Mode of Study</label>
                                                                    <select id="modeOfStudy" name="modeOfStudy" class="form-control input">
                                                                        <option value="<%=results3.getString("Mode_Of_Study")%>" selected><%=results3.getString("Mode_Of_Study")%></option> 
                                                                        <option value="Full Time">Full Time</option>
                                                                        <option value="Part Time">Part Time</option>
                                                                        <option value="Evening Classes">Evening Classes</option>
                                                                        <option value="Weekend Classes">Weekend Classes</option>
                                                                    </select>
                                                                </div>
                                                                <div class="form-group">
                                                                    <label for="campus">Campus/Study Center</label>
                                                                    <select id="campus" name="campus" class="form-control input">
                                                                        <option value="<%=results3.getString("Campus")%>" selected><%=results3.getString("Campus")%></option> 
                                                                        <%ResultSet results14=user.getCampuses();
                                                                            while(results14.next()){%>
                                                                        <option value="<%=results14.getString("Campus_Name")%>"><%=results14.getString("Campus_Name")%></option>
                                                                        <%}%>
                                                                    </select>
                                                                </div>                           
                                                                <div class="well modal-footer">
                                                                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                                                    <input type="submit" class="btn btn-primary" name="save3<%=check%>" value="Save changes" />
                                                                </div>
                                                            </form>   
                                                    </div>      
                                                </div><!-- /.modal-content -->
                                            </div><!-- /.modal-dialog -->
                                        </div><!-- /.modal -->
                                        <%
                                        int levelId=0;
                                        int courseId=0;
                                        if(request.getParameter("save3"+check)!=null){              
                                            String level=request.getParameter("programmeLevel");
                                            String name=request.getParameter("programmeName");
                                            String mos =request.getParameter("modeOfStudy");
                                            String campus=request.getParameter("campus");
                                            ResultSet rs=user.getLevelId(level);
                                            if(rs.next()){
                                                levelId=rs.getInt("Level_id");
                                            } 
                                            
                                            ResultSet rs1=user.getCourseId(name);
                                            if(rs1.next()){
                                                courseId=rs1.getInt("Course_id");
                                            } 
               
                                            int resultsE2=user.editCourseDetails(levelId, courseId, mos, campus, applicantId, li, ci,mo,ca); 
                                        }
                                        
                                        i++;
                                        j++;
                                        check++;
                                        }%>
                                        
        <div class="modal fade" id="personalDetails" role="dialog">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" >Edit Personal Details</h4>
                    </div></tbody>
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
                
                                        <div class="modal-body">
                                            
                                            <form method="post" action="" id="myForm1">
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
                                                    <select id="gender" name="gender" class="form-control input">
                                                        <option value="<%=gender%>" selected><%=gender%></option> 
                                                        <option value="Male">Male</option>
                                                        <option value="Female">Female</option>
                                                    </select>
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
                                                    <button type="submit" name="save1" class="btn btn-primary">Save changes</button>
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
                            
                            <form method="post" action="" id="myForm2">
                                <div class="form-group">
                                    <label for="physicsGrade">Physics Grade</label>
                                    <select id="physics" name="physicsGrade" class="form-control input">
                                        <option value="<%=physicsGrade%>" selected><%=physicsGrade%></option> 
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
                                <div class="form-group">
                                    <label for="mathsGrade">Maths Grade</label>
                                    <select id="maths" name="mathsGrade" class="form-control input">
                                        <option value="<%=mathsGrade%>" selected><%=mathsGrade%></option> 
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
                                <div class="form-group">
                                    <label for="subj3Grade">Group II/Group III Grade</label>
                                    <select id="subj3" name="subj3Grade" class="form-control input">
                                        <option value="<%=subj3Grade%>" selected><%=subj3Grade%></option> 
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
                                <div class="form-group">
                                    <label for="subj4Grade">Group II/Group III/Group IV/Group V Grade</label>
                                    <select id="subj4" name="subj4Grade" class="form-control input">
                                        <option value="<%=subj4Grade%>" selected><%=subj4Grade%></option> 
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
                                <div class="form-group">
                                    <label for="meanGrade">Mean Grade</label>
                                    <select id="meanGrade" name="meanGrade" class="form-control input">
                                        <option value="<%=meanGrade%>" selected><%=meanGrade%></option> 
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
                                    <button type="submit" class="btn btn-primary" name="save2">Save changes</button>
                                </div>
                            </form>
                        </div>
                            
                    </div><!-- /.modal-content -->
                </div><!-- /.modal-dialog -->
            </div><!-- /.modal -->
            <script type="text/javascript" src="mycss/modal/jquery.minCust.js"></script>
            <script type="text/javascript" src="mycss/modal/bootstrapJsCust.js"></script>
            <script type="text/javascript" src="mycss/validation/jquery.js"></script>
            <script type="text/javascript" src="mycss/validation/jquery.validate.js"></script>
            <script type="text/javascript" src="mycss/validation/additional-methods.js"></script>
            <script src="mycss/validation/custom.js"></script>
    </body>
</html>
