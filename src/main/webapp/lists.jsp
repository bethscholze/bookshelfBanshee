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
                    <c:forEach items="${sessionScope.userLists}" var="booksOnList">
                        <tr><td><a href="viewList?id=${userLists.indexOf(booksOnList)}">${booksOnList.name}</a></td></tr>
                    </c:forEach>

                </table>

            </div>
            <div class="col-6 bg-light">
                <h2>Current list</h2>
                <c:set var="books" value="${sessionScope.userMappedBooks}"/>
                <table class="table bg-light rounded px-2 py-2">
                    <tr><th colspan="3">${sessionScope.currentList.name}</th></tr>
                    <c:forEach items="${sessionScope.keysOfBooksOnList}" var="bookKey">
                        <tr><td>${books[(bookKey).intValue()].googleData.title}</td><td>${books[bookKey.intValue()].googleData.leadAuthor}</td><td><a class="btn btn-dark my-2 p-1" href="removeFromList?id=${bookKey}">Remove</a></tr>
                    </c:forEach>

                </table>
                <a class="btn btn-dark my-2 p-2" href="deleteList">Delete</a>
                <table class="table bg-light rounded px-2 py-2">
                    <tr><th colspan="3">Books not on list</th></tr>

                    <c:forEach items="${sessionScope.booksNotOnList}" var="nonListBookKey">
                        <tr><td>${books[(nonListBookKey).intValue()].googleData.title}</td><td>${books[(nonListBookKey).intValue()].googleData.leadAuthor}</td><td><a class="btn btn-dark my-2 p-1" href="addToList?id=${nonListBookKey}">Add</a></td></tr>
                    </c:forEach>

                </table>

            </div>
            <div class="col-2">
                <h2>Add List</h2>
                <form method="post" action="viewList" class="form bg-light rounded px-2 py-2">
                    <div class="form-group">
                        <label for="name">List Name</label>
                        <input type="text" class="form-control" id="name" name="name" placeholder="enter label" />
                    </div>
                    <div class="form-group">
                        <label for="description">Description</label>
                        <textarea class="form-control" aria-label="With textarea" id="description" name="description"></textarea>
                    </div>
                    <button type="submit" value="submit" class="btn btn-primary">Submit</button>
                </form>
            </div>
        </section>


    </body>
</html>
