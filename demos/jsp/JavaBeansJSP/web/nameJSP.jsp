<%-- 
    Document   : nameJSP
    Created on : Sep 16, 2019, 2:51:07 PM
    Author     : Administrator
--%>

<%@page import="ca.sait.itsd.NameBean" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Name JSP using JavaBeans</h1>
        <form action="nameJSP.jsp" method="GET">
            <div>
                <label for="">Enter name</label>
                <input type="text" name="name" id="">
            </div>
            <button type="submit">Go</button>
        </form>

        <%-- Page scope --%>
        <%
            NameBean name = new NameBean(request.getParameter("name"));
            out.println("Name: " + name.getName() + "<br>"
                    + " Name old: " + name.getNameOld());
        %>

        <%-- Session scope --%>
        <jsp:useBean
            id="otherBean"
            class="ca.sait.itsd.NameBean"
            scope="session"
            />
        <jsp:setProperty
            name="otherBean"
            property="name"
            value="${param.name}"
            />
        
        <p>
            OtherBean name: ${otherBean.name}
            <br>
            OtherBean name old: ${otherBean.nameOld}
        </p>
    </body>
</html>
