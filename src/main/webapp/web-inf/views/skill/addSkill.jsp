<%-- 
    Document   : addSkill
    Created on : 9-nov-2014, 4:18:52
    Author     : TimGortworst
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>


    <jsp:body>
        <div>
            <h2>Voeg een skill toe</h2>
            <p class="div-box">
                Op deze pagina kunt u een nieuwe skills toevoegen die gebruikers kunnen aanvinken op hun profiel.

            </p>

            <div class="container-fluid  div-box" >
                <div class="col-md-3">

                    <form:form method="POST" commandName="skill" action="${pageContext.request.contextPath}/skill/add">  
                        <table class="table table-responsive" border="0">
                            <tbody>
                                <tr>
                                    <td>Skill naam</td>
                                    <td>
                                        <form:input path="name" class="form-control" />
                                    </td>
                                </tr>
                                <tr>
                                    <td>Categorie:</td>
                                    <td>
                                        <form:select path="category">
                                            <form:option value="0">Selecteer een categorie</form:option>
                                            <form:options items="${categoryList}" itemValue="categoryId" itemLabel="name"/>
                                        </form:select>
                                    </td>
                                </tr>

                                <tr>
                                    <td><button type="submit" class="btn btn-primary">Voeg Toe</button></td>
                                    <td><a class="btn btn-danger pull-right" href="${pageContext.request.contextPath}/skill/list">Annuleer</a></td>
                                </tr>
                            </tbody>
                        </table>
                    </form:form>
                </div>
            </div>
        </div>
    </jsp:body>


</t:genericpage>


