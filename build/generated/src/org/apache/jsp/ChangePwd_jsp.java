package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class ChangePwd_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body style=\"overflow-x: hidden; background-color: #EFEEEE;\">\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
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
      out.write("                                <li><a href=\"UserAccount.jsp\"><button class=\"btn btn-info\" style=\"width: 148px; height: 38px; padding-top: 0px; margin-top: -5px;\"><span class=\"glyphicon glyphicon-home\"></span>Home</button></a>\n");
      out.write("                                </li>\n");
      out.write("                            </ul>\n");
      out.write("                            <ul>\n");
      out.write("                                <li><a href=\"#\"><button class=\"btn btn-info\" style=\"width: 148px; height: 38px; padding-top: 0px; margin-top: -5px;\"><span class=\"glyphicon glyphicon-arrow-down\"></span>Apply Course</button></a>\n");
      out.write("                                    <ul>\n");
      out.write("                                        <li><a href=\"ApplicationForm.jsp\">Under Graduate</a></li>\n");
      out.write("                                        <li><a href=\"#\">Post Graduate</a></li>\n");
      out.write("                                    </ul>\n");
      out.write("                                </li>\n");
      out.write("                            </ul>\n");
      out.write("                            <ul>\n");
      out.write("                                <li><a href=\"Announcements.jsp\"><button class=\"btn btn-info\" style=\"width: 148px; height: 38px; padding-top: 0px; margin-top: -5px;\"><span class=\"glyphicon glyphicon-new-window\"></span>Announcements</button></a>\n");
      out.write("                                    \n");
      out.write("                                </li>\n");
      out.write("                            </ul>\n");
      out.write("                            <ul>\n");
      out.write("                                <li><a href=\"Details.jsp\"><button class=\"btn btn-info\" style=\"width: 148px; height: 38px; padding-top: 0px; margin-top: -5px;\"><span class=\"glyphicon glyphicon-move\"></span>My Details</button></a>     \n");
      out.write("                                </li>\n");
      out.write("                            </ul>\n");
      out.write("                            <ul>\n");
      out.write("                                <li><a href=\"Messaging.jsp\"><button class=\"btn btn-info\" style=\"width: 148px; height: 38px; padding-top: 0px; margin-top: -5px;\"><span class=\"glyphicon glyphicon-inbox\"></span>Inquiries</button></a>\n");
      out.write("                                    \n");
      out.write("                                </li>\n");
      out.write("                            </ul>\n");
      out.write("                            <ul>\n");
      out.write("                                <li><a href=\"#ApplicationStatus\" data-toggle=\"modal\"><button class=\"btn btn-info\" style=\"width: 148px; height: 38px; padding-top: 0px; margin-top: -5px;\"><span class=\"glyphicon glyphicon-star\"></span>Application Status</button></a>\n");
      out.write("                                </li>\n");
      out.write("                            </ul>\n");
      out.write("                            <ul>\n");
      out.write("                                <li><a href=\"#\"><button class=\"btn btn-info\" style=\"width: 148px; height: 38px; padding-top: 0px; margin-top: -5px; background-color: #428BCA;\"><span class=\"glyphicon glyphicon-user\"></span>kip</button></a>\n");
      out.write("                                    <ul>\n");
      out.write("                                        <li><a href=\"#\"><span class=\"glyphicon glyphicon-cog\"></span>Change Password</a></li>\n");
      out.write("                                        <li><a href=\"UserLogout.jsp\"><span class=\"glyphicon glyphicon-log-out\"></span>Logout</a></li>\n");
      out.write("                                    </ul>\n");
      out.write("                                </li>\n");
      out.write("                            </ul>\n");
      out.write("                            \n");
      out.write("                        </div>\n");
      out.write("                        <!--end navigation menus-->\n");
      out.write("                        \n");
      out.write("                        <div class=\"panel-body\" style=\"padding-left:170px;\">\n");
      out.write("                            <form action=\"\"> \n");
      out.write("                                <div class=\"row\">\n");
      out.write("                                    <div class=\"col-xs-12 col-sm-12 col-md-6 col-md-offset-2\">\n");
      out.write("                                        <div class=\"panel panel-primary\"  style=\"margin-top:20px;\">\n");
      out.write("                                            <div class=\"panel-heading\">\n");
      out.write("                                                <h3 class=\"panel-title\">\n");
      out.write("                                                    <span class=\"glyphicon glyphicon-th\"></span>\n");
      out.write("                                                    Change password   \n");
      out.write("                                                </h3>\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"panel-body\">\n");
      out.write("                                                \n");
      out.write("                                                <div class=\"row\">\n");
      out.write("                                                    <div style=\"margin-top:40px; padding-left: 50px;\" class=\"col-xs-11 col-sm-11 col-md-11 \">\n");
      out.write("                                                        <div class=\"form-group\">\n");
      out.write("                                                            <div class=\"input-group\">\n");
      out.write("                                                                <div class=\"input-group-addon\"><span class=\"glyphicon glyphicon-lock\"></span></div>\n");
      out.write("                                                                <input class=\"form-control\" type=\"password\" placeholder=\"Current Password\">\n");
      out.write("                                                            </div>\n");
      out.write("                                                        </div>\n");
      out.write("                                                        <div class=\"form-group\">\n");
      out.write("                                                            <div class=\"input-group\">\n");
      out.write("                                                                <div class=\"input-group-addon\"><span class=\"glyphicon glyphicon-question-sign\"></span></div>\n");
      out.write("                                                                <input class=\"form-control\" type=\"password\" placeholder=\"New Password\">\n");
      out.write("                                                            </div>\n");
      out.write("                                                        </div>\n");
      out.write("                                                        <div class=\"form-group\">\n");
      out.write("                                                            <div class=\"input-group\">\n");
      out.write("                                                                <div class=\"input-group-addon\"><span class=\"glyphicon glyphicon-ok-sign\"></span></div>\n");
      out.write("                                                                <input class=\"form-control\" type=\"password\" placeholder=\"Confirm New Password\">\n");
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
      out.write("                                                        <button class=\"btn icon-btn-save btn-success\" type=\"submit\">\n");
      out.write("                                                            <span class=\"btn-save-label\"><i class=\"glyphicon glyphicon-thumbs-up\"></i></span>Save</button>\n");
      out.write("                                                    </div>\n");
      out.write("                                                    <div class=\"col-xs-6 col-sm-6 col-md-6\"> <button class=\"btn icon-btn-save btn-success\" type=\"reset\">\n");
      out.write("                                                            <span class=\"btn-save-label\"><i class=\"glyphicon glyphicon-remove\"></i></span>Reset</button></div>\n");
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
      out.write("        \n");
      out.write("        <script type=\"text/javascript\" src=\"mycss/modal/jquery.minCust.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"mycss/modal/bootstrapJsCust.js\"></script>\n");
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
