<%--
  Created by IntelliJ IDEA.
  User: oem
  Date: 13.11.18
  Time: 18:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${not empty shopping}">
<table border="1 px solid black" style="text-align: center">
    <tr>
        <th> Product id </th>
        <th> Product </th>
        <th> Quantity </th>
        <th> Action </th>
    </tr>
    <c:forEach items="${shopping}" var="product">
        <tr>
            <td> ${product.product.id} </td>
            <td> ${product.product.name} </td>
            <td> ${product.quantity} </td>
            <td> <a href="http://localhost:8080/AddedCart/Add/${product.product.name}"> Add 1 </a> / <a href="http://localhost:8080/AddedCart/Subtract/${product.product.name}"> Subtract 1 </a> / <a href="http://localhost:8080/AddedCart/Delete/${product.product.name}"> Delete </a></td>
        </tr>
    </c:forEach>
</table>
</c:if>
<c:if test="${empty shopping}">
    Brak produktów w koszyku!
</c:if>
</body>
</html>
