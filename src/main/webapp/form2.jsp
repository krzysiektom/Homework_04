<%--
  Created by IntelliJ IDEA.
  User: krzysztof
  Date: 18.01.19
  Time: 13:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Servlet_02</title>
</head>
<body>
<form action="/Servlet_02" method="post">
    Wybierz lotnisko wylotu:
    <select name="airportFrom">
        <c:forEach var="airport" items="${airports}">
            <option value=${airport.code}>${airport.name}</option>
        </c:forEach>
    </select>
    <br>
    Wybierz lotnisko przylotu:
    <select name="airportTo">
        <c:forEach var="airport" items="${airports}">
            <option value=${airport.code}>${airport.name}</option>
        </c:forEach>
    </select>
    <br>
    <label>Czas startu:
        <input type="datetime-local" name="localTime">
    </label>
    <br>
    <label>Długość lotu w godzinach:
        <input type="number" min="0" step="1" name="flightTime">
    </label>
    <br>
    <label>Cena lotu:
        <input type="number" min="0" step="0.01" name="price">
    </label>
    <br>
    <label>
        <input type="submit">
    </label>
</form>
</body>
</html>
