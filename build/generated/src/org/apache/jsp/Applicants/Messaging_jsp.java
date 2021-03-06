package org.apache.jsp.Applicants;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class Messaging_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


        public class Applicant{
            Connection conn=null;
            PreparedStatement pst=null;
            PreparedStatement pst1=null;
            PreparedStatement pst2=null;
            String db="jdbc:mysql:///project1c";
            String username="root";
            String password="";
            
            public Applicant(){
                try{
                   conn=DriverManager.getConnection(db,username,password);
                   pst=conn.prepareStatement("SELECT First_Name, Last_Name FROM registration WHERE Email_Address=? AND Role_id=?");
                   pst1=conn.prepareStatement("INSERT INTO inquiries(Sender,Message) VALUES(?,?)");
                   pst2=conn.prepareStatement("SELECT Message, Reply FROM inquiries WHERE Sender=?");
                }
                catch(SQLException e){
                    e.printStackTrace();
                }
            }
            
            public ResultSet getApplicant(String email){
                ResultSet rs=null;
                try{
                  pst.setString(1, email);
                  pst.setInt(2, 2);
                  rs=pst.executeQuery();
                }
                catch(SQLException e){
                    e.printStackTrace();
                }
                return rs;
            }
            
            public int setInquiries(String email, String message){
                int i=0;
                try{
                   pst1.setString(1, email);
                   pst1.setString(2, message);
                   //pst1.setDate(3, date);
                   i=pst1.executeUpdate();
                }
                catch(SQLException e){
                    e.printStackTrace();
                }
                return i;
            }
            
            public ResultSet getMessage(String email){
                ResultSet rs=null;
                try{
                   pst2.setString(1, email);
                   rs=pst2.executeQuery();
                }
                catch(SQLException e){
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
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Consultation</title>\n");
      out.write("        <link href=\"mycss/chatbox/bootstrap.css\" rel=\"stylesheet\" style type=\"text/css\">\n");
      out.write("        <link href=\"mycss/chatbox/chatbox.css\" rel=\"stylesheet\" style type=\"text/css\">\n");
      out.write("        <!-- Core CSS - Include with every page -->\n");
      out.write("        <link href=\"assets/plugins/bootstrap/bootstrap.css\" rel=\"stylesheet\" />\n");
      out.write("        <link href=\"assets/font-awesome/css/font-awesome.css\" rel=\"stylesheet\" />\n");
      out.write("        <link href=\"assets/plugins/pace/pace-theme-big-counter.css\" rel=\"stylesheet\" />\n");
      out.write("        <link href=\"assets/css/style.css\" rel=\"stylesheet\" />\n");
      out.write("        <link href=\"assets/css/main-style.css\" rel=\"stylesheet\" />\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"bootstrap/css/bootstrap.css\">\n");
      out.write("        <!--start navigation menus-->\n");
      out.write("        <link rel=\"stylesheet\" href=\"mycss/glyphicons/css/bootstrap.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" style type=\"text/css\" href=\"mycss/navMenus.css\">\n");
      out.write("        <!--end navigation menus-->\n");
      out.write("    </head>\n");
      out.write("    <body style=\"overflow-x: hidden; background-color: #EFEEEE;\">\n");
      out.write("        \n");
      out.write("        ");

            String applicantId=new String(); 
            if(session.getAttribute("applicantId")==null||(session.getAttribute("applicantId")==""))
            {
                
             response.sendRedirect("../Login.jsp"); 

            }
            else
            { 
            applicantId=(String)session.getAttribute("applicantId");          
            }
       
            
      out.write("\n");
      out.write("            \n");
      out.write("            ");
      out.write("\n");
      out.write("        \n");
      out.write("        ");

           Applicant user=new Applicant();
           String firstName=new String();
           String lastName=new String();
                      
           ResultSet results=user.getApplicant(applicantId); 
           
           if(results.next()){
               firstName=results.getString("First_Name");
               lastName=results.getString("Last_Name");
           }
           if(request.getParameter("send")!=null){
           String message=request.getParameter("message");
           int results1=user.setInquiries(applicantId, message);
           }
           ResultSet results2=user.getMessage(applicantId);
        
      out.write("\n");
      out.write("        \n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Header.jsp", out, false);
      out.write("\n");
      out.write("        <div class=\"container\" style=\"margin-top:180px;\">\n");
      out.write("            \n");
      out.write("            <div class=\"row1\" style=\"margin-top: -180px;\"> \n");
      out.write("                \n");
      out.write("                <div class=\"col-md-4 col-md-offset-4\" style=\"width: 1082px; margin-left: 43px;\">\n");
      out.write("                    \n");
      out.write("                    <div class=\"login-panel panel panel-default\"> \n");
      out.write("                        <!--start navigation menus-->\n");
      out.write("                        <div id=\"navMenu\" style=\"margin-top: 2px;\">\n");
      out.write("                            <ul>\n");
      out.write("                                <li><a href=\"UserAccount.jsp\"><button class=\"btn btn-info\" style=\"width: 148px; height: 38px; padding-top: 0px; margin-top: -5px;\"><i class=\"fa fa-home\"></i>Home</button></a>\n");
      out.write("                                </li>\n");
      out.write("                            </ul>\n");
      out.write("                            <ul>\n");
      out.write("                                <li><a href=\"#\"><button class=\"btn btn-info\" style=\"width: 148px; height: 38px; padding-top: 0px; margin-top: -5px;\"><i class=\"fa fa-arrow-down\"></i>Apply Course</button></a>\n");
      out.write("                                    <ul>\n");
      out.write("                                        <li><a href=\"ApplicationForm.jsp\">Under Graduate</a></li>\n");
      out.write("                                        <li><a href=\"#\">Post Graduate</a></li>\n");
      out.write("                                    </ul>\n");
      out.write("                                </li>\n");
      out.write("                            </ul>\n");
      out.write("                            <ul>\n");
      out.write("                                <li><a href=\"Announcements.jsp\"><button class=\"btn btn-info\" style=\"width: 148px; height: 38px; padding-top: 0px; margin-top: -5px;\"><i class=\"fa fa-bell\"></i>Announcements</button></a>\n");
      out.write("                                    \n");
      out.write("                                </li>\n");
      out.write("                            </ul>\n");
      out.write("                            <ul>\n");
      out.write("                                <li><a href=\"Details.jsp\"><button class=\"btn btn-info\" style=\"width: 148px; height: 38px; padding-top: 0px; margin-top: -5px;\"><i class=\"fa fa-archive\"></i>My Details</button></a>\n");
      out.write("                                </li>\n");
      out.write("                            </ul>\n");
      out.write("                            <ul>\n");
      out.write("                                <li><a href=\"Messaging.jsp\"><button class=\"btn btn-info\" style=\"width: 148px; height: 38px; padding-top: 0px; margin-top: -5px; background-color: #428BCA;\"><i class=\"fa fa-inbox\"></i>Inquiries</button></a>\n");
      out.write("                                    \n");
      out.write("                                </li>\n");
      out.write("                            </ul>\n");
      out.write("                            <ul>\n");
      out.write("                                <li><a href=\"#ApplicationStatus\" data-toggle=\"modal\"><button class=\"btn btn-info\" style=\"width: 148px; height: 38px; padding-top: 0px; margin-top: -5px;\"><i class=\"fa fa-star\"></i>Application Status</button></a>\n");
      out.write("                                </li>\n");
      out.write("                            </ul>\n");
      out.write("                            <ul>\n");
      out.write("                                <li><a href=\"#\"><button class=\"btn btn-info\" style=\"width: 148px; height: 38px; padding-top: 0px; margin-top: -5px;\"><i class=\"fa fa-user\"></i>");
      out.print(firstName);
      out.write("</button></a>\n");
      out.write("                                    <ul>\n");
      out.write("                                        <li><a href=\"ChangePwd.jsp\"><i class=\"fa fa-dropbox\"></i>Change Password</a></li>\n");
      out.write("                                        <li><a href=\"UserLogout.jsp\"><i class=\"fa fa-sign-out\"></i>Logout</a></li>\n");
      out.write("                                    </ul>\n");
      out.write("                                </li>\n");
      out.write("                            </ul>\n");
      out.write("                            \n");
      out.write("                        </div>\n");
      out.write("                        <!--end navigation menus-->\n");
      out.write("                        <div class=\"panel-body\">\n");
      out.write("                            \n");
      out.write("                            <div class=\"row\" style=\"margin-top: 15px;\">\n");
      out.write("                                <div class=\"col-md-4 col-md-offset-4\">\n");
      out.write("                                    <div class=\"portlet portlet-default\">\n");
      out.write("                                        <div class=\"portlet-heading\">\n");
      out.write("                                            <div class=\"portlet-title\">\n");
      out.write("                                                <h4> ");
      out.print(firstName);
      out.write(' ');
      out.print(lastName);
      out.write(" </h4>\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"clearfix\"></div>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div id=\"chat\" class=\"panel-collapse collapse in\">\n");
      out.write("                                            <div>\n");
      out.write("                                                <div class=\"portlet-body\" style=\"overflow-y: auto; width: auto; height: 200px;\">\n");
      out.write("                                                    <div class=\"row\">\n");
      out.write("                                                        <div class=\"col-lg-12\">\n");
      out.write("                                                            <p class=\"text-center text-muted small\">");
      out.print( (new java.util.Date()).toLocaleString());
      out.write("</p> \n");
      out.write("                                                        </div>\n");
      out.write("                                                    </div>\n");
      out.write("                                                     ");

                                                     String message=new String();
                                                     String reply=new String();
                                                     while(results2.next()){
                                                         message=results2.getString("Message");
                                                         reply=results2.getString("Reply");
                                                     
      out.write("\n");
      out.write("                                                    <div class=\"row\">\n");
      out.write("                                                        <div class=\"col-lg-12\">\n");
      out.write("                                                            <div class=\"media\">\n");
      out.write("                                                                <a class=\"pull-left\" href=\"#\">\n");
      out.write("                                                                    <img class=\"media-object img-circle\" src=\"image/username2.png\" alt=\"\" style=\"width: 20px; height: 20px;\">\n");
      out.write("                                                                </a>\n");
      out.write("                                                                <div class=\"media-body\">\n");
      out.write("                                                                    <h4 class=\"media-heading\">");
      out.print(firstName);
      out.write("\n");
      out.write("                                                                        <span class=\"small pull-right\">12:23 PM</span>\n");
      out.write("                                                                    </h4>\n");
      out.write("                                                                       \n");
      out.write("                                                                    <p>");
      out.print(message);
      out.write("</p>\n");
      out.write("                                                                        \n");
      out.write("                                                                </div>\n");
      out.write("                                                            </div>\n");
      out.write("                                                        </div>\n");
      out.write("                                                    </div>\n");
      out.write("                                                    <hr>\n");
      out.write("                                                    ");
if(reply!=null){
      out.write("\n");
      out.write("                                                        <div class=\"row\">\n");
      out.write("                                                        <div class=\"col-lg-12\">\n");
      out.write("                                                            <div class=\"media\">\n");
      out.write("                                                                <a class=\"pull-left\" href=\"#\">\n");
      out.write("                                                                    <img class=\"media-object img-circle\" src=\"image/username2.png\" alt=\"\" style=\"width: 20px; height: 20px;\">\n");
      out.write("                                                                </a>\n");
      out.write("                                                                <div class=\"media-body\">\n");
      out.write("                                                                    <h4 class=\"media-heading\">mmust\n");
      out.write("                                                                        <span class=\"small pull-right\">12:23 PM</span>\n");
      out.write("                                                                    </h4>\n");
      out.write("                                                                       \n");
      out.write("                                                                    <p>");
      out.print(reply);
      out.write("</p>\n");
      out.write("                                                                        \n");
      out.write("                                                                </div>\n");
      out.write("                                                            </div>\n");
      out.write("                                                        </div>\n");
      out.write("                                                    </div>\n");
      out.write("                                                    <hr>\n");
      out.write("                                                    ");
}
                                                    }
      out.write("\n");
      out.write("                                                    \n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"portlet-footer\">\n");
      out.write("                                                <form role=\"form\">\n");
      out.write("                                                    <div class=\"form-group\">\n");
      out.write("                                                        <textarea class=\"form-control\" name=\"message\" placeholder=\"Enter message...\"></textarea>\n");
      out.write("                                                    </div>\n");
      out.write("                                                    <div class=\"form-group\">\n");
      out.write("                                                        <input type=\"submit\" class=\"btn btn-default pull-right\" value=\"Send\" name=\"send\">\n");
      out.write("                                                        <div class=\"clearfix\"></div>\n");
      out.write("                                                    </div>\n");
      out.write("                                                </form>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <!-- /.col-md-4 -->\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div> \n");
      out.write("        </div> \n");
      out.write("        \n");
      out.write("        <div class=\"modal fade\" id=\"ApplicationStatus\" role=\"dialog\">\n");
      out.write("            <div class=\"modal-dialog\">\n");
      out.write("                <div class=\"modal-content\">\n");
      out.write("                    <div class=\"modal-header\">\n");
      out.write("                        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>\n");
      out.write("                        <h4 class=\"modal-title\">Application Status</h4>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"modal-body\">\n");
      out.write("                        <p>You successfully secured a placement in bachelor of science in computer science\n");
      out.write("                        </p>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"modal-footer\">\n");
      out.write("                        <button type=\"button\" class=\"btn btn-danger\" data-dismiss=\"modal\">close</button>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        <script type=\"text/javascript\" src=\"mycss/modal/jquery.minCust.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"mycss/modal/bootstrapJsCust.js\"></script>\n");
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
