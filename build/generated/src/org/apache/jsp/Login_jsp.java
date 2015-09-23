package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import myproject.*;

public final class Login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Login</title>\n");
      out.write("        <link href=\"js/bootstrap/dist/css/bootstrap.css\" rel=\"stylesheet\" />\n");
      out.write("        <link href=\"css/login.css\" rel=\"stylesheet\" />\n");
      out.write("    </head>\n");
      out.write("    <body style=\"overflow-x: hidden;\">\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Header.jsp", out, false);
      out.write("\n");
      out.write("        <div id=\"container\">\n");
      out.write("        ");
if(request.getParameter("login")!=null){
        
         Common login=new Common();
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
         else{
      out.write("\n");
      out.write("            <div class=\"panel-heading\" style=\"background-color: #8391b9\">     \n");
      out.write("                <h3 class=\"panel-title alert alert-danger\" style=\"margin-left:20px;font-family: Verdana, Geneva, Arial, Helvetica, sans-serif;\"><span style=\"color: red;\">Wrong Login Credentials!!</span></h3>\n");
      out.write("            </div><br/>\n");
      out.write("            ");
}
        }else{
      out.write("\n");
      out.write("        <div class=\"panel-heading\" style=\"background-color: #8391b9\">     \n");
      out.write("            <h3 class=\"panel-title\" style=\"margin-left:20px;font-family: Verdana, Geneva, Arial, Helvetica, sans-serif;\">Login to your account</h3>\n");
      out.write("        </div><br/>\n");
      out.write("        ");
}
      out.write("\n");
      out.write("            <form class=\"form-vertical\" method=\"post\" action=\"\">\n");
      out.write("                \n");
      out.write("                <div class=\"row\" >\n");
      out.write("                    <div class=\"col-md-12\">\n");
      out.write("                        <div class=\"col-md-1\"></div>\n");
      out.write("                        <div class=\"col-md-10\">\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <div class=\"icon-addon addon-md\">\n");
      out.write("                                    <input type=\"text\" placeholder=\"Email\" class=\"form-control login_txt\" name=\"email\">\n");
      out.write("                                    <label for=\"email\" class=\"glyphicon glyphicon-envelope\"  ></label>\n");
      out.write("                                    \n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <div class=\"icon-addon addon-md\">\n");
      out.write("                                    <input type=\"password\" placeholder=\"Password\" class=\"form-control login_txt\" name=\"password\">\n");
      out.write("                                    <label for=\"password\" class=\"glyphicon glyphicon-lock\"  ></label>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            \n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <button style=\"outline:none;\" class=\"btn btn-success btn-block\" type=\"submit\" id=\"login_btn\" name=\"login\"><i class=\"glyphicon glyphicon-log-in\"></i> Login</button>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-md-1\"></div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                \n");
      out.write("                <hr>\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-md-1\"></div>\n");
      out.write("                    <div class=\"col-md-10\" style=\"padding-right: 30px;\">\n");
      out.write("                        <p style=\"font-size:14px;padding-left:10px;font-family:Verdana, Geneva, Arial, Helvetica, sans-serif;\">\n");
      out.write("                            <a href=\"#\" class=\"pull-left\"> Forgot password? </a>\n");
      out.write("                            <a href=\"Applicants/UserRegistrationb.jsp\" class=\"pull-right\"> Sign Up </a>\n");
      out.write("                        </p>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-md-1\"></div>\n");
      out.write("                </div>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("        <script type=\"text/javascript\" src=\"js/jquery.js\"></script>\n");
      out.write("        <script src=\"js/bootstrap/dist/js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"js/login.js\"></script>\n");
      out.write("    </body>\n");
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
