<%-- 
    Document   : index
    Created on : Oct 8, 2019, 2:15:30 PM
    Author     : Carlos J. Garcia Carmona
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
        <h1>JDBC Application</h1>
        <div>
            <h2>Usernames in Database</h2>
            <p>
                <c:forTokens var="username" delims="," items="${requestScope.namesList}">
                    ${username}<br>
                </c:forTokens>
                <b>${requestScope.message}</b>
            </p>
        </div>
        <div>
            <form action="JDBCcontroller" method="GET">
                <h2>Add Username</h2>
                <div>
                    <label for="inputUsername">Enter username:</label>
                    <input type="hidden" name="action" value="add">
                    <input type="text" name="username" id="inputUsername">
                </div>
                <button type="submit">Add</button>
            </form>
            <form action="JDBCcontroller" method="GET">
                <h2>Delete Username</h2>
                <div>
                    <label for="inputUsername">Enter username:</label>
                    <input type="hidden" name="action" value="delete">
                    <input type="text" name="username" id="inputUsername">
                </div>
                <button type="submit">Delete</button>
            </form>
            <form action="JDBCcontroller" method="GET">
                <h2>Update Username</h2>
                <div>
                    <div>
                        <label for="inputUsername">Enter username:</label>
                        <input type="text" name="username" id="inputUsername">
                    </div>
                    <div>
                        <label for="inputNewUsername">Enter new username:</label>
                        <input type="text" name="newUsername" id="inputNewUsername">
                    </div>
                    <input type="hidden" name="action" value="update">
                </div>
                <button type="submit">Update</button>
            </form>
        </div>
    </div>
</body>
</html>
