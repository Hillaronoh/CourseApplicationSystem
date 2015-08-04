<%-- 
    Document   : Login
    Created on : Aug 4, 2015, 11:38:14 AM
    Author     : hillary
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link href="js/bootstrap/dist/css/bootstrap.css" rel="stylesheet" />
        <link href="css/login.css" rel="stylesheet" />
    </head>
    <body>
        <jsp:include page="Header.jsp"></jsp:include>
        <div id="container">
            <div class="panel-heading" style="background-color: #8391b9">     
                <h3 class="panel-title" style="margin-left:20px;font-family: Verdana, Geneva, Arial, Helvetica, sans-serif;">Login to your account</h3>
            </div><br/>
            <form class="form-vertical" method="post" action="login1">
                
                <div class="row" >
                    <div class="col-md-12">
                        <div class="col-md-1"></div>
                        <div class="col-md-10">
                            <div class="form-group">
                                <div class="icon-addon addon-md">
                                    <input type="text" placeholder="Username" class="form-control login_txt" name="username">
                                    <label for="email" class="glyphicon glyphicon-user"  ></label>
                                    
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="icon-addon addon-md">
                                    <input type="password" placeholder="Password" class="form-control login_txt" name="password">
                                    <label for="password" class="glyphicon glyphicon-lock"  ></label>
                                </div>
                            </div>
                            
                            <div class="form-group">
                                <button style="outline:none;" class="btn btn-success btn-block" type="submit" id="login_btn" name="submit"><i class="glyphicon glyphicon-log-in"></i> Login</button>
                            </div>
                        </div>
                        <div class="col-md-1"></div>
                    </div>
                </div>
                
                <hr>
                <div class="row">
                    <div class="col-md-1"></div>
                    <div class="col-md-10" style="padding-right: 30px;">
                        <p style="font-size:14px;padding-left:10px;font-family:Verdana, Geneva, Arial, Helvetica, sans-serif;">
                            <a href="#" class="pull-left"> Forgot password? </a>
                            <a href="Applicants/UserRegistrationb.jsp" class="pull-right"> Sign Up </a>
                        </p>
                    </div>
                    <div class="col-md-1"></div>
                </div>
            </form>
        </div>
        <script type="text/javascript" src="js/jquery.js"></script>
        <script src="js/bootstrap/dist/js/bootstrap.min.js"></script>
        <script src="js/login.js"></script>
    </body>
</html>
