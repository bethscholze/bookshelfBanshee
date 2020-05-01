<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<%@include file="head.jsp"%>

<body class="container-fluid">
<%@include file="header.jsp"%>

<section class="pageBackground h-100 row justify-content-center align-items-center mx-0">
    <c:if test = "${!empty sessionScope.currentBookGoogle}">
        <table>
            <tr><td>Title</td><td>${currentBookGoogle.title}</td></tr>
            <tr><td>Author</td><td>${currentBookGoogle.authors[0]}</td></tr>
            <c:forEach items="${sessionScope.currentBookData}" var="bookData">
                <tr><td>${bookData.dataLabel}</td><td>${bookData.dataValue}</td></tr>
            </c:forEach>

        </table>
        <form method="put" action="BookDetails" class="form bg-light rounded px-2 py-2">
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
    </c:if>

</section>


</body>


</html>
