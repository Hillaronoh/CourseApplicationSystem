package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class newjsp_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<script>\n");
      out.write("function dateDiff(dateform) {\n");
      out.write("date1 = new Date();\n");
      out.write("date2 = new Date();\n");
      out.write("diff  = new Date();\n");
      out.write("\n");
      out.write("date1temp = new Date(dateform.firstdate.value);\n");
      out.write("date1.setTime(date1temp.getTime());\n");
      out.write("\n");
      out.write("date2temp = new Date(dateform.seconddate.value);\n");
      out.write("date2.setTime(date2temp.getTime());\n");
      out.write("diff.setTime(Math.abs(date1.getTime() - date2.getTime()));\n");
      out.write("\n");
      out.write("timediff = diff.getTime();\n");
      out.write("days = Math.floor(timediff / (1000 * 60 * 60 * 24)); \n");
      out.write("dateform.difference.value = days;\n");
      out.write("return false; \n");
      out.write("}\n");
      out.write("</script>\n");
      out.write("</head>\n");
      out.write("<form onSubmit=\"return dateDiff(this);\">\n");
      out.write("<pre>\n");
      out.write("First Date(MM/DD/YYYY):     <input type=text name=firstdate>   \n");
      out.write("\n");
      out.write("Second Date(MM/DD/YYYY):    <input type=text name=seconddate> \n");
      out.write("\n");
      out.write("Date Difference (in days):  <input type=text name=difference>\n");
      out.write("\n");
      out.write("                            <input type=submit value=\"Calculate Difference!\">\n");
      out.write("\n");
      out.write("</pre>\n");
      out.write("</form>\n");
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
