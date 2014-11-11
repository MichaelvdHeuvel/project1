<%-- 
    Document   : editProject
    Created on : 9-nov-2014, 12:15:34
    Author     : Faustino
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@page contentType="text/html" pageEncoding="windows-1252"%>


</script>
<t:genericpage>

    <jsp:body>
        <h1>Projecten wijzigen</h1>

        <form:form method="POST" commandName="project" action="${pageContext.request.contextPath}/project/edit">

            <table class="table table-responsive" border="0">
                <tbody>
                    
                        
                        <form:hidden path="projectId" />                 
                        
                    
                    <tr>
                        <td>Projectnaam</td>
                        <td><form:input path="projectName" /></td>                   
                        
                    </tr>
                    <tr>
                        <td>Start Datum (yyyy-mm-dd)</td>
                        <td><form:input path="startDate"   /></td>
                    </tr>
                    <tr>
                        <td>Eind Datum (yyyy-mm-dd)</td>
                        <td><form:input path="endDate" /></td>
                    </tr>
<%--                    <tr>
                        <td>Manager</td>
                        <td><form:hidden path="assignedManager" /></td>
</tr>--%>
                    <tr>
                        <td><input class="btn btn-primary" type="submit" value="Wijzig" /></td>
                        <td></td>
                    </tr>
                </tbody>
            </table>


        </form:form>

    </jsp:body>


</t:genericpage>




