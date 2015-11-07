package org.apache.jsp.Applicants;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import myproject.*;

public final class ApplicationForm_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <title>Application Form|mmust</title>\n");
      out.write("            \n");
      out.write("        <!--start date picker-->\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" media=\"all\" href=\"jsDatePick_ltr.min.css\" />\n");
      out.write("        <script type=\"text/javascript\" src=\"jsDatePick.min.1.3.js\"></script>\n");
      out.write("            \n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            window.onload = function(){\n");
      out.write("                new JsDatePick({\n");
      out.write("                    useMode:2,\n");
      out.write("                    target:\"dob\",\n");
      out.write("                    dateFormat:\"%Y-%m-%d\"\n");
      out.write("                    /*selectedDate:{\t\t\t\tThis is an example of what the full configuration offers.\n");
      out.write("                                        day:5,\t\t\t\t\t\tFor full documentation about these settings please see the full version of the code.\n");
      out.write("                                        month:9,\n");
      out.write("                                        year:2006\n");
      out.write("                                },\n");
      out.write("                                yearsRange:[1978,2020],\n");
      out.write("                                limitToToday:false,\n");
      out.write("                                cellColorScheme:\"beige\",\n");
      out.write("                                dateFormat:\"%m-%d-%Y\",\n");
      out.write("                                imgPath:\"img/\",\n");
      out.write("                                weekStartDay:1*/\n");
      out.write("                });\n");
      out.write("            };\n");
      out.write("        </script>        \n");
      out.write("        <!--end date picker--> \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        <!--start navigation menus-->\n");
      out.write("        <link rel=\"stylesheet\" href=\"mycss/glyphicons/css/bootstrap.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" style type=\"text/css\" href=\"mycss/navMenus.css\">\n");
      out.write("        <!--end navigation menus-->\n");
      out.write("        <!-- accordions -->\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"mycss/accordion1/defaults.css\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"mycss/accordion1/demo.css\">\n");
      out.write("        <script type=\"text/javascript\" src=\"mycss/accordion1/jquery.min.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"mycss/accordion1/accordion.js\"></script>\n");
      out.write("        \n");
      out.write("        <!--form elements--><link rel=\"stylesheet\" href=\"layout/bootstrap/css/bootstrap.css\" type=\"text/css\">\n");
      out.write("        <!-- Core CSS - Include with every page -->\n");
      out.write("        <link href=\"assets/plugins/bootstrap/bootstrap.css\" rel=\"stylesheet\" />\n");
      out.write("        <link href=\"assets/font-awesome/css/font-awesome.css\" rel=\"stylesheet\" />\n");
      out.write("        <link href=\"assets/plugins/pace/pace-theme-big-counter.css\" rel=\"stylesheet\" />\n");
      out.write("        <link href=\"assets/css/style.css\" rel=\"stylesheet\" />\n");
      out.write("        <link href=\"assets/css/main-style.css\" rel=\"stylesheet\" />\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"bootstrap/css/bootstrap.css\">\n");
      out.write("         <link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/css/bootstrap-formhelpers.min.css\">\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        <script type=\"text/javascript\" src=\"mycss/dateValidater.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"mycss/pDetailsValidate.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"mycss/eBackgroundValidate.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"mycss/cApplicationDetailsValidate.js\"></script>\n");
      out.write("        \n");
      out.write("        <style>\n");
      out.write("            .error{\n");
      out.write("                color: red;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("        <script>\n");
      out.write("            function dateDiff(dateform) {\n");
      out.write("                date1 = new Date();\n");
      out.write("                date2 = new Date();\n");
      out.write("                diff  = new Date();\n");
      out.write("                \n");
      out.write("                date1temp = new Date(dateform.dob.value);\n");
      out.write("                date1.setTime(date1temp.getTime());\n");
      out.write("                \n");
      out.write("                diff.setTime(Math.abs(date1.getTime() - date2.getTime()));\n");
      out.write("                \n");
      out.write("                timediff = diff.getTime();\n");
      out.write("                age = Math.floor(timediff / (1000 * 60 * 60 * 24*365)); \n");
      out.write("                if(age<15){\n");
      out.write("                    alert(\"Your Age is too low!\");\n");
      out.write("                    dateform.dob.select();\n");
      out.write("                    return false;\n");
      out.write("                }\n");
      out.write("                \n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body style=\"overflow-x: hidden; background-color: #EFEEEE;\"> \n");
      out.write("        \n");
      out.write("        ");

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
       
            
      out.write("\n");
      out.write("            \n");
      out.write("                 \n");
      out.write("            ");

            Applicant user=new Applicant();
            Applicant user2=new Applicant();
            Applicant user3=new Applicant();
            
            Applicant user4=new Applicant();
            Applicant user5=new Applicant();
            Applicant user6=new Applicant();
            
            String firstName=new String();
            String middleName=new String();
            String lastName=new String();
                      
            ResultSet results=user.getApplicantDetails(applicantId); 
            int degStatusId=0;
            int dipStatusId=0;
            int certStatusId=0;
           ResultSet degStatus=user.checkSatus(3);
           ResultSet dipStatus=user2.checkSatus(4); 
           ResultSet certStatus=user3.checkSatus(5);
           if(degStatus.next()){
             degStatusId=degStatus.getInt("Status");
           }
           if(dipStatus.next()){
             dipStatusId=dipStatus.getInt("Status");
           }
           if(certStatus.next()){
             certStatusId=certStatus.getInt("Status");
           }
                      
            if(results.next()){
                firstName=results.getString("First_Name");
                middleName=results.getString("Middle_Name");
                lastName=results.getString("Last_Name");
            }
            ResultSet check1=user.checkSectionA(applicantId);
            ResultSet check2=user.checkSectionB(applicantId);
            ResultSet check3=user.checkSectionC(applicantId);
            
            ResultSet confirmRanking=user.confirmRanking();
            ResultSet crs=user.getCourseDetails(applicantId);
            ResultSet crs2=user2.getCourseDetails(applicantId);
            
            ResultSet confirmDegRanking=user.checkRankingPerLevel(3);
           ResultSet confirmDipRanking=user2.checkRankingPerLevel(4);
           ResultSet confirmCertRanking=user3.checkRankingPerLevel(5);
            
            String p=new String();
            String m=new String();
            ResultSet legibility=user.getEducationBackground(applicantId);
            if(legibility.next()){
                m=legibility.getString("Math_Grade");
                p=legibility.getString("Physics_Grade");
            }
            ResultSet chRank1=user4.checkRankingPerLevel(3);
            ResultSet chRank2=user5.checkRankingPerLevel(4);
            ResultSet chRank3=user6.checkRankingPerLevel(5);
            boolean cc=false;
            if(chRank1.next()&&chRank2.next()&&chRank3.next()){
                cc=true;
            }
            
      out.write("\n");
      out.write("        \n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Header.jsp", out, false);
      out.write("\n");
      out.write("        \n");
      out.write("                <div class=\"container\">\n");
      out.write("                    \n");
      out.write("                    <div class=\"row1\" style=\"margin-top: 0px;\">\n");
      out.write("                        \n");
      out.write("                        <div class=\"col-md-4 col-md-offset-4\" style=\"width: 1082px; margin-left: 43px;\">\n");
      out.write("                            \n");
      out.write("                            <div class=\"login-panel panel panel-default\"> \n");
      out.write("                                <!--start navigation menus-->\n");
      out.write("                                <div id=\"navMenu\" style=\"margin-top: 5px;\">\n");
      out.write("                                    <ul>\n");
      out.write("                                        <li><a href=\"UserAccount.jsp\"><button class=\"btn btn-info\" style=\"width: 148px; height: 38px; padding-top: 0px; margin-top: -5px;\"><i class=\"fa fa-home\"></i>Home</button></a>\n");
      out.write("                                        </li>\n");
      out.write("                                    </ul>\n");
      out.write("                                    <ul>\n");
      out.write("                                        ");
if(cc){
      out.write("\n");
      out.write("                                        <li><a href=\"ApplicationForm.jsp\"><button class=\"btn btn-info disabled\" style=\"width: 148px; height: 38px; padding-top: 0px; margin-top: -5px; background-color: #428BCA;\"><i class=\"fa fa-arrow-down\"></i>Apply Course</button></a>\n");
      out.write("                                        ");
} else{
      out.write("\n");
      out.write("                                        <li><a href=\"ApplicationForm.jsp\"><button class=\"btn btn-info\" style=\"width: 148px; height: 38px; padding-top: 0px; margin-top: -5px; background-color: #428BCA;\"><i class=\"fa fa-arrow-down\"></i>Apply Course</button></a></li>\n");
      out.write("                                            ");
}
      out.write("\n");
      out.write("                                            <!--<ul>\n");
      out.write("                                                <li><a href=\"ApplicationForm.jsp\">Under Graduate</a></li>\n");
      out.write("                                                <li><a href=\"#\">Post Graduate</a></li>\n");
      out.write("                                            </ul>\n");
      out.write("                                        </li>-->\n");
      out.write("                                    </ul>\n");
      out.write("                                    <ul>\n");
      out.write("                                        <li><a href=\"Announcements.jsp\"><button class=\"btn btn-info\" style=\"width: 148px; height: 38px; padding-top: 0px; margin-top: -5px;\"><i class=\"fa fa-bell\"></i>Announcements</button></a>\n");
      out.write("                                            \n");
      out.write("                                        </li>\n");
      out.write("                                    </ul>\n");
      out.write("                                    <ul>\n");
      out.write("                                        <li><a href=\"Details.jsp\"><button class=\"btn btn-info\" style=\"width: 148px; height: 38px; padding-top: 0px; margin-top: -5px;\"><i class=\"fa fa-archive\"></i>My Details</button></a>\n");
      out.write("                                        </li>\n");
      out.write("                                    </ul>\n");
      out.write("                                    <ul>\n");
      out.write("                                        <li><a href=\"Messaging.jsp\"><button class=\"btn btn-info\" style=\"width: 148px; height: 38px; padding-top: 0px; margin-top: -5px;\"><i class=\"fa fa-inbox\"></i>Inquiries</button></a>\n");
      out.write("                                        </li>\n");
      out.write("                                    </ul>\n");
      out.write("                                    <ul>\n");
      out.write("                                        <li><a href=\"#ApplicationStatus\" data-toggle=\"modal\"><button class=\"btn btn-info\" style=\"width: 148px; height: 38px; padding-top: 0px; margin-top: -5px;\"><i class=\"fa fa-star\"></i>Application Status</button></a>\n");
      out.write("                                        </li>\n");
      out.write("                                    </ul>\n");
      out.write("                                    <ul>\n");
      out.write("                                        <li><a href=\"#\"><button class=\"btn btn-info\" style=\"width: 148px; height: 38px; padding-top: 0px; margin-top: -5px;\"><i class=\"fa fa-user\"></i>");
      out.print(firstName);
      out.write("</button></a>\n");
      out.write("                                        <ul>\n");
      out.write("                                            <li><a href=\"ChangePwd.jsp\"><i class=\"fa fa-dropbox\"></i>Change Password</a></li>\n");
      out.write("                                            <li><a href=\"UserLogout.jsp\"><i class=\"fa fa-sign-out\"></i>Logout</a></li>\n");
      out.write("                                        </ul>\n");
      out.write("                                    </li>\n");
      out.write("                                </ul>\n");
      out.write("                                    \n");
      out.write("                            </div>\n");
      out.write("                            <!--end navigation menus-->\n");
      out.write("                            <div class=\"panel-heading\" style=\"margin-top: 56px;border-top: 1px solid;\">\n");
      out.write("                                <h3 class=\"panel-title\">Provide The required Information in the Sections Below.</h3>\n");
      out.write("                            </div>\n");
      out.write("                                \n");
      out.write("                            <div class=\"panel-body\">\n");
      out.write("                                \n");
      out.write("                                <!--start accordion A-->\n");
      out.write("                                <div class=\"main\">\n");
      out.write("                                    <div class=\"accordion\">\n");
      out.write("                                        <div class=\"accordion-section\">\n");
      out.write("                                            ");

                                            if(request.getParameter("submit1")!=null){
                                                
                                                ResultSet checkRe=user.confirmDetails(applicantId);
                                                if(!checkRe.next()){
                                                String fName=request.getParameter("fname");
                                                String mName=request.getParameter("mname");
                                                String lName=request.getParameter("lname");
                                                String dob=request.getParameter("dob");
                                                String gender=request.getParameter("gender");
                                                String pAddress=request.getParameter("address");
                                                String mobile=request.getParameter("mobile");
                                                String country=request.getParameter("country");
                                                      
                                                int results2=user.setApplicants(applicantId, fName, mName, lName, dob, gender, pAddress, mobile, country);    
                                       
                                                if(results2>0){
      out.write(" \n");
      out.write("                                                <a class=\"accordion-section-title alert alert-success\" style=\"margin-bottom:0px;\" href=\"#accordion-1\"><i class=\"fa fa-check-circle\"></i>Your Personal Details has been saved successfully..Proceed to the next section.</a>\n");
      out.write("                                                ");
}
                                                else{
      out.write("\n");
      out.write("                                                <a class=\"accordion-section-title alert alert-error\" style=\"margin-bottom:0px;\" href=\"#accordion-1\"><i class=\"fa fa-exclamation-circle\"></i>There was an error saving your details..Please try again.</a>\n");
      out.write("                                                ");
}} else{
      out.write("\n");
      out.write("                                                <a class=\"accordion-section-title alert alert-warning\" style=\"margin-bottom:0px;\" href=\"#accordion-1\"><i class=\"fa fa-warning\"></i>You have already submitted your details!</a>   \n");
      out.write("                                                ");
 }} else{
      out.write("\n");
      out.write("                                                <a class=\"accordion-section-title\" href=\"#accordion-1\">SECTION A: Applicant's Personal Details.</a>\n");
      out.write("                                                ");
}
      out.write("\n");
      out.write("                                                <div id=\"accordion-1\" class=\"accordion-section-content\"> \n");
      out.write("                                                    \n");
      out.write("                                                    <form method=\"post\" action=\"\" id=\"myForm1\" onSubmit=\"return dateDiff(this);\">\n");
      out.write("                                                        <fieldset>\n");
      out.write("                                                            \n");
      out.write("                                                            <div class=\"row\" id=\"firstNameRow\">   \n");
      out.write("                                                                <div class=\"form-group col-sm-3\">\n");
      out.write("                                                                    <label for=\"fname\">First Name:<span style=\"color:red\"> *</span></label>\n");
      out.write("                                                                    <input type=\"text\" class=\"form-control input\" id=\"fname\" name=\"fname\" value=\"");
      out.print(firstName);
      out.write("\" placeholder=\"First Name\" readonly=\"readonly\"/>\n");
      out.write("                                                                </div>\n");
      out.write("                                                                    \n");
      out.write("                                                                <div class=\"form-group col-sm-3\">\n");
      out.write("                                                                    <label for=\"mname\">Middle Name:</label>\n");
      out.write("                                                                    <input type=\"text\" class=\"form-control input\" id=\"mname\" name=\"mname\" value=\"");
      out.print(middleName);
      out.write("\" placeholder=\"Middle Name\" readonly=\"readonly\"/>\n");
      out.write("                                                                </div>\n");
      out.write("                                                                    \n");
      out.write("                                                                <div class=\"form-group col-sm-3\">\n");
      out.write("                                                                    <label for=\"fname\">Last Name:<span style=\"color:red\"> *</span></label>\n");
      out.write("                                                                    <input type=\"text\" class=\"form-control input\" id=\"lname\" name=\"lname\" value=\"");
      out.print(lastName);
      out.write("\" placeholder=\"Last Name\" readonly=\"readonly\"/>\n");
      out.write("                                                                </div>\n");
      out.write("                                                                    \n");
      out.write("                                                                <div class=\"form-group col-sm-3\">\n");
      out.write("                                                                    <label for=\"dob\">Date of Birth:<span style=\"color:red\"> *</span></label>\n");
      out.write("                                                                    <input type=\"text\" class=\"form-control input\" id=\"dob\" name=\"dob\" placeholder=\"yyyy-mm-dd\"/>\n");
      out.write("                                                                </div>\n");
      out.write("                                                                    \n");
      out.write("                                                            </div>\n");
      out.write("                                                                \n");
      out.write("                                                            <div class=\"row\" id=\"dobRow\"> \n");
      out.write("                                                                <div class=\"form-group col-sm-3\">\n");
      out.write("                                                                    <label for=\"gender\">Gender:<span style=\"color:red\"> *</span></label>\n");
      out.write("                                                                    <select id=\"gender\" name=\"gender\" class=\"form-control input\">\n");
      out.write("                                                                        <option value=\"\" selected>I am...</option> \n");
      out.write("                                                                        <option value=\"Male\">Male</option>\n");
      out.write("                                                                        <option value=\"Female\">Female</option>\n");
      out.write("                                                                    </select>\n");
      out.write("                                                                </div>\n");
      out.write("                                                                    \n");
      out.write("                                                                <div class=\"form-group col-sm-3\">\n");
      out.write("                                                                    <label for=\"address\">Postal Address:<span style=\"color:red\"> *</span></label>\n");
      out.write("                                                                    <input type=\"text\" class=\"form-control input\" id=\"address\" name=\"address\" placeholder=\"e.g. P.O Box 48, Chebunyo\"/>\n");
      out.write("                                                                </div>\n");
      out.write("                                                                    \n");
      out.write("                                                                <div class=\"form-group col-sm-3\">\n");
      out.write("                                                                    <label for=\"mobile\">Mobile:<span style=\"color:red\"> *</span></label>\n");
      out.write("                                                                    <input type=\"text\" class=\"form-control input\" id=\"mobile\" name=\"mobile\" placeholder=\"+...\"/>\n");
      out.write("                                                                </div>\n");
      out.write("                                                                    \n");
      out.write("                                                                <div class=\"form-group col-sm-3\">\n");
      out.write("                                                                    <div class=\"row\">\n");
      out.write("                                                                        <div class=\"col-sm-12\">\n");
      out.write("                                                                            <label for=\"country\">Nationality:<span style=\"color:red\"> *</span></label>\n");
      out.write("                                                                        </div>\n");
      out.write("                                                                    </div>\n");
      out.write("                                                                    <div class=\"row\">\n");
      out.write("                                                                        <div class=\"col-sm-4\">\n");
      out.write("                                                                            <button type=\"button\" onclick=\"$('#countries').bfhcountries({country: 'US'})\" class=\"btn btn-default btn-small\">Countries</button>\n");
      out.write("                                                                        </div>\n");
      out.write("                                                                        <div class=\"col-sm-3\">\n");
      out.write("                                                                            <select id=\"countries\" name=\"country\" class=\"input-medium\">\n");
      out.write("                                                                                <option value=\"\" selected=\"\">Click Countries</option>\n");
      out.write("                                                                            </select>\n");
      out.write("                                                                        </div>\n");
      out.write("                                                                    </div>\n");
      out.write("                                                                   <!-- <input type=\"text\" class=\"form-control input\" id=\"country\" name=\"country\" placeholder=\"country of residence\"/>-->\n");
      out.write("                                                                </div>     \n");
      out.write("                                                            </div>\n");
      out.write("                                                                \n");
      out.write("                                                            <div class=\"row\" id=\"buttons1\">\n");
      out.write("                                                                <div class=\"col-sm-4\"></div>\n");
      out.write("                                                                <div class=\"form-group col-sm-2\">\n");
      out.write("                                                                    <button type=\"submit\" name=\"submit1\" class=\"btn btn-success\" style=\"width: 120px;\">Submit</button>\n");
      out.write("                                                                </div>\n");
      out.write("                                                                <div class=\"form-group col-sm-2\">\n");
      out.write("                                                                    <button type=\"reset\" name=\"reset\" class=\"btn btn-info pull-right\" style=\"width: 120px;\">Reset</button>\n");
      out.write("                                                                </div>\n");
      out.write("                                                                <div class=\"col-sm-4\"></div>\n");
      out.write("                                                            </div>\n");
      out.write("                                                                \n");
      out.write("                                                                \n");
      out.write("                                                        </fieldset>\n");
      out.write("                                                    </form>\n");
      out.write("                                                </div><!--end .accordion-section-content-->\n");
      out.write("                                        </div><!--end .accordion-section-->\n");
      out.write("                                    </div><!--end .accordion-->\n");
      out.write("                                </div>\n");
      out.write("                                <!--end accordion A-->\n");
      out.write("                                    \n");
      out.write("                                <!--start accordion B-->\n");
      out.write("                                <div class=\"main\">\n");
      out.write("                                    <div class=\"accordion\">\n");
      out.write("                                        <div class=\"accordion-section\">\n");
      out.write("                                            ");

                                            if(request.getParameter("submit2")!=null){
                                                if(check1.next()){
                                                    ResultSet checkRe=user.checkSectionB(applicantId);
                                                if(!checkRe.next()){
                                                String engGrade=request.getParameter("eng");
                                                String kiswGrade=request.getParameter("kisw");
                                                String mathsGrade=request.getParameter("maths");
                                                String physicsGrade=request.getParameter("physics");
                                                String grp2Grade=request.getParameter("grp2");
                                                String grp3Grade=request.getParameter("grp3");
                                                String grp4or5Grade=request.getParameter("grp4or5");
                                                                                                                                                                                 
                                                double engConverted=user.convertGradestoPoints(engGrade);
                                                double kiswConverted=user.convertGradestoPoints(kiswGrade);
                                                double mathsConverted=user.convertGradestoPoints(mathsGrade);
                                                double physicsConverted=user.convertGradestoPoints(physicsGrade);
                                                double grp2Converted=user.convertGradestoPoints(grp2Grade);
                                                double grp3Converted=user.convertGradestoPoints(grp3Grade);
                                                double grp4or5Converted=user.convertGradestoPoints(grp4or5Grade);
                                                double subj3=0.0;
                                                double subj4=0.0;
                                                
                                                double aggregatePts=user.calculateAggregatePoints(engConverted, kiswConverted, mathsConverted, physicsConverted, grp2Converted, grp3Converted, grp4or5Converted);
                                                
                                                if(grp2Converted>=grp3Converted){
                                                  subj3= grp2Converted;
                                                }else{
                                                    subj3= grp3Converted;
                                                }
                                                
                                                if(subj3>=grp4or5Converted){
                                                    subj4=subj3;
                                                }else{
                                                    subj4=grp4or5Converted;
                                                }
                                                
                                                double clusterPoints=user.calculateClusterPoints(physicsConverted, mathsConverted, subj3, subj4, aggregatePts);  
                                           
                                                int results3=user.setEducationBackground(engGrade, kiswGrade, mathsGrade, physicsGrade, grp2Grade, grp3Grade, grp4or5Grade, aggregatePts, clusterPoints, applicantId); 
                                                if(results3>0){
                                                
      out.write("\n");
      out.write("                                                <a class=\"accordion-section-title alert alert-success\" style=\"margin-bottom:0px;\" href=\"#accordion-2\"><i class=\"fa fa-check-circle\"></i>Your details has been saved successfully..Proceed to the next section.</a>\n");
      out.write("                                                ");
} else{
      out.write("\n");
      out.write("                                                <a class=\"accordion-section-title alert alert-error\" style=\"margin-bottom:0px;\" href=\"#accordion-2\"><i class=\"fa fa-exclamation-circle\"></i>There was an error saving your details..Please try again.</a>\n");
      out.write("                                                ");
} } else{
      out.write("\n");
      out.write("                                                <a class=\"accordion-section-title alert alert-warning\" style=\"margin-bottom:0px;\" href=\"#accordion-1\"><i class=\"fa fa-warning\"></i>You have already submitted your details!</a>\n");
      out.write("                                                ");
}} else{
      out.write("\n");
      out.write("                                                    <a class=\"accordion-section-title alert alert-warning\" style=\"margin-bottom:0px;\" href=\"#accordion-2\"><i class=\"fa fa-warning\"></i>Please fill SECTION A!</a>\n");
      out.write("                                                ");
 }
                                            } 
                                            else{
                                                
      out.write("\n");
      out.write("                                                <a class=\"accordion-section-title\" href=\"#accordion-2\">SECTION B: Applicant's Education Background.</a>\n");
      out.write("                                                ");
}
      out.write("\n");
      out.write("                                                <div id=\"accordion-2\" class=\"accordion-section-content\">\n");
      out.write("                                                    \n");
      out.write("                                                    <form role=\"form\" method=\"post\" action=\"\" id=\"myForm2\" onsubmit=\"return validateEducationBackgroundForm1(this)\">\n");
      out.write("                                                        <fieldset>\n");
      out.write("                                                            \n");
      out.write("                                                            <div class=\"row\" id=\"row1\">\n");
      out.write("                                                                <div class=\"form-group col-sm-3\">\n");
      out.write("                                                                    <label for=\"eng\">K.C.S.E English Grade:<span style=\"color:red\"> *</span></label>\n");
      out.write("                                                                    <select id=\"eng\" name=\"eng\" class=\"form-control input\">\n");
      out.write("                                                                        <option value=\"\" selected>~select grade~</option> \n");
      out.write("                                                                        <option value=\"A\">A</option>\n");
      out.write("                                                                        <option value=\"A-\">A-</option>\n");
      out.write("                                                                        <option value=\"B+\">B+</option>\n");
      out.write("                                                                        <option value=\"B\">B</option>\n");
      out.write("                                                                        <option value=\"B-\">B-</option>\n");
      out.write("                                                                        <option value=\"C+\">C+</option>\n");
      out.write("                                                                        <option value=\"C\">C</option>\n");
      out.write("                                                                        <option value=\"C-\">C-</option>\n");
      out.write("                                                                        <option value=\"D+\">D+</option>\n");
      out.write("                                                                        <option value=\"D\">D</option>\n");
      out.write("                                                                        <option value=\"D-\">D-</option>\n");
      out.write("                                                                        <option value=\"E\">E</option>\n");
      out.write("                                                                    </select>\n");
      out.write("                                                                </div>\n");
      out.write("                                                                    \n");
      out.write("                                                                <div class=\"form-group col-sm-3\">\n");
      out.write("                                                                    <label for=\"kisw\">K.C.S.E Kiswahili Grade:<span style=\"color:red\"> *</span></label>\n");
      out.write("                                                                    <select id=\"kisw\" name=\"kisw\" class=\"form-control input\">\n");
      out.write("                                                                        <option value=\"\" selected>~select grade~</option> \n");
      out.write("                                                                        <option value=\"A\">A</option>\n");
      out.write("                                                                        <option value=\"A-\">A-</option>\n");
      out.write("                                                                        <option value=\"B+\">B+</option>\n");
      out.write("                                                                        <option value=\"B\">B</option>\n");
      out.write("                                                                        <option value=\"B-\">B-</option>\n");
      out.write("                                                                        <option value=\"C+\">C+</option>\n");
      out.write("                                                                        <option value=\"C\">C</option>\n");
      out.write("                                                                        <option value=\"C-\">C-</option>\n");
      out.write("                                                                        <option value=\"D+\">D+</option>\n");
      out.write("                                                                        <option value=\"D\">D</option>\n");
      out.write("                                                                        <option value=\"D-\">D-</option>\n");
      out.write("                                                                        <option value=\"E\">E</option>\n");
      out.write("                                                                    </select>\n");
      out.write("                                                                </div>\n");
      out.write("                                                                    \n");
      out.write("                                                                <div class=\"form-group col-sm-3\">\n");
      out.write("                                                                    <label for=\"maths\">K.C.S.E Maths Grade:<span style=\"color:red\"> *</span></label>\n");
      out.write("                                                                    <select id=\"maths\" name=\"maths\" class=\"form-control input\">\n");
      out.write("                                                                        <option value=\"\" selected>~select grade~</option> \n");
      out.write("                                                                        <option value=\"A\">A</option>\n");
      out.write("                                                                        <option value=\"A-\">A-</option>\n");
      out.write("                                                                        <option value=\"B+\">B+</option>\n");
      out.write("                                                                        <option value=\"B\">B</option>\n");
      out.write("                                                                        <option value=\"B-\">B-</option>\n");
      out.write("                                                                        <option value=\"C+\">C+</option>\n");
      out.write("                                                                        <option value=\"C\">C</option>\n");
      out.write("                                                                        <option value=\"C-\">C-</option>\n");
      out.write("                                                                        <option value=\"D+\">D+</option>\n");
      out.write("                                                                        <option value=\"D\">D</option>\n");
      out.write("                                                                        <option value=\"D-\">D-</option>\n");
      out.write("                                                                        <option value=\"E\">E</option>\n");
      out.write("                                                                    </select>\n");
      out.write("                                                                </div>\n");
      out.write("                                                                \n");
      out.write("                                                                <div class=\"form-group col-sm-3\">\n");
      out.write("                                                                    <label for=\"physics\">K.C.S.E Physics Grade:<span style=\"color:red\"> *</span></label>\n");
      out.write("                                                                    <select id=\"physics\" name=\"physics\" class=\"form-control input\">\n");
      out.write("                                                                        <option value=\"\" selected>~select grade~</option> \n");
      out.write("                                                                        <option value=\"A\">A</option>\n");
      out.write("                                                                        <option value=\"A-\">A-</option>\n");
      out.write("                                                                        <option value=\"B+\">B+</option>\n");
      out.write("                                                                        <option value=\"B\">B</option>\n");
      out.write("                                                                        <option value=\"B-\">B-</option>\n");
      out.write("                                                                        <option value=\"C+\">C+</option>\n");
      out.write("                                                                        <option value=\"C\">C</option>\n");
      out.write("                                                                        <option value=\"C-\">C-</option>\n");
      out.write("                                                                        <option value=\"D+\">D+</option>\n");
      out.write("                                                                        <option value=\"D\">D</option>\n");
      out.write("                                                                        <option value=\"D-\">D-</option>\n");
      out.write("                                                                        <option value=\"E\">E</option>\n");
      out.write("                                                                    </select>\n");
      out.write("                                                                </div>\n");
      out.write("                                                            </div>\n");
      out.write("                                                            \n");
      out.write("                                                            <div class=\"row\" id=\"row2\">\n");
      out.write("                                                                <div class=\"form-group col-sm-3\">\n");
      out.write("                                                                    <label for=\"grp2\">Any Other Group II Grade:<span style=\"color:red\"> *</span></label>\n");
      out.write("                                                                    <select id=\"grp2\" name=\"grp2\" class=\"form-control input\">\n");
      out.write("                                                                        <option value=\"\" selected>~select grade~</option> \n");
      out.write("                                                                        <option value=\"A\">A</option>\n");
      out.write("                                                                        <option value=\"A-\">A-</option>\n");
      out.write("                                                                        <option value=\"B+\">B+</option>\n");
      out.write("                                                                        <option value=\"B\">B</option>\n");
      out.write("                                                                        <option value=\"B-\">B-</option>\n");
      out.write("                                                                        <option value=\"C+\">C+</option>\n");
      out.write("                                                                        <option value=\"C\">C</option>\n");
      out.write("                                                                        <option value=\"C-\">C-</option>\n");
      out.write("                                                                        <option value=\"D+\">D+</option>\n");
      out.write("                                                                        <option value=\"D\">D</option>\n");
      out.write("                                                                        <option value=\"D-\">D-</option>\n");
      out.write("                                                                        <option value=\"E\">E</option>\n");
      out.write("                                                                    </select>\n");
      out.write("                                                                </div>\n");
      out.write("                                                                \n");
      out.write("                                                                <div class=\"form-group col-sm-3\">\n");
      out.write("                                                                    <label for=\"grp3\">Group III Grade:<span style=\"color:red\"> *</span></label>\n");
      out.write("                                                                    <select id=\"grp3\" name=\"grp3\" class=\"form-control input\">\n");
      out.write("                                                                        <option value=\"\" selected>~select grade~</option> \n");
      out.write("                                                                        <option value=\"A\">A</option>\n");
      out.write("                                                                        <option value=\"A-\">A-</option>\n");
      out.write("                                                                        <option value=\"B+\">B+</option>\n");
      out.write("                                                                        <option value=\"B\">B</option>\n");
      out.write("                                                                        <option value=\"B-\">B-</option>\n");
      out.write("                                                                        <option value=\"C+\">C+</option>\n");
      out.write("                                                                        <option value=\"C\">C</option>\n");
      out.write("                                                                        <option value=\"C-\">C-</option>\n");
      out.write("                                                                        <option value=\"D+\">D+</option>\n");
      out.write("                                                                        <option value=\"D\">D</option>\n");
      out.write("                                                                        <option value=\"D-\">D-</option>\n");
      out.write("                                                                        <option value=\"E\">E</option>\n");
      out.write("                                                                    </select>\n");
      out.write("                                                                </div>\n");
      out.write("                                                                    \n");
      out.write("                                                                <div class=\"form-group col-sm-3\">\n");
      out.write("                                                                    <label for=\"grp4or5\">Group IV or Group V Grade:<span style=\"color:red\"> *</span></label>\n");
      out.write("                                                                    <select id=\"grp4or5\" name=\"grp4or5\" class=\"form-control input\">\n");
      out.write("                                                                        <option value=\"\" selected>~select grade~</option> \n");
      out.write("                                                                        <option value=\"A\">A</option>\n");
      out.write("                                                                        <option value=\"A-\">A-</option>\n");
      out.write("                                                                        <option value=\"B+\">B+</option>\n");
      out.write("                                                                        <option value=\"B\">B</option>\n");
      out.write("                                                                        <option value=\"B-\">B-</option>\n");
      out.write("                                                                        <option value=\"C+\">C+</option>\n");
      out.write("                                                                        <option value=\"C\">C</option>\n");
      out.write("                                                                        <option value=\"C-\">C-</option>\n");
      out.write("                                                                        <option value=\"D+\">D+</option>\n");
      out.write("                                                                        <option value=\"D\">D</option>\n");
      out.write("                                                                        <option value=\"D-\">D-</option>\n");
      out.write("                                                                        <option value=\"E\">E</option>\n");
      out.write("                                                                    </select>\n");
      out.write("                                                                </div>\n");
      out.write("                                                               \n");
      out.write("                                                            </div>\n");
      out.write("                                                                                                                            \n");
      out.write("                                                            <div class=\"row\" id=\"buttons2\">\n");
      out.write("                                                                <div class=\"col-sm-4\"></div>\n");
      out.write("                                                                <div class=\"form-group col-sm-2\">\n");
      out.write("                                                                    <button type=\"submit\" name=\"submit2\" class=\"btn btn-success\" style=\"width: 120px;\">Submit</button>\n");
      out.write("                                                                </div>\n");
      out.write("                                                                <div class=\"form-group col-sm-2\">\n");
      out.write("                                                                    <button type=\"reset\" name=\"reset\" class=\"btn btn-info pull-right\" style=\"width: 120px;\">Reset</button>\n");
      out.write("                                                                </div>\n");
      out.write("                                                                <div class=\"col-sm-4\"></div>\n");
      out.write("                                                            </div>\n");
      out.write("                                                                \n");
      out.write("                                                        </fieldset>\n");
      out.write("                                                    </form>\n");
      out.write("                                                        \n");
      out.write("                                                </div><!--end .accordion-section-content-->\n");
      out.write("                                        </div><!--end .accordion-section-->\n");
      out.write("                                    </div><!--end .accordion-->\n");
      out.write("                                </div>\n");
      out.write("                                <!--end accordion B-->\n");
      out.write("                                    \n");
      out.write("                                <!--start accordion C-->\n");
      out.write("                                <div class=\"main\">\n");
      out.write("                                    <div class=\"accordion\">\n");
      out.write("                                        <div class=\"accordion-section\">\n");
      out.write("                                            ");

                                            int courseIdInt=0;
                                            int levelIdInt=0; 
                                            String physics=new String();
                                            ResultSet results5=user.getCampuses();
                                            //ResultSet results6=user.getCourses();
                                            if(request.getParameter("submit3")!=null){
                                                if(check2.next()){
                                                String courseIdString=request.getParameter("programmeName");
                                                courseIdInt=Integer.parseInt(courseIdString);
                                                String levelIdString=request.getParameter("programmeLevel");
                                                levelIdInt=Integer.parseInt(levelIdString);
                                           
                                               /* ResultSet results7=user.getCourseId(courseName);
                                                if(results7.next()){
                                                    courseId=results7.getInt("Course_id");
                                                }
                                           
                                                ResultSet results8=user.getLevelId(levelName); 
                                                if(results8.next()){
                                                    levelId=results8.getInt("Level_id");
                                                }*/
                                                String mos=request.getParameter("modeOfStudy");
                                                String campus=request.getParameter("campus");
                                                int campusId=Integer.parseInt(campus);
                                           
                                                int results4=user.setCourseDetails(applicantId, levelIdInt, courseIdInt, mos, campusId);
                                       
                                                if(results4>0){
      out.write(" \n");
      out.write("                                                <a class=\"accordion-section-title alert alert-success\" style=\"margin-bottom:0px;\" href=\"#accordion-3\"><i class=\"fa fa-check-circle\"></i>Your details has been saved successfully..Proceed to the next section.</a>\n");
      out.write("                                                ");
} else{
      out.write("\n");
      out.write("                                                <a class=\"accordion-section-title alert alert-error\" style=\"margin-bottom:0px;\" href=\"#accordion-3\"><i class=\"fa fa-exclamation-triangle\"></i>There was an error saving your details..Please try again.</a>\n");
      out.write("                                                ");
} }else{
      out.write("\n");
      out.write("                                                <a class=\"accordion-section-title alert alert-warning\" style=\"margin-bottom:0px;\" href=\"#accordion-2\"><i class=\"fa fa-warning\"></i>Please fill SECTION B!</a>\n");
      out.write("                                                ");
 }
                                            } 
                                            else{
      out.write("\n");
      out.write("                                            <a class=\"accordion-section-title\" href=\"#accordion-3\">SECTION C: Course Application Details.</a>\n");
      out.write("                                            ");
}
      out.write("\n");
      out.write("                                            <div id=\"accordion-3\" class=\"accordion-section-content\">\n");
      out.write("                                                \n");
      out.write("                                                <form role=\"form\" method=\"post\" action=\"\" id=\"myForm3\" onsubmit=\"return validateCourseApplicationDetailsForm1(this)\">\n");
      out.write("                                                    <fieldset>\n");
      out.write("                                                        \n");
      out.write("                                                        <div class=\"row\" id=\"programmeLevelRow\">\n");
      out.write("                                                            <div class=\"col-sm-2\"></div>\n");
      out.write("                                                            <div class=\"form-group col-sm-4\">\n");
      out.write("                                                                <label for=\"level\">Programme Level:<span style=\"color:red\"> *</span></label>\n");
      out.write("                                                                <select id=\"programmeLevel\" name=\"programmeLevel\" class=\"form-control input\">\n");
      out.write("                                                                    <option value=\"\" selected>~select programme level~</option> \n");
      out.write("                                                                    ");
if(m.equals("C") && (p.equals("C")||p.equals("C+")||p.equals("B-")||p.equals("B")||p.equals("B+")||p.equals("A-")||p.equals("A"))){
      out.write("\n");
      out.write("                                                                    <option value=\"4\">Diploma</option>\n");
      out.write("                                                                    <option value=\"5\">Certificate</option>\n");
      out.write("                                                                    ");
}
                                                                    else if(p.equals("C") && (m.equals("C")||m.equals("C+")||m.equals("B-")||m.equals("B")||m.equals("B+")||m.equals("A-")||m.equals("A"))){
      out.write("\n");
      out.write("                                                                    <option value=\"4\">Diploma</option>\n");
      out.write("                                                                    <option value=\"5\">Certificate</option>\n");
      out.write("                                                                    ");
} 
                                                                    else if(m.equals("C-") && (p.equals("C-")||p.equals("C")||p.equals("C+")||p.equals("B-")||p.equals("B")||p.equals("B+")||p.equals("A-")||p.equals("A"))){
      out.write("\n");
      out.write("                                                                    <option value=\"5\">Certificate</option>\n");
      out.write("                                                                    ");
}
                                                                    else if(p.equals("C-") && (m.equals("C-")||m.equals("C")||m.equals("C+")||m.equals("B-")||m.equals("B")||m.equals("B+")||m.equals("A-")||m.equals("A"))){
      out.write("\n");
      out.write("                                                                    <option value=\"5\">Certificate</option>\n");
      out.write("                                                                    ");
} 
                                                                    else if(m.equals("D+")||m.equals("D")||m.equals("D-")||m.equals("E")){
      out.write("\n");
      out.write("                                                                     <option value=\"\">Can't Qualify (Maths Grade Too Low!)</option>\n");
      out.write("                                                                    ");
} 
                                                                    else if(p.equals("D+")||p.equals("D")||p.equals("D-")||p.equals("E")){
      out.write("\n");
      out.write("                                                                    <option value=\"\">Can't Qualify (Physics Grade Too Low!)</option>\n");
      out.write("                                                                    ");
} else{
      out.write("\n");
      out.write("                                                                    ");
if(degStatusId==0){
      out.write("\n");
      out.write("                                                                    <option value=\"4\">Diploma</option>\n");
      out.write("                                                                    <option value=\"5\">Certificate</option>\n");
      out.write("                                                                    ");
} else{
      out.write("\n");
      out.write("                                                                    <option value=\"3\">Degree</option>\n");
      out.write("                                                                    <option value=\"4\">Diploma</option>\n");
      out.write("                                                                    <option value=\"5\">Certificate</option>\n");
      out.write("                                                                    ");
}
      out.write("\n");
      out.write("                                                                    ");
}
      out.write("\n");
      out.write("                                                                </select>\n");
      out.write("                                                            </div>\n");
      out.write("                                                                \n");
      out.write("                                                                \n");
      out.write("                                                            <div class=\"form-group col-sm-4\">\n");
      out.write("                                                                <label for=\"programmeName\">Programme Name:<span style=\"color:red\"> *</span></label>\n");
      out.write("                                                                <select id=\"programmeName\" name=\"programmeName\" class=\"form-control input\">\n");
      out.write("                                                                    <option value=\"\" selected>~select programme name~</option> \n");
      out.write("                                                                    \n");
      out.write("                                                                </select>\n");
      out.write("                                                            </div>\n");
      out.write("                                                            <div class=\"col-sm-2\"></div>\n");
      out.write("                                                        </div>\n");
      out.write("                                                            \n");
      out.write("                                                                <div class=\"row\" id=\"modeOfStudyRow\">\n");
      out.write("                                                                    <div class=\"col-sm-2\"></div>\n");
      out.write("                                                                    <div class=\"form-group col-sm-4\">\n");
      out.write("                                                                        <label for=\"modeOfStudy\">Mode of Study:<span style=\"color:red\"> *</span></label>\n");
      out.write("                                                                        <select id=\"modeOfStudy\" name=\"modeOfStudy\" class=\"form-control input\">\n");
      out.write("                                                                            <option value=\"\" selected>~select mode of study~</option> \n");
      out.write("                                                                            <option value=\"Full Time\">Full Time</option>\n");
      out.write("                                                                            <option value=\"Part Time\">Part Time</option>\n");
      out.write("                                                                            <option value=\"Evening Classes\">Evening Classes</option>\n");
      out.write("                                                                            <option value=\"Weekend Classes\">Weekend Classes</option>\n");
      out.write("                                                                        </select>\n");
      out.write("                                                                    </div>\n");
      out.write("                                                        \n");
      out.write("                                                                    <div class=\"form-group col-sm-4\">\n");
      out.write("                                                                        <label for=\"campus\">Campus/Study Center:<span style=\"color:red\"> *</span></label>\n");
      out.write("                                                                        <select id=\"campus\" name=\"campus\" class=\"form-control input\">\n");
      out.write("                                                                            <option value=\"\" selected>~select campus~</option> \n");
      out.write("                                                                            ");
while(results5.next()){
      out.write("\n");
      out.write("                                                                            <option value=\"");
      out.print(results5.getString("campus_id"));
      out.write('"');
      out.write('>');
      out.print(results5.getString("campus_Name"));
      out.write("</option>\n");
      out.write("                                                                            ");
}
      out.write("\n");
      out.write("                                                                        </select>\n");
      out.write("                                                                    </div>\n");
      out.write("                                                                    <div class=\"col-sm-2\"></div>\n");
      out.write("                                                                </div>\n");
      out.write("                                                                    \n");
      out.write("                                                                <div class=\"row\" id=\"buttons3\">\n");
      out.write("                                                                    <div class=\"col-sm-4\"></div>\n");
      out.write("                                                                    <div class=\"form-group col-sm-2\">\n");
      out.write("                                                                        <button type=\"submit\" name=\"submit3\" class=\"btn btn-success\" style=\"width: 120px;\">Submit</button>\n");
      out.write("                                                                    </div>\n");
      out.write("                                                                    <div class=\"form-group col-sm-2\">\n");
      out.write("                                                                        <button type=\"reset\" name=\"reset\" class=\"btn btn-info pull-right\" style=\"width: 120px;\">Reset</button>\n");
      out.write("                                                                    </div>\n");
      out.write("                                                                    <div class=\"col-sm-4\"></div>\n");
      out.write("                                                                </div>\n");
      out.write("                                                                    \n");
      out.write("                                                    </fieldset>\n");
      out.write("                                                </form>\n");
      out.write("                                                    \n");
      out.write("                                            </div><!--end .accordion-section-content-->\n");
      out.write("                                        </div><!--end .accordion-section-->\n");
      out.write("                                    </div><!--end .accordion-->\n");
      out.write("                                </div>\n");
      out.write("                                <!--end accordion C-->\n");
      out.write("                                    \n");
      out.write("                                <!--start accordion D-->\n");
      out.write("                                <div class=\"main\">\n");
      out.write("                                    <div class=\"accordion\">\n");
      out.write("                                        <div class=\"accordion-section\">\n");
      out.write("                                            ");
if(request.getParameter("print")!=null){
      out.write("\n");
      out.write("                                            <a class=\"accordion-section-title alert alert-warning\" style=\"margin-bottom:0px;\" href=\"#accordion-4\"><i class=\"fa fa-warning\"></i>Please fill All Sections before printing!</a>\n");
      out.write("                                            ");
} else{
      out.write("\n");
      out.write("                                            <a class=\"accordion-section-title\" href=\"#accordion-4\">SECTION D: Print Your Form.</a>\n");
      out.write("                                            ");
}
      out.write("\n");
      out.write("                                            <div id=\"accordion-4\" class=\"accordion-section-content\">\n");
      out.write("                                                 ");
 if(check1.next() && check2.next() && check3.next()){
      out.write("\n");
      out.write("                                                <form action=\"PdfGenerator.jsp\">\n");
      out.write("                                                    <button class=\"btn btn-success\"><i class=\"fa fa-print\">Print</i></button>\n");
      out.write("                                                </form>  \n");
      out.write("                                                ");
} else{
      out.write(" \n");
      out.write("                                                <form action=\"\">\n");
      out.write("                                                    <button type=\"submit\" class=\"btn btn-success\" name=\"print\"><i class=\"fa fa-print\">Print</i></button>\n");
      out.write("                                                </form>\n");
      out.write("                                                ");
}
      out.write("\n");
      out.write("                                            </div><!--end .accordion-section-content-->\n");
      out.write("                                        </div><!--end .accordion-section-->\n");
      out.write("                                    </div><!--end .accordion-->\n");
      out.write("                                </div>\n");
      out.write("                                <!--end accordion D-->                \n");
      out.write("                            </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("               <div class=\"modal fade\" id=\"ApplicationStatus\" role=\"dialog\">\n");
      out.write("            <div class=\"modal-dialog\">\n");
      out.write("                <div class=\"modal-content\">\n");
      out.write("                    <div class=\"modal-header\">\n");
      out.write("                        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>\n");
      out.write("                        <h4 class=\"modal-title\">Application Status</h4>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"modal-body\">\n");
      out.write("                        ");
if(!crs2.next()){
      out.write("\n");
      out.write("                        <h4 class=\"alert alert-danger\">Status not found!<br/>Please Apply a course of your choice now.</h4> \n");
      out.write("                        ");
} else{
      out.write("\n");
      out.write("                        ");
if(!confirmDegRanking.next() && !confirmDipRanking.next() && !confirmCertRanking.next()){
      out.write("\n");
      out.write("                        <h4 class=\"alert alert-danger\">Status not found!<br/>Results not yet out, Keep checking.</h4>\n");
      out.write("                        ");
} else if(confirmDegRanking.next() && !confirmDipRanking.next() && !confirmCertRanking.next()){
      out.write("\n");
      out.write("                        <h4 class=\"alert alert-info\">Check Carefully on the table below;</h4>\n");
      out.write("                        <table class=\"table table-bordered\">\n");
      out.write("                            <thead>\n");
      out.write("                                <tr>\n");
      out.write("                                    <th>Course Level</th>\n");
      out.write("                                    <th>Course Name</th>\n");
      out.write("                                    <th>Application Status</th>\n");
      out.write("                                    <th>Comment</th>\n");
      out.write("                                </tr>\n");
      out.write("                            </thead>\n");
      out.write("                            ");
int li=0;
                            int ci=0;
                            int rank=0;
                            int i=0;
                            String[] levels=new String[12];
                            String[] names=new String[12];
                            String[] status=new String[12];
                            String[] comments=new String[12];
                            ResultSet crn=null;
                            ResultSet ln=null;
                        while(crs.next()){
                            li=crs.getInt("Level_id");
                            ci=crs.getInt("Course_id");
                           
                            if(li==3&&ci==1){
                                ResultSet getrank=user.getDegCsRank(applicantId);
                                
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                 }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Not Successful";
                                      comments[i]="Thanks for your application.";
                                       } 
                                }
                                i++;
                            }
                            
                            if(li==3&&ci==2){
                                ResultSet getrank=user.getDegItRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next(); 
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Not Successful";
                                      comments[i]="Thanks for your application.";
                                  }
                                }
                                i++; 
                            }
                            
                            if(li==3&&ci==3){
                                ResultSet getrank=user.getDegInfoRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Not Successful";
                                      comments[i]="Thanks for your application.";
                                  }
                                }
                                i++;
                            }
                            
                            if(li==3&&ci==4){
                                ResultSet getrank=user.getDegCfRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                 }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Not Successful";
                                      comments[i]="Thanks for your application.";
                                  }
                                }
                                i++;
                            }
                            
                            if(li==4&&ci==1){
                                ResultSet getrank=user.getDipCsRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                 }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Diploma results not yet out.";
                                      comments[i]="keep checking.";
                                   }
                                }
                                i++;
                            }
                            
                            if(li==4&&ci==2){
                                ResultSet getrank=user.getDipItRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Diploma results not yet out.";
                                      comments[i]="Keep checking.";
                                  }
                                }
                                i++;
                            }
                            
                            if(li==4&&ci==3){ 
                                ResultSet getrank=user.getDipInfoRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Diploma results not yet out.";
                                      comments[i]="keep checking.";
                                   }
                                }
                                i++;
                            }
                            
                            if(li==4&&ci==4){ 
                                ResultSet getrank=user.getDipCfRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Diploma results not yet out.";
                                      comments[i]="keep checking.";
                                   }
                                }
                                i++;
                            }
                            
                            if(li==5&&ci==2){ 
                                ResultSet getrank=user.getCertItRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Certificate results not yet out.";
                                      comments[i]="keep checking.";
                                   }
                                }
                                i++;
                            }
                            
                            if(li==5&&ci==4){ 
                                ResultSet getrank=user.getCertCfRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Certificate results not yet out.";
                                      comments[i]="keep checking.";
                                  }
                                }
                                i++;
                            }
                            
                            if(li==5&&ci==5){ 
                                ResultSet getrank=user.getCertIsRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id")); 
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Certificate results not yet out.";
                                      comments[i]="keep checking.";
                                  }
                                }
                                i++;
                            }
                            
                            if(li==5&&ci==6){ 
                                ResultSet getrank=user.getCertHmRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Certificate results not yet out.";
                                      comments[i]="keep checking.";
                                  }
                                }
                                i++;
                            }
                           }
      out.write("\n");
      out.write("                           ");
 --i;
      out.write("\n");
      out.write("                           ");
while(i>=0){
      out.write("\n");
      out.write("                           <tr>\n");
      out.write("                               <td>");
      out.print(levels[i]);
      out.write("</td> \n");
      out.write("                               <td>");
      out.print(names[i]);
      out.write("</td>\n");
      out.write("                               <td>");
      out.print(status[i]);
      out.write("</td>\n");
      out.write("                               <td>");
      out.print(comments[i]);
      out.write("</td>\n");
      out.write("                           </tr>\n");
      out.write("                           ");
i--;}
      out.write("\n");
      out.write("                        </table>\n");
      out.write("                        ");
} else if(!confirmDegRanking.next() && confirmDipRanking.next() && !confirmCertRanking.next()){
      out.write("\n");
      out.write("                        <h4 class=\"alert alert-info\">Check Carefully on the table below;</h4>\n");
      out.write("                        <table class=\"table table-bordered\">\n");
      out.write("                            <thead>\n");
      out.write("                                <tr>\n");
      out.write("                                    <th>Course Level</th>\n");
      out.write("                                    <th>Course Name</th>\n");
      out.write("                                    <th>Application Status</th>\n");
      out.write("                                    <th>Comment</th>\n");
      out.write("                                </tr>\n");
      out.write("                            </thead>\n");
      out.write("                            ");
int li=0;
                            int ci=0;
                            int rank=0;
                            int i=0;
                            String[] levels=new String[12];
                            String[] names=new String[12];
                            String[] status=new String[12];
                            String[] comments=new String[12];
                            ResultSet crn=null;
                            ResultSet ln=null;
                        while(crs.next()){
                            li=crs.getInt("Level_id");
                            ci=crs.getInt("Course_id");
                           
                            if(li==3&&ci==1){
                                ResultSet getrank=user.getDegCsRank(applicantId);
                                
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                 }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Degree results not yet out.";
                                      comments[i]="keep checking.";
                                       } 
                                }
                                i++;
                            }
                            
                            if(li==3&&ci==2){
                                ResultSet getrank=user.getDegItRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next(); 
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Degree results not yet out.";
                                      comments[i]="keep checking.";
                                  }
                                }
                                i++; 
                            }
                            
                            if(li==3&&ci==3){
                                ResultSet getrank=user.getDegInfoRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Degree results not yet out.";
                                      comments[i]="keep checking.";
                                  }
                                }
                                i++;
                            }
                            
                            if(li==3&&ci==4){
                                ResultSet getrank=user.getDegCfRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                 }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Degree results not yet out.";
                                      comments[i]="keep checking.";
                                  }
                                }
                                i++;
                            }
                            
                            if(li==4&&ci==1){
                                ResultSet getrank=user.getDipCsRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                 }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Not Successful";
                                      comments[i]="Thanks for your application.";
                                   }
                                }
                                i++;
                            }
                            
                            if(li==4&&ci==2){
                                ResultSet getrank=user.getDipItRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Not Successful";
                                      comments[i]="Thanks for your application.";
                                  }
                                }
                                i++;
                            }
                            
                            if(li==4&&ci==3){ 
                                ResultSet getrank=user.getDipInfoRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Not Successful";
                                      comments[i]="Thanks for your application.";
                                   }
                                }
                                i++;
                            }
                            
                            if(li==4&&ci==4){ 
                                ResultSet getrank=user.getDipCfRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Not Successful";
                                      comments[i]="Thanks for your application.";
                                   }
                                }
                                i++;
                            }
                            
                            if(li==5&&ci==2){ 
                                ResultSet getrank=user.getCertItRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Certificate results not yet out.";
                                      comments[i]="keep checking.";
                                   }
                                }
                                i++;
                            }
                            
                            if(li==5&&ci==4){ 
                                ResultSet getrank=user.getCertCfRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Certificate results not yet out.";
                                      comments[i]="keep checking.";
                                  }
                                }
                                i++;
                            }
                            
                            if(li==5&&ci==5){ 
                                ResultSet getrank=user.getCertIsRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id")); 
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Certificate results not yet out.";
                                      comments[i]="keep checking.";
                                  }
                                }
                                i++;
                            }
                            
                            if(li==5&&ci==6){ 
                                ResultSet getrank=user.getCertHmRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Certificate results not yet out.";
                                      comments[i]="keep checking.";
                                  }
                                }
                                i++;
                            }
                           }
      out.write("\n");
      out.write("                           ");
 --i;
      out.write("\n");
      out.write("                           ");
while(i>=0){
      out.write("\n");
      out.write("                           <tr>\n");
      out.write("                               <td>");
      out.print(levels[i]);
      out.write("</td> \n");
      out.write("                               <td>");
      out.print(names[i]);
      out.write("</td>\n");
      out.write("                               <td>");
      out.print(status[i]);
      out.write("</td>\n");
      out.write("                               <td>");
      out.print(comments[i]);
      out.write("</td>\n");
      out.write("                           </tr>\n");
      out.write("                           ");
i--;}
      out.write("\n");
      out.write("                        </table>\n");
      out.write("                        ");
} else if(!confirmDegRanking.next() && !confirmDipRanking.next() && confirmCertRanking.next()){
      out.write("\n");
      out.write("                        <h4 class=\"alert alert-info\">Check Carefully on the table below;</h4>\n");
      out.write("                        <table class=\"table table-bordered\">\n");
      out.write("                            <thead>\n");
      out.write("                                <tr>\n");
      out.write("                                    <th>Course Level</th>\n");
      out.write("                                    <th>Course Name</th>\n");
      out.write("                                    <th>Application Status</th>\n");
      out.write("                                    <th>Comment</th>\n");
      out.write("                                </tr>\n");
      out.write("                            </thead>\n");
      out.write("                            ");
int li=0;
                            int ci=0;
                            int rank=0;
                            int i=0;
                            String[] levels=new String[12];
                            String[] names=new String[12];
                            String[] status=new String[12];
                            String[] comments=new String[12];
                            ResultSet crn=null;
                            ResultSet ln=null;
                        while(crs.next()){
                            li=crs.getInt("Level_id");
                            ci=crs.getInt("Course_id");
                           
                            if(li==3&&ci==1){
                                ResultSet getrank=user.getDegCsRank(applicantId);
                                
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                 }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Degree results not yet out.";
                                      comments[i]="keep checking.";
                                       } 
                                }
                                i++;
                            }
                            
                            if(li==3&&ci==2){
                                ResultSet getrank=user.getDegItRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next(); 
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Degree results not yet out.";
                                      comments[i]="keep checking.";
                                  }
                                }
                                i++; 
                            }
                            
                            if(li==3&&ci==3){
                                ResultSet getrank=user.getDegInfoRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Degree results not yet out.";
                                      comments[i]="keep checking.";
                                  }
                                }
                                i++;
                            }
                            
                            if(li==3&&ci==4){
                                ResultSet getrank=user.getDegCfRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                 }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Degree results not yet out.";
                                      comments[i]="keep checking.";
                                  }
                                }
                                i++;
                            }
                            
                            if(li==4&&ci==1){
                                ResultSet getrank=user.getDipCsRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                 }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Diploma results not yet out.";
                                      comments[i]="keep checking.";
                                   }
                                }
                                i++;
                            }
                            
                            if(li==4&&ci==2){
                                ResultSet getrank=user.getDipItRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Diploma results not yet out.";
                                      comments[i]="keep checking.";
                                  }
                                }
                                i++;
                            }
                            
                            if(li==4&&ci==3){ 
                                ResultSet getrank=user.getDipInfoRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Diploma results not yet out.";
                                      comments[i]="keep checking.";
                                   }
                                }
                                i++;
                            }
                            
                            if(li==4&&ci==4){ 
                                ResultSet getrank=user.getDipCfRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Diploma results not yet out.";
                                      comments[i]="keep checking.";
                                   }
                                }
                                i++;
                            }
                            
                            if(li==5&&ci==2){ 
                                ResultSet getrank=user.getCertItRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Not Successful";
                                      comments[i]="Thanks for your application.";
                                   }
                                }
                                i++;
                            }
                            
                            if(li==5&&ci==4){ 
                                ResultSet getrank=user.getCertCfRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Not Successful";
                                      comments[i]="Thanks for your application.";
                                  }
                                }
                                i++;
                            }
                            
                            if(li==5&&ci==5){ 
                                ResultSet getrank=user.getCertIsRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id")); 
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Not Successful";
                                      comments[i]="Thanks for your application.";
                                  }
                                }
                                i++;
                            }
                            
                            if(li==5&&ci==6){ 
                                ResultSet getrank=user.getCertHmRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Not Successful";
                                      comments[i]="Thanks for your application.";
                                  }
                                }
                                i++;
                            }
                           }
      out.write("\n");
      out.write("                           ");
 --i;
      out.write("\n");
      out.write("                           ");
while(i>=0){
      out.write("\n");
      out.write("                           <tr>\n");
      out.write("                               <td>");
      out.print(levels[i]);
      out.write("</td> \n");
      out.write("                               <td>");
      out.print(names[i]);
      out.write("</td>\n");
      out.write("                               <td>");
      out.print(status[i]);
      out.write("</td>\n");
      out.write("                               <td>");
      out.print(comments[i]);
      out.write("</td>\n");
      out.write("                           </tr>\n");
      out.write("                           ");
i--;}
      out.write("\n");
      out.write("                        </table>\n");
      out.write("                        ");
}
                        else if(confirmDegRanking.next() && confirmDipRanking.next() || !confirmCertRanking.next()){
      out.write("\n");
      out.write("                        <h4 class=\"alert alert-info\">Check Carefully on the table below;</h4>\n");
      out.write("                        <table class=\"table table-bordered\">\n");
      out.write("                            <thead>\n");
      out.write("                                <tr>\n");
      out.write("                                    <th>Course Level</th>\n");
      out.write("                                    <th>Course Name</th>\n");
      out.write("                                    <th>Application Status</th>\n");
      out.write("                                    <th>Comment</th>\n");
      out.write("                                </tr>\n");
      out.write("                            </thead>\n");
      out.write("                            ");
int li=0;
                            int ci=0;
                            int rank=0;
                            int i=0;
                            String[] levels=new String[12];
                            String[] names=new String[12];
                            String[] status=new String[12];
                            String[] comments=new String[12];
                            ResultSet crn=null;
                            ResultSet ln=null;
                        while(crs.next()){
                            li=crs.getInt("Level_id");
                            ci=crs.getInt("Course_id");
                           
                            if(li==3&&ci==1){
                                ResultSet getrank=user.getDegCsRank(applicantId);
                                
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                 }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Not Successful";
                                      comments[i]="Thanks for your application.";
                                       } 
                                }
                                i++;
                            }
                            
                            if(li==3&&ci==2){
                                ResultSet getrank=user.getDegItRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next(); 
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Not Successful";
                                      comments[i]="Thanks for your application.";
                                  }
                                }
                                i++; 
                            }
                            
                            if(li==3&&ci==3){
                                ResultSet getrank=user.getDegInfoRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Not Successful";
                                      comments[i]="Thanks for your application.";
                                  }
                                }
                                i++;
                            }
                            
                            if(li==3&&ci==4){
                                ResultSet getrank=user.getDegCfRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                 }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Not Successful";
                                      comments[i]="Thanks for your application.";
                                  }
                                }
                                i++;
                            }
                            
                            if(li==4&&ci==1){
                                ResultSet getrank=user.getDipCsRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                 }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Not Successful";
                                      comments[i]="Thanks for your application.";
                                   }
                                }
                                i++;
                            }
                            
                            if(li==4&&ci==2){
                                ResultSet getrank=user.getDipItRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Not Successful";
                                      comments[i]="Thanks for your application.";
                                  }
                                }
                                i++;
                            }
                            
                            if(li==4&&ci==3){ 
                                ResultSet getrank=user.getDipInfoRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Not Successful";
                                      comments[i]="Thanks for your application.";
                                   }
                                }
                                i++;
                            }
                            
                            if(li==4&&ci==4){ 
                                ResultSet getrank=user.getDipCfRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Not Successful";
                                      comments[i]="Thanks for your application.";
                                   }
                                }
                                i++;
                            }
                            
                            if(li==5&&ci==2){ 
                                ResultSet getrank=user.getCertItRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Certificate results not yet out.";
                                      comments[i]="keep checking.";
                                   }
                                }
                                i++;
                            }
                            
                            if(li==5&&ci==4){ 
                                ResultSet getrank=user.getCertCfRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Certificate results not yet out.";
                                      comments[i]="keep checking.";
                                  }
                                }
                                i++;
                            }
                            
                            if(li==5&&ci==5){ 
                                ResultSet getrank=user.getCertIsRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id")); 
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Certificate results not yet out.";
                                      comments[i]="keep checking.";
                                  }
                                }
                                i++;
                            }
                            
                            if(li==5&&ci==6){ 
                                ResultSet getrank=user.getCertHmRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Certificate results not yet out.";
                                      comments[i]="keep checking.";
                                  }
                                }
                                i++;
                            }
                           }
      out.write("\n");
      out.write("                           ");
 --i;
      out.write("\n");
      out.write("                           ");
while(i>=0){
      out.write("\n");
      out.write("                           <tr>\n");
      out.write("                               <td>");
      out.print(levels[i]);
      out.write("</td> \n");
      out.write("                               <td>");
      out.print(names[i]);
      out.write("</td>\n");
      out.write("                               <td>");
      out.print(status[i]);
      out.write("</td>\n");
      out.write("                               <td>");
      out.print(comments[i]);
      out.write("</td>\n");
      out.write("                           </tr>\n");
      out.write("                           ");
i--;}
      out.write("\n");
      out.write("                        </table>\n");
      out.write("                        ");
} else if(confirmDegRanking.next() && !confirmDipRanking.next() && confirmCertRanking.next()){
      out.write("\n");
      out.write("                        <h4 class=\"alert alert-info\">Check Carefully on the table below;</h4>\n");
      out.write("                        <table class=\"table table-bordered\">\n");
      out.write("                            <thead>\n");
      out.write("                                <tr>\n");
      out.write("                                    <th>Course Level</th>\n");
      out.write("                                    <th>Course Name</th>\n");
      out.write("                                    <th>Application Status</th>\n");
      out.write("                                    <th>Comment</th>\n");
      out.write("                                </tr>\n");
      out.write("                            </thead>\n");
      out.write("                            ");
int li=0;
                            int ci=0;
                            int rank=0;
                            int i=0;
                            String[] levels=new String[12];
                            String[] names=new String[12];
                            String[] status=new String[12];
                            String[] comments=new String[12];
                            ResultSet crn=null;
                            ResultSet ln=null;
                        while(crs.next()){
                            li=crs.getInt("Level_id");
                            ci=crs.getInt("Course_id");
                           
                            if(li==3&&ci==1){
                                ResultSet getrank=user.getDegCsRank(applicantId);
                                
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                 }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Not Successful";
                                      comments[i]="Thanks for your application.";
                                       } 
                                }
                                i++;
                            }
                            
                            if(li==3&&ci==2){
                                ResultSet getrank=user.getDegItRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next(); 
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Not Successful";
                                      comments[i]="Thanks for your application.";
                                  }
                                }
                                i++; 
                            }
                            
                            if(li==3&&ci==3){
                                ResultSet getrank=user.getDegInfoRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Not Successful";
                                      comments[i]="Thanks for your application.";
                                  }
                                }
                                i++;
                            }
                            
                            if(li==3&&ci==4){
                                ResultSet getrank=user.getDegCfRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                 }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Not Successful";
                                      comments[i]="Thanks for your application.";
                                  }
                                }
                                i++;
                            }
                            
                            if(li==4&&ci==1){
                                ResultSet getrank=user.getDipCsRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                 }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Diploma results not yet out.";
                                      comments[i]="keep checking.";
                                   }
                                }
                                i++;
                            }
                            
                            if(li==4&&ci==2){
                                ResultSet getrank=user.getDipItRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Diploma results not yet out.";
                                      comments[i]="keep checking.";
                                  }
                                }
                                i++;
                            }
                            
                            if(li==4&&ci==3){ 
                                ResultSet getrank=user.getDipInfoRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Diploma results not yet out.";
                                      comments[i]="keep checking.";
                                   }
                                }
                                i++;
                            }
                            
                            if(li==4&&ci==4){ 
                                ResultSet getrank=user.getDipCfRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Diploma results not yet out.";
                                      comments[i]="keep checking.";
                                   }
                                }
                                i++;
                            }
                            
                            if(li==5&&ci==2){ 
                                ResultSet getrank=user.getCertItRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Not Successful";
                                      comments[i]="Thanks for your application.";
                                   }
                                }
                                i++;
                            }
                            
                            if(li==5&&ci==4){ 
                                ResultSet getrank=user.getCertCfRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Not Successful";
                                      comments[i]="Thanks for your application.";
                                  }
                                }
                                i++;
                            }
                            
                            if(li==5&&ci==5){ 
                                ResultSet getrank=user.getCertIsRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id")); 
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Not Successful";
                                      comments[i]="Thanks for your application.";
                                  }
                                }
                                i++;
                            }
                            
                            if(li==5&&ci==6){ 
                                ResultSet getrank=user.getCertHmRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Not Successful";
                                      comments[i]="Thanks for your application.";
                                  }
                                }
                                i++;
                            }
                           }
      out.write("\n");
      out.write("                           ");
 --i;
      out.write("\n");
      out.write("                           ");
while(i>=0){
      out.write("\n");
      out.write("                           <tr>\n");
      out.write("                               <td>");
      out.print(levels[i]);
      out.write("</td> \n");
      out.write("                               <td>");
      out.print(names[i]);
      out.write("</td>\n");
      out.write("                               <td>");
      out.print(status[i]);
      out.write("</td>\n");
      out.write("                               <td>");
      out.print(comments[i]);
      out.write("</td>\n");
      out.write("                           </tr>\n");
      out.write("                           ");
i--;}
      out.write("\n");
      out.write("                        </table>\n");
      out.write("                        ");
} else if(!confirmDegRanking.next() && confirmDipRanking.next() && confirmCertRanking.next()){
      out.write("\n");
      out.write("                        <h4 class=\"alert alert-info\">Check Carefully on the table below;</h4>\n");
      out.write("                        <table class=\"table table-bordered\">\n");
      out.write("                            <thead>\n");
      out.write("                                <tr>\n");
      out.write("                                    <th>Course Level</th>\n");
      out.write("                                    <th>Course Name</th>\n");
      out.write("                                    <th>Application Status</th>\n");
      out.write("                                    <th>Comment</th>\n");
      out.write("                                </tr>\n");
      out.write("                            </thead>\n");
      out.write("                            ");
int li=0;
                            int ci=0;
                            int rank=0;
                            int i=0;
                            String[] levels=new String[12];
                            String[] names=new String[12];
                            String[] status=new String[12];
                            String[] comments=new String[12];
                            ResultSet crn=null;
                            ResultSet ln=null;
                        while(crs.next()){
                            li=crs.getInt("Level_id");
                            ci=crs.getInt("Course_id");
                           
                            if(li==3&&ci==1){
                                ResultSet getrank=user.getDegCsRank(applicantId);
                                
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                 }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Degree results not yet out.";
                                      comments[i]="keep checking.";
                                       } 
                                }
                                i++;
                            }
                            
                            if(li==3&&ci==2){
                                ResultSet getrank=user.getDegItRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next(); 
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Degree results not yet out.";
                                      comments[i]="keep checking.";
                                  }
                                }
                                i++; 
                            }
                            
                            if(li==3&&ci==3){
                                ResultSet getrank=user.getDegInfoRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Degree results not yet out.";
                                      comments[i]="keep checking.";
                                  }
                                }
                                i++;
                            }
                            
                            if(li==3&&ci==4){
                                ResultSet getrank=user.getDegCfRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                 }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Degree results not yet out.";
                                      comments[i]="keep checking.";
                                  }
                                }
                                i++;
                            }
                            
                            if(li==4&&ci==1){
                                ResultSet getrank=user.getDipCsRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                 }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Not Successful";
                                      comments[i]="Thanks for your application.";
                                   }
                                }
                                i++;
                            }
                            
                            if(li==4&&ci==2){
                                ResultSet getrank=user.getDipItRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Not Successful";
                                      comments[i]="Thanks for your application.";
                                  }
                                }
                                i++;
                            }
                            
                            if(li==4&&ci==3){ 
                                ResultSet getrank=user.getDipInfoRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Not Successful";
                                      comments[i]="Thanks for your application.";
                                   }
                                }
                                i++;
                            }
                            
                            if(li==4&&ci==4){ 
                                ResultSet getrank=user.getDipCfRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Not Successful";
                                      comments[i]="Thanks for your application.";
                                   }
                                }
                                i++;
                            }
                            
                            if(li==5&&ci==2){ 
                                ResultSet getrank=user.getCertItRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Not Successful";
                                      comments[i]="Thanks for your application.";
                                   }
                                }
                                i++;
                            }
                            
                            if(li==5&&ci==4){ 
                                ResultSet getrank=user.getCertCfRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Not Successful";
                                      comments[i]="Thanks for your application.";
                                  }
                                }
                                i++;
                            }
                            
                            if(li==5&&ci==5){ 
                                ResultSet getrank=user.getCertIsRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id")); 
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Not Successful";
                                      comments[i]="Thanks for your application.";
                                  }
                                }
                                i++;
                            }
                            
                            if(li==5&&ci==6){ 
                                ResultSet getrank=user.getCertHmRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Not Successful";
                                      comments[i]="Thanks for your application.";
                                  }
                                }
                                i++;
                            }
                           }
      out.write("\n");
      out.write("                           ");
 --i;
      out.write("\n");
      out.write("                           ");
while(i>=0){
      out.write("\n");
      out.write("                           <tr>\n");
      out.write("                               <td>");
      out.print(levels[i]);
      out.write("</td> \n");
      out.write("                               <td>");
      out.print(names[i]);
      out.write("</td>\n");
      out.write("                               <td>");
      out.print(status[i]);
      out.write("</td>\n");
      out.write("                               <td>");
      out.print(comments[i]);
      out.write("</td>\n");
      out.write("                           </tr>\n");
      out.write("                           ");
i--;}
      out.write("\n");
      out.write("                        </table>\n");
      out.write("                        ");
}
                        else if(confirmDegRanking.next() && confirmDipRanking.next() && confirmCertRanking.next()){
      out.write("\n");
      out.write("                        <h4 class=\"alert alert-info\">Check Carefully on the table below;</h4>\n");
      out.write("                        <table class=\"table table-bordered\">\n");
      out.write("                            <thead>\n");
      out.write("                                <tr>\n");
      out.write("                                    <th>Course Level</th>\n");
      out.write("                                    <th>Course Name</th>\n");
      out.write("                                    <th>Application Status</th>\n");
      out.write("                                    <th>Comment</th>\n");
      out.write("                                </tr>\n");
      out.write("                            </thead>\n");
      out.write("                            ");
int li=0;
                            int ci=0;
                            int rank=0;
                            int i=0;
                            String[] levels=new String[12];
                            String[] names=new String[12];
                            String[] status=new String[12];
                            String[] comments=new String[12];
                            ResultSet crn=null;
                            ResultSet ln=null;
                        while(crs.next()){
                            li=crs.getInt("Level_id");
                            ci=crs.getInt("Course_id");
                           
                            if(li==3&&ci==1){
                                ResultSet getrank=user.getDegCsRank(applicantId);
                                
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                 }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Not Successful";
                                      comments[i]="Thanks for your application.";
                                       } 
                                }
                                i++;
                            }
                            
                            if(li==3&&ci==2){
                                ResultSet getrank=user.getDegItRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next(); 
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Not Successful";
                                      comments[i]="Thanks for your application.";
                                  }
                                }
                                i++; 
                            }
                            
                            if(li==3&&ci==3){
                                ResultSet getrank=user.getDegInfoRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Not Successful";
                                      comments[i]="Thanks for your application.";
                                  }
                                }
                                i++;
                            }
                            
                            if(li==3&&ci==4){
                                ResultSet getrank=user.getDegCfRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                 }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Not Successful";
                                      comments[i]="Thanks for your application.";
                                  }
                                }
                                i++;
                            }
                            
                            if(li==4&&ci==1){
                                ResultSet getrank=user.getDipCsRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                 }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Not Successful";
                                      comments[i]="Thanks for your application.";
                                   }
                                }
                                i++;
                            }
                            
                            if(li==4&&ci==2){
                                ResultSet getrank=user.getDipItRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Not Successful";
                                      comments[i]="Thanks for your application.";
                                  }
                                }
                                i++;
                            }
                            
                            if(li==4&&ci==3){ 
                                ResultSet getrank=user.getDipInfoRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Not Successful";
                                      comments[i]="Thanks for your application.";
                                   }
                                }
                                i++;
                            }
                            
                            if(li==4&&ci==4){ 
                                ResultSet getrank=user.getDipCfRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Not Successful";
                                      comments[i]="Thanks for your application.";
                                   }
                                }
                                i++;
                            }
                            
                            if(li==5&&ci==2){ 
                                ResultSet getrank=user.getCertItRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Not Successful";
                                      comments[i]="Thanks for your application.";
                                   }
                                }
                                i++;
                            }
                            
                            if(li==5&&ci==4){ 
                                ResultSet getrank=user.getCertCfRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Not Successful";
                                      comments[i]="Thanks for your application.";
                                  }
                                }
                                i++;
                            }
                            
                            if(li==5&&ci==5){ 
                                ResultSet getrank=user.getCertIsRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id")); 
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Not Successful";
                                      comments[i]="Thanks for your application.";
                                  }
                                }
                                i++;
                            }
                            
                            if(li==5&&ci==6){ 
                                ResultSet getrank=user.getCertHmRank(applicantId);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=user.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                      crn=user.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=user.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=user.getCourseName(ci);
                                      crn.next();
                                      ln=user.getLevelName(li);
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Not Successful";
                                      comments[i]="Thanks for your application.";
                                  }
                                }
                                i++;
                            }
                           }
      out.write("\n");
      out.write("                           ");
 --i;
      out.write("\n");
      out.write("                           ");
while(i>=0){
      out.write("\n");
      out.write("                           <tr>\n");
      out.write("                               <td>");
      out.print(levels[i]);
      out.write("</td> \n");
      out.write("                               <td>");
      out.print(names[i]);
      out.write("</td>\n");
      out.write("                               <td>");
      out.print(status[i]);
      out.write("</td>\n");
      out.write("                               <td>");
      out.print(comments[i]);
      out.write("</td>\n");
      out.write("                           </tr>\n");
      out.write("                           ");
i--;}
      out.write("\n");
      out.write("                        </table>\n");
      out.write("                        ");
}
                        }
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"modal-footer\">\n");
      out.write("                        <button type=\"button\" class=\"btn btn-danger\" data-dismiss=\"modal\">close</button> \n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("                <!-- Core Scripts - Include with every page -->\n");
      out.write("                <script src=\"assets/plugins/jquery-1.10.2.js\"></script>\n");
      out.write("                <script src=\"assets/plugins/bootstrap/bootstrap.min.js\"></script>\n");
      out.write("                <script src=\"assets/plugins/metisMenu/jquery.metisMenu.js\"></script>\n");
      out.write("                <script src=\"mycss/dateValidator.js\"></script> \n");
      out.write("                <script type=\"text/javascript\" src=\"mycss/modal/jquery.minCust.js\"></script>\n");
      out.write("                <script type=\"text/javascript\" src=\"mycss/modal/bootstrapJsCust.js\"></script>\n");
      out.write("                <script type=\"text/javascript\" src=\"mycss/validation/jquery.js\"></script>\n");
      out.write("                <script type=\"text/javascript\" src=\"mycss/validation/jquery.validate.js\"></script>\n");
      out.write("                <script type=\"text/javascript\" src=\"mycss/validation/additional-methods.js\"></script>\n");
      out.write("                <script src=\"mycss/validation/custom.js\"></script>\n");
      out.write("                \n");
      out.write("                <script src=\"js/bootstrap-formhelpers.min.js\"></script>\n");
      out.write("               \n");
      out.write("                <script>\n");
      out.write("                    $(document).ready(function(){\n");
      out.write("                        $(\"#programmeLevel\").change(function(){\n");
      out.write("                            var value = $(this).val();\n");
      out.write("                            $.get(\"GetCourses.jsp\",{programmeLevel:value},function(data){\n");
      out.write("                                $(\"#programmeName\").html(data);//append('<option>' + data + '</option>');\n");
      out.write("                            });\n");
      out.write("                        });\n");
      out.write("                    });\n");
      out.write("                </script>\n");
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
