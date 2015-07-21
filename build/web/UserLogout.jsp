<%-- 
    Document   : Logout
    Created on : Mar 27, 2015, 4:14:46 PM
    Author     : Kipngetich
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>logout</title>
    </head>
    <body>
        <%
        session.setAttribute("userid",null);
        session.invalidate();
        response.sendRedirect("UserLogin.jsp");
        %>
    </body>
</html>
