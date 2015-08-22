<%-- 
    Document   : data
    Created on : Aug 18, 2015, 5:35:56 PM
    Author     : hillary
--%>
<%@page import="java.sql.*" %>
<%@page import="myproject.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
    <title>kip</title>
    <script type="text/javascript" src="mycss/modal/jquery.minCust.js"></script>
            <script type="text/javascript" src="mycss/modal/bootstrapJsCust.js"></script>
            <script type="text/javascript" src="mycss/validation/jquery.js"></script>
            <script type="text/javascript" src="mycss/validation/jquery.validate.js"></script>
            <script type="text/javascript" src="mycss/validation/additional-methods.js"></script>
            <script src="mycss/validation/custom.js"></script>
</head>
<body>
<dialog id="window">  
    <h3>Sample Dialog!</h3>  
    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Earum, inventore!</p>  
    <button id="exit">Close Dialog </button> 
    <button id="show">Show Dialog</button>  
</dialog> 
<script>
    (function() {  
    var dialog = document.getElementById('window');  
    document.getElementById('show').onclick = function() {  
        dialog.show();  
    };  
    document.getElementById('exit').onclick = function() {  
        dialog.close();  
    };  
})();
</script>
</body>
</html>