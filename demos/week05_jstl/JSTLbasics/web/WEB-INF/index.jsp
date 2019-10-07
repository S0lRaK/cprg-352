<%-- 
    Document   : index
    Created on : Sep 30, 2019, 3:01:47 PM
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
        <h1>JSTL Basics</h1>
        <div>
            <h2>Functions</h2>
            <a href="JSTLbasicsController?next=true">
                Next
            </a>
        </div>
        <div>
            <h2>out</h2>
            <p>
                <c:out value="Hello world<br>"/>
                Next line 1
            </p>
            <p>
                <c:out value="Hello world<br>" escapeXml="false"></c:out>
                    Next line 2
                </p>
            </div>
            <div>
                <h2>set</h2>
                <p>
                <c:set var="username" value="alice" scope="page"/>
                <c:out value="The username is ${username}<br>" escapeXml="false"/>
            </p>
        </div>
        <div>
            <h2>forEach loop</h2>
            <div>
                <p>
                    Count from 1 to 10:
                </p>
                <ol>
                    <c:forEach var="index" begin="1" end="10" step="1">
                        <li>${index}</li>
                        </c:forEach>
                </ol>
            </div>
            <div>
                <p>
                    Count from 10 to 1:
                </p>
                <ol>
                    <c:forEach var="index" begin="0" end="9" step="1">
                        <li>${10-index}</li>
                        </c:forEach>
                </ol>
            </div>
            <div>
                <p>
                    Iterate through String Array:
                </p>
                <ol>
                    <c:forEach var="name" items="${names}">
                        <li>${name}</li>
                        </c:forEach>
                </ol>
            </div>
            <div>
                <p>
                    Iterate through Object Array:
                </p>
                <ol>
                    <c:forEach var="user" items="${users}">
                        <li>${user.username}</li>
                        </c:forEach>
                </ol>
            </div>
        </div>
        <div>
            <h2>forTokens loop</h2>
            <p>
                Iterate through a comma-separated list:
            </p>
            <ol>
                <c:forTokens var="name" delims="," items="alice,bob,charlie,,derek">
                    <li>${name}</li>
                    </c:forTokens>
            </ol>
        </div>
        <div>
            <h2>if</h2>
            <c:set var="x" value="5"/>
            <c:if test="${x gt 0}">
                <p>
                    <i>x</i> is greater than 0
                </p>
            </c:if>
        </div>
        <div>
            <h2>if...else</h2>
            <c:choose>
                <c:when test="${x lt 5}">
                    <p>
                        <i>x</i> is less than 5
                    </p>
                </c:when>
                <c:when test="${x eq 5}">
                    <p>
                        <i>x</i> equals 5
                    </p>
                </c:when>
                <c:when test="${x gt 5}">
                    <p>
                        <i>x</i> is greater than 5
                    </p>
                </c:when>
                <c:otherwise>
                    <p>
                        <i>x</i> is... something?
                    </p>
                </c:otherwise>
            </c:choose>
        </div>
        <div>
            <h2>Show all Headers</h2>
            <ol>
                <c:forEach var="nextHeader" items="${header}">
                    <li>${nextHeader.key} = ${nextHeader.value}</li>
                </c:forEach>
            </ol>
        </div>
    </body>
</html>
