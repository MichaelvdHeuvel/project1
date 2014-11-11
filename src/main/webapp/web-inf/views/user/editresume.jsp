<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>
    <jsp:body>
       
      
        <div>
        <h2>Cv Instellingen aanpassen</h2>
        <p class="div-box">
            Op deze pagina kunt u aangeven welke items u op uw gegenereerde cv wilt terug zien. 
            Vink een item aan indien u deze op het cv wil plaatsen. Enkele velden zijn verplicht. U kunt onderaan op de knop klikken als u klaar bent om het cv te laten genereren.
        </p>
        
        <div class="container-fluid  div-box" >
            <div class="col-md-3">
                <b>Personalia</b>
                <div class="checkbox">
                    <label>
                        <input type="checkbox"  checked="true" disabled="disabled" value="name">Naam
                    </label>
                </div>
                <div class="checkbox">
                    <label>
                        <input type="checkbox" checked="true" value="address">Adres
                    </label>
                </div>
                <div class="checkbox">
                    <label>
                        <input type="checkbox" checked="true" value="postalcode">Postcode
                    </label>
                </div>
                <div class="checkbox">
                    <label>
                        <input type="checkbox" disabled="disabled" checked="true"  value="city">Woonplaats
                    </label>
                </div>
                <div class="checkbox">
                    <label>
                        <input type="checkbox" checked="true"  value="phone">Telefoonnummer
                    </label>
                </div>
                <div class="checkbox">
                    <label>
                        <input type="checkbox" checked="true" value="mail">E-mailadres
                    </label>
                </div>
                <div class="checkbox">
                    <label>
                        <input type="checkbox" checked="true"  value="birthdate">Geboortedatum
                    </label>
                </div>
                <div class="checkbox">
                    <label>
                        <input type="checkbox" checked="true"  value="nationality">Nationaliteit
                    </label>
                </div>
            </div>
      
            <div class="col-md-3">
                <b>Opleidingen</b>
                <div class="checkbox">
                    <label>
                        <input type="checkbox" value="">Opleiding 1
                    </label>
                </div>
                <div class="subtopic">
                    <ul class="inputs-list" style="list-style-type: none;">
                        <li>
                            <input type="checkbox"  name="subtopic" value="1">
                            <span>Jaartal vanaf</span>
                        </li>
                        <li>
                            <input type="checkbox"  name="subtopic" value="2">
                            <span>Jaartal tot</span>
                        </li>
                        <li>
                            <input type="checkbox"  name="subtopic" value="3">
                            <span>Plaats</span>
                        </li>
                    </ul>
                </div> 
                <div class="checkbox">
                    <label>
                        <input type="checkbox" value="">Opleiding 2
                    </label>
                </div>
                <div class="subtopic">
                    <ul class="inputs-list" style="list-style-type: none;">
                        <li>
                            <input type="checkbox"  name="subtopic" value="1">
                            <span>Jaartal vanaf</span>
                        </li>
                        <li>
                            <input type="checkbox"  name="subtopic" value="2">
                            <span>Jaartal tot</span>
                        </li>
                        <li>
                            <input type="checkbox"  name="subtopic" value="3">
                            <span>Plaats</span>
                        </li>
                    </ul>
                </div> 
            </div>

            <div class="col-md-3">
                <b>Werkervaring</b>
                <div class="checkbox">
                    <label>
                        <input type="checkbox" value="">Werkervaring 1
                    </label>
                </div>
                <div class="checkbox">
                    <label>
                        <input type="checkbox" value="">Werkervaring 2
                    </label>
                </div>
                <div class="checkbox">
                    <label>
                        <input type="checkbox" value="">Werkervaring 3
                    </label>
                </div>
                <div class="checkbox">
                    <label>
                        <input type="checkbox" value="">Werkervaring 4
                    </label>
                </div>


            </div>
            <div class="col-md-3">
                <b>Vaardigheden</b>
                <div class="checkbox">
                    <label>
                        <input type="checkbox" value="">Skill 2
                    </label>
                </div>
                <div class="checkbox">
                    <label>
                        <input type="checkbox" value="">Skill 2
                    </label>
                </div>
                <div class="checkbox">
                    <label>
                        <input type="checkbox" value="">Skill 3
                    </label>
                </div>
                <div class="checkbox">
                    <label>
                        <input type="checkbox" value="">Skill 4
                    </label>
                </div>
                <div class="checkbox">
                    <label>
                        <input type="checkbox" value="">Skill 5
                    </label>
                </div>
                <div class="checkbox">
                    <label>
                        <input type="checkbox" value="">Skill 6
                    </label>
                </div>
                <div class="checkbox">
                    <label>
                        <input type="checkbox" value="">Skill 7
                    </label>
                </div>
            </div>
        </div>
        <div style="margin-top: 40px;">
            <center>
                <a href="${pageContext.request.contextPath}/createPdf/${user.id}"> 
                    <button class="btn btn-lg btn-primary">
                        <strong>C.V. Genereren</strong>
                    </button>
                </a>
            </center>
        </div>
        </div>
    </jsp:body>

</t:genericpage>