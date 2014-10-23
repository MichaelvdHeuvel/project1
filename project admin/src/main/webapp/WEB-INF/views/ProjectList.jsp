<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>

    <jsp:attribute name="header">
        <link href="${pageContext.request.contextPath}css/plugins/dataTables.bootstrap.css" rel="stylesheet">

        <h1>Projects</h1>
    </jsp:attribute>
        

    <jsp:body>

        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        Overzicht van de medewerker met welke project hij is gekoppeld    <div id="message" style="float: right;"><b>${message}</b></div>
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body ">

                        
                        <c:choose>
                            <c:when test="${projectList.size() != 0}">

                                <!-- Wanneer er gebruikers opgeslagen zijn, worden ze hier getoond -->
                                <div class="table-responsive">
                                    <table class="table userList table-striped table-bordered" id="dataTables-example">
                                        <thead>
                                            <tr>
                                                <th>ID</th>
                                                <th>Naam</th>
                                                <th>MederwerkerID</th>
                                                <th>Medewerkernaam</th>
                                                
                                            </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach var="project" items="${projectList}" varStatus= "status">
                                            <!-- Per gebruiker wordt nu een rij aangemaakt met daarin zijn gegevens -->
                                            
                                                <tr>
                                                    <td>${project.projectID}</td>
                                                    <td>${project.projectName}</td>
                                                    <td>19</td>
                                                    <td>Jordy </td>
                                                    

                                                     
                                                   
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </c:when>
                            <c:otherwise>
                                <!-- Als er geen projecten zijn, wordt deze melding getoond -->
                                Er zijn geen projecten gevonden.
                            </c:otherwise>
                        </c:choose>


                    </div>
                </div>
                </div>
                </div>
                        
                        <script>
                        setTimeout(function() {
    $('#message').fadeOut('long');
}, 2000); // <-- time in milliseconds
</script>
                       
                            <!-- DataTables JavaScript -->
    <script src="${pageContext.request.contextPath}/resources/js/plugins/dataTables/jquery.dataTables.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/plugins/dataTables/dataTables.bootstrap.js"></script>
     <!-- Page-Level Demo Scripts - Tables - Use for reference -->
    <script>
    $(document).ready(function() {
        $('#dataTables-example').dataTable();
    });
    </script>
    

                </jsp:body>


            </t:genericpage>









