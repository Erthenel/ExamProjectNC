<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Login page</title>
    <link href="<c:url value='/static/css/bootstrap.css' />"  rel="stylesheet"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
    <link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />
</head>

<body>
<div id="mainWrapper">
    <div class="login-container">

        <div class="login-card">
            <div class="login-form">

                <section class="welcome logo">
                    Welcome to ExamProjectNC service!
                </section >

                <form action="<c:url value='/j_spring_security_check' />" method="post" class="form-horizontal">
                    <c:if test="${param.error != null}">
                        <div class="alert alert-danger">
                            <p>Invalid username and password.</p>
                        </div>
                    </c:if>
                    <c:if test="${param.logout != null}">
                        <div class="alert alert-success">
                            <p>You have been logged out successfully.</p>
                        </div>
                    </c:if>
                    <div class="input-group input-sm">
                        <label class="input-group-addon" for="j_username"><i class="fa fa-user"></i></label>
                        <input type="text" class="form-control" name="j_username" placeholder="Enter Email" required>
                    </div>
                    <div class="input-group input-sm">
                        <label class="input-group-addon" for="j_password"><i class="fa fa-lock"></i></label>
                        <input type="password" class="form-control" name="j_password"  placeholder="Enter Password" required>
                    </div>

                    <div class="form-actions">
                        <input type="submit"
                               class="btn btn-block btn-primary btn-default" value="Log in">
                    </div>
                </form>
                <a class="registerLink" href="/Registration">Not registered? Register now!</a>
            </div>
        </div>
    </div>
</div>

</body>
</html>