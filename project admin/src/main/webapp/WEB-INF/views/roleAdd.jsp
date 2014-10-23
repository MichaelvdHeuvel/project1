<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<t:genericpage>

    <jsp:attribute name="header">

           <h1>Maak een nieuwe rol aan</h1>
    </jsp:attribute>

    <jsp:body>


        <form:form method="POST" commandName="role" action="${pageContext.request.contextPath}/role/add">


              <table class="table table-responsive" border="0">
                <tbody>
                    <tr>
                        <td>Naam</td>
                        <td><form:input path="name" /></td>
                    </tr>

                    <tr>
                        <td><input type="submit" class="btn btn-primary" value="Voeg Toe" /></td>
                        <td></td>
                    </tr>
                </tbody>
            </table>


     </form:form>
        </jsp:body>


    </t:genericpage>

