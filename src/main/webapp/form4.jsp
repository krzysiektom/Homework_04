<%--
  Created by IntelliJ IDEA.
  User: krzysztof
  Date: 19.01.19
  Time: 00:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
    <title>guest-book</title>
</head>
<body>

<form action="/guest-book" method="post">

    <label>
        <input type="text" name="name" placeholder="Wpisz nazwę">
    </label>
    <label>
        <input type="text" name="text" placeholder="Wpisz opis">
    </label>
    <label>
        <input type="submit">
    </label>
</form>
<c:set var="num_guestBooks" value="${fn:length(guestBooks)}"/>
<c:forEach var="i" begin="1" end="${num_guestBooks}" step="1">
    <c:set var="guestBook" value="${guestBooks[num_guestBooks-i]}"/>
    <c:out value="${guestBook.name} ${guestBook.text}"/><br>
</c:forEach>

<%--
<c:forEach items="${guestBooks}" var="guestBook">
    <c:out value="${guestBook.name} ${guestBook.text}"/><br>
</c:forEach>
--%>
</body>
</html>
