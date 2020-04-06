<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 2/24/20
  Time: 10:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%--TODO take out head stuff and replace with import--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@include file="head.jsp"%>

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
        <section class="row d-flex justify-content-between align-items-center">
            <div class="col-3 bg-dark text-light text-center">
                <h2 class="p-1">Sort By</h2>
                <div>
<%--                    I want these buttons loaded from the backend? on page load users sort categories--%>
                    <button>Title</button>
                    <button>Author</button>
                    <button>Date added</button>
                    <button>Publish Date</button>
                    <button># of pages</button>
                </div>
            </div>
            <div id="bookList" class="col-9 bg-light">
                <form>
                    <input>
                    <button type="submit">Search</button>
                    <button type="reset">Clear</button>
                </form>
                <%-- this one should just be done with js to toggle class for visible to invisible--%>
                <h3>Booklist</h3>

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
                            <td><button onclick="toggleEdit()">Edit</button></td>
                            <td><button>Add to list</button></td>
<%--                            this will have to pop up a modal? or something--%>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <div id="editBook" class="col-9 bg-light d-none">
<%--                //this one should just be done with js to toggle class for visible to invisible--%>
                <h3>Edit Book</h3>
            </div>
            <div class="col-9 bg-light d-none">
<%--                this one needs to be loaded from the servlet on form submit--%>
                <h3>Search results</h3>
<%--                button on each to add book--%>
            </div>

        </section>


    </body>
</html>
