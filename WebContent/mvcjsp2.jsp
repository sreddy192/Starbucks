<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%String itemvalue="";
   String pricevalue="";
   if(request.getAttribute("item")!=null)
	   itemvalue=(String)request.getAttribute("item");
    if(request.getAttribute("price")!=null)
	   pricevalue=(String)request.getAttribute("price");%>
<p>Please enter item name and price</p>	   
<form  method="Post" action="command"?name=action>
    Item:<br>
     <input type="text" name="item" value=<%=itemvalue%>><br>
    Price:<br>
    <input type="text" name="price" value=<%=pricevalue%>><br>
    <br><br>
    <input type="submit" name="action" value="insert">
     <input type="submit" name="action" value="find">
    <input type="submit" name="action" value="update">
    <input type="submit" name="action" value="delete">
    <input type="submit" name="action" value="display">
    
    <p><a href = "login.html">Logout</a></p>
</body>
</html>