<%-- 
    Document   : runtime
    Created on : Sep 17, 2019, 2:26:56 PM
    Author     : Administrator
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
        <h1>JSP Includes Runtime</h1>
        <p>
            <!--JSTL-->
            <!--Convenction -> 'c' for 'core'-->
            <c:import url="file:///c:/users/administrator/file.txt"></c:import>
        </p>
        <a href="index.jsp">
            <button>Go to Index page</button>
        </a>
        <a href="page2.jsp">
            <button>Go to Page 2</button>
        </a>
    </body>
</html>
