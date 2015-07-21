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
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>pdf</title>
    </head>
    <body>


        <%!
        public class PdfGenerator{
           Connection conn = null;
           PreparedStatement pst = null;
           String db="jdbc:mysql:///vettingsystem";
           String user = "root";
           String password = "";
           
           public PdfGenerator(){
               try{
               conn = DriverManager.getConnection(db,user,password);
               pst=conn.prepareStatement("select * from applicants_detailsb where Email=?");
               }catch(SQLException e){
                   e.printStackTrace();
               }
              }
           
           public ResultSet getApplicantDetails(String email){ 
               ResultSet rs=null;
               try{
                  pst.setString(1, email);
                  rs=pst.executeQuery();
               }catch(SQLException e){
                   e.printStackTrace();
               }
               return rs; 
           }
        }
        %>
        
        <%
               PdfPTable table1 = new PdfPTable(6); 
               PdfPCell c1 = new PdfPCell();
               
               c1 = new PdfPCell(new Phrase("First Name"));
               c1.setHorizontalAlignment(Element.ALIGN_CENTER);
               table1.addCell(c1);
               
               c1 = new PdfPCell(new Phrase("Last Name"));
               c1.setHorizontalAlignment(Element.ALIGN_CENTER);
               table1.addCell(c1);

               c1 = new PdfPCell(new Phrase("Gender"));
               c1.setHorizontalAlignment(Element.ALIGN_CENTER);
               table1.addCell(c1);

               c1 = new PdfPCell(new Phrase("Date Of Birth"));
               c1.setHorizontalAlignment(Element.ALIGN_CENTER);
               table1.addCell(c1);
               table1.setHeaderRows(1);
               
               c1 = new PdfPCell(new Phrase("Postal Address"));
               c1.setHorizontalAlignment(Element.ALIGN_CENTER);
               table1.addCell(c1);
               table1.setHeaderRows(1);
               
               c1 = new PdfPCell(new Phrase("Country"));
               c1.setHorizontalAlignment(Element.ALIGN_CENTER);
               table1.addCell(c1);
               table1.setHeaderRows(1);

            response.setContentType("application/pdf");
            Document document = new Document();
            PdfWriter.getInstance(document, response.getOutputStream());
            document.open();
            String relativeWebPath = "/image/mmustlogo.png";
            String absoluteDiskPath = getServletContext().getRealPath(relativeWebPath);
            Image image = Image.getInstance(absoluteDiskPath);
            
            document.addTitle("Application Form");
            document.add(image); 
            
            String email="kkkk";
            PdfGenerator pdf=new PdfGenerator();
            ResultSet rs1=pdf.getApplicantDetails(email);
            document.add(new Paragraph("A. Personal Details")); 
            if(rs1.next()) { 
            table1.addCell(rs1.getString("First_Name"));
            table1.addCell(rs1.getString("Last_Name"));
            table1.addCell(rs1.getString("Gender"));
            table1.addCell(rs1.getString("DoB"));
            table1.addCell(rs1.getString("Postal_Address"));
            table1.addCell(rs1.getString("Country"));
            }
            document.add(table1);
            
            document.add(new Paragraph("B. Academic Qualification")); 
            document.add(new Paragraph("C. Programme Details")); 
            document.close();
            
        %>

    </body>
</html>
