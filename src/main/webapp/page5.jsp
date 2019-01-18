<%--
  Created by IntelliJ IDEA.
  User: krzysztof
  Date: 18.01.19
  Time: 23:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>history</title>
</head>
<body>
<c:if test="${empty pages}">
    <c:out value="Nie odwiedziłeś żadnej strony"/>
</c:if>
<c:if test="${not empty pages}">
    <c:out value="Odwiedzałeś:"/>
    <br>
    <c:forEach var="page" items="${pages}">
        ${page}
        <br>
    </c:forEach>
</c:if>

</body>
</html>
