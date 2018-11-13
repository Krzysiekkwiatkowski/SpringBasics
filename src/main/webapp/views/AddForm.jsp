<%--
  Created by IntelliJ IDEA.
  User: oem
  Date: 13.11.18
  Time: 18:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="http://localhost:8080/add" method="post">
Quantity: <input type="number" name="quantity"></br>
Product: <select name="name">
    <c:forEach items="${products}" var="product">
        <option value="${product.name}"> ${product.name} </option>
    </c:forEach>
</select></br>
<input type="submit" value="Add">
</form>
</body>
</html>
