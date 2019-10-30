<%-- 
    Document   : index
    Created on : Oct 17, 2019, 9:15:25 AM
    Author     : Carlos J. Garcia Carmona <carlos.garciacarmona@edu.sait.ca>
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Manage Notes</h1>
        <div>
            <h2>Add Note</h2>
            <form action="DBcontroller" method="GET">
                <div>
                    <label for="inputNote">Enter note:</label>
                    <input type="text" id="inputNote" name="note">
                </div>
                <button type="submit" name="add">Add</button>
            </form>
        </div>
        <div>
            <h2>Note List</h2>
            <div>
                <table>
                    <thead>
                        <tr>
                            <th>Note Text</th>
                            <th>Date/Time</th>
                            <th>Delete</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="note" items="${requestScope.notes}">
                            <tr>
                                <td>${note.text}</td>
                                <td>${note.dateTime}</td>
                                <td>
                                    <a href="DBcontroller?delete=${note.id}">Delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
