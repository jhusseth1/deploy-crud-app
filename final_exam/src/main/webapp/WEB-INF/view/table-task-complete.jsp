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
    <title>task-complete</title>
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
    <table class="table table-bordered">
        <thead>
        <tr class="text-center">
            <th scope="col">Task</th>
            <th scope="col">Creator</th>
            <th scope="col">Priority</th>
            <th scope="col">Status</th>
        </tr>
        </thead>
        <tbody class="table-group-divider">
        <c:forEach items="${myTasks}" var="task">
            <tr class="text-center align-content-center justify-content-center">
                <td><a href="/tasks/${task.id}">${task.name}</a></td>
                <td>${task.creatorUsername}</td>
                <td>${task.priorityCode}</td>
                <c:if test="${task.complete}">
                    <td><span class="badge bg-success">Completada</span></td>
                </c:if>
                <c:if test="${!task.complete}">
                    <td><span class="badge bg-warning">Pendiente</span></td>
                </c:if>
            </tr>
        </c:forEach>
        </tbody>

    </table>
</div>
</body>
</html>