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
  
        <h1>SECTION A: Applicants Personal Details</h1><br>
      
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
        
      
              <h1>SECTION B: Applicant's Education Background</h1>  
                
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
        
            
        
      <h1>SECTION C: Course Application Details</h1>
     
      <!--start accordion advice-->
      <div class="try" style="width: auto; height: auto; margin-left: 300px; margin-right: 300px;">
          <h5 style="text-align: center; color: green;">You qualify for the following programmes:</h5>
     
    
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
