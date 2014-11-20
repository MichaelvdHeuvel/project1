<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>
    <jsp:body>
        <h1>Werkervaring</h1>
        <div style="height: 60px;">            <div id="message">${message}</div></div>

        <c:choose>
            <c:when test="${workExpSize != 0}">

                <!-- Wanneer er skills opgeslagen zijn, worden ze hier getoond -->
                <div class="table-responsive">
                    <table class="table table-striped table-bordered">
                        <thead>
                            <tr>
                                <th>Bedrijf</th>
                                <th>Functie</th>
                                <th>Beschrijving</th>
                                <th>Zichtbaarheid</th>
                                <th>Opties</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="workExp" items="${workExpList}">
                                <!-- Per skill wordt nu een rij aangemaakt met daarin zijn gegevens -->

                                <tr>
                                    <td>${workExp.company}</td>
                                    <td>${workExp.function}</td>
                                    <td>${workExp.description}</td>
                                    <td>       
                                        <c:choose>
                                            <c:when test="${workExp.active == 0}">
                                                <a class="btn btn-danger" href="${pageContext.request.contextPath}/profile/workexperience/visibility/${workExp.id}">
                                                    Verborgen
                                                </a>
                                            </c:when>
                                            <c:otherwise>
                                                <a class="btn btn-success" href="${pageContext.request.contextPath}/profile/workexperience/visibility/${workExp.id}">
                                                    Zichtbaar
                                                </a>
                                            </c:otherwise>
                                        </c:choose>
                                    </td>
                                    <td>
                                        <a class="btn btn-primary" href="${pageContext.request.contextPath}/profile/edit/workexperience/${workExp.id}">
                                            Wijzigen
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>

                </div>
            </c:when>
            <c:otherwise>
                <!-- Als er geen skills zijn, wordt deze melding getoond -->
                Er is geen werkervaring gevonden.<br>
                <a href="${pageContext.request.contextPath}/profile/add/workexperience">Klik hier om Werkervaring toe te voegen</a> 

            </c:otherwise>
        </c:choose>



    </jsp:body>

</t:genericpage>