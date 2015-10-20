<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset='UTF-8'>
    <title>User List</title>
</head>
<body>
<div id="header">
    <h3>registered users info</h3>
</div>

<br>
<div id="table">
    <table cellpadding="10">
        <tr>
            <th>email</th>
            <th>password</th>
            <th>sex</th>
            <th>subscription</th>
        </tr>
        <c:forEach var="user" items="${userList}">
           <tr>
            <c:forEach var="pole" items="${user}">
                <td>${pole}</td>
            </c:forEach>
            </tr>
        </c:forEach>
        <br>
    </table>
    <c:if test="${not empty message}">
        <h3>${message}</h3>
    </c:if>
</div>
</body>
</html>
