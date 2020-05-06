<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 2/24/20
  Time: 10:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@include file="head.jsp"%>

    <body class="container-fluid p-0">
    <%@include file="header.jsp"%>

        <section class="row d-flex justify-content-between align-items-center">
            <div class="col-3 bg-dark text-light text-center">
                <h2 class="p-1">Lists</h2>
                <table class="table bg-light rounded px-2 py-2">
                    <c:forEach items="${sessionScope.userLists}" var="userList">
                        <tr><td><a href="viewList?id=${userLists.indexOf(userList)}">${userList.name}</a></td></tr>
                    </c:forEach>

                </table>

            </div>
            <div class="col-6 bg-light">
                <h2>Current list</h2>
                <table class="table bg-light rounded px-2 py-2">
                    <tr><th>${sessionScope.currentList.name}</th></tr>
                    <c:forEach items="${sessionScope.currentListBooks}" var="book">
                        <tr><td>${book.title}</td><td>${book.author}</td></tr>
                    </c:forEach>

                </table>
            </div>
            <div class="col-2">
                <h2>Manage List</h2>
                <form method="post" action="BookDetails" class="form bg-light rounded px-2 py-2">
                    <div class="form-group">
                        <label for="dataLabel">data label</label>
                        <input type="text" class="form-control" id="dataLabel" name="dataLabel" placeholder="enter label" />
                    </div>
                    <div class="form-group">
                        <label for="dataValue">data value</label>
                        <input type="text" class="form-control" id="dataValue" name="dataValue" placeholder="enter value" />
                    </div>
                    <button type="submit" value="submit" class="btn btn-primary">Submit</button>
                </form>
            </div>
        </section>


    </body>
</html>
