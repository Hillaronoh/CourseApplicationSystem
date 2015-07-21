<%-- 
    Document   : CertificateFormb
    Created on : Jun 20, 2015, 8:01:33 PM
    Author     : Kipngetich
--%>

<%@page import="java.sql.*" %>
<%Class.forName("com.mysql.jdbc.Driver"); %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Certificate Application</title>
    <!-- Core CSS - Include with every page -->
    <link href="assets/plugins/bootstrap/bootstrap.css" rel="stylesheet" />
    <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <link href="assets/plugins/pace/pace-theme-big-counter.css" rel="stylesheet" />
    <link href="assets/css/style.css" rel="stylesheet" />
    <link href="assets/css/main-style.css" rel="stylesheet" />
    <link rel="stylesheet" href="mycss/style2.css" style type="text/css">
    

    
 <link rel="stylesheet" href="layout/bootstrap/css/bootstrap.css" type="text/css">

<script type="text/javascript" src="mycss/validate.js"></script>

</head>
<body style="overflow-x: hidden; background-color: #EFEEEE;"> 
    
    <jsp:include page="Header.jsp"></jsp:include>
    
    <div class="container">
        
            
            <div class="row" style="margin-top: 80px;">
                <div class="col-md-4 col-md-offset-4" style="width: auto; padding-left: auto; padding-right: auto; margin-left: 145px; margin-right: auto;">
			
                    <div class="login-panel panel panel-default">
   

                    <div class="panel-heading">
                        <h3 class="panel-title" style="text-align: center;">Welcome New User! Sign Up Below.</h3>
                    </div>
                  <div class="panel-body">
                        
                        <form name="registration" method="post" action="" onsubmit="return validateForm(this)"><br>
  <fieldset>

  <table style="width: 600px; height: 350px;">
	<tbody>
 

<tr>
    <td align="right" valign="top" style="padding-top:10px;">First Name:<span style="color:red"> *</span> &nbsp;&nbsp;&nbsp;</td>
    <td valign="top"><input style="height:30px; width:300px;" autocomplete="off" name="fname" id="surname" type="text" autofocus>
    <span id="fnameError" style="color: #ff6699;"></span>
    </td>
	<td valign="top"></td>
</tr>
<tr>
	<td align="right" valign="top" style="padding-top:10px;">Middle Name:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
	<td valign="top"><input style="height:30px; width:300px;" autocomplete="off" name="mname" id="mname" type="text">
        <span id="mnameError"> </span>
        </td>
	<td valign="top"></td>
</tr>
<tr>
	<td align="right" valign="top" style="padding-top:10px;">Last Name:<span style="color:red"> *</span>&nbsp;&nbsp;&nbsp;&nbsp;</td>
	<td valign="top"><input style="height:30px; width:300px;" autocomplete="off" name="lname" id="lname" type="text">
        <span id="lnameError" style="color: #ff6699;"> </span>
        </td>
	<td valign="top"></td>
</tr>

<tr>
	<td align="right" valign="top" style="padding-top:10px;">Gender:<span style="color:red"> *</span>&nbsp;&nbsp;&nbsp;&nbsp;</td>
	<td valign="top"><input style="height:30px; width:300px;" autocomplete="off" name="gender" id="idnum" type="email">
        <span id="emailError" style="color: #ff6699;"> </span>
        </td>
	<td valign="top"></td>
</tr>
<tr >
	<td align="right" valign="top" style="padding-top:10px;">Date Of Birth:<span style="color:red"> *</span>&nbsp;&nbsp;&nbsp;&nbsp;</td>
	<td valign="top"><input style="height:30px; width:300px;" autocomplete="off" name="dob" id="pwd" type="password" >
        <span id="password1Error" style="color: #ff6699;"> </span>
        </td>
	<td valign="top"></td>
</tr>

<tr>
	<td align="right" valign="top" style="padding-top:10px;">Postal Address:<span style="color:red"></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
	<td valign="top"><input style="height:30px; width:300px;"  autocomplete="off" name="pa" id="mobnumber" type="password">
        <span id="password2Error" style="color: #ff6699;"> </span>
        </td>
	<td valign="top"></td>
</tr>

<tr>
	<td align="right" valign="top" style="padding-top:10px;">Mobile:<span style="color:red"></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
	<td valign="top"><input style="height:30px; width:300px;"  autocomplete="off" name="mobile" id="mobnumber" type="password">
        <span id="password2Error" style="color: #ff6699;"> </span>
        </td>
	<td valign="top"></td>
</tr>

<tr>
	<td align="right" valign="top" style="padding-top:10px;">Nationality:<span style="color:red"></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
	<td valign="top"><input style="height:30px; width:300px;"  autocomplete="off" name="country" id="mobnumber" type="password">
        <span id="password2Error" style="color: #ff6699;"> </span>
        </td>
	<td valign="top"></td>
</tr>

<tr>
	<td align="right" valign="top" style="padding-top:10px;">K.C.S.E Physics Grade:<span style="color:red"></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
	<td valign="top"><input style="height:30px; width:300px;"  autocomplete="off" name="physics" id="mobnumber" type="password">
        <span id="password2Error" style="color: #ff6699;"> </span>
        </td>
	<td valign="top"></td>
</tr>

<tr>
	<td align="right" valign="top" style="padding-top:10px;">K.C.S.E Maths Grade:<span style="color:red"></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
	<td valign="top"><input style="height:30px; width:300px;"  autocomplete="off" name="maths" id="mobnumber" type="password">
        <span id="password2Error" style="color: #ff6699;"> </span>
        </td>
	<td valign="top"></td>
</tr>

<tr>
	<td align="right" valign="top" style="padding-top:10px;">K.C.S.E Mean Grade:<span style="color:red"></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
	<td valign="top"><input style="height:30px; width:300px;"  autocomplete="off" name="meangrade" id="mobnumber" type="password">
        <span id="password2Error" style="color: #ff6699;"> </span>
        </td>
	<td valign="top"></td>
</tr>

<tr>
	<td align="right" valign="top" style="padding-top:10px;">K.C.S.E Aggregate Points:<span style="color:red"></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
	<td valign="top"><input style="height:30px; width:300px;"  autocomplete="off" name="aggregatepoints" id="mobnumber" type="password">
        <span id="password2Error" style="color: #ff6699;"> </span>
        </td>
	<td valign="top"></td>
</tr>

<tr>
	<td align="right" valign="top" style="padding-top:10px;">Select Programme:<span style="color:red"></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
	<td valign="top"><input style="height:30px; width:300px;"  autocomplete="off" name="programme" id="mobnumber" type="password">
        <span id="password2Error" style="color: #ff6699;"> </span>
        </td>
	<td valign="top"></td>
</tr>

<tr>
	<td align="right" valign="top"></td>
	<td valign="top"><strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="submit" name="register" class="btn btn-success" style="width:25%;" value="Register" id="submit"></strong> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <strong><input name="reset" class="btn btn-info" style="width:25%;" value="Reset" id="clear" type="reset"></strong> <br/></td>
	<td valign="top"></td>
	
</tr>

  </tbody>
  </table>  
  </fieldset>
 <a href="UserLogin.jsp" style="float: right;">Sign In Here</a>
</form>
                        
                    </div>
                </div>
                </div>
            </div>
       
    </div>

     <!-- Core Scripts - Include with every page -->
    <script src="assets/plugins/jquery-1.10.2.js"></script>
    <script src="assets/plugins/bootstrap/bootstrap.min.js"></script>
    <script src="assets/plugins/metisMenu/jquery.metisMenu.js"></script>

</body>
</html>