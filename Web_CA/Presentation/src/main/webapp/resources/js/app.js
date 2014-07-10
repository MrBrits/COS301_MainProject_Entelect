var web_ca = angular.module('web_ca', [
    'ngRoute'
]);

web_ca.config(['$routeProvider', function($routeProvider) {
    $routeProvider.
        when('/home', {
            templateUrl: 'resources/partials/home.jsp'
        })
        .when('/register', {
            templateUrl: 'resources/partials/register.jsp'
        })
        .otherwise({
            redirectTo : '/home'
        })
}]);