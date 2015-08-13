package org.apache.jsp.Admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class UnrepliedInquiries_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


        public class Admin{
            Connection conn=null;
            PreparedStatement pst=null;
            PreparedStatement pst1=null;
            String db="jdbc:mysql:///project1c";
            String username="root";
            String password="";
            
            public Admin(){
                try{
                   conn=DriverManager.getConnection(db,username,password);
                   pst=conn.prepareStatement("SELECT First_Name FROM registration WHERE Email_Address=? AND Role_id=?");
                   pst1=conn.prepareStatement("SELECT * FROM inquiries WHERE Reply IS NULL");
                }
                catch(SQLException e){
                    e.printStackTrace();
                }
            }
            
            public ResultSet getAdmin(String email){
                ResultSet rs=null;
                try{
                  pst.setString(1, email);
                  pst.setInt(2, 1);
                  rs=pst.executeQuery();
                }
                catch(SQLException e){
                    e.printStackTrace();
                }
                return rs;
            }
            
            public ResultSet getUnrepliedInquiries(){
                ResultSet rs=null;
                try{
                  rs=pst1.executeQuery();
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
      out.write("        <!-- Meta, title, CSS, favicons, etc. -->\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <link rel=\"shortcut icon\" href=\"images/favicon.ico\">\n");
      out.write("        \n");
      out.write("        <title> Inquiries | Unreplied </title>\n");
      out.write("        \n");
      out.write("        <!-- Bootstrap core CSS -->\n");
      out.write("        \n");
      out.write("        <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("        \n");
      out.write("        <link href=\"fonts/css/font-awesome.min.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"css/animate.min.css\" rel=\"stylesheet\">\n");
      out.write("        \n");
      out.write("        <!-- Custom styling plus plugins -->\n");
      out.write("        <link href=\"css/custom.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"css/icheck/flat/green.css\" rel=\"stylesheet\">\n");
      out.write("        <!-- editor -->\n");
      out.write("        <link href=\"http://netdna.bootstrapcdn.com/font-awesome/3.0.2/css/font-awesome.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"css/editor/external/google-code-prettify/prettify.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"css/editor/index.css\" rel=\"stylesheet\">\n");
      out.write("        <!-- select2 -->\n");
      out.write("        <link href=\"css/select/select2.min.css\" rel=\"stylesheet\">\n");
      out.write("        <!-- switchery -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/switchery/switchery.min.css\" />\n");
      out.write("        \n");
      out.write("        <script src=\"js/jquery.min.js\"></script>\n");
      out.write("        \n");
      out.write("    </head>\n");
      out.write("    \n");
      out.write("    \n");
      out.write("    <body class=\"nav-md\">\n");
      out.write("        \n");
      out.write("        ");

            String adminId=new String(); 
            if(session.getAttribute("adminId")==null||(session.getAttribute("adminId")==""))
            {
                
                response.sendRedirect("../Login.jsp"); 

            }
            else
            { 
                adminId=(String)session.getAttribute("adminId");          
            }
       
            
      out.write("\n");
      out.write("            \n");
      out.write("            ");
      out.write("\n");
      out.write("        \n");
      out.write("        ");

           Admin admin=new Admin();
           String firstName=new String();
           
           ResultSet results=admin.getAdmin(adminId);
           
           if(results.next()){
               firstName=results.getString("First_Name");
           }
           
           ResultSet results1=admin.getUnrepliedInquiries();
        
      out.write("\n");
      out.write("        \n");
      out.write("        <div class=\"container body\">\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            <div class=\"main_container\">\n");
      out.write("                \n");
      out.write("                <div class=\"col-md-3 left_col\">\n");
      out.write("                    <div class=\"left_col scroll-view\">\n");
      out.write("                        \n");
      out.write("                        <div class=\"navbar nav_title\" style=\"border: 0;\">\n");
      out.write("                            <a href=\"AdminPanel.jsp\" class=\"site_title\"><i class=\"fa fa-user-md\"></i> <span>Admin</span></a>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"clearfix\"></div>\n");
      out.write("                        \n");
      out.write("                        <br />\n");
      out.write("                        \n");
      out.write("                        <!-- sidebar menu -->\n");
      out.write("                        <div id=\"sidebar-menu\" class=\"main_menu_side hidden-print main_menu\">\n");
      out.write("                            \n");
      out.write("                            <div class=\"menu_section\">\n");
      out.write("                                <h3>General</h3>\n");
      out.write("                                <ul class=\"nav side-menu\">\n");
      out.write("                                    <li><a><i class=\"fa fa-home\"></i> Home <span class=\"fa fa-chevron-down\"></span></a>\n");
      out.write("                                        <ul class=\"nav child_menu\" style=\"display: none\">\n");
      out.write("                                            <li><a href=\"AdminPanel.jsp\">Dashboard</a>\n");
      out.write("                                            </li>\n");
      out.write("                                        </ul>\n");
      out.write("                                    </li>\n");
      out.write("                                    <li><a><i class=\"fa fa-desktop\"></i> View Applicants <span class=\"fa fa-chevron-down\"></span></a>\n");
      out.write("                                        <ul class=\"nav child_menu\" style=\"display: none\">\n");
      out.write("                                            <li><a href=\"ViewDegApplicants.jsp\">Degree Applicants</a>\n");
      out.write("                                            </li>\n");
      out.write("                                            <li><a href=\"ViewDipApplicants.jsp\">Diploma Applicants</a>\n");
      out.write("                                            </li>\n");
      out.write("                                            <li><a href=\"ViewCertApplicants.jsp\">Certificate Applicants</a>\n");
      out.write("                                            </li>\n");
      out.write("                                        </ul>\n");
      out.write("                                    </li>\n");
      out.write("                                    <li><a><i class=\"fa fa-bell-o\"></i> Announcements <span class=\"fa fa-chevron-down\"></span></a>\n");
      out.write("                                        <ul class=\"nav child_menu\" style=\"display: none\">\n");
      out.write("                                            <li><a href=\"#postAnnouncement\" data-toggle=\"modal\">Post</a>\n");
      out.write("                                            </li>\n");
      out.write("                                            <li><a href=\"DeleteAnn.jsp\">Delete</a>\n");
      out.write("                                            </li>\n");
      out.write("                                        </ul>\n");
      out.write("                                    </li>\n");
      out.write("                                    <li><a><i class=\"fa fa-table\"></i> Rank Applicants <span class=\"fa fa-chevron-down\"></span></a>\n");
      out.write("                                        <ul class=\"nav child_menu\" style=\"display: none\">\n");
      out.write("                                            <li><a href=\"RankDegApp.jsp\">Degree Apllicants</a>\n");
      out.write("                                            </li>\n");
      out.write("                                            <li><a href=\"RankDipApp.jsp\">Diploma Applicants</a>\n");
      out.write("                                            </li>\n");
      out.write("                                            <li><a href=\"RankCertApp.jsp\">Certificate Applicants</a>\n");
      out.write("                                            </li>\n");
      out.write("                                        </ul>\n");
      out.write("                                    </li>\n");
      out.write("                                    <li><a><i class=\"fa fa-inbox\"></i> Inquiries <span class=\"fa fa-chevron-down\"></span></a>\n");
      out.write("                                        <ul class=\"nav child_menu\" style=\"display: none\">\n");
      out.write("                                            <li><a href=\"UnrepliedInquiries.jsp\">Unreplied</a>\n");
      out.write("                                            </li>\n");
      out.write("                                            <li><a href=\"RepliedInquiries.jsp\">Replied</a>\n");
      out.write("                                            </li>\n");
      out.write("                                        </ul>\n");
      out.write("                                    </li>\n");
      out.write("                                </ul>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <!-- /sidebar menu -->\n");
      out.write("                        \n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                \n");
      out.write("                <!-- top navigation -->\n");
      out.write("                <div class=\"top_nav\">\n");
      out.write("                    \n");
      out.write("                    <div class=\"nav_menu\">\n");
      out.write("                        <nav class=\"\" role=\"navigation\">\n");
      out.write("                            <div class=\"nav toggle\">\n");
      out.write("                                <a id=\"menu_toggle\"><i class=\"fa fa-bars\"></i></a>\n");
      out.write("                            </div>\n");
      out.write("                            \n");
      out.write("                            <ul class=\"nav navbar-nav navbar-right\">\n");
      out.write("                                <li class=\"\">\n");
      out.write("                                    <a href=\"javascript:;\" class=\"user-profile dropdown-toggle\" data-toggle=\"dropdown\" aria-expanded=\"false\">\n");
      out.write("                                        <img src=\"images/username2.png\" alt=\"\">");
      out.print(firstName);
      out.write(" \n");
      out.write("                                        <span class=\" fa fa-angle-down\"></span>\n");
      out.write("                                    </a>\n");
      out.write("                                    <ul class=\"dropdown-menu dropdown-usermenu animated fadeInDown pull-right\">\n");
      out.write("                                        \n");
      out.write("                                        <li>\n");
      out.write("                                            <a href=\"#\">Change Password</a>\n");
      out.write("                                        </li>\n");
      out.write("                                        <li><a href=\"../Applicants/UserLogout.jsp\"><i class=\"fa fa-sign-out pull-right\"></i> Log Out</a>\n");
      out.write("                                        </li>\n");
      out.write("                                    </ul>\n");
      out.write("                                </li>\n");
      out.write("                                \n");
      out.write("                                <li role=\"presentation\" class=\"dropdown\">\n");
      out.write("                                    <a href=\"javascript:;\" class=\"dropdown-toggle info-number\" data-toggle=\"dropdown\" aria-expanded=\"false\">\n");
      out.write("                                        <i class=\"fa fa-globe\"></i>\n");
      out.write("                                        <span class=\"badge bg-green\">6</span>\n");
      out.write("                                    </a>\n");
      out.write("                                    <ul id=\"menu1\" class=\"dropdown-menu list-unstyled msg_list animated fadeInDown\" role=\"menu\">\n");
      out.write("                                        <li>\n");
      out.write("                                            <a>\n");
      out.write("                                                <span class=\"image\">\n");
      out.write("                                                    <img src=\"images/img.jpg\" alt=\"Profile Image\" />\n");
      out.write("                                                </span>\n");
      out.write("                                                <span>\n");
      out.write("                                                    <span>John Smith</span>\n");
      out.write("                                                    <span class=\"time\">3 mins ago</span>\n");
      out.write("                                                </span>\n");
      out.write("                                                <span class=\"message\">\n");
      out.write("                                                    Film festivals used to be do-or-die moments for movie makers. They were where... \n");
      out.write("                                                </span>\n");
      out.write("                                            </a>\n");
      out.write("                                        </li>\n");
      out.write("                                        <li>\n");
      out.write("                                            <a>\n");
      out.write("                                                <span class=\"image\">\n");
      out.write("                                                    <img src=\"images/img.jpg\" alt=\"Profile Image\" />\n");
      out.write("                                                </span>\n");
      out.write("                                                <span>\n");
      out.write("                                                    <span>John Smith</span>\n");
      out.write("                                                    <span class=\"time\">3 mins ago</span>\n");
      out.write("                                                </span>\n");
      out.write("                                                <span class=\"message\">\n");
      out.write("                                                    Film festivals used to be do-or-die moments for movie makers. They were where... \n");
      out.write("                                                </span>\n");
      out.write("                                            </a>\n");
      out.write("                                        </li>\n");
      out.write("                                        <li>\n");
      out.write("                                            <a>\n");
      out.write("                                                <span class=\"image\">\n");
      out.write("                                                    <img src=\"images/img.jpg\" alt=\"Profile Image\" />\n");
      out.write("                                                </span>\n");
      out.write("                                                <span>\n");
      out.write("                                                    <span>John Smith</span>\n");
      out.write("                                                    <span class=\"time\">3 mins ago</span>\n");
      out.write("                                                </span>\n");
      out.write("                                                <span class=\"message\">\n");
      out.write("                                                    Film festivals used to be do-or-die moments for movie makers. They were where... \n");
      out.write("                                                </span>\n");
      out.write("                                            </a>\n");
      out.write("                                        </li>\n");
      out.write("                                        <li>\n");
      out.write("                                            <a>\n");
      out.write("                                                <span class=\"image\">\n");
      out.write("                                                    <img src=\"images/img.jpg\" alt=\"Profile Image\" />\n");
      out.write("                                                </span>\n");
      out.write("                                                <span>\n");
      out.write("                                                    <span>John Smith</span>\n");
      out.write("                                                    <span class=\"time\">3 mins ago</span>\n");
      out.write("                                                </span>\n");
      out.write("                                                <span class=\"message\">\n");
      out.write("                                                    Film festivals used to be do-or-die moments for movie makers. They were where... \n");
      out.write("                                                </span>\n");
      out.write("                                            </a>\n");
      out.write("                                        </li>\n");
      out.write("                                        <li>\n");
      out.write("                                            <div class=\"text-center\">\n");
      out.write("                                                <a>\n");
      out.write("                                                    <strong>See All Alerts</strong>\n");
      out.write("                                                    <i class=\"fa fa-angle-right\"></i>\n");
      out.write("                                                </a>\n");
      out.write("                                            </div>\n");
      out.write("                                        </li>\n");
      out.write("                                    </ul>\n");
      out.write("                                </li>\n");
      out.write("                                <li>\n");
      out.write("                                    <a href=\"#\"><i class=\"glyphicon glyphicon-calendar fa fa-calendar\"></i>\n");
      out.write("                                        <span>December 30, 2014</span></a>\n");
      out.write("                                </li>\n");
      out.write("                            </ul>\n");
      out.write("                        </nav>\n");
      out.write("                    </div>\n");
      out.write("                    \n");
      out.write("                </div>\n");
      out.write("                <!-- /top navigation -->\n");
      out.write("                \n");
      out.write("                <!-- page content -->\n");
      out.write("                <div class=\"right_col\" role=\"main\">\n");
      out.write("                    <div class=\"\">\n");
      out.write("                        \n");
      out.write("                        <div class=\"page-title\">\n");
      out.write("                            <div class=\"title_left\">\n");
      out.write("                                <h3>Inquiries</h3>\n");
      out.write("                            </div>\n");
      out.write("                            \n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"clearfix\"></div>\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"col-md-12 col-sm-12 col-xs-12\">\n");
      out.write("                                <div class=\"x_panel\">\n");
      out.write("                                    <div class=\"x_title\">\n");
      out.write("                                        \n");
      out.write("                                        <h4>Unreplied</h4>\n");
      out.write("                                        \n");
      out.write("                                        <div class=\"clearfix\"></div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"x_content\">\n");
      out.write("                                        <br />\n");
      out.write("                                        \n");
      out.write("                                        \n");
      out.write("                                        <table class=\"table table-bordered\">\n");
      out.write("                                            <thead>\n");
      out.write("                                                <tr>\n");
      out.write("                                                    <th>Id</th>\n");
      out.write("                                                    <th>Sender</th>\n");
      out.write("                                                    <th>Message</th>\n");
      out.write("                                                    <th>Date Sent</th>\n");
      out.write("                                                    <th>Action</th>\n");
      out.write("                                                </tr>\n");
      out.write("                                            </thead>\n");
      out.write("                                            <tbody>\n");
      out.write("                                                ");
int check=1;
                                                while(results1.next()){
      out.write("\n");
      out.write("                                                <tr>\n");
      out.write("                                                    <th scope=\"row\">");
      out.print(results1.getInt("id"));
      out.write("</th>\n");
      out.write("                                                    <td>");
      out.print(results1.getString("Sender"));
      out.write("</td>\n");
      out.write("                                                    <td>");
      out.print(results1.getString("Message"));
      out.write("</td>\n");
      out.write("                                                    <td>");
      out.print(results1.getDate("Sent_Date"));
      out.write("</td>\n");
      out.write("                                                    <td style=\"width: 154px; padding-right: 0px;\">\n");
      out.write("                                                        <a href=\"#reply");
      out.print(check);
      out.write("\" data-toggle=\"modal\" style=\"background-color:#EDEDED; padding-top: 13px; border: 1px solid #F7F7F7; padding-bottom: 12px; padding-left: 12px; padding-right: 10px; margin-left: -11px; outline: none;\">\n");
      out.write("                                                            <i class=\"fa fa-reply\">Reply</i></a>\n");
      out.write("                                                        <a href=\"#deleteConfirm\" data-toggle=\"modal\" style=\"background-color:#EDEDED; padding-top: 13px; border: 1px solid #F7F7F7; padding-bottom: 12px; padding-left: 12px; padding-right: 10px; margin-left: -3px; outline: none;\">\n");
      out.write("                                                            <i class=\"fa fa-exclamation-circle\">Ignore</i></a>\n");
      out.write("                                                    </td>\n");
      out.write("                                                </tr>\n");
      out.write("                                                \n");
      out.write("                                                <div class=\"modal fade\" id=\"reply");
      out.print(check);
      out.write("\" role=\"dialog\">\n");
      out.write("                            <div class=\"modal-dialog modal-sm\">\n");
      out.write("                                <div class=\"modal-content\">\n");
      out.write("                                    <div class=\"modal-header\">\n");
      out.write("                                        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>\n");
      out.write("                                        <h4 class=\"modal-title\" >Inquiry</h4>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"modal-body\">\n");
      out.write("                                        \n");
      out.write("                                        <div class=\"portlet portlet-default\" style=\"border: 1px solid; \">\n");
      out.write("                                            \n");
      out.write("                                            <div id=\"chat\" class=\"panel-collapse collapse in\">\n");
      out.write("                                                <div>\n");
      out.write("                                                    <div class=\"portlet-body\" style=\"overflow-y: auto; overflow-x: hidden; height: 180px; padding-right: 3px;\">\n");
      out.write("                                                        <div class=\"row\">\n");
      out.write("                                                            <div class=\"col-lg-12\">\n");
      out.write("                                                                <p class=\"text-center text-muted small\">");
      out.print( (new java.util.Date()).toLocaleString());
      out.write("</p> \n");
      out.write("                                                            </div>\n");
      out.write("                                                        </div>\n");
      out.write("                                                        \n");
      out.write("                                                        <div class=\"row\">\n");
      out.write("                                                            <div class=\"col-lg-12\">\n");
      out.write("                                                                <div class=\"media\">\n");
      out.write("                                                                    <a class=\"pull-left\" href=\"#\">\n");
      out.write("                                                                        <i class=\"fa fa-user\"></i>\n");
      out.write("                                                                    </a>\n");
      out.write("                                                                    <div class=\"media-body\">\n");
      out.write("                                                                        <h4 class=\"media-heading\">Kipngetich Hillary\n");
      out.write("                                                                            <span class=\"small pull-right\">12:23 PM</span>\n");
      out.write("                                                                        </h4>\n");
      out.write("                                                                        <p>");
      out.print(results1.getString("Message"));
      out.write("</p>\n");
      out.write("                                                                    </div>\n");
      out.write("                                                                </div>\n");
      out.write("                                                            </div>\n");
      out.write("                                                        </div>\n");
      out.write("                                                        \n");
      out.write("                                                    </div>\n");
      out.write("                                                </div>\n");
      out.write("                                                <div class=\"well portlet-footer\">\n");
      out.write("                                                    <form role=\"form\" method=\"post\">\n");
      out.write("                                                        <div class=\"form-group\">\n");
      out.write("                                                            <textarea class=\"form-control\" placeholder=\"Enter reply...\"></textarea>\n");
      out.write("                                                        </div>\n");
      out.write("                                                        <div class=\"form-group\">\n");
      out.write("                                                            <input type=\"submit\" class=\"btn btn-success pull-right\" value=\"Send\">\n");
      out.write("                                                            <div class=\"clearfix\"></div>\n");
      out.write("                                                        </div>\n");
      out.write("                                                    </form>\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("                                            \n");
      out.write("                                        </div>\n");
      out.write("                                        \n");
      out.write("                                    </div><!-- /.modal-content -->\n");
      out.write("                                </div><!-- /.modal-dialog -->\n");
      out.write("                            </div><!-- /.modal -->\n");
      out.write("                                                ");
check++;}
      out.write("\n");
      out.write("                                                \n");
      out.write("                                            </tbody>\n");
      out.write("                                        </table>\n");
      out.write("                                        \n");
      out.write("                                        \n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        \n");
      out.write("                        <div class=\"modal fade\" id=\"reply\" role=\"dialog\">\n");
      out.write("                            <div class=\"modal-dialog modal-sm\">\n");
      out.write("                                <div class=\"modal-content\">\n");
      out.write("                                    <div class=\"modal-header\">\n");
      out.write("                                        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>\n");
      out.write("                                        <h4 class=\"modal-title\" >Inquiry</h4>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"modal-body\">\n");
      out.write("                                        \n");
      out.write("                                        <div class=\"portlet portlet-default\" style=\"border: 1px solid; \">\n");
      out.write("                                            \n");
      out.write("                                            <div id=\"chat\" class=\"panel-collapse collapse in\">\n");
      out.write("                                                <div>\n");
      out.write("                                                    <div class=\"portlet-body\" style=\"overflow-y: auto; overflow-x: hidden; height: 180px; padding-right: 3px;\">\n");
      out.write("                                                        <div class=\"row\">\n");
      out.write("                                                            <div class=\"col-lg-12\">\n");
      out.write("                                                                <p class=\"text-center text-muted small\">");
      out.print( (new java.util.Date()).toLocaleString());
      out.write("</p> \n");
      out.write("                                                            </div>\n");
      out.write("                                                        </div>\n");
      out.write("                                                        \n");
      out.write("                                                        <div class=\"row\">\n");
      out.write("                                                            <div class=\"col-lg-12\">\n");
      out.write("                                                                <div class=\"media\">\n");
      out.write("                                                                    <a class=\"pull-left\" href=\"#\">\n");
      out.write("                                                                        <i class=\"fa fa-user\"></i>\n");
      out.write("                                                                    </a>\n");
      out.write("                                                                    <div class=\"media-body\">\n");
      out.write("                                                                        <h4 class=\"media-heading\">Kipngetich Hillary\n");
      out.write("                                                                            <span class=\"small pull-right\">12:23 PM</span>\n");
      out.write("                                                                        </h4>\n");
      out.write("                                                                        <p>Hi, I wanted to make sure you got the latest product report. Did Roddy get it to you?\n");
      out.write("                                                                            Hi, I wanted to make sure you got the latest product report. Did Roddy get it to you?\n");
      out.write("                                                                            Hi, I wanted to make sure you got the latest product report. Did Roddy get it to you?\n");
      out.write("                                                                            Hi, I wanted to make sure you got the latest product report. Did Roddy get it to you?\n");
      out.write("                                                                            Hi, I wanted to make sure you got the latest product report. Did Roddy get it to you?</p>\n");
      out.write("                                                                    </div>\n");
      out.write("                                                                </div>\n");
      out.write("                                                            </div>\n");
      out.write("                                                        </div>\n");
      out.write("                                                        \n");
      out.write("                                                    </div>\n");
      out.write("                                                </div>\n");
      out.write("                                                <div class=\"well portlet-footer\">\n");
      out.write("                                                    <form role=\"form\" method=\"post\">\n");
      out.write("                                                        <div class=\"form-group\">\n");
      out.write("                                                            <textarea class=\"form-control\" placeholder=\"Enter reply...\"></textarea>\n");
      out.write("                                                        </div>\n");
      out.write("                                                        <div class=\"form-group\">\n");
      out.write("                                                            <input type=\"submit\" class=\"btn btn-success pull-right\" value=\"Send\">\n");
      out.write("                                                            <div class=\"clearfix\"></div>\n");
      out.write("                                                        </div>\n");
      out.write("                                                    </form>\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("                                            \n");
      out.write("                                        </div>\n");
      out.write("                                        \n");
      out.write("                                    </div><!-- /.modal-content -->\n");
      out.write("                                </div><!-- /.modal-dialog -->\n");
      out.write("                            </div><!-- /.modal -->\n");
      out.write("                                                      \n");
      out.write("                        </div>\n");
      out.write("                        <!-- /page content -->\n");
      out.write("                        \n");
      out.write("                    </div>\n");
      out.write("                    \n");
      out.write("                    <div class=\"modal fade\" id=\"deleteConfirm\" role=\"dialog\">\n");
      out.write("                        <div class=\"modal-dialog modal-sm\">\n");
      out.write("                            <div class=\"modal-content\">\n");
      out.write("                                <div class=\"modal-header\">\n");
      out.write("                                    <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>\n");
      out.write("                                    <h4 class=\"modal-title\" >Confirm</h4>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"modal-body\">\n");
      out.write("                                    <h5>Are you sure you want to ignore?</h5>\n");
      out.write("                                    <form method=\"post\" action=\"\">\n");
      out.write("                                        <div class=\"\">\n");
      out.write("                                            <button type=\"button\" class=\"btn btn-info\" data-dismiss=\"modal\">Cancel</button>\n");
      out.write("                                            <button type=\"submit\" name=\"delete\" class=\"btn btn-danger\">Ignore</button> \n");
      out.write("                                        </div>\n");
      out.write("                                    </form>\n");
      out.write("                                </div>\n");
      out.write("                                \n");
      out.write("                            </div><!-- /.modal-content -->\n");
      out.write("                        </div><!-- /.modal-dialog -->\n");
      out.write("                    </div><!-- /.modal -->\n");
      out.write("                    \n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("            \n");
      out.write("            <!-- chart js -->\n");
      out.write("            <script src=\"js/chartjs/chart.min.js\"></script>\n");
      out.write("            <!-- bootstrap progress js -->\n");
      out.write("            <script src=\"js/progressbar/bootstrap-progressbar.min.js\"></script>\n");
      out.write("            <script src=\"js/nicescroll/jquery.nicescroll.min.js\"></script>\n");
      out.write("            <!-- icheck -->\n");
      out.write("            <script src=\"js/icheck/icheck.min.js\"></script>\n");
      out.write("            <!-- tags -->\n");
      out.write("            <script src=\"js/tags/jquery.tagsinput.min.js\"></script>\n");
      out.write("            <!-- switchery -->\n");
      out.write("            <script src=\"js/switchery/switchery.min.js\"></script>\n");
      out.write("            <!-- daterangepicker -->\n");
      out.write("            <script type=\"text/javascript\" src=\"js/moment.min2.js\"></script>\n");
      out.write("            <script type=\"text/javascript\" src=\"js/datepicker/daterangepicker.js\"></script>\n");
      out.write("            <!-- richtext editor -->\n");
      out.write("            <script src=\"js/editor/bootstrap-wysiwyg.js\"></script>\n");
      out.write("            <script src=\"js/editor/external/jquery.hotkeys.js\"></script>\n");
      out.write("            <script src=\"js/editor/external/google-code-prettify/prettify.js\"></script>\n");
      out.write("            <!-- select2 -->\n");
      out.write("            <script src=\"js/select/select2.full.js\"></script>\n");
      out.write("            <!-- form validation -->\n");
      out.write("            <script type=\"text/javascript\" src=\"js/parsley/parsley.min.js\"></script>\n");
      out.write("            <!-- textarea resize -->\n");
      out.write("            <script src=\"js/textarea/autosize.min.js\"></script>\n");
      out.write("            <!-- Autocomplete -->\n");
      out.write("            <script type=\"text/javascript\" src=\"js/autocomplete/countries.js\"></script>\n");
      out.write("            <script src=\"js/autocomplete/jquery.autocomplete.js\"></script>\n");
      out.write("            \n");
      out.write("            <script src=\"js/custom.js\"></script>\n");
      out.write("            \n");
      out.write("            \n");
      out.write("    </body>\n");
      out.write("    \n");
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
