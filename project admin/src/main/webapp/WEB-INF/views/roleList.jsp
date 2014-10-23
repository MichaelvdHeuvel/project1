<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>

    <jsp:attribute name="header">

        <h1>Rollen</h1>
    </jsp:attribute>

    <jsp:body>

        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        Overzicht van alle rollen <div id="message" style="float: right;"><b>${message}</b></div>
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body ">

                        <p>
                            <a href="${pageContext.request.contextPath}/role/add">Voeg een nieuwe rol toe</a>
                        </p>
                        <c:choose>
                            <c:when test="${roleList.size() != 0}">
                                <!-- Wanneer er gebruikers opgeslagen zijn, worden ze hier getoond -->
                                <div class="table-responsive">
                                    <table class="table userList table-striped table-bordered">
                                        <tr>
                                            <th>ID</th>
                                            <th>Rol</th>
                                        </tr>
                                        <c:forEach var="role" items="${roleList}">
                                            <!-- Per gebruiker wordt nu een rij aangemaakt met daarin zijn gegevens -->
                                            <tr>
                                                <td>${role.roleId}</td>
                                                <td>${role.name}</td>
                                                <td style="background-color: #fff;"><a href="${pageContext.request.contextPath}/role/edit/${role.roleId}">Wijzig</a> | 
                                                    <a href="${pageContext.request.contextPath}/role/remove/${role.roleId}">Verwijder</a>
                                                </td>    
                                            </tr>
                                        </c:forEach>
                                    </table>
                                </div>
                            </c:when>
                            <c:otherwise>
                                <!-- Als er geen gebruikers zijn, wordt deze melding getoond -->
                                Er zijn geen rollen gevonden.
                            </c:otherwise>
                        </c:choose>
                    </div>

                    <script>
                        setTimeout(function () {
                            $('#message').fadeOut('long');
                        }, 2000); // <-- time in milliseconds
                    </script>                       

                    <!-- DataTables JavaScript -->
                    <script src="${pageContext.request.contextPath}/resources/js/plugins/dataTables/jquery.dataTables.js"></script>
                    <script src="${pageContext.request.contextPath}/resources/js/plugins/dataTables/dataTables.bootstrap.js"></script>
                    <!-- Page-Level Demo Scripts - Tables - Use for reference -->
                    <script>
                             $(document).ready(function () {
                                 $('#dataTables-example').dataTable();
                             });
                    </script>
                </jsp:body>
            </t:genericpage>
