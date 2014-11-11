<%-- 
    Document   : activeUserList
    Created on : 28-okt-2014, 14:40:29
    Author     : michaelheuvel
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>
    <jsp:body>
        <div>
            <h1>Found users by search citeria</h1>
            <div class="table-responsive">
                <table  id="searchResult" class="table table-hover  table-responsive table-bordered">
                    <thead>
                        <tr>
                            <td><strong> firstname</strong></td>
                            <td><strong> Lastname</strong></td>

                        </tr>
                    </thead>
                    <c:choose>
                        <c:when test="${users != null}">
                            <c:forEach var="user" items="${users}">
                                <tr>
                                    <td>${user.firstName}</td>
                                    <td>${user.lastName}</td>
                                </tr>
                            </c:forEach>
                        </c:when>
                        <c:otherwise>
                            Geen zoekresultaten
                        </c:otherwise>
                    </c:choose>

                </table>
            </div>
        </div>
    </jsp:body>
</t:genericpage>

