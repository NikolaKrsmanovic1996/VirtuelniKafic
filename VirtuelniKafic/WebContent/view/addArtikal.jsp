<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dodaj Artikal u bazu</title>
</head>
<body>
<a href = "administrator.jsp">back to admin page</a><br><br>

<form action="../AddArtikalServlet"method="get">
 Ime Artikla <input type="text" name="imeArtikla"><br><br>
 Cena        <input type="text" name="cena"><br><br>
 Stanje      <input type="text" name="stanje"><br><br>
 Popust      <input type="text" name="popust"><br><br>
             <input type="submit" value="DODAJ">




</form>

</body>
</html>