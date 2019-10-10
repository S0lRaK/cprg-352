<%-- 
    Document   : mainPage
    Created on : Sep 23, 2019, 2:32:51 PM
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
        <div>
            <h1>Session State Main Page</h1>
            <p>
                Welcome, ${sessionScope.username}
            </p>            
            <a href="SessionStateController?logout=true">
                <button>
                    Logout
                </button>
            </a>
        </div>
        <div>
            <h2>
                Add Word
            </h2>
            <form action="SessionStateController" method="POSt">
                <div>
                    <label for="inputWord">
                        Enter word:
                    </label>
                    <input type="text" id="inputWord" name="word">
                </div>
                <button type="submit">
                    Add
                </button>
            </form>
        </div>
        <div>
            <h2>
                Word List
            </h2>
            <ul>
                <c:forEach var="word" items="${sessionScope.words}">
                    <li>
                        ${word}
                    </li>
                </c:forEach>
            </ul>
        </div>
    </body>
</html>
