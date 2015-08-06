<%-- 
    Document   : DeleteAnn
    Created on : Jul 27, 2015, 3:16:46 PM
    Author     : hillary
--%>
<%@page import="java.sql.*" %>
<%Class.forName("com.mysql.jdbc.Driver");%> 
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
        
        <title> Delete Announcements </title>
        
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
                
                <%!
        public class Admin{
            Connection conn=null;
            PreparedStatement pst=null;
            String db="jdbc:mysql:///project1c";
            String username="root";
            String password="";
            
            public Admin(){
                try{
                   conn=DriverManager.getConnection(db,username,password);
                   pst=conn.prepareStatement("SELECT First_Name FROM registration WHERE Email_Address=? AND Role_id=?");
                }
                catch(SQLException e){
                    e.printStackTrace();
                }
            }
            
            public ResultSet getAdmin(String email){
                ResultSet rs=null;
                try{
                  pst.setString(1, email);
                  pst.setInt(2, 1);
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
           Admin admin=new Admin();
           String firstName=new String();
           
           ResultSet results=admin.getAdmin(adminId);
           
           if(results.next()){
               firstName=results.getString("First_Name");
           }
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
                                <h3>Announcements</h3>
                            </div>
                            
                        </div>
                        <div class="clearfix"></div>
                        <div class="row">
                            <div class="col-md-12 col-sm-12 col-xs-12">
                                <div class="x_panel">
                                    <div class="x_title">
                                        
                                        <h4>Delete</h4>
                                        <div class="clearfix"></div>
                                    </div>
                                    <div class="x_content">
                                        <br />
                                        
                                        <table class="table table-bordered">
                                            <thead>
                                                <tr>
                                                    <th>Id</th>
                                                    <th>Announcement</th>
                                                    <th>Post_Date</th>
                                                    <th>Action</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <th scope="row">1</th>
                                                    <td>Mark</td>
                                                    <td>Otto</td>
                                                    <td style="width: 78px;"><a href="#deleteConfirm" data-toggle="modal" style="background-color:#EDEDED; padding-top: 13px; border: 1px solid #F7F7F7; padding-bottom: 12px; padding-left: 12px; padding-right: 10px; margin-left: -11px; outline: none;"><i class="fa fa-trash-o">Delete</i></a></td>
                                                </tr>
                                                <tr>
                                                    <th scope="row">2</th>
                                                    <td>Jacob</td>
                                                    <td>Thornton</td>
                                                    <td style="width: 78px;"><a href="#deleteConfirm" data-toggle="modal" style="background-color:#EDEDED; padding-top: 13px; border: 1px solid #F7F7F7; padding-bottom: 12px; padding-left: 12px; padding-right: 10px; margin-left: -11px; outline: none;"><i class="fa fa-trash-o">Delete</i></a></td>
                                                </tr>
                                                <tr>
                                                    <th scope="row">3</th>
                                                    <td>Larry</td>
                                                    <td>the Bird</td>
                                                    <td style="width: 78px;"><a href="#deleteConfirm" data-toggle="modal" style="background-color:#EDEDED; padding-top: 13px; border: 1px solid #F7F7F7; padding-bottom: 12px; padding-left: 12px; padding-right: 10px; margin-left: -11px; outline: none;"><i class="fa fa-trash-o">Delete</i></a></td>
                                                </tr>
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
            
        <!-- Autocomplete -->
        <script type="text/javascript" src="js/autocomplete/countries.js"></script>
        <script src="js/autocomplete/jquery.autocomplete.js"></script>
            
        <script src="js/custom.js"></script>
            
    </body>
    
</html>