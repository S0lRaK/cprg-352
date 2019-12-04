<%-- 
    Document   : index
    Created on : Nov 12, 2019, 5:13:23 AM
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
	<h1>Manage Products - Assignment 2</h1>
	<div>
	  <p>
		<a href="ProductController?report=true">
		  Report
		</a>
	  </p>
	</div>
	<form action="ProductController" method="GET">
	  <h2>
		Add Product
	  </h2>
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
		<button type="submit" data-name="add" class="action">
		  ADD <i class="material-icons">add</i>
		</button>
		<input type="hidden" name="action" value="add">
		<h3>${requestScope.message}</h3>
	  </div>
	</form>
	<div>
	  <h2>
		Product List
	  </h2>
	  <div class="table-container">
		<table>
		  <thead>
			<tr>
			  <th>Product</th>
			  <th>Unit Price</th>
			  <th>Stock Level</th>
			  <th>Delete</th>
			  <th>Update</th>
			</tr>
		  </thead>
		  <tbody>
			<c:set var="totalInventoryValue"/>
			<c:set var="index" value="0"/>
			<c:forEach var="product" items="${requestScope.productList}">
				<c:set var="totalInventoryValue"
					   value="${totalInventoryValue + (product.productUnitPrice * product.productStockLevel)}"/>
				<tr>
				  <td>${product.productDescription}</td>
				  <td>${product.productUnitPrice}</td>
				  <td>${product.productStockLevel}</td>
				  <td class="delete-cell">
					<a href="ProductController?action=delete&id=${product.productID}">
					  <button data-name="delete">
						<i class="material-icons">delete</i>
					  </button>
					</a>
				  </td>
				  <td class="update-cell">
					<a href="ProductController?action=update&id=${product.productID}&index=${index}">
					  <button data-name="update">
						<i class="material-icons">edit</i>
					  </button>
					</a>
				  </td>
				</tr>
				<c:set var="index" value="${index + 1}"/>
			</c:forEach>
		  </tbody>
		  <tfoot>
			<tr>
			  <th colspan="5">
				Total Inventory Value: $${totalInventoryValue}
			  </th>
			</tr>
		  </tfoot>
		</table>
	  </div>
	</div>
  </body>
</html>
