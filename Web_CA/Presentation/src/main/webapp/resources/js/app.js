var web_ca = angular.module('web_ca', ['ngRoute','rule_app', 'user_app', 'world_app', 'state_app']);
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