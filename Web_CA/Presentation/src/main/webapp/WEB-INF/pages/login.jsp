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

</head>

<body>

<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Tera CA</a>
        </div>
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav" role="tablist">
                <li class="active"><a onclick = "$(this).parent().parent().find('.active').removeClass('active'); $(this).parent().addClass('active');" href="/"  data-toggle="pill" roll="tab">Welcome</a></li>

            </ul>
            <form class="navbar-form navbar-right" role="form">
                <div class="form-group">
                    <input type="text" placeholder="Email" class="form-control">
                </div>
                <div class="form-group">
                    <input type="password" placeholder="Password" class="form-control">
                </div>
                <button type="submit" class="btn btn-success">Sign in</button>
                <button type="button" class="btn btn-primary btn-large" data-toggle="modal" data-target="#myModal">Register</button>
            </form>
        </div><!--/.nav-collapse -->
    </div>
</div>

 <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="purchaseLabel" aria-hidden="true" ng-controller="UserSetCtr as web_ca">
     <div class="modal-dialog">
         <div class="modal-content">
             <div class="modal-header modal-success">
                 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="purchaseLabel">Sign-up</h4>
                    </div>
                    <div class = "container">
                        <br/>
                        <form class="form-horizontal">
                            <div class="form-group">
                                <label class="col-xs-2 control-label">Firstname</label>
                                <div class="col-xs-4">
                                    <input type="text" id="userFirstName" class="form-control" ng-model="web_ca.user.userFirstName" placeholder="Firstname">
                                    <span class="help-block"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-xs-2 control-label">Lastname</label>
                                <div class="col-xs-4">
                                    <input type="text" id="userLastName" class="form-control" ng-model="web_ca.user.userLastName" placeholder="Lastname">
                                    <span class="help-block"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-xs-2 control-label">Email</label>
                                <div class="col-xs-4">
                                    <input type="email" id="userEmail" class="form-control"  ng-model="web_ca.user.userEmail" placeholder="Email">
                                    <span class="help-block"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-xs-2 control-label">Password</label>
                                <div class="col-xs-4">
                                    <input type="password" id="userPassword" class="form-control"  ng-model="web_ca.user.userPassword" placeholder="Password">
                                    <span class="help-block"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-xs-2 control-label">Retype</label>
                                <div class="col-xs-4">
                                    <input type="password" id="utug" class="form-control" placeholder="Password">
                                    <span class="help-block"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-xs-offset-2 col-xs-4">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                    <button type="button" class="btn btn-primary" ng-click="web_ca.addUser(web_ca.user)">Register</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>



<div class = "container">
    <div class = "main" ng-view></div>

</div>
</body>
</html>
