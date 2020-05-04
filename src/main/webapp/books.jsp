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
                <h2 class="p-1">Sort By</h2>
<%--                    I want these buttons loaded from the backend? on page load users sort categories--%>
                <ul>
                    <li>Title <a class="btn btn-dark col-4 my-2 p-2" href="sortBooks?sortBy=titleAsc">Asc</a><a class="btn btn-dark col-4 my-2 p-2" href="sortBooks?sortBy=titleDesc">Desc</a></li>
                    <li><a class="btn btn-dark col-4 my-2 p-2" href="sortBooks?sortBy=author">Author</a></li>
<%--                    <li><a class="btn btn-dark col-1 my-2 p-2" href="sortBooks?sortBy=addedDate">Date Added</a></li>--%>
                    <li><a class="btn btn-dark col-4 my-2 p-2" href="sortBooks?sortBy=pubDate">Publish Date</a></li>
                    <li><a class="btn btn-dark col-4 my-2 p-2" href="sortBooks?sortBy=pageCount">Page Count</a></li>
                </ul>
            </div>

            <div id="bookList" class="col-9 bg-light">
                <c:choose>
                    <c:when test = "${empty sessionScope.bookResults}">
                        <h2>Add a New Book</h2>
                        <form method="get" action="addBook" class="form bg-light rounded px-2 py-2">
                            <div class="form-group">
                                <label for="searchTerm">Enter a search value: </label>
                                <input class="form-control" type="text" name="searchTerm" id="searchTerm">
                            </div>
                            <div class="form-check-inline">
                                <label class="form-check-label">
                                    <input type="radio" class="form-check-input" name="searchType" value="intitle">Title
                                </label>
                            </div>
                            <div class="form-check-inline">
                                <label class="form-check-label">
                                    <input type="radio" class="form-check-input" name="searchType" value="inauthor">Author
                                </label>
                            </div>
<%--                            <div class="form-check-inline">--%>
<%--                                <label class="form-check-label">--%>
<%--                                    <input type="radio" class="form-check-input" name="searchType" value="subject">Keyword--%>
<%--                                </label>--%>
<%--                            </div>--%>

                            <button type="submit">Search</button>
                            <button type="reset">Clear</button>
                        </form>
                    </c:when>
                    <c:when test = "${!empty sessionScope.bookResults}">
                        <c:forEach items="${sessionScope.bookResults}" var="bookResult">
                            <div class="d-flex">
                                <div class="card" style="width: 14rem;">
                                    <img class="card-img-top" src="${bookResult.imageLinks.smallThumbnail}" alt="Book Cover">
                                    <div class="card-body">
                                        <h5 class="card-title">${bookResult.title}</h5>
                                        <table class="table">
                                            <tbody class="bg-white">
                                            <tr>
                                                <th rowspan="${bookResult.authors.size()}">Authors</th>
                                                <c:forEach items="${bookResult.authors}" var="author">
                                                    <td>${author}</td>
                                            </tr>
                                            <tr>
                                                </c:forEach>
                                                <th>Publish Date</th>
                                                <td>${bookResult.publishedDate}</td>
                                            </tr>
                                            </tbody>
                                        </table>
                                        <form method="post" action="addBook" class="form bg-light rounded px-2 py-2">
                                            <input type="hidden" id="bookToAdd" name="bookToAdd" value="${bookResults.indexOf(bookResult)}">
                                            <button type="submit">Add</button>
                                        </form>


                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </c:when>

                </c:choose>
                <%-- this one should just be done with js to toggle class for visible to invisible--%>
                <h3>My Booklist</h3>

                <div class="d-flex">
                    <c:forEach items="${sessionScope.userGoogleBooks}" var="book">
                        <div class="card" style="width: 14rem;">
                            <img class="card-img-top" src="${book.imageLinks.smallThumbnail}" alt="Book Cover">
                            <div class="card-body">
                                <h5 class="card-title">${book.title}</h5>
                                <table class="table">
                                    <thead class="table-light">
                                    </thead>
                                    <tbody class="bg-white">
                                    <tr>
                                        <th rowspan="${book.authors.size()}">Authors</th>
                                        <c:forEach items="${book.authors}" var="author">
                                        <td>${author}</td>
                                    </tr>
                                    <tr>
                                        </c:forEach>
                                        <th>Publish Date</th>
                                        <td>${book.publishedDate}</td>
                                    </tr>
                                    </tbody>
                                </table>

                                <a class="btn btn-dark my-2 p-2" href="BookDetails?id=${userGoogleBooks.indexOf(book)}">Edit</a>
                                <a class="btn btn-dark my-2 p-2" href="deleteBook?id=${userGoogleBooks.indexOf(book)}">Delete</a>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>

        </section>


    </body>
</html>
