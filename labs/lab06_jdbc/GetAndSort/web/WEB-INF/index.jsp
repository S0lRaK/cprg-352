<%-- 
    Document   : index
    Created on : Oct 15, 2019, 2:14:11 PM
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
        <h1>List Users</h1>
        <div>
            <h2>Sort Order</h2>
            <form action="DBcontroller" method="POST">
                <select name="order">
                    <option value="asc" selected>Ascending</option>
                    <option value="desc">Descending</option>
                </select>
                <button type="submit">Get Data</button>
            </form>
        </div>
        <div>
            <h2>User List</h2>
            <p>
                <c:forTokens var="user" delims="," items="${requestScope.users}">
                    ${user}<br>
                </c:forTokens>
            </p>
        </div>
    </body>
</html>
