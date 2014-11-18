<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>
    <jsp:body>
        <h1>Categorieen</h1>
          <div style="height: 60px;">            <div id="message">${message}</div></div>
        <c:choose>
<c:when test="${categoryList.size() != 0}">

                                <!-- Wanneer er categorieen opgeslagen zijn, worden ze hier getoond -->
                                <div class="table-responsive">
                                    <table id="dataTable" class="table categoryList table-striped table-bordered">
                                        <thead>
                                            <tr>
                                                <th>ID</th>
                                                <th>Categorie naam</th>
                                                <th>Opties</th>
                                                </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach var="category" items="${categoryList}">
                                            <!-- Per categorie wordt nu een rij aangemaakt met daarin zijn gegevens -->
                                            
                                                <tr>
                                                    <td>${category.categoryId}</td>
                                                    <td>${category.name}</td>
       
                                                    <td style="background-color: #fff;"><a href="${pageContext.request.contextPath}/category/edit/${category.categoryId}">Wijzig</a> |
                                                    <a href="${pageContext.request.contextPath}/category/remove/${category.categoryId}">Verbergen</a> 
                                                    
                                                </tr>
                                                
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                    <td><a class="btn btn-primary pull-left" href="${pageContext.request.contextPath}/category/add">Aanmaken</a></td>  
                                </div>
                            </c:when>
                            <c:otherwise>
                                <!-- Als er geen categorieen zijn, wordt deze melding getoond -->
                                Er zijn geen categorieen gevonden.<br>
                                <a href="${pageContext.request.contextPath}/category/add/">Klik hier om een nieuwe categorie aan te maken</a> 
                              
                            </c:otherwise>
                                </c:choose>
                                        
        
        
    </jsp:body>
    
</t:genericpage>








