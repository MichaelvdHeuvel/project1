<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>
    <jsp:body>
        <div align="center">
            <div class="row">
                <div class="col-sm-6 col-sm-offset-3 col-lg-6 col-lg-offset-3">
                    <h1>Indienen van een verzoek</h1>
                    
                    <form:form method="POST" commandName="userRequest"
                               action="${pageContext.request.contextPath}/userrequest/add" role="form"> 
                        <div class="form-group right-inner-addon">
                            <i class="glyphicon glyphicon-inbox"></i>
                            <form:textarea class="form-control" path="request" placeholder="verzoek" />
                            <form:errors path="request"></form:errors>
                        </div>
                           
                        <div class="form-group">    
                            <button type="submit" class="btn btn-success" value="Add">Verzend</button>
                            <a class="btn btn-danger" href="${pageContext.request.contextPath}/">Annuleer</a>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </jsp:body>
    
</t:genericpage>