<%-- 
    Document   : DeleteAnn
    Created on : Jul 27, 2015, 3:16:46 PM
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
           response.setHeader("Cache-Control","no-cache"); //Forces caches to obtain a new copy of the page from the origin server
           response.setHeader("Cache-Control","no-store"); //Directs caches not to store the page under any circumstance
           response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
           response.setHeader("Pragma","no-cache"); //HTTP 1.0 backward compatibility
     
           String adminId=new String(); 
           if(session.getAttribute("adminId")==null||(session.getAttribute("adminId")==""))
           {
                
               response.sendRedirect("../index.jsp"); 

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
                    window.location.href="DeleteAnn.jsp";
                </script>
                <%} else{%>
                <script type="text/javascript">
                    alert("Problem encountered! Try again.");
                    window.location.href="DeleteAnn.jsp";
                </script> 
                <%}
            }
                     
           ResultSet rs=Common.getAnnouncements();
           
           int unrepliedInquiries=0;
            ResultSet unrepliedInq=admin.numberOfUnrepliedInquiries();
            unrepliedInq.next(); 
            unrepliedInquiries = unrepliedInq.getInt(1);
            
            int totalInquiries=0;
            ResultSet totalInq=admin.numberOfInquiries();
            totalInq.next(); 
            totalInquiries = totalInq.getInt(1);
           %>
            
            <div class="container body">
                
                
                <div class="main_container">
                    
                <div class="col-md-3 left_col">
                        <div class="left_col">
                            
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
                                        <i class="fa fa-envelope-o"></i>
                                        <%if(unrepliedInquiries!=0){%>
                                        <span class="badge bg-green"><%=unrepliedInquiries%></span>
                                        <%}%>
                                    </a>
                                    <ul id="menu1" class="dropdown-menu list-unstyled msg_list animated fadeInDown" role="menu">
                                        
                                        <li>
                                            <a>
                                               
                                                <span>
                                                    <span>Inquiries(<%=totalInquiries%>)</span>
                                                    <span class="time">Unreplied(<%=unrepliedInquiries%>)</span>
                                                </span>
                                                
                                            </a>  
                                        </li>
                                        <li>
                                            <a>
                                              
                                                <span class="message">
                                                    <%if(unrepliedInquiries==0){%>
                                                    Oops! No unreplied inquiry... 
                                                    <%} else if(unrepliedInquiries==1){%>
                                                    You have <%=unrepliedInquiries%> unreplied inquiry... 
                                                    <%} else {%>
                                                    You have <%=unrepliedInquiries%> unreplied inquiries...
                                                    <%}%>
                                                </span>
                                            </a>  
                                        </li>
                                        
                                        <li>
                                            <%if(unrepliedInquiries!=0){%>
                                            <div class="text-center">
                                                
                                                    <strong><a href="UnrepliedInquiries.jsp">Reply</a></strong>
                                                    <i class="fa fa-angle-right"></i>
                                               
                                            </div>
                                            <%}%>
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
                                <h3>Announcements</h3>
                            </div>
                            
                        </div>
                        <div class="clearfix"></div>
                        <div class="row">
                            <div class="col-md-12 col-sm-12 col-xs-12">
                                <div class="x_panel">
                                    
                                    <div class="x_content">
                                        <br />
                                        <div class="panel panel-default">
                                            <div class="panel-heading">
                                                Delete
                                            </div>
                                            <div class="panel-body">
                                                <table class="table table-striped table-bordered table-hover" id="delete-announcement">
                                                    <thead>
                                                        <tr>
                                                    <th>Id</th>
                                                    <th>Title</th>
                                                    <th>Announcement</th>
                                                    <th>Post_Date</th>
                                                    <th>Action</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                 <%
                                                 int check=1;
                                                 int id=0; 
                                                 while(rs.next()){
                                                     id=rs.getInt("id");
                                                 %>
                                                <tr>
                                                    <th scope="row"><%=rs.getInt("id")%></th>
                                                    <td><%=rs.getString("Title")%></td>
                                                    <td><%=rs.getString("Body")%></td>
                                                    <td><%=rs.getDate("Post_Date")%></td>
                                                    <td style="width: 78px;"><a href="#deleteConfirm<%=check%>" data-toggle="modal" class="btn btn-primary" style="margin: 0px 0px;"><i class="fa fa-trash-o">Delete</i></a></td>
                                                </tr>
                                                    
                                            <div class="modal fade" id="deleteConfirm<%=check%>" role="dialog">
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
                                                                    <button type="submit" name="delete<%=check%>" class="btn btn-danger">Delete</button> 
                                                                </div>
                                                            </form>
                                                        </div>
                                                            
                                                    </div><!-- /.modal-content -->
                                                </div><!-- /.modal-dialog -->
                                            </div><!-- /.modal -->
                                            <%
                                                if(request.getParameter("delete"+check)!=null){
                                                    int results2=admin.deleteAnn(id);
                                                    if(results2>0){%>
                                                    <script>
                                                        window.location.href="DeleteAnn.jsp";
                                                    </script>
                                                    <%}
                                                }
                                            check++;
                                                 }%>
                                            </tbody>
                                        </table>
                                         </div> 
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
        
        <!-- DataTables JavaScript -->
    <script src="js/tables/jquery.dataTables.min.js"></script>
    <script src="js/tables/dataTables.bootstrap.min.js"></script>

    <!-- Page-Level Demo Scripts - Tables - Use for reference -->
    <script>
    $(document).ready(function() {
        $('#delete-announcement').DataTable({
                responsive: true
        });
    });
    </script>
            
    </body>
    
</html>