<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="../css/main.css" rel="stylesheet" type="text/css">
    <title>Задача з пріоритетом ${task.getPriority()}</title>
</head>
<body>
<%@include file="header.jsp"%>
<h1 class="gg">Загальна інформація</h1>
<div class="ggh">
    <p><b class="text-task">Задача: </b><em>${task.getText()}</em></p>
    <p><b class="text-task">Пріоритет: </b><c:out value="${task.getPriority()}"/></p>
    <p><b class="text-task">Дата створення: </b><fmt:formatDate pattern="dd.MM.yyyy hh:mm a" value="${task.getDate()}" /></p>
    <p><b class="text-task">Статус виконання: </b>
        <c:if test="${task.isCompleted()}">
            <span class="jjjn">Виконана &#10004</span>
        </c:if>
        <c:if test="${!(task.isCompleted())}">
            <span class="jjj">Не виконана &#10008</span>
        </c:if>
    </p>
</div>
<div class="gg">
    <a href="edit?taskId=${task.getTaskId()}&newPriority=${task.getPriority()}&text=${task.getText()}" class="button-edit">Редагувати &#9998</a>
    <a href="delete?taskId=${task.getTaskId()}" class="button-delete">Видалити &#10006</a>
</div>
</body>
</html>
