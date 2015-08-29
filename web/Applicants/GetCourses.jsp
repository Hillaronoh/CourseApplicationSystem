<%-- 
    Document   : data
    Created on : Aug 18, 2015, 5:35:56 PM
    Author     : hillary
--%>
<%@page import="java.sql.*" %>
<%@page import="myproject.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

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
    Applicant app=new Applicant();
    Applicant app2=new Applicant();
    double clusterPoints=0.0; 
    ResultSet rs1=app.getEducationBackground(applicantId);
    if(rs1.next()){
       clusterPoints=rs1.getDouble("Cluster_Points");
    }
    String levelIdString = request.getParameter("programmeLevel");
    int levelIdInt=Integer.parseInt(levelIdString);  
    //ResultSet rs=app.getCourses(levelIdInt);
    ResultSet rs2=app2.getCoursesOverClusterLimit(levelIdInt, clusterPoints);
    ResultSet rs=app.getCoursesOverClusterLimit(levelIdInt, clusterPoints);
    if(rs2.next()){
    while (rs.next()){ 
        int courseId=rs.getInt("Course_id"); 
        String courseName = rs.getString("Course_Name");
        out.print("<option value="+courseId+">"+courseName+"</option>");
    }
}
    else{
       out.print("<option value=>Your Cluster is low! Choose another level.</option>"); 
    }
    %>
