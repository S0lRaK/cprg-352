<%-- 
    Document   : index
    Created on : Sep 30, 2019, 2:31:38 PM
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
        <h1>EL Basics</h1>
        <div>
            <h2>Math Ops</h2>
            <p>
                ${1+1}<br>
                ${10.9+1.35}<br>
                ${1/4}<br>
                ${1 div 4}
            </p>
        </div>
        <div>
            <h2>Relational Ops</h2>
            <p>
                ${1==1}<br>
                ${1 eq 1}<br>
                ${2 != 1}<br>
                ${2 ne 1}<br>
                ${4 < 3}<br>
                ${4 lt 3}<br>
                ${4 gt 3}
            </p>
        </div>
        <div>
            <h2>Logical Ops</h2>
            <p>
                ${true && true}<br>
                ${true and rue}<br>
            </p>
        </div>
        <div>
            <h2>Access Object Data</h2>
            <p>
                User name is ${user.username}<br>
                User name is ${applicationScope.user.username}
            </p>
        </div>
        <div>
            <h2>Access Array Data</h2>
            <p>
                First name is ${names[0]}<br>
                Second name is ${names[1]}
            </p>
        </div>
        <div>
            <h2>Access Object Array Data</h2>
            <p>
                First name in array of Users is ${users[0].username}<br>
                Second name in array of Users is ${users[1].username}
            </p>
        </div>
    </body>
</html>
