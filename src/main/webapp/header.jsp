<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 4/27/20
  Time: 11:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header class="pageBackground jumbotron jumbotron-fluid d-flex flex-wrap p-0">
    <div class="col-12 align-self-top d-flex justify-content-end">
        <a class="btn btn-dark col-1 my-2 p-2" href="logout">Logout</a>
        <a class="btn btn-dark col-1 my-2 p-2" href="#">Profile</a>
    </div>
    <div class="col-12 align-self-center p-5">
        <h1>Bookshelf Banshee</h1>
    </div>
    <!-- create header image with navbar elements below -->
    <nav class="navbar navbar-expand-md navbar navbar-dark bg-dark col-12 align-self-end">
        <a href="index.jsp" class="navbar-brand">Bookshelf Banshee</a>
        <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse1">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarCollapse1">
            <div class="navbar-nav">
                <a href="UserHome" class="nav-item nav-link active">Home</a>
                <a href="books.jsp" class="nav-item nav-link">Bookshelf</a>
                <a href="viewList" class="nav-item nav-link">Lists</a>
                <a href="#" class="nav-item nav-link">Stats</a>
            </div>
            <form class="form-inline ml-auto bg-dark">
                <input type="text" class="form-control mr-sm-2" placeholder="Search">
                <button type="submit" class="btn btn-outline-light bg-info">Search</button>
            </form>
        </div>
    </nav>
</header>
