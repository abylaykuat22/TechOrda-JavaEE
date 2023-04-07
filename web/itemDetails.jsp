<%@ page import="models.Item" %><%--
  Created by IntelliJ IDEA.
  User: Kuat
  Date: 07.04.2023
  Time: 19:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="head.jsp"%>
</head>
<body>
<%@include file="navbar.jsp"%>
<br>
    <%
        Item item = (Item) request.getAttribute("zat");
        if (item != null) {
    %>
        <div class="container col-6 mx-auto">
            <div class="row">
                <div class="col-12">
                    NAME:
                    <h5><%=item.getId()%></h5>
                </div>
            </div>
            <div class="row">
                <div class="col-12">
                    PRICE:
                    <h5><%=item.getPrice()%></h5>
                </div>
            </div>
            <div class="row">
                <div class="col-12">
                    AMOUNT:
                    <h5><%=item.getAmount()%></h5>
                </div>
            </div>

        </div>

    <%
        }
    %>

</body>
</html>
