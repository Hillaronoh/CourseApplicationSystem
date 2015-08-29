package org.apache.jsp.Admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import myproject.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

public final class RankCertApp_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write(" \n");
      out.write("\n");
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
      out.write("        <title> Ranking | Certificate </title>\n");
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

           response.setHeader("Cache-Control","no-cache"); //Forces caches to obtain a new copy of the page from the origin server
           response.setHeader("Cache-Control","no-store"); //Directs caches not to store the page under any circumstance
           response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
           response.setHeader("Pragma","no-cache"); //HTTP 1.0 backward compatibility
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
      out.write("       \n");
      out.write("            ");

            String months[] = {
                "January", "February", "March", "April",
                "May", "June", "July", "August",
                "September", "October", "November", "December"};
            GregorianCalendar gcalendar = new GregorianCalendar();
            String month=months[gcalendar.get(Calendar.MONTH)];
            int day=gcalendar.get(Calendar.DATE);
            int year=gcalendar.get(Calendar.YEAR);
            
            Admin admin=new Admin();
            String firstName=new String();
           
            ResultSet results=admin.getAdmin(adminId);
           
            if(results.next()){
                firstName=results.getString("First_Name");
            }
            
            if(request.getParameter("post")!=null){
                String title=request.getParameter("title");
                String body=request.getParameter("body");
                int results1=admin.setAnnouncement(title, body);
                if(results1>0){
      out.write("\n");
      out.write("                <script type=\"text/javascript\">\n");
      out.write("                    alert(\"Announcement posted successfully.\");\n");
      out.write("                    window.location.href=\"RankCertApp.jsp\";\n");
      out.write("                </script>\n");
      out.write("                ");
} else{
      out.write("\n");
      out.write("                <script type=\"text/javascript\">\n");
      out.write("                    alert(\"Problem encountered! Try again.\");\n");
      out.write("                    window.location.href=\"RankCertApp.jsp\";\n");
      out.write("                </script> \n");
      out.write("                ");
}
            }
            
            if(request.getParameter("rank")!=null){
                int levelId=5;
                int courseIdIt=2;
                int courseIdCf=4;
                int courseIdIs=5;
                int courseIdHm=6;
                int requiredNumberIt=Integer.parseInt(request.getParameter("it"));
                int requiredNumberCf=Integer.parseInt(request.getParameter("cf"));
                int requiredNumberIs=Integer.parseInt(request.getParameter("is"));
                int requiredNumberHm=Integer.parseInt(request.getParameter("hm"));
                int r1=admin.ranking(levelId, courseIdIt, requiredNumberIt);
                int r2=admin.ranking(levelId, courseIdCf, requiredNumberCf);
                int r3=admin.ranking(levelId, courseIdIs, requiredNumberIs);
                int r4=admin.ranking(levelId, courseIdHm, requiredNumberHm);
                if(r1>0&&r2>0&&r3>0&&r4>0){
      out.write("\n");
      out.write("                <script>\n");
      out.write("                    alert(\"Ranking Successful\");\n");
      out.write("                    window.location.href=\"RankCertApp.jsp\";\n");
      out.write("                </script>\n");
      out.write("                ");
}else{
      out.write("\n");
      out.write("                <script>\n");
      out.write("                    alert(\"Problem encountered! Try again.\");\n");
      out.write("                    window.location.href=\"RankCertApp.jsp\";\n");
      out.write("                </script>  \n");
      out.write("                ");
}
            }
            if(request.getParameter("undo")!=null){
                int r=admin.undoRanking(5);
                if(r>0){
      out.write("\n");
      out.write("                <script>\n");
      out.write("                    alert(\"Ranking undone successfully.\");\n");
      out.write("                    window.location.href=\"RankCertApp.jsp\";\n");
      out.write("                </script>\n");
      out.write("                ");
}else{
      out.write("\n");
      out.write("                <script>\n");
      out.write("                    alert(\"Problem encountered! Try again.\");\n");
      out.write("                    window.location.href=\"RankCertApp.jsp\";\n");
      out.write("                </script>  \n");
      out.write("                ");
}
            }
            
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
      out.write("                                <h3>Menu</h3>\n");
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
      out.write("\n");
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
      out.write("                                        <span>");
      out.print( month);
      out.write(' ');
      out.print( day);
      out.write(',');
      out.write(' ');
      out.print( year);
      out.write("</span></a>\n");
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
      out.write("                                <h3>Rank</h3>\n");
      out.write("                            </div>\n");
      out.write("                            \n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"clearfix\"></div>\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"col-md-12 col-sm-12 col-xs-12\">\n");
      out.write("                                <div class=\"x_panel\">\n");
      out.write("                                    <div class=\"x_title\">\n");
      out.write("                                        \n");
      out.write("                                        <h4>Cetificate Applicants</h4>\n");
      out.write("                                        <div class=\"clearfix\"></div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"x_content\">\n");
      out.write("                                        <br />\n");
      out.write("                                        \n");
      out.write("                                        <div class=\"row\">\n");
      out.write("                                            <form class=\"form-horizontal\">\n");
      out.write("                                                <div class=\"col-sm-5 panel panel-default\" style=\"padding: 15px 15px;\">\n");
      out.write("                                                    <fieldset> <legend>Specify the number of applicants as follows:</legend></fieldset>\n");
      out.write("                                                    <label for=\"it\">Information Technology:</label>\n");
      out.write("                                                    <input type=\"number\" class=\"form-control input\" id=\"it\" name=\"it\" placeholder=\"Number of IT applicants\"/><br/>\n");
      out.write("                                                    \n");
      out.write("                                                    <label for=\"cf\">Computer Forensics:</label>\n");
      out.write("                                                    <input type=\"number\" class=\"form-control input\" id=\"cf\" name=\"cf\" placeholder=\"Number of computer forensics applicants\"/><br/>\n");
      out.write("                                                    \n");
      out.write("                                                    <label for=\"is\">Information Studies:</label>\n");
      out.write("                                                    <input type=\"number\" class=\"form-control input\" id=\"is\" name=\"is\" placeholder=\"Number of information studies applicants\"/><br/> \n");
      out.write("                                                    \n");
      out.write("                                                    <label for=\"hm\">Hardware Maintenance:</label>\n");
      out.write("                                                    <input type=\"number\" class=\"form-control input\" id=\"hm\" name=\"hm\" placeholder=\"Number of hardware maintenance applicants\"/><br/> \n");
      out.write("                                                </div>\n");
      out.write("                                                <div class=\"col-sm-1\"></div>\n");
      out.write("                                                <div class=\"col-sm-3 panel panel-default\">\n");
      out.write("                                                    <fieldset> <legend>Actions</legend></fieldset>\n");
      out.write("                                                    <button type=\"submit\" class=\"btn btn-success btn-block\" name=\"rank\"><i class=\"fa fa-check-square-o\"></i>Rank</button><br/>\n");
      out.write("                                                    <button type=\"reset\" class=\"btn btn-info btn-block\" name=\"reset\"><i class=\"fa fa-close\"></i>Reset</button><br/>\n");
      out.write("                                                    <button type=\"submit\" class=\"btn btn-danger btn-block\" name=\"undo\"><i class=\"fa fa-undo\"></i>Undo Ranking</button><br/>\n");
      out.write("                                                </div>\n");
      out.write("                                                <div class=\"col-sm-1\"></div>\n");
      out.write("                                                <div class=\"col-sm-2 panel panel-default\">\n");
      out.write("                                                    <fieldset><legend>Note</legend></fieldset>\n");
      out.write("                                                    <p>Specifying zero in any field means you don't want to rank the concerned applicants</p>\n");
      out.write("                                                </div>\n");
      out.write("                                            </form>\n");
      out.write("                                        </div>\n");
      out.write("                                        \n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        \n");
      out.write("                        <div class=\"modal fade\" id=\"postAnnouncement\" role=\"dialog\">\n");
      out.write("                            <div class=\"modal-dialog\" style=\"width: 500px;\">\n");
      out.write("                                <div class=\"modal-content\">\n");
      out.write("                                    <div class=\"modal-header\">\n");
      out.write("                                        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>\n");
      out.write("                                        <h4 class=\"modal-title\" >Post Announcement</h4>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"modal-body\">\n");
      out.write("                                        \n");
      out.write("                                        <form method=\"post\" action=\"\">\n");
      out.write("                                            <input type=\"text\" name=\"title\" placeholder=\"Announcement Title...\" size=\"56\">\n");
      out.write("                                            <textarea name=\"body\" placeholder=\"Announcement Body...\" style=\"width: 468px; height: 100px;\"></textarea>\n");
      out.write("                                \n");
      out.write("                                            <div class=\"well modal-footer\">\n");
      out.write("                                                <button type=\"reset\" class=\"btn btn-default\">Clear</button>\n");
      out.write("                                                <button type=\"submit\" class=\"btn btn-primary\" name=\"post\">Post</button>\n");
      out.write("                                            </div>\n");
      out.write("                                        </form>\n");
      out.write("                                    </div>\n");
      out.write("                        \n");
      out.write("                                </div><!-- /.modal-content -->\n");
      out.write("                            </div><!-- /.modal-dialog -->\n");
      out.write("                        </div><!-- /.modal -->\n");
      out.write("                        \n");
      out.write("                    </div>\n");
      out.write("                    <!-- /page content -->\n");
      out.write("                    \n");
      out.write("                    \n");
      out.write("                </div>\n");
      out.write("                \n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        <div id=\"custom_notifications\" class=\"custom-notifications dsp_none\">\n");
      out.write("            <ul class=\"list-unstyled notifications clearfix\" data-tabbed_notifications=\"notif-group\">\n");
      out.write("            </ul>\n");
      out.write("            <div class=\"clearfix\"></div>\n");
      out.write("            <div id=\"notif-group\" class=\"tabbed_notifications\"></div>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("        \n");
      out.write("        <!-- chart js -->\n");
      out.write("        <script src=\"js/chartjs/chart.min.js\"></script>\n");
      out.write("        <!-- bootstrap progress js -->\n");
      out.write("        <script src=\"js/progressbar/bootstrap-progressbar.min.js\"></script>\n");
      out.write("        <script src=\"js/nicescroll/jquery.nicescroll.min.js\"></script>\n");
      out.write("        <!-- icheck -->\n");
      out.write("        <script src=\"js/icheck/icheck.min.js\"></script>\n");
      out.write("        <!-- tags -->\n");
      out.write("        <script src=\"js/tags/jquery.tagsinput.min.js\"></script>\n");
      out.write("        <!-- switchery -->\n");
      out.write("        <script src=\"js/switchery/switchery.min.js\"></script>\n");
      out.write("        <!-- daterangepicker -->\n");
      out.write("        <script type=\"text/javascript\" src=\"js/moment.min2.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"js/datepicker/daterangepicker.js\"></script>\n");
      out.write("        <!-- richtext editor -->\n");
      out.write("        <script src=\"js/editor/bootstrap-wysiwyg.js\"></script>\n");
      out.write("        <script src=\"js/editor/external/jquery.hotkeys.js\"></script>\n");
      out.write("        <script src=\"js/editor/external/google-code-prettify/prettify.js\"></script>\n");
      out.write("        <!-- select2 -->\n");
      out.write("        <script src=\"js/select/select2.full.js\"></script>\n");
      out.write("        <!-- form validation -->\n");
      out.write("        <script type=\"text/javascript\" src=\"js/parsley/parsley.min.js\"></script>\n");
      out.write("        <!-- textarea resize -->\n");
      out.write("        <script src=\"js/textarea/autosize.min.js\"></script>\n");
      out.write("        <script>\n");
      out.write("            autosize($('.resizable_textarea'));\n");
      out.write("        </script>\n");
      out.write("        <!-- Autocomplete -->\n");
      out.write("        <script type=\"text/javascript\" src=\"js/autocomplete/countries.js\"></script>\n");
      out.write("        <script src=\"js/autocomplete/jquery.autocomplete.js\"></script>\n");
      out.write("        \n");
      out.write("        <script src=\"js/custom.js\"></script>\n");
      out.write("        \n");
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
