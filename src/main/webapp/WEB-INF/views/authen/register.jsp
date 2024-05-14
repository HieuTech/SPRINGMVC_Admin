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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<body>
<h1>REGISTER PAGE</h1>

<form method="post" action="/authen/register">
    <div class="input-group mb-3">
        <label>Email</label>
        <input type="text" class="form-control" placeholder="email" name="email">
    </div>
    <div class="input-group mb-3">
        <label>Password</label>
        <input type="text" class="form-control" placeholder="password" name="password">
    </div>
    <input type="submit" value="Register">
</form>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>

</body>
</html>
