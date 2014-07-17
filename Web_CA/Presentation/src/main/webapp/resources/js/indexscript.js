var web_ca = angular.module('web_ca_index', ['ngRoute']);
web_ca.config(['$routeProvider', function($routeProvider) {
    $routeProvider.
        when('/36', {
            templateUrl: '../resources/partials/home.jsp'
        })
        .when('/register', {
            templateUrl: '../resources/partials/register.jsp'
        })
        .when('/user', {
            templateUrl: '../resources/partials/users.jsp'
        })
        .when('/world', {
            templateUrl: '../resources/partials/register.jsp/#world'
        })
        .when('/state', {
            templateUrl: '../resources/partials/register.jsp/#state'
        })
        .when('/rule', {
            templateUrl: '../resources/partials/register.jsp/#rule'
        })
        .otherwise({
            redirectTo : '/home'
        })


}]);