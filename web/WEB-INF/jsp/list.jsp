<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="css/style.css">
    <title>Статистика по клиенту</title>
</head>
<body>
<jsp:include page="fragments/header.jsp"/>
<section>
    <form method="post" action="main">
        <table border="0" cellpadding="8" cellspacing="0">
            <tr>
                <th>Номер телефона:</th>
                <th><input type="text" name="phone" size=30></th>
                <th>
                    <button type="submit">Показать</button>
                    </a><br><br></th>
            </tr>
        </table>

        <table border="1" cellpadding="8" cellspacing="0">
            <tr>
                <th>Телефон</th>
                <th>Талон</th>
                <th>Время выдачи талона</th>
                <th>Начало приёма</th>
                <th>Конец приёма</th>
                <th>Сотрудник</th>
                <th>Вид услуги</th>
            </tr>
            <c:forEach items="${clientStat}" var="row">
                <jsp:useBean id="row" type="com.model.ClientStat"/>
                <tr>
                    <td>${row.phone}</td>
                    <td>${row.ticket}</td>
                    <td>${row.standTime}</td>
                    <td>${row.startTime}</td>
                    <td>${row.finishTime}</td>
                    <td>${row.serviceMan}</td>
                    <td>${row.service}</td>
                </tr>
            </c:forEach>
        </table>
    </form>
</section>
</body>
</html>
