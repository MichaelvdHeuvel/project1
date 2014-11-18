<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>
    <jsp:body>
        <div align="center">
            <h1>Werkervaring toevoegen</h1>

            <div class="table-responcive table">
                <form:form method="POST" commandName="workexperience" action="${pageContext.request.contextPath}/profile/add/workexperience">  
                    <table class="table" border="0px">
                        <tbody>
                            <tr>
                                <td>Bedrijf</td>
                                <td>
                                    <form:input path="company" class="form-control" />
                                    <form:errors path="company"></form:errors>
                                </td>
                            </tr>
                            <tr>
                                <td>Functie</td>
                                <td><form:input path="description" class="form-control" /></td>
                                <form:errors path="description"></form:errors>
                            </tr>
                            <tr>
                                <td>StartDatum</td>
                                <td><form:input path="startDate" class="form-control" id="workExpStartDate"/></td>
                                <%--<form:errors path="strartDate"></form:errors>--%>
                            </tr>
                            <tr>
                                <td>Einddatum</td>
                                <td><form:input path="endDate" class="form-control" id="workExpEndDate" /></td>
                                <%--<form:errors path="endDate"></form:errors>--%>
                            </tr>
                            <tr>
                                <td>Functie omschrijving</td>
                                <td><form:input path="description" class="form-control"/></td>
                                <form:errors path="description"></form:errors>
                            </tr>
                            <tr>
                                <td><button type="submit" class="btn btn-success">Voeg Toe</button></td>
                                <td><a class="btn btn-danger pull-right" href="${pageContext.request.contextPath}/">Annuleer</a></td>
                            </tr>
                        </tbody>
                    </table>
                </form:form>
            </div>
        </div>
    </jsp:body>

</t:genericpage>