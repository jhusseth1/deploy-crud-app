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
    <title>Login & Register</title>
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
<div class="container mt-5">
    <div class="mt-4">
        <% if (request.getParameter("logout") != null) {
            out.println("<div class=\"alert alert-success\" role=\"alert\">\n" +
                    "  Logout successfully\n" +
                    "</div>\n");
        }
        %>
    </div>
</div>
<div class="container flex mt-5">
    <div class="row justify-content-between">
        <div class="col-6">
            <jsp:include page="registerUser.jsp">
                <jsp:param name="errorRegister" value="${errorRegister}"/>
                <jsp:param name="errorMessage" value="${errorMessage}"/>
            </jsp:include>
        </div>
        <div class="col-6">
            <jsp:include page="loginUser.jsp">
                <jsp:param name="errorLogin" value="${errorLogin}"/>
                <jsp:param name="errorMessage" value="${errorMessage}"/>
            </jsp:include>
        </div>
    </div>
</div>
</body>
</html>
