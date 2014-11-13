<%@tag description="Sidebar Template" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>

<!-- Navigation -->
<nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 3px;">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="${pageContext.request.contextPath}/"><img src="<%=request.getContextPath()%>/resources/img/logo.png" alt=""/>
        </a>
    </div>
    <!-- /.navbar-header -->

    <ul class="nav navbar-top-links navbar-right">
        <c:if test="${loggedInUser.role == '3'}">
            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                    <i class="fa fa-envelope fa-fw"></i>
                    <c:if test="${requestListSize != 0}">
                        <span class="badge">
                            ${requestListSize}
                        </span>  
                    </c:if>
                        <i class="fa fa-caret-down"></i>
                </a>
                <ul class="dropdown-menu dropdown-messages">
                    <c:choose>
                        <c:when test="${requestList.size() != 0}">
                            <c:forEach begin="0" end="3" var="request" items="${requestList}">
                                <li>
                                <a href="#">
                                    <div>
                                        <strong>${request.requester.firstName} ${request.requester.lastName}</strong>
                                        <span class="pull-right text-muted">
                                            <em>${request.requestDate.date}/${request.requestDate.month+1}/${request.requestDate.year+1900}</em>
                                        </span>
                                    </div>
                                    <div>${request.request}</div>
                                </a>
                            </li>
                            <li class="divider"></li>
                            </c:forEach>
                            <li>
                                <a class="text-center" href="${pageContext.request.contextPath}/admin/userrequestlist">
                                    <strong>Lees alle verzoeken</strong>
                                    <i class="fa fa-angle-right"></i>
                                </a>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li class="text-center">
                                Geen verzoeken gevonden
                            </li>
                        </c:otherwise>
                    </c:choose>
                </ul>
                <!-- /.dropdown-messages -->
            </li>
            <!-- /.dropdown -->
            <!--<li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                    <i class="fa fa-tasks fa-fw"></i>  <i class="fa fa-caret-down"></i>
                </a>
                <ul class="dropdown-menu dropdown-tasks">
                    <li>
                        <a href="#">
                            <div>
                                <p>
                                    <strong>Task 1</strong>
                                    <span class="pull-right text-muted">40% Complete</span>
                                </p>
                                <div class="progress progress-striped active">
                                    <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 40%">
                                        <span class="sr-only">40% Complete (success)</span>
                                    </div>
                                </div>
                            </div>
                        </a>
                    </li>
                    <li class="divider"></li>
                    <li>
                        <a href="#">
                            <div>
                                <p>
                                    <strong>Task 2</strong>
                                    <span class="pull-right text-muted">20% Complete</span>
                                </p>
                                <div class="progress progress-striped active">
                                    <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100" style="width: 20%">
                                        <span class="sr-only">20% Complete</span>
                                    </div>
                                </div>
                            </div>
                        </a>
                    </li>
                    <li class="divider"></li>
                    <li>
                        <a href="#">
                            <div>
                                <p>
                                    <strong>Task 3</strong>
                                    <span class="pull-right text-muted">60% Complete</span>
                                </p>
                                <div class="progress progress-striped active">
                                    <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%">
                                        <span class="sr-only">60% Complete (warning)</span>
                                    </div>
                                </div>
                            </div>
                        </a>
                    </li>
                    <li class="divider"></li>
                    <li>
                        <a href="#">
                            <div>
                                <p>
                                    <strong>Task 4</strong>
                                    <span class="pull-right text-muted">80% Complete</span>
                                </p>
                                <div class="progress progress-striped active">
                                    <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 80%">
                                        <span class="sr-only">80% Complete (danger)</span>
                                    </div>
                                </div>
                            </div>
                        </a>
                    </li>
                    <li class="divider"></li>
                    <li>
                        <a class="text-center" href="#">
                            <strong>See All Tasks</strong>
                            <i class="fa fa-angle-right"></i>
                        </a>
                    </li>
                </ul>
                <!-- /.dropdown-tasks -->
            <!--</li>
            <!-- /.dropdown -->
            <!--<li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                    <i class="fa fa-bell fa-fw"></i>  <i class="fa fa-caret-down"></i>
                </a>
                <ul class="dropdown-menu dropdown-alerts">
                    <li>
                        <a href="#">
                            <div>
                                <i class="fa fa-comment fa-fw"></i> New Comment
                                <span class="pull-right text-muted small">4 minutes ago</span>
                            </div>
                        </a>
                    </li>
                    <li class="divider"></li>
                    <li>
                        <a href="#">
                            <div>
                                <i class="fa fa-twitter fa-fw"></i> 3 New Followers
                                <span class="pull-right text-muted small">12 minutes ago</span>
                            </div>
                        </a>
                    </li>
                    <li class="divider"></li>
                    <li>
                        <a href="#">
                            <div>
                                <i class="fa fa-envelope fa-fw"></i> Message Sent
                                <span class="pull-right text-muted small">4 minutes ago</span>
                            </div>
                        </a>
                    </li>
                    <li class="divider"></li>
                    <li>
                        <a href="#">
                            <div>
                                <i class="fa fa-tasks fa-fw"></i> New Task
                                <span class="pull-right text-muted small">4 minutes ago</span>
                            </div>
                        </a>
                    </li>
                    <li class="divider"></li>
                    <li>
                        <a href="#">
                            <div>
                                <i class="fa fa-upload fa-fw"></i> Server Rebooted
                                <span class="pull-right text-muted small">4 minutes ago</span>
                            </div>
                        </a>
                    </li>
                    <li class="divider"></li>
                    <li>
                        <a class="text-center" href="#">
                            <strong>See All Alerts</strong>
                            <i class="fa fa-angle-right"></i>
                        </a>
                    </li>
                </ul>
                <!-- /.dropdown-alerts -->
            <!--</li>
        </c:if>
        <!-- /.dropdown -->
        <li class="dropdown pull-right">
            <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                <i class="fa fa-user fa-fw"></i>  <i class="fa fa-caret-down"></i>
            </a>
            <ul class="dropdown-menu dropdown-user">
                <li><a href="${pageContext.request.contextPath}/profile/user/${loggedInUser.id}"><i class="fa fa-user fa-fw"></i>
                    ${loggedInUser.firstName}
                    </a>
                </li>
                <li><a href="${pageContext.request.contextPath}/upload/profile/image"><i class="fa fa-picture-o"></i> wijzig plaatje</a>
                </li>
                <li><a href="${pageContext.request.contextPath}/user/edit/password/${loggedInUser.id}"><i class="fa fa-gear fa-fw"></i>Wijzig wachtwoord</a>
                </li>
                <li class="divider"></li>
                <li>
                    <a href="${pageContext.request.contextPath}/logout">
                        uitloggen
                    </a>
                </li>
            </ul>
            <!-- /.dropdown-user -->
        </li>
        <!-- /.dropdown -->
    </ul>
    <!-- /.navbar-top-links -->

    
    <div class="navbar-default sidebar" role="navigation">
        <div class="sidebar-nav navbar-collapse">
            
            <ul class="nav" id="side-menu">
                
                    <li class="sidebar-search">
                        
                        <form:form method="POST" commandName="user"
                                   action="${pageContext.request.contextPath}/searchresult">
                        <div class="input-group custom-search-form">
                            <input type="text" class="form-control" 
                                placeholder="Zoeken..." path="firstName" id="firstName" name="firstName">
                            
                            <span class="input-group-btn">
                                <button class="btn btn-default" type="submit">
                                    <i class="glyphicon glyphicon-search"></i>
                                </button>
                            </span>
                        </div>

                        <!-- /input-group -->
                        </form:form>
                    </li>
                
                <li>
                    <a href="${pageContext.request.contextPath}/"><i class="glyphicon glyphicon-home"></i> Home</a>
                </li> 
                <c:if test="${loggedInUser.role != '3'}">
                    <li>
                        <a href="${pageContext.request.contextPath}/userrequest/add"><i class="fa fa-envelope"></i> Verzoek indienen</a>
                    </li>
                </c:if>
                <c:if test="${loggedInUser.role == '3'}">
                    <li>
                        <a href="#"><i class="fa fa-wrench fa-fw"></i> Gebruikers Beheer<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="${pageContext.request.contextPath}/admin/userlist"><i class="fa fa-user"></i> Alle gebruikers</a>
                            </li>
                        </ul>
                    </li>
                </c:if>
                <c:if test="${loggedInUser.role != '3'}">
                    <li>
                        <a href="#"><i class="glyphicon glyphicon-th-list"></i> Projecten<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <c:if test="${loggedInUser.role != '3'}">
                                <li>
                                    <a href="${pageContext.request.contextPath}/project/list"><i class="glyphicon glyphicon-list-alt"></i> Lijst</a>
                                </li>
                            </c:if>
                            <c:if test="${loggedInUser.role == '2'}">
                            <li>
                                <a href="${pageContext.request.contextPath}/project/add"><i class="fa fa-edit fa-fw"></i> Aanmaken</a>
                            </li>
                            </c:if>    
                        </ul>
                    </li>
                </c:if>
                    <li>
                        <a href="#"><i class="glyphicon glyphicon-user"></i> Profiel<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="${pageContext.request.contextPath}/profile/add/workexperience"><i class="glyphicon glyphicon-briefcase"></i> Werkervaring toevoegen</a>
                            </li>
                        </ul>
                    </li>
            </ul>
            
        </div>
        <!-- /.sidebar-collapse -->
    </div>
    <!-- /.navbar-static-side -->
</nav>