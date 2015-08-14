<%-- 
    Document   : ChangePwd
    Created on : Jul 17, 2015, 1:42:12 PM
    Author     : Kipngetich
--%>
<%@page import="java.sql.*" %>
<%@page import="myproject.*" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Change Password</title>
        <link rel="stylesheet" href="mycss/glyphicons/css/bootstrap.min.css">
        <link rel="stylesheet" style type="text/css" href="mycss/navMenus.css">
        <!-- Core CSS - Include with every page -->
        <link href="assets/plugins/bootstrap/bootstrap.css" rel="stylesheet" />
        <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
        <link href="assets/plugins/pace/pace-theme-big-counter.css" rel="stylesheet" />
        <link href="assets/css/style.css" rel="stylesheet" />
        <link href="assets/css/main-style.css" rel="stylesheet" />
        <link rel="stylesheet" type="text/css" href="mycss/style2.css">
        <style type="text/css">
            .separator {
                border-right: 1px solid #dfdfe0; 
            }
            .icon-btn-save {
                padding-top: 0;
                padding-bottom: 0;
            }
            .input-group {
                margin-bottom:10px; 
            }
            .btn-save-label {
                position: relative;
                left: -12px;
                display: inline-block;
                padding: 6px 12px;
                background: rgba(0,0,0,0.15);
                border-radius: 3px 0 0 3px;
            }
            .error{
                color: red;
            }
        </style>
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
                                <li><a href="#"><button class="btn btn-info" style="width: 148px; height: 38px; padding-top: 0px; margin-top: -5px; background-color: #428BCA;"><i class="fa fa-user"></i><%=firstName%></button></a>
                                    <ul>
                                        <li><a href="#"><i class="fa fa-dropbox"></i>Change Password</a></li>
                                        <li><a href="UserLogout.jsp"><i class="fa fa-sign-out"></i>Logout</a></li>
                                    </ul>
                                </li>
                            </ul>
                            
                        </div>
                        <!--end navigation menus-->
                        
                        <div class="panel-body" style="padding-left:170px;">
                            <form action="" method="post" id="myForm4"> 
                                <div class="row">
                                    <div class="col-xs-12 col-sm-12 col-md-6 col-md-offset-2">
                                        <div class="panel panel-primary"  style="margin-top:20px;">
                                            <%
                                            String oldPwd=new String();
                                            String newPwd=new String();
                                            if(request.getParameter("save")!=null){
                                                oldPwd=request.getParameter("oldPwd"); 
                                                newPwd=request.getParameter("password1");
                                            
                                            int results2=user.changePwd(newPwd, applicantId, oldPwd);
                                            if(results2>0){%>
                                            <div class="panel-heading">
                                                <h3 class="panel-title alert alert-success" style="color: #5CB85C;">
                                                    <i class="fa fa-check-circle"></i>
                                                    Your password has been changed successfully  
                                                </h3>
                                            </div>
                                            <%} else{%>
                                            <div class="panel-heading">
                                                <h3 class="panel-title alert alert-danger" style="color: #e86b5a;">
                                                    <i class="fa fa-exclamation-triangle"></i>
                                                    An error occurred..Please try again.  
                                                </h3>
                                            </div>
                                            <%}} else{%>
                                            <div class="panel-heading">
                                                <h3 class="panel-title">
                                                    <i class="fa fa-th"></i>
                                                    Change password  
                                                </h3>
                                            </div>
                                            <%}%>
                                            <div class="panel-body">
                                                
                                                <div class="row">
                                                    <div style="margin-top:40px; padding-left: 50px;" class="col-xs-11 col-sm-11 col-md-11 ">
                                                        <div class="form-group">
                                                            <div class="input-group">
                                                                <div class="input-group-addon"><i class="fa fa-lock"></i></div>
                                                                <input class="form-control" type="password" placeholder="Current Password" name="oldPwd">
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <div class="input-group">
                                                                <div class="input-group-addon"><i class="fa fa-question-circle"></i></div>
                                                                <input class="form-control" type="password" placeholder="New Password" name="password1" id="password1">
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <div class="input-group">
                                                                <div class="input-group-addon"><i class="fa fa-check-circle"></i></div>
                                                                <input class="form-control" type="password" placeholder="Confirm New Password" name="password2" id="password2">
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                
                                            </div>
                                            <div class="panel-footer">
                                                <div class="row">
                                                    
                                                    <div class="col-xs-6 col-sm-6 col-md-6" style="padding-left: 70px;">
                                                        <button class="btn icon-btn-save btn-success" type="submit" name="save">
                                                            <span class="btn-save-label"><i class="fa fa-thumbs-o-up"></i></span>Save</button>
                                                    </div>
                                                    <div class="col-xs-6 col-sm-6 col-md-6"> <button class="btn icon-btn-save btn-success" type="reset">
                                                            <span class="btn-save-label"><i class="fa fa-repeat"></i></span>Reset</button></div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </form>
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
        <script type="text/javascript" src="mycss/validation/jquery.js"></script>
        <script type="text/javascript" src="mycss/validation/jquery.validate.js"></script>
        <script type="text/javascript" src="mycss/validation/additional-methods.js"></script>
        <script src="mycss/validation/custom.js"></script>
    </body>
</html>
