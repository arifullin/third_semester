<%@ page contentType="text/html" pageEncoding="utf-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <meta charset='UTF-8'>
    <title>Reg page</title>
</head>
<body>
<c:if test="${not empty message}">
  <h3>${message}</h3>
</c:if>
  <form action='' method='POST'>

    <input type='text' name='soap'><br>
    <input type='password' name='password'><br>
   <input type='radio' name='man' value="true"> male <input type="radio" name="man" value="false">female<br>
    <input type='checkbox' name='subscribe' value="true">Subscribe<br>
    <input type="submit" >
  </form>
</body>
</html>
