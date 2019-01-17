<%--
  Created by IntelliJ IDEA.
  User: krzysztof
  Date: 17.01.19
  Time: 22:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
    <title>index3.jsp</title>
</head>
<body>
<c:set var="someName" value="Witaj w coderslab."/>
<c:if test="${fn:contains(someName, 'coderslab')}">
    <p>OK</p>
</c:if>
</body>
</html>
