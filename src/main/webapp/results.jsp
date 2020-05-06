<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 2/16/20
  Time: 1:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@include file="head.jsp"%>

<html>
<body>
<header class="pageBackground jumbotron jumbotron-fluid d-flex flex-wrap p-0">
    <div class="col-12 align-self-top d-flex justify-content-end">
        <a class="btn btn-dark col-1 my-2 p-2" href="logout">Logout</a>
        <a class="btn btn-dark col-1 my-2 p-2" href="#">Profile</a>
    </div>
    <div class="col-12 align-self-center p-5">
        <h1>Admin page</h1>
    </div>
</header>

<div class="container-fluid">
    <h2>Search Results: </h2>
    <table class="table">
        <thead class="table-light">
        <tr>
            <td>ID</td>
            <td>Username</td>
            <td>Password</td>
        </tr>

        </thead>
        <tbody class="bg-white">
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.username}</td>
                <td>${user.password}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <table class="table">
        <thead class="table-light">
        <tr>
            <td>ID</td>
            <td>Title</td>
            <td>Author</td>
        </tr>

        </thead>
        <tbody class="bg-white">
        <c:forEach items="${userList}" var="book">
            <tr>
                <td>${book.id}</td>
                <td>${book.title}</td>
                <td>${book.author}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>

</body>
</html>

