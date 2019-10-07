<%-- 
    Document   : mainpage
    Created on : Sep 26, 2019, 8:43:37 AM
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
        <h1>Main Page</h1>
        <p>
            Welcome, ${sessionScope.username}
            <br>
            <a href="sessionController?logout=true">
                Logout
            </a>
        </p>
    </body>
</html>
