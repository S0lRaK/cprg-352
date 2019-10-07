<%-- 
    Document   : index
    Created on : Sep 19, 2019, 8:24:17 AM
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
        <h1>Simple JSP Calculator</h1>
        <form action="index.jsp" method="GET">
            <div>
                <label for="inputFirstNum">
                    First:
                </label>
                <input type="number" name="firstNum" id="inputFirstNum">
            </div>
            <div>
                <label for="inputSecondNum">
                    Second:
                </label>
                <input type="number" name="secondNum" id="inputSecondNum">
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
        <%
            String firstNum = request.getParameter("firstNum");
            String secondNum = request.getParameter("secondNum");
            String operation = request.getParameter("operation");
            String result="";
            if (firstNum == null || secondNum == null || firstNum.equals("") || secondNum.equals("")) {
                result = "---";
            } else if (operation != null) {
                switch (operation) {
                    case "sum":
                        result = Integer.toString(Integer.parseInt(firstNum) + Integer.parseInt(secondNum));
                        break;
                    case "substraction":
                        if (Integer.parseInt(firstNum) < Integer.parseInt(secondNum)) {
                            result = "For substraction, the first number cannot be smaller than the second.";
                        } else {
                            result = Integer.toString(Integer.parseInt(firstNum) - Integer.parseInt(secondNum));
                        }
                        break;
                    case "multiplication":
                        result = Integer.toString(Integer.parseInt(firstNum) * Integer.parseInt(secondNum));
                        break;
                    case "modulus":
                        if (Integer.parseInt(firstNum) < Integer.parseInt(secondNum)) {
                            result = "For modulus, the first number cannot be smaller than the second.";
                        } else {
                            result = Float.toString(Float.parseFloat(firstNum) % Float.parseFloat(secondNum));
                        }
                        break;
                }
            }
        %>
        <div>
            <p>
                RESULT: <br>
                ${result}<br>
                <%  out.println(result); %><br>
                <%= result %>
            </p>
        </div>
    </body>
</html>
