<%-- 
    Document   : login
    Created on : Sep 26, 2019, 8:43:08 AM
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
        <h1>Login</h1>
        <form action="sessionController" method="POST">
            <div>
                <label for="inputUsername">
                    Username:
                </label>
                <input type="text" name="username" id="inputUsername">
            </div>
            <div>
                <label for="inputPassword">
                    Password:
                </label>
                <input type="password" name="password" id="inputPassword">
            </div>
            <button type="submit">
                Login
            </button>
        </form>
        <div>
            <p>
                ${requestScope.message}
            </p>
        </div>
    </body>
</html>
