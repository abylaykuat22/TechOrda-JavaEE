<%@ page import="models.Student" %><%--
  Created by IntelliJ IDEA.
  User: Kuat
  Date: 14.04.2023
  Time: 20:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>DETAILS</title>
    <%@include file="head.jsp" %>
</head>
<body>
<%@include file="navbar.jsp" %>
<%
    Student student = (Student) request.getAttribute("student");
    if (student != null) {
%>
<div class="container col-6 mx-auto">
    <form action="/editStudent" method="post">
        <input type="hidden" name="id" value="<%=student.getId()%>">
        <div class="row">
            <div class="col-6">
                NAME:
            </div>
            <div class="col-6">
                <input class="form-control" type="text" name="name" value="<%=student.getName()%>">
            </div>
        </div>
        <div class="row">
            <div class="col-6">
                SURNAME:
            </div>
            <div class="col-6">
                <input class="form-control" type="text" name="surname"
                       value="<%=student.getSurname()%>">
            </div>
        </div>
        <div class="row">
            <div class="col-6">
                BIRTHDATE:
            </div>
            <div class="col-6">
                <input class="form-control" type="text" name="birthdate"
                       value="<%=student.getBirthdate()%>">
            </div>
        </div>
        <div class="row">
            <div class="col-6">
                CITY:
            </div>
            <div class="col-6">
                <input type="text" name="city" value="<%=student.getCity()%>">
            </div>
        </div>
        <button class="btn btn-success">SAVE STUDENT</button>
    </form>
    <form action="/deleteStudent" method="post">
        <input type="hidden" value="<%=student.getId()%>" name="id">
        <button class="btn btn-danger">DELETE</button>
    </form>
</div>
<%
    }
%>
</body>
</html>
