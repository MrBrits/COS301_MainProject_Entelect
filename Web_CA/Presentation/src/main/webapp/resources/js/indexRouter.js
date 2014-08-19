var web_ca = angular.module('web_ca', ['ngRoute','rule_app', 'user_app', 'world_app', 'state_app']);

web_ca.config(['$routeProvider', function($routeProvider) {
    $routeProvider.
     when('/', {
            templateUrl: 'resources/partials/indexHome.jsp'
     })
     .when('/world', {
            templateUrl: 'resources/partials/indexHome.jsp/#world'
     })
     .when('/state', {
            templateUrl: 'resources/partials/indexHome.jsp/#state'
     })
     .when('/rule', {
            templateUrl: 'resources/partials/indexHome.jsp/#rule'
     })
     .when('/profile', {
            templateUrl: 'resources/partials/userProfile.jsp/#rule'
     })
     .when('/home', {
            templateUrl: 'resources/partials/indexHome.jsp'
     })
     .when('/simulator', {
            templateUrl: 'resources/partials/indexSimulator.jsp'
     })
     .otherwise({
     redirectTo : '/' });

}]);