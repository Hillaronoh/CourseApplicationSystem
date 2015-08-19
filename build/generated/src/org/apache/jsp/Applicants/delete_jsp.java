package org.apache.jsp.Applicants;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class delete_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        ");

    String db="jdbc:mysql:///project1c";
    String user="root";
    String password="";
   String name = "";
   Connection conn=null;
   PreparedStatement pst=null; 
   //String q = request.getParameter("q");
   //int q1=Integer.parseInt(q);
   try { 
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(db,user,password); 
        //Statement smt = conn.createStatement(); //Create Statement to interact
        pst=conn.prepareStatement("select * from course_details where Level_id=3");
       // ResultSet r = smt.executeQuery("select * from courses where(Level_id='" + q + "');");
         //pst.setInt(1,q1);
        ResultSet rs=pst.executeQuery();
       
        while (rs.next()) {
          name = rs.getString("Email_Address");
          out.print("<option value="+name+">"+name+"</option>"); 
        }
        conn.close();
   } catch (Exception e) {
        e.printStackTrace();
   }

      out.write('\n');
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
