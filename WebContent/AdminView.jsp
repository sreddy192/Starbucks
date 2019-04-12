<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<TABLE BORDER=5 ALIGN="CENTER">
  <TR><TH CLASS="TITLE">
     Starbucks Management</TABLE>
<OL>
   
    The menu with the following data is <%=(String)session.getAttribute("operation")%>: 
    <I><%= (String)session.getAttribute("item") %></I>
    <I><%= (String)session.getAttribute("price") %></I><br>
    
     <I><%= (String)session.getAttribute("result") %></I><br>
     
    <A HREF="mvcjsp2.jsp " >Go Back</a> 
</OL>  
</body>
</html>