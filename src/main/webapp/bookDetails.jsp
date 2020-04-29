<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<%@include file="head.jsp"%>

<body class="container-fluid">
<%@include file="header.jsp"%>
<c:if test = "${!empty sessionScope.errorMessage}">
    <div class="alert-danger"><p>${sessionScope.errorMessage}</p></div>
</c:if>
<section class="pageBackground h-100 row justify-content-center align-items-center mx-0">

    <form method="put" action="BookDetails" class="form bg-light rounded px-2 py-2">
        <div class="form-group">
            <label for="username">Username</label>
            <input type="text" class="form-control" id="username" name="username" placeholder="enter username" />
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input type="password" class="form-control" id="password" name="password" placeholder="enter password" />
        </div>
        <div class="form-group">
            <label for="password2">Password</label>
            <input type="password" class="form-control" id="password2" name="password2" placeholder="reenter password" />
        </div>
        <button type="submit" value="submit" class="btn btn-primary">Submit</button>
    </form>
</section>


</body>


</html>
