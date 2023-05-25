<%--
  Created by IntelliJ IDEA.
  User: jhusseth
  Date: 28/02/23
  Time: 9:50 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
        <%@include file="../css/style.css" %>
    </style>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
            crossorigin="anonymous"></script>
</head>
<body>
<div class="container-full">
    <div>
        <strong><h1 class="text-start">Register</h1></strong>
    </div>
    <div class="text-center flex justify-content-center align-content-center mx-auto">
        <c:if test="${errorRegister}">
            <div class="alert-error">
                <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span>
                    ${errorMessage}
            </div>
        </c:if>
    </div>
    <form action="/register" method="POST">
        <div class="form-group mt-3">
            <div class="row justify-content-evenly">
                <div class="col-5">
                    <label for="username">Username:</label>
                </div>
                <div class="col-7">
                    <input type="text" class="form-control" name="username" id="username" placeholder="Enter username"
                           required>
                </div>
            </div>
        </div>
        <div class="form-group mt-3">
            <div class="row justify-content-evenly">
                <div class="col-5">
                    <label for="email">Email:</label>
                </div>
                <div class="col-7">
                    <input type="email" class="form-control" name="email" id="email" placeholder="Enter email" required>
                </div>
            </div>
        </div>
        <div class="form-group mt-3">
            <div class="row justify-content-evenly">
                <div class="col-5">
                    <label for="password">Password:</label>
                </div>
                <div class="col-7">
                    <input type="password" class="form-control" name="password" id="password" placeholder="Password"
                           required>
                </div>
            </div>
        </div>
        <div class="form-group mt-3">
            <div class="row justify-content-evenly">
                <div class="col-5">
                    <label for="confirmPassword">Confirm Password:</label>
                </div>
                <div class="col-7">
                    <input type="password" class="form-control" name="confirmPassword" id="confirmPassword"
                           placeholder="Confirm Password" required>
                </div>
            </div>
        </div>
        <div class="flex mt-3">
            <div class="justify-content-end align-content-end text-end">
                <button type="submit" class="btn btn-primary">Submit</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>
