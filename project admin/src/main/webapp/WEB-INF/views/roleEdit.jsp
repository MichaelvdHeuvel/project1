<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<t:genericpage>

    <jsp:attribute name="header">
        <h1>Wijzig de rol</h1>
    </jsp:attribute>

    <jsp:body>


        <form:form method="POST" commandName="role" action="${pageContext.request.contextPath}/role/edit">
            <form:errors path="*" class="errorblock" element="div" />

            <table class="table table-responsive" border="0">
                <tbody>
                    <tr>
                        <td>Naam</td>
                        <td><form:input path="name" /></td>
                        <td><form:errors path="name" class="error" /></td>
                        <td><form:hidden path="roleId"/>
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
