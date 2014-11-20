<%-- 
    Document   : projectList
    Created on : 9-nov-2014, 0:04:31
    Author     : Tim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>
    <jsp:body>
        <h1>Skills</h1>
        <div style="height: 60px;">            <div id="message">${message}</div></div>

        <c:choose>
            <c:when test="${skillList.size() != 0}">

                <!-- Wanneer er skills opgeslagen zijn, worden ze hier getoond -->
                <div class="table-responsive">
                    <table id="skillTable" class="table skillList table-striped table-bordered">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Skill Naam</th>
                                <th>Categorie</th>
                                <th>Zichtbaarheid</th>
                                <th>Opties</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="skill" items="${skillList}">
                                <!-- Per skill wordt nu een rij aangemaakt met daarin zijn gegevens -->

                                <tr>
                                    <td>${skill.skillId}</td>
                                    <td>${skill.name}</td>
                                    <td>${skill.category.name}</td>
                                    <td>       
                                        <c:choose>
                                            <c:when test="${skill.active == 0}">
                                                <a class="btn btn-danger" href="${pageContext.request.contextPath}/skill/skillList/visibility/${skill.skillId}">
                                                    Verborgen
                                                </a>
                                            </c:when>
                                            <c:otherwise>
                                                <a class="btn btn-success" href="${pageContext.request.contextPath}/skill/skillList/visibility/${skill.skillId}">
                                                    Zichtbaar
                                                </a>
                                            </c:otherwise>
                                        </c:choose>
                                    </td>
                                    
                                    <td style="background-color: #fff;"><a href="${pageContext.request.contextPath}/skill/edit/${skill.skillId}">Wijzig</a> |
                                        <a href="${pageContext.request.contextPath}/skill/remove/${skill.skillId}">Verwijderen</a> 

                                </tr>

                            </c:forEach>
                        </tbody>
                    </table>

                    <td><a class="btn btn-primary pull-left" href="${pageContext.request.contextPath}/skill/add">Aanmaken</a></td>  
                </div>
            </c:when>
            <c:otherwise>
                <!-- Als er geen skills zijn, wordt deze melding getoond -->
                Er zijn geen skills gevonden.<br>
                <a href="${pageContext.request.contextPath}/skill/add/">Klik hier om een nieuwe skill aan te maken</a> 

            </c:otherwise>
        </c:choose>



    </jsp:body>

</t:genericpage>