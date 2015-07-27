package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class ajaxconn_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <title>ajax trial</title>\n");
      out.write("    <link rel=\"stylesheet\" href=\"mycss/glyphicons/css/bootstrap.min.css\">\n");
      out.write("    <!-- Core CSS - Include with every page -->\n");
      out.write("    <link href=\"assets/plugins/bootstrap/bootstrap.css\" rel=\"stylesheet\" />\n");
      out.write("    <link href=\"assets/font-awesome/css/font-awesome.css\" rel=\"stylesheet\" />\n");
      out.write("    <link href=\"assets/plugins/pace/pace-theme-big-counter.css\" rel=\"stylesheet\" />\n");
      out.write("    <link href=\"assets/css/style.css\" rel=\"stylesheet\" />\n");
      out.write("    <link href=\"assets/css/main-style.css\" rel=\"stylesheet\" />   \n");
      out.write("</head>\n");
      out.write("<body style=\"overflow-x: hidden; background-color: #EFEEEE;\"> \n");
      out.write("    \n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Header.jsp", out, false);
      out.write("\n");
      out.write("    \n");
      out.write("    <div class=\"container\">\n");
      out.write("      \n");
      out.write("        <div class=\"row1\">\n");
      out.write("            \n");
      out.write("            <div class=\"col-md-3 col-md-offset-3\">\n");
      out.write("\t\t\t\n");
      out.write("                <div class=\"login-panel panel panel-default\"> \n");
      out.write("            \n");
      out.write("    \n");
      out.write("    \n");
      out.write("\n");
      out.write("     <div class=\"panel-heading\" id=\"result\">\n");
      out.write("         Please Sign In\n");
      out.write("     </div>\n");
      out.write("    \n");
      out.write("       <div class=\"panel-body2\">\n");
      out.write("                        \n");
      out.write("           <form role=\"form\" method=\"post\" action=\"UserLoginProcessor.jsp\" id=\"myForm\">\n");
      out.write("               <fieldset>\n");
      out.write("                   <div class=\"form-group\">\n");
      out.write("                      <div class=\"input-group\">\n");
      out.write("                          <div class=\"input-group-addon\"><i class=\"fa fa-envelope\"></i></div>\n");
      out.write("                          <input class=\"form-control\" type=\"email\" placeholder=\"Email\" name=\"email\" autocomplete=\"off\" autofocus>\n");
      out.write("                      </div>\n");
      out.write("                   </div>\n");
      out.write("                   <div class=\"form-group\">\n");
      out.write("                       <div class=\"input-group\">\n");
      out.write("                           <div class=\"input-group-addon\"><i class=\"fa fa-lock\"></i></div>\n");
      out.write("                           <input class=\"form-control\" type=\"password\" placeholder=\"Password\" name=\"password\">\n");
      out.write("                       </div>\n");
      out.write("                   </div>\n");
      out.write("                   <div class=\"checkbox\">\n");
      out.write("                       <label>\n");
      out.write("                           <input name=\"remember\" type=\"checkbox\" value=\"Remember Me\">Remember Me\n");
      out.write("                       </label>\n");
      out.write("                   </div>\n");
      out.write("                   <!-- Change this to a button or input when using this as a form -->\n");
      out.write("                   <button class=\"btn btn-lg btn-success btn-block\" type=\"submit\" name=\"login\" id=\"sub\"><i class=\"fa fa-sign-in\"></i> Login</button>\n");
      out.write("                \n");
      out.write("               </fieldset>\n");
      out.write("           </form>\n");
      out.write("           <br>\n");
      out.write("           <p><a href=\"\">Forgot Password?</a> &nbsp;&nbsp;&nbsp;<a href=\"UserRegistrationb.jsp\" style=\"float: right;\">Sign Up Here</a>\n");
      out.write("       </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("     <!-- Core Scripts - Include with every page -->\n");
      out.write("    <script src=\"assets/plugins/jquery-1.10.2.js\"></script>\n");
      out.write("    <script src=\"assets/plugins/bootstrap/bootstrap.min.js\"></script>\n");
      out.write("    <script src=\"assets/plugins/metisMenu/jquery.metisMenu.js\"></script>\n");
      out.write("    <script src=\"mycss/js/jquery-1.8.1.min.js\"></script>\n");
      out.write("    <script src=\"mycss/js/myScript.js\"></script>\n");
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
