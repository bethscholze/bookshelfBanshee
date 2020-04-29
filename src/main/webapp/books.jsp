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

                <div class="d-flex">
                    <c:forEach items="${sessionScope.userBooks}" var="books">
                        <div class="card" style="width: 14rem;">
                            <img class="card-img-top" src="${books.imageLinks.smallThumbnail}" alt="Book Cover">
                            <div class="card-body">
                                <h5 class="card-title">${books.title}</h5>
                                <table class="table">
                                    <thead class="table-light">
                                    </thead>
                                    <tbody class="bg-white">
                                    <tr>
                                        <th>Authors</th>
                                        <td>${books.authors}</td>
                                    </tr>
                                    <tr>
                                        <th>Publish Date</th>
                                        <td>${books.publishedDate}</td>
                                    </tr>
                                    </tbody>
                                </table>

                                <a class="btn btn-dark col-1 my-2 p-2" href="BookDetails?id=${indexOf(books)}">Edit</a>
<%--                                <button type="button" class="editBook" value="">Edit</button>--%>
                                <button>Add to list</button>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
<%--            js should create these sections--%>
<%--            <div id="editBook" class="col-9 bg-light">--%>
<%--&lt;%&ndash;                //this one should just be done with js to toggle class for visible to invisible&ndash;%&gt;--%>
<%--                <h3>Edit Book</h3>--%>
<%--                <form></form>--%>
<%--            </div>--%>
<%--            <div class="col-9 bg-light d-none">--%>
<%--&lt;%&ndash;                this one needs to be loaded from the servlet on form submit&ndash;%&gt;--%>
<%--                <h3>Search results</h3>--%>
<%--&lt;%&ndash;                button on each to add book&ndash;%&gt;--%>
<%--            </div>--%>

        </section>


    </body>
</html>
