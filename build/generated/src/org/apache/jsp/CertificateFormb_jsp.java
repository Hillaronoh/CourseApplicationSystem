package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class CertificateFormb_jsp extends org.apache.jasper.runtime.HttpJspBase
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
Class.forName("com.mysql.jdbc.Driver"); 
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("  <meta charset=\"utf-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <title>Certificate Application</title>\n");
      out.write("    <!-- Core CSS - Include with every page -->\n");
      out.write("    <link href=\"assets/plugins/bootstrap/bootstrap.css\" rel=\"stylesheet\" />\n");
      out.write("    <link href=\"assets/font-awesome/css/font-awesome.css\" rel=\"stylesheet\" />\n");
      out.write("    <link href=\"assets/plugins/pace/pace-theme-big-counter.css\" rel=\"stylesheet\" />\n");
      out.write("    <link href=\"assets/css/style.css\" rel=\"stylesheet\" />\n");
      out.write("    <link href=\"assets/css/main-style.css\" rel=\"stylesheet\" />\n");
      out.write("    <link rel=\"stylesheet\" href=\"mycss/style2.css\" style type=\"text/css\">\n");
      out.write("    \n");
      out.write("\n");
      out.write("    \n");
      out.write(" <link rel=\"stylesheet\" href=\"layout/bootstrap/css/bootstrap.css\" type=\"text/css\">\n");
      out.write("\n");
      out.write("<script type=\"text/javascript\" src=\"mycss/validate.js\"></script>\n");
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
      out.write("            <div class=\"row\" style=\"margin-top: 80px;\">\n");
      out.write("                <div class=\"col-md-4 col-md-offset-4\" style=\"width: auto; padding-left: auto; padding-right: auto; margin-left: 145px; margin-right: auto;\">\n");
      out.write("\t\t\t\n");
      out.write("                    <div class=\"login-panel panel panel-default\">\n");
      out.write("   \n");
      out.write("\n");
      out.write("                    <div class=\"panel-heading\">\n");
      out.write("                        <h3 class=\"panel-title\" style=\"text-align: center;\">Welcome New User! Sign Up Below.</h3>\n");
      out.write("                    </div>\n");
      out.write("                  <div class=\"panel-body\">\n");
      out.write("                        \n");
      out.write("                        <form name=\"registration\" method=\"post\" action=\"\" onsubmit=\"return validateForm(this)\"><br>\n");
      out.write("  <fieldset>\n");
      out.write("\n");
      out.write("  <table style=\"width: 600px; height: 350px;\">\n");
      out.write("\t<tbody>\n");
      out.write(" \n");
      out.write("\n");
      out.write("<tr>\n");
      out.write("    <td align=\"right\" valign=\"top\" style=\"padding-top:10px;\">First Name:<span style=\"color:red\"> *</span> &nbsp;&nbsp;&nbsp;</td>\n");
      out.write("    <td valign=\"top\"><input style=\"height:30px; width:300px;\" autocomplete=\"off\" name=\"fname\" id=\"surname\" type=\"text\" autofocus>\n");
      out.write("    <span id=\"fnameError\" style=\"color: #ff6699;\"></span>\n");
      out.write("    </td>\n");
      out.write("\t<td valign=\"top\"></td>\n");
      out.write("</tr>\n");
      out.write("<tr>\n");
      out.write("\t<td align=\"right\" valign=\"top\" style=\"padding-top:10px;\">Middle Name:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n");
      out.write("\t<td valign=\"top\"><input style=\"height:30px; width:300px;\" autocomplete=\"off\" name=\"mname\" id=\"mname\" type=\"text\">\n");
      out.write("        <span id=\"mnameError\"> </span>\n");
      out.write("        </td>\n");
      out.write("\t<td valign=\"top\"></td>\n");
      out.write("</tr>\n");
      out.write("<tr>\n");
      out.write("\t<td align=\"right\" valign=\"top\" style=\"padding-top:10px;\">Last Name:<span style=\"color:red\"> *</span>&nbsp;&nbsp;&nbsp;&nbsp;</td>\n");
      out.write("\t<td valign=\"top\"><input style=\"height:30px; width:300px;\" autocomplete=\"off\" name=\"lname\" id=\"lname\" type=\"text\">\n");
      out.write("        <span id=\"lnameError\" style=\"color: #ff6699;\"> </span>\n");
      out.write("        </td>\n");
      out.write("\t<td valign=\"top\"></td>\n");
      out.write("</tr>\n");
      out.write("\n");
      out.write("<tr>\n");
      out.write("\t<td align=\"right\" valign=\"top\" style=\"padding-top:10px;\">Gender:<span style=\"color:red\"> *</span>&nbsp;&nbsp;&nbsp;&nbsp;</td>\n");
      out.write("\t<td valign=\"top\"><input style=\"height:30px; width:300px;\" autocomplete=\"off\" name=\"gender\" id=\"idnum\" type=\"email\">\n");
      out.write("        <span id=\"emailError\" style=\"color: #ff6699;\"> </span>\n");
      out.write("        </td>\n");
      out.write("\t<td valign=\"top\"></td>\n");
      out.write("</tr>\n");
      out.write("<tr >\n");
      out.write("\t<td align=\"right\" valign=\"top\" style=\"padding-top:10px;\">Date Of Birth:<span style=\"color:red\"> *</span>&nbsp;&nbsp;&nbsp;&nbsp;</td>\n");
      out.write("\t<td valign=\"top\"><input style=\"height:30px; width:300px;\" autocomplete=\"off\" name=\"dob\" id=\"pwd\" type=\"password\" >\n");
      out.write("        <span id=\"password1Error\" style=\"color: #ff6699;\"> </span>\n");
      out.write("        </td>\n");
      out.write("\t<td valign=\"top\"></td>\n");
      out.write("</tr>\n");
      out.write("\n");
      out.write("<tr>\n");
      out.write("\t<td align=\"right\" valign=\"top\" style=\"padding-top:10px;\">Postal Address:<span style=\"color:red\"></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n");
      out.write("\t<td valign=\"top\"><input style=\"height:30px; width:300px;\"  autocomplete=\"off\" name=\"pa\" id=\"mobnumber\" type=\"password\">\n");
      out.write("        <span id=\"password2Error\" style=\"color: #ff6699;\"> </span>\n");
      out.write("        </td>\n");
      out.write("\t<td valign=\"top\"></td>\n");
      out.write("</tr>\n");
      out.write("\n");
      out.write("<tr>\n");
      out.write("\t<td align=\"right\" valign=\"top\" style=\"padding-top:10px;\">Mobile:<span style=\"color:red\"></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n");
      out.write("\t<td valign=\"top\"><input style=\"height:30px; width:300px;\"  autocomplete=\"off\" name=\"mobile\" id=\"mobnumber\" type=\"password\">\n");
      out.write("        <span id=\"password2Error\" style=\"color: #ff6699;\"> </span>\n");
      out.write("        </td>\n");
      out.write("\t<td valign=\"top\"></td>\n");
      out.write("</tr>\n");
      out.write("\n");
      out.write("<tr>\n");
      out.write("\t<td align=\"right\" valign=\"top\" style=\"padding-top:10px;\">Nationality:<span style=\"color:red\"></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n");
      out.write("\t<td valign=\"top\"><input style=\"height:30px; width:300px;\"  autocomplete=\"off\" name=\"country\" id=\"mobnumber\" type=\"password\">\n");
      out.write("        <span id=\"password2Error\" style=\"color: #ff6699;\"> </span>\n");
      out.write("        </td>\n");
      out.write("\t<td valign=\"top\"></td>\n");
      out.write("</tr>\n");
      out.write("\n");
      out.write("<tr>\n");
      out.write("\t<td align=\"right\" valign=\"top\" style=\"padding-top:10px;\">K.C.S.E Physics Grade:<span style=\"color:red\"></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n");
      out.write("\t<td valign=\"top\"><input style=\"height:30px; width:300px;\"  autocomplete=\"off\" name=\"physics\" id=\"mobnumber\" type=\"password\">\n");
      out.write("        <span id=\"password2Error\" style=\"color: #ff6699;\"> </span>\n");
      out.write("        </td>\n");
      out.write("\t<td valign=\"top\"></td>\n");
      out.write("</tr>\n");
      out.write("\n");
      out.write("<tr>\n");
      out.write("\t<td align=\"right\" valign=\"top\" style=\"padding-top:10px;\">K.C.S.E Maths Grade:<span style=\"color:red\"></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n");
      out.write("\t<td valign=\"top\"><input style=\"height:30px; width:300px;\"  autocomplete=\"off\" name=\"maths\" id=\"mobnumber\" type=\"password\">\n");
      out.write("        <span id=\"password2Error\" style=\"color: #ff6699;\"> </span>\n");
      out.write("        </td>\n");
      out.write("\t<td valign=\"top\"></td>\n");
      out.write("</tr>\n");
      out.write("\n");
      out.write("<tr>\n");
      out.write("\t<td align=\"right\" valign=\"top\" style=\"padding-top:10px;\">K.C.S.E Mean Grade:<span style=\"color:red\"></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n");
      out.write("\t<td valign=\"top\"><input style=\"height:30px; width:300px;\"  autocomplete=\"off\" name=\"meangrade\" id=\"mobnumber\" type=\"password\">\n");
      out.write("        <span id=\"password2Error\" style=\"color: #ff6699;\"> </span>\n");
      out.write("        </td>\n");
      out.write("\t<td valign=\"top\"></td>\n");
      out.write("</tr>\n");
      out.write("\n");
      out.write("<tr>\n");
      out.write("\t<td align=\"right\" valign=\"top\" style=\"padding-top:10px;\">K.C.S.E Aggregate Points:<span style=\"color:red\"></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n");
      out.write("\t<td valign=\"top\"><input style=\"height:30px; width:300px;\"  autocomplete=\"off\" name=\"aggregatepoints\" id=\"mobnumber\" type=\"password\">\n");
      out.write("        <span id=\"password2Error\" style=\"color: #ff6699;\"> </span>\n");
      out.write("        </td>\n");
      out.write("\t<td valign=\"top\"></td>\n");
      out.write("</tr>\n");
      out.write("\n");
      out.write("<tr>\n");
      out.write("\t<td align=\"right\" valign=\"top\" style=\"padding-top:10px;\">Select Programme:<span style=\"color:red\"></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n");
      out.write("\t<td valign=\"top\"><input style=\"height:30px; width:300px;\"  autocomplete=\"off\" name=\"programme\" id=\"mobnumber\" type=\"password\">\n");
      out.write("        <span id=\"password2Error\" style=\"color: #ff6699;\"> </span>\n");
      out.write("        </td>\n");
      out.write("\t<td valign=\"top\"></td>\n");
      out.write("</tr>\n");
      out.write("\n");
      out.write("<tr>\n");
      out.write("\t<td align=\"right\" valign=\"top\"></td>\n");
      out.write("\t<td valign=\"top\"><strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n");
      out.write("            <input type=\"submit\" name=\"register\" class=\"btn btn-success\" style=\"width:25%;\" value=\"Register\" id=\"submit\"></strong> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n");
      out.write("            <strong><input name=\"reset\" class=\"btn btn-info\" style=\"width:25%;\" value=\"Reset\" id=\"clear\" type=\"reset\"></strong> <br/></td>\n");
      out.write("\t<td valign=\"top\"></td>\n");
      out.write("\t\n");
      out.write("</tr>\n");
      out.write("\n");
      out.write("  </tbody>\n");
      out.write("  </table>  \n");
      out.write("  </fieldset>\n");
      out.write(" <a href=\"UserLogin.jsp\" style=\"float: right;\">Sign In Here</a>\n");
      out.write("</form>\n");
      out.write("                        \n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("       \n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("     <!-- Core Scripts - Include with every page -->\n");
      out.write("    <script src=\"assets/plugins/jquery-1.10.2.js\"></script>\n");
      out.write("    <script src=\"assets/plugins/bootstrap/bootstrap.min.js\"></script>\n");
      out.write("    <script src=\"assets/plugins/metisMenu/jquery.metisMenu.js\"></script>\n");
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
