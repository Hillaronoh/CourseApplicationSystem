<%-- 
    Document   : UserLogin
    Created on : Jun 13, 2015, 9:41:48 PM
    Author     : Kipngetich
--%>
<%@page import="java.sql.*" %>
<%@page import="myproject.*"%> 
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
         <link rel="stylesheet" type="text/css" href="vendor/css/bootstrap-formhelpers.min.css">
        
        
        <script type="text/javascript" src="mycss/dateValidater.js"></script>
        <script type="text/javascript" src="mycss/pDetailsValidate.js"></script>
        <script type="text/javascript" src="mycss/eBackgroundValidate.js"></script>
        <script type="text/javascript" src="mycss/cApplicationDetailsValidate.js"></script>
        
        <style>
            .error{
                color: red;
            }
        </style>
        <script>
            function dateDiff(dateform) {
                date1 = new Date();
                date2 = new Date();
                diff  = new Date();
                
                date1temp = new Date(dateform.dob.value);
                date1.setTime(date1temp.getTime());
                
                diff.setTime(Math.abs(date1.getTime() - date2.getTime()));
                
                timediff = diff.getTime();
                age = Math.floor(timediff / (1000 * 60 * 60 * 24*365)); 
                if(age<15){
                    alert("Your Age is too low!");
                    dateform.dob.select();
                    return false;
                }
                
            }
        </script>
    </head>
    <body style="overflow-x: hidden; background-color: #EFEEEE;"> 
        
        <%
           response.setHeader("Cache-Control","no-cache"); //Forces caches to obtain a new copy of the page from the origin server
           response.setHeader("Cache-Control","no-store"); //Directs caches not to store the page under any circumstance
           response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
           response.setHeader("Pragma","no-cache"); //HTTP 1.0 backward compatibility
            String applicantId=new String(); 
            if(session.getAttribute("applicantId")==null||(session.getAttribute("applicantId")==""))
            {
                
             response.sendRedirect("../index.jsp"); 

            }
            else
            { 
            applicantId=(String)session.getAttribute("applicantId");          
            }
       
            %>
            
                 
            <%
            Applicant user=new Applicant();
            Applicant user2=new Applicant();
            Applicant user3=new Applicant();
            
            Applicant user4=new Applicant();
            Applicant user5=new Applicant();
            Applicant user6=new Applicant();
            
            String firstName=new String();
            String middleName=new String();
            String lastName=new String();
                      
            ResultSet results=user.getApplicantDetails(applicantId); 
            int degStatusId=0;
            int dipStatusId=0;
            int certStatusId=0;
           ResultSet degStatus=user.checkSatus(3);
           ResultSet dipStatus=user2.checkSatus(4); 
           ResultSet certStatus=user3.checkSatus(5);
           if(degStatus.next()){
             degStatusId=degStatus.getInt("Status");
           }
           if(dipStatus.next()){
             dipStatusId=dipStatus.getInt("Status");
           }
           if(certStatus.next()){
             certStatusId=certStatus.getInt("Status");
           }
                      
            if(results.next()){
                firstName=results.getString("First_Name");
                middleName=results.getString("Middle_Name");
                lastName=results.getString("Last_Name");
            }
            ResultSet check1=user.checkSectionA(applicantId);
            ResultSet check2=user.checkSectionB(applicantId);
            ResultSet check3=user.checkSectionC(applicantId);
            
            ResultSet confirmRanking=user.confirmRanking();
            ResultSet crs=user.getCourseDetails(applicantId);
            ResultSet crs2=user2.getCourseDetails(applicantId);
            
            ResultSet confirmDegRanking=user.checkRankingPerLevel(3);
           ResultSet confirmDipRanking=user2.checkRankingPerLevel(4);
           ResultSet confirmCertRanking=user3.checkRankingPerLevel(5);
            
            String p=new String();
            String m=new String();
            
            ResultSet chRank1=user4.checkRankingPerLevel(3);
            ResultSet chRank2=user5.checkRankingPerLevel(4);
            ResultSet chRank3=user6.checkRankingPerLevel(5);
            boolean applicationClosed=false;
            if(degStatusId==0 && dipStatusId==0 && certStatusId==0){
               applicationClosed=true; 
            }
           /* if(chRank1.next()&&chRank2.next()&&chRank3.next()){
                applicationClosed=true;
            }*/
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
                                        <%if(applicationClosed){%>
                                        <li><a href="ApplicationForm.jsp"><button class="btn btn-info disabled" style="width: 148px; height: 38px; padding-top: 0px; margin-top: -5px; background-color: #428BCA;"><i class="fa fa-arrow-down"></i>Apply Course</button></a>
                                        <%} else{%>
                                        <li><a href="ApplicationForm.jsp"><button class="btn btn-info" style="width: 148px; height: 38px; padding-top: 0px; margin-top: -5px; background-color: #428BCA;"><i class="fa fa-arrow-down"></i>Apply Course</button></a></li>
                                            <%}%>
                                            <!--<ul>
                                                <li><a href="ApplicationForm.jsp">Under Graduate</a></li>
                                                <li><a href="#">Post Graduate</a></li>
                                            </ul>
                                        </li>-->
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
                                                
                                                ResultSet checkRe=user.confirmDetails(applicantId);
                                                if(!checkRe.next()){
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
                                                <a class="accordion-section-title alert alert-error" style="margin-bottom:0px;" href="#accordion-1"><i class="fa fa-exclamation-circle"></i>There was an error saving your details..Please try again.</a>
                                                <%}} else{%>
                                                <a class="accordion-section-title alert alert-warning" style="margin-bottom:0px;" href="#accordion-1"><i class="fa fa-warning"></i>You have already submitted your details!</a>   
                                                <% }} else{%>
                                                <a class="accordion-section-title" href="#accordion-1">SECTION A: Applicant's Personal Details.</a>
                                                <%}%>
                                                <div id="accordion-1" class="accordion-section-content"> 
                                                    
                                                    <form method="post" action="" id="myForm1" onSubmit="return dateDiff(this);">
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
                                                                    <input type="text" class="form-control input" id="mobile" name="mobile" placeholder="+..."/>
                                                                </div>
                                                                    
                                                                <div class="form-group col-sm-3">
                                                                    <div class="row">
                                                                        <div class="col-sm-12">
                                                                            <label for="country">Nationality:<span style="color:red"> *</span></label>
                                                                        </div>
                                                                    </div>
                                                                    <div class="row">
                                                                        <div class="col-sm-4">
                                                                            <button type="button" onclick="$('#countries').bfhcountries({country: 'US'})" class="btn btn-default btn-small">Countries</button>
                                                                        </div>
                                                                        <div class="col-sm-3">
                                                                            <select id="countries" name="country" class="input-medium">
                                                                                <option value="" selected="">Click Countries</option>
                                                                            </select>
                                                                        </div>
                                                                    </div>
                                                                   <!-- <input type="text" class="form-control input" id="country" name="country" placeholder="country of residence"/>-->
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
                                                if(check1.next()){
                                                    ResultSet checkRe=user.checkSectionB(applicantId);
                                                if(!checkRe.next()){
                                                String engGrade=request.getParameter("eng");
                                                String kiswGrade=request.getParameter("kisw");
                                                String mathsGrade=request.getParameter("maths");
                                                String physicsGrade=request.getParameter("physics");
                                                String grp2Grade=request.getParameter("grp2");
                                                String grp3Grade=request.getParameter("grp3");
                                                String grp4or5Grade=request.getParameter("grp4or5");
                                                                                                                                                                                 
                                                double engConverted=user.convertGradestoPoints(engGrade);
                                                double kiswConverted=user.convertGradestoPoints(kiswGrade);
                                                double mathsConverted=user.convertGradestoPoints(mathsGrade);
                                                double physicsConverted=user.convertGradestoPoints(physicsGrade);
                                                double grp2Converted=user.convertGradestoPoints(grp2Grade);
                                                double grp3Converted=user.convertGradestoPoints(grp3Grade);
                                                double grp4or5Converted=user.convertGradestoPoints(grp4or5Grade);
                                                double subj3=0.0;
                                                double subj4=0.0;
                                                
                                                double aggregatePts=user.calculateAggregatePoints(engConverted, kiswConverted, mathsConverted, physicsConverted, grp2Converted, grp3Converted, grp4or5Converted);
                                                
                                                if(grp2Converted>=grp3Converted){
                                                  subj3= grp2Converted;
                                                }else{
                                                    subj3= grp3Converted;
                                                }
                                                
                                                if(subj3>=grp4or5Converted){
                                                    subj4=subj3;
                                                }else{
                                                    subj4=grp4or5Converted;
                                                }
                                                
                                                double clusterPoints=user.calculateClusterPoints(physicsConverted, mathsConverted, subj3, subj4, aggregatePts);  
                                           
                                                int results3=user.setEducationBackground(engGrade, kiswGrade, mathsGrade, physicsGrade, grp2Grade, grp3Grade, grp4or5Grade, aggregatePts, clusterPoints, applicantId); 
                                                if(results3>0){
                                                    ResultSet legibility=user.getEducationBackground(applicantId);
                                                    if(legibility.next()){
                                                        m=legibility.getString("Math_Grade");
                                                        p=legibility.getString("Physics_Grade");
                                                    }
                                                %>
                                                <a class="accordion-section-title alert alert-success" style="margin-bottom:0px;" href="#accordion-2"><i class="fa fa-check-circle"></i>Your details has been saved successfully..Proceed to the next section.</a>
                                                <%} else{%>
                                                <a class="accordion-section-title alert alert-error" style="margin-bottom:0px;" href="#accordion-2"><i class="fa fa-exclamation-circle"></i>There was an error saving your details..Please try again.</a>
                                                <%} } else{%>
                                                <a class="accordion-section-title alert alert-warning" style="margin-bottom:0px;" href="#accordion-2"><i class="fa fa-warning"></i>You have already submitted your details!</a>
                                                <%}} else{%>
                                                    <a class="accordion-section-title alert alert-warning" style="margin-bottom:0px;" href="#accordion-2"><i class="fa fa-warning"></i>Please fill SECTION A!</a>
                                                <% }
                                            } 
                                            else{
                                                %>
                                                <a class="accordion-section-title" href="#accordion-2">SECTION B: Applicant's Education Background.</a>
                                                <%}%>
                                                <div id="accordion-2" class="accordion-section-content">
                                                    
                                                    <form role="form" method="post" action="" id="myForm2" onsubmit="return validateEducationBackgroundForm1(this)">
                                                        <fieldset>
                                                            
                                                            <div class="row" id="row1">
                                                                <div class="form-group col-sm-3">
                                                                    <label for="eng">K.C.S.E English Grade:<span style="color:red"> *</span></label>
                                                                    <select id="eng" name="eng" class="form-control input">
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
                                                                    
                                                                <div class="form-group col-sm-3">
                                                                    <label for="kisw">K.C.S.E Kiswahili Grade:<span style="color:red"> *</span></label>
                                                                    <select id="kisw" name="kisw" class="form-control input">
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
                                                                    
                                                                <div class="form-group col-sm-3">
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
                                                                
                                                                <div class="form-group col-sm-3">
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
                                                            </div>
                                                            
                                                            <div class="row" id="row2">
                                                                <div class="form-group col-sm-3">
                                                                    <label for="grp2">Any Other Group II Grade:<span style="color:red"> *</span></label>
                                                                    <select id="grp2" name="grp2" class="form-control input">
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
                                                                
                                                                <div class="form-group col-sm-3">
                                                                    <label for="grp3">Group III Grade:<span style="color:red"> *</span></label>
                                                                    <select id="grp3" name="grp3" class="form-control input">
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
                                                                    
                                                                <div class="form-group col-sm-3">
                                                                    <label for="grp4or5">Group IV or Group V Grade:<span style="color:red"> *</span></label>
                                                                    <select id="grp4or5" name="grp4or5" class="form-control input">
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
                                            int courseIdInt=0;
                                            int levelIdInt=0; 
                                            String physics=new String();
                                            ResultSet results5=user.getCampuses();
                                            //ResultSet results6=user.getCourses();
                                            if(request.getParameter("submit3")!=null){
                                                if(check2.next()){
                                                String courseIdString=request.getParameter("programmeName");
                                                courseIdInt=Integer.parseInt(courseIdString);
                                                String levelIdString=request.getParameter("programmeLevel");
                                                levelIdInt=Integer.parseInt(levelIdString);
                                           
                                               /* ResultSet results7=user.getCourseId(courseName);
                                                if(results7.next()){
                                                    courseId=results7.getInt("Course_id");
                                                }
                                           
                                                ResultSet results8=user.getLevelId(levelName); 
                                                if(results8.next()){
                                                    levelId=results8.getInt("Level_id");
                                                }*/
                                                String mos=request.getParameter("modeOfStudy");
                                                String campus=request.getParameter("campus");
                                                int campusId=Integer.parseInt(campus);
                                           
                                                int results4=user.setCourseDetails(applicantId, levelIdInt, courseIdInt, mos, campusId);
                                       
                                                if(results4>0){%> 
                                                <a class="accordion-section-title alert alert-success" style="margin-bottom:0px;" href="#accordion-3"><i class="fa fa-check-circle"></i>Your details has been saved successfully..Proceed to the next section.</a>
                                                <%} else{%>
                                                <a class="accordion-section-title alert alert-error" style="margin-bottom:0px;" href="#accordion-3"><i class="fa fa-exclamation-triangle"></i>There was an error saving your details..Please try again.</a>
                                                <%} }else{%>
                                                <a class="accordion-section-title alert alert-warning" style="margin-bottom:0px;" href="#accordion-3"><i class="fa fa-warning"></i>Please fill SECTION B!</a>
                                                <% }
                                            } 
                                            else{%>
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
                                                                    <%if(m.equals("C") && (p.equals("C")||p.equals("C+")||p.equals("B-")||p.equals("B")||p.equals("B+")||p.equals("A-")||p.equals("A"))){%>
                                                                    
                                                                    <%if(dipStatusId==1 && certStatusId==0){%>  
                                                                    <option value="4">Diploma</option>
                                                                    <%} else if(dipStatusId==0 && certStatusId==1){%>
                                                                    <option value="5">Certificate</option>
                                                                    <%} else {%>
                                                                    <option value="4">Diploma</option>
                                                                    <option value="5">Certificate</option>
                                                                    <%}%>
                                                                    
                                                                    <%}
                                                                    else if(p.equals("C") && (m.equals("C")||m.equals("C+")||m.equals("B-")||m.equals("B")||m.equals("B+")||m.equals("A-")||m.equals("A"))){%>
                                                                    
                                                                    <%if(dipStatusId==1 && certStatusId==0){%>  
                                                                    <option value="4">Diploma</option>
                                                                    <%} else if(dipStatusId==0 && certStatusId==1){%>
                                                                    <option value="5">Certificate</option>
                                                                    <%} else {%>
                                                                    <option value="4">Diploma</option>
                                                                    <option value="5">Certificate</option>
                                                                    <%}%>
                                                                   
                                                                    <%} 
                                                                    else if(m.equals("C-") && (p.equals("C-")||p.equals("C")||p.equals("C+")||p.equals("B-")||p.equals("B")||p.equals("B+")||p.equals("A-")||p.equals("A"))){%>
                                                                    <option value="5">Certificate</option>
                                                                    <%}
                                                                    else if(p.equals("C-") && (m.equals("C-")||m.equals("C")||m.equals("C+")||m.equals("B-")||m.equals("B")||m.equals("B+")||m.equals("A-")||m.equals("A"))){%>
                                                                    <option value="5">Certificate</option>
                                                                    <%} 
                                                                    else if(m.equals("D+")||m.equals("D")||m.equals("D-")||m.equals("E")){%>
                                                                     <option value="">Can't Qualify (Maths Grade Too Low!)</option>
                                                                    <%} 
                                                                    else if(p.equals("D+")||p.equals("D")||p.equals("D-")||p.equals("E")){%>
                                                                    <option value="">Can't Qualify (Physics Grade Too Low!)</option>
                                                                    <%} else{%>
                                                                    
                                                                    <%if(degStatusId==0 && dipStatusId==1 && certStatusId==1){%>  
                                                                    <option value="4">Diploma</option>
                                                                    <option value="5">Certificate</option>
                                                                    <%} else if(degStatusId==1 && dipStatusId==0 && certStatusId==1){%>
                                                                    <option value="3">Degree</option>
                                                                    <option value="5">Certificate</option>
                                                                    <%} else if(degStatusId==1 && dipStatusId==1 && certStatusId==0){%>
                                                                    <option value="3">Degree</option>
                                                                    <option value="4">Diploma</option>
                                                                    <%} else if(degStatusId==0 && dipStatusId==0 && certStatusId==1){%>
                                                                    <option value="5">Certificate</option>
                                                                    <%} else if(degStatusId==0 && dipStatusId==1 && certStatusId==0){%>
                                                                    <option value="4">Diploma</option>
                                                                    <%} else if(degStatusId==1 && dipStatusId==0 && certStatusId==0){%>
                                                                    <option value="3">Degree</option>
                                                                    <%} else{%>
                                                                    <option value="3">Degree</option>
                                                                    <option value="4">Diploma</option>
                                                                    <option value="5">Certificate</option>
                                                                    <%}%>
                                                                    
                                                                    <%}%>
                                                                </select>
                                                            </div>
                                                                
                                                                
                                                            <div class="form-group col-sm-4">
                                                                <label for="programmeName">Programme Name:<span style="color:red"> *</span></label>
                                                                <select id="programmeName" name="programmeName" class="form-control input">
                                                                    <option value="" selected>~select programme name~</option> 
                                                                    
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
                                                                            <option value="<%=results5.getString("campus_id")%>"><%=results5.getString("campus_Name")%></option>
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
                                            <%if(request.getParameter("print")!=null){%>
                                            <a class="accordion-section-title alert alert-warning" style="margin-bottom:0px;" href="#accordion-4"><i class="fa fa-warning"></i>Please fill All Sections before printing!</a>
                                            <%} else{%>
                                            <a class="accordion-section-title" href="#accordion-4">SECTION D: Print Your Form.</a>
                                            <%}%>
                                            <div id="accordion-4" class="accordion-section-content">
                                                 <% if(check1.next() && check2.next() && check3.next()){%>
                                                <form action="PdfGenerator.jsp">
                                                    <button class="btn btn-success"><i class="fa fa-print">Print</i></button>
                                                </form>  
                                                <%} else{%> 
                                                <form action="">
                                                    <button type="submit" class="btn btn-success" name="print"><i class="fa fa-print">Print</i></button>
                                                </form>
                                                <%}%>
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
                        <%if(!crs2.next()){%>
                        <h4 class="alert alert-danger">Status not found!<br/>Please Apply a course of your choice now.</h4> 
                        <%} else{%>
                        <%if(!confirmDegRanking.next() && !confirmDipRanking.next() && !confirmCertRanking.next()){%>
                        <h4 class="alert alert-danger">Status not found!<br/>Results not yet out, Keep checking.</h4>
                        <%} else if(confirmDegRanking.next() && !confirmDipRanking.next() && !confirmCertRanking.next()){%>
                        <h4 class="alert alert-info">Check Carefully on the table below;</h4>
                        <table class="table table-bordered">
                            <thead>
                                <tr>
                                    <th>Course Level</th>
                                    <th>Course Name</th>
                                    <th>Application Status</th>
                                    <th>Comment</th>
                                </tr>
                            </thead>
                            <%int li=0;
                            int ci=0;
                            int rank=0;
                            int i=0;
                            String[] levels=new String[12];
                            String[] names=new String[12];
                            String[] status=new String[12];
                            String[] comments=new String[12];
                            ResultSet crn=null;
                            ResultSet ln=null;
                        while(crs.next()){
                            li=crs.getInt("Level_id");
                            ci=crs.getInt("Course_id");
                           
                            if(li==3&&ci==1){
                                ResultSet getrank=user.getDegCsRank(applicantId);
                                
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                 }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Not Successful";
                                      comments[i]="Thanks for your application.";
                                       } 
                                }
                                i++;
                            }
                            
                            if(li==3&&ci==2){
                                ResultSet getrank=user.getDegItRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next(); 
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Not Successful";
                                      comments[i]="Thanks for your application.";
                                  }
                                }
                                i++; 
                            }
                            
                            if(li==3&&ci==3){
                                ResultSet getrank=user.getDegInfoRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Not Successful";
                                      comments[i]="Thanks for your application.";
                                  }
                                }
                                i++;
                            }
                            
                            if(li==3&&ci==4){
                                ResultSet getrank=user.getDegCfRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                 }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Not Successful";
                                      comments[i]="Thanks for your application.";
                                  }
                                }
                                i++;
                            }
                            
                            if(li==4&&ci==1){
                                ResultSet getrank=user.getDipCsRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                 }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Diploma results not yet out.";
                                      comments[i]="keep checking.";
                                   }
                                }
                                i++;
                            }
                            
                            if(li==4&&ci==2){
                                ResultSet getrank=user.getDipItRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Diploma results not yet out.";
                                      comments[i]="Keep checking.";
                                  }
                                }
                                i++;
                            }
                            
                            if(li==4&&ci==3){ 
                                ResultSet getrank=user.getDipInfoRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Diploma results not yet out.";
                                      comments[i]="keep checking.";
                                   }
                                }
                                i++;
                            }
                            
                            if(li==4&&ci==4){ 
                                ResultSet getrank=user.getDipCfRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Diploma results not yet out.";
                                      comments[i]="keep checking.";
                                   }
                                }
                                i++;
                            }
                            
                            if(li==5&&ci==2){ 
                                ResultSet getrank=user.getCertItRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Certificate results not yet out.";
                                      comments[i]="keep checking.";
                                   }
                                }
                                i++;
                            }
                            
                            if(li==5&&ci==4){ 
                                ResultSet getrank=user.getCertCfRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Certificate results not yet out.";
                                      comments[i]="keep checking.";
                                  }
                                }
                                i++;
                            }
                            
                            if(li==5&&ci==5){ 
                                ResultSet getrank=user.getCertIsRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id")); 
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Certificate results not yet out.";
                                      comments[i]="keep checking.";
                                  }
                                }
                                i++;
                            }
                            
                            if(li==5&&ci==6){ 
                                ResultSet getrank=user.getCertHmRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Certificate results not yet out.";
                                      comments[i]="keep checking.";
                                  }
                                }
                                i++;
                            }
                           }%>
                           <% --i;%>
                           <%while(i>=0){%>
                           <tr>
                               <td><%=levels[i]%></td> 
                               <td><%=names[i]%></td>
                               <td><%=status[i]%></td>
                               <td><%=comments[i]%></td>
                           </tr>
                           <%i--;}%>
                        </table>
                        <%} else if(!confirmDegRanking.next() && confirmDipRanking.next() && !confirmCertRanking.next()){%>
                        <h4 class="alert alert-info">Check Carefully on the table below;</h4>
                        <table class="table table-bordered">
                            <thead>
                                <tr>
                                    <th>Course Level</th>
                                    <th>Course Name</th>
                                    <th>Application Status</th>
                                    <th>Comment</th>
                                </tr>
                            </thead>
                            <%int li=0;
                            int ci=0;
                            int rank=0;
                            int i=0;
                            String[] levels=new String[12];
                            String[] names=new String[12];
                            String[] status=new String[12];
                            String[] comments=new String[12];
                            ResultSet crn=null;
                            ResultSet ln=null;
                        while(crs.next()){
                            li=crs.getInt("Level_id");
                            ci=crs.getInt("Course_id");
                           
                            if(li==3&&ci==1){
                                ResultSet getrank=user.getDegCsRank(applicantId);
                                
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                 }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Degree results not yet out.";
                                      comments[i]="keep checking.";
                                       } 
                                }
                                i++;
                            }
                            
                            if(li==3&&ci==2){
                                ResultSet getrank=user.getDegItRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next(); 
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Degree results not yet out.";
                                      comments[i]="keep checking.";
                                  }
                                }
                                i++; 
                            }
                            
                            if(li==3&&ci==3){
                                ResultSet getrank=user.getDegInfoRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Degree results not yet out.";
                                      comments[i]="keep checking.";
                                  }
                                }
                                i++;
                            }
                            
                            if(li==3&&ci==4){
                                ResultSet getrank=user.getDegCfRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                 }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Degree results not yet out.";
                                      comments[i]="keep checking.";
                                  }
                                }
                                i++;
                            }
                            
                            if(li==4&&ci==1){
                                ResultSet getrank=user.getDipCsRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                 }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Not Successful";
                                      comments[i]="Thanks for your application.";
                                   }
                                }
                                i++;
                            }
                            
                            if(li==4&&ci==2){
                                ResultSet getrank=user.getDipItRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Not Successful";
                                      comments[i]="Thanks for your application.";
                                  }
                                }
                                i++;
                            }
                            
                            if(li==4&&ci==3){ 
                                ResultSet getrank=user.getDipInfoRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Not Successful";
                                      comments[i]="Thanks for your application.";
                                   }
                                }
                                i++;
                            }
                            
                            if(li==4&&ci==4){ 
                                ResultSet getrank=user.getDipCfRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Not Successful";
                                      comments[i]="Thanks for your application.";
                                   }
                                }
                                i++;
                            }
                            
                            if(li==5&&ci==2){ 
                                ResultSet getrank=user.getCertItRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Certificate results not yet out.";
                                      comments[i]="keep checking.";
                                   }
                                }
                                i++;
                            }
                            
                            if(li==5&&ci==4){ 
                                ResultSet getrank=user.getCertCfRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Certificate results not yet out.";
                                      comments[i]="keep checking.";
                                  }
                                }
                                i++;
                            }
                            
                            if(li==5&&ci==5){ 
                                ResultSet getrank=user.getCertIsRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id")); 
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Certificate results not yet out.";
                                      comments[i]="keep checking.";
                                  }
                                }
                                i++;
                            }
                            
                            if(li==5&&ci==6){ 
                                ResultSet getrank=user.getCertHmRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Certificate results not yet out.";
                                      comments[i]="keep checking.";
                                  }
                                }
                                i++;
                            }
                           }%>
                           <% --i;%>
                           <%while(i>=0){%>
                           <tr>
                               <td><%=levels[i]%></td> 
                               <td><%=names[i]%></td>
                               <td><%=status[i]%></td>
                               <td><%=comments[i]%></td>
                           </tr>
                           <%i--;}%>
                        </table>
                        <%} else if(!confirmDegRanking.next() && !confirmDipRanking.next() && confirmCertRanking.next()){%>
                        <h4 class="alert alert-info">Check Carefully on the table below;</h4>
                        <table class="table table-bordered">
                            <thead>
                                <tr>
                                    <th>Course Level</th>
                                    <th>Course Name</th>
                                    <th>Application Status</th>
                                    <th>Comment</th>
                                </tr>
                            </thead>
                            <%int li=0;
                            int ci=0;
                            int rank=0;
                            int i=0;
                            String[] levels=new String[12];
                            String[] names=new String[12];
                            String[] status=new String[12];
                            String[] comments=new String[12];
                            ResultSet crn=null;
                            ResultSet ln=null;
                        while(crs.next()){
                            li=crs.getInt("Level_id");
                            ci=crs.getInt("Course_id");
                           
                            if(li==3&&ci==1){
                                ResultSet getrank=user.getDegCsRank(applicantId);
                                
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                 }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Degree results not yet out.";
                                      comments[i]="keep checking.";
                                       } 
                                }
                                i++;
                            }
                            
                            if(li==3&&ci==2){
                                ResultSet getrank=user.getDegItRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next(); 
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Degree results not yet out.";
                                      comments[i]="keep checking.";
                                  }
                                }
                                i++; 
                            }
                            
                            if(li==3&&ci==3){
                                ResultSet getrank=user.getDegInfoRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Degree results not yet out.";
                                      comments[i]="keep checking.";
                                  }
                                }
                                i++;
                            }
                            
                            if(li==3&&ci==4){
                                ResultSet getrank=user.getDegCfRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                 }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Degree results not yet out.";
                                      comments[i]="keep checking.";
                                  }
                                }
                                i++;
                            }
                            
                            if(li==4&&ci==1){
                                ResultSet getrank=user.getDipCsRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                 }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Diploma results not yet out.";
                                      comments[i]="keep checking.";
                                   }
                                }
                                i++;
                            }
                            
                            if(li==4&&ci==2){
                                ResultSet getrank=user.getDipItRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Diploma results not yet out.";
                                      comments[i]="keep checking.";
                                  }
                                }
                                i++;
                            }
                            
                            if(li==4&&ci==3){ 
                                ResultSet getrank=user.getDipInfoRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Diploma results not yet out.";
                                      comments[i]="keep checking.";
                                   }
                                }
                                i++;
                            }
                            
                            if(li==4&&ci==4){ 
                                ResultSet getrank=user.getDipCfRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Diploma results not yet out.";
                                      comments[i]="keep checking.";
                                   }
                                }
                                i++;
                            }
                            
                            if(li==5&&ci==2){ 
                                ResultSet getrank=user.getCertItRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Not Successful";
                                      comments[i]="Thanks for your application.";
                                   }
                                }
                                i++;
                            }
                            
                            if(li==5&&ci==4){ 
                                ResultSet getrank=user.getCertCfRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Not Successful";
                                      comments[i]="Thanks for your application.";
                                  }
                                }
                                i++;
                            }
                            
                            if(li==5&&ci==5){ 
                                ResultSet getrank=user.getCertIsRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id")); 
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Not Successful";
                                      comments[i]="Thanks for your application.";
                                  }
                                }
                                i++;
                            }
                            
                            if(li==5&&ci==6){ 
                                ResultSet getrank=user.getCertHmRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Not Successful";
                                      comments[i]="Thanks for your application.";
                                  }
                                }
                                i++;
                            }
                           }%>
                           <% --i;%>
                           <%while(i>=0){%>
                           <tr>
                               <td><%=levels[i]%></td> 
                               <td><%=names[i]%></td>
                               <td><%=status[i]%></td>
                               <td><%=comments[i]%></td>
                           </tr>
                           <%i--;}%>
                        </table>
                        <%}
                        else if(confirmDegRanking.next() && confirmDipRanking.next() || !confirmCertRanking.next()){%>
                        <h4 class="alert alert-info">Check Carefully on the table below;</h4>
                        <table class="table table-bordered">
                            <thead>
                                <tr>
                                    <th>Course Level</th>
                                    <th>Course Name</th>
                                    <th>Application Status</th>
                                    <th>Comment</th>
                                </tr>
                            </thead>
                            <%int li=0;
                            int ci=0;
                            int rank=0;
                            int i=0;
                            String[] levels=new String[12];
                            String[] names=new String[12];
                            String[] status=new String[12];
                            String[] comments=new String[12];
                            ResultSet crn=null;
                            ResultSet ln=null;
                        while(crs.next()){
                            li=crs.getInt("Level_id");
                            ci=crs.getInt("Course_id");
                           
                            if(li==3&&ci==1){
                                ResultSet getrank=user.getDegCsRank(applicantId);
                                
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                 }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Not Successful";
                                      comments[i]="Thanks for your application.";
                                       } 
                                }
                                i++;
                            }
                            
                            if(li==3&&ci==2){
                                ResultSet getrank=user.getDegItRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next(); 
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Not Successful";
                                      comments[i]="Thanks for your application.";
                                  }
                                }
                                i++; 
                            }
                            
                            if(li==3&&ci==3){
                                ResultSet getrank=user.getDegInfoRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Not Successful";
                                      comments[i]="Thanks for your application.";
                                  }
                                }
                                i++;
                            }
                            
                            if(li==3&&ci==4){
                                ResultSet getrank=user.getDegCfRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                 }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Not Successful";
                                      comments[i]="Thanks for your application.";
                                  }
                                }
                                i++;
                            }
                            
                            if(li==4&&ci==1){
                                ResultSet getrank=user.getDipCsRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                 }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Not Successful";
                                      comments[i]="Thanks for your application.";
                                   }
                                }
                                i++;
                            }
                            
                            if(li==4&&ci==2){
                                ResultSet getrank=user.getDipItRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Not Successful";
                                      comments[i]="Thanks for your application.";
                                  }
                                }
                                i++;
                            }
                            
                            if(li==4&&ci==3){ 
                                ResultSet getrank=user.getDipInfoRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Not Successful";
                                      comments[i]="Thanks for your application.";
                                   }
                                }
                                i++;
                            }
                            
                            if(li==4&&ci==4){ 
                                ResultSet getrank=user.getDipCfRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Not Successful";
                                      comments[i]="Thanks for your application.";
                                   }
                                }
                                i++;
                            }
                            
                            if(li==5&&ci==2){ 
                                ResultSet getrank=user.getCertItRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Certificate results not yet out.";
                                      comments[i]="keep checking.";
                                   }
                                }
                                i++;
                            }
                            
                            if(li==5&&ci==4){ 
                                ResultSet getrank=user.getCertCfRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Certificate results not yet out.";
                                      comments[i]="keep checking.";
                                  }
                                }
                                i++;
                            }
                            
                            if(li==5&&ci==5){ 
                                ResultSet getrank=user.getCertIsRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id")); 
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Certificate results not yet out.";
                                      comments[i]="keep checking.";
                                  }
                                }
                                i++;
                            }
                            
                            if(li==5&&ci==6){ 
                                ResultSet getrank=user.getCertHmRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Certificate results not yet out.";
                                      comments[i]="keep checking.";
                                  }
                                }
                                i++;
                            }
                           }%>
                           <% --i;%>
                           <%while(i>=0){%>
                           <tr>
                               <td><%=levels[i]%></td> 
                               <td><%=names[i]%></td>
                               <td><%=status[i]%></td>
                               <td><%=comments[i]%></td>
                           </tr>
                           <%i--;}%>
                        </table>
                        <%} else if(confirmDegRanking.next() && !confirmDipRanking.next() && confirmCertRanking.next()){%>
                        <h4 class="alert alert-info">Check Carefully on the table below;</h4>
                        <table class="table table-bordered">
                            <thead>
                                <tr>
                                    <th>Course Level</th>
                                    <th>Course Name</th>
                                    <th>Application Status</th>
                                    <th>Comment</th>
                                </tr>
                            </thead>
                            <%int li=0;
                            int ci=0;
                            int rank=0;
                            int i=0;
                            String[] levels=new String[12];
                            String[] names=new String[12];
                            String[] status=new String[12];
                            String[] comments=new String[12];
                            ResultSet crn=null;
                            ResultSet ln=null;
                        while(crs.next()){
                            li=crs.getInt("Level_id");
                            ci=crs.getInt("Course_id");
                           
                            if(li==3&&ci==1){
                                ResultSet getrank=user.getDegCsRank(applicantId);
                                
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                 }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Not Successful";
                                      comments[i]="Thanks for your application.";
                                       } 
                                }
                                i++;
                            }
                            
                            if(li==3&&ci==2){
                                ResultSet getrank=user.getDegItRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next(); 
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Not Successful";
                                      comments[i]="Thanks for your application.";
                                  }
                                }
                                i++; 
                            }
                            
                            if(li==3&&ci==3){
                                ResultSet getrank=user.getDegInfoRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Not Successful";
                                      comments[i]="Thanks for your application.";
                                  }
                                }
                                i++;
                            }
                            
                            if(li==3&&ci==4){
                                ResultSet getrank=user.getDegCfRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                 }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Not Successful";
                                      comments[i]="Thanks for your application.";
                                  }
                                }
                                i++;
                            }
                            
                            if(li==4&&ci==1){
                                ResultSet getrank=user.getDipCsRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                 }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Diploma results not yet out.";
                                      comments[i]="keep checking.";
                                   }
                                }
                                i++;
                            }
                            
                            if(li==4&&ci==2){
                                ResultSet getrank=user.getDipItRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Diploma results not yet out.";
                                      comments[i]="keep checking.";
                                  }
                                }
                                i++;
                            }
                            
                            if(li==4&&ci==3){ 
                                ResultSet getrank=user.getDipInfoRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Diploma results not yet out.";
                                      comments[i]="keep checking.";
                                   }
                                }
                                i++;
                            }
                            
                            if(li==4&&ci==4){ 
                                ResultSet getrank=user.getDipCfRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Diploma results not yet out.";
                                      comments[i]="keep checking.";
                                   }
                                }
                                i++;
                            }
                            
                            if(li==5&&ci==2){ 
                                ResultSet getrank=user.getCertItRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Not Successful";
                                      comments[i]="Thanks for your application.";
                                   }
                                }
                                i++;
                            }
                            
                            if(li==5&&ci==4){ 
                                ResultSet getrank=user.getCertCfRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Not Successful";
                                      comments[i]="Thanks for your application.";
                                  }
                                }
                                i++;
                            }
                            
                            if(li==5&&ci==5){ 
                                ResultSet getrank=user.getCertIsRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id")); 
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Not Successful";
                                      comments[i]="Thanks for your application.";
                                  }
                                }
                                i++;
                            }
                            
                            if(li==5&&ci==6){ 
                                ResultSet getrank=user.getCertHmRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Not Successful";
                                      comments[i]="Thanks for your application.";
                                  }
                                }
                                i++;
                            }
                           }%>
                           <% --i;%>
                           <%while(i>=0){%>
                           <tr>
                               <td><%=levels[i]%></td> 
                               <td><%=names[i]%></td>
                               <td><%=status[i]%></td>
                               <td><%=comments[i]%></td>
                           </tr>
                           <%i--;}%>
                        </table>
                        <%} else if(!confirmDegRanking.next() && confirmDipRanking.next() && confirmCertRanking.next()){%>
                        <h4 class="alert alert-info">Check Carefully on the table below;</h4>
                        <table class="table table-bordered">
                            <thead>
                                <tr>
                                    <th>Course Level</th>
                                    <th>Course Name</th>
                                    <th>Application Status</th>
                                    <th>Comment</th>
                                </tr>
                            </thead>
                            <%int li=0;
                            int ci=0;
                            int rank=0;
                            int i=0;
                            String[] levels=new String[12];
                            String[] names=new String[12];
                            String[] status=new String[12];
                            String[] comments=new String[12];
                            ResultSet crn=null;
                            ResultSet ln=null;
                        while(crs.next()){
                            li=crs.getInt("Level_id");
                            ci=crs.getInt("Course_id");
                           
                            if(li==3&&ci==1){
                                ResultSet getrank=user.getDegCsRank(applicantId);
                                
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                 }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Degree results not yet out.";
                                      comments[i]="keep checking.";
                                       } 
                                }
                                i++;
                            }
                            
                            if(li==3&&ci==2){
                                ResultSet getrank=user.getDegItRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next(); 
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Degree results not yet out.";
                                      comments[i]="keep checking.";
                                  }
                                }
                                i++; 
                            }
                            
                            if(li==3&&ci==3){
                                ResultSet getrank=user.getDegInfoRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Degree results not yet out.";
                                      comments[i]="keep checking.";
                                  }
                                }
                                i++;
                            }
                            
                            if(li==3&&ci==4){
                                ResultSet getrank=user.getDegCfRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                 }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Degree results not yet out.";
                                      comments[i]="keep checking.";
                                  }
                                }
                                i++;
                            }
                            
                            if(li==4&&ci==1){
                                ResultSet getrank=user.getDipCsRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                 }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Not Successful";
                                      comments[i]="Thanks for your application.";
                                   }
                                }
                                i++;
                            }
                            
                            if(li==4&&ci==2){
                                ResultSet getrank=user.getDipItRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Not Successful";
                                      comments[i]="Thanks for your application.";
                                  }
                                }
                                i++;
                            }
                            
                            if(li==4&&ci==3){ 
                                ResultSet getrank=user.getDipInfoRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Not Successful";
                                      comments[i]="Thanks for your application.";
                                   }
                                }
                                i++;
                            }
                            
                            if(li==4&&ci==4){ 
                                ResultSet getrank=user.getDipCfRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Not Successful";
                                      comments[i]="Thanks for your application.";
                                   }
                                }
                                i++;
                            }
                            
                            if(li==5&&ci==2){ 
                                ResultSet getrank=user.getCertItRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Not Successful";
                                      comments[i]="Thanks for your application.";
                                   }
                                }
                                i++;
                            }
                            
                            if(li==5&&ci==4){ 
                                ResultSet getrank=user.getCertCfRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Not Successful";
                                      comments[i]="Thanks for your application.";
                                  }
                                }
                                i++;
                            }
                            
                            if(li==5&&ci==5){ 
                                ResultSet getrank=user.getCertIsRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id")); 
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Not Successful";
                                      comments[i]="Thanks for your application.";
                                  }
                                }
                                i++;
                            }
                            
                            if(li==5&&ci==6){ 
                                ResultSet getrank=user.getCertHmRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Not Successful";
                                      comments[i]="Thanks for your application.";
                                  }
                                }
                                i++;
                            }
                           }%>
                           <% --i;%>
                           <%while(i>=0){%>
                           <tr>
                               <td><%=levels[i]%></td> 
                               <td><%=names[i]%></td>
                               <td><%=status[i]%></td>
                               <td><%=comments[i]%></td>
                           </tr>
                           <%i--;}%>
                        </table>
                        <%}
                        else if(confirmDegRanking.next() && confirmDipRanking.next() && confirmCertRanking.next()){%>
                        <h4 class="alert alert-info">Check Carefully on the table below;</h4>
                        <table class="table table-bordered">
                            <thead>
                                <tr>
                                    <th>Course Level</th>
                                    <th>Course Name</th>
                                    <th>Application Status</th>
                                    <th>Comment</th>
                                </tr>
                            </thead>
                            <%int li=0;
                            int ci=0;
                            int rank=0;
                            int i=0;
                            String[] levels=new String[12];
                            String[] names=new String[12];
                            String[] status=new String[12];
                            String[] comments=new String[12];
                            ResultSet crn=null;
                            ResultSet ln=null;
                        while(crs.next()){
                            li=crs.getInt("Level_id");
                            ci=crs.getInt("Course_id");
                           
                            if(li==3&&ci==1){
                                ResultSet getrank=user.getDegCsRank(applicantId);
                                
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                 }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Not Successful";
                                      comments[i]="Thanks for your application.";
                                       } 
                                }
                                i++;
                            }
                            
                            if(li==3&&ci==2){
                                ResultSet getrank=user.getDegItRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next(); 
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Not Successful";
                                      comments[i]="Thanks for your application.";
                                  }
                                }
                                i++; 
                            }
                            
                            if(li==3&&ci==3){
                                ResultSet getrank=user.getDegInfoRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Not Successful";
                                      comments[i]="Thanks for your application.";
                                  }
                                }
                                i++;
                            }
                            
                            if(li==3&&ci==4){
                                ResultSet getrank=user.getDegCfRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                 }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Not Successful";
                                      comments[i]="Thanks for your application.";
                                  }
                                }
                                i++;
                            }
                            
                            if(li==4&&ci==1){
                                ResultSet getrank=user.getDipCsRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                 }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Not Successful";
                                      comments[i]="Thanks for your application.";
                                   }
                                }
                                i++;
                            }
                            
                            if(li==4&&ci==2){
                                ResultSet getrank=user.getDipItRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Not Successful";
                                      comments[i]="Thanks for your application.";
                                  }
                                }
                                i++;
                            }
                            
                            if(li==4&&ci==3){ 
                                ResultSet getrank=user.getDipInfoRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Not Successful";
                                      comments[i]="Thanks for your application.";
                                   }
                                }
                                i++;
                            }
                            
                            if(li==4&&ci==4){ 
                                ResultSet getrank=user.getDipCfRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Not Successful";
                                      comments[i]="Thanks for your application.";
                                   }
                                }
                                i++;
                            }
                            
                            if(li==5&&ci==2){ 
                                ResultSet getrank=user.getCertItRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Not Successful";
                                      comments[i]="Thanks for your application.";
                                   }
                                }
                                i++;
                            }
                            
                            if(li==5&&ci==4){ 
                                ResultSet getrank=user.getCertCfRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Not Successful";
                                      comments[i]="Thanks for your application.";
                                  }
                                }
                                i++;
                            }
                            
                            if(li==5&&ci==5){ 
                                ResultSet getrank=user.getCertIsRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id")); 
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Not Successful";
                                      comments[i]="Thanks for your application.";
                                  }
                                }
                                i++;
                            }
                            
                            if(li==5&&ci==6){ 
                                ResultSet getrank=user.getCertHmRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Not Successful";
                                      comments[i]="Thanks for your application.";
                                  }
                                }
                                i++;
                            }
                           }%>
                           <% --i;%>
                           <%while(i>=0){%>
                           <tr>
                               <td><%=levels[i]%></td> 
                               <td><%=names[i]%></td>
                               <td><%=status[i]%></td>
                               <td><%=comments[i]%></td>
                           </tr>
                           <%i--;}%>
                        </table>
                        <%}
                        }%>
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
                
                <script src="js/bootstrap-formhelpers.min.js"></script>
               
                <script>
                    $(document).ready(function(){
                        $("#programmeLevel").change(function(){
                            var value = $(this).val();
                            $.get("GetCourses.jsp",{programmeLevel:value},function(data){
                                $("#programmeName").html(data);//append('<option>' + data + '</option>');
                            });
                        });
                    });
                </script>
    </body>
</html>
