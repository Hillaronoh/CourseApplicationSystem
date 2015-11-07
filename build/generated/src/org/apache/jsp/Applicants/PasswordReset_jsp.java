package org.apache.jsp.Applicants;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import myproject.*;

public final class PasswordReset_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Change Password</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"mycss/glyphicons/css/bootstrap.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" style type=\"text/css\" href=\"mycss/navMenus.css\">\n");
      out.write("        <!-- Core CSS - Include with every page -->\n");
      out.write("        <link href=\"assets/plugins/bootstrap/bootstrap.css\" rel=\"stylesheet\" />\n");
      out.write("        <link href=\"assets/font-awesome/css/font-awesome.css\" rel=\"stylesheet\" />\n");
      out.write("        <link href=\"assets/plugins/pace/pace-theme-big-counter.css\" rel=\"stylesheet\" />\n");
      out.write("        <link href=\"assets/css/style.css\" rel=\"stylesheet\" />\n");
      out.write("        <link href=\"assets/css/main-style.css\" rel=\"stylesheet\" />\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"mycss/style2.css\">\n");
      out.write("        <style type=\"text/css\">\n");
      out.write("            .separator {\n");
      out.write("                border-right: 1px solid #dfdfe0; \n");
      out.write("            }\n");
      out.write("            .icon-btn-save {\n");
      out.write("                padding-top: 0;\n");
      out.write("                padding-bottom: 0;\n");
      out.write("            }\n");
      out.write("            .input-group {\n");
      out.write("                margin-bottom:10px; \n");
      out.write("            }\n");
      out.write("            .btn-save-label {\n");
      out.write("                position: relative;\n");
      out.write("                left: -12px;\n");
      out.write("                display: inline-block;\n");
      out.write("                padding: 6px 12px;\n");
      out.write("                background: rgba(0,0,0,0.15);\n");
      out.write("                border-radius: 3px 0 0 3px;\n");
      out.write("            }\n");
      out.write("            .error{\n");
      out.write("                color: red;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body style=\"overflow-x: hidden; background-color: #EFEEEE;\">\n");
      out.write("     ");
Applicant user=new Applicant();
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Header.jsp", out, false);
      out.write("\n");
      out.write("        <div class=\"container\">\n");
      out.write("            \n");
      out.write("            <div class=\"row1\" style=\"margin-top: 0px;\">\n");
      out.write("                \n");
      out.write("                <div class=\"col-md-4 col-md-offset-4\" style=\"width: 1082px; margin-left: 43px;\">\n");
      out.write("                    \n");
      out.write("                    <div class=\"login-panel panel panel-default\"> \n");
      out.write("                        <!--start navigation menus-->\n");
      out.write("                        <div id=\"navMenu\" style=\"margin-top: 2px;\">\n");
      out.write("                            <ul>\n");
      out.write("                                <li><a href=\"UserAccount.jsp\"><button class=\"btn btn-info\" style=\"width: 148px; height: 38px; padding-top: 0px; margin-top: -5px;\"><i class=\"fa fa-home\"></i>Home</button></a>\n");
      out.write("                                </li>\n");
      out.write("                            </ul>\n");
      out.write("                            <ul>\n");
      out.write("                                <li><a href=\"#\"><button class=\"btn btn-info\" style=\"width: 148px; height: 38px; padding-top: 0px; margin-top: -5px;\"><i class=\"fa fa-arrow-down\"></i>Apply Course</button></a>\n");
      out.write("                                    <ul>\n");
      out.write("                                        <li><a href=\"ApplicationForm.jsp\">Under Graduate</a></li>\n");
      out.write("                                        <li><a href=\"#\">Post Graduate</a></li>\n");
      out.write("                                    </ul>\n");
      out.write("                                </li>\n");
      out.write("                            </ul>\n");
      out.write("                            <ul>\n");
      out.write("                                <li><a href=\"Announcements.jsp\"><button class=\"btn btn-info\" style=\"width: 148px; height: 38px; padding-top: 0px; margin-top: -5px;\"><i class=\"fa fa-bell\"></i>Announcements</button></a>\n");
      out.write("                                    \n");
      out.write("                                </li>\n");
      out.write("                            </ul>\n");
      out.write("                            <ul>\n");
      out.write("                                <li><a href=\"Details.jsp\"><button class=\"btn btn-info\" style=\"width: 148px; height: 38px; padding-top: 0px; margin-top: -5px;\"><i class=\"fa fa-archive\"></i>My Details</button></a>     \n");
      out.write("                                </li>\n");
      out.write("                            </ul>\n");
      out.write("                            <ul>\n");
      out.write("                                <li><a href=\"Messaging.jsp\"><button class=\"btn btn-info\" style=\"width: 148px; height: 38px; padding-top: 0px; margin-top: -5px;\"><i class=\"fa fa-inbox\"></i>Inquiries</button></a>\n");
      out.write("                                    \n");
      out.write("                                </li>\n");
      out.write("                            </ul>\n");
      out.write("                            <ul>\n");
      out.write("                                <li><a href=\"#ApplicationStatus\" data-toggle=\"modal\"><button class=\"btn btn-info\" style=\"width: 148px; height: 38px; padding-top: 0px; margin-top: -5px;\"><i class=\"fa fa-star\"></i>Application Status</button></a>\n");
      out.write("                                </li>\n");
      out.write("                            </ul>\n");
      out.write("                            <ul>\n");
      out.write("                                <li><a href=\"#\"><button class=\"btn btn-info\" style=\"width: 148px; height: 38px; padding-top: 0px; margin-top: -5px; background-color: #428BCA;\"><i class=\"fa fa-user\"></i></button></a>\n");
      out.write("                                    <ul>\n");
      out.write("                                        <li><a href=\"#\"><i class=\"fa fa-dropbox\"></i>Change Password</a></li>\n");
      out.write("                                        <li><a href=\"UserLogout.jsp\"><i class=\"fa fa-sign-out\"></i>Logout</a></li>\n");
      out.write("                                    </ul>\n");
      out.write("                                </li>\n");
      out.write("                            </ul>\n");
      out.write("                            \n");
      out.write("                        </div>\n");
      out.write("                        <!--end navigation menus-->\n");
      out.write("                        \n");
      out.write("                        <div class=\"panel-body\" style=\"padding-left:170px;\">\n");
      out.write("                            <form action=\"\" method=\"post\" id=\"myForm4\"> \n");
      out.write("                                <div class=\"row\">\n");
      out.write("                                    <div class=\"col-xs-12 col-sm-12 col-md-6 col-md-offset-2\">\n");
      out.write("                                        <div class=\"panel panel-primary\"  style=\"margin-top:20px;\">\n");
      out.write("                                            ");

                                            String oldPwd=new String();
                                            String newPwd=new String();
                                            if(request.getParameter("save")!=null){
                                                oldPwd=request.getParameter("oldPwd"); 
                                                newPwd=request.getParameter("password1");
                                            
                                            int results2=user.changePwd(newPwd, "kip", oldPwd);
                                            if(results2>0){
      out.write("\n");
      out.write("                                            <div class=\"panel-heading\">\n");
      out.write("                                                <h3 class=\"panel-title alert alert-success\" style=\"color: #5CB85C;\">\n");
      out.write("                                                    <i class=\"fa fa-check-circle\"></i>\n");
      out.write("                                                    Your password has been changed successfully  \n");
      out.write("                                                </h3>\n");
      out.write("                                            </div>\n");
      out.write("                                            ");
} else{
      out.write("\n");
      out.write("                                            <div class=\"panel-heading\">\n");
      out.write("                                                <h3 class=\"panel-title alert alert-danger\" style=\"color: #e86b5a;\">\n");
      out.write("                                                    <i class=\"fa fa-exclamation-triangle\"></i>\n");
      out.write("                                                    An error occurred..Please try again.  \n");
      out.write("                                                </h3>\n");
      out.write("                                            </div>\n");
      out.write("                                            ");
}} else{
      out.write("\n");
      out.write("                                            <div class=\"panel-heading\">\n");
      out.write("                                                <h3 class=\"panel-title\">\n");
      out.write("                                                    <i class=\"fa fa-th\"></i>\n");
      out.write("                                                    Change password  \n");
      out.write("                                                </h3>\n");
      out.write("                                            </div>\n");
      out.write("                                            ");
}
      out.write("\n");
      out.write("                                            <div class=\"panel-body\">\n");
      out.write("                                                \n");
      out.write("                                                <div class=\"row\">\n");
      out.write("                                                    <div style=\"margin-top:40px; padding-left: 50px;\" class=\"col-xs-11 col-sm-11 col-md-11 \">\n");
      out.write("                                                        \n");
      out.write("                                                        <div class=\"form-group\">\n");
      out.write("                                                            <div class=\"input-group\">\n");
      out.write("                                                                <div class=\"input-group-addon\"><i class=\"fa fa-lock\"></i></div>    \n");
      out.write("                                                                <input class=\"form-control\" type=\"password\" placeholder=\"New Password\" name=\"password1\" id=\"password1\">\n");
      out.write("                                                            </div>\n");
      out.write("                                                        </div>\n");
      out.write("                                                        <div class=\"form-group\">\n");
      out.write("                                                            <div class=\"input-group\">\n");
      out.write("                                                                <div class=\"input-group-addon\"><i class=\"fa fa-check-circle\"></i></div>\n");
      out.write("                                                                <input class=\"form-control\" type=\"password\" placeholder=\"Confirm New Password\" name=\"password2\" id=\"password2\">\n");
      out.write("                                                            </div>\n");
      out.write("                                                        </div>\n");
      out.write("                                                    </div>\n");
      out.write("                                                </div>\n");
      out.write("                                                \n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"panel-footer\">\n");
      out.write("                                                <div class=\"row\">\n");
      out.write("                                                    \n");
      out.write("                                                    <div class=\"col-xs-6 col-sm-6 col-md-6\" style=\"padding-left: 70px;\">\n");
      out.write("                                                        <button class=\"btn icon-btn-save btn-success\" type=\"submit\" name=\"save\">\n");
      out.write("                                                            <span class=\"btn-save-label\"><i class=\"fa fa-thumbs-o-up\"></i></span>Save</button>\n");
      out.write("                                                    </div>\n");
      out.write("                                                    <div class=\"col-xs-6 col-sm-6 col-md-6\"> <button class=\"btn icon-btn-save btn-success\" type=\"reset\">\n");
      out.write("                                                            <span class=\"btn-save-label\"><i class=\"fa fa-repeat\"></i></span>Reset</button></div>\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </form>\n");
      out.write("                        </div>\n");
      out.write("                        \n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        <script type=\"text/javascript\" src=\"mycss/modal/jquery.minCust.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"mycss/modal/bootstrapJsCust.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"mycss/validation/jquery.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"mycss/validation/jquery.validate.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"mycss/validation/additional-methods.js\"></script>\n");
      out.write("        <script src=\"mycss/validation/custom.js\"></script>\n");
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
