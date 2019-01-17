<%--
  Created by IntelliJ IDEA.
  User: krzysztof
  Date: 17.01.19
  Time: 22:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Servlet_01_1</title>
</head>
<body>
<c:out value="${cookie.language.value}" default="Cześć"/>
<form action="/Servlet_01_2" method="post">
    Wybierz język:
    <select name="lang">
        <c:forEach var="lang" items="${lang}">
            <option value=${lang.key}>${lang.key}</option>
        </c:forEach>
    </select>
    <label>
        <input type="submit">
    </label>
</form>
</body>
</html>
