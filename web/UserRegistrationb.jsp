<%-- 
    Document   : UserRegistrationb
    Created on : Jun 13, 2015, 9:41:48 PM
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
    <title>User Registration</title>
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
        
            
        <div class="row2">
            <div class="col-md-5 col-md-offset-5">
			
                <div class="login-panel panel panel-default">
   
                <%if(request.getParameter("register")!=null){%>                 
                <%!
    public class Registration{ 
        Connection conn=null;
        PreparedStatement pst=null;
        PreparedStatement pst1=null;
        ResultSet rs=null;
        int res1=0;
        int res2=0; 
        String db="jdbc:mysql:///vettingsystem";
        String user="root";
        String password="";
        
        public Registration(){ 
           try{
            conn = DriverManager.getConnection(db,user,password); 

            pst = conn.prepareStatement("insert into registration values(?,?,?,?,?)");
            
            pst1 = conn.prepareStatement("select * from registration where Email=?");
            
           }catch(SQLException e){
               e.printStackTrace(); 
           }
        }
        
        public ResultSet checkIfRegistered(String email1){ 
        try{   
        pst1.setString(1, email1); 
        rs=pst1.executeQuery(); 
        }catch(SQLException e){
            e.printStackTrace();
        }
        return rs;  
        }

        public int setUsers(String fname, String mname, String lname, String email, String pwd){ 
        try{   
        pst.setString(1, fname);
        pst.setString(2, mname);
        pst.setString(3, lname);
        pst.setString(4, email);
        pst.setString(5, pwd);
        res2=pst.executeUpdate(); 
        }catch(SQLException e){
            e.printStackTrace();
        }
        return res2;  
        }
            
        }
    %>
    
    <%
    Registration reg=new Registration(); 
    
    String fname=request.getParameter("fname");
    String mname=request.getParameter("mname");
    String lname=request.getParameter("lname");
    String email=request.getParameter("email");
    String pwd=request.getParameter("password1"); 
    
    ResultSet results1=reg.checkIfRegistered(email);
    int results2=reg.setUsers(fname, mname, lname, email, pwd);

    
        if(results1.next()){%>
        <div class="panel-heading">
               <h3 class="panel-title alert alert-danger alert-block" style="text-align: center;"><span style="color: red;">Email You Provided is Already Registered!!</span></h3>
        </div> 
       <% }
        else{
    
            if(results2>0){%>
            <div class="panel-heading">
               <h3 class="panel-title alert alert-success alert-block" style="text-align: center;"><span style="color: green;">Registration Successful... Click Sign In below to Login</span></h3>
            </div> 
     <% }
       else{%>
       <div class="panel-heading">
               <h3 class="panel-title alert alert-error alert-block" style="text-align: center;"><span style="color: red;">Server is Down!!</span></h3>
       </div> 
         <% }
    }
    }
    else{
                    %>
                    <div class="panel-heading">
                        <h3 class="panel-title" style="text-align: center;">Welcome New User! Sign Up Below.</h3>
                    </div>
            <%}%> 
            <div class="panel-body">
                        
                <form name="registration" method="post" action="" onsubmit="return validateForm(this)"><br>
                   
                    <fieldset>

                        <table style="width: 600px; height: 350px;">
                            <tbody>
                                <tr>
                                    <td align="right" valign="top" style="padding-top:10px;">First Name:<span style="color:red"> *</span> &nbsp;&nbsp;&nbsp;</td>
                                    <td valign="top"><input  autocomplete="off" name="fname" id="fname" type="text" autofocus>
                                        <span id="fnameError" style="color: #ff6699;"></span>
                                    </td>
                                    <td valign="top"></td>
                                </tr>
                                <tr>
                                    <td align="right" valign="top" style="padding-top:10px;">Middle Name:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                                    <td valign="top"><input autocomplete="off" name="mname" id="mname" type="text">
                                        <span id="mnameError"> </span>
                                    </td>
                                    <td valign="top"></td>
                                </tr>
                                <tr>
                                    <td align="right" valign="top" style="padding-top:10px;">Last Name:<span style="color:red"> *</span>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                                    <td valign="top"><input autocomplete="off" name="lname" id="lname" type="text">
                                        <span id="lnameError" style="color: #ff6699;"> </span>
                                    </td>
                                    <td valign="top"></td>
                                </tr>

                                <tr>
                                    <td align="right" valign="top" style="padding-top:10px;">Email Address:<span style="color:red"> *</span>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                                    <td valign="top"><input autocomplete="off" name="email" id="idnum" type="email">
                                        <span id="emailError" style="color: #ff6699;"> </span>
                                    </td>
                                    <td valign="top"></td>
                                </tr>
                                <tr >
                                    <td align="right" valign="top" style="padding-top:10px;">Password:<span style="color:red"> *</span>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                                    <td valign="top"><input autocomplete="off" name="password1" id="pwd" type="password" >
                                        <span id="password1Error" style="color: #ff6699;"> </span>
                                    </td>
                                    <td valign="top"></td>
                                </tr>

                                <tr>
                                    <td align="right" valign="top" style="padding-top:10px;">Confirm Password:<span style="color:red">*</span>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                                    <td valign="top"><input autocomplete="off" name="password2" id="mobnumber" type="password">
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
