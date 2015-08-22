package org.apache.jsp.Applicants;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import myproject.*;

public final class del_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <title>kip</title>\n");
      out.write("    <script type=\"text/javascript\" src=\"mycss/modal/jquery.minCust.js\"></script>\n");
      out.write("            <script type=\"text/javascript\" src=\"mycss/modal/bootstrapJsCust.js\"></script>\n");
      out.write("            <script type=\"text/javascript\" src=\"mycss/validation/jquery.js\"></script>\n");
      out.write("            <script type=\"text/javascript\" src=\"mycss/validation/jquery.validate.js\"></script>\n");
      out.write("            <script type=\"text/javascript\" src=\"mycss/validation/additional-methods.js\"></script>\n");
      out.write("            <script src=\"mycss/validation/custom.js\"></script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<dialog id=\"window\">  \n");
      out.write("    <h3>Sample Dialog!</h3>  \n");
      out.write("    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Earum, inventore!</p>  \n");
      out.write("    <button id=\"exit\">Close Dialog </button> \n");
      out.write("    <button id=\"show\">Show Dialog</button>  \n");
      out.write("</dialog> \n");
      out.write("<script>\n");
      out.write("    (function() {  \n");
      out.write("    var dialog = document.getElementById('window');  \n");
      out.write("    document.getElementById('show').onclick = function() {  \n");
      out.write("        dialog.show();  \n");
      out.write("    };  \n");
      out.write("    document.getElementById('exit').onclick = function() {  \n");
      out.write("        dialog.close();  \n");
      out.write("    };  \n");
      out.write("})();\n");
      out.write("</script>\n");
      out.write("</body>\n");
      out.write("</html>");
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
