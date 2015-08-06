<%-- 
    Document   : Messaging
    Created on : Jul 8, 2015, 11:07:27 AM
    Author     : Kipngetich
--%>
<%@page import="java.sql.*" %>
<%Class.forName("com.mysql.jdbc.Driver");%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consultation</title>
        <link href="mycss/chatbox/bootstrap.css" rel="stylesheet" style type="text/css">
        <link href="mycss/chatbox/chatbox.css" rel="stylesheet" style type="text/css">
        <!-- Core CSS - Include with every page -->
        <link href="assets/plugins/bootstrap/bootstrap.css" rel="stylesheet" />
        <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
        <link href="assets/plugins/pace/pace-theme-big-counter.css" rel="stylesheet" />
        <link href="assets/css/style.css" rel="stylesheet" />
        <link href="assets/css/main-style.css" rel="stylesheet" />
        <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.css">
        <!--start navigation menus-->
        <link rel="stylesheet" href="mycss/glyphicons/css/bootstrap.min.css">
        <link rel="stylesheet" style type="text/css" href="mycss/navMenus.css">
        <!--end navigation menus-->
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
            String db="jdbc:mysql:///project1c";
            String username="root";
            String password="";
            
            public Applicant(){
                try{
                   conn=DriverManager.getConnection(db,username,password);
                   pst=conn.prepareStatement("SELECT First_Name FROM registration WHERE Email_Address=? AND Role_id=?");
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
        }
        %>
        
        <%
           Applicant user=new Applicant();
           String firstName=new String();
                      
           ResultSet results=user.getApplicant(applicantId); 
           
           if(results.next()){
               firstName=results.getString("First_Name");
           }
        %>
        
        <jsp:include page="Header.jsp"></jsp:include>
        <div class="container" style="margin-top:180px;">
            
            <div class="row1" style="margin-top: -180px;"> 
                
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
                                <li><a href="Messaging.jsp"><button class="btn btn-info" style="width: 148px; height: 38px; padding-top: 0px; margin-top: -5px; background-color: #428BCA;"><i class="fa fa-inbox"></i>Inquiries</button></a>
                                    
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
                        <div class="panel-body">
                            
                            <div class="row" style="margin-top: 15px;">
                                <div class="col-md-4 col-md-offset-4">
                                    <div class="portlet portlet-default">
                                        <div class="portlet-heading">
                                            <div class="portlet-title">
                                                <h4> Kipngetich Hillary </h4>
                                            </div>
                                            <div class="clearfix"></div>
                                        </div>
                                        <div id="chat" class="panel-collapse collapse in">
                                            <div>
                                                <div class="portlet-body" style="overflow-y: auto; width: auto; height: 200px;">
                                                    <div class="row">
                                                        <div class="col-lg-12">
                                                            <p class="text-center text-muted small"><%= (new java.util.Date()).toLocaleString()%></p> 
                                                        </div>
                                                    </div>
                                                    
                                                    <div class="row">
                                                        <div class="col-lg-12">
                                                            <div class="media">
                                                                <a class="pull-left" href="#">
                                                                    <img class="media-object img-circle" src="image/username2.png" alt="" style="width: 20px; height: 20px;">
                                                                </a>
                                                                <div class="media-body">
                                                                    <h4 class="media-heading">Kipngetich Hillary
                                                                        <span class="small pull-right">12:23 PM</span>
                                                                    </h4>
                                                                    <p>Hi, I wanted to make sure you got the latest product report. Did Roddy get it to you?</p>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <hr>
                                                    <div class="row">
                                                        <div class="col-lg-12">
                                                            <p class="text-center text-muted small">January 1, 2014 at 12:23 PM</p>
                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <div class="col-lg-12">
                                                            <div class="media">
                                                                <a class="pull-left" href="#">
                                                                    <img class="media-object img-circle" src="image/username2.png" alt="" style="width: 20px; height: 20px;">
                                                                </a>
                                                                <div class="media-body">
                                                                    <h4 class="media-heading">Kipngetich Hillary
                                                                        <span class="small pull-right">12:23 PM</span>
                                                                    </h4>
                                                                    <p>Hi, I wanted to make sure you got the latest product report. Did Roddy get it to you?</p>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <hr>
                                                    
                                                </div>
                                            </div>
                                            <div class="portlet-footer">
                                                <form role="form">
                                                    <div class="form-group">
                                                        <textarea class="form-control" placeholder="Enter message..."></textarea>
                                                    </div>
                                                    <div class="form-group">
                                                        <input type="submit" class="btn btn-default pull-right" value="Send">
                                                        <div class="clearfix"></div>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!-- /.col-md-4 -->
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
