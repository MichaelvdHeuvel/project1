<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>
    <jsp:body>
        <div align="center">
                <h2>${pageTitle}</h2>

                <div class="row">
                    <div class="col-sm-6 col-sm-offset-3 col-lg-6 col-lg-offset-3">
                        <form:form method="POST" commandName="user"
                                   action="${pageContext.request.contextPath}/user/edit" role="form">

                            <div class="form-group right-inner-addon">
                                <i class="glyphicon glyphicon-user"></i>
                                <form:input class="form-control" path="firstName" placeholder="Voornaam" />
                                <form:errors path="firstName"></form:errors>
                            </div>
                            
                            <div class="form-group right-inner-addon">
                                <i class="glyphicon glyphicon-user"></i>
                                <form:input class="form-control" path="lastName" placeholder="Achternaam" />
                                <form:errors path="lastName"></form:errors>
                            </div>
                            
                            <div class="form-group right-inner-addon">
                                <i class="glyphicon glyphicon-cloud-upload"></i>
                                <form:input class="form-control" path="emailAddress" placeholder="Email adres" />
                                <form:errors path="emailAddress"></form:errors>
                            </div>
                            
                            <div class="form-group right-inner-addon">
                                <i class="glyphicon glyphicon-envelope"></i>
                                <form:input class="form-control" path="zipcode" placeholder="Postcode" />
                                <form:errors path="zipcode"></form:errors>
                            </div>
                            
                            <div class="row">
                                <div class="col-md-8 col-sm-12">
                                    <div class="form-group right-inner-addon">
                                        <i class="glyphicon glyphicon-home"></i>
                                        <form:input class="form-control" path="address" placeholder="Adres" />
                                        <form:errors path="address"></form:errors>
                                    </div>
                                </div>
                                <div class="col-md-4 hidden-sm">
                                    <div class="form-group right-inner-addon">
                                        <i class="glyphicon glyphicon-home"></i>
                                        <form:input class="form-control" path="addressNumber" placeholder="Huisnummer" />
                                        <form:errors path="addressNumber"></form:errors>
                                    </div>
                                </div>
                            </div>
                            
                            <div class="form-group right-inner-addon">
                                <i class="glyphicon glyphicon-home"></i>
                                <form:input class="form-control" path="city" placeholder="Stad" />
                                <form:errors path="city"></form:errors>
                            </div>
                            
                            
                            <div class="form-group">
                                <form:select class="form-control" path="role" >
                                    <form:option value="${user.role}">
                                        <c:if test="${user.role == 1}">
                                            Medewerker
                                        </c:if>
                                        <c:if test="${user.role == 2}">
                                            Manager
                                        </c:if>
                                        <c:if test="${user.role == 3}">
                                            Administrator
                                        </c:if>
                                    </form:option>
                                </form:select>
                            </div>

                            <form:hidden path="id" />
                            
                             <div class="form-group">    
                                <button type="submit" class="btn btn-success" value="edit">Verzend</button>
                                <a class="btn btn-danger" href="${pageContext.request.contextPath}/profile/user/${user.id}">Annuleer</a>
                            </div>
                        </form:form>
                    </div>
                </div>
            </div>
    </jsp:body>
    
</t:genericpage>