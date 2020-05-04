<html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@include file="head.jsp"%>

    <body class="container-fluid p-0">
    <%@include file="header.jsp"%>
        <section class="row justify-content-around d-flex align-items-center mx-5">
            <div class="col-3 card">
                <h2>Bookshelf</h2>
                <table class="table">
                    <thead class="table-light">
                    <tr>
                        <td>Title</td>
                        <td>Authors</td>
                        <td>Publish Date</td>
                    </tr>

                    </thead>
                    <tbody class="bg-white">
                    <c:forEach items="${sessionScope.userGoogleBooks}" var="books">
                        <tr>
                            <td>${books.title}</td>
                            <td>${books.authors}</td>
                            <td>${books.publishedDate}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
<%--                TODO pull list of bookList here, make sure to limit #--%>
            </div>
            <div class="col-3 card">
                <h2>Lists</h2>
                <table class="table">
                    <thead class="table-light">
                    <tr>
                        <td>List Name</td>
                        <td>Description</td>
                    </tr>

                    </thead>
                    <tbody class="bg-white">
                    <c:forEach items="${sessionScope.userLists}" var="list">
                        <tr>
                            <td>${list.name}</td>
                            <td>${list.description}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
<%--                TODO pull list of lists here, make sure to limit #--%>
            </div>
            <div class="col-3 card">
                <h2>Stats</h2>
<%--                TODO put something here--%>
            </div>

        </section>


    </body>


</html>
