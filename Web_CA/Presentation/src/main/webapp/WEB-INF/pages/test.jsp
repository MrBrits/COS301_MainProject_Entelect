<html ng-app = "app">
<head>
<link href="resources/css/lib/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/jumbotron.css" rel="stylesheet">
<script src="resources/js/lib/jquery-1.11.1.min.js"></script>
<script src="resources/js/lib/bootstrap.min.js"></script>
<script src="resources/js/lib/angular.min.js"></script>
<script src="resources/js/lib/angular-route.min.js"></script>
<script src="resources/js/lib/angular-resource.min.js"></script>
    <script>
        var web_ca = angular.module('app', []);


        web_ca.controller("UserSetCtr", function($http) {
        var app = this;
        app.addUser = function(user) {
            user.userRole="User";
            $http.post("http://localhost:8080/UserSet",user)
                    .success(function(data) {
                        alert("WIN");
                    }).error(function () {
                        alert("SERVER ERROR");
                    });
        };
        });
    </script>
</head>
<body>
<div >
    <div  ng-controller="UserSetCtr as app">

        <label>firstName</label><input type ="text" ng-model="app.person.userFirstName"/><br>
        <label>lastName</label><input type ="text" ng-model="app.person.userLastName"/><br>
        <label>email</label><input type ="text" ng-model="app.person.userEmail"/><br>
        <label>password</label><input type ="text" ng-model="app.person.userPassword"/><br>
        <label></label><input type="button" ng-click="app.addUser(app.person)" /><br>
        </div>


</div>
</body>
</html>