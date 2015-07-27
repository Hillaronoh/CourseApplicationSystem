<%-- 
    Document   : UserLogin
    Created on : Jun 13, 2015, 9:41:48 PM
    Author     : Kipngetich
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ajax trial</title>
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
            
    
    

     <div class="panel-heading" id="result">
         Please Sign In
     </div>
    
       <div class="panel-body2">
                        
           <form role="form" method="post" action="UserLoginProcessor.jsp" id="myForm">
               <fieldset>
                   <div class="form-group">
                      <div class="input-group">
                          <div class="input-group-addon"><i class="fa fa-envelope"></i></div>
                          <input class="form-control" type="email" placeholder="Email" name="email" autocomplete="off" autofocus>
                      </div>
                   </div>
                   <div class="form-group">
                       <div class="input-group">
                           <div class="input-group-addon"><i class="fa fa-lock"></i></div>
                           <input class="form-control" type="password" placeholder="Password" name="password">
                       </div>
                   </div>
                   <div class="checkbox">
                       <label>
                           <input name="remember" type="checkbox" value="Remember Me">Remember Me
                       </label>
                   </div>
                   <!-- Change this to a button or input when using this as a form -->
                   <button class="btn btn-lg btn-success btn-block" type="submit" name="login" id="sub"><i class="fa fa-sign-in"></i> Login</button>
                
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
    <script src="mycss/js/jquery-1.8.1.min.js"></script>
    <script src="mycss/js/myScript.js"></script>
</body>
</html>
