<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="../css/main.css" rel="stylesheet" type="text/css">
    <title>Редагування</title>
</head>
<body>
<%@include file="header.jsp"%>
<h1 class="gg">Внесіть зміни</h1>
<p class="gg">ЗВЕРНІТЬ УВАГУ!!! Всі задачі повинні мати різний пріоритет!</p>
<div>
    <form class="add">
        <input type="hidden" name="taskId" value="${task.getTaskId()}">
        <div class="group">
            <%--@declare id="text"--%><label for="text"><b class="text-task">Задача: </b></label><br>
            <textarea name="text" cols="140" rows="6">${task.getText()}</textarea>
        </div>
        <div class="group">
            <label><b class="text-task">Пріоритет: </b>
                <input class="input-form" type="number" min="1" name="newPriority" value="${task.getPriority()}"><br />
            </label>
        </div>
        <br>
        <div class="button-submit">
            <button class="add-task" type="submit">Зберегти</button>
        </div>
    </form>
</div>

<div class="right">
    <a href="task?taskId=${task.getTaskId()}" class="add-task">Повернутись назад &#8617</a>
</div>
</body>
</html>
