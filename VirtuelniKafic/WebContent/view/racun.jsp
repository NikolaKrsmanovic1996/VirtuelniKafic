<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="model.User" %>
<%@page import="java.util.ArrayList"%> 
<%@page import="java.util.List" %>
<%@page import="model.Artikal" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>racun</title>
</head>
<body>
      <%  User user = (User)session.getAttribute("ovdeJeUserObjekat");
          double totalPrice = (Double)request.getAttribute("totalPrice");
          List<Artikal> listaArtikala = (List<Artikal>)request.getAttribute("listaArtikala");
          List<String> listaKolicina = (List<String>)request.getAttribute("listaKolicina");
      
      
      
      %>
  User: <%=user.getUserName() %><br><br>
  Racun: <table border="1">
  
               <tr>
                <th>ime artikla</th>
                <th>cena</th>
                <th>popust</th>
                <th>kolicina</th>
                
                </tr>
                <% for (int i=0;i<listaArtikala.size();i++){ %>
  
                <tr>
               <td><%= listaArtikala.get(i).getImeArtikla() %></td>
               <td><%= listaArtikala.get(i).getCena() %></td>
               <td><%= listaArtikala.get(i).getPopust() %></td>
               <td><%= listaArtikala.get(i)%></td>
               
             
              </tr>
  
          <% } %>
    
  </table>
  <br><br>
  
  Total Price : <%= totalPrice  %>
  
  <a href="view/user.jsp">Back to User</a>
  
</body>
</html>