package org.apache.jsp.Applicants;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.text.DecimalFormat;

public final class Try_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!--DOCTYPE-->\n");
      out.write("\n");
      out.write(" \n");
Class.forName("com.mysql.jdbc.Driver"); 
      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("<title>Application Form</title>\n");
      out.write("<!--start favicon--><link rel=\"shortcut icon\" href=\"image/favicon.ico\"><!--end favicon-->\n");
      out.write("<!--starts accordion advice-->\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"mycss/accordion2/defaults.css\">\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"mycss/accordion2/demo.css\">\n");
      out.write("<script type=\"text/javascript\" src=\"mycss/accordion2/jquery.min.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"mycss/accordion2/accordion.js\"></script>\n");
      out.write("<!--ends accordion advice-->\n");
      out.write("<!--start datepicker-->\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" media=\"all\" href=\"datepicker/jsDatePick_ltr.min.css\" />\n");
      out.write("<script type=\"text/javascript\" src=\"datepicker/jsDatePick.min.1.3.js\"></script>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("\twindow.onload = function(){\n");
      out.write("\t\tnew JsDatePick({\n");
      out.write("\t\t\tuseMode:2,\n");
      out.write("\t\t\ttarget:\"inputField\",\n");
      out.write("\t\t\tdateFormat:\"%Y-%m-%d\"\n");
      out.write("\t\t\t/*selectedDate:{\t\t\t\tThis is an example of what the full configuration offers.\n");
      out.write("\t\t\t\tday:5,\t\t\t\t\t\tFor full documentation about these settings please see the full version of the code.\n");
      out.write("\t\t\t\tmonth:9,\n");
      out.write("\t\t\t\tyear:2006\n");
      out.write("\t\t\t},\n");
      out.write("\t\t\tyearsRange:[1978,2020],\n");
      out.write("\t\t\tlimitToToday:false,\n");
      out.write("\t\t\tcellColorScheme:\"beige\",\n");
      out.write("\t\t\tdateFormat:\"%m-%d-%Y\",\n");
      out.write("\t\t\timgPath:\"img/\",\n");
      out.write("\t\t\tweekStartDay:1*/\n");
      out.write("\t\t});\n");
      out.write("\t};\n");
      out.write("</script>\n");
      out.write("<!--end datepicker-->  \n");
      out.write("<!--start accordions-->\n");
      out.write("<link rel=\"stylesheet\" href=\"css/jquery.mobile-1.4.5.min.css\">\n");
      out.write("<script src=\"js/jquery-1.11.3.min.js\"></script>\n");
      out.write("<script src=\"js/jquery.mobile-1.4.5.min.js\"></script>\n");
      out.write("<link rel=\"stylesheet\" href=\"layout/styles/layout.css\"> \n");
      out.write("<!--start accordions-->\n");
      out.write("<!-- Core CSS - Include with every page -->\n");
      out.write("<link href=\"assets/plugins/bootstrap/bootstrap.css\" rel=\"stylesheet\" />\n");
      out.write("<link href=\"assets/font-awesome/css/font-awesome.css\" rel=\"stylesheet\" />\n");
      out.write("<link href=\"assets/plugins/pace/pace-theme-big-counter.css\" rel=\"stylesheet\" />\n");
      out.write("<link href=\"assets/css/style.css\" rel=\"stylesheet\" />\n");
      out.write("<link href=\"assets/css/main-style.css\" rel=\"stylesheet\" />\n");
      out.write("<link rel=\"stylesheet\" href=\"mycss/style2.css\" style type=\"text/css\">\n");
      out.write("<script type=\"text/javascript\" src=\"mycss/validate.js\"></script> \n");
      out.write("</head> \n");
      out.write("<body style=\"overflow-x: hidden; background-color: #EFEEEE;\">\n");
      out.write("    <div class=\"container-fluid\">\n");
      out.write("   <div class=\"header\"> \n");
      out.write("      <div class=\"imagelogo\" style=\"margin-left: 120px; margin-top: 10px;\"><img src=\"image/mmustlogo.png\" style=\"width: 100px; height: 100px;\"/></div>\n");
      out.write("    \n");
      out.write("    <div class=\"mmust_title\">\n");
      out.write("        <h1 class=\"style1\">MASINDE MULIRO UNIVERSITY OF SCIENCE AND TECHNOLOGY</h1>\n");
      out.write("      <h2 class=\"style2\">DEPARTMENT OF COMPUTER SCIENCE </h2>\n");
      out.write("    </div>\n");
      out.write("\t\n");
      out.write("  </div>\n");
      out.write("        \n");
      out.write("    \n");
      out.write("    <!--Starts main content --> \n");
      out.write(" <div class=\"row\" style=\"margin-top: 50px;\">\n");
      out.write("     <div class=\"col-md-4 col-md-offset-4\" style=\"width: 1000px; margin-left: 200px;\"> \n");
      out.write("     <div class=\"login-panel panel panel-default\">\n");
      out.write("         \n");
      out.write("         <div class=\"panel-heading\">\n");
      out.write("              <h3 class=\"panel-title\" style=\"text-align: center;\">Provide The required Information in the Sections Below.</h3>\n");
      out.write("         </div>\n");
      out.write("         \n");
      out.write("   <div class=\"panel-body\">\n");
      out.write("  \n");
      out.write("   <!--Starts collapsible SECTION A--> \n");
      out.write("  <div data-role=\"main\" class=\"ui-content\">\n");
      out.write("    <div data-role=\"collapsible\">\n");
      out.write("  \n");
      out.write("        <h1>SECTION A: Applicants Personal Details</h1><br>\n");
      out.write("      \n");
      out.write("      <form name=\"registration\" method=\"post\" action=\"Try.jsp\" onsubmit=\"return validateForm(this)\">\n");
      out.write("      <fieldset>\n");
      out.write("         <table style=\"width: 600px; height: 50px;\">\n");
      out.write("           <tbody>\n");
      out.write("                                    <tr>\n");
      out.write("\t<td align=\"right\" valign=\"top\" style=\"padding-top:10px;\">First Name:<span style=\"color:red\"> *</span>&nbsp;&nbsp;&nbsp;&nbsp;</td>\n");
      out.write("        <td valign=\"top\"><input autocomplete=\"off\" name=\"fname\" id=\"fname\" type=\"text\">\n");
      out.write("        <span id=\"fnameError\" style=\"color: #ff6699;\"> </span>\n");
      out.write("        </td>\n");
      out.write("\t<td valign=\"top\"></td>\n");
      out.write("</tr>\n");
      out.write("              <tr>\n");
      out.write("\t       <td align=\"right\" valign=\"top\" style=\"padding-top:10px;\">Middle Name:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n");
      out.write("\t       <td valign=\"top\"><input autocomplete=\"off\" name=\"mname\" id=\"mname\" type=\"text\">\n");
      out.write("                <span id=\"mnameError\"> </span></td>       \n");
      out.write("\t       <td valign=\"top\"></td>\n");
      out.write("             </tr>\n");
      out.write("             <tr>\n");
      out.write("\t       <td align=\"right\" valign=\"top\" style=\"padding-top:10px;\">Last Name:<span style=\"color:red\"> *</span>&nbsp;&nbsp;&nbsp;&nbsp;</td>\n");
      out.write("\t       <td valign=\"top\"><input autocomplete=\"off\" name=\"lname\" id=\"lname\" type=\"text\">\n");
      out.write("               <span id=\"lnameError\" style=\"color: #ff6699;\"> </span></td>              \n");
      out.write("\t       <td valign=\"top\"></td>\n");
      out.write("             </tr>\n");
      out.write("\n");
      out.write("             <tr>\n");
      out.write("\t      <td align=\"right\" valign=\"top\" style=\"padding-top:10px;\">Gender:<span style=\"color:red\"> *</span>&nbsp;&nbsp;&nbsp;&nbsp;</td>\n");
      out.write("              <td valign=\"top\"><input name=\"gender\" id=\"genderMale\" value=\"Male\" type=\"radio\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Male\n");
      out.write("                  <input name=\"gender\" id=\"genderFemale\" value=\"Female\" type=\"radio\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Female\n");
      out.write("               <span id=\"genderError\" style=\"color: #ff6699;\"> </span></td>        \n");
      out.write("\t      <td valign=\"top\"></td>\n");
      out.write("            </tr>\n");
      out.write("            \n");
      out.write("            <tr>\n");
      out.write("\t      <td align=\"right\" valign=\"top\" style=\"padding-top:10px;\">Date Of Birth:<span style=\"color:red\"> *</span>&nbsp;&nbsp;&nbsp;&nbsp;</td>\n");
      out.write("\t      <td valign=\"top\"><input autocomplete=\"off\" name=\"dob\" id=\"inputField\" placeholder=\"yyyy-mm-dd\" type=\"text\" >\n");
      out.write("               <span id=\"dobError\" style=\"color: #ff6699;\"> </span> </td>       \n");
      out.write("\t      <td valign=\"top\"></td>\n");
      out.write("            </tr>\n");
      out.write("            \n");
      out.write("            <tr>\n");
      out.write("\t      <td align=\"right\" valign=\"top\" style=\"padding-top:10px;\">Postal Address:<span style=\"color:red\"></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n");
      out.write("\t      <td valign=\"top\"><input autocomplete=\"off\" name=\"postalAddress\" id=\"postalAddress\" type=\"text\">\n");
      out.write("               <span id=\"addressError\" style=\"color: #ff6699;\"> </span></td>       \n");
      out.write("\t      <td valign=\"top\"></td>\n");
      out.write("            </tr>\n");
      out.write("\n");
      out.write("           <tr>\n");
      out.write("\t    <td align=\"right\" valign=\"top\" style=\"padding-top:10px;\">Mobile:<span style=\"color:red\"></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n");
      out.write("\t    <td valign=\"top\"><input autocomplete=\"off\" name=\"mobNumber\" id=\"mobNumber\" type=\"text\">\n");
      out.write("            <span id=\"mobileError\" style=\"color: #ff6699;\"> </span></td>        \n");
      out.write("\t   <td valign=\"top\"></td>\n");
      out.write("          </tr>\n");
      out.write("\n");
      out.write("<tr>\n");
      out.write("\t<td align=\"right\" valign=\"top\" style=\"padding-top:10px;\">Nationality:<span style=\"color:red\"></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n");
      out.write("\t<td valign=\"top\"><input autocomplete=\"off\" name=\"country\" id=\"country\" type=\"text\">\n");
      out.write("        <span id=\"countryError\" style=\"color: #ff6699;\"> </span>\n");
      out.write("        </td>\n");
      out.write("\t<td valign=\"top\"></td>\n");
      out.write("</tr>\n");
      out.write("<tr>\n");
      out.write("\t<td align=\"right\" valign=\"top\"></td>\n");
      out.write("\t<td valign=\"top\"><strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n");
      out.write("                <input type=\"submit\" value=\"Submit\" name=\"submit1\"></strong> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n");
      out.write("                <strong><input name=\"reset\" value=\"Reset\" type=\"reset\"></strong> <br/></td>\n");
      out.write("\t<td valign=\"top\"></td>\n");
      out.write("\t\n");
      out.write("</tr>\n");
      out.write("                  </tbody>\n");
      out.write("              </table>\n");
      out.write("      </fieldset>\n");
      out.write("    </form>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("<!--ends collapsible SECTION A-->\n");
      out.write("    \n");
      out.write("    <!--Starts collapsible SECTION B-->\n");
      out.write("  <div data-role=\"main\" class=\"ui-content\">\n");
      out.write("    <div data-role=\"collapsible\">\n");
      out.write("        \n");
      out.write("      \n");
      out.write("              <h1>SECTION B: Applicant's Education Background</h1>  \n");
      out.write("                \n");
      out.write("      <form name=\"registration\" method=\"post\" action=\"\" onsubmit=\"\"><br>\n");
      out.write("          <fieldset>\n");
      out.write("              <table style=\"width: 600px; height: 50px;\">\n");
      out.write("                  <tbody>\n");
      out.write("                      <tr>\n");
      out.write("\t<td align=\"right\" valign=\"top\" style=\"padding-top:10px;\">K.C.S.E Physics Grade:<span style=\"color:red\"> *</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n");
      out.write("\t<td valign=\"top\"><input autocomplete=\"off\" name=\"subj1\" id=\"subj1\" type=\"text\">\n");
      out.write("        <span id=\"physcsError\" style=\"color: #ff6699;\"> </span>\n");
      out.write("        </td>\n");
      out.write("\t<td valign=\"top\"></td>\n");
      out.write("</tr>\n");
      out.write("\n");
      out.write("<tr>\n");
      out.write("\t<td align=\"right\" valign=\"top\" style=\"padding-top:10px;\">K.C.S.E Maths Grade:<span style=\"color:red\"> *</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n");
      out.write("\t<td valign=\"top\"><input autocomplete=\"off\" name=\"subj2\" id=\"subj2\" type=\"text\">\n");
      out.write("        <span id=\"mathsError\" style=\"color: #ff6699;\"> </span>\n");
      out.write("        </td>\n");
      out.write("\t<td valign=\"top\"></td>\n");
      out.write("</tr>\n");
      out.write("\n");
      out.write("<tr>\n");
      out.write("\t<td align=\"right\" valign=\"top\" style=\"padding-top:10px;\">GROUP II or any GROUP III Grade:<span style=\"color:red\"> *</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n");
      out.write("\t<td valign=\"top\"><input autocomplete=\"off\" name=\"subj3\" id=\"subj3\" type=\"text\">\n");
      out.write("        <span id=\"subj3Error\" style=\"color: #ff6699;\"> </span>\n");
      out.write("        </td>\n");
      out.write("\t<td valign=\"top\"></td>\n");
      out.write("</tr>\n");
      out.write("\n");
      out.write("<tr>\n");
      out.write("\t<td align=\"right\" valign=\"top\" style=\"padding-top:10px;\">GROUP II/GROUP III/GROUP IV/GROUP V Grade:<span style=\"color:red\"> *</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n");
      out.write("\t<td valign=\"top\"><input autocomplete=\"off\" name=\"subj4\" id=\"subj4\" type=\"text\">\n");
      out.write("        <span id=\"subj4Error\" style=\"color: #ff6699;\"> </span>\n");
      out.write("        </td>\n");
      out.write("\t<td valign=\"top\"></td>\n");
      out.write("</tr>\n");
      out.write("\n");
      out.write("<tr>\n");
      out.write("\t<td align=\"right\" valign=\"top\" style=\"padding-top:10px;\">K.C.S.E Mean Grade:<span style=\"color:red\"> *</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n");
      out.write("\t<td valign=\"top\"><input autocomplete=\"off\" name=\"meangrade\" id=\"meangrade\" type=\"text\">\n");
      out.write("        <span id=\"meangradeError\" style=\"color: #ff6699;\"> </span>\n");
      out.write("        </td>\n");
      out.write("\t<td valign=\"top\"></td>\n");
      out.write("</tr>\n");
      out.write("\n");
      out.write("<tr>\n");
      out.write("\t<td align=\"right\" valign=\"top\" style=\"padding-top:10px;\">K.C.S.E Aggregate Points:<span style=\"color:red\"> *</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n");
      out.write("\t<td valign=\"top\"><input autocomplete=\"off\" name=\"aggregatepoints\" id=\"aggregatepoints\" type=\"text\">\n");
      out.write("        <span id=\"qggregatepointsError\" style=\"color: #ff6699;\"> </span>\n");
      out.write("        </td>\n");
      out.write("\t<td valign=\"top\"></td>\n");
      out.write("</tr>\n");
      out.write("<tr>\n");
      out.write("\t<td align=\"right\" valign=\"top\"></td>\n");
      out.write("\t<td valign=\"top\"><strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n");
      out.write("                <input type=\"submit\" value=\"Submit\" name=\"submit2\"></strong> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n");
      out.write("                <strong><input name=\"reset\" value=\"Reset\" type=\"reset\"></strong> <br/></td>\n");
      out.write("\t<td valign=\"top\"></td>\n");
      out.write("\t\n");
      out.write("</tr>\n");
      out.write("\n");
      out.write("                  </tbody>\n");
      out.write("              </table>\n");
      out.write("          </fieldset>\n");
      out.write("      </form>\n");
      out.write("      \n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("    <!--Starts collapsible SECTION B-->\n");
      out.write("    \n");
      out.write("    <!--Starts collapsible SECTION C--> \n");
      out.write("  <div data-role=\"main\" class=\"ui-content\">\n");
      out.write("    <div data-role=\"collapsible\">\n");
      out.write("        \n");
      out.write("            \n");
      out.write("        \n");
      out.write("      <h1>SECTION C: Course Application Details</h1>\n");
      out.write("     \n");
      out.write("      <!--start accordion advice-->\n");
      out.write("      <div class=\"try\" style=\"width: auto; height: auto; margin-left: 300px; margin-right: 300px;\">\n");
      out.write("          <h5 style=\"text-align: center; color: green;\">You qualify for the following programmes:</h5>\n");
      out.write("     \n");
      out.write("    \n");
      out.write("      <form name=\"registration\" method=\"post\" action=\"Try.jsp\" onsubmit=\"\"><br>\n");
      out.write("          <fieldset>\n");
      out.write("              <table style=\"width: 600px; height: 50px;\">\n");
      out.write("                  <tbody>\n");
      out.write("\n");
      out.write("                      <tr>\n");
      out.write("                        <td align=\"right\" valign=\"top\" style=\"padding-top:10px;\">Select Level:<span style=\"color:red\"> *</span> &nbsp;&nbsp;&nbsp;</td>\n");
      out.write("                        <td valign=\"top\"><select name=\"levelName\">\n");
      out.write("                                <option selected=\"\">select level</option> \n");
      out.write("                                <option>Degree</option>\n");
      out.write("                                <option>Diploma</option>\n");
      out.write("                                <option>Certificate</option>\n");
      out.write("                            </select>\n");
      out.write("                        <span id=\"programmeError\" style=\"color: #ff6699;\"></span>\n");
      out.write("                        </td>\n");
      out.write("\t                <td valign=\"top\"></td>\n");
      out.write("                      </tr>\n");
      out.write("                      \n");
      out.write("                      <tr>\n");
      out.write("                        <td align=\"right\" valign=\"top\" style=\"padding-top:10px;\">Select programme:<span style=\"color:red\"> *</span> &nbsp;&nbsp;&nbsp;</td>\n");
      out.write("                        <td valign=\"top\"><select name=\"courseName\">\n");
      out.write("                                <option selected=\"\">select programme</option> \n");
      out.write("                                <option>Computer Science</option>\n");
      out.write("                                <option>Information Technology</option>\n");
      out.write("                                <option>Computer Studies</option>\n");
      out.write("                            </select>\n");
      out.write("                        <span id=\"programmeError\" style=\"color: #ff6699;\"></span>\n");
      out.write("                        </td>\n");
      out.write("\t                <td valign=\"top\"></td>\n");
      out.write("                      </tr>\n");
      out.write("               \n");
      out.write("                       <tr>\n");
      out.write("                        <td align=\"right\" valign=\"top\" style=\"padding-top:10px;\">Mode of Study:<span style=\"color:red\"> *</span> &nbsp;&nbsp;&nbsp;</td>\n");
      out.write("                        <td valign=\"top\"><select name=\"mod\">\n");
      out.write("                                <option selected=\"\">mode of study</option> \n");
      out.write("                                <option>Full Time</option>\n");
      out.write("                                <option>Part Time</option>\n");
      out.write("                                <option>Evening Classes</option>\n");
      out.write("                                <option>Weekend Classes</option>\n");
      out.write("                            </select>\n");
      out.write("                        <span id=\"modeofstudyError\" style=\"color: #ff6699;\"></span>\n");
      out.write("                        </td>\n");
      out.write("\t                <td valign=\"top\"></td>\n");
      out.write("                      </tr>\n");
      out.write("                      \n");
      out.write("                       <tr>\n");
      out.write("                        <td align=\"right\" valign=\"top\" style=\"padding-top:10px;\">Campus/Study Center:<span style=\"color:red\"> *</span> &nbsp;&nbsp;&nbsp;</td>\n");
      out.write("                        <td valign=\"top\"><select name=\"studyCampus\">\n");
      out.write("                                <option selected=\"\">study center</option> \n");
      out.write("                               \n");
      out.write("                              </select>\n");
      out.write("                           <span id=\"studycenterError\" style=\"color: #ff6699;\"></span>\n");
      out.write("                        </td>\n");
      out.write("\t                <td valign=\"top\"></td>\n");
      out.write("                      </tr>\n");
      out.write("                      \n");
      out.write("                      <tr>\n");
      out.write("\t               <td align=\"right\" valign=\"top\"></td>\n");
      out.write("\t               <td valign=\"top\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n");
      out.write("                       <input type=\"submit\" name=\"submit3\" value=\"Submit\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n");
      out.write("                      <td valign=\"top\"></td>\n");
      out.write("\t\n");
      out.write("                    </tr>\n");
      out.write("                  </tbody>\n");
      out.write("              </table>\n");
      out.write("          </fieldset>\n");
      out.write("      </form>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("<!--ends collapsible SECTION C-->\n");
      out.write("       \n");
      out.write("    <!--Starts collapsible SECTION D-->\n");
      out.write("    <div data-role=\"main\" class=\"ui-content\">\n");
      out.write("    <div data-role=\"collapsible\">\n");
      out.write("      <h1>SECTION D: Print Your Form</h1>\n");
      out.write("      <a href=\"Click.jsp\">print</a>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("    <!--ends collapsible SECTION D-->\n");
      out.write("    \n");
      out.write("   </div> \n");
      out.write("</div>\n");
      out.write(" </div>\n");
      out.write("</div>\n");
      out.write("<!--ends main content --> \n");
      out.write("    </div>\n");
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
