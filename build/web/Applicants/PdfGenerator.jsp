<%-- 
    Document   : PdfGenerator
    Created on : Jun 30, 2015, 11:53:45 AM
    Author     : Kipngetich
--%>

<%@ page trimDirectiveWhitespaces="true" %>
<%@page import="com.itextpdf.text.Document"%>
<%@page import="com.itextpdf.text.Paragraph"%>
<%@page import="com.itextpdf.text.pdf.PdfWriter"%>
<%@page import="java.sql.*" %>
<% Class.forName("com.mysql.jdbc.Driver"); %>
<%@page import="com.itextpdf.text.*"%> 
<%@page import="com.itextpdf.text.BadElementException"%>
<%@page import="com.itextpdf.text.pdf.*"%> 
<%@page import="myproject.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>pdf</title>
    </head>
    <body>
        
      <%
            String applicantId=new String(); 
            if(session.getAttribute("applicantId")==null||(session.getAttribute("applicantId")==""))
            {
                
             response.sendRedirect("../index.jsp"); 

            }
            else
            { 
            applicantId=(String)session.getAttribute("applicantId");          
            }
       
            %>
        
        <%
               PdfPTable table1 = new PdfPTable(8);
               PdfPTable table2 = new PdfPTable(9);
               PdfPTable table3 = new PdfPTable(4);
               PdfPCell c1 = new PdfPCell();
               PdfPCell c2 = new PdfPCell();
               PdfPCell c3 = new PdfPCell();
               
               c1 = new PdfPCell(new Phrase("First Name"));
               c1.setHorizontalAlignment(Element.ALIGN_CENTER);
               table1.addCell(c1);
               
               c1 = new PdfPCell(new Phrase("Middle Name"));
               c1.setHorizontalAlignment(Element.ALIGN_CENTER);
               table1.addCell(c1);
               
               c1 = new PdfPCell(new Phrase("Last Name"));
               c1.setHorizontalAlignment(Element.ALIGN_CENTER);
               table1.addCell(c1);
               
               c1 = new PdfPCell(new Phrase("Date Of Birth"));
               c1.setHorizontalAlignment(Element.ALIGN_CENTER);
               table1.addCell(c1);
               //table1.setHeaderRows(1);

               c1 = new PdfPCell(new Phrase("Gender"));
               c1.setHorizontalAlignment(Element.ALIGN_CENTER);
               table1.addCell(c1);
                             
               c1 = new PdfPCell(new Phrase("Postal Address"));
               c1.setHorizontalAlignment(Element.ALIGN_CENTER);
               table1.addCell(c1);
               //table1.setHeaderRows(1);
               
               c1 = new PdfPCell(new Phrase("Mobile"));
               c1.setHorizontalAlignment(Element.ALIGN_CENTER);
               table1.addCell(c1);
               //table1.setHeaderRows(1);
               
               c1 = new PdfPCell(new Phrase("Country"));
               c1.setHorizontalAlignment(Element.ALIGN_CENTER);
               table1.addCell(c1);
               //table1.setHeaderRows(1);
               
               
               c2 = new PdfPCell(new Phrase("English"));
               c2.setHorizontalAlignment(Element.ALIGN_CENTER);
               table2.addCell(c2);
               
               c2 = new PdfPCell(new Phrase("Kiswahili"));
               c2.setHorizontalAlignment(Element.ALIGN_CENTER);
               table2.addCell(c2);
               
               c2 = new PdfPCell(new Phrase("Maths"));
               c2.setHorizontalAlignment(Element.ALIGN_CENTER);
               table2.addCell(c2);
               
               c2 = new PdfPCell(new Phrase("Physics"));
               c2.setHorizontalAlignment(Element.ALIGN_CENTER);
               table2.addCell(c2);
               //table1.setHeaderRows(1);

               c2 = new PdfPCell(new Phrase("Group II"));
               c2.setHorizontalAlignment(Element.ALIGN_CENTER);
               table2.addCell(c2);
               
               c2 = new PdfPCell(new Phrase("Group III"));
               c2.setHorizontalAlignment(Element.ALIGN_CENTER);
               table2.addCell(c2);
               
               c2 = new PdfPCell(new Phrase("Group IV/ Group V"));
               c2.setHorizontalAlignment(Element.ALIGN_CENTER);
               table2.addCell(c2);
                             
               c2 = new PdfPCell(new Phrase("Aggregate Points"));
               c2.setHorizontalAlignment(Element.ALIGN_CENTER);
               table2.addCell(c2);
               //table1.setHeaderRows(1);
               
               c2 = new PdfPCell(new Phrase("Cluster Points"));
               c2.setHorizontalAlignment(Element.ALIGN_CENTER);
               table2.addCell(c2);
               //table1.setHeaderRows(1);
               
               
               c3 = new PdfPCell(new Phrase("Level"));
               c3.setHorizontalAlignment(Element.ALIGN_CENTER);
               table3.addCell(c3);
               
               c3 = new PdfPCell(new Phrase("Programme"));
               c3.setHorizontalAlignment(Element.ALIGN_CENTER);
               table3.addCell(c3);
               
               c3 = new PdfPCell(new Phrase("Mode of study"));
               c3.setHorizontalAlignment(Element.ALIGN_CENTER);
               table3.addCell(c3);
               
               c3 = new PdfPCell(new Phrase("Campus"));
               c3.setHorizontalAlignment(Element.ALIGN_CENTER);
               table3.addCell(c3);
               //table1.setHeaderRows(1);
               
            response.setContentType("application/pdf");
            Document document = new Document();
            PdfWriter.getInstance(document, response.getOutputStream());
            document.open();
            /*String relativeWebPath = "/image/mmustlogo.png";
            String absoluteDiskPath = getServletContext().getRealPath(relativeWebPath);
            Image image = Image.getInstance(absoluteDiskPath);*/
            
            document.addTitle("Application Form");
            //document.add(image); 
     
            Applicant user=new Applicant(); 
            
            ResultSet rs1=user.getPersonalDetails(applicantId);
            document.add(new Paragraph("A. Personal Details")); 
            if(rs1.next()) { 
            table1.addCell(rs1.getString("First_Name"));
            table1.addCell(rs1.getString("Middle_Name"));
            table1.addCell(rs1.getString("Last_Name"));
            table1.addCell(rs1.getString("DoB"));
            table1.addCell(rs1.getString("Gender"));
            table1.addCell(rs1.getString("Postal_Address"));
            table1.addCell(rs1.getString("Mobile"));
            table1.addCell(rs1.getString("Country"));
            }
            document.add(table1);
            
            ResultSet rs2=user.getEducationBackground(applicantId);
            document.add(new Paragraph("B. Academic Qualification")); 
            if(rs2.next()) { 
            table2.addCell(rs2.getString("Eng_Grade"));
            table2.addCell(rs2.getString("Kisw_Grade"));
            table2.addCell(rs2.getString("Math_Grade"));
            table2.addCell(rs2.getString("Physics_Grade"));
            table2.addCell(rs2.getString("Group2_Grade"));
            table2.addCell(rs2.getString("Group3_Grade"));
            table2.addCell(rs2.getString("Grp4or5_Grade"));
            table2.addCell(rs2.getString("Aggregate_Points"));
            table2.addCell(rs2.getString("Cluster_Points"));
            }
            document.add(table2);
            
            ResultSet rs3=user.getCourseDetails(applicantId);
            document.add(new Paragraph("C. Programme Details")); 
            while(rs3.next()) {
                String ln=new String();
                String cn=new String();
                int li=rs3.getInt("Level_id");
                int ci=rs3.getInt("Course_id");
                ResultSet l=user.getLevelName(li);
                ResultSet c=user.getCourseName(ci);
                if(l.next()){ 
                   ln=l.getString("Level_Name");
                }
                if(c.next()){ 
                   cn=c.getString("Course_Name");
                }
            table3.addCell(ln);
            table3.addCell(cn);
            table3.addCell(rs3.getString("Mode_Of_Study"));
            String campusName=new String();
            int cumpusId=rs3.getInt("Campus");
            ResultSet getCampusName=user.getCampusName(cumpusId);
            if(getCampusName.next()){
              campusName=getCampusName.getString("Campus_Name");
            }
            table3.addCell(campusName);
            }
            document.add(table3);
            
            document.close();
            
        %>

    </body>
</html>
