var web_ca = angular.module('web_ca', ['ngRoute','state_app','user_app','rule_app','world_app']);
web_ca.config(['$routeProvider', function($routeProvider) {
    $routeProvider.
        when('/home', {
            templateUrl: 'resources/partials/home.jsp'
        })
        .when('/register', {
            templateUrl: 'resources/partials/register.jsp'
        })
        .when('/user', {
            templateUrl: 'resources/partials/users.jsp'
        })
        .when('/world', {
            templateUrl: 'resources/partials/register.jsp/#world'
        })
        .when('/state', {
            templateUrl: 'resources/partials/register.jsp/#state'
        })
        .when('/rule', {
            templateUrl: 'resources/partials/register.jsp/#rule'
        })
        .otherwise({
            redirectTo : '/home'
        })


}]);
/*
web_ca.controller("AppCtrl", function($http) {
    var app = this;

    app.addUser = function(user) {

        var User = user;
        User.userRole="User";
        var jsonstr = JSON.stringify(User);
        alert(jsonstr);
        $http.post("http://localhost:8080/createUser",jsonstr)
            .success(function(data) {
                alert("Saved");
            }).error(function () {

            });
    };
});
web_ca.controller("mycon", function ($scope, $http) {
        var app = this;

        $http.get("http://localhost:8080/getAllUsers")
            .success(function (data) {
                $scope.profiles = data;

            }).error(function () {

            });
});
*/