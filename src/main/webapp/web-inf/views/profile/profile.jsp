<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>
    <jsp:body>
        <div class="row">
            <div class="col-sm-10 text-left">
                <h1 style="margin-top:70px;">
                    ${user.firstName} ${user.lastName}
                </h1>
                    <div id="message"> ${message}</div>
            </div>
            <div class="col-sm-2 text-center">
                <div>
                    <img class=" img-circle" 
                         src="<c:url value="/resources/userfiles/${user.emailAddress}/${user.profileImage}"/>"
                         width="130" height="130"/>
                </div>
            </div>
        </div>
        <br />
        <div class="row">
            <div class="col-sm-3"><!--left col-->
                <ul class="list-group">
                    <li class="list-group-item text-muted">Profiel</li>
                    <li class="list-group-item text-right">
                        <span class="pull-left"><strong>Werkzaam sinds:</strong></span> ${user.createdAt.year+1900}
                    </li>
                    <li class="list-group-item text-right">
                        <span class="pull-left"><strong>Huidige Project: </strong></span> ING mobiel
                    </li>
                </ul> 
                <ul class="list-group">
                    <li class="list-group-item text-muted">
                        ProjectInfo <i class="fa fa-dashboard fa-1x"></i>
                    </li>
                    <li class="list-group-item text-right"><span class="pull-left">
                            <strong>Projecten gedaan:</strong></span> 3
                    </li>
                    <li class="list-group-item text-right"><span class="pull-left">
                            <strong>Projecten nu:</strong></span> 1
                    </li>
                </ul> 

                <c:if test="${user.id == loggedInUser.id}">
                    <ul class="list-group">
                        <li class="list-group-item text-muted">
                            Instellingen <i class="fa fa-dashboard fa-1x"></i>
                        </li>
                        <li class="list-group-item text-right">
                            <span class="pull-left">
                                <a href="${pageContext.request.contextPath}/user/edit/${user.id}"> 
                                    <strong>Profiel instellingen</strong>
                                </a>
                            </span> &nbsp;
                        </li>
                        <li class="list-group-item text-right">
                            <span class="pull-left">
                                <a href="${pageContext.request.contextPath}/resume/edit/${user.id}"> 
                                    <strong>CV. instellingen</strong>
                                </a>
                            </span> &nbsp;
                        </li>
                        <li class="list-group-item text-right hidden-xs">
                            <span class="pull-left">
                                <a href="${pageContext.request.contextPath}/createPdf/${user.id}"> 
                                    <strong>CV. genereren</strong>
                                </a>
                            </span> &nbsp;
                        </li>
                    </ul> 
                </c:if>
            </div><!--/col-3-->

            <div class="col-sm-9"><!--right col-->
                <div class="nav nav-tabs">
                    <div class="tab-pane container-fluid">
                        <div class="row">
                            <div class="col-sm-6">
                                <h3>Persoonlijke info</h3>

                                privé
                                <ul>
                                    <li>Achternaam: ${user.lastName}</li>
                                    <li>Voornaam: ${user.firstName}</li>
                                        <c:if test="${user.id == loggedInUser.id}">
                                        <li>Adres: ${user.address}</li>
                                        <li>Huisnummer: ${user.addressNumber}</li>
                                        <li>Postcode: ${user.zipcode}</li>
                                        <li>Woonplaats: ${user.city}</li>
                                        </c:if>
                                </ul>

                            </div><!--./col-sm-6 -->
                            <div class="col-sm-6">
                                <br/><br/><br/>
                                werk
                                <ul>
                                    <li>Afdeling: Web Design</li>
                                    <li>Taak: 
                                        <c:if test="${user.role == 1}">
                                            Medewerker
                                        </c:if>
                                        <c:if test="${user.role == 2}">
                                            Manager
                                        </c:if>
                                        <c:if test="${user.role == 3}">
                                            Administrator
                                        </c:if>
                                    </li>
                                    <li>Telefoonnummer: ${user.phoneNumber}</li> 
                                    <li>Email: ${user.emailAddress}</li>
                                </ul>
                            </div><!--./col-sm-6-->
                        </div><!--./row -->
                        <!--<hr/>
                        <!--
                        <div class="row">
                            <div class="col-sm-12">
                                <h3>Vaardigheden</h3>
                                <ul>
                                    <li>C++ developer</li>
                                    <li>Java Embedded Systems</li>
                                    <li>Php</li>
                                    <li>Objective C</li>
                                    <li>Sql</li>
                                    <li>Ruby</li>
                                </ul>
                            </div><!--./col-sm-12-->
                        <!-- </div><!--./row-->
                        <!--<hr/>
                        <div class="row">
                            <div class="col-sm-12">
                                <div class="row">
                                    <div class="col-sm-6">
                                        <h3>opleidingen</h3>

                                        <strong>Hogeschool van Amsterdam</strong> 2000 - 2004<br />
                                        <p style="margin-left:2em;">
                                            <strong>Opleiding</strong>: Software Engineering (SE)<br />
                                            <strong>Projecten</strong>: 
                                                Fasten Your Seatbelts<br />
                                                <span style="margin-left:5.1em;">Project Agile Development</span><br />
                                                <span style="margin-left:5.1em;">Enterprise Web Applications</span>
                                        </p>
                                    </div><!--./col-sm-6-->
                        <!--<br/><br/><br />
                        <div class="col-sm-6" style="margin-top:-4px;">
                            <strong>Lagere Technisch Onderwijs</strong> 1996 - 2000<br />
                            <p style="margin-left:2em;">
                                <strong>Opleiding</strong>: Web programmeur<br />
                                <strong>Projecten</strong>: 
                                    How web begins<br />
                                    <span style="margin-left:5.1em;">Leer programmeren</span><br />
                                    <span style="margin-left:5.1em;">Websites voor dummies</span>
                            </p>
                        </div><!--./col-sm-6-->
                        <!--</div><!--./row-->
                        <!--</div><!--./col-sm-12-->
                        <!--</div><!--./row -->
                        <!--<hr/>
                        <div class="row">
                            <div class="col-sm-12">
                                <div class="row">
                                    <div class="col-sm-6">
                                        <h3>Cursussen</h3>
                                        <strong>Webprogramming</strong> 2007<br />
                                        <p style="margin-left:2em;">
                                            <strong>cursustype</strong>: Webprogramming<br />
                                            <span style="margin-left:2.8em;"><strong>Talen</strong>: 
                                                HTML5</span><br />
                                                <span style="margin-left:5.8em;">CSS3</span><br />
                                                <span style="margin-left:5.8em;">JavaScript</span>
                                        </p>
                                    </div><!--./col-sm-6-->
                        <!--<br/> <br/><br/>
                        <div class="col-sm-6" style="margin-top:-4px;">
                        <strong>How To Use Bootstrap</strong> 2011<br />
                        <p style="margin-left:2em;">
                            <strong>Cursustype</strong>: Web programmeur<br />
                            <strong>Framework</strong>: 
                                Bootstrap<br />
                                <span style="margin-left:-0.8em;"><strong>omschrijving</strong>:</span>
                                    cursus voor het begrijpen en 
                                    <span style="margin-left:5.8em;">toepassen van bootstrap.</span>
                        </div><!--./col-sm-6-->
                        <!--</div><!--./row-->
                        <!--</div><!--./col-sm-12-->
                        <!--</div><!--./row -->
                        <!--<div class="row container-fluid">-->
                        <hr /> 
                        <div class="col-sm-12">
                            <h3>Werkervaring</h3>
                        
                            <c:choose>
                                <c:when test="${workExpSize != 0}">
                                    <c:forEach var="workExp" items="${workExp}">
                                        <p>
                                            <strong>${workExp.company}, ${workExp.function}</strong><br />
                                            <h6>${workExp.startDate.year+1900}-${workExp.endDate.year+1900}</h6>
                                            ${workExp.description}
                                        </p>
                                    </c:forEach>
                                </c:when>
                                <c:otherwise>
                                    <p>
                                        Er is nog geen werkervaring toegevoegd aan dit account!
                                    </p>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                </div>
            </div>
        </div><!--/col-9-->
    </jsp:body>

</t:genericpage>