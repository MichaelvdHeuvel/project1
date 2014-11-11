<%-- 
    Document   : addProject
    Created on : 9-nov-2014, 4:18:52
    Author     : Faustino
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>


    <jsp:body>
        <div align="center">
            <h1>Project aanmaken</h1>

            <form:form method="POST" commandName="project" action="${pageContext.request.contextPath}/project/add">  
                <table class="table table-responsive" border="0">
                    <tbody>
                        <tr>
                            <td>Project Naam</td>
                            <td>
                                <form:input path="projectName" class="form-control" />
                            </td>
                        </tr>
                        <tr>
                            <td>Start Datum (yyyy-mm-dd)</td>
                            <td><form:input path="startDate" class="form-control" /></td>
                        </tr>
                        <tr>
                            <td>Eind Datum (yyyy-mm-dd)</td>
                            <td><form:input path="endDate" class="form-control" /></td>
                        </tr>
                        <tr>
                            <td>Manager</td>
                            <td>${loggedInUser.firstName}</td>
                        </tr>
                        <tr>
                            <td><button type="submit" class="btn btn-success">Voeg Toe</button></td>
                            <td><a class="btn btn-danger pull-right" href="${pageContext.request.contextPath}/project/list">Annuleer</a></td>
                        </tr>
                    </tbody>
                </table>
            </form:form>
        </div>
        </jsp:body>



    </t:genericpage>















