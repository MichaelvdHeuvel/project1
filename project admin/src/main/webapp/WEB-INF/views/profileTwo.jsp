<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>

    <jsp:body>
        <div class="row">
            <div class="col-sm-10 text-left">
                <h1 style="margin-top:70px;">
                    Henk Sout
                </h1>
            </div>
            <div class="col-sm-2 text-center">
                <div>
                <img class=" img-circle" 
                     src="<c:url value="/resources/img/blank_person.png"/>"
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
                        <span class="pull-left"><strong>Werkzaam sinds:</strong></span> 2004
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
                    <li class="list-group-item text-right"><span class="pull-left">
                            <strong>ervaring (jaren):</strong></span> 16
                    </li>
                </ul> 
                
                <ul class="list-group hidden-xs">
                    <li class="list-group-item text-muted">
                        Instellingen <i class="fa fa-dashboard fa-1x"></i>
                    </li>
                    <li class="list-group-item text-right">
                        <span class="pull-left">
                            <a href="${pageContext.request.contextPath}/profile/tabbed/#"> 
                                <strong>Persoonlijke instellingen</strong>
                            </a>
                        </span> &nbsp;
                            
                    </li>
                    <li class="list-group-item text-right">
                        <span class="pull-left">
                            <a href="${pageContext.request.contextPath}/profile/tabbed/#"> 
                                <strong>C.V. instellingen</strong>
                            </a>
                        </span> &nbsp;
                    </li>
                    <li class="list-group-item text-right">
                        <span class="pull-left">
                            <a href="${pageContext.request.contextPath}/profile/tabbed/#"> 
                                <strong>C.V. uitprinten</strong>
                            </a>
                        </span> &nbsp;
                    </li>
                </ul> 
            </div><!--/col-3-->
            
            <div class="col-sm-9"><!--right col-->
                <div class="nav nav-tabs">
                    <div class="tab-pane container-fluid">
                        <div class="row">
                            <div class="col-sm-6">
                                <h3>Persoonlijke info</h3>

                                privé
                                <ul>
                                    <li>Achternaam: Sout</li>
                                    <li>Tussenvoegsel: </li>
                                    <li>Voornaam: Henk</li>
                                    <li>Adres: Muggenpat</li>
                                    <li>Huisnummer: 23</li> 
                                    <li>Woonplaats: Amsterdam</li> 
                                    <li>Telefoonnummer: 06-39485776</li> 
                                    <li>Email: Henk.Sout@gmail.com</li>
                                </ul>
                                
                            </div><!--./col-sm-6 -->
                            <div class="col-sm-6">
                                <br/><br/><br/>
                                werk
                                <ul>
                                    <li>Personeelsnummer: 345654</li>
                                    <li>Afdeling: Web Design</li>
                                    <li>Taak: Manager</li>
                                    <li>Telefoonnummer: 06-38499506</li> 
                                    <li>Email: h.sout@infosupport.nl</li>
                                </ul>
                            </div><!--./col-sm-6-->
                        </div><!--./row -->
                        <hr/>
                        
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
                        </div><!--./row-->
                        <hr/>
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
                                    <br/><br/><br />
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
                                </div><!--./row-->
                            </div><!--./col-sm-12-->
                        </div><!--./row -->
                        <hr/>
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
                                    <br/> <br/><br/>
                                    <div class="col-sm-6" style="margin-top:-4px;">
                                    <strong>How To Use Bootstrap</strong> 2011<br />
                                    <p style="margin-left:2em;">
                                        <strong>Cursustype</strong>: Web programmeur<br />
                                        <strong>Framework</strong>: 
                                            Bootstrap</span><br />
                                            <span style="margin-left:-0.8em;"><strong>omschrijving</strong>:</span>
                                                cursus voor het begrijpen en 
                                                <span style="margin-left:5.8em;">toepassen van bootstrap.</span>
                                    </div><!--./col-sm-6-->
                                </div><!--./row-->
                            </div><!--./col-sm-12-->
                        </div><!--./row -->
                            <div class="row container-fluid">
                                <hr />
                                <div class="col-sm-12">
                                    <h3>Werkervaring</h3>
                                    <p>
                                        <strong>Login BV, Goor, 2012:</strong><br />
                                        Ontwikkelen van server, pc en “smart device / embedded” software systemen.
                                    </p>
                                    <p>
                                        <strong>Betagraphics, Hengelo, 2011:</strong><br />
                                        Application consultancy m.b.t. Engineering Document Management systemen.
                                    </p>
                                    <p>
                                        <strong>Quatro Software, Enschede, 2011:</strong><br />
                                        Ontwikkelen van maatwerk calculatie advies software. Zowel als stand-alone 
                                        PC applicatie, als in de vorm van een interactieve web applicatie.
                                    </p>
                                    <p>
                                        <strong>Project via een lokaal IT bedrijf 
                                            in Goor voor de gemeente Amsterdam, 2010:</strong><br />
                                        Ontwikkelen van een webservice applicatie ten behoeve van parkeerbeheer diensten 
                                        in aansluiting op een centrale database van het RDW. Ontwikkeltools: Visual Studio, 
                                        SQL Server, ASP.NET, Windows Communication Foundation (WCF).
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div><!--/col-9-->
        </div><!--/row-->
    </jsp:body>


</t:genericpage>
