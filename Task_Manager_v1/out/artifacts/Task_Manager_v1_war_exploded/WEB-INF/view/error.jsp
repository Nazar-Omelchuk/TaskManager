<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="../css/main.css" rel="stylesheet" type="text/css">
    <title>Помилка</title>
</head>
<body>
<%@include file="header.jsp"%>
<div>
    <h1>Вибачте, сталася помилка!</h1>

    <h2><c:out value="${message}" /></h2>
</div>
</body>
</html>
