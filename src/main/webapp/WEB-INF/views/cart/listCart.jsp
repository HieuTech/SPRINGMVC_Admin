<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hieuhoang
  Date: 14/05/2024
  Time: 08:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="">
    <ul>
        <c:forEach items="${cartList}" var="cartItem">
            <li>${}</li>
        </c:forEach>
    </ul>
</div>

</body>
</html>
