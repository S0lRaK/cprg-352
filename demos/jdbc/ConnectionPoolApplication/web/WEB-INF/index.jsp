<%-- 
    Document   : index
    Created on : Oct 21, 2019, 2:18:23 PM
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
        <h1>Connection Pool Application!</h1>
        <div>
            <h2>Usernames in Database</h2>
            <c:forTokens var="user" delims="," items="${requestScope.users}">
                ${user}<br>
            </c:forTokens>
        </div>
    </body>
</html>
