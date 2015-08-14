<%-- 
    Document   : UnrepliedInquiries
    Created on : Jul 27, 2015, 2:04:35 PM
    Author     : hillary
--%>
<%@page import="java.sql.*" %>
<%@page import="myproject.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Meta, title, CSS, favicons, etc. -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="shortcut icon" href="images/favicon.ico">
        
        <title> Inquiries | Unreplied </title>
        
        <!-- Bootstrap core CSS -->
        
        <link href="css/bootstrap.min.css" rel="stylesheet">
        
        <link href="fonts/css/font-awesome.min.css" rel="stylesheet">
        <link href="css/animate.min.css" rel="stylesheet">
        
        <!-- Custom styling plus plugins -->
        <link href="css/custom.css" rel="stylesheet">
        <link href="css/icheck/flat/green.css" rel="stylesheet">
        <!-- editor -->
        <link href="http://netdna.bootstrapcdn.com/font-awesome/3.0.2/css/font-awesome.css" rel="stylesheet">
        <link href="css/editor/external/google-code-prettify/prettify.css" rel="stylesheet">
        <link href="css/editor/index.css" rel="stylesheet">
        <!-- select2 -->
        <link href="css/select/select2.min.css" rel="stylesheet">
        <!-- switchery -->
        <link rel="stylesheet" href="css/switchery/switchery.min.css" />
        
        <script src="js/jquery.min.js"></script>
        
    </head>
    
    
    <body class="nav-md">
        
        <%
           response.setHeader("Cache-Control","no-cache"); //Forces caches to obtain a new copy of the page from the origin server
           response.setHeader("Cache-Control","no-store"); //Directs caches not to store the page under any circumstance
           response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
           response.setHeader("Pragma","no-cache"); //HTTP 1.0 backward compatibility
            String adminId=new String(); 
            if(session.getAttribute("adminId")==null||(session.getAttribute("adminId")==""))
            {
                
                response.sendRedirect("../Login.jsp"); 

            }
            else
            { 
                adminId=(String)session.getAttribute("adminId");          
            }
       
            %>
           
        <%
           Admin admin=new Admin();
           String firstName=new String();
           
           ResultSet results=admin.getAdmin(adminId);
           
           if(results.next()){
               firstName=results.getString("First_Name");
           }
           
           ResultSet results1=admin.getUnrepliedInquiries();
        %>
        
        <div class="container body">
            
            
            <div class="main_container">
                
                <div class="col-md-3 left_col">
                    <div class="left_col scroll-view">
                        
                        <div class="navbar nav_title" style="border: 0;">
                            <a href="AdminPanel.jsp" class="site_title"><i class="fa fa-user-md"></i> <span>Admin</span></a>
                        </div>
                        <div class="clearfix"></div>
                        
                        <br />
                        
                        <!-- sidebar menu -->
                        <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
                            
                            <div class="menu_section">
                                <h3>General</h3>
                                <ul class="nav side-menu">
                                    <li><a><i class="fa fa-home"></i> Home <span class="fa fa-chevron-down"></span></a>
                                        <ul class="nav child_menu" style="display: none">
                                            <li><a href="AdminPanel.jsp">Dashboard</a>
                                            </li>
                                        </ul>
                                    </li>
                                    <li><a><i class="fa fa-desktop"></i> View Applicants <span class="fa fa-chevron-down"></span></a>
                                        <ul class="nav child_menu" style="display: none">
                                            <li><a href="ViewDegApplicants.jsp">Degree Applicants</a>
                                            </li>
                                            <li><a href="ViewDipApplicants.jsp">Diploma Applicants</a>
                                            </li>
                                            <li><a href="ViewCertApplicants.jsp">Certificate Applicants</a>
                                            </li>
                                        </ul>
                                    </li>
                                    <li><a><i class="fa fa-bell-o"></i> Announcements <span class="fa fa-chevron-down"></span></a>
                                        <ul class="nav child_menu" style="display: none">
                                            <li><a href="#postAnnouncement" data-toggle="modal">Post</a>
                                            </li>
                                            <li><a href="DeleteAnn.jsp">Delete</a>
                                            </li>
                                        </ul>
                                    </li>
                                    <li><a><i class="fa fa-table"></i> Rank Applicants <span class="fa fa-chevron-down"></span></a>
                                        <ul class="nav child_menu" style="display: none">
                                            <li><a href="RankDegApp.jsp">Degree Apllicants</a>
                                            </li>
                                            <li><a href="RankDipApp.jsp">Diploma Applicants</a>
                                            </li>
                                            <li><a href="RankCertApp.jsp">Certificate Applicants</a>
                                            </li>
                                        </ul>
                                    </li>
                                    <li><a><i class="fa fa-inbox"></i> Inquiries <span class="fa fa-chevron-down"></span></a>
                                        <ul class="nav child_menu" style="display: none">
                                            <li><a href="UnrepliedInquiries.jsp">Unreplied</a>
                                            </li>
                                            <li><a href="RepliedInquiries.jsp">Replied</a>
                                            </li>
                                        </ul>
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <!-- /sidebar menu -->
                        
                    </div>
                </div>
                
                <!-- top navigation -->
                <div class="top_nav">
                    
                    <div class="nav_menu">
                        <nav class="" role="navigation">
                            <div class="nav toggle">
                                <a id="menu_toggle"><i class="fa fa-bars"></i></a>
                            </div>
                            
                            <ul class="nav navbar-nav navbar-right">
                                <li class="">
                                    <a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                                        <img src="images/username2.png" alt=""><%=firstName%> 
                                        <span class=" fa fa-angle-down"></span>
                                    </a>
                                    <ul class="dropdown-menu dropdown-usermenu animated fadeInDown pull-right">
                                        
                                        <li>
                                            <a href="#">Change Password</a>
                                        </li>
                                        <li><a href="../Applicants/UserLogout.jsp"><i class="fa fa-sign-out pull-right"></i> Log Out</a>
                                        </li>
                                    </ul>
                                </li>
                                
                                <li role="presentation" class="dropdown">
                                    <a href="javascript:;" class="dropdown-toggle info-number" data-toggle="dropdown" aria-expanded="false">
                                        <i class="fa fa-globe"></i>
                                        <span class="badge bg-green">6</span>
                                    </a>
                                    <ul id="menu1" class="dropdown-menu list-unstyled msg_list animated fadeInDown" role="menu">
                                        <li>
                                            <a>
                                                <span class="image">
                                                    <img src="images/img.jpg" alt="Profile Image" />
                                                </span>
                                                <span>
                                                    <span>John Smith</span>
                                                    <span class="time">3 mins ago</span>
                                                </span>
                                                <span class="message">
                                                    Film festivals used to be do-or-die moments for movie makers. They were where... 
                                                </span>
                                            </a>
                                        </li>
                                        <li>
                                            <a>
                                                <span class="image">
                                                    <img src="images/img.jpg" alt="Profile Image" />
                                                </span>
                                                <span>
                                                    <span>John Smith</span>
                                                    <span class="time">3 mins ago</span>
                                                </span>
                                                <span class="message">
                                                    Film festivals used to be do-or-die moments for movie makers. They were where... 
                                                </span>
                                            </a>
                                        </li>
                                        <li>
                                            <a>
                                                <span class="image">
                                                    <img src="images/img.jpg" alt="Profile Image" />
                                                </span>
                                                <span>
                                                    <span>John Smith</span>
                                                    <span class="time">3 mins ago</span>
                                                </span>
                                                <span class="message">
                                                    Film festivals used to be do-or-die moments for movie makers. They were where... 
                                                </span>
                                            </a>
                                        </li>
                                        <li>
                                            <a>
                                                <span class="image">
                                                    <img src="images/img.jpg" alt="Profile Image" />
                                                </span>
                                                <span>
                                                    <span>John Smith</span>
                                                    <span class="time">3 mins ago</span>
                                                </span>
                                                <span class="message">
                                                    Film festivals used to be do-or-die moments for movie makers. They were where... 
                                                </span>
                                            </a>
                                        </li>
                                        <li>
                                            <div class="text-center">
                                                <a>
                                                    <strong>See All Alerts</strong>
                                                    <i class="fa fa-angle-right"></i>
                                                </a>
                                            </div>
                                        </li>
                                    </ul>
                                </li>
                                <li>
                                    <a href="#"><i class="glyphicon glyphicon-calendar fa fa-calendar"></i>
                                        <span>December 30, 2014</span></a>
                                </li>
                            </ul>
                        </nav>
                    </div>
                    
                </div>
                <!-- /top navigation -->
                
                <!-- page content -->
                <div class="right_col" role="main">
                    <div class="">
                        
                        <div class="page-title">
                            <div class="title_left">
                                <h3>Inquiries</h3>
                            </div>
                            
                        </div>
                        <div class="clearfix"></div>
                        <div class="row">
                            <div class="col-md-12 col-sm-12 col-xs-12">
                                <div class="x_panel">
                                    <div class="x_title">
                                        
                                        <h4>Unreplied</h4>
                                        
                                        <div class="clearfix"></div>
                                    </div>
                                    <div class="x_content">
                                        <br />
                                        
                                        
                                        <table class="table table-bordered">
                                            <thead>
                                                <tr>
                                                    <th>Id</th>
                                                    <th>Sender</th>
                                                    <th>Message</th>
                                                    <th>Date Sent</th>
                                                    <th>Action</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <%
                                                int check=1;
                                                String email=new String();
                                                String fname=new String();
                                                String lname=new String();
                                                String message=new String();
                                                String rep=new String();
                                                String rep1=new String();
                                                while(results1.next()){
                                                email=results1.getString("Sender");
                                                //message=results1.getString("Message");
                                                rep1=results1.getString("Reply");
                                                ResultSet results2=admin.getSender(email);
                                                if(results2.next()){
                                                    fname=results2.getString("First_Name");
                                                    lname=results2.getString("Last_Name");
                                                }
                                                ResultSet results4=admin.getChats(email);
                                                
                                                if(rep1==null){
                                                %>
                                                <tr>
                                                    <th scope="row"><%=results1.getInt("id")%></th>
                                                    <td><%=results1.getString("Sender")%></td>
                                                    <td><%=results1.getString("Message")%></td>
                                                    <td><%=results1.getDate("Sent_Date")%></td>
                                                    <td style="width: 154px; padding-right: 0px;">
                                                        <a href="#reply<%=check%>" data-toggle="modal" style="background-color:#EDEDED; padding-top: 13px; border: 1px solid #F7F7F7; padding-bottom: 12px; padding-left: 12px; padding-right: 10px; margin-left: -11px; outline: none;">
                                                            <i class="fa fa-reply">Reply</i></a>
                                                        <a href="#ignoreConfirm<%=check%>" data-toggle="modal" style="background-color:#EDEDED; padding-top: 13px; border: 1px solid #F7F7F7; padding-bottom: 12px; padding-left: 12px; padding-right: 10px; margin-left: -3px; outline: none;">
                                                            <i class="fa fa-exclamation-circle">Ignore</i></a>
                                                    </td>
                                                </tr>
                                                <%}%>
                                            <div class="modal fade" id="reply<%=check%>" role="dialog">
                                                <div class="modal-dialog modal-sm">
                                                    <div class="modal-content">
                                                        <div class="modal-header">
                                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                                            <h4 class="modal-title" >Inquiry</h4>
                                                        </div>
                                                        <div class="modal-body">
                                                            
                                                            <div class="portlet portlet-default" style="border: 1px solid; ">
                                                                
                                                                <div id="chat" class="panel-collapse collapse in">
                                                                    <div>
                                                                        <div class="portlet-body" style="overflow-y: auto; overflow-x: hidden; height: 180px; padding-right: 3px;">
                                                                            <div class="row">
                                                                                <div class="col-lg-12">
                                                                                    <p class="text-center text-muted small"><%= (new java.util.Date()).toLocaleString()%></p> 
                                                                                </div>
                                                                            </div>
                                                                                    <%while(results4.next()){
                                                                                        message=results4.getString("Message"); 
                                                                                        rep=results4.getString("Reply");%>
                                                
                                                                                        <div class="row">
                                                                                            <div class="col-lg-12">
                                                                                                <div class="media">
                                                                                                    <a class="pull-left" href="#">
                                                                                                        <i class="fa fa-user"></i>
                                                                                                    </a>
                                                                                                    <div class="media-body">
                                                                                                        <h4 class="media-heading"><%=fname%> <%=lname%>
                                                                                                            <span class="small pull-right">12:23 PM</span>
                                                                                                        </h4>
                                                                                                        <p><%=message%></p>
                                                                                                    </div>
                                                                                                </div>
                                                                                            </div>
                                                                                        </div>
                                                                                        <hr>
                                                                                        <%if(rep!=null){%>
                                                                                        <div class="row">
                                                                                            <div class="col-lg-12">
                                                                                                <div class="media">
                                                                                                    <a class="pull-left" href="#">
                                                                                                        <img class="media-object img-circle" src="images/favicon.ico" alt="" style="width: 15px; height: 15px;">
                                                                                                    </a>
                                                                                                    <div class="media-body">
                                                                                                        <h4 class="media-heading">mmust
                                                                                                            <span class="small pull-right">12:23 PM</span>
                                                                                                        </h4>
                                                                                                        <p><%=rep%></p>
                                                                                                    </div>
                                                                                                </div>
                                                                                            </div>
                                                                                        </div>
                                                                                                        <hr><%}}%>
                                                                        </div>
                                                                    </div>
                                                                    <div class="well portlet-footer">
                                                                        <form role="form" method="post">
                                                                            <div class="form-group">
                                                                                <textarea class="form-control" name="reply" placeholder="Enter reply..."></textarea>
                                                                            </div>
                                                                            <div class="form-group">
                                                                                <input type="submit" class="btn btn-success pull-right" value="Send" name="send<%=check%>">
                                                                                <div class="clearfix"></div>
                                                                            </div>
                                                                        </form>
                                                                    </div>
                                                                </div>
                                                
                                                            </div>
                                            
                                                        </div><!-- /.modal-content -->
                                                    </div><!-- /.modal-dialog -->
                                                </div><!-- /.modal -->
                                            </div>
                                            
                                            <div class="modal fade" id="ignoreConfirm<%=check%>" role="dialog">
                                                <div class="modal-dialog modal-sm">
                                                    <div class="modal-content">
                                                        <div class="modal-header">
                                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                                            <h4 class="modal-title" >Confirm</h4>
                                                        </div>
                                                        <div class="modal-body">
                                                            <h5>Are you sure you want to ignore?</h5>
                                                            <form method="post" action="">
                                                                <div class="">
                                                                    <button type="button" class="btn btn-info" data-dismiss="modal">Cancel</button>
                                                                    <button type="submit" name="ignore<%=check%>" class="btn btn-danger">Ignore</button> 
                                                                </div>
                                                            </form>
                                                        </div>
                                    
                                                    </div><!-- /.modal-content -->
                                                </div><!-- /.modal-dialog -->
                                            </div><!-- /.modal -->
                                                <%
                                                if(request.getParameter("send"+check)!=null){
                                                    String reply=request.getParameter("reply");
                                                    int results3=admin.setReply(reply, email, message);
                                                }
                                                if(request.getParameter("ignore"+check)!=null){
                                                    String reply="Ignored";
                                                    int results3=admin.setIgnore(reply, email, message);
                                                }
                                                check++;
                                               }%>
                                                
                                            </tbody>
                                        </table>
                                        
                                        
                                    </div>
                                </div>
                            </div>
                        </div>
                        
                        <div class="modal fade" id="postAnnouncement" role="dialog">
                            <div class="modal-dialog" style="width: 500px;">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                        <h4 class="modal-title" >Post Announcement</h4>
                                    </div>
                                    <div class="modal-body">
                                        
                                        <form method="post" action="">
                                            <input type="text" name="title" placeholder="Announcement Title..." size="56">
                                            <textarea placeholder="Announcement Body..." style="width: 468px; height: 100px;"></textarea>
                                            
                                            <div class="well modal-footer">
                                                <button type="reset" class="btn btn-default">Clear</button>
                                                <button type="submit" class="btn btn-primary" name="save">Post</button>
                                            </div>
                                        </form>
                                    </div>
                                    
                                </div><!-- /.modal-content -->
                            </div><!-- /.modal-dialog -->
                        </div><!-- /.modal -->
                                                      
                        </div>
                        <!-- /page content -->
                        
                    </div>
                    
                   
                    
                </div>
            </div>
            
            
            <script src="js/bootstrap.min.js"></script>
            
            <!-- chart js -->
            <script src="js/chartjs/chart.min.js"></script>
            <!-- bootstrap progress js -->
            <script src="js/progressbar/bootstrap-progressbar.min.js"></script>
            <script src="js/nicescroll/jquery.nicescroll.min.js"></script>
            <!-- icheck -->
            <script src="js/icheck/icheck.min.js"></script>
            <!-- tags -->
            <script src="js/tags/jquery.tagsinput.min.js"></script>
            <!-- switchery -->
            <script src="js/switchery/switchery.min.js"></script>
            <!-- daterangepicker -->
            <script type="text/javascript" src="js/moment.min2.js"></script>
            <script type="text/javascript" src="js/datepicker/daterangepicker.js"></script>
            <!-- richtext editor -->
            <script src="js/editor/bootstrap-wysiwyg.js"></script>
            <script src="js/editor/external/jquery.hotkeys.js"></script>
            <script src="js/editor/external/google-code-prettify/prettify.js"></script>
            <!-- select2 -->
            <script src="js/select/select2.full.js"></script>
            <!-- form validation -->
            <script type="text/javascript" src="js/parsley/parsley.min.js"></script>
            <!-- textarea resize -->
            <script src="js/textarea/autosize.min.js"></script>
            <!-- Autocomplete -->
            <script type="text/javascript" src="js/autocomplete/countries.js"></script>
            <script src="js/autocomplete/jquery.autocomplete.js"></script>
            
            <script src="js/custom.js"></script>
            
            
    </body>
    
</html>
