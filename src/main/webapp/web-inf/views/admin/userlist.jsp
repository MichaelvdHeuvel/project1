<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>
    <jsp:body>
        <div>
            <h1>Alle gebruikers</h1>
            <div class="table-responsive">
                <table id="adminList" class="table table-hover  table-responsive table-bordered">
                    <thead>
                        <tr>
                            <th>Naam</th>
                            <th>Gebruikersnaam</th>
                            <th>Rol</th>
                            <th>Actief</th>
                        </tr>
                    </thead>
                    <c:forEach var="user" items="${userList}">
                        <tr>
                            <td><a href="${pageContext.request.contextPath}/profile/user/${user.id}">${user.firstName}&nbsp;${user.lastName}</a></td>
                            <td>${user.emailAddress}</td>
                            <td>
                                <c:if test="${user.role == 1}">
                                    Medewerker
                                </c:if>
                                <c:if test="${user.role == 2}">
                                    Manager
                                </c:if>
                                <c:if test="${user.role == 3}">
                                    Administrator
                                </c:if>
                            </td>
                            <td>       
                                <c:choose>
                                    <c:when test="${user.active == 0}">
                                        <a class="btn btn-danger" href="${pageContext.request.contextPath}/admin/userlist/active/${user.id}">
                                            non actief
                                        </a>
                                    </c:when>
                                    <c:otherwise>
                                        <a class="btn btn-success" href="${pageContext.request.contextPath}/admin/userlist/active/${user.id}">
                                            actief
                                        </a>
                                    </c:otherwise>
                                </c:choose>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </jsp:body>

</t:genericpage>