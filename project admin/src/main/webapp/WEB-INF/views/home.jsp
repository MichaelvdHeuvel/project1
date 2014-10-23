<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>

    <jsp:attribute name="header" >
        
        <h1>Homepage</h1>
    </jsp:attribute>

    <jsp:body>
        <h2>${requestScope.message}</h2>
        
        <form method="post" action="UploadServlet"
		enctype="multipart/form-data">
		Select file to upload: <input type="file" name="file" size="60" /><br />
		<br /> <input type="submit" value="Upload" />
	</form>
       
    </jsp:body>

</t:genericpage>