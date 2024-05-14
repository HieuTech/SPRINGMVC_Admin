<%--
  Created by IntelliJ IDEA.
  User: hieuhoang
  Date: 13/05/2024
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>
<h1 class="text-center">Create Product</h1>
<form class="row g-3" action="/Products/add" method="post">


    <div class="col-12">
        <label for="inputName" class="form-label">Name</label>
        <input type="text" class="form-control" name="name" id="inputName"  placeholder="Product Name">
    </div>
    <div class="col-12">
        <label for="CategoryId" class="form-label">Category Id</label>
        <input type="text" class="form-control" name="category_id" id="CategoryId"  placeholder="Product Category Id">
    </div>
    <div class="col-12">
        <label for="price" class="form-label">Price</label>
        <input type="text" class="form-control" name="price" id="price"  placeholder="Product Price">
    </div>
    <div class="col-12">
        <label for="stock" class="form-label">Stock</label>
        <input type="text" class="form-control" name="stock" id="stock"  placeholder="Product Stock">
    </div>
    <div class="col-12">
        <label for="totalPage" class="form-label">total Pages</label>
        <input type="text" class="form-control" name="totalPages" id="totalPage"  placeholder="Product Total Pages">
    </div>
    <div class="col-12">
        <label for="yearCreated" class="form-label">Year Created</label>
        <input type="text" class="form-control" name="yearCreated" id="yearCreated" placeholder="Product year">
    </div>

    <div class="col-md-4">
        <label for="inputState" class="form-label">Status</label>
        <select id="inputState" name="sex" class="form-select">
            <option selected value="1">Active</option>
            <option value="0">Inactive</option>
        </select>
    </div>
    <div class="col-12">
        <input type="submit" class="btn btn-primary" value="Add"/>
    </div>
</form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
