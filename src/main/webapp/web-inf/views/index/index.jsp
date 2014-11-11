<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>
    <jsp:body>
        Welcome ${loggedInUser.firstName}<br/>
        
        <c:if test="${error != null}">
            <div class="alert alert-danger" role="alert">
                ${error}
            </div>
        </c:if>
        <c:if test="${message != null}">
            <div class="alert alert-success" role="alert">
                ${message}
            </div>
        </c:if>
    </jsp:body>
    
</t:genericpage>