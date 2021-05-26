<%--
  Created by IntelliJ IDEA.
  User: sevskii
  Date: 26.05.2021
  Time: 23:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List, com.labs.Lab8.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    List<User> users = UserBase.getInstance().getUserList();
%>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
          integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
    <title>Список пользователей</title>
</head>
<body>
<header>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="/">Главная страница</a>
    </nav>
</header>

<div class="content">
    <table class="table">
        <tr>
            <th>имя пользователя</th>
            <th>пароль</th>
        </tr>
        <% for (User user : users) { %>
        <tr>
            <td><%=user.getLogin() %>
            </td>
            <td><%=user.getPassword() %>
            </td>
        </tr>
        <% } %>
    </table>
</div>
</body>
</html>