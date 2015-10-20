<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
</head>
<body>
  <table>
    <tr>
      <th>Mail</th>
      <th>Password</th>
      <th>Man</th>
      <th>Subscribe</th>
    </tr>
    <tr>
      <th><c:out value="${user.getSoap()}"/></th>
      <th><c:out value="${user.getPassword()}"/></th>
      <th><c:out value="${user.isMan()}"/></th>
      <th><c:out value="${user.isSubscribe()}"/></th>
    </tr>
  </table>
</body>
</html>

