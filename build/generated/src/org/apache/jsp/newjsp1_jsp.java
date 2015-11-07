package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.*;
import java.util.Calendar;

public final class newjsp1_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("<html>\n");
      out.write("<body bgcolor=\"pink\">\n");
      out.write("<form method=\"post\">\n");
      out.write("<input  name=\"T1\" value=\"2013-10-14\"/> \n");
      out.write("<input  name=\"T2\" value=\"2014-07-01\"/>\n");
      out.write("<input type=\"submit\" value=\"Submit\" name=\"B1\">\n");
      out.write("</form>\n");
      out.write("\n");


String dStart = request.getParameter("T1");
String dStop = request.getParameter("T2");

SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

Date d1 = null;
Date d2 = null;
Date d3 = null;
SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
String dateSent=formatter.format(new Date());

if (dStart != null && dStop != null) {
try {
d1 = format.parse(dStart);
d2 = format.parse(dStop);
d3 = format.parse(dateSent); 

//out.print(d1);

long difference = d3.getTime() - d1.getTime(); 

long seconds = (difference / (1000*60*60*24));// 60 * 60 * 24*365)); 
long kk=seconds/365;

out.print(kk);

} catch (Exception e) {
e.printStackTrace();
}
}

      out.write("\n");
      out.write("\n");
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
