<%-- 
    Document   : next
    Created on : Sep 30, 2019, 3:01:55 PM
    Author     : Administrator
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>JSTL Additional</h1>
        <div>
            <h2>JSTL Functions</h2>
            <p>
                word in upper case is ${fn:toUpperCase("word")}<br>
                a in pizza is found at position ${fn:indexOf("pizza","a")}<br>
                There are ${fn:length("apple")} characters in apple<br>

                <c:set var="name" value="alice"/>
                <c:if test="${fn:contains(name, 'ice')}">
                    alice contains "ice"
                </c:if>
            </p>
        </div>
        <div>
            <h2>JSTL Formatting</h2>
            <p>
                <jsp:useBean id="now" class="java.util.Date" />
                ${now}<br>
                Time: <fmt:formatDate type="time" value="${now}"/><br>
                Date: <fmt:formatDate type="date" value="${now}"/><br>
                Short style: <fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${now}"/>
            </p>
        </div>
        <div>
            <h2>JSTL SQL</h2>
            <sql:setDataSource
                var="db"
                driver="com.mysql.jdbc.Driver"
                url="jdbc:mysql://localhost:3306/users1"
                user="root"
                password="password"
                />
            <sql:query dataSource="${db}" var="resultSet">
                select * from users;
            </sql:query>
            <p>
                List of Users:
            <ol>
                <c:forEach var="row" items="${resultSet.rows}">
                    <li>${row.username}</li>
                </c:forEach>
            </ol>
        </p>
    </div>
</body>
</html>
