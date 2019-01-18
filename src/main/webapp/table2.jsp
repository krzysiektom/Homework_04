<%--
  Created by IntelliJ IDEA.
  User: krzysztof
  Date: 18.01.19
  Time: 19:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<html>
<head>
    <title>Servlet_02</title>
</head>
<body>
<table>
    <tr>
        <th>Lotnisko wylotu, czas wylotu i kod lotniska</th>
        <th>Lotnisko przylotu, czas przylotu i kod lotniska</th>
        <th>Czas lotu</th>
        <th>Cena lotu</th>
    </tr>
    <tr>
        <c:forEach items="${airports}" var="airport">
            <c:if test="${flight.departure eq airport.code}">
                <th>${airport.name}
                    <br>
                        ${ldt}
                    <br>
                        ${flight.departure}
                </th>
            </c:if>
        </c:forEach>
        <c:forEach items="${airports}" var="airport">
            <c:if test="${flight.arrival eq airport.code}">
                <th>${airport.name}
                    <br>
                        ${flight.arrivalTime}
                    <br>
                        ${flight.arrival}
                </th>
            </c:if>
        </c:forEach>
        <th>${flightTime}</th>
        <th>${flight.price}</th>
    </tr>
</table>
</body>
</html>
