<%-- 
    Document   : UserLogin
    Created on : Jun 13, 2015, 9:41:48 PM
    Author     : Kipngetich
--%>
<%@page import="java.sql.*" %>
<%Class.forName("com.mysql.jdbc.Driver"); %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Application Form|mmust</title>
        
        <!--start date picker-->
        <link rel="stylesheet" type="text/css" media="all" href="jsDatePick_ltr.min.css" />
        <script type="text/javascript" src="jsDatePick.min.1.3.js"></script>
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
        <!--end date picker--> 
        
        <script type="text/javaScript">
function ValidateG(form){
ErrorText= "";
if ( ( form.gender[0].checked == false ) && ( form.gender[1].checked == false ) )
{
alert ( "Please choose your Gender: Male or Female" );
return false;
}
if (ErrorText= "") { form.submit() }
}
</script>
        
        <!--start navigation menus-->
        <link rel="stylesheet" href="mycss/glyphicons/css/bootstrap.min.css">
        <link rel="stylesheet" style type="text/css" href="mycss/navMenus.css">
        <!--end navigation menus-->
        <!-- accordions -->
        <link rel="stylesheet" type="text/css" href="mycss/accordion1/defaults.css">
        <link rel="stylesheet" type="text/css" href="mycss/accordion1/demo.css">
        <script type="text/javascript" src="mycss/accordion1/jquery.min.js"></script>
        <script type="text/javascript" src="mycss/accordion1/accordion.js"></script>
        
        <!--form elements--><link rel="stylesheet" href="layout/bootstrap/css/bootstrap.css" type="text/css">
        <!-- Core CSS - Include with every page -->
        <link href="assets/plugins/bootstrap/bootstrap.css" rel="stylesheet" />
        <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
        <link href="assets/plugins/pace/pace-theme-big-counter.css" rel="stylesheet" />
        <link href="assets/css/style.css" rel="stylesheet" />
        <link href="assets/css/main-style.css" rel="stylesheet" />
        <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.css">
        
        
        <script type="text/javascript" src="mycss/dateValidater.js"></script>
        <script type="text/javascript" src="mycss/pDetailsValidate.js"></script>
        <script type="text/javascript" src="mycss/eBackgroundValidate.js"></script>
        <script type="text/javascript" src="mycss/cApplicationDetailsValidate.js"></script>
        
    </head>
    <body style="overflow-x: hidden; background-color: #EFEEEE;"> 
        
        <jsp:include page="Header.jsp"></jsp:include>
        
        <div class="container">
            
            <div class="row1" style="margin-top: 0px;">
                
                <div class="col-md-4 col-md-offset-4" style="width: 1082px; margin-left: 43px;">
                    
                    <div class="login-panel panel panel-default"> 
                        <!--start navigation menus-->
                        <div id="navMenu" style="margin-top: 5px;">
                            <ul>
                                <li><a href="UserAccount.jsp"><button class="btn btn-info" style="width: 148px; height: 38px; padding-top: 0px; margin-top: -5px;"><i class="fa fa-home"></i>Home</button></a>
                                </li>
                            </ul>
                            <ul>
                                <li><a href="#"><button class="btn btn-info" style="width: 148px; height: 38px; padding-top: 0px; margin-top: -5px; background-color: #428BCA;"><i class="fa fa-arrow-down"></i>Apply Course</button></a>
                                    <ul>
                                        <li><a href="ApplicationForm.jsp">Under Graduate</a></li>
                                        <li><a href="#">Post Graduate</a></li>
                                    </ul>
                                </li>
                            </ul>
                            <ul>
                                <li><a href="Announcements.jsp"><button class="btn btn-info" style="width: 148px; height: 38px; padding-top: 0px; margin-top: -5px;"><i class="fa fa-bell"></i>Announcements</button></a>
                                    
                                </li>
                            </ul>
                            <ul>
                                <li><a href="Details.jsp"><button class="btn btn-info" style="width: 148px; height: 38px; padding-top: 0px; margin-top: -5px;"><i class="fa fa-archive"></i>My Details</button></a>
                                </li>
                            </ul>
                            <ul>
                                <li><a href="Messaging.jsp"><button class="btn btn-info" style="width: 148px; height: 38px; padding-top: 0px; margin-top: -5px;"><i class="fa fa-inbox"></i>Inquiries</button></a>
                                </li>
                            </ul>
                            <ul>
                                <li><a href="#ApplicationStatus" data-toggle="modal"><button class="btn btn-info" style="width: 148px; height: 38px; padding-top: 0px; margin-top: -5px;"><i class="fa fa-star"></i>Application Status</button></a>
                                </li>
                            </ul>
                            <ul>
                                <li><a href="#"><button class="btn btn-info" style="width: 148px; height: 38px; padding-top: 0px; margin-top: -5px;"><i class="fa fa-user"></i>kip</button></a>
                                    <ul>
                                        <li><a href="ChangePwd.jsp"><i class="fa fa-dropbox"></i>Change Password</a></li>
                                        <li><a href="UserLogout.jsp"><i class="fa fa-sign-out"></i>Logout</a></li>
                                    </ul>
                                </li>
                            </ul>
                            
                        </div>
                        <!--end navigation menus-->
                        <div class="panel-heading" style="margin-top: 56px;border-top: 1px solid;">
                            <h3 class="panel-title">Provide The required Information in the Sections Below.</h3>
                        </div>
                        
                        <div class="panel-body">
                            
                            <!--start accordion A-->
                            <div class="main">
                                <div class="accordion">
                                    <div class="accordion-section">
                                        <a class="accordion-section-title" href="#accordion-1">SECTION A: Applicant's Personal Details.</a>
                                        <div id="accordion-1" class="accordion-section-content"> 
                                            
                                            <form name="personalDetails" method="post" action="" onsubmit="return validatePersonaldetailsForm(this)">
                                                <fieldset>
                                                    
                                                    <table style="width: 100%; height: 450px;">
                                                        <tbody>
                                                            
                                                            <tr>
                                                                <td align="right" valign="top" style="padding-top:10px;">First Name:<span style="color:red"> *</span>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                                                                <td valign="top"><input placeholder="First Name" autocomplete="off" name="fname" type="text" readonly>
                                                                </td>
                                                                <td valign="top"></td>
                                                                
                                                            </tr>
                                                            <tr>
                                                                <td align="right" valign="top" style="padding-top:10px;">Middle Name:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>   
                                                                <td valign="top"><input placeholder="Middle Name" name="mname" type="text" readonly></td>
                                                                <td valign="top"></td>
                                                                
                                                            </tr>
                                                            <tr>
                                                                <td align="right" valign="top" style="padding-top:10px;">Last Name:<span style="color:red"> *</span>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                                                                <td valign="top"><input placeholder="Last Name" name="lname" type="text" readonly>
                                                                    <span id="lnameError" style="color: red;"></span></td>
                                                                <td valign="top"></td>
                                                                
                                                            </tr>
                                                            <tr>
                                                                <td align="right" valign="top" style="padding-top:10px;">Gender:<span style="color:red"> *</span>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                                                                <td valign="top"><input name="gender" id="genderMale" value="Male" type="radio">&nbsp;&nbsp;Male<br>
                                                                    <input name="gender" id="genderFemale" value="Female" type="radio">&nbsp;&nbsp;Female
                                                                    <span id="genderError" style="color: #ff6699;"> </span></td>        
                                                                <td valign="top"></td>
                                                            </tr>
                                                            <tr>
                                                                <td align="right" valign="top" style="padding-top:10px;">Date of Birth:<span style="color:red"> *</span>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                                                                <td valign="top"><input placeholder="yyyy-mm-dd" id="inputField" name="dob" type="text" autocomplete="off">
                                                                    <span id="dobError" style="color: red;"></span></td>
                                                                <td valign="top"></td>
                                                                
                                                            </tr>
                                                            <tr>
                                                                <td align="right" valign="top" style="padding-top:10px;">Postal address:<span style="color:red"> *</span>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                                                                <td valign="top"><input placeholder="e.g P.O Box 48, Chebunyo" name="postaladdress" type="text">
                                                                    <span id="postaladdressError" style="color: red;"></span></td>
                                                                <td valign="top"></td>
                                                                
                                                            </tr>
                                                            <tr>
                                                                <td align="right" valign="top" style="padding-top:10px;">Mobile:<span style="color:red"> *</span>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                                                                <td valign="top"><input placeholder="Mobile Number (07...)" name="mobile" type="text">
                                                                    <span id="mobileError" style="color: red;"></span></td>
                                                                <td valign="top"></td>
                                                                
                                                            </tr>
                                                            <tr>
                                                                <td align="right" valign="top" style="padding-top:10px;">Nationality:<span style="color:red"> *</span>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                                                                <td valign="top"><input placeholder="Country of Residence" name="country" type="text">
                                                                    <span id="countryError" style="color: red;"></span></td>
                                                                <td valign="top"></td>
                                                                
                                                            </tr>
                                                            <tr>
                                                                <td align="right" valign="top"></td>
                                                                <td valign="top">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                                    <input type="submit" name="submit1" class="btn btn-success" value="Submit" onclick=""> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                                    <input name="reset" class="btn btn-info" value="Reset" type="reset" id="reset"> <br/></td>
                                                                <td valign="top"></td>
                                                                
                                                            </tr>
                                                        </tbody>
                                                    </table>
                                                </fieldset>
                                            </form>
                                        </div><!--end .accordion-section-content-->
                                    </div><!--end .accordion-section-->
                                </div><!--end .accordion-->
                            </div>
                            <!--end accordion A-->
                            
                            <!--start accordion B-->
                            <div class="main">
                                <div class="accordion">
                                    <div class="accordion-section">
                                        <a class="accordion-section-title" href="#accordion-2">SECTION B: Applicant's Education Background.</a>
                                        <div id="accordion-2" class="accordion-section-content">
                                            
                                            <form role="form" method="post" action="" onsubmit="return validateEducationBackgroundForm(this)">
                                                <fieldset>
                                                    
                                                    <table style="width: 650px; height: 350px;">
                                                        <tbody>
                                                            
                                                            <tr>
                                                                <td align="right" valign="top" style="padding-top:10px;">K.C.S.E Physics Grade:<span style="color:red"> *</span> &nbsp;&nbsp;&nbsp;</td>
                                                                <td valign="top"><select id="physicsgrade" name="physicsgrade">
                                                                        <option value="" selected>~select grade~</option> 
                                                                        <option value="A">A</option>
                                                                        <option value="A-">A-</option>
                                                                        <option value="B+">B+</option>
                                                                        <option value="B">B</option>
                                                                        <option value="B-">B-</option>
                                                                        <option value="C+">C+</option>
                                                                        <option value="C">C</option>
                                                                        <option value="C-">C-</option>
                                                                        <option value="D+">D+</option>
                                                                        <option value="D">D</option>
                                                                        <option value="D-">D-</option>
                                                                        <option value="E">E</option>
                                                                    </select>
                                                                    <span id="physicsgradeError" style="color: #ff6699;"></span>
                                                                </td>
                                                                <td valign="top"></td>
                                                            </tr>
                                                            <tr>
                                                                <td align="right" valign="top" style="padding-top:10px;">K.C.S.E Maths Grade:<span style="color:red"> *</span> &nbsp;&nbsp;&nbsp;</td>
                                                                <td valign="top"><select name="mathsgrade">
                                                                        <option value="" selected>~select grade~</option> 
                                                                        <option value="A">A</option>
                                                                        <option value="A-">A-</option>
                                                                        <option value="B+">B+</option>
                                                                        <option value="B">B</option>
                                                                        <option value="B-">B-</option>
                                                                        <option value="C+">C+</option>
                                                                        <option value="C">C</option>
                                                                        <option value="C-">C-</option>
                                                                        <option value="D+">D+</option>
                                                                        <option value="D">D</option>
                                                                        <option value="D-">D-</option>
                                                                        <option value="E">E</option>
                                                                    </select>
                                                                    <span id="mathsgradeError" style="color: #ff6699;"></span>
                                                                </td>
                                                                <td valign="top"></td>
                                                            </tr>
                                                            <tr>
                                                                <td align="right" valign="top" style="padding-top:10px;">GROUP II or any GROUP III Grade:<span style="color:red"> *</span> &nbsp;&nbsp;&nbsp;</td>
                                                                <td valign="top"><select name="subj3">
                                                                        <option value="" selected>~select grade~</option> 
                                                                        <option value="A">A</option>
                                                                        <option value="A-">A-</option>
                                                                        <option value="B+">B+</option>
                                                                        <option value="B">B</option>
                                                                        <option value="B-">B-</option>
                                                                        <option value="C+">C+</option>
                                                                        <option value="C">C</option>
                                                                        <option value="C-">C-</option>
                                                                        <option value="D+">D+</option>
                                                                        <option value="D">D</option>
                                                                        <option value="D-">D-</option>
                                                                        <option value="E">E</option>
                                                                    </select>
                                                                    <span id="subj3Error" style="color: #ff6699;"></span>
                                                                </td>
                                                                <td valign="top"></td>
                                                            </tr>
                                                            <tr>
                                                                <td align="right" valign="top" style="padding-top:10px;">GROUP II/GROUP III/GROUP IV/GROUP V Grade:<span style="color:red"> *</span> &nbsp;&nbsp;&nbsp;</td>
                                                                <td valign="top"><select name="subj4">
                                                                        <option value="" selected>~select grade~</option> 
                                                                        <option value="A">A</option>
                                                                        <option value="A-">A-</option>
                                                                        <option value="B+">B+</option>
                                                                        <option value="B">B</option>
                                                                        <option value="B-">B-</option>
                                                                        <option value="C+">C+</option>
                                                                        <option value="C">C</option>
                                                                        <option value="C-">C-</option>
                                                                        <option value="D+">D+</option>
                                                                        <option value="D">D</option>
                                                                        <option value="D-">D-</option>
                                                                        <option value="E">E</option>
                                                                    </select>
                                                                    <span id="subj4Error" style="color: #ff6699;"></span>
                                                                </td>
                                                                <td valign="top"></td>
                                                            </tr>
                                                            <tr>
                                                                <td align="right" valign="top" style="padding-top:10px;">K.C.S.E Mean Grade:<span style="color:red"> *</span> &nbsp;&nbsp;&nbsp;</td>
                                                                <td valign="top"><select name="meangrade">
                                                                        <option value="" selected>~select grade~</option> 
                                                                        <option value="A">A</option>
                                                                        <option value="A-">A-</option>
                                                                        <option value="B+">B+</option>
                                                                        <option value="B">B</option>
                                                                        <option value="B-">B-</option>
                                                                        <option value="C+">C+</option>
                                                                        <option value="C">C</option>
                                                                        <option value="C-">C-</option>
                                                                        <option value="D+">D+</option>
                                                                        <option value="D">D</option>
                                                                        <option value="D-">D-</option>
                                                                        <option value="E">E</option>
                                                                    </select>
                                                                    <span id="meangradeError" style="color: #ff6699;"></span>
                                                                </td>
                                                                <td valign="top"></td>
                                                            </tr>
                                                            <tr>
                                                                <td align="right" valign="top" style="padding-top:10px;">K.C.S.E Aggregate Points:<span style="color:red"> *</span>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                                                                <td valign="top"><input style="width: 150px;" placeholder="Total Aggregate Points" name="aggregatepoints" type="text" autocomplete="off">
                                                                    <span id="aggregatepointsError" style="color: #ff6699;"></span></td>
                                                                <td valign="top"></td>
                                                                
                                                            </tr>
                                                            <tr>
                                                                <td align="right" valign="top"></td>
                                                                <td valign="top">
                                                                    <input type="submit" name="submit2" class="btn btn-success" value="Submit">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                                    <input name="reset" class="btn btn-info" value="Reset" type="reset"> <br/></td>
                                                                <td valign="top"></td>
                                                                
                                                            </tr>
                                                        </tbody>
                                                    </table>
                                                </fieldset>
                                            </form>
                                            
                                        </div><!--end .accordion-section-content-->
                                    </div><!--end .accordion-section-->
                                </div><!--end .accordion-->
                            </div>
                            <!--end accordion B-->
                            
                            <!--start accordion C-->
                            <div class="main">
                                <div class="accordion">
                                    <div class="accordion-section">
                                        <a class="accordion-section-title" href="#accordion-3">SECTION C: Course Application Details.</a>
                                        <div id="accordion-3" class="accordion-section-content">
                                            
                                            <form role="form" method="post" action="" onsubmit="return validateCourseApplicationDetailsForm(this)">
                                                <fieldset>
                                                    
                                                    <table style="width: 650px; height: 250px;">
                                                        <tbody>
                                                            
                                                            <tr>
                                                                <td align="right" valign="top" style="padding-top:10px;">Programme Level:<span style="color:red"> *</span> &nbsp;&nbsp;&nbsp;</td>
                                                                <td valign="top"><select name="programmelevel" style="width: 205px;">
                                                                        <option value="" selected>~select programme level~</option> 
                                                                        <option value="Degree">Degree</option>
                                                                        <option value="Diploma">Diploma</option>
                                                                        <option value="Certificate">Certificate</option>
                                                                    </select>
                                                                    <span id="programmelevelError" style="color: #ff6699;"></span>
                                                                </td>
                                                                <td valign="top"></td>
                                                            </tr>
                                                            <tr>
                                                                <td align="right" valign="top" style="padding-top:10px;">Programme Name:<span style="color:red"> *</span> &nbsp;&nbsp;&nbsp;</td>
                                                                <td valign="top"><select name="programmename" style="width: 205px;">
                                                                        <option value="" selected>~select programme name~</option> 
                                                                        <option value="Computer Science">Computer Science</option>
                                                                        <option value="Information Technology">Information Technology</option>
                                                                        <option value="Computer Studies">Computer Studies</option>
                                                                        <option value="Computer Forensics">Computer Forensics</option>
                                                                    </select>
                                                                    <span id="programmenameError" style="color: #ff6699;"></span>
                                                                </td>
                                                                <td valign="top"></td>
                                                            </tr>
                                                            <tr>
                                                                <td align="right" valign="top" style="padding-top:10px;">Mode of Study:<span style="color:red"> *</span> &nbsp;&nbsp;&nbsp;</td>
                                                                <td valign="top"><select name="modeofstudy" style="width: 205px;">
                                                                        <option value="" selected>~select mode of study~</option> 
                                                                        <option value="Full Time">Full Time</option>
                                                                        <option value="Part Time">Part Time</option>
                                                                        <option value="Evening">Evening Classes</option>
                                                                        <option value="Weekend Classes">Weekend Classes</option>
                                                                    </select>
                                                                    <span id="modeofstudyError" style="color: #ff6699;"></span>
                                                                </td>
                                                                <td valign="top"></td>
                                                            </tr>
                                                            <tr>
                                                                <td align="right" valign="top" style="padding-top:10px;">Campus/Study Center:<span style="color:red"> *</span> &nbsp;&nbsp;&nbsp;</td>
                                                                <td valign="top"><select name="campus" style="width: 205px;">
                                                                        <option value="" selected>~select campus~</option> 
                                                                        <option value="Main Campus">Main Campus</option>
                                                                        <option value="KiBuCo">Kibabii University College</option>
                                                                        <option value="BuC">Bungoma Campus</option>
                                                                        <option value="Kaps">Kapsabet Campus</option>
                                                                    </select>
                                                                    <span id="campusError" style="color: #ff6699;"></span>
                                                                </td>
                                                                <td valign="top"></td>
                                                            </tr>
                                                            <tr>
                                                                <td align="right" valign="top"></td>
                                                                <td valign="top">&nbsp;&nbsp;&nbsp;&nbsp;
                                                                    <input type="submit" name="submit2" class="btn btn-success" value="Submit">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                                    <input name="reset" class="btn btn-info" value="Reset" type="reset"> <br/></td>
                                                                <td valign="top"></td>
                                                                
                                                            </tr>
                                                        </tbody>
                                                    </table>
                                                </fieldset>
                                            </form>
                                            
                                        </div><!--end .accordion-section-content-->
                                    </div><!--end .accordion-section-->
                                </div><!--end .accordion-->
                            </div>
                            <!--end accordion C-->
                            
                            <!--start accordion D-->
                            <div class="main">
                                <div class="accordion">
                                    <div class="accordion-section">
                                        <a class="accordion-section-title" href="#accordion-4">SECTION D: Print Your Form.</a>
                                        <div id="accordion-4" class="accordion-section-content">
                                            
                                            
                                            <a href="PdfGenerator.jsp" class="btn btn-success btn-lg">
                                                <span><img src="image/printer.png" alt="printer" style="width: 30px; height: 30px;"></span> Print 
                                            </a>
                                            
                                            
                                        </div><!--end .accordion-section-content-->
                                    </div><!--end .accordion-section-->
                                </div><!--end .accordion-->
                            </div>
                            <!--end accordion D-->
                            
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="modal fade" id="ApplicationStatus" role="dialog">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title">Application Status</h4>
                    </div>
                    <div class="modal-body">
                        <p>You successfully secured a placement in bachelor of science in computer science
                        </p>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-danger" data-dismiss="modal">close</button>
                    </div>
                </div>
            </div>
        </div>
        <!-- Core Scripts - Include with every page -->
        <script src="assets/plugins/jquery-1.10.2.js"></script>
        <script src="assets/plugins/bootstrap/bootstrap.min.js"></script>
        <script src="assets/plugins/metisMenu/jquery.metisMenu.js"></script>
        <script src="mycss/dateValidator.js"></script> 
        <script type="text/javascript" src="mycss/modal/jquery.minCust.js"></script>
        <script type="text/javascript" src="mycss/modal/bootstrapJsCust.js"></script>
    </body>
</html>
