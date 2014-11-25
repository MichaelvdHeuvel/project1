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
                        <h3 class="panel-title">Login Infosupport</h3>
                    </div>
                    <div class="panel-body">

                        <form:form method="POST" commandName="user" action="${pageContext.request.contextPath}/login/register">
                            <div class="form-group right-inner-addon">
                                <i class="glyphicon glyphicon-user"></i>
                                <form:input class="form-control" path="firstName" placeholder="Voornaam" />
                                <form:errors path="firstName"></form:errors>
                                </div>

                                <div class="form-group right-inner-addon">
                                    <i class="glyphicon glyphicon-user"></i>
                                <form:input class="form-control" path="lastName" placeholder="Achternaam" />
                                <form:errors path="lastName"></form:errors>
                                </div>

                                <div class="form-group right-inner-addon">
                                    <i class="glyphicon glyphicon-cloud-upload"></i>
                                <form:input type="email" class="form-control" path="emailAddress" placeholder="Email adres" />
                                <form:errors path="emailAddress"></form:errors>
                                </div>

                                <div class="form-group right-inner-addon">
                                    <i class="glyphicon glyphicon-envelope"></i>
                                <form:input class="form-control" path="zipcode" placeholder="Postcode" />
                                <form:errors path="zipcode"></form:errors>
                                </div>

                                <div class="row">
                                    <div class="col-md-8 col-sm-12">
                                        <div class="form-group right-inner-addon">
                                            <i class="glyphicon glyphicon-home"></i>
                                        <form:input class="form-control" path="address" placeholder="Adres" />
                                        <form:errors path="address"></form:errors>
                                        </div>
                                    </div>
                                    <div class="col-md-4">
                                        <div class="form-group right-inner-addon">
                                            <i class="glyphicon glyphicon-home"></i>
                                        <form:input class="form-control" path="addressNumber" placeholder="Huisnr." />
                                        <form:errors path="addressNumber"></form:errors>
                                        </div>
                                    </div>
                                </div>

                                <div class="form-group right-inner-addon">
                                    <i class="glyphicon glyphicon-home"></i>
                                <form:input class="form-control" path="city" placeholder="Stad" />
                                <form:errors path="city"></form:errors>
                                </div>

                                <div class="form-group">
                                <form:input type="password" class="form-control" id="inputEmail3" placeholder="wachtwoord" path="password" />
                            </div>

                            <div class="form-group">
                                <form:input type="password" class="form-control" id="inputEmail3" placeholder="bevestig wachtwoord" path="passwordConfirm" />
                            </div>

                            <div class="form-group">
                                <div>
                                    <c:if test="${error!= null}">
                                        <div class="alert alert-danger" role="alert">
                                            <div class="error">${error}</div>
                                        </div>
                                    </c:if>
                                    <div>
                                        <!--check if the setup of database is succesful-->
                                        <c:if test="${message != null}">
                                            ${message} <br/>
                                        </c:if>
                                        <a href="${pageContext.request.contextPath}/dba">Database setup</a>
                                    </div>
                                </div>
                            </div>

                            <div class="form-group">
                                <button type="submit" class="btn btn-lg btn-primary btn-block">Registreer</button>
                            </div>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>