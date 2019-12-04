<%-- 
    Document   : Login
    Created on : Dec 4, 2019, 9:31:13 AM
    Author     : Carlos J. Garcia Carmona <carlos.garciacarmona@edu.sait.ca>
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Login</title>
	<c:set var="root" value="${pageContext.request.contextPath}" />
	<link
		href="https://fonts.googleapis.com/icon?family=Material+Icons"
		rel="stylesheet"
		/>
	<link rel="stylesheet" href="${root}/styles/shared.css">
  </head>
  <body>
	<h1>Order Application</h1>
	<form action="UserServices" method="GET">
	  <div>
		<div>
		  <label for="inputUsername">
			  Username
		  </label>
		  <input id="inputUsername" name="username" type="text">
		</div>
		<div>
		  <label for="inputPassword">
			  Password
		  </label>
		  <input id="inputPassword" name="password" type="password">
		</div>
	  </div>
	  <button type="submit">
		LOGIN
	  </button>
	</form>
	<p>
		${requestScope.message}
	</p>
	<div>
	  <p>
		<a href="UserServices?register=true">
			Register new Account
		</a>
	  </p>
	</div>
  </body>
</html>
