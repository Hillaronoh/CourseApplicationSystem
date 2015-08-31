<%-- 
    Document   : index
    Created on : Jul 27, 2015, 1:56:21 PM
    Author     : hillary
--%>
<%@page import="java.sql.*" %>
<%@page import="java.util.Calendar" %>
<%@page import="java.util.GregorianCalendar" %>
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
        
        <title>Admin Panel</title>
        
        <!-- Bootstrap core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="fonts/css/font-awesome.min.css" rel="stylesheet">
        
        
        <!-- Custom styling plus plugins -->
        <link href="css/custom.css" rel="stylesheet">
        
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
                    window.location.href="AdminPanel.jsp";
                </script>
                <%} else{%>
                <script type="text/javascript">
                    alert("Problem encountered! Try again.");
                    window.location.href="AdminPanel.jsp";
                </script> 
                <%}
            }
            int totalApplicantsCount=0;
            ResultSet totalApplicants=admin.getTotalApplicants();
            totalApplicants.next();
            totalApplicantsCount = totalApplicants.getInt(1);
            
            int degreeApplicantsCount=0;
            ResultSet degreeApplicants=admin.getDegreeApplicants(); 
            degreeApplicants.next();
            degreeApplicantsCount = degreeApplicants.getInt(1);
            
            int diplomaApplicantsCount=0;
            ResultSet diplomaApplicants=admin.getDiplomaApplicants(); 
            diplomaApplicants.next(); 
            diplomaApplicantsCount = diplomaApplicants.getInt(1);
            
            int certApplicantsCount=0;
            ResultSet certApplicants=admin.getCertApplicants(); 
            certApplicants.next(); 
            certApplicantsCount = certApplicants.getInt(1);
            
            double degreePercentage=admin.calculatePercentage(totalApplicantsCount, degreeApplicantsCount);
            double diplomaPercentage=admin.calculatePercentage(totalApplicantsCount, diplomaApplicantsCount);
            double certPercentage=admin.calculatePercentage(totalApplicantsCount, certApplicantsCount);
           
            int maleCount=0;
            ResultSet totalMales=admin.displayTotalGender("Male");
            totalMales.next(); 
            maleCount = totalMales.getInt(1);
            int femaleCount=0;
            ResultSet totalFemales=admin.displayTotalGender("Female");
            totalFemales.next(); 
            femaleCount = totalFemales.getInt(1);
            
            int degMalesCount=0;
            ResultSet degMales=admin.displayGenderPerLevel("Male", 3);
            degMales.next(); 
            degMalesCount = degMales.getInt(1);
            int degFemalesCount=0;
            ResultSet degFemales=admin.displayGenderPerLevel("Female", 3);
            degFemales.next(); 
            degFemalesCount = degFemales.getInt(1);
            
            int dipMalesCount=0;
            ResultSet dipMales=admin.displayGenderPerLevel("Male", 4);
            dipMales.next(); 
            dipMalesCount = dipMales.getInt(1);
            int dipFemalesCount=0;
            ResultSet dipFemales=admin.displayGenderPerLevel("Female", 4);
            dipFemales.next(); 
            dipFemalesCount = dipFemales.getInt(1);
            
            int certMalesCount=0;
            ResultSet certMales=admin.displayGenderPerLevel("Male", 5);
            certMales.next(); 
            certMalesCount = certMales.getInt(1);
            int certFemalesCount=0;
            ResultSet certFemales=admin.displayGenderPerLevel("Female", 5);
            certFemales.next(); 
            certFemalesCount = certFemales.getInt(1);
            
            double degreeMalePercentage=admin.calculatePercentage(degreeApplicantsCount, degMalesCount);
            double diplomaMalePercentage=admin.calculatePercentage(diplomaApplicantsCount, dipMalesCount);
            double certMalePercentage=admin.calculatePercentage(certApplicantsCount, certMalesCount);
            
            double degreeFemalePercentage=admin.calculatePercentage(degreeApplicantsCount, degFemalesCount);
            double diplomaFemalePercentage=admin.calculatePercentage(diplomaApplicantsCount, dipFemalesCount);
            double certFemalePercentage=admin.calculatePercentage(certApplicantsCount, certFemalesCount);
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
                                <h3>Menu</h3>
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
                                    <a href="#" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                                        <img src="images/username2.png" alt="admin"><%=firstName%>
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
                    
                    <!-- top tiles -->
                    <div class="row tile_count">
                        <div class="animated flipInY col-md-3 col-sm-4 col-xs-4 tile_stats_count">
                            <div class="left"></div>
                            <div class="right">
                                <span class="count_top"><i class="fa fa-users"></i> Total Applicants</span>
                                <div class="count"><%=totalApplicantsCount%></div>
                                <span class="count_bottom"><i class="green"><i class="fa fa-sort-asc"></i><%=maleCount%> </i> Male</span> 
                                <span class="count_bottom"><i class="green"><i class="fa fa-sort-asc"></i><%=femaleCount%> </i> Female</span>
                            </div>
                        </div>
                        <div class="animated flipInY col-md-3 col-sm-4 col-xs-4 tile_stats_count">
                            <div class="left"></div>
                            <div class="right">
                                <span class="count_top"><i class="fa fa-users"></i> Degree Applicants</span>
                                <div class="count"><%=degreeApplicantsCount%></div>
                                <span class="count_bottom"><i class="green"><i class="fa fa-sort-asc"></i><%=degMalesCount%> </i> Male</span>
                                <span class="count_bottom"><i class="green"><i class="fa fa-sort-asc"></i><%=degFemalesCount%> </i> Female</span>
                            </div>
                        </div>
                        <div class="animated flipInY col-md-3 col-sm-4 col-xs-4 tile_stats_count">
                            <div class="left"></div>
                            <div class="right">
                                <span class="count_top"><i class="fa fa-users"></i> Diploma Applicants</span>
                                <div class="count"><%=diplomaApplicantsCount%></div>
                                <span class="count_bottom"><i class="green"><i class="fa fa-sort-asc"></i><%=dipMalesCount%> </i> Male</span>
                                <span class="count_bottom"><i class="green"><i class="fa fa-sort-asc"></i><%=dipFemalesCount%> </i> Female</span>
                            </div>
                        </div>
                        <div class="animated flipInY col-md-3 col-sm-4 col-xs-4 tile_stats_count">
                            <div class="left"></div>
                            <div class="right">
                                <span class="count_top"><i class="fa fa-users"></i> Certificate Applicants</span>
                                <div class="count"><%=certApplicantsCount%></div>
                                <span class="count_bottom"><i class="green"><i class="fa fa-sort-asc"></i><%=certMalesCount%> </i> Male</span>
                                <span class="count_bottom"><i class="green"><i class="fa fa-sort-asc"></i><%=certFemalesCount%> </i> Female</span>
                            </div>
                        </div>
                    </div>
                    <!-- /top tiles -->
                    
                    <div class="row">
                        <div class="col-md-12 col-sm-12 col-xs-12">
                            <div class="dashboard_graph"  style="min-height: 500px;">
                                
                                <div class="row x_title">
                                    <div class="col-md-6">
                                        <h3>Welcome, you are logged in as <small>Admin</small></h3>
                                    </div>
                                    
                                </div>
                                
                               <div class="col-md-5 col-sm-5 col-xs-5">
                        <div class="x_panel tile">
                            <div class="x_title">
                                <h2>Applicants</h2>
                               
                                <div class="clearfix"></div>
                            </div>
                            <div class="x_content">
                                <h4>Applicants percentage across levels</h4>
                                <div class="widget_summary">
                                    <div class="w_left w_25">
                                        <span>Degree</span>
                                    </div>
                                    <div class="w_center w_55">
                                        <div class="progress">
                                            <div class="progress-bar bg-green" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: <%=degreePercentage%>%;">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="w_right w_20">
                                        <span style="padding:10%;"><%=degreePercentage%>%</span>
                                    </div>
                                    <div class="clearfix"></div>
                                </div>

                                <div class="widget_summary">
                                    <div class="w_left w_25">
                                        <span>Diploma</span>
                                    </div>
                                    <div class="w_center w_55">
                                        <div class="progress">
                                            <div class="progress-bar bg-green" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: <%=diplomaPercentage%>%;">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="w_right w_20">
                                        <span style="padding:10%;"><%=diplomaPercentage%>%</span>
                                    </div>
                                    <div class="clearfix"></div>
                                </div>
                              
                                <div class="widget_summary">
                                    <div class="w_left w_25">
                                        <span>Certificate</span>
                                    </div>
                                    <div class="w_center w_55">
                                        <div class="progress">
                                            <div class="progress-bar bg-green" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: <%=certPercentage%>%;">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="w_right w_20">
                                        <span style="padding:10%;"><%=certPercentage%>%</span>
                                    </div>
                                    <div class="clearfix"></div>
                                </div>

                            </div>
                        </div>
                    </div>
                      <div class="col-md-1 col-sm-1 col-xs-1"></div>
                       <div class="col-md-5 col-sm-5 col-xs-5">
                        <div class="x_panel tile">
                            <div class="x_title">
                                <h2>Gender</h2>
                               
                                <div class="clearfix"></div>
                            </div>
                            <div class="x_content">
                                <h4>Degree </h4>
                                <div class="widget_summary">
                                    <div class="w_left w_25">
                                        <span>Male</span>
                                    </div>
                                    <div class="w_center w_55">
                                        <div class="progress">
                                            <div class="progress-bar bg-green" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: <%=degreeMalePercentage%>%;">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="w_right w_20">
                                        <span style="padding:10%;"><%=degreeMalePercentage%>%</span>
                                    </div>
                                    <div class="clearfix"></div>
                                </div>
                              
                                <div class="widget_summary">
                                    <div class="w_left w_25">
                                        <span>Female</span>
                                    </div>
                                    <div class="w_center w_55">
                                        <div class="progress">
                                            <div class="progress-bar bg-green" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: <%=degreeFemalePercentage%>%;">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="w_right w_20">
                                        <span style="padding:10%;"><%=degreeFemalePercentage%>%</span>
                                    </div>
                                    <div class="clearfix"></div>
                                </div>
                                    
                                    <h4>Diploma </h4>
                                <div class="widget_summary">
                                    <div class="w_left w_25">
                                        <span>Male</span>
                                    </div>
                                    <div class="w_center w_55">
                                        <div class="progress">
                                            <div class="progress-bar bg-green" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: <%=diplomaMalePercentage%>%;">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="w_right w_20">
                                        <span style="padding:10%;"><%=diplomaMalePercentage%>%</span>
                                    </div>
                                    <div class="clearfix"></div>
                                </div>
                              
                                <div class="widget_summary">
                                    <div class="w_left w_25">
                                        <span>Female</span>
                                    </div>
                                    <div class="w_center w_55">
                                        <div class="progress">
                                            <div class="progress-bar bg-green" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: <%=diplomaFemalePercentage%>%;">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="w_right w_20">
                                        <span style="padding:10%;"><%=diplomaFemalePercentage%>%</span>
                                    </div>
                                    <div class="clearfix"></div>
                                </div>
                                    
                                    <h4>Certificate </h4>
                                <div class="widget_summary">
                                    <div class="w_left w_25">
                                        <span>Male</span>
                                    </div>
                                    <div class="w_center w_55">
                                        <div class="progress">
                                            <div class="progress-bar bg-green" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: <%=certMalePercentage%>%;">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="w_right w_20">
                                        <span style="padding:10%;"><%=certMalePercentage%>%</span>
                                    </div>
                                    <div class="clearfix"></div>
                                </div>
                              
                                <div class="widget_summary">
                                    <div class="w_left w_25">
                                        <span>Female</span>
                                    </div>
                                    <div class="w_center w_55">
                                        <div class="progress">
                                            <div class="progress-bar bg-green" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: <%=certFemalePercentage%>%;">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="w_right w_20">
                                        <span style="padding:10%;"><%=certFemalePercentage%>%</span>
                                    </div>
                                    <div class="clearfix"></div>
                                </div>

                            </div>
                        </div>
                    </div>
                            </div>
                        </div>
                        
                    </div>
                    <br />            
                </div>
                <!-- /page content -->
                
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
       
            </div>
        </div>
        
        
        
        <script src="js/bootstrap.min.js"></script>
       
        <!-- bootstrap progress js -->
        <script src="js/nicescroll/jquery.nicescroll.min.js"></script>
        
        <script src="js/custom.js"></script>
        
        <!-- /footer content -->
    </body>
    
</html>

