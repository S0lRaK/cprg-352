<%-- 
    Author: Carlos J. Garcia Carmona
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="ca.sait.itsd.StudentList" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean
    id="studentList"
    class="ca.sait.itsd.StudentList"
    scope="session"
    />
<%
    final String MSG_ADD = "Added new student";
    final String MSG_DELETE = "Deleted student";
    String message = (String) request.getAttribute("message");

    if (message != null) {
        if (message.equals(MSG_ADD)) {
            studentList.addStudent(
                    request.getParameter("name"),
                    request.getParameter("id"),
                    request.getParameter("email")
            );
        } else if (message.equals(MSG_DELETE)) {
            studentList.deleteStudent(Integer.parseInt(request.getParameter("delete")));
        }
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://fonts.googleapis.com/css?family=Bungee+Shade|Roboto:400,700" rel="stylesheet">
        <link
            href="https://fonts.googleapis.com/icon?family=Material+Icons"
            rel="stylesheet"
            />
        <link rel="stylesheet" href="styles/index.css">
    </head>
    <body>
        <h1>Student List</h1>
        <h3>${requestScope.message}</h3>
        <form action="StudentController" method="POST">
            <h2>
                Add Student
            </h2>
            <div class="inputs">
                <div class="input">
                    <label for="inputName">
                        Name:
                    </label>
                    <input id="inputName" name="name" type="text">
                </div>
                <div class="input">
                    <label for="inputId">
                        ID:
                    </label>
                    <input id="inputId" name="id" type="text" pattern="[0-9]" placeholder="Numbers only">
                </div>
                <div class="input">
                    <label for="inputEmail">
                        Email:
                    </label>
                    <input id="inputEmail" name="email" type="email">
                </div>
                <button type="submit" name="add" class="action">
                    Add <i class="material-icons">add</i>
                </button>
            </div>
        </form>
        <div>
            <h2>
                Students
            </h2>
            <div class="table-container">
                <table>
                    <thead>
                        <tr>
                            <th>Name</th>
                            <th>ID</th>
                            <th>Email</th>
                            <th>Delete</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:choose>
                            <c:when test="${studentList.numberOfStudents eq 0}">
                                <tr>
                                    <td class="no-data" colspan="4">No student data available</td>
                                </tr>
                            </c:when>
                            <c:otherwise>
                                <c:forEach var="student" items="${studentList.studentList}">
                                    <tr>
                                        <td>${student.name}</td>
                                        <td>${student.id}</td>
                                        <td>${student.email}</td>
                                        <td class="delete-cell">
                                            <a href="StudentController?delete=${studentList.studentList.indexOf(student)}">
                                                <button name="delete">
                                                    <i class="material-icons">delete</i>
                                                </button>
                                            </a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </c:otherwise>
                        </c:choose>
                    </tbody>
                </table>
            </div>
        </div>
        <div>
            <p>
                <a href="StudentController?report=true">
                    Show Student Report
                </a>
            </p>
        </div>
    </body>
</html>
