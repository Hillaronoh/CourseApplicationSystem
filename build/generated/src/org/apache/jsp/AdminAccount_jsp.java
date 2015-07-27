package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class AdminAccount_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Applicant's Account</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"mycss/glyphicons/css/bootstrap.min.css\">\n");
      out.write("        <link href=\"assets/plugins/bootstrap/bootstrap.css\" rel=\"stylesheet\" />\n");
      out.write("        <link href=\"assets/font-awesome/css/font-awesome.css\" rel=\"stylesheet\" />\n");
      out.write("        <link href=\"assets/plugins/pace/pace-theme-big-counter.css\" rel=\"stylesheet\" />\n");
      out.write("        <link href=\"assets/css/style.css\" rel=\"stylesheet\" />\n");
      out.write("        <link href=\"assets/css/main-style.css\" rel=\"stylesheet\" />\n");
      out.write("        <link rel=\"stylesheet\" style type=\"text/css\" href=\"mycss/navMenus.css\">\n");
      out.write("    </head>\n");
      out.write("    <body style=\"overflow-x: hidden; background-color: #EFEEEE;\">\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Header.jsp", out, false);
      out.write("\n");
      out.write("        \n");
      out.write("        <div class=\"container\">\n");
      out.write("            \n");
      out.write("            <div class=\"row1\" style=\"margin-left: -58px; margin-top: -20px;\">\n");
      out.write("                \n");
      out.write("                <div class=\"col-md-4 col-md-offset-4\" style=\"width: 1052px; padding-right: 0px; padding-left: 0px\">\n");
      out.write("                    \n");
      out.write("                    <div class=\"login-panel panel panel-default\"> \n");
      out.write("                        \n");
      out.write("                        <div class=\"panel-heading\">\n");
      out.write("                            <h3 class=\"panel-title\">You are Logged in as Administrator</h3>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"panel-body\" style=\" height: 400px; padding: 0px;\">\n");
      out.write("                            \n");
      out.write("                            <div id=\"navMenu\" style=\"margin-top: 1px;\">\n");
      out.write("                                <ul>\n");
      out.write("                                    <li><a href=\"#\"><button class=\"btn btn-info\" style=\"width: 148px; height: 35px; padding-top: 0px; margin-top: -5px; background-color: #428BCA;\"><i class=\"fa fa-home\"></i>Home</button></a>\n");
      out.write("                                    </li>\n");
      out.write("                                </ul>\n");
      out.write("                                <ul>\n");
      out.write("                                    <li><a href=\"#\"><button class=\"btn btn-info\" style=\"width: 148px; height: 35px; padding-top: 0px; margin-top: -5px;\"><i class=\"fa fa-arrow-down\"></i>Apply Course</button></a>\n");
      out.write("                                        <ul>\n");
      out.write("                                            <li><a href=\"ApplicationForm.jsp\">Under Graduate</a></li>\n");
      out.write("                                            <li><a href=\"#\">Post Graduate</a></li>\n");
      out.write("                                        </ul>\n");
      out.write("                                    </li>\n");
      out.write("                                </ul>\n");
      out.write("                                <ul>\n");
      out.write("                                    <li><a href=\"Announcements.jsp\"><button class=\"btn btn-info\" style=\"width: 148px; height: 35px; padding-top: 0px; margin-top: -5px;\"><i class=\"fa fa-bell\"></i>Announcements</button></a>\n");
      out.write("                                        \n");
      out.write("                                    </li>\n");
      out.write("                                </ul>\n");
      out.write("                                <ul>\n");
      out.write("                                    <li><a href=\"Details.jsp\"><button class=\"btn btn-info\" style=\"width: 148px; height: 35px; padding-top: 0px; margin-top: -5px;\"><i class=\"fa fa-archive\"></i>My Details</button></a>\n");
      out.write("                                    </li>\n");
      out.write("                                </ul>\n");
      out.write("                                <ul>\n");
      out.write("                                    <li><a href=\"Messaging.jsp\"><button class=\"btn btn-info\" style=\"width: 148px; height: 35px; padding-top: 0px; margin-top: -5px;\"><i class=\"fa fa-inbox\"></i>Inquiries</button></a>\n");
      out.write("                                        \n");
      out.write("                                    </li>\n");
      out.write("                                </ul>\n");
      out.write("                                <ul>\n");
      out.write("                                    <li><a href=\"#ApplicationStatus\" data-toggle=\"modal\"><button class=\"btn btn-info\" style=\"width: 148px; height: 35px; padding-top: 0px; margin-top: -5px;\"><i class=\"fa fa-star\"></i>Application Status</button></a>\n");
      out.write("                                    </li>\n");
      out.write("                                </ul>\n");
      out.write("                                <ul>\n");
      out.write("                                    <li><a href=\"#\"><button class=\"btn btn-info\" style=\"width: 148px; height: 35px; padding-top: 0px; margin-top: -5px;\"><i class=\"fa fa-user\"></i>kip</button></a>\n");
      out.write("                                        <ul>\n");
      out.write("                                            <li><a href=\"ChangePwd.jsp\"><i class=\"fa fa-dropbox\"></i>Change Password</a></li>\n");
      out.write("                                            <li><a href=\"UserLogout.jsp\"><i class=\"fa fa-sign-out\"></i>Logout</a></li>\n");
      out.write("                                        </ul>\n");
      out.write("                                    </li>\n");
      out.write("                                </ul>\n");
      out.write("                                \n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"modal fade\" id=\"ApplicationStatus\" role=\"dialog\">\n");
      out.write("            <div class=\"modal-dialog\">\n");
      out.write("                <div class=\"modal-content\">\n");
      out.write("                    <div class=\"modal-header\">\n");
      out.write("                        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>\n");
      out.write("                        <h4 class=\"modal-title\">Application Status</h4>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"modal-body\">\n");
      out.write("                        <p>You successfully secured a placement in bachelor of science in computer science\n");
      out.write("                        </p>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"modal-footer\">\n");
      out.write("                        <button type=\"button\" class=\"btn btn-danger\" data-dismiss=\"modal\">close</button>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <script type=\"text/javascript\" src=\"mycss/modal/jquery.minCust.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"mycss/modal/bootstrapJsCust.js\"></script>\n");
      out.write("    </body> \n");
      out.write("</html> \n");
      out.write("\n");
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
