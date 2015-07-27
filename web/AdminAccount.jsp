<%-- 
    Document   : AdminAccount
    Created on : Jul 23, 2015, 1:40:35 PM
    Author     : hillary
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Panel</title>
        <link rel="stylesheet" href="mycss/glyphicons/css/bootstrap.min.css">
        <link href="assets/plugins/bootstrap/bootstrap.css" rel="stylesheet" />
        <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
        <link href="assets/plugins/pace/pace-theme-big-counter.css" rel="stylesheet" />
        <link href="assets/css/style.css" rel="stylesheet" />
        <link href="assets/css/main-style.css" rel="stylesheet" />
        <link rel="stylesheet" style type="text/css" href="mycss/navMenus.css">
    </head>
    <body style="overflow-x: hidden; background-color: #EFEEEE;">
        <jsp:include page="Header.jsp"></jsp:include>
        
        <div class="container">
            
            <div class="row1" style="margin-left: -58px; margin-top: -20px;">
                
                <div class="col-md-4 col-md-offset-4" style="width: 1052px; padding-right: 0px; padding-left: 0px">
                    
                    <div class="login-panel panel panel-default"> 
                        
                        <div class="panel-heading">
                            <h3 class="panel-title">You are Logged in as Administrator</h3>
                        </div>
                        <div class="panel-body" style=" height: 400px; padding: 0px;">
                            
                            <div id="navMenu" style="margin-top: 1px;">
                                <ul>
                                    <li><a href="#"><button class="btn btn-info" style="width: 148px; height: 35px; padding-top: 0px; margin-top: -5px; background-color: #428BCA;"><i class="fa fa-home"></i>Home</button></a>
                                    </li>
                                </ul>
                                <ul>
                                    <li><a href="#"><button class="btn btn-info" style="width: 148px; height: 35px; padding-top: 0px; margin-top: -5px;"><i class="fa fa-arrow-down"></i>View Applicants</button></a>
                                        <ul>
                                            <li><a href="#">Degree Applicants</a></li>
                                            <li><a href="#">Diploma Applicants</a></li>
                                            <li><a href="#">Cert Applicants</a></li>
                                        </ul>
                                    </li>
                                </ul>
                                <ul>
                                    <li><a href="#"><button class="btn btn-info" style="width: 148px; height: 35px; padding-top: 0px; margin-top: -5px;"><i class="fa fa-bell"></i>Announcements</button></a>
                                        <ul>
                                            <li><a href="#">Post</a></li>
                                            <li><a href="#">Delete</a></li>
                                        </ul>
                                    </li>
                                </ul>
                                <ul>
                                    <li><a href="Details.jsp"><button class="btn btn-info" style="width: 148px; height: 35px; padding-top: 0px; margin-top: -5px;"><i class="fa fa-archive"></i>My Details</button></a>
                                    </li>
                                </ul>
                                <ul>
                                    <li><a href="Messaging.jsp"><button class="btn btn-info" style="width: 148px; height: 35px; padding-top: 0px; margin-top: -5px;"><i class="fa fa-inbox"></i>Inquiries</button></a>
                                        
                                    </li>
                                </ul>
                                <ul>
                                    <li><a href="#ApplicationStatus" data-toggle="modal"><button class="btn btn-info" style="width: 148px; height: 35px; padding-top: 0px; margin-top: -5px;"><i class="fa fa-star"></i>Application Status</button></a>
                                    </li>
                                </ul>
                                <ul>
                                    <li><a href="#"><button class="btn btn-info" style="width: 148px; height: 35px; padding-top: 0px; margin-top: -5px;"><i class="fa fa-user"></i>kip</button></a>
                                        <ul>
                                            <li><a href="ChangePwd.jsp"><i class="fa fa-dropbox"></i>Change Password</a></li>
                                            <li><a href="UserLogout.jsp"><i class="fa fa-sign-out"></i>Logout</a></li>
                                        </ul>
                                    </li>
                                </ul>
                                
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
        <script type="text/javascript" src="mycss/modal/jquery.minCust.js"></script>
        <script type="text/javascript" src="mycss/modal/bootstrapJsCust.js"></script>
    </body> 
</html> 

