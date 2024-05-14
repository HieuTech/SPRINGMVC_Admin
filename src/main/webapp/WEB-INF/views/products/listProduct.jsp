<%@ page import="rikkei.ss20_addtocart_session.models.Users" %>
<%@ page import="rikkei.ss20_addtocart_session.dto.response.UserResponse" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hieuhoang
  Date: 13/05/2024
  Time: 09:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<h2>User Email: ${user.email}</h2>
<h2>Avatar: <img src="${user.avatar}" alt="avatar"></h2>
<p><i class="bi bi-cart-fill"></i> </p>

<h1 class="alert alert-primary">Danh sách Product</h1>
<a href="/Product/add" class="btn btn-info">Thêm mới</a>
<table class="table table-danger">
    <thead>
    <tr class="text-center">
        <th scope="col">#</th>
        <th scope="col">Name</th>
        <th scope="col">Category_id</th>
        <th scope="col">Price</th>
        <th scope="col">Stock</th>
        <th scope="col">Image</th>
        <th scope="col">Status</th>
        <th scope="col" colspan="2">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${productList}" var="product" varStatus="loop">
        <tr>
            <th scope="row">${loop.count}</th>
            <td>${product.name}</td>
            <td>${product.categoryId}</td>
            <td>${product.price}</td>
            <td>${product.stock}</td>
            <td><img src="${product.image}" alt="img" style="width: 50px"></td>
            <td>${product.status?"Active":"Inactive"}</td>
            <td><a href="/Product/edit/${product.id}" class="btn btn-warning"><i class="bi bi-pencil-square"></i></a></td>

            <td><a href="/Product/delete/${product.id}" class="btn btn-danger"><i class="bi bi-trash"></i></a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
