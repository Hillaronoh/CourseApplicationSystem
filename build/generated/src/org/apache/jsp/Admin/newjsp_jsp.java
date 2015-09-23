package org.apache.jsp.Admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import myproject.*;

public final class newjsp_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Hello World!</h1>\n");
      out.write("        ");

          
       
            
            Applicant ad=new Applicant();
            Admin ad2=new Admin();
            ad2.sendMails("hillarykipngetich@student.mmust.ac.ke"); 
            //ResultSet crs=ad2.getCourseDetails(applicantId);
            ResultSet crs=ad2.try1();
            
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
                            String mails=new String();
            while(crs.next()){ 
                            li=crs.getInt("Level_id");
                            ci=crs.getInt("Course_id");
                            String email=crs.getString("Email_Address");
                           
                            if(li==3&&ci==1){
                                ResultSet getrank=ad.getDegCsRank(email);
                                
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=ad.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                       mails+=email+","; 
                                       }else{
                                      crn=ad.getCourseName(ci);
                                      crn.next();
                                      ln=ad.getLevelName(li);
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
                                ResultSet getrank=ad.getDegItRank(email);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=ad.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                       mails+=email+",";
                                      crn=ad.getCourseName(compare.getInt("Course_id"));
                                      crn.next(); 
                                      ln=ad.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=ad.getCourseName(ci);
                                      crn.next();
                                      ln=ad.getLevelName(li);
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
                                ResultSet getrank=ad.getDegInfoRank(email);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=ad.compareRank(li, ci, rank); 
                                   if(compare.next()){
                                       mails+=email+",";
                                      crn=ad.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=ad.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=ad.getCourseName(ci);
                                      crn.next();
                                      ln=ad.getLevelName(li);
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
                                ResultSet getrank=ad.getDegCfRank(email);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=ad.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                       mails+=email+",";
                                      crn=ad.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=ad.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                 }else{
                                      crn=ad.getCourseName(ci);
                                      crn.next();
                                      ln=ad.getLevelName(li);
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
                                ResultSet getrank=ad.getDipCsRank(email);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=ad.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                       mails+=email+",";
                                      crn=ad.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=ad.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                 }else{
                                      crn=ad.getCourseName(ci);
                                      crn.next();
                                      ln=ad.getLevelName(li);
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
                                ResultSet getrank=ad.getDipItRank(email);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=ad.compareRank(li, ci, rank); 
                                   if(compare.next()){
                                       mails+=email+",";
                                      crn=ad.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=ad.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=ad.getCourseName(ci);
                                      crn.next();
                                      ln=ad.getLevelName(li);
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
                                ResultSet getrank=ad.getDipInfoRank(email);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=ad.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                       mails+=email+",";
                                      crn=ad.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=ad.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=ad.getCourseName(ci);
                                      crn.next();
                                      ln=ad.getLevelName(li);
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
                                ResultSet getrank=ad.getDipCfRank(email);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=ad.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                       mails+=email+",";
                                      crn=ad.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=ad.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=ad.getCourseName(ci);
                                      crn.next();
                                      ln=ad.getLevelName(li);
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
                                ResultSet getrank=ad.getCertItRank(email);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=ad.compareRank(li, ci, rank); 
                                   if(compare.next()){
                                       mails+=email+",";
                                      crn=ad.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=ad.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=ad.getCourseName(ci);
                                      crn.next();
                                      ln=ad.getLevelName(li);
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
                                ResultSet getrank=ad.getCertCfRank(email);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=ad.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                       mails+=email+",";
                                      crn=ad.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=ad.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=ad.getCourseName(ci);
                                      crn.next();
                                      ln=ad.getLevelName(li);
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
                                ResultSet getrank=ad.getCertIsRank(email);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=ad.compareRank(li, ci, rank); 
                                   if(compare.next()){
                                       mails+=email+",";
                                      crn=ad.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=ad.getLevelName(compare.getInt("Level_id")); 
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=ad.getCourseName(ci);
                                      crn.next();
                                      ln=ad.getLevelName(li);
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
                                ResultSet getrank=ad.getCertHmRank(email);
                                if(getrank.next()){
                                   rank=getrank.getInt("Rank");
                                   ResultSet compare=ad.compareRank(li, ci, rank); 
                                   if(compare.next()){ 
                                       mails+=email+",";
                                      crn=ad.getCourseName(compare.getInt("Course_id"));
                                      crn.next();
                                      ln=ad.getLevelName(compare.getInt("Level_id"));
                                      ln.next();
                                      levels[i]=ln.getString("Level_Name");
                                      names[i]=crn.getString("Course_Name");
                                      status[i]="Application Successful";
                                      comments[i]="Congratulation! Download a confirmation slip sent to your email.";
                                  }else{
                                      crn=ad.getCourseName(ci);
                                      crn.next();
                                      ln=ad.getLevelName(li);
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
            ad2.sendMails(mails);
        
      out.write("\n");
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
