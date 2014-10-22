<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>

<html>

    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Info Support project managment</title>
          <t:resources>  
    </t:resources>
    </head>

    <body>
        <div id="wrapper">

            <!-- Menu-->
            <t:sidebar>
            </t:sidebar>

            <!-- Page Content -->
            <div id="page-wrapper">
                <div class="row">
                    <div class="col-lg-12">
                        <jsp:invoke fragment="header"/>

                        <jsp:doBody/>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <!-- /.row -->
            </div>
            <!-- /#page-wrapper -->


        </div>

        <script src="<%=request.getContextPath()%>/resources/js/jquery-1.11.0.js"></script>
        <script src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
        <script src="<%=request.getContextPath()%>/resources/js/plugins/metisMenu/metisMenu.min.js"></script>
        <script src="<%=request.getContextPath()%>/resources/js/sb-admin-2.js"></script>
        

    </body>
</html>