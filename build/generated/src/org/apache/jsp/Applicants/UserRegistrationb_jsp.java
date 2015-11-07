package org.apache.jsp.Applicants;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import myproject.*;
import javax.crypto.SecretKey;

public final class UserRegistrationb_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write(" \n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <title>User Registration</title>\n");
      out.write("        <!-- Core CSS - Include with every page -->\n");
      out.write("        <link href=\"assets/plugins/bootstrap/bootstrap.css\" rel=\"stylesheet\" />\n");
      out.write("        <link href=\"assets/font-awesome/css/font-awesome.css\" rel=\"stylesheet\" />\n");
      out.write("        <link href=\"assets/plugins/pace/pace-theme-big-counter.css\" rel=\"stylesheet\" />\n");
      out.write("        <link href=\"assets/css/style.css\" rel=\"stylesheet\" />\n");
      out.write("        <link href=\"assets/css/main-style.css\" rel=\"stylesheet\" />\n");
      out.write("        <link rel=\"stylesheet\" href=\"mycss/style2.css\" style type=\"text/css\">\n");
      out.write("            \n");
      out.write("        <link rel=\"stylesheet\" href=\"layout/bootstrap/css/bootstrap.css\" type=\"text/css\">\n");
      out.write("        <script type=\"text/javascript\" src=\"mycss/validate.js\"></script>\n");
      out.write("        <style>\n");
      out.write("            .error{\n");
      out.write("                color: red;\n");
      out.write("            }\n");
      out.write("            .login-panel{\n");
      out.write("                margin-top: 19%;\n");
      out.write("                width: 90%;\n");
      out.write("                margin-left: 6%;\n");
      out.write("                height: 350px;\n");
      out.write("            }\n");
      out.write("           \n");
      out.write("            .strength_meter{\n");
      out.write("                //position: relative;\n");
      out.write("                left: 0px;\n");
      out.write("                margin-top: -30px;\n");
      out.write("                width: 100%;\n");
      out.write("                height: 2px;\n");
      out.write("                z-index:-1;\n");
      out.write("                border-radius:5px;\n");
      out.write("                padding-right:13px;\n");
      out.write("            }\n");
      out.write("            .button_strength {\n");
      out.write("                text-decoration: none;\n");
      out.write("                color: white;\n");
      out.write("                font-size: 10px;\n");
      out.write("            }\n");
      out.write("            .strength_meter div{\n");
      out.write("                width:0%;\n");
      out.write("                height: 15px;\n");
      out.write("                text-align: right;\n");
      out.write("                color: #000;\n");
      out.write("                line-height: 43px;\n");
      out.write("                -webkit-transition: all .3s ease-in-out;\n");
      out.write("                -moz-transition: all .3s ease-in-out;\n");
      out.write("                -o-transition: all .3s ease-in-out;\n");
      out.write("                -ms-transition: all .3s ease-in-out;\n");
      out.write("                transition: all .3s ease-in-out;\n");
      out.write("                \n");
      out.write("                border-radius:5px;\n");
      out.write("            }\n");
      out.write("            .strength_meter div p{\n");
      out.write("                position: absolute;\n");
      out.write("                top: 50px;\n");
      out.write("                right: 0px;\n");
      out.write("                color: red;\n");
      out.write("                font-size:13px;\n");
      out.write("            }\n");
      out.write("                \n");
      out.write("            .veryweak{\n");
      out.write("                background-color: #FFA0A0;\n");
      out.write("                border-color: #F04040!important;\n");
      out.write("                width:25%!important;\n");
      out.write("            }\n");
      out.write("            .weak{\n");
      out.write("                background-color: #FFB78C;\n");
      out.write("                border-color: #FF853C!important;\n");
      out.write("                width:50%!important;\n");
      out.write("            }\n");
      out.write("            .medium{\n");
      out.write("                background-color: #FFEC8B;\n");
      out.write("                border-color: #FC0!important;\n");
      out.write("                width:75%!important;\n");
      out.write("            }\n");
      out.write("            .strong{\n");
      out.write("                background-color: #C3FF88;\n");
      out.write("                border-color: #8DFF1C!important;\n");
      out.write("                width:100%!important;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body style=\"overflow-x: hidden; background-color: #EFEEEE;\"> \n");
      out.write("        \n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Header.jsp", out, false);
      out.write("\n");
      out.write("            \n");
      out.write("        <div class=\"container\">\n");
      out.write("            \n");
      out.write("            <div class=\"login-panel panel panel-default\">\n");
      out.write("   \n");
      out.write("           ");
 Applicant applicant=new Applicant();
            String key=applicant.keyGen();
            String key2=applicant.keyGen2();
            if(request.getParameter("register")!=null){                 
            String fname=request.getParameter("fname");
            String mname=request.getParameter("mname");
            String lname=request.getParameter("lname");
            String email=request.getParameter("email");
            String pwd=request.getParameter("password1");
            int roleId=2;
    
            ResultSet results1=applicant.checkIfRegistered(email);
            //int results2=applicant.setUsers(fname, mname, lname, email, pwd, roleId);
    
            if(results1.next()){
      out.write("\n");
      out.write("            <div class=\"panel-heading\">\n");
      out.write("                <h3 class=\"panel-title alert alert-danger alert-block\" style=\"text-align: center;\"><span style=\"color: red;\">Email You Provided is Already Registered!!</span></h3>\n");
      out.write("            </div> \n");
      out.write("            ");
 }
            else{
                applicant.sendMail(email, key, key2);
                int tempUser=applicant.insertTempUser(fname, mname, lname, email, pwd, key); 
                if(tempUser>0){
      out.write("\n");
      out.write("                <div class=\"panel-heading\">\n");
      out.write("                    <h3 class=\"panel-title alert alert-success alert-block\" style=\"text-align: center;\"><span style=\"color: green;\">Account Activation link has been sent to ");
      out.print(email);
      out.write("</span></h3>\n");
      out.write("                </div> \n");
      out.write("                ");
 }
                else{
      out.write("\n");
      out.write("                <div class=\"panel-heading\">\n");
      out.write("                    <h3 class=\"panel-title alert alert-error alert-block\" style=\"text-align: center;\"><span style=\"color: red;\">Server is Down!!</span></h3>\n");
      out.write("                </div> \n");
      out.write("                ");
 }
            }
        }
        else{
        
      out.write("\n");
      out.write("        <div class=\"panel-heading\">\n");
      out.write("            <h3 class=\"panel-title\" style=\"text-align: center;\">Welcome New User! Sign Up Below.</h3>\n");
      out.write("        </div>\n");
      out.write("        ");
}
      out.write(" \n");
      out.write("        <div class=\"panel-body\" style=\"padding-left: 3%;\">\n");
      out.write("            \n");
      out.write("            <form name=\"registration\" method=\"post\" action=\"\" id=\"myForm4\" onsubmit=\"return validateForm(this)\"><br>\n");
      out.write("                \n");
      out.write("                <fieldset>\n");
      out.write("                    \n");
      out.write("                    <div class=\"row\" id=\"firstNameRow\">     \n");
      out.write("                        <div class=\"form-group col-sm-4\">\n");
      out.write("                            <label for=\"fname\">First Name:<span style=\"color:red\"> *</span></label>\n");
      out.write("                            <input type=\"text\" class=\"form-control input\" id=\"fname\" name=\"fname\" placeholder=\"First Name\"/>\n");
      out.write("                        </div>\n");
      out.write("                            \n");
      out.write("                        <div class=\"form-group col-sm-4\">\n");
      out.write("                            <label for=\"mname\">Middle Name:</label>\n");
      out.write("                            <input type=\"text\" class=\"form-control input\" id=\"mname\" name=\"mname\" placeholder=\"Middle Name\"/>\n");
      out.write("                        </div>\n");
      out.write("                            \n");
      out.write("                        <div class=\"form-group col-sm-4\">\n");
      out.write("                            <label for=\"lname\">Last Name:<span style=\"color:red\"> *</span></label>\n");
      out.write("                            <input type=\"text\" class=\"form-control input\" id=\"lname\" name=\"lname\" placeholder=\"Last Name\"/>\n");
      out.write("                        </div>    \n");
      out.write("                    </div>\n");
      out.write("                        \n");
      out.write("                    <div class=\"row\" id=\"emailRow\">    \n");
      out.write("                        <div class=\"form-group col-sm-4\">\n");
      out.write("                            <label for=\"email\">Email Address:<span style=\"color:red\"> *</span></label>\n");
      out.write("                            <input type=\"text\" class=\"form-control input\" id=\"email\" name=\"email\" placeholder=\"Email Address\"/>\n");
      out.write("                        </div>\n");
      out.write("                            \n");
      out.write("                        <div class=\"form-group col-sm-4\">\n");
      out.write("                            <label for=\"password1\">Password:<span style=\"color:red\"> *</span></label>\n");
      out.write("                            <input type=\"password\" class=\"form-control input\" id=\"password1\" name=\"password1\" placeholder=\"Password\"/>\n");
      out.write("                        </div>\n");
      out.write("                            \n");
      out.write("                        <div class=\"form-group col-sm-4\">\n");
      out.write("                            <label for=\"password2\">Confirm Password:<span style=\"color:red\"> *</span></label>\n");
      out.write("                            <input type=\"password\" class=\"form-control input\" id=\"password2\" name=\"password2\" placeholder=\"Confirm Password\"/>\n");
      out.write("                        </div>        \n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"row\" style=\"height:4px;\"></div>\n");
      out.write("                    <div class=\"row\" id=\"buttons1\">\n");
      out.write("                        <div class=\"col-sm-3\"></div>\n");
      out.write("                        <div class=\"form-group col-sm-3\">\n");
      out.write("                            <button type=\"submit\" name=\"register\" class=\"btn btn-success\" style=\"width: 150px;\">Submit</button>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group col-sm-3\">\n");
      out.write("                            <button type=\"reset\" name=\"reset\" class=\"btn btn-info pull-right\" style=\"width: 150px;\">Reset</button>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-sm-3\"></div>\n");
      out.write("                    </div>\n");
      out.write("                  \n");
      out.write("                </fieldset>\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    \n");
      out.write("                    <div class=\"col-sm-3\">\n");
      out.write("                        <div class=\"pull-left\"><a href=\"../index.jsp\"><button type=\"button\" class=\"btn btn-info btn-sm\"><i class=\"fa fa-backward\">Back</i></button></a></div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-sm-9\"></div>\n");
      out.write("                </div>\n");
      out.write("            </form>\n");
      out.write("                \n");
      out.write("        </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("        \n");
      out.write("    <!-- Core Scripts - Include with every page -->\n");
      out.write("    <script src=\"assets/plugins/jquery-1.10.2.js\"></script>\n");
      out.write("    <script src=\"assets/plugins/bootstrap/bootstrap.min.js\"></script>\n");
      out.write("    <script src=\"assets/plugins/metisMenu/jquery.metisMenu.js\"></script>\n");
      out.write("    <script type=\"text/javascript\" src=\"mycss/validation/jquery.validate.js\"></script>\n");
      out.write("    <script type=\"text/javascript\" src=\"mycss/validation/additional-methods.js\"></script>\n");
      out.write("    <script src=\"mycss/validation/custom.js\"></script>\n");
      out.write("    <script type=\"text/javascript\" src=\"js/strength.js\"></script>\n");
      out.write("    <script type=\"text/javascript\" src=\"js/js.js\"></script>\n");
      out.write("    \n");
      out.write("    <script>\n");
      out.write("        $(document).ready(function($) {\n");
      out.write("            \n");
      out.write("            $('#password1').strength({\n");
      out.write("                strengthClass: 'strength',\n");
      out.write("                strengthMeterClass: 'strength_meter',\n");
      out.write("                strengthButtonClass: 'button_strength',\n");
      out.write("                strengthButtonText: 'Show Password',\n");
      out.write("                strengthButtonTextToggle: 'Hide Password'\n");
      out.write("            });\n");
      out.write("            \n");
      out.write("        });\n");
      out.write("    </script>\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
