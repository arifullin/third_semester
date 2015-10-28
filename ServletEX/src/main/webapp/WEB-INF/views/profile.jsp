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
      <th>${user.getSoap()}</th>
      <th><${user.getPassword()}</th>
      <th><${user.isMan()}</th>
      <th><${user.isSubscribe()}</th>
    </tr>
  </table>
</body>
</html>

