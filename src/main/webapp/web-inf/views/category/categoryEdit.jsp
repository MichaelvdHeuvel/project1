<%-- 
    Document   : editProject
    Created on : 9-nov-2014, 12:15:34
    Author     : Tim
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@page contentType="text/html" pageEncoding="windows-1252"%>


</script>
<t:genericpage>

    <jsp:body>
        <h1>Categorie wijzigen</h1>

        <form:form method="POST" commandName="category" action="${pageContext.request.contextPath}/category/edit">

            <table class="table table-responsive" border="0">
                <tbody>     
                    <tr>
                        <td>id</td>
                         <td><form:input path="categoryId" readonly="true" /></td>              
                        
                    </tr>
                    <tr>
                        <td>Naam</td>
                    <td><form:input path="name" /></td>
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
