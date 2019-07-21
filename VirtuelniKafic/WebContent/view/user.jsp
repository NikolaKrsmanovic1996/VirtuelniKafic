<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import= "model.User" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Page</title>
</head>
<body>

<%
      User user = (User)session.getAttribute("ovdeJeUserObjekat");
%>
<h1> Zdravo user</h1>
<h2> Dobrodosli <%=user.getUserName() %></h2>
<h3> Stanje na vasem racunu je <%= user.getNovcanik() %></h3>


</body>
</html>