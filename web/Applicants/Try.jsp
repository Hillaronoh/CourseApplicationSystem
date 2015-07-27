<!--DOCTYPE-->
<%@page import="java.sql.*" %>
<%@page import="java.text.DecimalFormat"%> 
<%Class.forName("com.mysql.jdbc.Driver"); %>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Application Form</title>
<!--start favicon--><link rel="shortcut icon" href="image/favicon.ico"><!--end favicon-->
<!--starts accordion advice-->
<link rel="stylesheet" type="text/css" href="mycss/accordion2/defaults.css">
<link rel="stylesheet" type="text/css" href="mycss/accordion2/demo.css">
<script type="text/javascript" src="mycss/accordion2/jquery.min.js"></script>
<script type="text/javascript" src="mycss/accordion2/accordion.js"></script>
<!--ends accordion advice-->
<!--start datepicker-->
<link rel="stylesheet" type="text/css" media="all" href="datepicker/jsDatePick_ltr.min.css" />
<script type="text/javascript" src="datepicker/jsDatePick.min.1.3.js"></script>
<script type="text/javascript">
	window.onload = function(){
		new JsDatePick({
			useMode:2,
			target:"inputField",
			dateFormat:"%Y-%m-%d"
			/*selectedDate:{				This is an example of what the full configuration offers.
				day:5,						For full documentation about these settings please see the full version of the code.
				month:9,
				year:2006
			},
			yearsRange:[1978,2020],
			limitToToday:false,
			cellColorScheme:"beige",
			dateFormat:"%m-%d-%Y",
			imgPath:"img/",
			weekStartDay:1*/
		});
	};
</script>
<!--end datepicker-->  
<!--start accordions-->
<link rel="stylesheet" href="css/jquery.mobile-1.4.5.min.css">
<script src="js/jquery-1.11.3.min.js"></script>
<script src="js/jquery.mobile-1.4.5.min.js"></script>
<link rel="stylesheet" href="layout/styles/layout.css"> 
<!--start accordions-->
<!-- Core CSS - Include with every page -->
<link href="assets/plugins/bootstrap/bootstrap.css" rel="stylesheet" />
<link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
<link href="assets/plugins/pace/pace-theme-big-counter.css" rel="stylesheet" />
<link href="assets/css/style.css" rel="stylesheet" />
<link href="assets/css/main-style.css" rel="stylesheet" />
<link rel="stylesheet" href="mycss/style2.css" style type="text/css">
<script type="text/javascript" src="mycss/validate.js"></script> 
</head> 
<body style="overflow-x: hidden; background-color: #EFEEEE;">
    <div class="container-fluid">
   <div class="header"> 
      <div class="imagelogo" style="margin-left: 120px; margin-top: 10px;"><img src="image/mmustlogo.png" style="width: 100px; height: 100px;"/></div>
    
    <div class="mmust_title">
        <h1 class="style1">MASINDE MULIRO UNIVERSITY OF SCIENCE AND TECHNOLOGY</h1>
      <h2 class="style2">DEPARTMENT OF COMPUTER SCIENCE </h2>
    </div>
	
  </div>
        <%!
    public class AppDetails{
        PreparedStatement pst=null;
        PreparedStatement pst2=null;
        PreparedStatement pst3=null;
        PreparedStatement pst4=null;
        PreparedStatement pst5=null; 
        PreparedStatement pst6=null;  
        PreparedStatement pst7=null;
        PreparedStatement pst8=null;
        PreparedStatement pst9=null;
        PreparedStatement pst10=null; 
        Connection conn=null;  
        ResultSet rs=null;
        String db="jdbc:mysql:///vettingsystem";
        String user="root";
        String password="";
        
        public AppDetails(){
            try{ 
            conn = DriverManager.getConnection(db,user,password); 

            pst = conn.prepareStatement("insert into applicants_detailsb values(?,?,?,?,?,?,?,?,?)");
            
            pst2=conn.prepareStatement("update qualification2 set PhysicsGrade=?, MathsGrade=?, Subject3Grade=?, Subject4Grade=?, MeanGrade=?, WeightedClusterPoints=? where Email=?");
            
            pst3=conn.prepareStatement("select * from min_cluster_points where minClusterpoints<=?");
            
            pst4=conn.prepareStatement("select WeightedClusterPoints from qualification2 where Email=?");
            
            pst5=conn.prepareStatement("select crs_name from courses where crs_id=?");
            
            pst6=conn.prepareStatement("select Level_name from course_levels where Level_id=?");
            
            pst7=conn.prepareStatement("select * from campuses");
            
            pst8=conn.prepareStatement("insert into course_app_details values (?,?,?,?,?)");  
            
            pst9=conn.prepareStatement("select Level_id from course_levels where Level_name=?");
            
            pst10=conn.prepareStatement("select crs_id from courses where crs_name=?");
            
            }
            catch(SQLException e){ 
                e.printStackTrace();
            }
        }
              
            public int setApplicants(String email, String fname, String mname, String lname, String gender, String dob, String postalAddress, String mobile, String country){
                int i=0; 
                try{
                    pst.setString(1,email);
                    pst.setString(2,fname);
                    pst.setString(3,mname);
                    pst.setString(4,lname);
                    pst.setString(5,gender);
                    pst.setString(6,dob);
                    pst.setString(7,postalAddress);
                    pst.setString(8,mobile);
                    pst.setString(9,country);
                    i=pst.executeUpdate();
                }catch(SQLException e){
                    e.printStackTrace();
                }
                return i; 
            }
            
            public int setQualificationPoints(String subj1, String subj2, String subj3, String subj4, String meanGrade, double aggregatePoints){
                int j=0;
                String kip="rok@yahoo.com";
                try{
                pst2.setString(1,subj1);
                pst2.setString(2,subj2);
                pst2.setString(3,subj3);
                pst2.setString(4,subj4); 
                pst2.setString(5,meanGrade);
                pst2.setDouble(6,aggregatePoints);  
                pst2.setString(7,kip);
                j=pst2.executeUpdate();
                }catch(SQLException e){
                    e.printStackTrace();
                }
                return j;  
            }
            
            public ResultSet setCourseName(int id){
                ResultSet info1=null;
                try{
                pst5.setInt(1, id); 
                info1=pst5.executeQuery();
                }catch(SQLException e){
                    e.printStackTrace();
                }
                return info1; 
            }
            
            public ResultSet setCourseLevel(int id){
                ResultSet info2=null;
                try{
                    pst6.setInt(1, id);
                    info2=pst6.executeQuery();
                }catch(SQLException e){
                    e.printStackTrace();
                }
                return info2; 
            }
            
            public ResultSet setCampuses(){
                ResultSet campus=null; 
                try{
                    campus=pst7.executeQuery();
                }catch(SQLException e){
                    e.printStackTrace();
                }
                return campus; 
            }
            
            public int setCourseAppDetails(String email, int crsLevel, int crsId, String modeOfStudy, String campus){
                int k=0;
                try{
                pst8.setString(1,email);
                pst8.setInt(2,crsLevel);
                pst8.setInt(3,crsId);
                pst8.setString(4,modeOfStudy);
                pst8.setString(5,campus);
                k=pst8.executeUpdate();
                }catch(SQLException e){
                    e.printStackTrace();
                }
                return k;  
            }
            
            public ResultSet getLevelId(String levelName){ 
                ResultSet results=null; 
            try{
                pst9.setString(1, levelName); 
                results=pst9.executeQuery(); 
                }catch(SQLException e){
                    e.printStackTrace();
                }
                return results; 
            }
            
            public ResultSet getCourseId(String courseName){ 
                ResultSet results=null; 
            try{
                pst10.setString(1, courseName);
                results=pst10.executeQuery(); 
                }catch(SQLException e){
                    e.printStackTrace();
                }
                return results; 
            }
            
            public ResultSet selectClusters(double clusterPoints){
                try{
                pst3.setDouble(1, clusterPoints); 
                rs=pst3.executeQuery();
                }catch(SQLException e){
                    e.printStackTrace();
                }
                return rs; 
            }
            
            public ResultSet selectClusterPoints(String email){
                ResultSet rsCluster=null;
                try{
                pst4.setString(1, email);
                rsCluster=pst4.executeQuery();
                }catch(SQLException e){
                    e.printStackTrace();
                }
                return rsCluster;
            }
            
            public double calculateClusterPoints(double subj1, double subj2, double subj3, double subj4, double aggPoints){
                double res1=(subj1+subj2+subj3+subj4);
                double res2=(res1/48); 
                double res3=(aggPoints/84);
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
    
    %>
    
    
    <!--Starts main content --> 
 <div class="row" style="margin-top: 50px;">
     <div class="col-md-4 col-md-offset-4" style="width: 1000px; margin-left: 200px;"> 
     <div class="login-panel panel panel-default">
         
         <div class="panel-heading">
              <h3 class="panel-title" style="text-align: center;">Provide The required Information in the Sections Below.</h3>
         </div>
         
   <div class="panel-body">
  
   <!--Starts collapsible SECTION A--> 
  <div data-role="main" class="ui-content">
    <div data-role="collapsible">
    
    <%if(request.getParameter("submit1")!=null){

    int result1=0; 
    String email="rok@yahoo.com";
    String fname=request.getParameter("fname");
    String mname=request.getParameter("mname");
    String lname=request.getParameter("lname");
    String gender=request.getParameter("gender");
    String dob=request.getParameter("dob");
    String postalAddress=request.getParameter("postalAddress");
    String mobile=request.getParameter("mobNumber");
    String nationality=request.getParameter("country");
    AppDetails appdet1=new AppDetails();
    result1=appdet1.setApplicants(email, fname, mname, lname, gender, dob, postalAddress, mobile, nationality); 
    %>
    
    <%
    if(result1>0){%> 
    <h1 style="color: green;">SECTION A: Applicants Personal Details...Details Saved Successfully, Proceed to the next section!</h1><br>
    <%}else{%>
        <h1 style="color: red;">SECTION A: Applicants Personal Detail...Sorry, Details Not Saved, Try Again!</h1><br>
   <% }
        
    }else{
    %>
        <h1>SECTION A: Applicants Personal Details</h1><br>
        <%}%>
      <form name="registration" method="post" action="Try.jsp" onsubmit="return validateForm(this)">
      <fieldset>
         <table style="width: 600px; height: 50px;">
           <tbody>
                                    <tr>
	<td align="right" valign="top" style="padding-top:10px;">First Name:<span style="color:red"> *</span>&nbsp;&nbsp;&nbsp;&nbsp;</td>
        <td valign="top"><input autocomplete="off" name="fname" id="fname" type="text">
        <span id="fnameError" style="color: #ff6699;"> </span>
        </td>
	<td valign="top"></td>
</tr>
              <tr>
	       <td align="right" valign="top" style="padding-top:10px;">Middle Name:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
	       <td valign="top"><input autocomplete="off" name="mname" id="mname" type="text">
                <span id="mnameError"> </span></td>       
	       <td valign="top"></td>
             </tr>
             <tr>
	       <td align="right" valign="top" style="padding-top:10px;">Last Name:<span style="color:red"> *</span>&nbsp;&nbsp;&nbsp;&nbsp;</td>
	       <td valign="top"><input autocomplete="off" name="lname" id="lname" type="text">
               <span id="lnameError" style="color: #ff6699;"> </span></td>              
	       <td valign="top"></td>
             </tr>

             <tr>
	      <td align="right" valign="top" style="padding-top:10px;">Gender:<span style="color:red"> *</span>&nbsp;&nbsp;&nbsp;&nbsp;</td>
              <td valign="top"><input name="gender" id="genderMale" value="Male" type="radio">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Male
                  <input name="gender" id="genderFemale" value="Female" type="radio">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Female
               <span id="genderError" style="color: #ff6699;"> </span></td>        
	      <td valign="top"></td>
            </tr>
            
            <tr>
	      <td align="right" valign="top" style="padding-top:10px;">Date Of Birth:<span style="color:red"> *</span>&nbsp;&nbsp;&nbsp;&nbsp;</td>
	      <td valign="top"><input autocomplete="off" name="dob" id="inputField" placeholder="yyyy-mm-dd" type="text" >
               <span id="dobError" style="color: #ff6699;"> </span> </td>       
	      <td valign="top"></td>
            </tr>
            
            <tr>
	      <td align="right" valign="top" style="padding-top:10px;">Postal Address:<span style="color:red"></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
	      <td valign="top"><input autocomplete="off" name="postalAddress" id="postalAddress" type="text">
               <span id="addressError" style="color: #ff6699;"> </span></td>       
	      <td valign="top"></td>
            </tr>

           <tr>
	    <td align="right" valign="top" style="padding-top:10px;">Mobile:<span style="color:red"></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
	    <td valign="top"><input autocomplete="off" name="mobNumber" id="mobNumber" type="text">
            <span id="mobileError" style="color: #ff6699;"> </span></td>        
	   <td valign="top"></td>
          </tr>

<tr>
	<td align="right" valign="top" style="padding-top:10px;">Nationality:<span style="color:red"></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
	<td valign="top"><input autocomplete="off" name="country" id="country" type="text">
        <span id="countryError" style="color: #ff6699;"> </span>
        </td>
	<td valign="top"></td>
</tr>
<tr>
	<td align="right" valign="top"></td>
	<td valign="top"><strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="submit" value="Submit" name="submit1"></strong> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <strong><input name="reset" value="Reset" type="reset"></strong> <br/></td>
	<td valign="top"></td>
	
</tr>
                  </tbody>
              </table>
      </fieldset>
    </form>
    </div>
  </div>
<!--ends collapsible SECTION A-->
    
    <!--Starts collapsible SECTION B-->
  <div data-role="main" class="ui-content">
    <div data-role="collapsible">
        
        <%
    double aggregatePoints=0.00;
    int result2=0;
    if(request.getParameter("submit2")!=null){
    AppDetails appdet2=new AppDetails();
    String subj1=request.getParameter("subj1");
    String subj2=request.getParameter("subj2");
    String subj3=request.getParameter("subj3");
    String subj4=request.getParameter("subj4");  
    String meanGrade=request.getParameter("meangrade");
    String aggregatePointsString=request.getParameter("aggregatepoints");
    double aggregatePointsInt=Double.parseDouble(aggregatePointsString);//  Integer.parseInt(aggregatePointsString);
    
    double subj1Converted=appdet2.convertGradestoPoints(subj1);
    double subj2Converted=appdet2.convertGradestoPoints(subj2);
    double subj3Converted=appdet2.convertGradestoPoints(subj3);
    double subj4Converted=appdet2.convertGradestoPoints(subj4); 
    aggregatePoints=appdet2.calculateClusterPoints(subj1Converted, subj2Converted, subj3Converted, subj4Converted, aggregatePointsInt);  
    
    result2=appdet2.setQualificationPoints(subj1, subj2, subj3, subj4, meanGrade, aggregatePoints);  
      
    if(result2>0){
        %>
        <h1>SECTION B: Applicant's Education Background...Details Saved Successfully, Proceed to the next section!</h1>  
      <%} else{%>
            
           <h1>SECTION B: Applicant's Education Background...Sorry, Details Not Saved, Try Again! </h1> 
        <%} 
    }else {%>
              <h1>SECTION B: Applicant's Education Background</h1>  
                <%}%>
      <form name="registration" method="post" action="" onsubmit=""><br>
          <fieldset>
              <table style="width: 600px; height: 50px;">
                  <tbody>
                      <tr>
	<td align="right" valign="top" style="padding-top:10px;">K.C.S.E Physics Grade:<span style="color:red"> *</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
	<td valign="top"><input autocomplete="off" name="subj1" id="subj1" type="text">
        <span id="physcsError" style="color: #ff6699;"> </span>
        </td>
	<td valign="top"></td>
</tr>

<tr>
	<td align="right" valign="top" style="padding-top:10px;">K.C.S.E Maths Grade:<span style="color:red"> *</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
	<td valign="top"><input autocomplete="off" name="subj2" id="subj2" type="text">
        <span id="mathsError" style="color: #ff6699;"> </span>
        </td>
	<td valign="top"></td>
</tr>

<tr>
	<td align="right" valign="top" style="padding-top:10px;">GROUP II or any GROUP III Grade:<span style="color:red"> *</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
	<td valign="top"><input autocomplete="off" name="subj3" id="subj3" type="text">
        <span id="subj3Error" style="color: #ff6699;"> </span>
        </td>
	<td valign="top"></td>
</tr>

<tr>
	<td align="right" valign="top" style="padding-top:10px;">GROUP II/GROUP III/GROUP IV/GROUP V Grade:<span style="color:red"> *</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
	<td valign="top"><input autocomplete="off" name="subj4" id="subj4" type="text">
        <span id="subj4Error" style="color: #ff6699;"> </span>
        </td>
	<td valign="top"></td>
</tr>

<tr>
	<td align="right" valign="top" style="padding-top:10px;">K.C.S.E Mean Grade:<span style="color:red"> *</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
	<td valign="top"><input autocomplete="off" name="meangrade" id="meangrade" type="text">
        <span id="meangradeError" style="color: #ff6699;"> </span>
        </td>
	<td valign="top"></td>
</tr>

<tr>
	<td align="right" valign="top" style="padding-top:10px;">K.C.S.E Aggregate Points:<span style="color:red"> *</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
	<td valign="top"><input autocomplete="off" name="aggregatepoints" id="aggregatepoints" type="text">
        <span id="qggregatepointsError" style="color: #ff6699;"> </span>
        </td>
	<td valign="top"></td>
</tr>
<tr>
	<td align="right" valign="top"></td>
	<td valign="top"><strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="submit" value="Submit" name="submit2"></strong> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <strong><input name="reset" value="Reset" type="reset"></strong> <br/></td>
	<td valign="top"></td>
	
</tr>

                  </tbody>
              </table>
          </fieldset>
      </form>
      
    </div>
  </div>
    <!--Starts collapsible SECTION B-->
    
    <!--Starts collapsible SECTION C--> 
  <div data-role="main" class="ui-content">
    <div data-role="collapsible">
        
            <%if(request.getParameter("submit3")!=null){

    ResultSet result1=null; 
    ResultSet result3=null;
    int result4=0;
    int courseLevelId=0; 
    int courseId=0; 
    String email="rok@yahoo.com";
    String crsLevel=request.getParameter("levelName");
    String crsName=request.getParameter("courseName");
    String modeOfStudy=request.getParameter("mod");
    String studyCampus=request.getParameter("studyCampus");
    AppDetails appdet3=new AppDetails();
    result1=appdet3.getLevelId(crsLevel);  
    result3=appdet3.getCourseId(crsName); 
    if(result1.next()){
       courseLevelId=result1.getInt("Level_id");  
       
    }
    if(result3.next()){   
         
       courseId=result3.getInt("crs_id"); 
    }
    result4=appdet3.setCourseAppDetails(email, courseLevelId, courseId, modeOfStudy, studyCampus);  
    %>
    
    <%
    if(result4>0){%>  
    <h1 style="color: green;">SECTION C: Course Application Details...Details Saved Successfully, Proceed to the next section!</h1><br>
    <%}else{%>
        <h1 style="color: red;">SECTION C: Course Application Details...Sorry, Details Not Saved, Try Again!</h1><br>
   <% }   
    }else{
    %>
        
      <h1>SECTION C: Course Application Details</h1>
      <%}%>
      <!--start accordion advice-->
      <div class="try" style="width: auto; height: auto; margin-left: 300px; margin-right: 300px;">
          <h5 style="text-align: center; color: green;">You qualify for the following programmes:</h5>
      <%
    double ch=0.00;
    int count=1;
    String email="rok@yahoo.com";
    ResultSet rs1=null;
    ResultSet rs22=null;
    ResultSet campuses=null; 
    AppDetails kip=new AppDetails();
    rs22=kip.selectClusterPoints(email);
    campuses=kip.setCampuses();
    if(rs22.next()){
        ch=rs22.getDouble("WeightedClusterPoints");
        rs1=kip.selectClusters(ch);
       while(rs1.next()){
               int crsId=rs1.getInt("Course_Id");
               int crsLevel=rs1.getInt("Level_Id");
               ResultSet info11=kip.setCourseName(crsId); 
               ResultSet info22=kip.setCourseLevel(crsLevel); 
      if(info11.next() && info22.next()){
          String crsName=info11.getString("crs_name");
          String crsLevelName=info22.getString("Level_name"); 
      
      %> 
           
           
      <input type="text" value="<%=count%>. <%=crsLevelName%> in <%=crsName%>" readonly>   
        
          <% }
      count++;
            }
       }
      %>
      </div>
      <!--ends accordion advice-->
    
      <form name="registration" method="post" action="Try.jsp" onsubmit=""><br>
          <fieldset>
              <table style="width: 600px; height: 50px;">
                  <tbody>

                      <tr>
                        <td align="right" valign="top" style="padding-top:10px;">Select Level:<span style="color:red"> *</span> &nbsp;&nbsp;&nbsp;</td>
                        <td valign="top"><select name="levelName">
                                <option selected="">select level</option> 
                                <option>Degree</option>
                                <option>Diploma</option>
                                <option>Certificate</option>
                            </select>
                        <span id="programmeError" style="color: #ff6699;"></span>
                        </td>
	                <td valign="top"></td>
                      </tr>
                      
                      <tr>
                        <td align="right" valign="top" style="padding-top:10px;">Select programme:<span style="color:red"> *</span> &nbsp;&nbsp;&nbsp;</td>
                        <td valign="top"><select name="courseName">
                                <option selected="">select programme</option> 
                                <option>Computer Science</option>
                                <option>Information Technology</option>
                                <option>Computer Studies</option>
                            </select>
                        <span id="programmeError" style="color: #ff6699;"></span>
                        </td>
	                <td valign="top"></td>
                      </tr>
               
                       <tr>
                        <td align="right" valign="top" style="padding-top:10px;">Mode of Study:<span style="color:red"> *</span> &nbsp;&nbsp;&nbsp;</td>
                        <td valign="top"><select name="mod">
                                <option selected="">mode of study</option> 
                                <option>Full Time</option>
                                <option>Part Time</option>
                                <option>Evening Classes</option>
                                <option>Weekend Classes</option>
                            </select>
                        <span id="modeofstudyError" style="color: #ff6699;"></span>
                        </td>
	                <td valign="top"></td>
                      </tr>
                      
                       <tr>
                        <td align="right" valign="top" style="padding-top:10px;">Campus/Study Center:<span style="color:red"> *</span> &nbsp;&nbsp;&nbsp;</td>
                        <td valign="top"><select name="studyCampus">
                                <option selected="">study center</option> 
                                <%
                                while(campuses.next()){
                                %>
                                <option><%=campuses.getString("Campus_Name")%></option>
                                <%}%>
                              </select>
                           <span id="studycenterError" style="color: #ff6699;"></span>
                        </td>
	                <td valign="top"></td>
                      </tr>
                      
                      <tr>
	               <td align="right" valign="top"></td>
	               <td valign="top">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                       <input type="submit" name="submit3" value="Submit">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                      <td valign="top"></td>
	
                    </tr>
                  </tbody>
              </table>
          </fieldset>
      </form>
    </div>
  </div>
<!--ends collapsible SECTION C-->
       
    <!--Starts collapsible SECTION D-->
    <div data-role="main" class="ui-content">
    <div data-role="collapsible">
      <h1>SECTION D: Print Your Form</h1>
      <a href="Click.jsp">print</a>
    </div>
  </div>
    <!--ends collapsible SECTION D-->
    
   </div> 
</div>
 </div>
</div>
<!--ends main content --> 
    </div>
</body>
</html>
