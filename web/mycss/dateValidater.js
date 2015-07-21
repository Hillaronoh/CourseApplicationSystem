/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function checkDate(){
var date=document.personalDetails.dob.value;
//var validformat=/^\d{4}-\d{2}-\d{2}$/ //Basic check for format validity
//if (!validformat.test(date)){
   // document.getElementById("dobError").innerHTML = "Invalid Date Format!";
//document.write("Invalid Date Format. Please correct and submit again.");
//document.personalDetails.dob.select();
//return false;
//}
//else{ //Detailed check for valid date ranges
var yearfield=date.split("-")[0];
var monthfield=date.split("-")[1];
var dayfield=date.split("-")[2];
var dayobj = new Date(yearfield, monthfield-1, dayfield);
if ((dayobj.getMonth()+1!=monthfield)||(dayobj.getDate()!=dayfield)||(dayobj.getFullYear()!=yearfield)){
     document.getElementById("dobError").innerHTML = "Invalid Day, Month, or Year range detected!";
//document.write("Invalid Day, Month, or Year range detected. Please correct and submit again.");
document.personalDetails.dob.select();
return false;
}
else{
return true;
}
}
//}