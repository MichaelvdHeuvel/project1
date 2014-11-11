<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>
    <jsp:body>
        <div align="center">
            <form method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath}/upload/save/image">
		Profiel plaatje wijzigen <input multiple accept='image/*' type="file" name="file">
		<br/><br/><input type="submit" value="Instellen"> 
            </form>
        </div>
    </jsp:body>
    
</t:genericpage>