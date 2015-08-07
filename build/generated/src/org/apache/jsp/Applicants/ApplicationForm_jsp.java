package org.apache.jsp.Applicants;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.text.DecimalFormat;
import java.sql.*;

public final class ApplicationForm_jsp extends org.apache.jasper.runtime.HttpJspBase
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
                   pst=conn.prepareStatement("SELECT First_Name,Middle_Name,Last_Name FROM registration WHERE Email_Address=? AND Role_id=?");
                   pst1=conn.prepareStatement("INSERT INTO applicants_details VALUES(?,?,?,?,?,?,?,?,?)");
                   pst2=conn.prepareStatement("INSERT INTO education_background VALUES(?,?,?,?,?,?,?,?)");
                }
                catch(SQLException e){
                    e.printStackTrace();
                }
            }
                       
            public ResultSet getApplicantDetails(String email){
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
            
            public int setApplicants(String email, String fName, String mName, String lName, String dob, String gender,String pAddress, String mobile, String country){
                int i=0;
                try{
                pst1.setString(1, email);
                pst1.setString(2, fName);
                pst1.setString(3, mName);
                pst1.setString(4, lName);
                pst1.setString(5, dob);
                pst1.setString(6, gender);
                pst1.setString(7, pAddress);
                pst1.setString(8, mobile);
                pst1.setString(9, country);
                i=pst1.executeUpdate();
                }
                catch(SQLException e){
                    e.printStackTrace();
                }
                return i;
            }
            
            public int setEducationBackground(String email, String physicsGrade, String mathsGrade, String subj3Grade, String subj4Grade, String meanGrade,double aggregatePoints, double clusterPoints){
                int j=0;
                try{
                pst2.setString(1, email);
                pst2.setString(2, physicsGrade);
                pst2.setString(3, mathsGrade);
                pst2.setString(4, subj3Grade);
                pst2.setString(5, subj4Grade);
                pst2.setString(6, meanGrade);
                pst2.setDouble(7, aggregatePoints);
                pst2.setDouble(8, clusterPoints);
                j=pst2.executeUpdate();
                }
                catch(SQLException e){
                    e.printStackTrace();
                }
                return j;
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
      out.write("\n");
      out.write("\n");
Class.forName("com.mysql.jdbc.Driver"); 
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <title>Application Form|mmust</title>\n");
      out.write("        \n");
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
      out.write("    </head>\n");
      out.write("    <body style=\"overflow-x: hidden; background-color: #EFEEEE;\"> \n");
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
           String middleName=new String();
           String lastName=new String();
                      
           ResultSet results=user.getApplicantDetails(applicantId); 
                      
           if(results.next()){
               firstName=results.getString("First_Name");
               middleName=results.getString("Middle_Name");
               lastName=results.getString("Last_Name");
           }
           
      out.write("\n");
      out.write("        \n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Header.jsp", out, false);
      out.write("\n");
      out.write("        \n");
      out.write("        <div class=\"container\">\n");
      out.write("            \n");
      out.write("            <div class=\"row1\" style=\"margin-top: 0px;\">\n");
      out.write("                \n");
      out.write("                <div class=\"col-md-4 col-md-offset-4\" style=\"width: 1082px; margin-left: 43px;\">\n");
      out.write("                    \n");
      out.write("                    <div class=\"login-panel panel panel-default\"> \n");
      out.write("                        <!--start navigation menus-->\n");
      out.write("                        <div id=\"navMenu\" style=\"margin-top: 5px;\">\n");
      out.write("                            <ul>\n");
      out.write("                                <li><a href=\"UserAccount.jsp\"><button class=\"btn btn-info\" style=\"width: 148px; height: 38px; padding-top: 0px; margin-top: -5px;\"><i class=\"fa fa-home\"></i>Home</button></a>\n");
      out.write("                                </li>\n");
      out.write("                            </ul>\n");
      out.write("                            <ul>\n");
      out.write("                                <li><a href=\"#\"><button class=\"btn btn-info\" style=\"width: 148px; height: 38px; padding-top: 0px; margin-top: -5px; background-color: #428BCA;\"><i class=\"fa fa-arrow-down\"></i>Apply Course</button></a>\n");
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
      out.write("                                <li><a href=\"Messaging.jsp\"><button class=\"btn btn-info\" style=\"width: 148px; height: 38px; padding-top: 0px; margin-top: -5px;\"><i class=\"fa fa-inbox\"></i>Inquiries</button></a>\n");
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
      out.write("                        <div class=\"panel-heading\" style=\"margin-top: 56px;border-top: 1px solid;\">\n");
      out.write("                            <h3 class=\"panel-title\">Provide The required Information in the Sections Below.</h3>\n");
      out.write("                        </div>\n");
      out.write("                        \n");
      out.write("                        <div class=\"panel-body\">\n");
      out.write("                            \n");
      out.write("                            <!--start accordion A-->\n");
      out.write("                            <div class=\"main\">\n");
      out.write("                                <div class=\"accordion\">\n");
      out.write("                                    <div class=\"accordion-section\">\n");
      out.write("                                        ");

                                       if(request.getParameter("submit1")!=null){
                                       
                                           String email="rok@gmail.com";
                                           String fName=request.getParameter("fname");
                                           String mName=request.getParameter("mname");
                                           String lName=request.getParameter("lname");
                                           String dob=request.getParameter("dob");
                                           String gender=request.getParameter("gender");
                                           String pAddress=request.getParameter("address");
                                           String mobile=request.getParameter("mobile");
                                           String country=request.getParameter("country");
           
                                           int results2=user.setApplicants(email, fName, mName, lName, dob, gender, pAddress, mobile, country);    
                                       
                                        if(results2>0){
      out.write(" \n");
      out.write("                                        <a class=\"accordion-section-title alert alert-success\" style=\"margin-bottom:0px;\" href=\"#accordion-1\"><i class=\"fa fa-check-circle\"></i>Your Personal Details has been saved successfully..Proceed to the next section.</a>\n");
      out.write("                                        ");
}
                                        else{
      out.write("\n");
      out.write("                                        <a class=\"accordion-section-title alert alert-error\" style=\"margin-bottom:0px;\" href=\"#accordion-1\"><i class=\"fa fa-exclamation-triangle\"></i>There was an error saving your details. Please try again.</a>\n");
      out.write("                                        ");
}} else{
      out.write("\n");
      out.write("                                        <a class=\"accordion-section-title\" href=\"#accordion-1\">SECTION A: Applicant's Personal Details.</a>\n");
      out.write("                                        ");
}
      out.write("\n");
      out.write("                                        <div id=\"accordion-1\" class=\"accordion-section-content\"> \n");
      out.write("                                            \n");
      out.write("                                            <form method=\"post\" action=\"\" id=\"myForm1\" onsubmit=\"return validatePersonaldetailsForm1(this)\">\n");
      out.write("                                                <fieldset>\n");
      out.write("                                                    \n");
      out.write("                                                    <div class=\"row\" id=\"firstNameRow\">   \n");
      out.write("                                                        <div class=\"form-group col-sm-3\">\n");
      out.write("                                                            <label for=\"fname\">First Name:<span style=\"color:red\"> *</span></label>\n");
      out.write("                                                            <input type=\"text\" class=\"form-control input\" id=\"fname\" name=\"fname\" value=\"");
      out.print(firstName);
      out.write("\" placeholder=\"First Name\" readonly=\"readonly\"/>\n");
      out.write("                                                        </div>\n");
      out.write("                                                        \n");
      out.write("                                                        <div class=\"form-group col-sm-3\">\n");
      out.write("                                                            <label for=\"mname\">Middle Name:</label>\n");
      out.write("                                                            <input type=\"text\" class=\"form-control input\" id=\"mname\" name=\"mname\" value=\"");
      out.print(middleName);
      out.write("\" placeholder=\"Middle Name\" readonly=\"readonly\"/>\n");
      out.write("                                                        </div>\n");
      out.write("                                                        \n");
      out.write("                                                        <div class=\"form-group col-sm-3\">\n");
      out.write("                                                            <label for=\"fname\">Last Name:<span style=\"color:red\"> *</span></label>\n");
      out.write("                                                            <input type=\"text\" class=\"form-control input\" id=\"lname\" name=\"lname\" value=\"");
      out.print(lastName);
      out.write("\" placeholder=\"Last Name\" readonly=\"readonly\"/>\n");
      out.write("                                                        </div>\n");
      out.write("                                                        \n");
      out.write("                                                        <div class=\"form-group col-sm-3\">\n");
      out.write("                                                            <label for=\"dob\">Date of Birth:<span style=\"color:red\"> *</span></label>\n");
      out.write("                                                            <input type=\"text\" class=\"form-control input\" id=\"dob\" name=\"dob\" placeholder=\"yyyy-mm-dd\"/>\n");
      out.write("                                                        </div>\n");
      out.write("                                                        \n");
      out.write("                                                    </div>\n");
      out.write("                                                    \n");
      out.write("                                                    <div class=\"row\" id=\"dobRow\"> \n");
      out.write("                                                        <div class=\"form-group col-sm-3\">\n");
      out.write("                                                            <label for=\"gender\">Gender:<span style=\"color:red\"> *</span></label>\n");
      out.write("                                                            <select id=\"gender\" name=\"gender\" class=\"form-control input\">\n");
      out.write("                                                                <option value=\"\" selected>I am...</option> \n");
      out.write("                                                                <option value=\"Male\">Male</option>\n");
      out.write("                                                                <option value=\"Female\">Female</option>\n");
      out.write("                                                            </select>\n");
      out.write("                                                        </div>\n");
      out.write("                                                        \n");
      out.write("                                                        <div class=\"form-group col-sm-3\">\n");
      out.write("                                                            <label for=\"address\">Postal Address:<span style=\"color:red\"> *</span></label>\n");
      out.write("                                                            <input type=\"text\" class=\"form-control input\" id=\"address\" name=\"address\" placeholder=\"e.g. P.O Box 48, Chebunyo\"/>\n");
      out.write("                                                        </div>\n");
      out.write("                                                        \n");
      out.write("                                                        <div class=\"form-group col-sm-3\">\n");
      out.write("                                                            <label for=\"mobile\">Mobile:<span style=\"color:red\"> *</span></label>\n");
      out.write("                                                            <input type=\"text\" class=\"form-control input\" id=\"mobile\" name=\"mobile\" placeholder=\"07....\"/>\n");
      out.write("                                                        </div>\n");
      out.write("                                                        \n");
      out.write("                                                        <div class=\"form-group col-sm-3\">\n");
      out.write("                                                            <label for=\"country\">Nationality:<span style=\"color:red\"> *</span></label>\n");
      out.write("                                                            <input type=\"text\" class=\"form-control input\" id=\"country\" name=\"country\" placeholder=\"country of residence\"/>\n");
      out.write("                                                        </div>     \n");
      out.write("                                                    </div>\n");
      out.write("                                                    \n");
      out.write("                                                    <div class=\"row\" id=\"buttons1\">\n");
      out.write("                                                        <div class=\"col-sm-4\"></div>\n");
      out.write("                                                        <div class=\"form-group col-sm-2\">\n");
      out.write("                                                            <button type=\"submit\" name=\"submit1\" class=\"btn btn-success\" style=\"width: 120px;\">Submit</button>\n");
      out.write("                                                        </div>\n");
      out.write("                                                        <div class=\"form-group col-sm-2\">\n");
      out.write("                                                            <button type=\"reset\" name=\"reset\" class=\"btn btn-info pull-right\" style=\"width: 120px;\">Reset</button>\n");
      out.write("                                                        </div>\n");
      out.write("                                                        <div class=\"col-sm-4\"></div>\n");
      out.write("                                                    </div>\n");
      out.write("                                                    \n");
      out.write("                                                    \n");
      out.write("                                                </fieldset>\n");
      out.write("                                            </form>\n");
      out.write("                                        </div><!--end .accordion-section-content-->\n");
      out.write("                                    </div><!--end .accordion-section-->\n");
      out.write("                                </div><!--end .accordion-->\n");
      out.write("                            </div>\n");
      out.write("                            <!--end accordion A-->\n");
      out.write("                            \n");
      out.write("                            <!--start accordion B-->\n");
      out.write("                            <div class=\"main\">\n");
      out.write("                                <div class=\"accordion\">\n");
      out.write("                                    <div class=\"accordion-section\">\n");
      out.write("                                        ");

                                       if(request.getParameter("submit2")!=null){
                                       
                                           String email="rok@gmail.com";
                                           String physicsGrade=request.getParameter("physics");
                                           String mathsGrade=request.getParameter("maths");
                                           String subj3Grade =request.getParameter("subj3");
                                           String subj4Grade=request.getParameter("subj4");
                                           String meanGrade=request.getParameter("meanGrade");
                                           String aggregatePointsString=request.getParameter("aggregatePoints");
                                           double aggregatePointsDouble=Double.parseDouble(aggregatePointsString); 
                                                                                      
                                           double physicsConverted=user.convertGradestoPoints(physicsGrade);
                                           double mathsConverted=user.convertGradestoPoints(mathsGrade);
                                           double subj3Converted=user.convertGradestoPoints(subj3Grade);
                                           double subj4Converted=user.convertGradestoPoints(subj4Grade); 
                                           double clusterPoints=user.calculateClusterPoints(physicsConverted, mathsConverted, subj3Converted, subj4Converted, aggregatePointsDouble);  
                                           
                                           int results3=user.setEducationBackground(email, physicsGrade, mathsGrade, subj3Grade, subj4Grade, meanGrade, aggregatePointsDouble, clusterPoints);
                                           if(results3>0){
                                           
      out.write("\n");
      out.write("                                           <a class=\"accordion-section-title\" href=\"#accordion-2\">SECTION B: Applicant's Education Background.good</a>\n");
      out.write("                                           ");
} else{
      out.write("\n");
      out.write("                                           <a class=\"accordion-section-title\" href=\"#accordion-2\">SECTION B: Applicant's Education Background.bad</a>\n");
      out.write("                                           ");
}} else{
      out.write("\n");
      out.write("                                           <a class=\"accordion-section-title\" href=\"#accordion-2\">SECTION B: Applicant's Education Background.</a>\n");
      out.write("                                           ");
}
      out.write("\n");
      out.write("                                           <div id=\"accordion-2\" class=\"accordion-section-content\">\n");
      out.write("                                            \n");
      out.write("                                               <form role=\"form\" method=\"post\" action=\"\" id=\"myForm2\" onsubmit=\"return validateEducationBackgroundForm1(this)\">\n");
      out.write("                                                   <fieldset>\n");
      out.write("                                                    \n");
      out.write("                                                    <div class=\"row\" id=\"physicsRow\">\n");
      out.write("                                                        <div class=\"form-group col-sm-4\">\n");
      out.write("                                                            <label for=\"physics\">K.C.S.E Physics Grade:<span style=\"color:red\"> *</span></label>\n");
      out.write("                                                            <select id=\"physics\" name=\"physics\" class=\"form-control input\">\n");
      out.write("                                                                <option value=\"\" selected>~select grade~</option> \n");
      out.write("                                                                <option value=\"A\">A</option>\n");
      out.write("                                                                <option value=\"A-\">A-</option>\n");
      out.write("                                                                <option value=\"B+\">B+</option>\n");
      out.write("                                                                <option value=\"B\">B</option>\n");
      out.write("                                                                <option value=\"B-\">B-</option>\n");
      out.write("                                                                <option value=\"C+\">C+</option>\n");
      out.write("                                                                <option value=\"C\">C</option>\n");
      out.write("                                                                <option value=\"C-\">C-</option>\n");
      out.write("                                                                <option value=\"D+\">D+</option>\n");
      out.write("                                                                <option value=\"D\">D</option>\n");
      out.write("                                                                <option value=\"D-\">D-</option>\n");
      out.write("                                                                <option value=\"E\">E</option>\n");
      out.write("                                                            </select>\n");
      out.write("                                                        </div>\n");
      out.write("                                                        \n");
      out.write("                                                        <div class=\"form-group col-sm-4\">\n");
      out.write("                                                            <label for=\"maths\">K.C.S.E Maths Grade:<span style=\"color:red\"> *</span></label>\n");
      out.write("                                                            <select id=\"maths\" name=\"maths\" class=\"form-control input\">\n");
      out.write("                                                                <option value=\"\" selected>~select grade~</option> \n");
      out.write("                                                                <option value=\"A\">A</option>\n");
      out.write("                                                                <option value=\"A-\">A-</option>\n");
      out.write("                                                                <option value=\"B+\">B+</option>\n");
      out.write("                                                                <option value=\"B\">B</option>\n");
      out.write("                                                                <option value=\"B-\">B-</option>\n");
      out.write("                                                                <option value=\"C+\">C+</option>\n");
      out.write("                                                                <option value=\"C\">C</option>\n");
      out.write("                                                                <option value=\"C-\">C-</option>\n");
      out.write("                                                                <option value=\"D+\">D+</option>\n");
      out.write("                                                                <option value=\"D\">D</option>\n");
      out.write("                                                                <option value=\"D-\">D-</option>\n");
      out.write("                                                                <option value=\"E\">E</option>\n");
      out.write("                                                            </select>\n");
      out.write("                                                        </div>\n");
      out.write("                                                        \n");
      out.write("                                                        <div class=\"form-group col-sm-4\">\n");
      out.write("                                                            <label for=\"subj3\">Group II or any Group III Grade:<span style=\"color:red\"> *</span></label>\n");
      out.write("                                                            <select id=\"subj3\" name=\"subj3\" class=\"form-control input\">\n");
      out.write("                                                                <option value=\"\" selected>~select grade~</option> \n");
      out.write("                                                                <option value=\"A\">A</option>\n");
      out.write("                                                                <option value=\"A-\">A-</option>\n");
      out.write("                                                                <option value=\"B+\">B+</option>\n");
      out.write("                                                                <option value=\"B\">B</option>\n");
      out.write("                                                                <option value=\"B-\">B-</option>\n");
      out.write("                                                                <option value=\"C+\">C+</option>\n");
      out.write("                                                                <option value=\"C\">C</option>\n");
      out.write("                                                                <option value=\"C-\">C-</option>\n");
      out.write("                                                                <option value=\"D+\">D+</option>\n");
      out.write("                                                                <option value=\"D\">D</option>\n");
      out.write("                                                                <option value=\"D-\">D-</option>\n");
      out.write("                                                                <option value=\"E\">E</option>\n");
      out.write("                                                            </select>\n");
      out.write("                                                        </div>\n");
      out.write("                                                    </div>\n");
      out.write("                                                    \n");
      out.write("                                                    <div class=\"row\" id=\"subj4Row\">\n");
      out.write("                                                        <div class=\"form-group col-sm-4\">\n");
      out.write("                                                            <label for=\"subj4\">Group II/Group III/Group IV/Group V Grade:<span style=\"color:red\"> *</span></label>\n");
      out.write("                                                            <select id=\"subj4\" name=\"subj4\" class=\"form-control input\">\n");
      out.write("                                                                <option value=\"\" selected>~select grade~</option> \n");
      out.write("                                                                <option value=\"A\">A</option>\n");
      out.write("                                                                <option value=\"A-\">A-</option>\n");
      out.write("                                                                <option value=\"B+\">B+</option>\n");
      out.write("                                                                <option value=\"B\">B</option>\n");
      out.write("                                                                <option value=\"B-\">B-</option>\n");
      out.write("                                                                <option value=\"C+\">C+</option>\n");
      out.write("                                                                <option value=\"C\">C</option>\n");
      out.write("                                                                <option value=\"C-\">C-</option>\n");
      out.write("                                                                <option value=\"D+\">D+</option>\n");
      out.write("                                                                <option value=\"D\">D</option>\n");
      out.write("                                                                <option value=\"D-\">D-</option>\n");
      out.write("                                                                <option value=\"E\">E</option>\n");
      out.write("                                                            </select>\n");
      out.write("                                                        </div>\n");
      out.write("                                                        \n");
      out.write("                                                        <div class=\"form-group col-sm-4\">\n");
      out.write("                                                            <label for=\"meanGrade\">K.C.S.E Mean Grade:<span style=\"color:red\"> *</span></label>\n");
      out.write("                                                            <select id=\"meanGrade\" name=\"meanGrade\" class=\"form-control input\">\n");
      out.write("                                                                <option value=\"\" selected>~select grade~</option> \n");
      out.write("                                                                <option value=\"A\">A</option>\n");
      out.write("                                                                <option value=\"A-\">A-</option>\n");
      out.write("                                                                <option value=\"B+\">B+</option>\n");
      out.write("                                                                <option value=\"B\">B</option>\n");
      out.write("                                                                <option value=\"B-\">B-</option>\n");
      out.write("                                                                <option value=\"C+\">C+</option>\n");
      out.write("                                                                <option value=\"C\">C</option>\n");
      out.write("                                                                <option value=\"C-\">C-</option>\n");
      out.write("                                                                <option value=\"D+\">D+</option>\n");
      out.write("                                                                <option value=\"D\">D</option>\n");
      out.write("                                                                <option value=\"D-\">D-</option>\n");
      out.write("                                                                <option value=\"E\">E</option>\n");
      out.write("                                                            </select>\n");
      out.write("                                                        </div>\n");
      out.write("                                                        \n");
      out.write("                                                        <div class=\"form-group col-sm-4\">\n");
      out.write("                                                            <label for=\"aggregatePoints\">K.C.S.E Aggregate Points:<span style=\"color:red\"> *</span></label>\n");
      out.write("                                                            <input type=\"text\" class=\"form-control input\" id=\"aggregatePoints\" name=\"aggregatePoints\" placeholder=\"Total Aggregate Points\"/>\n");
      out.write("                                                        </div>\n");
      out.write("                                                    </div>\n");
      out.write("                                                    \n");
      out.write("                                                    <div class=\"row\" id=\"buttons2\">\n");
      out.write("                                                        <div class=\"col-sm-4\"></div>\n");
      out.write("                                                        <div class=\"form-group col-sm-2\">\n");
      out.write("                                                            <button type=\"submit\" name=\"submit2\" class=\"btn btn-success\" style=\"width: 120px;\">Submit</button>\n");
      out.write("                                                        </div>\n");
      out.write("                                                        <div class=\"form-group col-sm-2\">\n");
      out.write("                                                            <button type=\"reset\" name=\"reset\" class=\"btn btn-info pull-right\" style=\"width: 120px;\">Reset</button>\n");
      out.write("                                                        </div>\n");
      out.write("                                                        <div class=\"col-sm-4\"></div>\n");
      out.write("                                                    </div>\n");
      out.write("                                                    \n");
      out.write("                                                </fieldset>\n");
      out.write("                                            </form>\n");
      out.write("                                            \n");
      out.write("                                        </div><!--end .accordion-section-content-->\n");
      out.write("                                    </div><!--end .accordion-section-->\n");
      out.write("                                </div><!--end .accordion-->\n");
      out.write("                            </div>\n");
      out.write("                            <!--end accordion B-->\n");
      out.write("                            \n");
      out.write("                            <!--start accordion C-->\n");
      out.write("                            <div class=\"main\">\n");
      out.write("                                <div class=\"accordion\">\n");
      out.write("                                    <div class=\"accordion-section\">\n");
      out.write("                                        <a class=\"accordion-section-title\" href=\"#accordion-3\">SECTION C: Course Application Details.</a>\n");
      out.write("                                        <div id=\"accordion-3\" class=\"accordion-section-content\">\n");
      out.write("                                            \n");
      out.write("                                            <form role=\"form\" method=\"post\" action=\"\" id=\"myForm3\" onsubmit=\"return validateCourseApplicationDetailsForm1(this)\">\n");
      out.write("                                                <fieldset>\n");
      out.write("                                                    \n");
      out.write("                                                    <div class=\"row\" id=\"programmeLevelRow\">\n");
      out.write("                                                        <div class=\"col-sm-2\"></div>\n");
      out.write("                                                        <div class=\"form-group col-sm-4\">\n");
      out.write("                                                            <label for=\"level\">Programme Level:<span style=\"color:red\"> *</span></label>\n");
      out.write("                                                            <select id=\"programmeLevel\" name=\"programmeLevel\" class=\"form-control input\">\n");
      out.write("                                                                <option value=\"\" selected>~select programme level~</option> \n");
      out.write("                                                                <option value=\"Degree\">Degree</option>\n");
      out.write("                                                                <option value=\"Diploma\">Diploma</option>\n");
      out.write("                                                                <option value=\"Certificate\">Certificate</option>\n");
      out.write("                                                            </select>\n");
      out.write("                                                        </div>\n");
      out.write("                                                        \n");
      out.write("                                                        \n");
      out.write("                                                        <div class=\"form-group col-sm-4\">\n");
      out.write("                                                            <label for=\"programmeName\">Programme Name:<span style=\"color:red\"> *</span></label>\n");
      out.write("                                                            <select id=\"programmeName\" name=\"programmeName\" class=\"form-control input\">\n");
      out.write("                                                                <option value=\"\" selected>~select programme name~</option> \n");
      out.write("                                                                <option value=\"Computer Science\">Computer Science</option>\n");
      out.write("                                                                <option value=\"Information Technology\">Information Technology</option>\n");
      out.write("                                                                <option value=\"Computer Studies\">Computer Studies</option>\n");
      out.write("                                                                <option value=\"Computer Forensics\">Computer Forensics</option>\n");
      out.write("                                                            </select>\n");
      out.write("                                                        </div>\n");
      out.write("                                                        <div class=\"col-sm-2\"></div>\n");
      out.write("                                                    </div>\n");
      out.write("                                                    \n");
      out.write("                                                    <div class=\"row\" id=\"modeOfStudyRow\">\n");
      out.write("                                                        <div class=\"col-sm-2\"></div>\n");
      out.write("                                                        <div class=\"form-group col-sm-4\">\n");
      out.write("                                                            <label for=\"modeOfStudy\">Mode of StudyRow:<span style=\"color:red\"> *</span></label>\n");
      out.write("                                                            <select id=\"modeOfStudy\" name=\"modeOfStudy\" class=\"form-control input\">\n");
      out.write("                                                                <option value=\"\" selected>~select mode of study</option> \n");
      out.write("                                                                <option value=\"Full Time\">Full Time</option>\n");
      out.write("                                                                <option value=\"Part Time\">Part Time</option>\n");
      out.write("                                                                <option value=\"Evening\">Evening Classes</option>\n");
      out.write("                                                                <option value=\"Weekend Classes\">Weekend Classes</option>\n");
      out.write("                                                            </select>\n");
      out.write("                                                        </div>\n");
      out.write("                                                        \n");
      out.write("                                                        <div class=\"form-group col-sm-4\">\n");
      out.write("                                                            <label for=\"campus\">Campus/Study Center:<span style=\"color:red\"> *</span></label>\n");
      out.write("                                                            <select id=\"campus\" name=\"campus\" class=\"form-control input\">\n");
      out.write("                                                                <option value=\"\" selected>~select mode of study</option> \n");
      out.write("                                                                <option value=\"Full Time\">Full Time</option>\n");
      out.write("                                                                <option value=\"Part Time\">Part Time</option>\n");
      out.write("                                                                <option value=\"Evening\">Evening Classes</option>\n");
      out.write("                                                                <option value=\"Weekend Classes\">Weekend Classes</option>\n");
      out.write("                                                            </select>\n");
      out.write("                                                        </div>\n");
      out.write("                                                        <div class=\"col-sm-2\"></div>\n");
      out.write("                                                    </div>\n");
      out.write("                                                    \n");
      out.write("                                                    <div class=\"row\" id=\"buttons3\">\n");
      out.write("                                                        <div class=\"col-sm-4\"></div>\n");
      out.write("                                                        <div class=\"form-group col-sm-2\">\n");
      out.write("                                                            <button type=\"submit\" name=\"submit3\" class=\"btn btn-success\" style=\"width: 120px;\">Submit</button>\n");
      out.write("                                                        </div>\n");
      out.write("                                                        <div class=\"form-group col-sm-2\">\n");
      out.write("                                                            <button type=\"reset\" name=\"reset\" class=\"btn btn-info pull-right\" style=\"width: 120px;\">Reset</button>\n");
      out.write("                                                        </div>\n");
      out.write("                                                        <div class=\"col-sm-4\"></div>\n");
      out.write("                                                    </div>\n");
      out.write("                                                    \n");
      out.write("                                                </fieldset>\n");
      out.write("                                            </form>\n");
      out.write("                                            \n");
      out.write("                                        </div><!--end .accordion-section-content-->\n");
      out.write("                                    </div><!--end .accordion-section-->\n");
      out.write("                                </div><!--end .accordion-->\n");
      out.write("                            </div>\n");
      out.write("                            <!--end accordion C-->\n");
      out.write("                            \n");
      out.write("                            <!--start accordion D-->\n");
      out.write("                            <div class=\"main\">\n");
      out.write("                                <div class=\"accordion\">\n");
      out.write("                                    <div class=\"accordion-section\">\n");
      out.write("                                        <a class=\"accordion-section-title\" href=\"#accordion-4\">SECTION D: Print Your Form.</a>\n");
      out.write("                                        <div id=\"accordion-4\" class=\"accordion-section-content\">\n");
      out.write("                                            \n");
      out.write("                                            \n");
      out.write("                                            <a href=\"PdfGenerator.jsp\" class=\"btn btn-success btn-lg\">\n");
      out.write("                                                <span><img src=\"image/printer.png\" alt=\"printer\" style=\"width: 30px; height: 30px;\"></span> Print \n");
      out.write("                                            </a>\n");
      out.write("                                            \n");
      out.write("                                            \n");
      out.write("                                        </div><!--end .accordion-section-content-->\n");
      out.write("                                    </div><!--end .accordion-section-->\n");
      out.write("                                </div><!--end .accordion-->\n");
      out.write("                            </div>\n");
      out.write("                            <!--end accordion D-->\n");
      out.write("                            \n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
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
      out.write("        <!-- Core Scripts - Include with every page -->\n");
      out.write("        <script src=\"assets/plugins/jquery-1.10.2.js\"></script>\n");
      out.write("        <script src=\"assets/plugins/bootstrap/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"assets/plugins/metisMenu/jquery.metisMenu.js\"></script>\n");
      out.write("        <script src=\"mycss/dateValidator.js\"></script> \n");
      out.write("        <script type=\"text/javascript\" src=\"mycss/modal/jquery.minCust.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"mycss/modal/bootstrapJsCust.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"mycss/validation/jquery.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"mycss/validation/jquery.validate.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"mycss/validation/additional-methods.js\"></script>\n");
      out.write("        <script src=\"mycss/validation/custom.js\"></script>\n");
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
