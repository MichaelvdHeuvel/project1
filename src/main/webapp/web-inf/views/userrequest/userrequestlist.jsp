<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>
    <jsp:body>
        <div>
            <h1>Lijst met verzoeken</h1>
            <table id="example" class="table table-hover  table-responsive table-bordered">
                <thead>
                    <tr>
                        <th>Naam</th>
                        <th>Verzoek</th>
                        <th>Datum</th>
                        <th>Tijdstip</th>
                        <th>Actie</th>
                    </tr>
                </thead>
                <c:forEach var="request" items="${requestList}">
                    <tr>
                        <td><a href="${pageContext.request.contextPath}/profile/user/${request.requester.id}">${request.requester.firstName}&nbsp;${request.requester.lastName}</a></td>
                        <td>${request.request}</td>
                        <td>${request.requestDate.date}/${request.requestDate.month+1}/${request.requestDate.year+1900}</td>
                        <td>${request.requestDate.hours}:${request.requestDate.minutes}:${request.requestDate.seconds}</td>
                        
                        <td align="center">        
                            <a class="btn btn-danger btn-lg" href="javascript:if(confirm('Weet u het zeker dat u dit verzoek wil verwijderen?'))
                                                                    window.location='${pageContext.request.contextPath}/request/remove/${request.id}';">
                                <i class="glyphicon glyphicon-trash"></i>
                            </a> 
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </jsp:body>
    
</t:genericpage>