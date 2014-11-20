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
        <h1>Vaardigheden</h1>
        <p class="div-box">
            HIer kunt u aangeven over welke vaardigheden u beschikt zodat u kunt worden uigenodigd om mee te werken aan een project.

        </p>
        <c:choose>
            <c:when test="${skillList.size() != 0}">

                <!-- Wanneer er skills opgeslagen zijn, worden ze hier getoond -->
                <div class="table-responsive">
                    <table id="profileSkillTable" class="table skillList table-striped table-bordered">
                        <thead>
                            <tr>

                                <th>Skill Naam</th>
                                <th>Categorie</th>
                                <th>Optie</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="skill" items="${skillList}">
                                <!-- Per skill wordt nu een rij aangemaakt met daarin zijn gegevens -->

                                <c:choose>
                                    <c:when test="${skill.active == 1}">
                                        <tr>

                                            <td>${skill.name}</td>
                                            <td>${skill.category.name}</td>
                                            <td><center><input type="checkbox"></center></td>
                                    </tr>
                                </c:when>
                                <c:otherwise>
                                    <!-- display niks wanneer een skill inactive is -->
                                </c:otherwise>
                            </c:choose>



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