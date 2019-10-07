<%-- 
    Document   : index
    Created on : Sep 16, 2019, 3:41:46 PM
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
        <%@include file="includes/header.html" %>
        <h1>JSP Includes Main Page</h1>
        <p>
            This is the body of the page.
        </p>
        <a href="page2.jsp">
            <button>Go to Page 2</button>
        </a>
        <%@include file="includes/footer.jspf" %>
    </body>
</html>
