<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<head>
    <title>Login</title>
    <t:resources>  
    </t:resources>
</head>

<body background="${pageContext.request.contextPath}/resources/img/cloud.jpg" style=" background-size: cover;">

    <div class="container">
        <div class="row">
            <div class="vertical-center col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Login Infosupport</h3>
                    </div>
                    <div class="panel-body">
                        <form role="form">
                            <fieldset>
                                <div class="form-group">
                                    <input class="form-control" placeholder="E-mail" name="email" type="email" autofocus>
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Wachtwoord" name="password" type="password" value="">
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input name="remember" type="checkbox" value="Remember Me">Onthoud mij
                                    </label>
                                </div>
                                
                                <!-- Change this to a button or input when using this as a form -->
                                <a href="${pageContext.request.contextPath}/user/list" class="btn btn-lg btn-primary btn-block">Login</a>
                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script src="<%=request.getContextPath()%>/resources/js/jquery-1.11.0.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/plugins/metisMenu/metisMenu.min.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/sb-admin-2.js"></script>

</body>

</html>
