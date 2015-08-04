<%-- 
    Document   : AdminLogout
    Created on : Aug 4, 2015, 2:42:50 PM
    Author     : hillary
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
        session.setAttribute("userid",null);
        session.invalidate();
        response.sendRedirect("../Login.jsp");
        %>
    </body>
</html>
