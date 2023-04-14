<%@ page import="java.util.List" %>
<%@ page import="models.News" %>
<%@ page import="models.Student" %><%--
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
    <%@include file="head.jsp" %>
</head>
<body>
<%@include file="navbar.jsp" %>
<div class="container">
    <br>
    <!-- Button trigger modal -->
    <button type="button" class="btn btn-primary" data-bs-toggle="modal"
            data-bs-target="#addStudentModal">
        ADD STUDENT
    </button>
    <table class="table table-stripped">
        <thead>
        <th>ID</th>
        <th>NAME</th>
        <th>SURNAME</th>
        <th>CITY</th>
        <th>DETAILS</th>
        </thead>
        <tbody>
        <%
            List<Student> students = (List<Student>) request.getAttribute("studenty");
            if (students != null) {
                for (Student student : students) {
        %>
        <tr>
            <td><%=student.getId()%>
            </td>
            <td><%=student.getName()%>
            </td>
            <td><%=student.getSurname()%>
            </td>
            <td><%=student.getCity()%>
            </td>
            <td><a href="/studentDetails?id=<%=student.getId()%>" class="btn btn-dark">DETAILS</a>
            </td>
        </tr>
        <%
                }
            }
        %>
        </tbody>
    </table>
</div>


<!-- Modal -->
<div class="modal fade" id="addStudentModal" tabindex="-1" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <form action="/addStudent" method="post">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="exampleModalLabel">ADD STUDENT MODAL</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                            aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <div class="row">
                        <div class="col-2">
                            NAME:
                        </div>
                        <div class="col-10">
                            <input type="text" placeholder="Insert name" name="s_name"
                                   class="form-control">
                        </div>
                    </div>
                    <br>
                    <div class="row">
                        <div class="col-2">
                            SURNAME:
                        </div>
                        <div class="col-10">
                            <input type="text" placeholder="Insert surname" name="s_surname"
                                   class="form-control">
                        </div>
                    </div>
                    <br>
                    <div class="row">
                        <div class="col-2">
                            BIRTHDATE:
                        </div>
                        <div class="col-10">
                            <input type="date" name="s_birthdate" class="form-control">
                        </div>
                    </div>
                    <br>
                    <div class="row">
                        <div class="col-2">
                            CITY:
                        </div>
                        <div class="col-10">
                            <select name="s_city" class="form-select">
                                <option>Almaty</option>
                                <option>Astana</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close
                    </button>
                    <button type="submit" class="btn btn-primary">ADD STUDENT</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
