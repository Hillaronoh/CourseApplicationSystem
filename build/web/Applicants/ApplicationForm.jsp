<%-- 
    Document   : UserLogin
    Created on : Jun 13, 2015, 9:41:48 PM
    Author     : Kipngetich
--%>
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
                                <li><a href="#"><button class="btn btn-info" style="width: 148px; height: 38px; padding-top: 0px; margin-top: -5px;"><i class="fa fa-user"></i>kip</button></a>
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
                                        <a class="accordion-section-title" href="#accordion-1">SECTION A: Applicant's Personal Details.</a>
                                        <div id="accordion-1" class="accordion-section-content"> 
                                            
                                            <form method="post" action="" id="myForm1" onsubmit="return validatePersonaldetailsForm1(this)">
                                                <fieldset>
                                                    
                                                    <div class="row" id="firstNameRow">   
                                                        <div class="form-group col-sm-3">
                                                            <label for="fname">First Name:<span style="color:red"> *</span></label>
                                                            <input type="text" class="form-control input" id="fname" name="fname" placeholder="First Name"/>
                                                        </div>
                                                        
                                                        <div class="form-group col-sm-3">
                                                            <label for="mname">Middle Name:</label>
                                                            <input type="text" class="form-control input" id="mname" name="mname" placeholder="Middle Name"/>
                                                        </div>
                                                        
                                                        <div class="form-group col-sm-3">
                                                            <label for="fname">Last Name:<span style="color:red"> *</span></label>
                                                            <input type="text" class="form-control input" id="lname" name="lname" placeholder="Last Name"/>
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
                                        <a class="accordion-section-title" href="#accordion-2">SECTION B: Applicant's Education Background.</a>
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
                                        <a class="accordion-section-title" href="#accordion-3">SECTION C: Course Application Details.</a>
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
                                                                <option value="Computer Science">Computer Science</option>
                                                                <option value="Information Technology">Information Technology</option>
                                                                <option value="Computer Studies">Computer Studies</option>
                                                                <option value="Computer Forensics">Computer Forensics</option>
                                                            </select>
                                                        </div>
                                                        <div class="col-sm-2"></div>
                                                    </div>
                                                    
                                                    <div class="row" id="modeOfStudyRow">
                                                        <div class="col-sm-2"></div>
                                                        <div class="form-group col-sm-4">
                                                            <label for="modeOfStudy">Mode of StudyRow:<span style="color:red"> *</span></label>
                                                            <select id="modeOfStudy" name="modeOfStudy" class="form-control input">
                                                                <option value="" selected>~select mode of study</option> 
                                                                <option value="Full Time">Full Time</option>
                                                                <option value="Part Time">Part Time</option>
                                                                <option value="Evening">Evening Classes</option>
                                                                <option value="Weekend Classes">Weekend Classes</option>
                                                            </select>
                                                        </div>
                                                        
                                                        <div class="form-group col-sm-4">
                                                            <label for="campus">Campus/Study Center:<span style="color:red"> *</span></label>
                                                            <select id="campus" name="campus" class="form-control input">
                                                                <option value="" selected>~select mode of study</option> 
                                                                <option value="Full Time">Full Time</option>
                                                                <option value="Part Time">Part Time</option>
                                                                <option value="Evening">Evening Classes</option>
                                                                <option value="Weekend Classes">Weekend Classes</option>
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
