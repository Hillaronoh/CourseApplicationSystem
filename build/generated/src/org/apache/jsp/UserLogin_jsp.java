package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class UserLogin_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


    public class Login{ 
        Connection conn=null;
        PreparedStatement pst=null;
        ResultSet rs=null;
        String db="jdbc:mysql:///project1c";
        String user="root";
        String password="";
        
        public Login(){ 
           try{
            conn = DriverManager.getConnection(db,user,password); 

            pst = conn.prepareStatement("select * from registration where Email=? and Password=?"); 
            
           }catch(SQLException e){
               e.printStackTrace(); 
           }
        }
        public ResultSet setUsers(String mail, String pass){
        try{   
        pst.setString(1, mail);
        pst.setString(2, pass);
        rs=pst.executeQuery();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return rs;  
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

      out.write('\n');
      out.write('\n');
Class.forName("com.mysql.jdbc.Driver"); 
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <title>User Login</title>\n");
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
      out.write("            ");
if(request.getParameter("login")!=null){
      out.write(" \n");
      out.write("            ");
      out.write("\n");
      out.write("    \n");
      out.write("    ");

    Login login=new Login(); 
  
    String email=request.getParameter("email");
    String pwd=request.getParameter("password"); 
    ResultSet results=login.setUsers(email, pwd); 
 
   if(results.next()){  
   session.setAttribute("userid", email);  
   response.sendRedirect("UserAccount.jsp"); 
        }
   else{
       
      out.write("\n");
      out.write("\t\t\t\t                 \n");
      out.write("       <div class=\"panel-heading\">\n");
      out.write("           \n");
      out.write("           <h3 class=\"panel-title alert alert-danger\"><span style=\"color: red;\">Wrong Login Credentials!!</span></h3>\n");
      out.write("       </div>\n");
      out.write("     ");
}} else {
      out.write("\n");
      out.write("     <div class=\"panel-heading\">\n");
      out.write("         <h3 class=\"panel-title\">Please Sign In</h3>\n");
      out.write("     </div>\n");
      out.write("       ");
}
      out.write("\n");
      out.write("       <div class=\"panel-body2\">\n");
      out.write("                        \n");
      out.write("           <form role=\"form\" method=\"post\" action=\"\">\n");
      out.write("               <fieldset>\n");
      out.write("                   <div class=\"form-group\">\n");
      out.write("                      <div class=\"input-group\">\n");
      out.write("                          <div class=\"input-group-addon\"><span class=\"glyphicon glyphicon-envelope\"></span></div>\n");
      out.write("                          <input class=\"form-control\" type=\"email\" placeholder=\"Email\" name=\"email\" autocomplete=\"off\" autofocus>\n");
      out.write("                      </div>\n");
      out.write("                   </div>\n");
      out.write("                   <div class=\"form-group\">\n");
      out.write("                       <div class=\"input-group\">\n");
      out.write("                           <div class=\"input-group-addon\"><span class=\"glyphicon glyphicon-lock\"></span></div>\n");
      out.write("                           <input class=\"form-control\" type=\"password\" placeholder=\"Password\" name=\"password\">\n");
      out.write("                       </div>\n");
      out.write("                   </div>\n");
      out.write("                   <div class=\"checkbox\">\n");
      out.write("                       <label>\n");
      out.write("                           <input name=\"remember\" type=\"checkbox\" value=\"Remember Me\">Remember Me\n");
      out.write("                       </label>\n");
      out.write("                   </div>\n");
      out.write("                   <!-- Change this to a button or input when using this as a form -->\n");
      out.write("                   <button class=\"btn btn-lg btn-success btn-block\" type=\"submit\" name=\"login\"><span class=\"glyphicon glyphicon-log-in\" style=\"font-size: 15px;\"></span> Login</button>\n");
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
      out.write("\n");
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
