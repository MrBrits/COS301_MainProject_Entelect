var web_ca = angular.module('web_ca', ['ngRoute','user_app']);
web_ca.config(['$routeProvider', function($routeProvider) {
    $routeProvider.
        when('/', {
            templateUrl: 'resources/partials/loginHome.jsp'
        });
}]);