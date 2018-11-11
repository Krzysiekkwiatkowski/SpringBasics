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
<c:if test="${not empty sum}">
<p> W koszyku jest ${size} pozycji. </p>
<p> W koszyku jest ${sum} produktów. </p>
<p> Wartość koszyka to: ${total}. </p>
</c:if>
<c:if test="${empty sum}">
    Brak produktów w koszyku!
</c:if>
</body>
</html>