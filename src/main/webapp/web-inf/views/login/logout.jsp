<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

    <head>
        <title>Login</title>
        <t:resources>  
        </t:resources>
    </head>  

    <body background="${pageContext.request.contextPath}/resources/img/cloud.jpg" style=" background-size: cover;">
        <div class="container">
            <div class="row">
                <div class="vertical-center col-md-4 col-md-offset-4">
                    <div class="login-panel panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">Logout Infosupport</h3>
                        </div>
                        <div class="panel-body">

                            U bent succesvol uitgelogd!<br />
                            <a href="${pageContext.request.contextPath}/login/login">Opnieuw inloggen</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>