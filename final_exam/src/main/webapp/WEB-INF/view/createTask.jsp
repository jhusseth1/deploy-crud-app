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
    <title>Create task</title>
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
    <div class="row justify-content-between">
        <div class="col-6">
            <div class="mt-3">
                <strong><h2 class="title-welcome">Create a new task</h2></strong>
            </div>
        </div>
        <div class="col-6">
            <div class="mt-4 text-end">
                <a href="/tasks">back to tasks</a>
            </div>
        </div>
    </div>
    <div class="container-full mt-5">
        <div class="text-center flex justify-content-center align-content-center mx-auto">
            <c:if test="${errorSaved}">
                <div class="alert-error">
                    <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span>
                        ${errorMessage}
                </div>
            </c:if>
        </div>
        <form:form action="/tasks" method="POST" modelAttribute="task">
            <div class="col-7">
                <form:hidden path="creatorUserId" value="${user}"/>
            </div>
            <div class="form-group mt-3">
                <div class="row justify-content-evenly">
                    <div class="col-5">
                        <form:label path="name">Task</form:label>
                    </div>
                    <div class="col-7">
                        <form:input path="name"/>
                    </div>
                </div>
            </div>
            <div class="form-group mt-3">
                <div class="row justify-content-evenly">
                    <div class="col-5">
                        <label>Assignee</label>
                    </div>
                    <div class="col-7">
                        <form:select path="assigneeUserId" class="form-select">
                            <c:forEach items="${users}" var="assigneeUser">
                                <form:option value="${assigneeUser.id}"
                                             id="assigneeUserId">${assigneeUser.username}</form:option>
                            </c:forEach>
                        </form:select>
                    </div>
                </div>
            </div>
            <div class="form-group mt-3">
                <div class="row justify-content-evenly">
                    <div class="col-5">
                        <label>Priority</label>
                    </div>
                    <div class="col-7">
                        <form:select path="priorityId" class="form-select">
                            <c:forEach items="${priorities}" var="priority">
                                <form:option value="${priority.id}" id="priorityId">${priority.code}</form:option>
                            </c:forEach>
                        </form:select>
                    </div>
                </div>
            </div>
            <div class="container mt-5">
                <div class="text-end align-content-end justify-content-end">
                    <div class="row justify-content-end">
                        <div class="col-auto text-center">
                            <button class="btn btn-primary btn-actions" type="submit">Create</button>
                        </div>
                    </div>
                </div>
            </div>
        </form:form>
    </div>
</div>
</body>
</html>
