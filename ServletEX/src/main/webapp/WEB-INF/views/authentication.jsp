<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Authentication page</title>
</head>
<body>
    <form action='' method='POST'>
      <input type="text" name="soap">
      <input type="password" name="password">
      <input type="submit">
    </form>
    <c:if test="${not empty message}">
      <h3>${message}</h3>
    </c:if>
</body>
</html>
