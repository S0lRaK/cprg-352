<%-- 
    Document   : otherPage
    Created on : Sep 17, 2019, 2:22:40 PM
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
<!--        Compile include-->
        <%@include file="includes/header.html" %>
        <h1>JSP Page 2</h1>
        <p>
            This is the body of the page.
        </p>
        <a href="index.jsp">
            <button>Go to Index page</button>
        </a>
        <a href="runtime.jsp">
            <button>Go to Runtime page</button>
        </a>
        <%@include file="includes/footer.jspf" %>
    </body>
</html>
