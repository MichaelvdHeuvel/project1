<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

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
                        <jsp:doBody/>
                    </div><!-- /.col-lg-12 -->
                </div><!-- /.row -->
            </div><!-- /#page-wrapper -->
        </div><!-- /.wrapper -->

        <script src="<%=request.getContextPath()%>/resources/js/jquery-1.11.1.js"></script>
        <script src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
        <script src="<%=request.getContextPath()%>/resources/js/plugins/metisMenu/metisMenu.min.js"></script>
        <script src="<%=request.getContextPath()%>/resources/js/sb-admin-2.js"></script>

        <script src="<%=request.getContextPath()%>/resources/js/plugins/dataTables/jquery.dataTables.js"></script>
        <script src="<%=request.getContextPath()%>/resources/js/plugins/dataTables/dataTables.bootstrap.js"></script>

        <script>
            $(document).ready(function() {
                $('#searchResult').DataTable({
                    "oLanguage": {
                        "oPaginate":{
                            "sPrevious" : "vorige",
                            "sNext" : "volgende"
                        },
                        "sSearch": "Zoeken binnen resultaten "
                    },
                });
            } );
        </script>
<script>
            $(document).ready(function () {
                $('#skillTable').DataTable({
                    "language": {
                        "lengthMenu": " _MENU_ resultaten per pagina",
                        "zeroRecords": "Geen items gevonden",
                        "info": "pagina _PAGE_ van de _PAGES_",
                        "infoEmpty": "Er zijn nog geen items toegevoegd",
                        "oPaginate": {
                            "sPrevious": "vorige",
                            "sNext": "volgende"
                        },
                        "sSearch": "Zoeken:",
                        "infoFiltered": "(filtered from _MAX_ total records)"
                    },
                    "aoColumnDefs": [
                        {'bSortable': false, 'aTargets': [2]}
                    ],
                    "aLengthMenu": [10, 25, 50],
                    "bLengthChange": true,
                    "bInfo": true
                });
            });
        </script>
        <script>
            $(document).ready(function () {
                $('#adminList').DataTable({
                    "oLanguage": {
                        "oPaginate":{
                            "sPrevious" : "vorige",
                            "sNext" : "volgende"
                        },
                        "sSearch": "Zoeken binnen resultaten "
                    },
                    "aoColumnDefs": [
                        { 'bSortable': true, 'aTargets': [ 3 ] }
                    ],
                    "aLengthMenu": [6],
                    "bLengthChange": true,
                    "bInfo":true
                });
            });
        </script>
        <script>
            $(document).ready(function () {
                $('#profileSkillTable').DataTable({
                    "language": {
                        "lengthMenu": " _MENU_ resultaten per pagina",
                        "zeroRecords": "Geen items gevonden",
                        "info": "pagina _PAGE_ van de _PAGES_",
                        "infoEmpty": "Er zijn nog geen items toegevoegd",
                        "oPaginate": {
                            "sPrevious": "vorige",
                            "sNext": "volgende"
                        },
                        "sSearch": "Zoeken:",
                        "infoFiltered": "(filtered from _MAX_ total records)"
                    },
                    "aoColumnDefs": [
                        {'bSortable': false, 'aTargets': [2]}
                    ],
                    "aLengthMenu": [10, 25, 50],
                    "bLengthChange": true,
                    "bInfo": true
                });
            });
        </script>
        
        <script>
            setTimeout(function () {
                $('#message').fadeOut('long');
            }, 2000); // <-- time in milliseconds
        </script>
    </body>
</html>