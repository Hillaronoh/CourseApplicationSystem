<%-- 
    Document   : RankCertApp
    Created on : Jul 27, 2015, 2:49:06 PM
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
        
        <title> Ranking | Certificate </title>
        
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
            Applicant applicant=new Applicant();
            Applicant applicant2=new Applicant();
            String firstName=new String();
                                   
            ResultSet results=admin.getAdmin(adminId);
            
            int certStatusId=0;
            ResultSet certStatus=applicant.checkSatus(5);
            if(certStatus.next()){
             certStatusId=certStatus.getInt("Status");
           }
           
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
                    window.location.href="RankCertApp.jsp";
                </script>
                <%} else{%>
                <script type="text/javascript">
                    alert("Problem encountered! Try again.");
                    window.location.href="RankCertApp.jsp";
                </script> 
                <%}
            }
            
            if(request.getParameter("rank")!=null){
                int levelId=5;
                int courseIdIt=2;
                int courseIdCf=4;
                int courseIdIs=5;
                int courseIdHm=6;
                int statusId=0;
                int requiredNumberIt=Integer.parseInt(request.getParameter("it"));
                int requiredNumberCf=Integer.parseInt(request.getParameter("cf"));
                int requiredNumberIs=Integer.parseInt(request.getParameter("is"));
                int requiredNumberHm=Integer.parseInt(request.getParameter("hm"));
                int r1=admin.ranking(levelId, courseIdIt, requiredNumberIt);
                int r2=admin.ranking(levelId, courseIdCf, requiredNumberCf);
                int r3=admin.ranking(levelId, courseIdIs, requiredNumberIs);
                int r4=admin.ranking(levelId, courseIdHm, requiredNumberHm);
                int status=admin.changeCourseStatus(statusId, levelId);
                if(r1>0&&r2>0&&r3>0&&r4>0&&status>0){%>
                <script>
                    alert("Ranking Successful");
                    window.location.href="RankCertApp.jsp";
                </script>
                <%}else{%>
                <script>
                    alert("Problem encountered! Try again.");
                    window.location.href="RankCertApp.jsp";
                </script>  
                <%}
            }
            if(request.getParameter("undo")!=null){
                int statusId=1; 
                int levelId=5;
                int status=admin.changeCourseStatus(statusId, levelId);
                int r=admin.undoRanking(5);
                if(r>0&&status>0){%>
                <script>
                    alert("Ranking undone successfully.");
                    window.location.href="RankCertApp.jsp";
                </script>
                <%}else{%>
                <script>
                    alert("Problem encountered! Try again.");
                    window.location.href="RankCertApp.jsp";
                </script>  
                <%}
            }
            
            int unrepliedInquiries=0;
            ResultSet unrepliedInq=admin.numberOfUnrepliedInquiries();
            unrepliedInq.next(); 
            unrepliedInquiries = unrepliedInq.getInt(1);
            
            int totalInquiries=0;
            ResultSet totalInq=admin.numberOfInquiries();
            totalInq.next(); 
            totalInquiries = totalInq.getInt(1);
            
            ResultSet confirmRank=applicant.checkRankingPerLevel(5);
            ResultSet getRankedCourses=applicant2.checkRankingPerLevel(5); 
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
                                <h3>Rank</h3>
                            </div>
                             <form>
                                <%if(certStatusId==0){%>
                                <div class="pull-right"><button type="submit" name="open" class="btn btn-info"><i class="fa fa-unlock"></i>Open Certificate Application</button></div>
                            <%} else{%>
                            <div class="pull-right"><button type="submit" name="close" class="btn btn-warning"><i class="fa fa-lock"></i>Close Certificate Application</button></div>
                            <%}%>
                            </form>
                            <%if(request.getParameter("open")!=null){
                             int statusId=1;
                             int levelId=5;
                            int status=admin.changeCourseStatus(statusId, levelId); 
                            if(status>0){%>
                            <script>
                                alert("Certificate Application was opened successfully.");
                                window.location.href="RankDegApp.jsp";
                            </script> 
                            <%} }
                            if(request.getParameter("close")!=null){
                             int statusId=0;
                             int levelId=5;
                             int status=admin.changeCourseStatus(statusId, levelId); 
                             if(status>0){%>
                            <script>
                                alert("Certificate Application was closed successfully.");
                                window.location.href="RankDegApp.jsp";
                            </script> 
                            <%} }
                            %>
                        </div>
                        <div class="clearfix"></div>
                        <div class="row">
                            <div class="col-md-12 col-sm-12 col-xs-12">
                                <div class="x_panel">
                                    <div class="x_title">
                                        
                                        <h4>Cetificate Applicants</h4>
                                        <div class="clearfix"></div>
                                    </div>
                                    <div class="x_content">
                                        <br />
                                        
                                        
                                        
                                        
                                        
                                        
                                        
                                        <div class="row">
                                            <div class="col-sm-3">
                                                <form>
                                            <div class="row">
                                                <div class="col-sm-12 panel panel-default">
                                                    <fieldset><legend>Rank Status</legend></fieldset>
                                                    <%boolean isRanked=false;
                                                    if(confirmRank.next()){
                                                    isRanked=true;%>
                                                    <p>Ranking for Certificate Applicants was done successfully as follows;</p>
                                                    <table class="table table-striped table-bordered table-hover"> 
                                                             <thead>
                                                                 <tr>
                                                                     <th>Course Name</th>
                                                                     <th>Required Number</th>
                                                                 </tr>
                                                             </thead>
                                                        <%while(getRankedCourses.next()){
                                                            ResultSet crsName=applicant.getCourseName(getRankedCourses.getInt("Course_id"));
                                                            crsName.next();
                                                         %>
                                                         
                                                             <tbody>
                                                                 <tr>
                                                                     <td><%=crsName.getString("Course_Name")%></td>
                                                                     <td><%=getRankedCourses.getInt("Required_Number")%></td>
                                                                 </tr>
                                                             </tbody>
                                                        
                                                        
                                                         <%}%> 
                                                     </table>
                                                    <%} else{%>
                                                    <p>No Ranking found for Certificate Applicants!</p>
                                                    <%}%>
                                            </div>
                                            <%if(isRanked){%>
                                            <button type="submit" class="btn btn-danger btn-block" name="undo"><i class="fa fa-undo"></i>Undo Previous Ranking</button><br/>
                                            <%} else{%>
                                            <button type="submit" class="btn btn-danger btn-block disabled" name="undo"><i class="fa fa-undo"></i>Undo Previous Ranking</button><br/>
                                            <%}%>
                                            </div>
                                            </form>
                                            </div>
                                                <div class="col-sm-1"></div>
                                            <form class="form-horizontal" id="myForm5">
                                                <div class="col-sm-4 panel panel-default" style="padding: 15px 15px;">
                                                    <fieldset><legend>Rank Now</legend></fieldset>
                                                    <p>Specify the number of applicants as follows:</p>
                                                    <label for="it">Information Technology:</label>
                                                    <input type="number" class="form-control input" id="it" name="it" placeholder="Number of IT applicants"/><br/>
                                                    
                                                    <label for="cf">Computer Forensics:</label>
                                                    <input type="number" class="form-control input" id="cf" name="cf" placeholder="Number of computer forensics applicants"/><br/>
                                                    
                                                    <label for="is">Information Studies:</label>
                                                    <input type="number" class="form-control input" id="is" name="is" placeholder="Number of information studies applicants"/><br/> 
                                                    
                                                    <label for="hm">Hardware Maintenance:</label>
                                                    <input type="number" class="form-control input" id="hm" name="hm" placeholder="Number of hardware maintenance applicants"/><br/> 
                                                </div>
                                                <div class="col-sm-1"></div>
                                                <div class="col-sm-3 panel panel-default">
                                                    <fieldset><legend>Actions</legend></fieldset>
                                                    <%if(isRanked){%>
                                                    <button type="submit" class="btn btn-success btn-block disabled" name="rank"><i class="fa fa-check-square-o"></i>Rank</button><br/>
                                                    <button type="reset" class="btn btn-info btn-block disabled" name="reset"><i class="fa fa-close"></i>Reset</button><br/>
                                                    <%} else{%>
                                                    <button type="submit" class="btn btn-success btn-block" name="rank"><i class="fa fa-check-square-o"></i>Rank</button><br/>
                                                    <button type="reset" class="btn btn-info btn-block " name="reset"><i class="fa fa-close"></i>Reset</button><br/>
                                                    <%}%>
                                                </div>
                                            </form>
                                        </div>
                                        
                                        
                                        
                                        
                                        
                                        
                                        
                                       <!-- <div class="row">
                                            <form class="form-horizontal">
                                                <div class="col-sm-5 panel panel-default" style="padding: 15px 15px;">
                                                    <fieldset> <legend>Specify the number of applicants as follows:</legend></fieldset>
                                                    <label for="it">Information Technology:</label>
                                                    <input type="number" class="form-control input" id="it" name="it" placeholder="Number of IT applicants"/><br/>
                                                    
                                                    <label for="cf">Computer Forensics:</label>
                                                    <input type="number" class="form-control input" id="cf" name="cf" placeholder="Number of computer forensics applicants"/><br/>
                                                    
                                                    <label for="is">Information Studies:</label>
                                                    <input type="number" class="form-control input" id="is" name="is" placeholder="Number of information studies applicants"/><br/> 
                                                    
                                                    <label for="hm">Hardware Maintenance:</label>
                                                    <input type="number" class="form-control input" id="hm" name="hm" placeholder="Number of hardware maintenance applicants"/><br/> 
                                                </div>
                                                <div class="col-sm-1"></div>
                                                <div class="col-sm-3 panel panel-default">
                                                    <fieldset> <legend>Actions</legend></fieldset>
                                                    <button type="submit" class="btn btn-success btn-block" name="rank"><i class="fa fa-check-square-o"></i>Rank</button><br/>
                                                    <button type="reset" class="btn btn-info btn-block" name="reset"><i class="fa fa-close"></i>Reset</button><br/>
                                                    <button type="submit" class="btn btn-danger btn-block" name="undo"><i class="fa fa-undo"></i>Undo Ranking</button><br/>
                                                </div>
                                                <div class="col-sm-1"></div>
                                                <div class="col-sm-2 panel panel-default">
                                                    <fieldset><legend>Note</legend></fieldset>
                                                    <p>Specifying zero in any field means you don't want to rank the concerned applicants</p>
                                                </div>
                                            </form>
                                        </div>
                                        
                                    </div>
                                </div>
                            </div>
                        </div>-->
                        
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
        <script>
            autosize($('.resizable_textarea'));
        </script>
        <!-- Autocomplete -->
        <script type="text/javascript" src="js/autocomplete/countries.js"></script>
        <script src="js/autocomplete/jquery.autocomplete.js"></script>
        
        <script src="js/custom.js"></script>
        
    </body>
    
</html>
