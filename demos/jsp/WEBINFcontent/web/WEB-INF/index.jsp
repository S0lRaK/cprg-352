<%-- 
    Document   : index
    Created on : Sep 17, 2019, 2:51:27 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>WEB-INF Login Page</h1>
        <form action="WebInfController" method="POST">
            <div>
                <label for="inputUsername">Username:</label>
                <input type="text" name="username" id="inputUsername">
            </div>
            <div>
                <label for="inputPassword">Password:</label>
                <input type="password" name="password" id="inputPassword">
            </div>
            <button type="submit">Login</button>
        </form>
        ${requestScope.message}
    </body>
</html>
