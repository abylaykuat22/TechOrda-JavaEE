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
    <div class="row">
        <div class="col-6">
            NAME:
        </div>
        <div class="col-6">
            <strong><%=student.getName()%>
            </strong>
        </div>
    </div>
    <div class="row">
        <div class="col-6">
            SURNAME:
        </div>
        <div class="col-6">
            <strong><%=student.getSurname()%>
            </strong>
        </div>
    </div>
    <div class="row">
        <div class="col-6">
            BIRTHDATE:
        </div>
        <div class="col-6">
            <strong><%=student.getBirthdate()%>
            </strong>
        </div>
    </div>
    <div class="row">
        <div class="col-6">
            CITY:
        </div>
        <div class="col-6">
            <strong><%=student.getCity()%>
            </strong>
        </div>
    </div>
    <br>
    <a href="/editStudent?id=<%=student.getId()%>" class="btn btn-primary">EDIT STUDENT</a>
</div>
<%
    }
%>
</body>
</html>
