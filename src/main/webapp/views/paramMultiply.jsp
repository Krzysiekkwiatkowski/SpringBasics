<%--
  Created by IntelliJ IDEA.
  User: oem
  Date: 10.11.18
  Time: 20:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <thead>
    <tr>
        <th scope="col"> x </th>
        <c:forEach begin="1" end="${cols}" varStatus="count">
            <th scope="row"> ${count.index} </th>
        </c:forEach>
    </tr>
    </thead>
    <tbody>
    <c:forEach begin="1" end="${rows}" varStatus="row">
        <tr scope="cols">
            <td>${row.index}</td>
            <c:forEach begin="1" end="${cols}" varStatus="col">
                <td>${col.index * row.index}</td>
            </c:forEach>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
