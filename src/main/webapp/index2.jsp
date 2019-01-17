<%--
  Created by IntelliJ IDEA.
  User: krzysztof
  Date: 17.01.19
  Time: 22:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>index2.jsp</title>
</head>
<body>
<c:forEach begin="2" end="10" step="2" varStatus="theCount">
    ${theCount.index}<br>
</c:forEach>

</body>
</html>
