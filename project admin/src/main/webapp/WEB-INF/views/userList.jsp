<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>

    <jsp:attribute name="header">
        <link href="${pageContext.request.contextPath}css/plugins/dataTables.bootstrap.css" rel="stylesheet">

        <h1>Gebruikers</h1>
    </jsp:attribute>


    <jsp:body>

        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        Overzicht van alle gebruikers         <div id="message" style="float: right;"><b>${message}</b></div>
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body ">

                        <p>
                            <a href="${pageContext.request.contextPath}/user/add">Maak nieuwe gebruiker aan</a>
                        </p>
                        <c:choose>
                            <c:when test="${userList.size() != 0}">

                                <!-- Wanneer er gebruikers opgeslagen zijn, worden ze hier getoond -->
                                <div class="table-responsive">
                                    <table class="table userList table-striped data-table table-bordered" id="dataTables-example">
                                        <thead>
                                            <tr>
                                                <th>ID</th>
                                                <th>Naam</th>
                                                <th>Adres</th>
                                                <th>Huisnummer</th>
                                                <th>Plaats</th>
                                                <th>Rol</th>
                                                <th>Opties</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="user" items="${userList}">
                                                <!-- Per gebruiker wordt nu een rij aangemaakt met daarin zijn gegevens -->

                                                <tr>
                                                    <td>${user.userId}</td>
                                                    <td>${user.name}</td>
                                                    <td>${user.streetAddress}</td>
                                                    <td>${user.houseNumber}</td>
                                                    <td>${user.city}</td>
                                                    <td>${user.role.name}</td>

                                                    <td style="background-color: #fff;"><a href="${pageContext.request.contextPath}/user/edit/${user.userId}">Wijzig</a> |
                                                        <a href="${pageContext.request.contextPath}/user/remove/${user.userId}">Verwijder</a> |
                                                        <a href="${pageContext.request.contextPath}/createPdf/${user.userId}">CV</a></td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </c:when>
                            <c:otherwise>
                                <!-- Als er geen gebruikers zijn, wordt deze melding getoond -->
                                Er zijn geen gebruikers gevonden.
                            </c:otherwise>
                        </c:choose>


                    </div>
                </div>
            </div>
        </div>

        


    </jsp:body>


</t:genericpage>









