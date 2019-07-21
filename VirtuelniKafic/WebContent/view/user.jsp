
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import= "model.User" %>   
 <%@page import="dao.UserDao"%>
 <%@page import="java.util.List" %>
 <%@page import="model.Artikal" %>
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

<%
   UserDao userDao = new UserDao();
  List<Artikal> listaArtikala = userDao.vratiSveArtikle();     
%>
<form action="../PlatiRacunServlet"method="get">
<table border="1">
<tr>
   <th>id</th>
   <th>ime</th>
   <th>cena</th>
   <th>popust</th>
   <th>check</th>
   <th>kolicina</th>

  </tr>
<%
for(Artikal a:listaArtikala){
%>
<tr>
      <td> <%=a.getIdArtikal() %></td>
       <td> <%=a.getImeArtikla() %></td>
       <td> <%=a.getCena() %></td>
       <td> <%=a.getPopust() %></td>
       <td> <input type="checkbox" name="check" value="<%=a.getIdArtikal()%>"></td>
       <td>
         <select name="kolicina">
         <%
            for(int i = 0;i<=a.getStanje();i++){	          
         %>
         
         <option value="<%=i %>"><%=i %>></option>
                  <%
                       }
                  %>
         
         
                 </select>

                </td>
   
      </tr>
 <%
  }
  %>


</table>

<input type="submit" value="PLATI RACUN">


</form>

</body>
</html>