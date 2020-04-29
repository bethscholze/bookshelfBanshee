<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 2/17/20
  Time: 1:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<% request.getSession().invalidate();%>
<html>
    <%@include file="head.jsp"%>

    <body class="container-fluid">
    <%@include file="header.jsp"%>
        <section class="pageBackground h-100 row justify-content-center align-items-center mx-0">
            <div><p>You are now logged out.</p></div>
        </section>
<%--todo invalidate the cache as well--%>

    </body>


</html>
