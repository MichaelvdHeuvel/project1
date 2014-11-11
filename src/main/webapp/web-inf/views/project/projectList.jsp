<%-- 
    Document   : projectList
    Created on : 9-nov-2014, 0:04:31
    Author     : Faustino
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>
    <jsp:body>
        <h1>Projecten</h1>
        <c:choose>
<c:when test="${projectList.size() != 0}">

                                <!-- Wanneer er projecten opgeslagen zijn, worden ze hier getoond -->
                                <div class="table-responsive">
                                    <table class="table userList table-striped table-bordered" id="dataTables-example">
                                        <thead>
                                            <tr>
                                                <th>ID</th>
                                                <th>Project Naam</th>
                                                <th>Start Datum (yyyy-mm-dd)</th>
                                                <th>Eind Datum (yyyy-mm-dd)</th>
                                                <th>Manager</th>
                                                <c:if test="${loggedInUser.role == 'Manager'}">
                                                    <th>Actie</th>
                                                </c:if>
                                                </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach var="project" items="${projectList}">
                                            <!-- Per project wordt nu een rij aangemaakt met daarin zijn gegevens -->
                                            
                                                <tr>
                                                    <td>${project.projectId}</td>
                                                    <td>${project.projectName}</td>
                                                    <td>${project.startDate}</td>
                                                    <td>${project.endDate}</td>
                                                    <td>${project.assignedManager.firstName} ${project.assignedManager.lastName}</td>
                                                    
                                                    <c:if test="${loggedInUser.role == 'Manager'}">        
                                                    <td style="background-color: #fff;"><a href="${pageContext.request.contextPath}/project/edit/${project.projectId}">Wijzig</a> |
                                                    <a href="${pageContext.request.contextPath}/project/remove/${project.projectId}">Verwijder</a> 
                                                    </c:if>
                                                </tr>
                                                
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </c:when>
                            <c:otherwise>
                                <!-- Als er geen projecten zijn, wordt deze melding getoond -->
                                Er zijn geen projecten gevonden.<br>
                                <c:if test="${loggedInUser.role == 'Manager'}">
                                <a href="${pageContext.request.contextPath}/project/add/">Klik hier om een nieuw project aan te maken</a> 
                                </c:if>
                            </c:otherwise>
                                </c:choose>
                                        
        
        
    </jsp:body>
    
</t:genericpage>