<%-- 
    Document   : UserAccount
    Created on : Jul 10, 2015, 9:32:23 AM
    Author     : Kipngetich
--%>
<%@page import="java.sql.*" %>
<%@page import="myproject.*"%> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Applicant's Account</title>
        <link rel="stylesheet" href="mycss/glyphicons/css/bootstrap.min.css">
        <link href="assets/plugins/bootstrap/bootstrap.css" rel="stylesheet" />
        <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
        <link href="assets/plugins/pace/pace-theme-big-counter.css" rel="stylesheet" />
        <link href="assets/css/style.css" rel="stylesheet" />
        <link href="assets/css/main-style.css" rel="stylesheet" />
        <link rel="stylesheet" style type="text/css" href="mycss/navMenus.css">
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
           String lastName=new String();
           
           ResultSet results=user.getApplicantDetails(applicantId);
           
           if(results.next()){
               firstName=results.getString("First_Name");
               lastName=results.getString("Last_Name");
           }
           
           ResultSet confirmRanking=user.confirmRanking();
           ResultSet crs=user.getCourseDetails(applicantId);
        %>
           
        <jsp:include page="Header.jsp"></jsp:include>
        
        <div class="container">
            
            <div class="row" style="margin-left: -58px; margin-top: -20px;">
                <div class="col-md-4"></div>
                
                <div class="col-md-4 col-md-offset-4" style="width: 1052px; padding-right: 0px; padding-left: 0px">
                    
                    <div class="login-panel panel panel-default"> 
                        
                        <div class="panel-heading">
                            <h3 class="panel-title">Welcome <%=firstName%> <%=lastName%> to Your Account</h3>
                        </div>
                        <div class="panel-body" style=" height: 400px; padding: 0px;">
                            
                            <div id="navMenu" style="margin-top: 1px;">
                                <ul>
                                    <li><a href="#"><button class="btn btn-info" style="width: 148px; height: 35px; padding-top: 0px; margin-top: -5px; background-color: #428BCA;"><i class="fa fa-home"></i>Home</button></a>
                                    </li>
                                </ul>
                                <ul>
                                    <li><a href="#"><button class="btn btn-info" style="width: 148px; height: 35px; padding-top: 0px; margin-top: -5px;"><i class="fa fa-arrow-down"></i>Apply Course</button></a>
                                        <ul>
                                            <li><a href="ApplicationForm.jsp">Under Graduate</a></li>
                                            <li><a href="#">Post Graduate</a></li>
                                        </ul>
                                    </li>
                                </ul>
                                <ul>
                                    <li><a href="Announcements.jsp"><button class="btn btn-info" style="width: 148px; height: 35px; padding-top: 0px; margin-top: -5px;"><i class="fa fa-bell"></i>Announcements</button></a>
                                        
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
                                    <li><a href="#"><button class="btn btn-info" style="width: 148px; height: 35px; padding-top: 0px; margin-top: -5px;"><i class="fa fa-user"></i><%=firstName%></button></a>
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
                <div class="col-md-4"></div>
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
                        <%if(!confirmRanking.next()){%>
                        <p><strong class="red">Status not found!</strong><br/>Keep checking.</p>
                        <%} else{%>
                        <h4>You qualify for:</h4>
                            <%int li=0;
                            int ci=0;
                            int rank=0;
                        while(crs.next()){
                            li=crs.getInt("Level_id");
                            ci=crs.getInt("Course_id");
                            if(li==3&&ci==1){
                                ResultSet getrank=user.getDegCsRank(applicantId); 
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      ResultSet crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ResultSet ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                  %>
                                  <p><%=ln.getString("Level_Name")%> in <%=crn.getString("Course_Name")%></p>
                                 <%}else{%>
                                       <p>nnnn</p>
                                  <% }
                                }
                            }
                            
                            if(li==3&&ci==2){
                                ResultSet getrank=user.getDegItRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      ResultSet crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ResultSet ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                  %>
                        <p><%=ln.getString("Level_Name")%> in <%=crn.getString("Course_Name")%></p>
                                 <%}else{%>
                                       <p>nnnn</p>
                                  <% }
                                }
                            }
                            
                            if(li==3&&ci==3){
                                ResultSet getrank=user.getDegInfoRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      ResultSet crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ResultSet ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                  %>
                        <p><%=ln.getString("Level_Name")%> <%=rank%>in <%=crn.getString("Course_Name")%></p>
                                 <%}else{%>
                                       <p>nnnn</p>
                                  <% }
                                }
                            }
                            
                            if(li==3&&ci==4){
                                ResultSet getrank=user.getDegCfRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      ResultSet crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ResultSet ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                  %>
                        <p><%=ln.getString("Level_Name")%> <%=rank%>in <%=crn.getString("Course_Name")%></p>
                                 <%}else{%>
                                       <p>nnnn</p>
                                  <% }
                                }
                            }
                            
                            if(li==4&&ci==1){
                                ResultSet getrank=user.getDipCsRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      ResultSet crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ResultSet ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                  %>
                        <p><%=ln.getString("Level_Name")%> <%=rank%>in <%=crn.getString("Course_Name")%></p>
                                 <%}else{%>
                                       <p>nnnn</p>
                                  <% }
                                }
                            }
                            
                            if(li==4&&ci==2){
                                ResultSet getrank=user.getDipItRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      ResultSet crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ResultSet ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                  %>
                        <p><%=ln.getString("Level_Name")%> <%=rank%>in <%=crn.getString("Course_Name")%></p>
                                 <%}else{%>
                                       <p>nnnn</p>
                                  <% }
                                }
                            }
                            
                            if(li==4&&ci==3){ 
                                ResultSet getrank=user.getDipInfoRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      ResultSet crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ResultSet ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                  %>
                        <p><%=ln.getString("Level_Name")%> in <%=crn.getString("Course_Name")%></p>
                                 <%}else{%>
                                       <p>nnnn</p>
                                  <% }
                                }
                            }
                            
                            if(li==4&&ci==4){ 
                                ResultSet getrank=user.getDipCfRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      ResultSet crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ResultSet ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                  %>
                        <p><%=ln.getString("Level_Name")%> in <%=crn.getString("Course_Name")%></p>
                                 <%}else{%>
                                       <p>nnnn</p>
                                  <% }
                                }
                            }
                            
                            if(li==5&&ci==2){ 
                                ResultSet getrank=user.getCertItRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      ResultSet crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ResultSet ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                  %>
                        <p><%=ln.getString("Level_Name")%> in <%=crn.getString("Course_Name")%></p>
                                 <%}else{%>
                                       <p>nnnn</p>
                                  <% }
                                }
                            }
                            
                            if(li==5&&ci==4){ 
                                ResultSet getrank=user.getCertCfRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      ResultSet crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ResultSet ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                  %>
                        <p><%=ln.getString("Level_Name")%> in <%=crn.getString("Course_Name")%></p>
                                 <%}else{%>
                                       <p>nnnn</p>
                                  <% }
                                }
                            }
                            
                            if(li==5&&ci==5){ 
                                ResultSet getrank=user.getCertIsRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      ResultSet crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ResultSet ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                  %>
                        <p><%=ln.getString("Level_Name")%> in <%=crn.getString("Course_Name")%></p>
                                 <%}else{%>
                                       <p>nnnn</p>
                                  <% }
                                }
                            }
                            
                            if(li==5&&ci==6){ 
                                ResultSet getrank=user.getCertHmRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      ResultSet crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ResultSet ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                  %>
                        <p><%=ln.getString("Level_Name")%> in <%=crn.getString("Course_Name")%></p>
                                 <%}else{%>
                                       <p>nnnn</p>
                                  <% }
                                }
                            }
                            
                           }
                        }%>
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
