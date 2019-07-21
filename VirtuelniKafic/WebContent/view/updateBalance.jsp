<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Balance</title>
</head>
<body>
<a href="administrator.jsp">back to admin</a><br><br>

<form action="../UpdateBalanceServlet" method="get">

   User name :<input type="text" name = "userName">
   Balance : <input type="text" name = "balance">
             <input type="submit" value="DODAJ">
             
   </form>

</body>
</html>