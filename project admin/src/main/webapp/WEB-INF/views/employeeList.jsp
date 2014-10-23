<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>

    <jsp:body>
        <div class="row">
            <div align="center" class="col-sm-12">
                <h2>Medewerkers</h2>
                <c:if test="${message != null}">
                    <div class="alert alert-success" role="alert" id="success-alert"><h5>${message}</h5></div>
                </c:if>
          
                <a class="btn btn-default pull-left margin-fix-product-add" href="
                   ${pageContext.request.contextPath}/employee/add">Medewerker toevoegen</a><br /><br />
                
                   
                <c:choose>
                    <c:when test="${employeeSize != null}">
                        <!-- Show the product if a list of products exist!-->
                        <div>
                            <table id="datatable" class="table table-hover  table-responsive table-bordered">
                                <thead>
                                    <tr>
                                        <th>Voornaam</th>
                                        <th>Achternaam</th>
                                        <th>Adres</th>
                                        <th>Huisnummer</th>
                                        <th>Stad</th>
                                        <th>Rol</th>
                                        <th>Acties</th>
                                    </tr>
                                </thead>
                                <c:forEach var="employee" items="${employeeList}">
                                    <!-- For each product a new row will be added-->
                                    <tr>
                                        <td>${employee.employeeFirstName}</td>
                                        <td>${employee.employeeLastName}</td>
                                        <td>${employee.employeeAddress}</td>
                                        <td>${employee.employeeAddressNumber}</td>
                                        <td>${employee.employeeCity}</td>
                                        <td>${employee.role.roleName}</td>
                                        <td align="center">
                                            <a class="btn btn-warning" href="${pageContext.request.contextPath}/employee/edit/${employee.employeeId}">Wijzig</a> 
                                            <a class="btn btn-danger" href="javascript:if(confirm('Weet u het zeker dat u ${employee.employeeFirstName} wil verwijderen?'))
                                   window.location='${pageContext.request.contextPath}/employee/remove/${employee.employeeId}';">Verwijder</a>
                                        </td>
                                    </tr>
                                    
                                </c:forEach>
                            </table>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <!-- When the list of products is empty, this part will be showed-->
                        <div class="alert alert-danger" role="alert">There are no products!</div>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </jsp:body>
    
</t:genericpage>