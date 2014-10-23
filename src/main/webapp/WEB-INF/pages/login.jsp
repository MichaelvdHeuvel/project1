<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<head>
    <title>Login</title>
    <t:resources>  
    </t:resources>
</head>  

<body onload='document.loginForm.username.focus();' background="${pageContext.request.contextPath}/resources/img/cloud.jpg" style=" background-size: cover;">
    <div class="container">
        <div class="row">
            <div class="vertical-center col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Login Infosupport</h3>
                    </div>
                    <div class="panel-body">

                        <form role="form" action="<c:url value='/login' />" method='POST'>
                            <div class="form-group">
                                <input type="text" class="form-control" id="inputEmail3" placeholder="e-mail" name="username">
                            </div>
                            <div class="form-group">
                                <input type="password" class="form-control" id="inputPassword3" placeholder="wachtwoord" name="password">
                            </div>
                            <div class="form-group">
                                <div class="checkbox">
                                    <label>
                                        <input name="remember" type="checkbox" value="Remember Me">Onthoud mij
                                    </label>
                                    <c:if test="${not empty error}">
                                        <div class="error">${error}</div>
                                    </c:if>
                                    <c:if test="${not empty msg}">
                                        <div class="msg">${msg}</div>
                                    </c:if>
                                </div>
                            </div>
                            <div class="form-group">
                                <button type="submit" class="btn btn-lg btn-primary btn-block">Sign in</button>
                                <input type="hidden" name="${_csrf.parameterName}"
                                       value="${_csrf.token}" />
                            </div>
                            <!--<div class=""-->
                            <a href="${pageContext.request.contextPath}/register">Nog geen account? klik hier!</a>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>

</body>
</html>