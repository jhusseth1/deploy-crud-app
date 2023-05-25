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
    <title>${task.name}</title>
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
                <strong><h1>Task ${task.name}</h1></strong>
            </div>
        </div>
        <div class="col-6">
            <div class="mt-4 text-end">
                <a href="/tasks">back to dashboard</a>
            </div>
        </div>
    </div>
    <div class="container-full mt-5">
        <div class="text-center flex justify-content-center align-content-center mx-auto">
            <c:if test="${error}">
                <div class="alert-error">
                    <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span>
                        ${errorMessage}
                </div>
            </c:if>
        </div>
        <div class="form-group mt-3">
            <div class="row justify-content-evenly">
                <div class="col-5">
                    <label>Creator:</label>
                </div>
                <div class="col-7">
                    <span>${task.creatorUsername}<span>
                </div>
            </div>
        </div>
        <div class="form-group mt-3">
            <div class="row justify-content-evenly">
                <div class="col-5">
                    <label>Assignee:</label>
                </div>
                <div class="col-7">
                    <span>${task.assigneeUsername}</span>
                </div>
            </div>
        </div>
        <div class="form-group mt-3">
            <div class="row justify-content-evenly">
                <div class="col-5">
                    <label>Priority:</label>
                </div>
                <div class="col-7">
                    <span>${task.priorityCode}</span>
                </div>
            </div>
        </div>
        <div class="form-group mt-3">
            <div class="row justify-content-evenly">
                <div class="col-5">
                    <label>Status</label>
                </div>
                <div class="col-7">
                    <c:if test="${task.complete==true}">
                        <span>Completa</span>
                    </c:if>
                    <c:if test="${task.complete==false}">
                        <span>Pendiente</span>
                    </c:if>
                </div>
            </div>
        </div>
        <div class="mt-5">
            <c:if test="${userId==task.creatorUserId && task.complete!=true}">
                <div class="container mt-3">
                    <div class="text-end align-content-end justify-content-end">
                        <div class="row justify-content-end">
                            <div class="col-auto text-center">
                                <div class="row">
                                    <div class="col-auto">
                                        <a class="btn btn-primary btn-actions btn-sm rounded-4"
                                           href="/tasks/${task.id}/edit"> Edit</a>
                                    </div>
                                    <div class="col-auto">
                                        <form action="/tasks/${task.id}/delete" method="POST">
                                            <input type="hidden" name="_method" value="DELETE">
                                            <input class="btn btn-danger btn-sm btn-actions rounded-4" type="submit"
                                                   value="delete" id="button_delete_submit">
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </c:if>
            <c:if test="${userId==task.assigneeUserId && task.complete!=true}">
                <div class="container mt-3">
                    <div class="text-end align-content-end justify-content-end">
                        <div class="row justify-content-end">
                            <div class="col-auto text-center">
                                <div class="row">

                                    <div class="col-auto">
                                        <form action="/tasks/${task.id}/complete" method="POST">
                                            <input class="btn btn-success btn-sm btn-actions rounded-4" type="submit"
                                                   value="complete" id="button_complete_submit">
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </c:if>
        </div>
    </div>
</div>
</body>
</html>
