<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>

    <jsp:attribute name="header">

        <h1>Maak een nieuwe gebruiker aan</h1>
    </jsp:attribute>

    <jsp:body>

        <div align="center">
               <div class="row">
                    <div class="col-xs-12 col-md-8">
            <form:form method="POST" commandName="user" action="${pageContext.request.contextPath}/user/add">  
                <table class="table table-responsive" border="0">
                    <tbody>
                        <tr>
                            <td>Naam</td>
                            <td>
                                <form:input placeholder="Naam" path="name" class="form-control" />
                            </td>
                        </tr>
                        <tr>
                            <td>Straatnaam</td>
                            <td><form:input placeholder="Straatnaam" path="streetAddress" class="form-control" /></td>
                        </tr>
                        <tr>
                            <td>Huisnummer</td>
                            <td><form:input placeholder="Huisnummer" path="houseNumber" class="form-control" /></td>
                        </tr>
                        <tr>
                            <td>Plaats</td>

                            <td><form:input placeholder="Plaats" path="city" class="form-control" /></td>
                        </tr>
                        <tr>

                            <td>Rol:</td>

                            <td>
                                <form:select path="role" class="form-control">
                                    <form:option value="0">Selecteer een rol</form:option>
                                    <form:options items="${roleList}" itemValue="roleId" itemLabel="name"/>
                                </form:select>
                            </td>
                        </tr>
                        <tr>
                            <td><button type="submit" class="btn btn-primary">Voeg Toe</button>
                            </td>
                            <td></td>
                        </tr>
                    </tbody>
                </table>
                    </div>
               </div>
            </div>
        </form:form>
    </jsp:body>


</t:genericpage>














