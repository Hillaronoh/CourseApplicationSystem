<%@ page language ="java" import="java.sql.*,java.text.SimpleDateFormat, java.util.Date,java.text.*, java.util.Calendar" %>
<html>
<body bgcolor="pink">
<form method="post">
<input  name="T1" value="2013-10-14"/> 
<input  name="T2" value="2014-07-01"/>
<input type="submit" value="Submit" name="B1">
</form>

<%

String dStart = request.getParameter("T1");
String dStop = request.getParameter("T2");

SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

Date d1 = null;
Date d2 = null;
Date d3 = null;
SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
String dateSent=formatter.format(new Date());

if (dStart != null && dStop != null) {
try {
d1 = format.parse(dStart);
d2 = format.parse(dStop);
d3 = format.parse(dateSent); 

//out.print(d1);

long difference = d3.getTime() - d1.getTime(); 

long seconds = (difference / (1000*60*60*24));// 60 * 60 * 24*365)); 
long kk=seconds/365;

out.print(kk);

} catch (Exception e) {
e.printStackTrace();
}
}
%>

</body>
</html>