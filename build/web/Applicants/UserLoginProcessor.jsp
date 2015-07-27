<%-- 
    Document   : UserLoginProcessor
    Created on : Jul 25, 2015, 12:46:38 PM
    Author     : hillary
--%>
<%@page import="java.sql.*" %>
<%Class.forName("com.mysql.jdbc.Driver"); %>


        <%if(request.getParameter("login")!=null){%> 
            <%!
    public class Login{ 
      
        Connection conn=null;
        PreparedStatement pst=null;
        int rs=0;
        String db="jdbc:mysql:///project";
        String user="root";
        String password="";
        
        public Login(){ 
           try{
            conn = DriverManager.getConnection(db,user,password); 

            pst = conn.prepareStatement("INSERT INTO del VALUES(?,?)"); 
            
           }catch(SQLException e){
               e.printStackTrace(); 
           }
        }
        public int setUsers(String mail, String pass){
        try{   
        pst.setString(1, mail);
        pst.setString(2, pass);
        rs=pst.executeUpdate(); 
        }catch(SQLException e){
            e.printStackTrace();
        }
        return rs;  
        }
            
        }
    %>
    
    <%
            boolean login_success=false;
              String alert=new String();
    Login login=new Login(); 
  
    String email=request.getParameter("email");
    String pwd=request.getParameter("password"); 
    int results=login.setUsers(email, pwd); 
 
   if(results>0){  
    login_success=true;
   %>
    <%=alert%>
   <%
        }
   else{
       login_success=false;
       
   }}%>
