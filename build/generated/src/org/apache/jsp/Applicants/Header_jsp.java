package org.apache.jsp.Applicants;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Header_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Header</title>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"mycss/glyphicons/css/bootstrap.min.css\" style type=\"text/css\">\n");
      out.write("        <link rel=\"shortcut icon\" href=\"image/favicon.ico\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("  <!-- Navigation -->\n");
      out.write("    <nav class=\"navbar navbar-inverse \" role=\"navigation\" style=\"background-color: #456896;\">\n");
      out.write("        <!--<div class=\"container\" style=\" width:100% ;background-color:#456896;\">\n");
      out.write("            <!-- Brand and toggle get grouped for better mobile display -->\n");
      out.write("            <div class=\"row-fluid\" >\n");
      out.write("\t\t\t<form class=\"form-inline\" style=\"margin-left:83%; margin-bottom:-3%;color:white\"><input type=\"text\" style=\"background-color:white;\" class=\"form-control\" placeholder=\"Search\" name=\"search\"></form>\n");
      out.write("          <div class=\"col-sm-2\"></div>  \n");
      out.write("          <div class=\"col-sm-1 \" style=\"margin-top:0.5%; padding-bottom: 0.8%;\">   \n");
      out.write("          \t<img src=\"images/Logo.png\"  class=\" img-responsive \" height=\"100\" width=\"110\"/> \n");
      out.write("          \t</div>\n");
      out.write("            <div class=\"col-sm-6  text-uppercase\" style=\"color:white;\"> \n");
      out.write("            \t<h2>Matungu Sub County </h2>\n");
      out.write("            \t</div>\n");
      out.write("              <div class=\"col-sm-3 \" style=\"margin-top:4%;color:black;\">\n");
      out.write("              \t <a href=\"../news.php\" style=\"color:white;\">News</a>&nbsp; |<a href=\"../management.php\" style=\"color:white;\">Management</a>&nbsp; |<a href=\"http://www.walmit.co.ke/squirrelmail/src/login.php\" style=\"color:white;\">Staff Email</a>&nbsp; |</div>\n");
      out.write("         </div>\n");
      out.write("\n");
      out.write("   <div class=\"navbar\">\n");
      out.write("            <div class=\"navbar-header\">\n");
      out.write("\n");
      out.write("                <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\"#bs-example-navbar-collapse-1\">\n");
      out.write("                    <span class=\"sr-only\">Click To Select Links</span>\n");
      out.write("                    <span class=\"icon-bar\"></span>\n");
      out.write("                    <span class=\"icon-bar\"></span>\n");
      out.write("                    <span class=\"icon-bar\"></span>\n");
      out.write("                </button>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("            <!-- Collect the nav links, forms, and other content for toggling -->\n");
      out.write("            <div class=\"collapse navbar-collapse\"   id=\"bs-example-navbar-collapse-1\" style=\"margin-left: -2%; margin-right: -2%;\">\n");
      out.write("                <ul class=\"nav navbar-nav\" style=\"background-color:#004560; padding-left:17%; padding-right:10%; width: 100%;\">\n");
      out.write("                    <li class=\"active\">\n");
      out.write("                        <a href=\"index.php\">Home</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"dropdown\">\n");
      out.write("                        <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\"> About Us <b class=\"caret\"></b></a>\n");
      out.write("                        <ul class=\"dropdown-menu\" id=\"bg\">\n");
      out.write("                        <li><a href=\"history.php\"> History</a> </li>\n");
      out.write("                            <li><a href=\"mission.php\"> Mission</a> </li>\n");
      out.write("                                <li><a href=\"vision.php\"> Vision</a> </li>\n");
      out.write("                        </ul>\n");
      out.write("                    </li>\n");
      out.write("                  <li class=\"dropdown\">\n");
      out.write("                        <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\"> Governance <b class=\"caret\"></b></a>\n");
      out.write("                        <ul class=\"dropdown-menu\" id=\"bg\">\n");
      out.write("                        <li><a href=\"structure.php\"> Sub County Structure</a> </li>\n");
      out.write("                            <li><a href=\"executive.php\"> Sub County Executive </a> </li>\n");
      out.write("                                <li><a href=\"administrator.php\"> Office of Sub County Administrator</a> </li>\n");
      out.write("                        </ul>\n");
      out.write("                    </li>\n");
      out.write("\n");
      out.write("\n");
      out.write("                   <li class=\"dropdown\">\n");
      out.write("                        <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">Departments <b class=\"caret\"></b></a>\n");
      out.write("                        <ul class=\"dropdown-menu\" id=\"bg\">\n");
      out.write("                            <li>\n");
      out.write("                                       <a href=\"finance.php\">Finance</a>\n");
      out.write("                            </li>\n");
      out.write("                            <li>\n");
      out.write("                                       <a href=\"revenue.php\">Revenue </a>\n");
      out.write("                            </li>\n");
      out.write("                            <li>\n");
      out.write("                                      <a href=\"procurement.php\">Procurement </a>\n");
      out.write("                            </li>\n");
      out.write("                              <li>\n");
      out.write("                                       <a href=\"works.php\">Civil works </a>\n");
      out.write("                            </li>\n");
      out.write("                            <li>\n");
      out.write("                                       <a href=\"audit.php\">Audit </a>\n");
      out.write("                            </li>\n");
      out.write("                            <li>\n");
      out.write("                                       <a href=\"services.php\">Social Services </a>\n");
      out.write("                            </li>\n");
      out.write("                           \n");
      out.write("                        </ul>\n");
      out.write("                    </li>\n");
      out.write("\n");
      out.write("                    <li class=\"dropdown\">\n");
      out.write("                        <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\"> Projects <b class=\"caret\"></b></a>\n");
      out.write("                        <ul class=\"dropdown-menu\" id=\"bg\">\n");
      out.write("                        <li><a href=\"consruction.php\"> Well construction</a> </li>\n");
      out.write("                            <li><a href=\"distribution.php\"> Bicycle Distribution</a> </li>\n");
      out.write("                                \n");
      out.write("                        </ul>\n");
      out.write("                    </li>\n");
      out.write("\n");
      out.write("                    <li class=\"dropdown\">\n");
      out.write("                        <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">News & Events <b class=\"caret\"></b></a>\n");
      out.write("                        <ul class=\"dropdown-menu\" id=\"bg\">\n");
      out.write("                            <li>\n");
      out.write("                                       <a href=\"latest.php\">Latest News</a>\n");
      out.write("                            </li>\n");
      out.write("                            <li>\n");
      out.write("                                       <a href=\"upcoming.php\">Upcoming Events </a>\n");
      out.write("                            </li>\n");
      out.write("                            <li>\n");
      out.write("                                      <a href=\"photos.php\">Photo Gallery </a>\n");
      out.write("                            </li>\n");
      out.write("                             \n");
      out.write("                        </ul>\n");
      out.write("                    </li>\n");
      out.write("                       <li>\n");
      out.write("                        <a href=\"tender.php\">Tenders </a>\n");
      out.write("                    </li>\n");
      out.write("\n");
      out.write("\n");
      out.write("                     <li>\n");
      out.write("                        <a href=\"downloads.php\">Downloads</a>\n");
      out.write("                    </li>\n");
      out.write("\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("            <!-- /.navbar-collapse -->\n");
      out.write("       <!-- </div>\n");
      out.write("        <!-- /.container -->\n");
      out.write("    </nav>\n");
      out.write("    </body> \n");
      out.write("   \n");
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
