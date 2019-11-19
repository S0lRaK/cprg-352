<%-- 
    Document   : update
    Created on : Nov 12, 2019, 1:07:44 PM
    Author     : Carlos J. Garcia Carmona <carlos.garciacarmona@edu.sait.ca>
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>JSP Page</title>
	<c:set var="root" value="${pageContext.request.contextPath}" />
	<link
		href="https://fonts.googleapis.com/icon?family=Material+Icons"
		rel="stylesheet"
		/>
	<link rel="stylesheet" href="${root}/styles/index.css">
  </head>
  <body>
	<h1>Update Product - Assignment 2</h1>
	<form action="ProductController" method="POST">
	  <h2>Update Product</h2>
	  <div class="inputs">
		<div class="input">
		  <label for="inputDescription">
			Description:
		  </label>
		  <input id="inputDescription" name="description" type="text">
		</div>
		<div class="input">
		  <label for="inputUnitPrice">
			Unit Price:
		  </label>
		  <input id="inputUnitPrice" name="unitPrice" type="number"  placeholder="0.00" min="0" step="0.01">
		</div>
		<div class="input">
		  <label for="inputStockLevel">
			Stock Level:
		  </label>
		  <input id="inputStockLevel" name="stockLevel" type="number" placeholder="0" min="0" step="1">
		</div>
		<button type="submit" data-name="save" class="action">
		  Save <i class="material-icons">save</i>
		</button>
		<input type="hidden" name="action" value="save">
	  </div
	</form>
  </body>
</html>
