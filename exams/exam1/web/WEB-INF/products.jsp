<%-- 
    Document   : products
    Created on : Oct 7, 2019, 2:20:45 PM
    Author     : Carlos J. Garcia Carmona
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://fonts.googleapis.com/css?family=Bungee+Shade|Roboto:400,700" rel="stylesheet">
        <link
            href="https://fonts.googleapis.com/icon?family=Material+Icons"
            rel="stylesheet"
            />
        <link rel="stylesheet" href="styles/index.css">
    </head>
    <body>
        <h1>Exam 1 - Products</h1>
        <p>
            Welcome, ${sessionScope.username}
            <br>
            <a href="UserLogin?logout=true">
                Logout
            </a>
        </p>
        <form action="ProductOperations" method="POST">
            <h2>
                Add Product
            </h2>
            <div class="inputs">
                <div class="input">
                    <label for="inputName">
                        Name:
                    </label>
                    <input id="inputName" name="name" type="text" required>
                </div>
                <div class="input">
                    <label for="inputCost">
                        Unit cost:
                    </label>
                    <input id="inputCost" name="cost" type="number" min="0" step="0.01" required>
                </div>
                <div class="input">
                    <label for="inputStock">
                        Stock:
                    </label>
                    <input id="inputStock" name="stock" type="number" min="0" step="1" required>
                </div>
                <button type="submit" name="add" class="action">
                    Add <i class="material-icons">add</i>
                </button>
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
                            <th>Name</th>
                            <th>Unit Cost</th>
                            <th>Number in Stock</th>
                            <th>Total Value in Stock</th>
                            <th>Delete</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:choose>
                            <c:when test="${sessionScope.products.size() eq 0}">
                                <tr>
                                    <td class="no-data" colspan="4">No product data available</td>
                                </tr>
                            </c:when>
                            <c:otherwise>
                                <c:forEach var="product" items="${sessionScope.products}">
                                    <tr>
                                        <td>${product.name}</td>
                                        <td><fmt:formatNumber value="${product.productUnitCost}" type="currency"/></td>
                                        <td>${product.productNumberInStock}</td>
                                        <td><fmt:formatNumber value="${product.calcTotalValueInStock(product.productNumberInStock, product.productUnitCost)}" type="currency"/></td>
                                        <td class="delete-cell">
                                            <a href="ProductOperations?delete=${sessionScope.products.indexOf(product)}">
                                                <button name="delete">
                                                    <i class="material-icons">delete</i>
                                                </button>
                                            </a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </c:otherwise>
                        </c:choose>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
