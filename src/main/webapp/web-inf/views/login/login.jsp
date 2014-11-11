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

                            <form:form method="POST" commandName="user" action="${pageContext.request.contextPath}/login/login">
                                
                                <div class="form-group">
                                    <form:input type="email" class="form-control" id="inputEmail3" placeholder="e-mail" path="emailAddress" />
                                </div>
                                
                                <div class="form-group">
                                    <form:input type="password" class="form-control" id="inputPassword3" placeholder="wachtwoord" path="password" />
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
                                    <button type="submit" class="btn btn-lg btn-primary btn-block">Inloggen</button>
                                </div>
                                        
                                <a href="${pageContext.request.contextPath}/login/register">Nog geen account? klik hier!</a>
                            </form:form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>