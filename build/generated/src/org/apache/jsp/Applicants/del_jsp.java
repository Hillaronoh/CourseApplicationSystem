package org.apache.jsp.Applicants;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.text.DecimalFormat;
import java.sql.*;
import myproject.*;

public final class del_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write(" \n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Applicant's Details</title>\n");
      out.write("        <!--start announcement box-->\n");
      out.write("        <link href=\"mycss/chatbox/bootstrap.css\" rel=\"stylesheet\" style type=\"text/css\">\n");
      out.write("        <link href=\"mycss/chatbox/chatbox.css\" rel=\"stylesheet\" style type=\"text/css\">\n");
      out.write("        <!--end announcement box-->\n");
      out.write("        <!--start navigation menus-->\n");
      out.write("        <link rel=\"stylesheet\" href=\"mycss/glyphicons/css/bootstrap.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" style type=\"text/css\" href=\"mycss/navMenus.css\">\n");
      out.write("        <!--end navigation menus-->\n");
      out.write("        <!-- Core CSS - Include with every page -->\n");
      out.write("        <link href=\"assets/plugins/bootstrap/bootstrap.css\" rel=\"stylesheet\" />\n");
      out.write("        <link href=\"assets/font-awesome/css/font-awesome.css\" rel=\"stylesheet\" />\n");
      out.write("        <link href=\"assets/plugins/pace/pace-theme-big-counter.css\" rel=\"stylesheet\" />\n");
      out.write("        <link href=\"assets/css/style.css\" rel=\"stylesheet\" />\n");
      out.write("        <link href=\"assets/css/main-style.css\" rel=\"stylesheet\" />\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"mycss/style2.css\">\n");
      out.write("            \n");
      out.write("        <style>\n");
      out.write("            .error{\n");
      out.write("                color: red;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("            \n");
      out.write("        <!--start date picker-->\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" media=\"all\" href=\"jsDatePick_ltr.min.css\" />\n");
      out.write("        <script type=\"text/javascript\" src=\"jsDatePick.min.1.3.js\"></script>\n");
      out.write("        \n");
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
      out.write("    </head>\n");
      out.write("     <body style=\"overflow-x: hidden; background-color: #EFEEEE;\">  \n");
      out.write("         ");

            response.setHeader("Cache-Control","no-cache"); //Forces caches to obtain a new copy of the page from the origin server
            response.setHeader("Cache-Control","no-store"); //Directs caches not to store the page under any circumstance
            response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page 
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
       
            
      out.write("       \n");
      out.write("                   \n");
      out.write("            ");

            Applicant user=new Applicant();
            String firstName=new String();
           
            ResultSet results=user.getApplicantDetails(applicantId);
           
            if(results.next()){
                firstName=results.getString("First_Name");
            }
           
            ResultSet results1=user.getPersonalDetails(applicantId);
            ResultSet results2=user.getEducationBackground(applicantId);
            ResultSet results3=user.getCourseDetails(applicantId);
            
            boolean checkDet=false;
            boolean checkEd=false;
            boolean checkCrs=false;
            ResultSet det=user.confirmDetails(applicantId);
            if(det.next()){
                checkDet=true;
            }
            ResultSet check1=user.checkSectionB(applicantId); 
            if(check1.next()){
                checkEd=true;
            }
            ResultSet check2=user.checkSectionC(applicantId);
            if(check2.next()){
                checkCrs=true;
            }
           
            String fName=new String();
            String mName=new String();
            String lName=new String();
            String dob=new String();
            String gender=new String();
            String address=new String();
            String mobile=new String();
            String country=new String();
           
            String physicsGrade=new String();
            String mathsGrade=new String();
            String subj3Grade=new String();
            String subj4Grade=new String();
            String meanGrade=new String();
            String aggregatePoints=new String();
            String clusterPoints=new String();
           
            String []levelNames=new String[100];
            String []courseNames=new String[100];
           
            int resultsE=0;
            if(request.getParameter("save1")!=null){
                String dobE=request.getParameter("dob");
                String genderE=request.getParameter("gender");
                String addressE=request.getParameter("address");
                String mobileE=request.getParameter("mobile");
                String countryE=request.getParameter("country");
                resultsE=user.editPersonalDetails(dobE, genderE, addressE, mobileE, countryE, applicantId); 
            }
           
            int resultsE1=0;
            if(request.getParameter("save2")!=null){              
                String physics=request.getParameter("physicsGrade");
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
               
                resultsE1=user.editEducationBackground(physics, maths, subj3, subj4, mean, aggregatePointsDouble, clusterPointsE, applicantId);
            } 
           
            
      out.write("\n");
      out.write("        \n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Header.jsp", out, false);
      out.write("\n");
      out.write("     <div class=\"container\">\n");
      out.write("                \n");
      out.write("                <div class=\"row1\" style=\"margin-top: 0px;\">\n");
      out.write("                    \n");
      out.write("                    <div class=\"col-md-4 col-md-offset-4\" style=\"width: 1082px; margin-left: 43px;\">\n");
      out.write("                        \n");
      out.write("                        <div class=\"login-panel panel panel-default\"> \n");
      out.write("                            <!--start navigation menus-->\n");
      out.write("                            <div id=\"navMenu\" style=\"margin-top: 2px;\">\n");
      out.write("                                <ul>\n");
      out.write("                                    <li><a href=\"UserAccount.jsp\"><button class=\"btn btn-info\" style=\"width: 148px; height: 38px; padding-top: 0px; margin-top: -5px;\"><i class=\"fa fa-home\"></i>Home</button></a>\n");
      out.write("                                    </li>\n");
      out.write("                                </ul>\n");
      out.write("                                <ul>\n");
      out.write("                                    <li><a href=\"#\"><button class=\"btn btn-info\" style=\"width: 148px; height: 38px; padding-top: 0px; margin-top: -5px;\"><i class=\"fa fa-arrow-down\"></i>Apply Course</button></a>\n");
      out.write("                                        <ul>\n");
      out.write("                                            <li><a href=\"ApplicationForm.jsp\">Under Graduate</a></li>\n");
      out.write("                                            <li><a href=\"#\">Post Graduate</a></li>\n");
      out.write("                                        </ul>\n");
      out.write("                                    </li>\n");
      out.write("                                </ul>\n");
      out.write("                                <ul>\n");
      out.write("                                    <li><a href=\"Announcements.jsp\"><button class=\"btn btn-info\" style=\"width: 148px; height: 38px; padding-top: 0px; margin-top: -5px;\"><i class=\"fa fa-bell\"></i>Announcements</button></a>\n");
      out.write("                                        \n");
      out.write("                                    </li>\n");
      out.write("                                </ul>\n");
      out.write("                                <ul>\n");
      out.write("                                    <li><a href=\"#\"><button class=\"btn btn-info\" style=\"width: 148px; height: 38px; padding-top: 0px; margin-top: -5px; background-color: #428BCA;\"><i class=\"fa fa-archive\"></i>My Details</button></a>     \n");
      out.write("                                    </li>\n");
      out.write("                                </ul>\n");
      out.write("                                <ul>\n");
      out.write("                                    <li><a href=\"Messaging.jsp\"><button class=\"btn btn-info\" style=\"width: 148px; height: 38px; padding-top: 0px; margin-top: -5px;\"><i class=\"fa fa-inbox\"></i>Inquiries</button></a>\n");
      out.write("                                        \n");
      out.write("                                    </li>\n");
      out.write("                                </ul>\n");
      out.write("                                <ul>\n");
      out.write("                                    <li><a href=\"#ApplicationStatus\" data-toggle=\"modal\"><button class=\"btn btn-info\" style=\"width: 148px; height: 38px; padding-top: 0px; margin-top: -5px;\"><i class=\"fa fa-star\"></i>Application Status</button></a>\n");
      out.write("                                    </li>\n");
      out.write("                                </ul>\n");
      out.write("                                <ul>\n");
      out.write("                                    <li><a href=\"#\"><button class=\"btn btn-info\" style=\"width: 148px; height: 38px; padding-top: 0px; margin-top: -5px;\"><i class=\"fa fa-user\"></i>");
      out.print(firstName);
      out.write("</button></a>\n");
      out.write("                                    <ul>\n");
      out.write("                                        <li><a href=\"ChangePwd.jsp\"><i class=\"fa fa-dropbox\"></i>Change Password</a></li>\n");
      out.write("                                        <li><a href=\"UserLogout.jsp\"><i class=\"fa fa-sign-out\"></i>Logout</a></li>\n");
      out.write("                                    </ul>\n");
      out.write("                                </li>\n");
      out.write("                            </ul>\n");
      out.write("                                \n");
      out.write("                        </div>\n");
      out.write("                        <!--end navigation menus-->\n");
      out.write("                        ");
if(checkDet==true && checkEd==true && checkCrs==true){
      out.write("  \n");
      out.write("                        <div class=\"panel-heading\" style=\"margin-top: 56px;border-top: 1px solid;\">\n");
      out.write("                            <h2 class=\"panel-title\" style=\"font-size: 20px; color: green;\">These are your details</h2>\n");
      out.write("                        </div>\n");
      out.write("                            \n");
      out.write("                        <div class=\"panel-body\">\n");
      out.write("                            <div class=\"container\" style=\"padding-top: 5px;\">\n");
      out.write("                                \n");
      out.write("                                <fieldset>\n");
      out.write("                                    <legend style=\"width: 300px;\">Personal Information</legend>\n");
      out.write("                                </fieldset>\n");
      out.write("                                <table class=\"table table-bordered\" style=\"width: 800px;height: 5px; margin-left: 80px;\">\n");
      out.write("                                    \n");
      out.write("                                    <thead>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <th>First Name</th>\n");
      out.write("                                            <th>Middle Name</th>\n");
      out.write("                                            <th>Last Name</th>\n");
      out.write("                                            <th>Date of Birth</th>\n");
      out.write("                                            <th>Gender</th>\n");
      out.write("                                            <th>Postal Address</th>\n");
      out.write("                                            <th>Mobile</th>\n");
      out.write("                                            <th>Nationality</th>\n");
      out.write("                                            <th>Action</th>\n");
      out.write("                                        </tr>\n");
      out.write("                                    </thead>\n");
      out.write("                                    <tbody>\n");
      out.write("                                        <tr>\n");
      out.write("                                            ");
if(results1.next()){
                                            fName=results1.getString("First_Name");
                                            mName=results1.getString("Middle_Name");
                                            lName=results1.getString("Last_Name");
                                            dob=results1.getString("DoB");
                                            gender=results1.getString("Gender");
                                            address=results1.getString("Postal_Address");
                                            mobile=results1.getString("Mobile");
                                            country=results1.getString("Country");
                                            
      out.write("\n");
      out.write("                                            <td>");
      out.print(fName);
      out.write("</td>\n");
      out.write("                                            <td>");
      out.print(mName);
      out.write("</td> \n");
      out.write("                                            <td>");
      out.print(lName);
      out.write("</td>\n");
      out.write("                                            <td>");
      out.print(dob);
      out.write("</td>\n");
      out.write("                                            <td>");
      out.print(gender);
      out.write("</td>\n");
      out.write("                                            <td>");
      out.print(address);
      out.write("</td>\n");
      out.write("                                            <td>");
      out.print(mobile);
      out.write("</td>\n");
      out.write("                                            <td>");
      out.print(country);
      out.write("</td>\n");
      out.write("                                            <td style=\"width: 68px;\"><a href=\"#personalDetails\" data-toggle=\"modal\" style=\"background-color:#E6E2EB; padding:10px 12px; margin-left: -8px; outline: none;\"><i class=\"fa fa-edit\">Edit</i></a></td>\n");
      out.write("                                            ");
}
      out.write("\n");
      out.write("                                        </tr>\n");
      out.write("                                    </tbody>\n");
      out.write("                                </table>\n");
      out.write("                                \n");
      out.write("                                        <fieldset>\n");
      out.write("                                            <legend style=\"width: 300px;\">Academic Qualifications</legend>\n");
      out.write("                                        </fieldset>\n");
      out.write("                                        <table class=\"table table-bordered\" style=\"width: 800px;height: 5px; margin-left: 80px;\">\n");
      out.write("                                    \n");
      out.write("                                            <thead>\n");
      out.write("                                                <tr>\n");
      out.write("                                                    <th>Physics Grade</th>\n");
      out.write("                                                    <th>Maths Grade</th>\n");
      out.write("                                                    <th>Group II/Group III Grade</th>\n");
      out.write("                                                    <th>Group II/Group III/Group IV/Group V Grade</th>\n");
      out.write("                                                    <th>Mean Grade</th>\n");
      out.write("                                                    <th>Aggregate Points</th>\n");
      out.write("                                                    <th>Cluster Points</th>\n");
      out.write("                                                    <th>Action</th>\n");
      out.write("                                                </tr>\n");
      out.write("                                            </thead>\n");
      out.write("                                            <tbody>\n");
      out.write("                                                <tr>\n");
      out.write("                                                    ");
if(results2.next()){
                                                        physicsGrade=results2.getString("Physics_Grade");
                                                        mathsGrade=results2.getString("Maths_Grade");
                                                        subj3Grade=results2.getString("Subject3_Grade");
                                                        subj4Grade=results2.getString("Subject4_Grade");
                                                        meanGrade=results2.getString("Mean_Grade");
                                                        aggregatePoints=results2.getString("Aggregate_Points");
                                                        clusterPoints=results2.getString("Cluster_Points");
                                                        
      out.write("\n");
      out.write("                                                        <td>");
      out.print(physicsGrade);
      out.write("</td>\n");
      out.write("                                                        <td>");
      out.print(mathsGrade);
      out.write("</td>\n");
      out.write("                                                        <td>");
      out.print(subj3Grade);
      out.write("</td>\n");
      out.write("                                                        <td>");
      out.print(subj4Grade);
      out.write("</td>\n");
      out.write("                                                        <td>");
      out.print(meanGrade);
      out.write("</td>\n");
      out.write("                                                        <td>");
      out.print(aggregatePoints);
      out.write("</td>\n");
      out.write("                                                        <td>");
      out.print(clusterPoints);
      out.write("</td>\n");
      out.write("                                                        <td style=\"width: 68px;\"><a href=\"#academicQualifications\" data-toggle=\"modal\" style=\"background-color:#E6E2EB; padding:10px 12px; margin-left: -8px; outline: none;\"><i class=\"fa fa-edit\">Edit</i></a></td>\n");
      out.write("                                                        ");
}
      out.write("\n");
      out.write("                                                </tr>\n");
      out.write("                                            </tbody>\n");
      out.write("                                        </table>\n");
      out.write("                                            \n");
      out.write("                                        <fieldset>\n");
      out.write("                                            <legend style=\"width: 300px;\">Course Details</legend>\n");
      out.write("                                        </fieldset>\n");
      out.write("                                        <table class=\"table table-bordered\" style=\"width: 800px;height: 5px; margin-left: 80px;\">\n");
      out.write("                                            \n");
      out.write("                                            <thead>\n");
      out.write("                                                <tr>\n");
      out.write("                                                    <th>Programme Level</th>\n");
      out.write("                                                    <th>Programme Name</th>\n");
      out.write("                                                    <th>Mode of Study</th>\n");
      out.write("                                                    <th>Campus/Study Center</th>\n");
      out.write("                                                    <th>Action</th>\n");
      out.write("                                                </tr>\n");
      out.write("                                            </thead>\n");
      out.write("                                            <tbody>\n");
      out.write("                                                ");

                                                    int i=0;
                                                    int j=0;
                                                    int check=1;
                                                    while(results3.next()){
                                                        int li=results3.getInt("Level_id");
                                                        int ci=results3.getInt("Course_id");
                                                        String mo=results3.getString("Mode_Of_Study");
                                                        String ca=results3.getString("Campus");
                                                        ResultSet results4=user.getLevelName(li);
                                                        ResultSet results5=user.getCourseName(ci);
                                                        
      out.write("\n");
      out.write("                                                        <tr>\n");
      out.write("                                                            ");
 if(results4.next()){
                                                                levelNames[i]=results4.getString("Level_Name");
                                                                
      out.write("\n");
      out.write("                                                                <td>");
      out.print(results4.getString("Level_Name"));
      out.write("</td>\n");
      out.write("                                                                ");
} if(results5.next()){
                                                                    courseNames[j]=results5.getString("Course_Name");
                                                                    
      out.write("\n");
      out.write("                                                                    <td>");
      out.print(results5.getString("Course_Name"));
      out.write("</td>\n");
      out.write("                                                                    ");
}
      out.write("\n");
      out.write("                                                                    <td>");
      out.print(results3.getString("Mode_Of_Study"));
      out.write("</td>\n");
      out.write("                                                                    <td>");
      out.print(results3.getString("Campus"));
      out.write("</td>\n");
      out.write("                                                                    <td style=\"width: 68px;\"><a href=\"#courseDetails");
      out.print(check);
      out.write("\" data-toggle=\"modal\" style=\"background-color:#E6E2EB; padding:10px 12px; margin-left: -8px; outline: none;\"><i class=\"fa fa-edit\">Edit</i></a></td>\n");
      out.write("                                                        </tr>\n");
      out.write("                                            <div class=\"modal fade\" id=\"courseDetails");
      out.print(check);
      out.write("\" role=\"dialog\">\n");
      out.write("                                                <div class=\"modal-dialog\">\n");
      out.write("                                                    <div class=\"modal-content\">\n");
      out.write("                                                        <div class=\"modal-header\">\n");
      out.write("                                                            <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>\n");
      out.write("                                                            <h4 class=\"modal-title\" >Edit Course Details</h4>\n");
      out.write("                                                        </div>\n");
      out.write("                                                        <div class=\"modal-body\">\n");
      out.write("                                                            <form method=\"post\" action=\"\">\n");
      out.write("                                                                \n");
      out.write("                                                                <div class=\"form-group\">\n");
      out.write("                                                                    <label for=\"programmeLevel\">Programme Level</label>\n");
      out.write("                                                                    <select id=\"programmeLevel\" name=\"programmeLevel\" class=\"form-control\">\n");
      out.write("                                                                        <option value=\"");
      out.print(results4.getString("Level_Name"));
      out.write("\" selected>");
      out.print(results4.getString("Level_Name"));
      out.write("</option> \n");
      out.write("                                                                        ");
ResultSet results13=user.getLevels();
                                                                while(results13.next()){
      out.write("\n");
      out.write("                                                                        <option value=\"");
      out.print(results13.getString("Level_Name"));
      out.write('"');
      out.write('>');
      out.print(results13.getString("Level_Name"));
      out.write("</option>\n");
      out.write("                                                                        ");
}
      out.write("\n");
      out.write("                                                                    </select>\n");
      out.write("                                                                </div>\n");
      out.write("                                                                <div class=\"form-group\">\n");
      out.write("                                                                    <label for=\"programmeName\">Programme Name</label>\n");
      out.write("                                                                    <select id=\"programmeName\" name=\"programmeName\" class=\"form-control\">\n");
      out.write("                                                                        <option value=\"");
      out.print(results5.getString("Course_id"));
      out.write("\" selected>");
      out.print(results5.getString("Course_Name"));
      out.write("</option> \n");
      out.write("                                                                        ");
ResultSet results12=user.getCourses(3);
                                                                        while(results12.next()){
      out.write("\n");
      out.write("                                                                        <option value=\"");
      out.print(results12.getString("course_Name"));
      out.write('"');
      out.write('>');
      out.print(results12.getString("course_Name"));
      out.write("</option>\n");
      out.write("                                                                        ");
}
      out.write("\n");
      out.write("                                                                    </select>\n");
      out.write("                                                                        \n");
      out.write("                                                                </div>\n");
      out.write("                                                                <div class=\"form-group\">\n");
      out.write("                                                                    <label for=\"modeOfStudy\">Mode of Study</label>\n");
      out.write("                                                                    <select id=\"modeOfStudy\" name=\"modeOfStudy\" class=\"form-control\">\n");
      out.write("                                                                        <option value=\"");
      out.print(results3.getString("Mode_Of_Study"));
      out.write("\" selected>");
      out.print(results3.getString("Mode_Of_Study"));
      out.write("</option> \n");
      out.write("                                                                        <option value=\"Full Time\">Full Time</option>\n");
      out.write("                                                                        <option value=\"Part Time\">Part Time</option>\n");
      out.write("                                                                        <option value=\"Evening Classes\">Evening Classes</option>\n");
      out.write("                                                                        <option value=\"Weekend Classes\">Weekend Classes</option>\n");
      out.write("                                                                    </select>\n");
      out.write("                                                                </div>\n");
      out.write("                                                                <div class=\"form-group\">\n");
      out.write("                                                                    <label for=\"campus\">Campus/Study Center</label>\n");
      out.write("                                                                    <select id=\"campus\" name=\"campus\" class=\"form-control\">\n");
      out.write("                                                                        <option value=\"");
      out.print(results3.getString("Campus"));
      out.write("\" selected>");
      out.print(results3.getString("Campus"));
      out.write("</option> \n");
      out.write("                                                                        ");
ResultSet results14=user.getCampuses();
                                                                            while(results14.next()){
      out.write("\n");
      out.write("                                                                        <option value=\"");
      out.print(results14.getString("Campus_Name"));
      out.write('"');
      out.write('>');
      out.print(results14.getString("Campus_Name"));
      out.write("</option>\n");
      out.write("                                                                        ");
}
      out.write("\n");
      out.write("                                                                    </select>\n");
      out.write("                                                                </div>                           \n");
      out.write("                                                                <div class=\"well modal-footer\">\n");
      out.write("                                                                    <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Close</button>\n");
      out.write("                                                                    <input type=\"submit\" class=\"btn btn-primary\" name=\"save3");
      out.print(check);
      out.write("\" value=\"Save changes\" />\n");
      out.write("                                                                </div>\n");
      out.write("                                                            </form>   \n");
      out.write("                                                    </div>      \n");
      out.write("                                                </div><!-- /.modal-content -->\n");
      out.write("                                            </div><!-- /.modal-dialog -->\n");
      out.write("                                        </div><!-- /.modal -->\n");
      out.write("                                        ");

                                        int levelId=0;
                                        int courseId=0;
                                        if(request.getParameter("save3"+check)!=null){              
                                            String level=request.getParameter("programmeLevel");
                                            String name=request.getParameter("programmeName");
                                            String mos =request.getParameter("modeOfStudy");
                                            String campus=request.getParameter("campus");
                                            ResultSet rs=user.getLevelId(level);
                                            if(rs.next()){
                                                levelId=rs.getInt("Level_id");
                                            } 
                                            
                                            ResultSet rs1=user.getCourseId(name);
                                            if(rs1.next()){
                                                courseId=rs1.getInt("Course_id");
                                            } 
               
                                            int resultsE2=user.editCourseDetails(levelId, courseId, mos, campus, applicantId, li, ci,mo,ca); 
                                        }
                                        
                                        i++;
                                        j++;
                                        check++;
                                        }
      out.write("\n");
      out.write("                                        </tbody>\n");
      out.write("                                        </table>     \n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                                        \n");
      out.write("                                        \n");
      out.write("                                        \n");
      out.write("                                        \n");
      out.write("                                        ");
}
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        \n");
      out.write("        <div class=\"modal fade\" id=\"ApplicationStatus\" role=\"dialog\">\n");
      out.write("                <div class=\"modal-dialog\">\n");
      out.write("                    <div class=\"modal-content\">\n");
      out.write("                        <div class=\"modal-header\">\n");
      out.write("                            <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>\n");
      out.write("                                        <h4 class=\"modal-title\">Application Status</h4>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"modal-body\">\n");
      out.write("                                        <p>You successfully secured a placement in bachelor of science in computer science\n");
      out.write("                                        </p>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"modal-footer\">\n");
      out.write("                                        <button type=\"button\" class=\"btn btn-danger\" data-dismiss=\"modal\">close</button>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div> \n");
      out.write("        \n");
      out.write("        <script type=\"text/javascript\" src=\"mycss/modal/jquery.minCust.js\"></script>\n");
      out.write("            <script type=\"text/javascript\" src=\"mycss/modal/bootstrapJsCust.js\"></script>\n");
      out.write("            <script type=\"text/javascript\" src=\"mycss/validation/jquery.js\"></script>\n");
      out.write("            <script type=\"text/javascript\" src=\"mycss/validation/jquery.validate.js\"></script>\n");
      out.write("            <script type=\"text/javascript\" src=\"mycss/validation/additional-methods.js\"></script>\n");
      out.write("            <script src=\"mycss/validation/custom.js\"></script>\n");
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
