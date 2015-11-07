package org.apache.jsp.Applicants;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import myproject.*;

public final class GetCourses_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");

    response.setHeader("Cache-Control","no-cache"); //Forces caches to obtain a new copy of the page from the origin server
    response.setHeader("Cache-Control","no-store"); //Directs caches not to store the page under any circumstance
    response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
    response.setHeader("Pragma","no-cache"); //HTTP 1.0 backward compatibility
    String applicantId=new String(); 
    if(session.getAttribute("applicantId")==null||(session.getAttribute("applicantId")==""))
    {
        
        response.sendRedirect("../Login.jsp"); 
            
    }
    else
    { 
        applicantId=(String)session.getAttribute("applicantId");          
    }
        
    
      out.write('\n');
   
    Applicant app=new Applicant();
    Applicant app2=new Applicant();
    double clusterPoints=0.0; 
    ResultSet rs1=app.getEducationBackground(applicantId);
    if(rs1.next()){
       clusterPoints=rs1.getDouble("Cluster_Points");
    }
    String levelIdString = request.getParameter("programmeLevel");
    int levelIdInt=Integer.parseInt(levelIdString);  
    //ResultSet rs=app.getCourses(levelIdInt);
    ResultSet rs2=app2.getCoursesOverClusterLimit(levelIdInt, clusterPoints);
    ResultSet rs=app.getCoursesOverClusterLimit(levelIdInt, clusterPoints);
    if(rs2.next()){
    while (rs.next()){ 
        int courseId=rs.getInt("Course_id"); 
        String courseName = rs.getString("Course_Name");
        out.print("<option value="+courseId+">"+courseName+"</option>");
    }
}
    else{
       out.print("<option value=>Your Cluster is low! Choose another level.</option>"); 
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
