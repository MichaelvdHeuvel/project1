<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>

    <jsp:attribute name="header">

           <h1>Maak een nieuwe gebruiker aan</h1>
    </jsp:attribute>

    <jsp:body>

        
            <form:form method="POST" commandName="user" action="${pageContext.request.contextPath}/register">
                <table class="table table-responsive" border="0">
                    <tbody>
                        <tr>
                            <td>E-Mail</td>
                            <td>
                                <form:input path="username" class="form-control" />
                            </td>
                        </tr>
                        <tr>
                            <td>Wachtwoord</td>
                            <td><form:input path="password" class="form-control" /></td>
                        </tr>
                        <tr>
                            <td>Voornaam</td>
                            <td><form:input path="firstName" class="form-control" /></td>
                        </tr>
                        <tr>
                            <td>Achternaam</td>
                            <td><form:input path="lastName" class="form-control" /></td>
                        </tr>
                        <tr>
                            <td>Adres</td>
                            <td><form:input path="address" class="form-control" /></td>
                        </tr>
                        <tr>
                            <td>Tel. Mobiel</td>
                            <td><form:input path="phoneMobile" class="form-control" /></td>
                        </tr>
                        <tr>
                            <td>Tel. Thuis</td>
                            <td><form:input path="phoneHome" class="form-control" /></td>
                        </tr>
                        <tr>
                            <td>Postcode</td>
                            <td><form:input path="zipCode" class="form-control" /></td>
                        </tr>
                        <tr>
                            <td><button type="submit" class="btn btn-primary">Voeg Toe</button>
                            </td>
                            <td></td>
                        </tr>
                    </tbody>
                </table>
            </form:form>
        </jsp:body>


    </t:genericpage>














