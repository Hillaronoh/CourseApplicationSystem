<html>
<head>
<script>
function dateDiff(dateform) {
date1 = new Date();
date2 = new Date();
diff  = new Date();

date1temp = new Date(dateform.firstdate.value);
date1.setTime(date1temp.getTime());

date2temp = new Date(dateform.seconddate.value);
date2.setTime(date2temp.getTime());
diff.setTime(Math.abs(date1.getTime() - date2.getTime()));

timediff = diff.getTime();
days = Math.floor(timediff / (1000 * 60 * 60 * 24)); 
dateform.difference.value = days;
return false; 
}
</script>
</head>
<form onSubmit="return dateDiff(this);">
<pre>
First Date(MM/DD/YYYY):     <input type=text name=firstdate>   

Second Date(MM/DD/YYYY):    <input type=text name=seconddate> 

Date Difference (in days):  <input type=text name=difference>

                            <input type=submit value="Calculate Difference!">

</pre>
</form>
</html>