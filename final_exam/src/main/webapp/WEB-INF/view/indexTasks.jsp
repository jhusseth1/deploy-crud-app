<%--
  Created by IntelliJ IDEA.
  User: jhusseth
  Date: 28/02/23
  Time: 9:18 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Projects</title>
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
<div class="container">
    <div class="row justify-content-between">
        <div class="col-4">
            <div class="mt-3 text-start">
                <strong><h2 class="title-welcome"> Welcome, ${param.username}!</h2></strong>
            </div>
        </div>
        <div class="col-8">
            <div class="row justify-content-end">
                <div class="col-4">
                    <div class="mt-4 text-end">
                        <a href="/tasks?order=1">Priority High-Low</a>
                    </div>
                </div>
                <div class="col-4">
                    <div class="mt-4 text-end">
                        <a href="/tasks?order=2">Priority Low-High</a>
                    </div>
                </div>
                <div class="col-4">
                    <div class="mt-4 text-end">
                        <a href="/logout">logout</a>
                    </div>
                </div>
            </div>
        </div>

    </div>
    <div class="mt-4">
        <jsp:include page="table.jsp"></jsp:include>
    </div>
    <div class="mt-5">
        <div class="mt-4">
            <h3>Mis tareas</h3>
        </div>
        <div class="text-end">
            <div class="mt-4 text-end">
                <a href="/tasks/new" class="btn btn btn-primary btn-sm rounded-4">Create Task</a>
            </div>
        </div>
        <div class="mt-3">
            <jsp:include page="table-task-complete.jsp"></jsp:include>
        </div>
    </div>
</div>
</body>
</html>
