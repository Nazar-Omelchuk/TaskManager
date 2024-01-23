<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="../css/main.css" rel="stylesheet" type="text/css">
    <title>Нова задача</title>
</head>
<body>
<%@include file="header.jsp"%>

<header>
    <h1 class="gg">Нова задача</h1>
</header>
<p><c:out value="${text}" /></p>
<div class="gg">
    <form class="add">
        <div class="group">
            <%--@declare id="text"--%><label for="text"><b class="text-task">Задача: </b></label><br>
            <textarea name="text" cols="140" rows="6"></textarea>
        </div>
        <div class="group">
            <label><b class="text-task">Пріоритет: </b>
                <input class="input-form" type="number" min="1" name="priority"><br />
            </label>
        </div>
        <br>
        <div class="button-submit">
            <button class="add-task" type="submit">Створити</button>
        </div>
    </form>
</div>
</body>
</html>
