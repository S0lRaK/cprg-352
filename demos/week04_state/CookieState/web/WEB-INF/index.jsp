<%-- 
    Document   : index
    Created on : Sep 23, 2019, 3:40:34 PM
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
        <h1>Cookie State Login Page</h1>
        <form action="CookieStateController" method="POST">
            <div>
                <label for="inputUsername">
                    Username:
                </label>
                <input
                    type="text"
                    name="username"
                    id="inputUsername"
                    value="${! empty cookie.username.value ? cookie.username.value : ''}">
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
            <div>
                <input
                    type="checkbox"
                    name="remember"
                    id="inputRemember"
                    ${cookie.remember.value != null ? 'checked' : ''}>
                <label for="inputRemember">
                    Remember me
                </label>
            </div>
        </form>
        <div>
            <p>
                ${requestScope.message}
            </p>
        </div>
    </body>
</html>
