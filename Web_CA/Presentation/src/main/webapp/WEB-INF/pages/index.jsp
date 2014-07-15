<!DOCTYPE html>
    <html lang="en" ng-app = "web_ca">
        <head>
            <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <meta name="description" content="">
            <meta name="author" content="">
            <link rel="icon" href="../../favicon.ico">

            <title>Web CA</title>

            <!-- Bootstrap core CSS -->
            <link href="resources/css/lib/bootstrap.min.css" rel="stylesheet">
            <link href="resources/css/jumbotron.css" rel="stylesheet">

            <!-- Custom styles for this template -->
            <script src="resources/js/lib/jquery-1.11.1.min.js"></script>
            <script src="resources/js/lib/bootstrap.min.js"></script>
            <script src="resources/js/lib/angular.min.js"></script>
            <script src="resources/js/lib/angular-route.min.js"></script>
            <script src="resources/js/lib/angular-resource.min.js"></script>
            <script src="resources/js/app.js"></script>
            <script src="resources/js/statescript.js"></script>
            <script src="resources/js/userscript.js"></script>
            <script src="resources/js/worldscript.js"></script>
            <script src="resources/js/rulescript.js"></script>

        </head>

        <body onload="getStuff()">

        <h1>LOGIN</h1>



        <div class = "container">
            <div class = "main" ng-view></div>

        </div>
    </body>
</html>
