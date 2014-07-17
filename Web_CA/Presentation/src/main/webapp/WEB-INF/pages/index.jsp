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

<body>

<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand">CA Terra</a>
        </div>
        <div class="collapse navbar-collapse" ng-controller="UserByIdGet">
            <ul class="nav navbar-nav navbar-right">
                <li class="active"><a href="#">Home</a></li>
                <li><a href="#">{{User.userFirstName+" "+User.userLastName}}</a></li>
                <li><a href="#">Logout</a></li>
            </ul>
        </div>
    </div>
</div>



<div class = "container">
    <div class = "main" ng-view></div>

</div>
</body>
</html>
