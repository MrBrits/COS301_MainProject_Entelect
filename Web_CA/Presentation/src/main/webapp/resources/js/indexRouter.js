var web_ca = angular.module('web_ca', ['ngRoute','rule_app', 'user_app', 'world_app', 'state_app','coordinate_app']);

web_ca.config(['$routeProvider', function($routeProvider) {
    $routeProvider.
     when('/', {
            templateUrl: 'resources/partials/indexHome.jsp'
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
     .when('/settings', {
            templateUrl: 'resources/partials/indexSettings.jsp'
     })
     .when('/simulatorWorld', {
            templateUrl: 'resources/partials/indexSimulator.jsp/#simulatorWorld'
     })
     .when('/simulatorRule', {
            templateUrl: 'resources/partials/indexSimulator.jsp/#simulatorWorld'
     })
     .when('/simulatorState', {
            templateUrl: 'resources/partials/indexSimulator.jsp/#simulatorWorld'
     })
     .otherwise({
     redirectTo : '/' });

}]);