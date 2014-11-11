<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>
    <jsp:body>
        <div align="center">
                <h2>${pageTitle}</h2>

                <div class="row">
                    <div class="col-sm-6 col-sm-offset-3 col-lg-6 col-lg-offset-3">
                        <form:form method="POST" commandName="user"
                                   action="${pageContext.request.contextPath}/user/editpassword" role="form">

                            <div class="form-group right-inner-addon">
                                <i class="glyphicon glyphicon-user"></i>
                                <form:input type="password" class="form-control" path="password" placeholder="wachtwoord" />
                            </div>
                            
                            <div class="form-group right-inner-addon">
                                <i class="glyphicon glyphicon-user"></i>
                                <form:input type="password" class="form-control" path="" placeholder="herhaal wachtwoord" />
                            </div>
                            
                            <form:hidden path="id" />
                            
                            <div class="form-group">    
                                <button type="submit" class="btn btn-success" value="editpassword">Verzend</button>
                                <a class="btn btn-danger" href="${pageContext.request.contextPath}/">Annuleer</a>
                            </div>
                        </form:form>
                    </div>
                </div>
            </div>
    </jsp:body>
    
</t:genericpage>