
<html>
<!-- <%-- <%@include file="head.jsp"%> --%> -->
<!-- this is the stuff in the head.jsp -->
<%--TODO take out head stuff and replace with import--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@include file="head.jsp"%>
    <!-- this is the head stuff -->
    <!--  -->

    <body class="container-fluid p-0">
        <header class="pageBackground jumbotron jumbotron-fluid d-flex flex-wrap p-0">
            <div class="col-12 align-self-top d-flex justify-content-end">
                <button class="btn my-1 mx-1 p-1" type="button" name="logout">Logout</button>
                <button  class="btn my-1 mx-1 p-1" type="button" name="button">Profile</button>
            </div>
            <div class="col-12 align-self-center p-5">
                <h1>Bookshelf Banshee</h1>
            </div>
            <!-- create header image with navbar elements below -->
            <nav class="navbar navbar-expand-md navbar navbar-dark bg-dark col-12 align-self-end">
                <a href="#" class="navbar-brand">Bookshelf Banshee</a>
                <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse1">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarCollapse1">
                    <div class="navbar-nav">
                        <a href="#" class="nav-item nav-link active">Home</a>
                        <a href="#" class="nav-item nav-link">Bookshelf</a>
                        <a href="#" class="nav-item nav-link">Lists</a>
                        <a href="#" class="nav-item nav-link">Stats</a>
                    </div>
                    <form class="form-inline ml-auto bg-dark">
                        <input type="text" class="form-control mr-sm-2" placeholder="Search">
                        <button type="submit" class="btn btn-outline-light bg-info">Search</button>
                    </form>
                </div>
            </nav>
        </header>
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
                    <c:forEach items="${sessionScope.userBooks}" var="books">
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
