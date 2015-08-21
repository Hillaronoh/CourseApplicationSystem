<%-- 
    Document   : data
    Created on : Aug 18, 2015, 5:35:56 PM
    Author     : hillary
--%>
<%@page import="java.sql.*" %>
<%@page import="myproject.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%   
    Applicant app=new Applicant();
    String levelIdString = request.getParameter("programmeLevel");
    int levelIdInt=Integer.parseInt(levelIdString);  
    ResultSet rs=app.getCourses(levelIdInt);
    while (rs.next()){ 
        int courseId=rs.getInt("Course_id"); 
        String courseName = rs.getString("Course_Name");
        out.print("<option value="+courseId+">"+courseName+"</option>");
    }
    %>
