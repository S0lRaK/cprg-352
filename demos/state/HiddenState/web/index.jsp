<%-- 
    Document   : index
    Created on : Sep 24, 2019, 3:01:33 PM
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
        <h1>State using Hidden Fields</h1>
        <form action="HiddenStateController" method="POST">
            <div>
                <label for="inputWord">
                    Enter word:
                </label>
                <input type="text" name="word" id="inputWord">
                <input type="hidden" name="wordList" value="${param.wordList}">
            </div>
            <button type="submit">
                Add
            </button>
        </form>
        <div>
            <h2>Word List</h2> 
            <p>
                ${param.wordList}
            </p>
        </div>
    </body>
</html>
