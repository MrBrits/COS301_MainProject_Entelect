<!DOCTYPE html>
<html lang="en" ng-app = "web_ca">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="resources/img/favicon_12.ico">

    <title>Web CA</title>

    <!-- Bootstrap core CSS -->
    <link href="resources/css/lib/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="resources/css/jumbotron.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <script type="text/javascript" src="resources/js/lib/jquery-2.0.0.min.js"></script>
    <script src="resources/js/lib/bootstrap.min.js"></script>
    <script src="resources/js/lib/angular.min.js"></script>

    <script src="resources/js/indexRouter.js"></script>
    <script src="resources/js/lib/angular-route.min.js"></script>
    <script src="resources/js/lib/angular-resource.min.js"></script>
    <script src="resources/js/config.js"></script>
    <script src="resources/js/statescript.js"></script>
    <script src="resources/js/userscript.js"></script>
    <script src="resources/js/worldscript.js"></script>
    <script src="resources/js/worldclass.js"></script>
    <script src="resources/js/rulescript.js"></script>
    <script src="resources/js/barscript.js"></script>
    <script type="text/javascript" src="resources/js/lib/three.min.js"></script>

    <script src="resources/js/CSS3DRenderer.js"></script>
    <script src="resources/js/lib/tween.min.js"></script>


</head>

<body>
<!--
*
*   For navigation
*
-->
<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" >Web CA</a>
        </div>

        <div class="collapse navbar-collapse" ng-controller="UserByIdGet">
            <ul class="nav navbar-nav navbar-left">
                <li>
                    <a href="#home">Home</a>
                </li>
                <li>
                    <a href="#simulator">Simulator</a>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#profile">${userFullName}</a></li>
                <li><input id ="userId" value="${userId}" type="hidden"></li>
                <li><input id ="worldId" value="${userId}" type="hidden"></li>
                <li><a href="#">Logout</a></li>
            </ul>
        </div>
    </div>
</div>
<!--
*
*   For partials angularjs
*
-->

<br><br>

<div class = "container">
    <div class = "main" ng-view></div>

</div>
</body>
</html>
