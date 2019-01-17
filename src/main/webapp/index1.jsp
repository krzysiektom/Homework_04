<%--
  Created by IntelliJ IDEA.
  User: krzysztof
  Date: 17.01.19
  Time: 21:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>index1.jsp</title>
</head>
<body>
<c:if test="${ not empty param.author}">
    <p>Wybrany autor ${param.author}</p>
</c:if>
</body>
</html>
