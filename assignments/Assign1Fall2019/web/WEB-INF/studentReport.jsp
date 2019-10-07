<%-- 
    Author: Carlos J. Garcia Carmona
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean
    id="studentList"
    class="ca.sait.itsd.StudentList"
    scope="session"
    />
<jsp:useBean
    id="now"
    class="java.util.Date"
    />
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
        <h1>Student Report</h1>
        <div class="table-container">
            <table>
                <tr>
                    <th>Date/Time:</th>
                    <td>${now}</td>
                </tr>
                <tr>
                    <th>Number of students:</th>
                    <td>${studentList.numberOfStudents}</td>
                </tr>
            </table>
        </div>
        <h2>Student Information</h2>
        <div class="table-container">
            <table>
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>ID</th>
                        <th>Email</th>
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
                                </tr>
                            </c:forEach>
                        </c:otherwise>
                    </c:choose>
                </tbody>
            </table>
        </div>
        <div class="actions">
            <a href="" onclick="window.print()">
                <button class="action">
                    <i class="material-icons">print</i>
                    Print
                </button>
            </a>
            <a href="StudentController?back=true">
                <button class="action">
                    <i class="material-icons">arrow_back</i>
                    Back
                </button>
            </a>
        </div>
    </body>
</html>
