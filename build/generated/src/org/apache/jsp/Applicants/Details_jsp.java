package org.apache.jsp.Applicants;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class Details_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


        public class Applicant{
            Connection conn=null;
            PreparedStatement pst=null;
            PreparedStatement pst1=null;
            PreparedStatement pst2=null;
            PreparedStatement pst3=null;
            PreparedStatement pst4=null;
            PreparedStatement pst5=null;
            String db="jdbc:mysql:///project1c";
            String username="root";
            String password="";
            
            public Applicant(){
                try{
                   conn=DriverManager.getConnection(db,username,password);
                   pst=conn.prepareStatement("SELECT First_Name FROM registration WHERE Email_Address=? AND Role_id=?");
                   pst1=conn.prepareStatement("SELECT * FROM applicants_details WHERE Email_Address=?");
                   pst2=conn.prepareStatement("SELECT * FROM education_background WHERE Email_Address=?");
                   pst3=conn.prepareStatement("SELECT * FROM course_details WHERE Email_Address=?");
                   pst4=conn.prepareStatement("SELECT Level_Name FROM course_levels WHERE Level_id=?");
                   pst5=conn.prepareStatement("SELECT Course_Name FROM courses WHERE Course_id=?");
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
            
            public ResultSet getPersonalDetails(String email){
                ResultSet rs=null;
                try{
                  pst1.setString(1, email);
                  rs=pst1.executeQuery();
                }
                catch(SQLException e){
                    e.printStackTrace();
                }
                return rs;
            }
            
            public ResultSet getEducationBackground(String email){
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
            
            public ResultSet getCourseDetails(String email){
                ResultSet rs=null;
                try{
                  pst3.setString(1, email);
                  rs=pst3.executeQuery();
                }
                catch(SQLException e){
                    e.printStackTrace();
                }
                return rs;
            }
            
            public ResultSet getLevelName(int levelId){
                ResultSet rs=null;
                try{
                  pst4.setInt(1, levelId);
                  rs=pst4.executeQuery();
                }
                catch(SQLException e){
                    e.printStackTrace();
                }
                return rs;
            }
            
            public ResultSet getCourseName(int courseId){
                ResultSet rs=null;
                try{
                  pst5.setInt(1, courseId);
                  rs=pst5.executeQuery();
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
Class.forName("com.mysql.jdbc.Driver");
      out.write("\n");
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
                     
           ResultSet results=user.getApplicant(applicantId); 
           
           if(results.next()){
               firstName=results.getString("First_Name");
           }
           
           ResultSet results1=user.getPersonalDetails("rok@gmail.com");
           ResultSet results2=user.getEducationBackground("rok@gmail.com");
           ResultSet results3=user.getCourseDetails("rok@gmail.com");
           
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
           
           String []levelNames=null; 
           
      out.write("\n");
      out.write("        \n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Header.jsp", out, false);
      out.write("\n");
      out.write("        <div class=\"container\">\n");
      out.write("            \n");
      out.write("            <div class=\"row1\" style=\"margin-top: 0px;\">\n");
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
      out.write("                                <li><a href=\"#\"><button class=\"btn btn-info\" style=\"width: 148px; height: 38px; padding-top: 0px; margin-top: -5px; background-color: #428BCA;\"><i class=\"fa fa-archive\"></i>My Details</button></a>     \n");
      out.write("                                </li>\n");
      out.write("                            </ul>\n");
      out.write("                            <ul>\n");
      out.write("                                <li><a href=\"Messaging.jsp\"><button class=\"btn btn-info\" style=\"width: 148px; height: 38px; padding-top: 0px; margin-top: -5px;\"><i class=\"fa fa-inbox\"></i>Inquiries</button></a>\n");
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
      out.write("                        <div class=\"panel-heading\" style=\"margin-top: 56px;border-top: 1px solid;\">\n");
      out.write("                            <h2 class=\"panel-title\" style=\"font-size: 20px; color: green;\">These are your details</h2>\n");
      out.write("                        </div>\n");
      out.write("                        \n");
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
      out.write("                                <fieldset>\n");
      out.write("                                    <legend style=\"width: 300px;\">Academic Qualifications</legend>\n");
      out.write("                                </fieldset>\n");
      out.write("                                <table class=\"table table-bordered\" style=\"width: 800px;height: 5px; margin-left: 80px;\">\n");
      out.write("                                    \n");
      out.write("                                    <thead>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <th>Physics Grade</th>\n");
      out.write("                                            <th>Maths Grade</th>\n");
      out.write("                                            <th>Group II/Group III Grade</th>\n");
      out.write("                                            <th>Group II/Group III/Group IV/Group V Grade</th>\n");
      out.write("                                            <th>Mean Grade</th>\n");
      out.write("                                            <th>Aggregate Points</th>\n");
      out.write("                                            <th>Cluster Points</th>\n");
      out.write("                                            <th>Action</th>\n");
      out.write("                                        </tr>\n");
      out.write("                                    </thead>\n");
      out.write("                                    <tbody>\n");
      out.write("                                        <tr>\n");
      out.write("                                            ");
if(results2.next()){
                                            physicsGrade=results2.getString("Physics_Grade");
                                            mathsGrade=results2.getString("Maths_Grade");
                                            subj3Grade=results2.getString("Subject3_Grade");
                                            subj4Grade=results2.getString("Subject4_Grade");
                                            meanGrade=results2.getString("Mean_Grade");
                                            aggregatePoints=results2.getString("Aggregate_Points");
                                            clusterPoints=results2.getString("Cluster_Points");
                                            
      out.write("\n");
      out.write("                                            <td>");
      out.print(physicsGrade);
      out.write("</td>\n");
      out.write("                                            <td>");
      out.print(mathsGrade);
      out.write("</td>\n");
      out.write("                                            <td>");
      out.print(subj3Grade);
      out.write("</td>\n");
      out.write("                                            <td>");
      out.print(subj4Grade);
      out.write("</td>\n");
      out.write("                                            <td>");
      out.print(meanGrade);
      out.write("</td>\n");
      out.write("                                            <td>");
      out.print(aggregatePoints);
      out.write("</td>\n");
      out.write("                                            <td>");
      out.print(clusterPoints);
      out.write("</td>\n");
      out.write("                                            <td style=\"width: 68px;\"><a href=\"#academicQualifications\" data-toggle=\"modal\" style=\"background-color:#E6E2EB; padding:10px 12px; margin-left: -8px; outline: none;\"><i class=\"fa fa-edit\">Edit</i></a></td>\n");
      out.write("                                            ");
}
      out.write("\n");
      out.write("                                        </tr>\n");
      out.write("                                    </tbody>\n");
      out.write("                                </table>\n");
      out.write("                                \n");
      out.write("                                <fieldset>\n");
      out.write("                                    <legend style=\"width: 300px;\">Course Details</legend>\n");
      out.write("                                </fieldset>\n");
      out.write("                                <table class=\"table table-bordered\" style=\"width: 800px;height: 5px; margin-left: 80px;\">\n");
      out.write("                                    \n");
      out.write("                                    <thead>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <th>Programme Level</th>\n");
      out.write("                                            <th>Programme Name</th>\n");
      out.write("                                            <th>Mode of Study</th>\n");
      out.write("                                            <th>Campus/Study Center</th>\n");
      out.write("                                            <th>Action</th>\n");
      out.write("                                        </tr>\n");
      out.write("                                    </thead>\n");
      out.write("                                    <tbody>\n");
      out.write("                                        ");
while(results3.next()){int i=0;
                                        ResultSet results4=user.getLevelName(results3.getInt("Level_id"));
                                        ResultSet results5=user.getCourseName(results3.getInt("Course_id"));
                                        
      out.write("\n");
      out.write("                                        <tr>\n");
      out.write("                                           ");
 if(results4.next()){
                                               levelNames[i]=results4.getString("Level_Name");
                                           
      out.write("\n");
      out.write("                                            <td>");
      out.print(results4.getString("Level_Name"));
      out.write("</td>\n");
      out.write("                                            ");
} if(results5.next()){
      out.write("\n");
      out.write("                                            <td>");
      out.print(results5.getString("Course_Name"));
      out.write("</td>\n");
      out.write("                                            ");
}
      out.write("\n");
      out.write("                                            <td>");
      out.print(results3.getString("Mode_Of_Study"));
      out.write("</td>\n");
      out.write("                                            <td>");
      out.print(results3.getString("Campus"));
      out.write("</td>\n");
      out.write("                                            <td style=\"width: 68px;\"><a href=\"#courseDetails\" data-toggle=\"modal\" style=\"background-color:#E6E2EB; padding:10px 12px; margin-left: -8px; outline: none;\"><i class=\"fa fa-edit\">Edit</i></a></td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        ");
i++;}
      out.write("\n");
      out.write("                                    </tbody>\n");
      out.write("                                </table>\n");
      out.write("                                \n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        \n");
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
      out.write("        </div> \n");
      out.write("        \n");
      out.write("        <div class=\"modal fade\" id=\"personalDetails\" role=\"dialog\">\n");
      out.write("            <div class=\"modal-dialog\">\n");
      out.write("                <div class=\"modal-content\">\n");
      out.write("                    <div class=\"modal-header\">\n");
      out.write("                        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>\n");
      out.write("                        <h4 class=\"modal-title\" >Edit Personal Details</h4>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"modal-body\">\n");
      out.write("                        \n");
      out.write("                        <form method=\"post\" action=\"\">\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"firstName\">First Name</label>\n");
      out.write("                                <input type=\"text\" class=\"form-control\" id=\"firstName\" placeholder=\"First Name\" name=\"firstName\" value=\"");
      out.print(fName);
      out.write("\" readonly>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"middleName\">Middle Name</label>\n");
      out.write("                                <input type=\"text\" class=\"form-control\" id=\"middleName\" placeholder=\"Middle Name\" name=\"middleName\" value=\"");
      out.print(mName);
      out.write("\" readonly>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"lastName\">Last Name</label>\n");
      out.write("                                <input type=\"text\" class=\"form-control\" id=\"lastName\" placeholder=\"Last Name\" name=\"lastName\" value=\"");
      out.print(lName);
      out.write("\" readonly>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"dob\">Date Of Birth</label>\n");
      out.write("                                <input type=\"text\" class=\"form-control\" id=\"dob\" placeholder=\"Date of Birth\" name=\"dob\" value=\"");
      out.print(dob);
      out.write("\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"gender\">Gender</label>\n");
      out.write("                                <input type=\"text\" class=\"form-control\" id=\"gender\" placeholder=\"Gender\" name=\"gender\" value=\"");
      out.print(gender);
      out.write("\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"gender\">Postal Address</label>\n");
      out.write("                                <input type=\"text\" class=\"form-control\" id=\"address\" placeholder=\"Postal Address\" name=\"address\" value=\"");
      out.print(address);
      out.write("\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"gender\">Mobile</label>\n");
      out.write("                                <input type=\"text\" class=\"form-control\" id=\"mobile\" placeholder=\"Mobile\" name=\"mobile\" value=\"");
      out.print(mobile);
      out.write("\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"country\">Nationality</label>\n");
      out.write("                                <input type=\"text\" class=\"form-control\" id=\"country\" placeholder=\"Nationality\" name=\"country\" value=\"");
      out.print(country);
      out.write("\">\n");
      out.write("                            </div>\n");
      out.write("                            \n");
      out.write("                            <div class=\"well modal-footer\">\n");
      out.write("                                <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Close</button>\n");
      out.write("                                <input type=\"submit\" class=\"btn btn-primary\" name=\"save\" value=\"Save changes\" />\n");
      out.write("                            </div>\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("                    \n");
      out.write("                </div><!-- /.modal-content -->\n");
      out.write("            </div><!-- /.modal-dialog -->\n");
      out.write("        </div><!-- /.modal -->\n");
      out.write("        \n");
      out.write("        <div class=\"modal fade\" id=\"academicQualifications\" role=\"dialog\">\n");
      out.write("            <div class=\"modal-dialog\">\n");
      out.write("                <div class=\"modal-content\">\n");
      out.write("                    <div class=\"modal-header\">\n");
      out.write("                        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>\n");
      out.write("                        <h4 class=\"modal-title\" >Edit Academic Credentials</h4>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"modal-body\">\n");
      out.write("                        \n");
      out.write("                        <form method=\"post\" action=\"\">\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"physicsGrade\">Physics Grade</label>\n");
      out.write("                                <input type=\"text\" class=\"form-control\" id=\"physicsGrade\" placeholder=\"Physics Grade\" name=\"physicsGrade\" value=\"");
      out.print(physicsGrade);
      out.write("\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"mathsGrade\">Maths Grade</label>\n");
      out.write("                                <input type=\"text\" class=\"form-control\" id=\"mathsGrade\" placeholder=\"Maths Grade\" name=\"mathsGrade\" value=\"");
      out.print(mathsGrade);
      out.write("\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"subj3Grade\">Group II/Group III Grade</label>\n");
      out.write("                                <input type=\"text\" class=\"form-control\" id=\"subj3Grade\" placeholder=\"Subject3 Grade\" name=\"subj3Grade\" value=\"");
      out.print(subj3Grade);
      out.write("\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"subj4Grade\">Group II/Group III/Group IV/Group V Grade</label>\n");
      out.write("                                <input type=\"text\" class=\"form-control\" id=\"subj4Grade\" placeholder=\"subject4 Grade\" name=\"subj4Grade\" value=\"");
      out.print(subj4Grade);
      out.write("\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"meanGrade\">Mean Grade</label>\n");
      out.write("                                <input type=\"text\" class=\"form-control\" id=\"meanGrade\" placeholder=\"Mean Grade\" name=\"meanGrade\" value=\"");
      out.print(meanGrade);
      out.write("\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"aggregatePoints\">Aggregate Points</label>\n");
      out.write("                                <input type=\"text\" class=\"form-control\" id=\"aggregatePoints\" placeholder=\"Aggregate Points\" name=\"aggregatePoints\" value=\"");
      out.print(aggregatePoints);
      out.write("\">\n");
      out.write("                            </div>\n");
      out.write("                            \n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"clusterPoints\">Cluster Points</label>\n");
      out.write("                                <input type=\"text\" class=\"form-control\" id=\"clusterPoints\" placeholder=\"Cluster Points\" name=\"clusterPoints\" value=\"");
      out.print(clusterPoints);
      out.write("\" readonly=\"readonly\">\n");
      out.write("                            </div>\n");
      out.write("                            \n");
      out.write("                            <div class=\"well modal-footer\">\n");
      out.write("                                <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Close</button>\n");
      out.write("                                <input type=\"submit\" class=\"btn btn-primary\" name=\"save\" value=\"Save changes\" />\n");
      out.write("                            </div>\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("                    \n");
      out.write("                </div><!-- /.modal-content -->\n");
      out.write("            </div><!-- /.modal-dialog -->\n");
      out.write("        </div><!-- /.modal -->\n");
      out.write("        \n");
      out.write("        <div class=\"modal fade\" id=\"courseDetails\" role=\"dialog\">\n");
      out.write("            <div class=\"modal-dialog\">\n");
      out.write("                <div class=\"modal-content\">\n");
      out.write("                    <div class=\"modal-header\">\n");
      out.write("                        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>\n");
      out.write("                        <h4 class=\"modal-title\" >Edit Course Details</h4>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"modal-body\">\n");
      out.write("                        \n");
      out.write("                        <form method=\"post\" action=\"\">\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"programmeLevel\">Programme Level</label>\n");
      out.write("                                <input type=\"text\" class=\"form-control\" id=\"programmeLevel\" placeholder=\"Programme Level\" name=\"programmeLevel\" value=\"");
      out.print(levelNames[0]);
      out.write("\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"programmeName\">Programme Name</label>\n");
      out.write("                                <input type=\"text\" class=\"form-control\" id=\"programmeNamee\" placeholder=\"Programme Name\" name=\"programmeName\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"modeOfStudy\">Mode of Study</label>\n");
      out.write("                                <input type=\"text\" class=\"form-control\" id=\"modeOfStudy\" placeholder=\"Mode of Study\" name=\"modeOfStudy\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"campus\">Campus/Study Center</label>\n");
      out.write("                                <input type=\"text\" class=\"form-control\" id=\"campus\" placeholder=\"Campus/Study Center\" name=\"campus\">\n");
      out.write("                            </div>                           \n");
      out.write("                            <div class=\"well modal-footer\">\n");
      out.write("                                <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Close</button>\n");
      out.write("                                <input type=\"submit\" class=\"btn btn-primary\" name=\"save\" value=\"Save changes\" />\n");
      out.write("                            </div>\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("                    \n");
      out.write("                </div><!-- /.modal-content -->\n");
      out.write("            </div><!-- /.modal-dialog -->\n");
      out.write("        </div><!-- /.modal -->\n");
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
