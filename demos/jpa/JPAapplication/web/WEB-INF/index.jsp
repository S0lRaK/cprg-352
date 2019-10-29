<%-- 
    Document   : index
    Created on : Oct 28, 2019, 2:20:32 PM
    Author     : Carlos J. Garcia Carmona <carlos.garciacarmona@edu.sait.ca>
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>JPA Application</h1>
        <div>
            <h2>Usernames in Database</h2>
            <c:forTokens var="username" delims="," items="${requestScope.namesList}">
                ${username}<br>
            </c:forTokens>
            <h3>${requestScope.message}</h3>
        </div>
        <div>
            <h2>Add Username</h2>
            <form action="JPAcontroller" method="POST">
                <div>
                    <label for="inputUsername">Enter username:</label>
                    <input type="text" id="inputUsername" name="username">
                </div>
                <input type="hidden" name="action" value="add">
                <button type="submit">Add</button>
            </form>
        </div>
        <div>
            <h2>Delete Username</h2>
            <form action="JPAcontroller" method="POST">
                <div>
                    <label for="inputUsername">Enter username:</label>
                    <input type="text" id="inputUsername" name="username">
                </div>
                <input type="hidden" name="action" value="delete">
                <button type="submit">Delete</button>
            </form>
        </div>
        <div>
            <h2>Update Username</h2>
            <form action="JPAcontroller" method="POST">
                <div>
                    <label for="inputUsername">Enter username:</label>
                    <input type="text" id="inputUsername" name="username">
                </div>
                <div>
                    <label for="inputNewUsername">Update to:</label>
                    <input type="text" id="inputNewUsername" name="newUsername">
                </div>
                <input type="hidden" name="action" value="update">
                <button type="submit">Update</button>
            </form>
        </div>
    </body>
</html>
