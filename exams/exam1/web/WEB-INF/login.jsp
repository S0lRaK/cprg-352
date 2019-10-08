<%-- 
    Document   : login
    Created on : Oct 7, 2019, 2:15:59 PM
    Author     : Carlos J. Garcia Carmona
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <h1>Exam1 - Login Page</h1>
        <form action="UserLogin" method="POST" id="login">
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
