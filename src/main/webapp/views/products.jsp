<%--
  Created by IntelliJ IDEA.
  User: oem
  Date: 10.11.18
  Time: 23:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${products}" var="product">
    <p> ${product.quantity} ${product.product.name} ${product.product.price} </p>
</c:forEach>
</body>
</html>