<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@page contentType="text/html" pageEncoding="windows-1252"%>

<t:genericpage>

    <jsp:attribute name="header">

        <h1>Wijzig de gebruiker</h1>
    </jsp:attribute>

    <jsp:body>


        <form:form method="POST" commandName="user" action="${pageContext.request.contextPath}/user/edit">


            <table class="table table-responsive" border="0">
                <tbody>
                    <tr>
                        <td>Naam</td>
                        <td><form:input path="name" /></td>
                    </tr>
                    <tr>
                        <td>Straatnaam</td>
                        <td><form:input path="streetAddress" /></td>
                    </tr>
                    <tr>
                        <td>Huisnummer</td>
                        <td><form:input path="houseNumber" /></td>
                    </tr>
                    <tr>
                        <td>Plaats</td>
                        <td><form:input path="city" /></td>
                    </tr>
                    <tr>

                        <td>Rol:</td>
                        <td>
                            <form:select path="role">
                                <form:option value="${user.role.roleId}">${user.role.name}</form:option>
                                <form:options items="${roleList}" itemValue="roleId" itemLabel="name"/>
                            </form:select>
                        </td>
                        <td>
                        <td><form:hidden path="userId"/>
                        </td>
                    </tr>
                    <tr>
                        <td><input class="btn btn-primary" type="submit" value="Wijzig" /></td>
                        <td></td>
                    </tr>
                </tbody>
            </table>


        </form:form>

    </jsp:body>


</t:genericpage>



