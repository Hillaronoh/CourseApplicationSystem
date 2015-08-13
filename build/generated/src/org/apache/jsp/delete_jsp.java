package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.text.DecimalFormat;
import java.sql.*;

public final class delete_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


        public class Applicant{
            Connection conn=null;
            PreparedStatement pst=null;
            PreparedStatement pst1=null;
            PreparedStatement pst2=null;
            PreparedStatement pst3=null;
            PreparedStatement pst4=null;
            PreparedStatement pst5=null;
            PreparedStatement pst6=null;
            PreparedStatement pst7=null;
            String db="jdbc:mysql:///project1c";
            String username="root";
            String password="";
            
            public Applicant(){
                try{
                   conn=DriverManager.getConnection(db,username,password); 
                   pst7=conn.prepareStatement("UPDATE education_background SET Physics_Grade=?, Maths_Grade=?, Subject3_Grade=?, Subject4_Grade=?, Mean_Grade, Aggregate_Points=?, Cluster_Points=? WHERE Email_Address=?");
                }
                catch(SQLException e){
                    e.printStackTrace();
                }
            }
         
            
            public int editEducationBackground(String physics,String maths,String subj3, String subj4, String mean, double aggPoints, double clusterPoints, String email){
                int j=0;
                try{
                  pst7.setString(1, physics);
                  pst7.setString(2, maths);
                  pst7.setString(3, subj3);
                  pst7.setString(4, subj4);
                  pst7.setString(5, mean);
                  pst7.setDouble(6, aggPoints);
                  pst7.setDouble(7, clusterPoints);
                  pst7.setString(8, email);
                  j=pst7.executeUpdate();
                }
                catch(SQLException e){
                    e.printStackTrace();
                }
                return j;
            }
            
            public double convertGradestoPoints(String grade){ 
               double points=0.00;  
                if(grade.equals("A")){
                    points=12;
                }
                else if(grade.equals("A-")){
                    points=11;
                }
                else if(grade.equals("B+")){
                    points=10;
                }
                else if(grade.equals("B")){
                    points=9;
                }
                else if(grade.equals("B-")){
                    points=8; 
                }
                else if(grade.equals("C+")){
                    points=7;
                }
                else if(grade.equals("C")){
                    points=6;
                }
                else if(grade.equals("C-")){
                    points=5;
                }
                else if(grade.equals("D+")){
                    points=4;
                }
                else{
                    points=3; 
                }
                return points;
            }
            
            public double calculateClusterPoints(double physics, double maths, double subj3, double subj4, double aggregatePoints){
                double res1=(physics+maths+subj3+subj4);
                double res2=(res1/48); 
                double res3=(aggregatePoints/84);
                double res4=(res2*res3);
                double res5=(Math.sqrt(res4));
                double w=(res5*48);
                DecimalFormat df = new DecimalFormat("#.##");
                String w1 = df.format(w);
                return Double.parseDouble(w1);
            }
        }
        
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
      out.write(" \n");
      out.write("\n");
Class.forName("com.mysql.jdbc.Driver");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      out.write("\n");
      out.write("        ");
 
           Applicant user=new Applicant();
           int resultsE1=0;
           if(request.getParameter("save2")!=null){              
               String physics=physics=request.getParameter("physicsGrade");
               String maths=request.getParameter("mathsGrade");
               String subj3 =request.getParameter("subj3Grade");
               String subj4=request.getParameter("subj4Grade");
               String mean=request.getParameter("meanGrade");
               String aggregatePointsString=request.getParameter("aggregatePoints");
               double aggregatePointsDouble=Double.parseDouble(aggregatePointsString); 
                                                                                                                                 
              double physicsConverted=user.convertGradestoPoints(physics);
              double mathsConverted=user.convertGradestoPoints(maths);
              double subj3Converted=user.convertGradestoPoints(subj3);
              double subj4Converted=user.convertGradestoPoints(subj4); 
              double clusterPointsE=user.calculateClusterPoints(physicsConverted, mathsConverted, subj3Converted, subj4Converted, aggregatePointsDouble); 
               
               resultsE1=user.editEducationBackground(physics, maths, subj3, subj4, mean, 8, 90, "ronokip55@gmail.com");
               if(resultsE1>0){
                   out.print("Good");
               }
               else{
                  out.print("Bad"); 
               }
           }                             
           
      out.write("\n");
      out.write("           \n");
      out.write("           <form method=\"post\" action=\"\">\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"physicsGrade\">Physics Grade</label>\n");
      out.write("                                <input type=\"text\" class=\"form-control\" id=\"physicsGrade\" placeholder=\"Physics Grade\" name=\"physicsGrade\" value=\"\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"mathsGrade\">Maths Grade</label>\n");
      out.write("                                <input type=\"text\" class=\"form-control\" id=\"mathsGrade\" placeholder=\"Maths Grade\" name=\"mathsGrade\" value=\"\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"subj3Grade\">Group II/Group III Grade</label>\n");
      out.write("                                <input type=\"text\" class=\"form-control\" id=\"subj3Grade\" placeholder=\"Subject3 Grade\" name=\"subj3Grade\" value=\"\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"subj4Grade\">Group II/Group III/Group IV/Group V Grade</label>\n");
      out.write("                                <input type=\"text\" class=\"form-control\" id=\"subj4Grade\" placeholder=\"subject4 Grade\" name=\"subj4Grade\" value=\"\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"meanGrade\">Mean Grade</label>\n");
      out.write("                                <input type=\"text\" class=\"form-control\" id=\"meanGrade\" placeholder=\"Mean Grade\" name=\"meanGrade\" value=\"\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"aggregatePoints\">Aggregate Points</label>\n");
      out.write("                                <input type=\"text\" class=\"form-control\" id=\"aggregatePoints\" placeholder=\"Aggregate Points\" name=\"aggregatePoints\" value=\"\">\n");
      out.write("                            </div>\n");
      out.write("                            \n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"clusterPoints\">Cluster Points</label>\n");
      out.write("                                <input type=\"text\" class=\"form-control\" id=\"clusterPoints\" placeholder=\"Cluster Points\" name=\"clusterPoints\" value=\"\">\n");
      out.write("                            </div>\n");
      out.write("                            \n");
      out.write("                            <div class=\"well modal-footer\">\n");
      out.write("                                <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Close</button>\n");
      out.write("                                <button type=\"submit\" class=\"btn btn-primary\" name=\"save2\">Save changes</button>\n");
      out.write("                            </div>\n");
      out.write("           </form>\n");
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
