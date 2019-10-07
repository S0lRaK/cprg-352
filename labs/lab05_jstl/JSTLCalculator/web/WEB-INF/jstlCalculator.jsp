<%-- 
    Document   : jstlCalculator
    Created on : Oct 1, 2019, 3:23:39 PM
    Author     : Administrator
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>

    <h1>JSTL Calculator</h1>
    <form action="Controller" method="POST">
        <div>
            <div>
                <label for="inputFirstNum">
                    First number:
                </label>
                <input type="number" id="inputFirstNum" name="firstNum" required>
            </div>
            <div>
                <label for="inputSecondNum">
                    Second number:
                </label>
                <input type="number" id="inputSecondNum" name="secondNum" required>
            </div>
        </div>
        <div>
            <button type="submit" name="operation" value="sum">
                +
            </button>
            <button type="submit" name="operation" value="substraction">
                -
            </button>
            <button type="submit" name="operation" value="multiplication">
                *
            </button>
            <button type="submit" name="operation" value="modulus">
                %
            </button>
        </div>
    </form>
    <c:set var="num1" value="${param.firstNum}" />
    <c:set var="num2" value="${param.secondNum}" />
    <c:set var="operation" value="${param.operation}" />

    <c:choose>
        <c:when test="${num1 eq null || num2 eq null}">
            <c:set var="result" value="--" />
        </c:when>
        <c:otherwise>
            <c:if test="${operation eq 'sum'}">
                <c:set var="result" value="${num1 + num2}" />
            </c:if>
            <c:if test="${operation eq 'substraction'}">
                <c:set var="result" value="${num1 - num2}" />
            </c:if>
            <c:if test="${operation eq 'multiplication'}">
                <c:set var="result" value="${num1 * num2}" />
            </c:if>
            <c:if test="${operation eq 'modulus'}">
                <c:set var="result" value="${num2 eq 0 ? 'Cannot divide by zero' : (num1 % num2)}" />
            </c:if>
        </c:otherwise>
    </c:choose>
    <div>
        <p>
            RESULT: ${result}
        </p>
    </div>

</html>
