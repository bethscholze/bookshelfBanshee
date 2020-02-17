<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 2/17/20
  Time: 1:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <%@include file="head.jsp"%>

    <body class="container-fluid">
        <section class="pageBackground h-100 row justify-content-center align-items-center mx-0">
            <form action="post" action="loginController" class="form bg-light rounded px-2 py-2">
                <div class="form-group">
                    <label for="username">Username</label>
                    <input type="text" class="form-control" id="username" name="username" placeholder="enter username" />
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" class="form-control" id="password" name="password" placeholder="enter password" />
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </section>


    </body>


</html>
