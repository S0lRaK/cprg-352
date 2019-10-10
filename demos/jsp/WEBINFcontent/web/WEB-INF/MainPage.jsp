<%-- 
    Document   : MainPage
    Created on : Sep 17, 2019, 2:58:59 PM
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
            Welcome, ${requestScope.username}
        </p>
    </body>
</html>
