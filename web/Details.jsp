<%-- 
    Document   : Details
    Created on : Jul 15, 2015, 15:32:23 PM
    Author     : Kipngetich
--%>


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
                                            <th>Gender</th>
                                            <th>Date of Birth</th>
                                            <th>Nationality</th>
                                            <th>Action</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td>John</td>
                                            <td>kiprono</td>
                                            <td>Sigei</td>
                                            <td>Male</td>
                                            <td>1989-09-11</td>
                                            <td>Kenya</td>
                                            <td style="width: 68px;"><a href="#personalDetails" data-toggle="modal" style="background-color:#E6E2EB; padding:10px 12px; margin-left: -8px; outline: none;"><i class="fa fa-edit">Edit</i></a></td>
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
                                            <th>Action</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td>A</td>
                                            <td>A</td>
                                            <td>A</td>
                                            <td>B</td>
                                            <td>A-</td>
                                            <td>78</td>
                                             <td style="width: 68px;"><a href="#personalDetails" data-toggle="modal" style="background-color:#E6E2EB; padding:10px 12px; margin-left: -8px; outline: none;"><i class="fa fa-edit">Edit</i></a></td>
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
                                        <tr>
                                            <td>Degree</td>
                                            <td>Computer Science</td>
                                            <td>Full Time</td>
                                            <td>Main Campus</td>
                                             <td style="width: 68px;"><a href="#personalDetails" data-toggle="modal" style="background-color:#E6E2EB; padding:10px 12px; margin-left: -8px; outline: none;"><i class="fa fa-edit">Edit</i></a></td>
                                        </tr>
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
                                <input type="text" class="form-control" id="firstName" placeholder="First Name" name="firstName" readonly>
                            </div>
                            <div class="form-group">
                                <label for="middleName">Middle Name</label>
                                <input type="text" class="form-control" id="middleName" placeholder="Middle Name" name="middleName" readonly>
                            </div>
                            <div class="form-group">
                                <label for="lastName">Last Name</label>
                                <input type="text" class="form-control" id="lastName" placeholder="Last Name" name="lastName" readonly>
                            </div>
                            <div class="form-group">
                                <label for="gender">Gender</label>
                                <input type="text" class="form-control" id="gender" placeholder="Gender" name="gender">
                            </div>
                            <div class="form-group">
                                <label for="dob">Date Of Birth</label>
                                <input type="text" class="form-control" id="dob" placeholder="Date of Birth" name="dob">
                            </div>
                            <div class="form-group">
                                <label for="country">Nationality</label>
                                <input type="text" class="form-control" id="country" placeholder="Nationality" name="country">
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
                                <input type="text" class="form-control" id="physicsGrade" placeholder="Physics Grade" name="physicsGrade">
                            </div>
                            <div class="form-group">
                                <label for="mathsGrade">Maths Grade</label>
                                <input type="text" class="form-control" id="mathsGrade" placeholder="Maths Grade" name="mathsGrade">
                            </div>
                            <div class="form-group">
                                <label for="subj3Grade">Group II/Group III Grade</label>
                                <input type="text" class="form-control" id="subj3Grade" placeholder="Subject3 Grade" name="subj3Grade">
                            </div>
                            <div class="form-group">
                                <label for="subj4Grade">Group II/Group III/Group IV/Group V Grade</label>
                                <input type="text" class="form-control" id="subj4Grade" placeholder="subject4 Grade" name="subj4Grade">
                            </div>
                            <div class="form-group">
                                <label for="meanGrade">Mean Grade</label>
                                <input type="text" class="form-control" id="meanGrade" placeholder="Mean Grade" name="meanGrade">
                            </div>
                            <div class="form-group">
                                <label for="aggregatePoints">Aggregate Points</label>
                                <input type="text" class="form-control" id="aggregatePoints" placeholder="Aggregate Points" name="aggregatePoints">
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
        
        <div class="modal fade" id="courseDetails" role="dialog">
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
                                <input type="text" class="form-control" id="programmeLevel" placeholder="Programme Level" name="programmeLevel">
                            </div>
                            <div class="form-group">
                                <label for="programmeName">Programme Name</label>
                                <input type="text" class="form-control" id="programmeNamee" placeholder="Programme Name" name="programmeName">
                            </div>
                            <div class="form-group">
                                <label for="modeOfStudy">Mode of Study</label>
                                <input type="text" class="form-control" id="modeOfStudy" placeholder="Mode of Study" name="modeOfStudy">
                            </div>
                            <div class="form-group">
                                <label for="campus">Campus/Study Center</label>
                                <input type="text" class="form-control" id="campus" placeholder="Campus/Study Center" name="campus">
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
