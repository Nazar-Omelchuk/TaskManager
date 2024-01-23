<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="../css/main.css" rel="stylesheet" type="text/css">
    <link href="../css/table.css" rel="stylesheet" type="text/css">
    <title>Планувальник задач онлайн</title>
</head>
<body>
<%@include file="header.jsp"%>
<header>
    <h1 class="head">Список всіх задач</h1>
</header>
<table width="90%" align="center">
    <div>
        <tr>
            <td>&nbsp</td>
            <td>Задача</td>
            <td><a href="main?sort=BY_PRIORITY">Пріоритет </a></td>
            <td><a href="main?sort=BY_DATE">Дата</a></td>
            <td>Статус</td>
        </tr>
    </div>
    <div>
        <c:if test="${!tasks.isEmpty()}">
            <c:forEach var="task" items="${tasks}">
                <tr>
                    <p>
                    <td class="f" bgcolor="#9d3834" width="20" title="Видалити"><a href="delete?taskId=${task.getTaskId()}">&#10006</a></td>
                    <td width="700" title="${task.getText()}">
                    <a href="task?taskId=${task.getTaskId()}">
                        <c:if test="${task.isCompleted()}">
                            <s>${task.getText()}</s></a>
                        </c:if>
                        <c:if test="${!(task.isCompleted())}">
                            <em>${task.getText()}</em></a>
                        </c:if>
                </td>
                    <td>${task.getPriority()}</td>
                    <td><fmt:formatDate pattern="dd.MM.yyyy hh:mm a" value="${task.getDate()}" /></td>
                    <c:if test="${task.isCompleted()}">
                        <td>Виконана &#10004</td></p>
                    </c:if>
                    <c:if test="${!(task.isCompleted())}">
                        <td>Не виконана &#10008</td>
                        <td bgcolor="#539d63"><a id="complete" href="completed?taskId=${task.getTaskId()}">Виконати</a></td></p>
                    </c:if>
                </tr>
            </c:forEach>
        </c:if>
        <c:if test="${tasks.isEmpty()}">
                <tr>
                    <td width="30"></td>
                    <td><p>Список задач порожній! &#9785 Ви можете додати нову задачу!</p></td>
                    <td><p></p></td>
                    <td><p></p></td>
                    <td><p></p></td>
                </tr>
        </c:if>
    </div>
</table>
<br>
<div class="f">
    <a href="add?text=0&priority=0" class="add-task">Додати задачу &#10010</a>
</div>
</body>
</html>