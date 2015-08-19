<%-- 
    Document   : data
    Created on : Aug 18, 2015, 5:35:56 PM
    Author     : hillary
--%>
<%@page import="java.sql.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

        <%
    String db="jdbc:mysql:///project1c";
    String user="root";
    String password="";
   String name = "";
   Connection conn=null;
   PreparedStatement pst=null; 
   //String q = request.getParameter("q");
   //int q1=Integer.parseInt(q);
   try { 
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(db,user,password); 
        //Statement smt = conn.createStatement(); //Create Statement to interact
        pst=conn.prepareStatement("select * from course_details where Level_id=3");
       // ResultSet r = smt.executeQuery("select * from courses where(Level_id='" + q + "');");
         //pst.setInt(1,q1);
        ResultSet rs=pst.executeQuery();
       
        while (rs.next()) {
          name = rs.getString("Email_Address");
          out.print("<option value="+name+">"+name+"</option>"); 
        }
        conn.close();
   } catch (Exception e) {
        e.printStackTrace();
   }
%>
