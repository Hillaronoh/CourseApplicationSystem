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
<style>
    .error{
        color: red;
    }
    .login-panel{
        margin-top: 19%;
        width: 90%;
        margin-left: 7%;
        height: 350px;
    }
</style>
</head>
<body style="overflow-x: hidden; background-color: #EFEEEE;"> 
    
    <jsp:include page="Header.jsp"></jsp:include>
    
    <div class="container">

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
        String db="jdbc:mysql:///project1c";
        String user="root";
        String password="";
        
        public Registration(){ 
           try{
            conn = DriverManager.getConnection(db,user,password); 

            pst = conn.prepareStatement("insert into registration values(?,?,?,?,?)");
            
            pst1 = conn.prepareStatement("select * from registration where Email_address=?");
            
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
            <div class="panel-body" style="padding-left: 3%;">
                        
                <form name="registration" method="post" action="" id="myForm4" onsubmit="return validateForm(this)"><br>
                    
                    <fieldset>
                        
                        <div class="row" id="firstNameRow">     
                            <div class="form-group col-sm-4">
                                <label for="fname">First Name:<span style="color:red"> *</span></label>
                                <input type="text" class="form-control input" id="fname" name="fname" placeholder="First Name"/>
                            </div>
                       
                            <div class="form-group col-sm-4">
                                <label for="mname">Middle Name:</label>
                                <input type="text" class="form-control input" id="mname" name="mname" placeholder="Middle Name"/>
                            </div>
                          
                            <div class="form-group col-sm-4">
                                <label for="lname">Last Name:<span style="color:red"> *</span></label>
                                <input type="text" class="form-control input" id="lname" name="lname" placeholder="Last Name"/>
                            </div>    
                        </div>
                        
                        <div class="row" id="emailRow">    
                            <div class="form-group col-sm-4">
                                <label for="email">Email Address:<span style="color:red"> *</span></label>
                                <input type="text" class="form-control input" id="email" name="email" placeholder="Email Address"/>
                            </div>
                    
                            <div class="form-group col-sm-4">
                                <label for="password1">Password:<span style="color:red"> *</span></label>
                                <input type="password" class="form-control input" id="password1" name="password1" placeholder="Password"/>
                            </div>
                        
                            <div class="form-group col-sm-4">
                                <label for="password2">Confirm Password:<span style="color:red"> *</span></label>
                                <input type="password" class="form-control input" id="password2" name="password2" placeholder="Confirm Password"/>
                            </div>        
                        </div>
                        
                        <div class="row" id="buttons1">
                            <div class="col-sm-3"></div>
                            <div class="form-group col-sm-3">
                                <button type="submit" name="submit1" class="btn btn-success" style="width: 150px;">Submit</button>
                            </div>
                            <div class="form-group col-sm-3">
                                <button type="reset" name="reset" class="btn btn-info pull-right" style="width: 150px;">Reset</button>
                            </div>
                            <div class="col-sm-3"></div>
                        </div>
                            
                       
                    </fieldset>
                    <div class="row">
                        <div class="col-sm-9"></div>
                        <div class="col-sm-3">
                    <a href="../Login.jsp" style="float: right;">Sign In</a>
                        </div>
                    </div>
                </form>
                    
            </div>
                </div>
    </div>
        
    <!-- Core Scripts - Include with every page -->
    <script src="assets/plugins/jquery-1.10.2.js"></script>
    <script src="assets/plugins/bootstrap/bootstrap.min.js"></script>
    <script src="assets/plugins/metisMenu/jquery.metisMenu.js"></script>
    <script type="text/javascript" src="mycss/validation/jquery.validate.js"></script>
    <script type="text/javascript" src="mycss/validation/additional-methods.js"></script>
    <script src="mycss/validation/custom.js"></script>
</body>
</html>
