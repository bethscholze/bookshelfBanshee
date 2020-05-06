<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 4/27/20
  Time: 10:45 AM
  To change this template use File | Settings | File Templates.
--%>
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

            <form id="signupForm" method="post" action="Signup" class="form bg-light rounded px-2 py-2">
                <div class="form-group">
                    <label for="username">Username</label>
                    <input type="text" class="form-control" minlength="5" id="username" name="username" placeholder="enter username" required/>
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" class="form-control" minlength="5" id="password" name="password" placeholder="enter password" required/>
                </div>
                <div class="form-group">
                    <label for="password2">Password</label>
                    <input type="password" class="form-control" minlength="5" id="password2" name="password2" placeholder="reenter password" required/>
                </div>
                <button type="submit" value="Sign up" class="btn btn-primary">Submit</button>
            </form>
            <script>
                $('#signupForm').validate({
                    rules: {
                        password: {
                            required: true,
                            minlength: 5,
                        },
                        password2: {
                            required: true,
                            minlength: 5,
                            equalTo:'#password'
                        }

                    }
                });
            </script>
        </section>


    </body>


</html>
