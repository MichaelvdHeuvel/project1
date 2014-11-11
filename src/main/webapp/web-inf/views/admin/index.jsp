<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>
    <jsp:body>
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Dashboard</h1>
            </div><!-- /.col-lg-12 -->
        </div><!-- /.row -->
            <div class="row">
                <div class="col-lg-3 col-md-6">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-4">
                                    <i class="fa fa-envelope fa-5x"></i>
                                </div>
                                <div class="col-xs-8 text-right">
                                    <div class="huge">${requestListSize}</div>
                                    <div>Nieuwe verzoeken</div>
                                </div>
                            </div>
                        </div>
                        <c:choose>
                            <c:when test="${requestListSize != 0}">
                                <a href="${pageContext.request.contextPath}/admin/userrequestlist">
                                    <div class="panel-footer">
                                        <span class="pull-left">Ga naar verzoeken!</span>
                                        <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                        <div class="clearfix"></div>
                                    </div>
                                </a>
                            </c:when>
                            <c:otherwise>
                                <div class="panel-footer">
                                    Geen verzoeken
                                </div>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
    </jsp:body>
    
</t:genericpage>