<%--
  Created by IntelliJ IDEA.
  User: hieuhoang
  Date: 13/05/2024
  Time: 09:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>
<h1>LOGIN PAGE</h1>
<form method="post" action="/authen/login" class="row g-3">
    <div class="input-group mb-3">
        <input type="text" class="form-control" placeholder="email" name="email">
    </div>
    <div class="input-group mb-3">
        <input type="text" class="form-control" placeholder="password" name="password">
    </div>
    <input type="submit" value="Login" >
</form>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

</body>
</html>
