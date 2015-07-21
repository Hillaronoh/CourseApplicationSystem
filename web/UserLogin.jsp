<%-- 
    Document   : UserLogin
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
    <title>User Login</title>
    <link rel="stylesheet" href="mycss/glyphicons/css/bootstrap.min.css">
    <!-- Core CSS - Include with every page -->
    <link href="assets/plugins/bootstrap/bootstrap.css" rel="stylesheet" />
    <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <link href="assets/plugins/pace/pace-theme-big-counter.css" rel="stylesheet" />
    <link href="assets/css/style.css" rel="stylesheet" />
    <link href="assets/css/main-style.css" rel="stylesheet" />   
</head>
<body style="overflow-x: hidden; background-color: #EFEEEE;"> 
    
    <jsp:include page="Header.jsp"></jsp:include>
    
    <div class="container">
      
        <div class="row1">
            
            <div class="col-md-3 col-md-offset-3">
			
                <div class="login-panel panel panel-default"> 
            <%if(request.getParameter("login")!=null){%> 
            <%!
    public class Login{ 
        Connection conn=null;
        PreparedStatement pst=null;
        ResultSet rs=null;
        String db="jdbc:mysql:///vettingsystem";
        String user="root";
        String password="";
        
        public Login(){ 
           try{
            conn = DriverManager.getConnection(db,user,password); 

            pst = conn.prepareStatement("select * from registration where Email=? and Password=?"); 
            
           }catch(SQLException e){
               e.printStackTrace(); 
           }
        }
        public ResultSet setUsers(String mail, String pass){
        try{   
        pst.setString(1, mail);
        pst.setString(2, pass);
        rs=pst.executeQuery();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return rs;  
        }
            
        }
    %>
    
    <%
    Login login=new Login(); 
  
    String email=request.getParameter("email");
    String pwd=request.getParameter("password"); 
    ResultSet results=login.setUsers(email, pwd); 
 
   if(results.next()){  
   session.setAttribute("userid", email);  
   response.sendRedirect("UserAccount.jsp"); 
        }
   else{
       %>
				                 
       <div class="panel-heading">
           
           <h3 class="panel-title alert alert-danger"><span style="color: red;">Wrong Login Credentials!!</span></h3>
       </div>
     <%}} else {%>
     <div class="panel-heading">
         <h3 class="panel-title">Please Sign In</h3>
     </div>
       <%}%>
       <div class="panel-body2">
                        
           <form role="form" method="post" action="">
               <fieldset>
                   <div class="form-group">
                      <div class="input-group">
                          <div class="input-group-addon"><span class="glyphicon glyphicon-envelope"></span></div>
                          <input class="form-control" type="email" placeholder="Email" name="email" autocomplete="off" autofocus>
                      </div>
                   </div>
                   <div class="form-group">
                       <div class="input-group">
                           <div class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></div>
                           <input class="form-control" type="password" placeholder="Password" name="password">
                       </div>
                   </div>
                   <div class="checkbox">
                       <label>
                           <input name="remember" type="checkbox" value="Remember Me">Remember Me
                       </label>
                   </div>
                   <!-- Change this to a button or input when using this as a form -->
                   <button class="btn btn-lg btn-success btn-block" type="submit" name="login"><span class="glyphicon glyphicon-log-in" style="font-size: 15px;"></span> Login</button>
                
               </fieldset>
           </form>
           <br>
           <p><a href="">Forgot Password?</a> &nbsp;&nbsp;&nbsp;<a href="UserRegistrationb.jsp" style="float: right;">Sign Up Here</a>
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
