<%@ page import="java.util.List" %>
<%@ page import="models.Item" %><%--
  Created by IntelliJ IDEA.
  User: Kuat
  Date: 07.04.2023
  Time: 19:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="head.jsp"%>
</head>
<body>
 <%@include file="navbar.jsp"%>
 <div class="container">
     <table class="table table-striped">
         <thead>
            <th>ID</th>
            <th>NAME</th>
            <th>PRICE</th>
            <th>DETAILS</th>
         </thead>
         <tbody>
             <%
                 List<Item> items = (List<Item>) request.getAttribute("veshi");
                 if (items != null) {
                     for (Item item : items) {
             %>
                <tr>
                    <td><%=item.getId()%></td>
                    <td><%=item.getName()%></td>
                    <td><%=item.getPrice()%></td>
                    <td><a href="/itemDetails?id=<%=item.getId()%>" class="btn btn-dark">DETAILS</a></td>
                </tr>
             <%
                     }
                 }
             %>
         </tbody>
     </table>
 </div>
</body>
</html>
