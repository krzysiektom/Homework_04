<%--
  Created by IntelliJ IDEA.
  User: krzysztof
  Date: 18.01.19
  Time: 21:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>newsletter</title>
</head>
<body>
<a>
    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam semper gravida arcu, quis facilisis eros maximus id. Nunc a lorem ac mauris rutrum aliquam in nec tortor. Fusce rutrum efficitur est eget semper. Morbi vitae porta sapien, bibendum finibus odio. Pellentesque posuere porttitor metus ac tincidunt. Phasellus enim metus, auctor quis rutrum sed, euismod non libero. Pellentesque elementum eleifend finibus.
</a>
<br>
<c:if test="${!cookie.containsKey('visit')}">
    <form action="/newsletter" method="post">
        <b> Zapis się do newslettera.</b>
        <br>
        <label>
            <input type="email" name="email" placeholder="Adres email">
        </label>
        <br>
        <label>
            <input type="text" name="name" placeholder="Imię i nazwisko">
        </label>
        <br>
        <label>
            <input type="submit" value="Zapisz">
        </label>
    </form>
</c:if>
</body>
</html>
