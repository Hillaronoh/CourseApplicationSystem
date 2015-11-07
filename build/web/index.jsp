<%-- 
    Document   : Login
    Created on : Aug 4, 2015, 11:38:14 AM
    Author     : hillary
--%>
<%@page import="java.sql.*" %>
<%@page import="myproject.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link href="js/bootstrap/dist/css/bootstrap.css" rel="stylesheet" />
        <link href="css/login.css" rel="stylesheet" />
        <script type = "text/javascript" >
            function disableBackButton()
            {
                window.history.forward();
            }
            setTimeout("disableBackButton()", 0);
        </script>
        <style>
            .error{
                color: red;
               }
        </style>
    </head>
    <body style="overflow-x: hidden;" onunload="disableBackButton()">
        
        <jsp:include page="Header.jsp"></jsp:include>
        <div id="container">
        <%Common login=new Common();
            Applicant applicant=new Applicant();
         String key=request.getParameter("u"); 
         if(key!=null){
        ResultSet checkKey=applicant.getKey(key);
        if(checkKey.next()){
           String fName=checkKey.getString("First_Name");
           String mName=checkKey.getString("Middle_Name");
           String lName=checkKey.getString("Last_Name");
           String email=checkKey.getString("Email_Address");
           String pwd=checkKey.getString("Password");
           int roleId=2;
           int insertion = applicant.insertTempUser(fName, mName, lName, email, pwd, roleId); 
           if(insertion>0){
               applicant.deleteTempUser(key); 
           }
        }
        else{%>
        <script>
            alert("Error Encountered: Key not found!\n Please try to log in...");
            window.location.href="index.jsp";
        </script>  
        <%}
        }
         String key2=applicant.keyGen2();
         if(request.getParameter("send")!=null){
             String email=request.getParameter("email");
             ResultSet checkMail=login.verifyEmail(email);
             if(checkMail.next()){
             applicant.sendMailPwd(email, key2);%>
             <script>
                 alert("check your email (<%=email%>) to reset your password.");
                 window.location.href="index.jsp";
             </script>
         <%} else{%>
               <script>
                 alert("Sorry Problem was encountered. Try later");
                 window.location.href="index.jsp";
             </script>  
             <%}
         }
            
         if(request.getParameter("login")!=null){
        
         
         int roleId=0;
         
         String email=request.getParameter("email");
         String password=request.getParameter("password");
         
         ResultSet results=login.login(email, password);
         
         if(results.next()){
             roleId=results.getInt("Role_id");
         }
         if(roleId==1){
            session.setAttribute("adminId", email);  
            response.sendRedirect("Admin/AdminPanel.jsp");
            }
         if(roleId==2){
            session.setAttribute("applicantId", email);  
            response.sendRedirect("Applicants/UserAccount.jsp");
         }
         else{%>
            <div class="panel-heading" style="background-color: #8391b9">     
                <h3 class="panel-title alert alert-danger" style="margin-left:20px;font-family: Verdana, Geneva, Arial, Helvetica, sans-serif;"><span style="color: red;">Wrong Login Credentials!!</span></h3>
            </div><br/>
            <%}
        }else{%>
        <div class="panel-heading" style="background-color: #8391b9">     
            <h3 class="panel-title" style="margin-left:20px;font-family: Verdana, Geneva, Arial, Helvetica, sans-serif;">Login to your account</h3>
        </div><br/>
        <%}%>
            <form class="form-vertical" method="post" id="myForm6" action="">
                
                <div class="row" >
                    <div class="col-md-12">
                        <div class="col-md-1"></div>
                        <div class="col-md-10">
                            <div class="form-group">
                                <div class="icon-addon addon-md">
                                    <input type="text" placeholder="Email" class="form-control login_txt" name="email">
                                    <label for="email" class="glyphicon glyphicon-envelope"  ></label>
                                    
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="icon-addon addon-md">
                                    <input type="password" placeholder="Password" class="form-control login_txt" name="password">
                                    <label for="password" class="glyphicon glyphicon-lock"  ></label>
                                </div>
                            </div>
                            
                            <div class="form-group">
                                <button style="outline:none;" class="btn btn-success btn-block" type="submit" id="login_btn" name="login"><i class="glyphicon glyphicon-log-in"></i> Login</button>
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
                            <a href="#forgotPwd" data-toggle="modal" class="pull-left"> Forgot password?</a> 
                            <a href="Applicants/UserRegistrationb.jsp" class="pull-right"> Sign Up </a>
                        </p>
                    </div>
                    <div class="col-md-1"></div>
                </div>
            </form>
        </div>
            
        <div class="modal fade" id="forgotPwd" role="dialog">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title">Password Reset</h4>
                    </div>
                    <form method="post" action="" id="myForm4">
                    <div class="modal-body">
                        <p>Enter your email to reset your password.</p>
                        <div class="form-group">
                                <label for="email">Email Address</label>
                                <input type="text" class="form-control" id="email" placeholder="Email Address" name="email">
                            </div>
                    </div>
                    <div class="well modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        <button type="submit" name="send" class="btn btn-primary">Send</button>
                    </div>
                    </form>
                </div>
            </div>
        </div>
        <script type="text/javascript" src="js/jquery.js"></script>
        <script src="js/bootstrap/dist/js/bootstrap.min.js"></script>
        <script src="js/login.js"></script>
        <script type="text/javascript" src="Applicants/mycss/validation/jquery.js"></script>
        <script type="text/javascript" src="Applicants/mycss/validation/jquery.validate.js"></script>
        <script type="text/javascript" src="Applicants/mycss/validation/additional-methods.js"></script>
        <script src="Applicants/mycss/validation/custom.js"></script>
    </body>
</html>
