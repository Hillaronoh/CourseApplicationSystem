<%-- 
    Document   : ViewDegApplicants
    Created on : Jul 27, 2015, 2:23:07 PM
    Author     : hillary
--%>
<%@page import="java.sql.*" %>
<%@page import="myproject.*" %>
<%@page import="java.util.Calendar" %>
<%@page import="java.util.GregorianCalendar" %>
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
        
        <title> Degree Applicants </title>
        
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
            String months[] = {
                "January", "February", "March", "April",
                "May", "June", "July", "August",
                "September", "October", "November", "December"};
            GregorianCalendar gcalendar = new GregorianCalendar();
            String month=months[gcalendar.get(Calendar.MONTH)];
            int day=gcalendar.get(Calendar.DATE);
            int year=gcalendar.get(Calendar.YEAR);
            
            Admin admin=new Admin();
            String firstName=new String();
           
            ResultSet results=admin.getAdmin(adminId);
           
            if(results.next()){
                firstName=results.getString("First_Name");
            }
            
            if(request.getParameter("post")!=null){
                String title=request.getParameter("title");
                String body=request.getParameter("body");
                int results1=admin.setAnnouncement(title, body); 
                if(results1>0){%>
                <script type="text/javascript">
                    alert("Announcement posted successfully.");
                    window.location.href="ViewDegApplicants.jsp";
                </script>
                <%} else{%>
                <script type="text/javascript">
                    alert("Problem encountered! Try again.");
                    window.location.href="ViewDegApplicants.jsp";
                </script> 
                <%}
            }
            
            int degCsApplicantsCount=0;
            ResultSet degCsApplicants=admin.getDegCsApplicants(); 
            degCsApplicants.next(); 
            degCsApplicantsCount = degCsApplicants.getInt(1);
            
            int degItApplicantsCount=0;
            ResultSet degItApplicants=admin.getDegItApplicants(); 
            degItApplicants.next(); 
            degItApplicantsCount = degItApplicants.getInt(1);
            
            int degInfoApplicantsCount=0;
            ResultSet degInfoApplicants=admin.getDegInfoApplicants(); 
            degInfoApplicants.next(); 
            degInfoApplicantsCount = degInfoApplicants.getInt(1);
            
            int degCfApplicantsCount=0;
            ResultSet degCfApplicants=admin.getDegCfApplicants(); 
            degCfApplicants.next(); 
            degCfApplicantsCount = degCfApplicants.getInt(1);
            
            ResultSet rs=admin.displayCsDegApplicants();
            ResultSet rs2=admin.displayItDegApplicants();
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
                                <h3>menu</h3>
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
                                        <span><%= month%> <%= day%>, <%= year%></span></a>
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
                                <h3>Degree Applicants</h3>
                            </div>
                            
                        </div>
                        <div class="clearfix"></div>
                        <div class="row">
                            <div class="col-md-12 col-sm-12 col-xs-12">
                                <div class="x_panel">
                                    <div class="x_title">
                                        
                                        <!-- top tiles -->
                                        <div class="row tile_count">
                                            <div class="animated flipInY col-md-3 col-sm-4 col-xs-4 tile_stats_count">
                                                <div class="left"></div>
                                                <div class="right">
                                                    <span class="count_top"><i class="fa fa-users"></i> Computer Science</span>
                                                    <div class="count"><%=degCsApplicantsCount%></div>
                                                    <span class="count_bottom"><i class="green"><i class="fa fa-sort-asc"></i>3% </i> Male</span>
                                                    <span class="count_bottom"><i class="green"><i class="fa fa-sort-asc"></i>3% </i> Female</span>
                                                </div>
                                            </div>
                                            <div class="animated flipInY col-md-3 col-sm-4 col-xs-4 tile_stats_count">
                                                <div class="left"></div>
                                                <div class="right">
                                                    <span class="count_top"><i class="fa fa-users"></i> Information Technology</span>
                                                    <div class="count"><%=degItApplicantsCount%></div>
                                                    <span class="count_bottom"><i class="green"><i class="fa fa-sort-asc"></i>3% </i> Male</span>
                                                    <span class="count_bottom"><i class="green"><i class="fa fa-sort-asc"></i>3% </i> Female</span>
                                                </div>
                                            </div>
                                            <div class="animated flipInY col-md-3 col-sm-4 col-xs-4 tile_stats_count">
                                                <div class="left"></div>
                                                <div class="right">
                                                    <span class="count_top"><i class="fa fa-users"></i> Informatics </span>
                                                    <div class="count"><%=degInfoApplicantsCount%></div>
                                                    <span class="count_bottom"><i class="green"><i class="fa fa-sort-asc"></i>34% </i> Male</span>
                                                    <span class="count_bottom"><i class="green"><i class="fa fa-sort-asc"></i>34% </i> Female</span>
                                                </div>
                                            </div>
                                            <div class="animated flipInY col-md-3 col-sm-4 col-xs-4 tile_stats_count">
                                                <div class="left"></div>
                                                <div class="right">
                                                    <span class="count_top"><i class="fa fa-users"></i> Computer Forensics </span>
                                                    <div class="count"><%=degCfApplicantsCount%></div>
                                                    <span class="count_bottom"><i class="green"><i class="fa fa-sort-asc"></i>12% </i> Male</span>
                                                    <span class="count_bottom"><i class="green"><i class="fa fa-sort-asc"></i>12% </i> Female</span>
                                                </div>
                                            </div>
                                        </div>
                                        <!-- /top tiles -->
                                        
                                        
                                        <div class="clearfix"></div>
                                    </div>
                                    <div class="x_content">
                                        <br />
                                        
                                        <h4 class="green">Computer Science</h4>                                      
                                        <table class="table table-bordered">
                                            <thead>
                                                <tr>
                                                    <th>Email Address</th>
                                                    <th>First Name</th>
                                                    <th>Last Name</th>
                                                    <th>Cluster Points</th>
                                                    <th>Rank</th>
                                                    <th>Action</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <%while(rs.next()){%>
                                                <tr>
                                                    <td><%=rs.getString("Email_Address")%></td>
                                                    <td><%=rs.getString("First_Name")%></td>
                                                    <td><%=rs.getString("Last_Name")%></td>
                                                    <td><%=rs.getDouble("Cluster_Points")%></td>
                                                    <td><%=rs.getString("Rank")%></td>
                                                    <td style="width: 78px;"><a href="#deleteConfirm" data-toggle="modal" style="background-color:#EDEDED; padding-top: 13px; border: 1px solid #F7F7F7; padding-bottom: 12px; padding-left: 12px; padding-right: 10px; margin-left: -11px; outline: none;"><i class="fa fa-trash-o">Delete</i></a></td>
                                                </tr>
                                                <%}%>
                                            </tbody>
                                        </table>
                                        
                                        <h4 class="green">Information Technology</h4>                                      
                                        <table class="table table-bordered">
                                            <thead>
                                                <tr>
                                                    <th>Email Address</th>
                                                    <th>First Name</th>
                                                    <th>Last Name</th>
                                                    <th>Cluster Points</th>
                                                    <th>Rank</th>
                                                    <th>Action</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <%while(rs2.next()){%>
                                                <tr>
                                                    <td><%=rs2.getString("Email_Address")%></td>
                                                    <td><%=rs2.getString("First_Name")%></td>
                                                    <td><%=rs2.getString("Last_Name")%></td>
                                                    <td><%=rs2.getDouble("Cluster_Points")%></td>
                                                    <td><%=rs2.getString("Rank")%></td>
                                                    <td style="width: 78px;"><a href="#deleteConfirm" data-toggle="modal" style="background-color:#EDEDED; padding-top: 13px; border: 1px solid #F7F7F7; padding-bottom: 12px; padding-left: 12px; padding-right: 10px; margin-left: -11px; outline: none;"><i class="fa fa-trash-o">Delete</i></a></td>
                                                </tr>
                                                <%}%>
                                            </tbody>
                                        </table>
                                        
                                        <h4 class="green">Informatics</h4>                                      
                                        <table class="table table-bordered">
                                            <thead>
                                                <tr>
                                                    <th>Email Address</th>
                                                    <th>First Name</th>
                                                    <th>Last Name</th>
                                                    <th>Course Name</th>
                                                    <th>Course Level</th>
                                                    <th>Action</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td>ronokip55@gmail.com</td>
                                                    <td>Mark</td>
                                                    <td>Otto</td>
                                                    <td>Mark</td>
                                                    <td>Otto</td>
                                                    <td style="width: 78px;"><a href="#deleteConfirm" data-toggle="modal" style="background-color:#EDEDED; padding-top: 13px; border: 1px solid #F7F7F7; padding-bottom: 12px; padding-left: 12px; padding-right: 10px; margin-left: -11px; outline: none;"><i class="fa fa-trash-o">Delete</i></a></td>
                                                </tr>
                                            </tbody>
                                        </table>
                                        
                                        <h4 class="green">Computer Forensics</h4>                                      
                                        <table class="table table-bordered">
                                            <thead>
                                                <tr>
                                                    <th>Email Address</th>
                                                    <th>First Name</th>
                                                    <th>Last Name</th>
                                                    <th>Course Name</th>
                                                    <th>Course Level</th>
                                                    <th>Action</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td>ronokip55@gmail.com</td>
                                                    <td>Mark</td>
                                                    <td>Otto</td>
                                                    <td>Mark</td>
                                                    <td>Otto</td>
                                                    <td style="width: 78px;"><a href="#deleteConfirm" data-toggle="modal" style="background-color:#EDEDED; padding-top: 13px; border: 1px solid #F7F7F7; padding-bottom: 12px; padding-left: 12px; padding-right: 10px; margin-left: -11px; outline: none;"><i class="fa fa-trash-o">Delete</i></a></td>
                                                </tr>
                                            </tbody>
                                        </table>
                                        
                                    </div>
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
                                            <textarea name="body" placeholder="Announcement Body..." style="width: 468px; height: 100px;"></textarea>
                                
                                            <div class="well modal-footer">
                                                <button type="reset" class="btn btn-default">Clear</button>
                                                <button type="submit" class="btn btn-primary" name="post">Post</button>
                                            </div>
                                        </form>
                                    </div>
                        
                                </div><!-- /.modal-content -->
                            </div><!-- /.modal-dialog -->
                        </div><!-- /.modal -->
                    
        
        <div class="modal fade" id="deleteConfirm" role="dialog">
                            <div class="modal-dialog modal-sm">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                        <h4 class="modal-title" >Confirm</h4>
                                    </div>
                                    <div class="modal-body">
                                        <h5>Are you sure you want to delete?</h5>
                                        <form method="post" action="">
                                            <div class="">
                                                <button type="button" class="btn btn-info" data-dismiss="modal">Cancel</button>
                                                <button type="submit" name="delete" class="btn btn-danger">Delete</button> 
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
        
        <div id="custom_notifications" class="custom-notifications dsp_none">
            <ul class="list-unstyled notifications clearfix" data-tabbed_notifications="notif-group">
            </ul>
            <div class="clearfix"></div>
            <div id="notif-group" class="tabbed_notifications"></div>
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
        <script>
            autosize($('.resizable_textarea'));
        </script>
        <!-- Autocomplete -->
        <script type="text/javascript" src="js/autocomplete/countries.js"></script>
        <script src="js/autocomplete/jquery.autocomplete.js"></script>
        
        <script src="js/custom.js"></script>
        
    </body>
    
</html>
