<%@ page import="java.util.List" %>
<%@ page import="models.News" %><%--
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
     <%
         List<News> news = (List<News>) request.getAttribute("zhanalyktar");
         if (news != null) {
             for (News n : news) {
     %>
     <h3><%=n.getTitle()%></h3>
     <p><%=n.getContent()%></p>
     <p>Author: <strong><%=n.getAuthor()%></strong></p>
     <hr>
     <%
             }
         }
     %>
 </div>
</body>
</html>
