package org.apache.jsp.Applicants;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class UserRegistrationb_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


    public class Registration{ 
        Connection conn=null;
        PreparedStatement pst=null;
        PreparedStatement pst1=null;
        ResultSet rs=null;
        int res1=0;
        int res2=0; 
        String db="jdbc:mysql:///project1c";
        String user="root";
        String password="";
        
        public Registration(){ 
           try{
            conn = DriverManager.getConnection(db,user,password); 

            pst = conn.prepareStatement("insert into registration values(?,?,?,?,?)");
            
            pst1 = conn.prepareStatement("select * from registration where Email_address=?");
            
           }catch(SQLException e){
               e.printStackTrace(); 
           }
        }
        
        public ResultSet checkIfRegistered(String email1){ 
        try{   
        pst1.setString(1, email1); 
        rs=pst1.executeQuery(); 
        }catch(SQLException e){
            e.printStackTrace();
        }
        return rs;  
        }

        public int setUsers(String fname, String mname, String lname, String email, String pwd){ 
        try{   
        pst.setString(1, fname);
        pst.setString(2, mname);
        pst.setString(3, lname);
        pst.setString(4, email);
        pst.setString(5, pwd);
        res2=pst.executeUpdate(); 
        }catch(SQLException e){
            e.printStackTrace();
        }
        return res2;  
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
      out.write("  <meta charset=\"utf-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <title>User Registration</title>\n");
      out.write("    <!-- Core CSS - Include with every page -->\n");
      out.write("    <link href=\"assets/plugins/bootstrap/bootstrap.css\" rel=\"stylesheet\" />\n");
      out.write("    <link href=\"assets/font-awesome/css/font-awesome.css\" rel=\"stylesheet\" />\n");
      out.write("    <link href=\"assets/plugins/pace/pace-theme-big-counter.css\" rel=\"stylesheet\" />\n");
      out.write("    <link href=\"assets/css/style.css\" rel=\"stylesheet\" />\n");
      out.write("    <link href=\"assets/css/main-style.css\" rel=\"stylesheet\" />\n");
      out.write("    <link rel=\"stylesheet\" href=\"mycss/style2.css\" style type=\"text/css\">\n");
      out.write("    \n");
      out.write(" <link rel=\"stylesheet\" href=\"layout/bootstrap/css/bootstrap.css\" type=\"text/css\">\n");
      out.write(" <script type=\"text/javascript\" src=\"mycss/validate.js\"></script>\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body style=\"overflow-x: hidden; background-color: #EFEEEE;\"> \n");
      out.write("    \n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Header.jsp", out, false);
      out.write("\n");
      out.write("    \n");
      out.write("    <div class=\"container\">\n");
      out.write("        \n");
      out.write("            \n");
      out.write("        <div class=\"row2\">\n");
      out.write("            <div class=\"col-md-5 col-md-offset-5\">\n");
      out.write("\t\t\t\n");
      out.write("                <div class=\"login-panel panel panel-default\">\n");
      out.write("   \n");
      out.write("                ");
if(request.getParameter("register")!=null){
      out.write("                 \n");
      out.write("                ");
      out.write("\n");
      out.write("    \n");
      out.write("    ");

    Registration reg=new Registration(); 
    
    String fname=request.getParameter("fname");
    String mname=request.getParameter("mname");
    String lname=request.getParameter("lname");
    String email=request.getParameter("email");
    String pwd=request.getParameter("password1"); 
    
    ResultSet results1=reg.checkIfRegistered(email);
    int results2=reg.setUsers(fname, mname, lname, email, pwd);

    
        if(results1.next()){
      out.write("\n");
      out.write("        <div class=\"panel-heading\">\n");
      out.write("               <h3 class=\"panel-title alert alert-danger alert-block\" style=\"text-align: center;\"><span style=\"color: red;\">Email You Provided is Already Registered!!</span></h3>\n");
      out.write("        </div> \n");
      out.write("       ");
 }
        else{
    
            if(results2>0){
      out.write("\n");
      out.write("            <div class=\"panel-heading\">\n");
      out.write("               <h3 class=\"panel-title alert alert-success alert-block\" style=\"text-align: center;\"><span style=\"color: green;\">Registration Successful... Click Sign In below to Login</span></h3>\n");
      out.write("            </div> \n");
      out.write("     ");
 }
       else{
      out.write("\n");
      out.write("       <div class=\"panel-heading\">\n");
      out.write("               <h3 class=\"panel-title alert alert-error alert-block\" style=\"text-align: center;\"><span style=\"color: red;\">Server is Down!!</span></h3>\n");
      out.write("       </div> \n");
      out.write("         ");
 }
    }
    }
    else{
                    
      out.write("\n");
      out.write("                    <div class=\"panel-heading\">\n");
      out.write("                        <h3 class=\"panel-title\" style=\"text-align: center;\">Welcome New User! Sign Up Below.</h3>\n");
      out.write("                    </div>\n");
      out.write("            ");
}
      out.write(" \n");
      out.write("            <div class=\"panel-body\">\n");
      out.write("                        \n");
      out.write("                <form name=\"registration\" method=\"post\" action=\"\" onsubmit=\"return validateForm(this)\"><br>\n");
      out.write("                   \n");
      out.write("                    <fieldset>\n");
      out.write("\n");
      out.write("                        <table style=\"width: 600px; height: 350px;\">\n");
      out.write("                            <tbody>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td align=\"right\" valign=\"top\" style=\"padding-top:10px;\">First Name:<span style=\"color:red\"> *</span> &nbsp;&nbsp;&nbsp;</td>\n");
      out.write("                                    <td valign=\"top\"><input  autocomplete=\"off\" name=\"fname\" id=\"fname\" type=\"text\" autofocus>\n");
      out.write("                                        <span id=\"fnameError\" style=\"color: #ff6699;\"></span>\n");
      out.write("                                    </td>\n");
      out.write("                                    <td valign=\"top\"></td>\n");
      out.write("                                </tr>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td align=\"right\" valign=\"top\" style=\"padding-top:10px;\">Middle Name:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n");
      out.write("                                    <td valign=\"top\"><input autocomplete=\"off\" name=\"mname\" id=\"mname\" type=\"text\">\n");
      out.write("                                        <span id=\"mnameError\"> </span>\n");
      out.write("                                    </td>\n");
      out.write("                                    <td valign=\"top\"></td>\n");
      out.write("                                </tr>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td align=\"right\" valign=\"top\" style=\"padding-top:10px;\">Last Name:<span style=\"color:red\"> *</span>&nbsp;&nbsp;&nbsp;&nbsp;</td>\n");
      out.write("                                    <td valign=\"top\"><input autocomplete=\"off\" name=\"lname\" id=\"lname\" type=\"text\">\n");
      out.write("                                        <span id=\"lnameError\" style=\"color: #ff6699;\"> </span>\n");
      out.write("                                    </td>\n");
      out.write("                                    <td valign=\"top\"></td>\n");
      out.write("                                </tr>\n");
      out.write("\n");
      out.write("                                <tr>\n");
      out.write("                                    <td align=\"right\" valign=\"top\" style=\"padding-top:10px;\">Email Address:<span style=\"color:red\"> *</span>&nbsp;&nbsp;&nbsp;&nbsp;</td>\n");
      out.write("                                    <td valign=\"top\"><input autocomplete=\"off\" name=\"email\" id=\"idnum\" type=\"email\">\n");
      out.write("                                        <span id=\"emailError\" style=\"color: #ff6699;\"> </span>\n");
      out.write("                                    </td>\n");
      out.write("                                    <td valign=\"top\"></td>\n");
      out.write("                                </tr>\n");
      out.write("                                <tr >\n");
      out.write("                                    <td align=\"right\" valign=\"top\" style=\"padding-top:10px;\">Password:<span style=\"color:red\"> *</span>&nbsp;&nbsp;&nbsp;&nbsp;</td>\n");
      out.write("                                    <td valign=\"top\"><input autocomplete=\"off\" name=\"password1\" id=\"pwd\" type=\"password\" >\n");
      out.write("                                        <span id=\"password1Error\" style=\"color: #ff6699;\"> </span>\n");
      out.write("                                    </td>\n");
      out.write("                                    <td valign=\"top\"></td>\n");
      out.write("                                </tr>\n");
      out.write("\n");
      out.write("                                <tr>\n");
      out.write("                                    <td align=\"right\" valign=\"top\" style=\"padding-top:10px;\">Confirm Password:<span style=\"color:red\">*</span>&nbsp;&nbsp;&nbsp;&nbsp;</td>\n");
      out.write("                                    <td valign=\"top\"><input autocomplete=\"off\" name=\"password2\" id=\"mobnumber\" type=\"password\">\n");
      out.write("                                        <span id=\"password2Error\" style=\"color: #ff6699;\"> </span>\n");
      out.write("                                    </td>\n");
      out.write("                                    <td valign=\"top\"></td>\n");
      out.write("                                </tr>\n");
      out.write("\n");
      out.write("                                <tr>\n");
      out.write("                                    <td align=\"right\" valign=\"top\"></td>\n");
      out.write("                                    <td valign=\"top\"><strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n");
      out.write("                                            <input type=\"submit\" name=\"register\" class=\"btn btn-success\" style=\"width:25%;\" value=\"Register\" id=\"submit\"></strong> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n");
      out.write("                                            <strong><input name=\"reset\" class=\"btn btn-info\" style=\"width:25%;\" value=\"Reset\" id=\"clear\" type=\"reset\"></strong> <br/></td>\n");
      out.write("                                    <td valign=\"top\"></td>\n");
      out.write("\t\n");
      out.write("                                </tr>\n");
      out.write("\n");
      out.write("                            </tbody>\n");
      out.write("                        </table>  \n");
      out.write("                    </fieldset>\n");
      out.write("                    <a href=\"UserLogin.jsp\" style=\"float: right;\">Sign In Here</a>\n");
      out.write("                </form>\n");
      out.write("                        \n");
      out.write("            </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("            \n");
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
