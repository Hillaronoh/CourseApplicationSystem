<%-- 
    Document   : newjsp
    Created on : Sep 4, 2015, 3:01:14 PM
    Author     : hillary
--%>
<%@page import="java.sql.*" %>
<%@page import="myproject.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
          
       
            
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
        %>
    </body>
</html>
