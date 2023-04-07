<%--
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
    <div class="container col-6 mx-auto">
        <form action="/addItem" method="post">
            <div class="row">
                <div class="col-12">
                    NAME:
                </div>
            </div>
            <div class="row">
                <div class="col-12">
                    <input name="i_name" class="form-control" type="text" placeholder="Insert name">
                </div>
            </div>
            <br>
            <div class="row">
                <div class="col-12">
                    PRICE:
                </div>
            </div>
            <div class="row">
                <div class="col-12">
                    <input name="i_price" class="form-control" type="number" placeholder="Insert price">
                </div>
            </div>
            <br>
            <div class="row">
                <div class="col-12">
                    AMOUNT:
                </div>
            </div>
            <div class="row">
                <div class="col-12">
                    <input name="i_amount" class="form-control" type="number" placeholder="Insert amount">
                </div>
            </div>
            <br>
            <button class="btn btn-success">ADD ITEM</button>
        </form>
    </div>
</body>
</html>
