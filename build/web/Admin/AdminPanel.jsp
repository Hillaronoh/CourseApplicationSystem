<%-- 
    Document   : index
    Created on : Jul 27, 2015, 1:56:21 PM
    Author     : hillary
--%>

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
                                        <img src="images/username2.png" alt="admin">Hilllary
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
                                                    <strong><a href="inbox.html">See All Alerts</strong>
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
                    
                    <!-- top tiles -->
                    <div class="row tile_count">
                        <div class="animated flipInY col-md-3 col-sm-4 col-xs-4 tile_stats_count">
                            <div class="left"></div>
                            <div class="right">
                                <span class="count_top"><i class="fa fa-users"></i> Total Applicants</span>
                                <div class="count">2500</div>
                                <span class="count_bottom"><i class="green"><i class="fa fa-sort-asc"></i>3% </i> Male</span>
                                <span class="count_bottom"><i class="green"><i class="fa fa-sort-asc"></i>3% </i> Female</span>
                            </div>
                        </div>
                        <div class="animated flipInY col-md-3 col-sm-4 col-xs-4 tile_stats_count">
                            <div class="left"></div>
                            <div class="right">
                                <span class="count_top"><i class="fa fa-users"></i> Degree Applicants</span>
                                <div class="count">123.50</div>
                                <span class="count_bottom"><i class="green"><i class="fa fa-sort-asc"></i>3% </i> Male</span>
                                <span class="count_bottom"><i class="green"><i class="fa fa-sort-asc"></i>3% </i> Female</span>
                            </div>
                        </div>
                        <div class="animated flipInY col-md-3 col-sm-4 col-xs-4 tile_stats_count">
                            <div class="left"></div>
                            <div class="right">
                                <span class="count_top"><i class="fa fa-users"></i> Diploma Applicants</span>
                                <div class="count green">2,500</div>
                                <span class="count_bottom"><i class="green"><i class="fa fa-sort-asc"></i>34% </i> Male</span>
                                <span class="count_bottom"><i class="green"><i class="fa fa-sort-asc"></i>34% </i> Female</span>
                            </div>
                        </div>
                        <div class="animated flipInY col-md-3 col-sm-4 col-xs-4 tile_stats_count">
                            <div class="left"></div>
                            <div class="right">
                                <span class="count_top"><i class="fa fa-users"></i> Certificate Applicants</span>
                                <div class="count">4,567</div>
                                <span class="count_bottom"><i class="green"><i class="fa fa-sort-asc"></i>12% </i> Male</span>
                                <span class="count_bottom"><i class="green"><i class="fa fa-sort-asc"></i>12% </i> Female</span>
                            </div>
                        </div>
                    </div>
                    <!-- /top tiles -->
                    
                    <div class="row">
                        <div class="col-md-12 col-sm-12 col-xs-12">
                            <div class="dashboard_graph"  style="height: 400px;">
                                
                                <div class="row x_title">
                                    <div class="col-md-6">
                                        <h3>Welcome, you are logged in as <small>Admin</small></h3>
                                    </div>
                                    
                                </div>
                                
                                
                                <div class="clearfix"></div>
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
                            <textarea placeholder="New Announcement..." style="width: 468px; height: 100px;"></textarea>
                            
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
        </div>
        
        
        
        <script src="js/bootstrap.min.js"></script>
       
        <!-- bootstrap progress js -->
        <script src="js/nicescroll/jquery.nicescroll.min.js"></script>
        
        <script src="js/custom.js"></script>
        
        <!-- /footer content -->
    </body>
    
</html>

