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
            <a class="navbar-brand" href="#">CA Tera</a>
        </div>

        <div class="collapse navbar-collapse" ng-controller="UserByIdGet">
            <ul class="nav navbar-nav navbar-left">
                <li>
                    <a href="#home">Home</a>
                </li>
                <li>
                    <a href="#simulator">Simulator</a>
                </li>
                <li>
                    <a href="#settings">Settings</a>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <form class="navbar-form navbar-left" role="form">
                    <div class="form-group">
                        <div style="width:75%; float: left;">
                            <label class="sr-only" >Enter search terms</label>
                            <input type="search" class="form-control" id="k" name="k" placeholder="Search Worlds">
                            <input id="cn" name="cn" type="hidden" value="false" />
                        </div>
                        <div style="width: 25%; float: left; padding-left: 10px; box-sizing: border-box;">
                            <button   type="submit" id="s" class="btn btn-default">
                                <img style="width: 5px;height: 5" src="resources/img/search.png"/>
                            </button>

                        </div>
                        <div class="clearfix"></div>
                    </div>
                </form>
                <li><img style="position:relative;top:10px;width: 30px;height: 30px" src="resources/img/user.png"/></li>
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
