<%-- 
    Document   : helloName
    Created on : Sep 16, 2019, 2:25:31 PM
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
        <h1>Hello Name JSP</h1>
        <p>
            1 + 1 = <% out.println(1+1); %><br>
            1 + 1 = <%= 1+1 %><br>
            1 + 1 = ${1+1}
        </p>
        <h2>JSP Scriptlet</h2>
        <p>
            Hello, <% out.println(request.getParameter("name")); %>
        </p>
        <h2>JSP Expression</h2>
        <p>
            Hello, <%= request.getParameter("name") %>
        </p>
        <h2>EL Expression</h2>
        <p>
            Hello, ${param.name}
        </p>
    </body>
</html>
