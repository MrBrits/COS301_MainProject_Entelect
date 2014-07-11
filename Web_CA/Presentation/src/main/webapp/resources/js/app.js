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
        .when('/user', {
            templateUrl: 'resources/partials/users.jsp'
        })
        .otherwise({
            redirectTo : '/home'
        })
}]);

web_ca.controller("AppCtrl", function($http) {
    var app = this;

    app.addUser = function(user) {

        var User = user;
        User.userRole="User";
        var jsonstr = JSON.stringify(User);
        alert(jsonstr);
        $http.post("http://localhost:8080/getAll",jsonstr)
            .success(function(data) {
                alert("Saved");
            }).error(function () {

            });
    };
});
web_ca.controller("mycon", function ($scope, $http) {
        var app = this;

        $http.get("http://localhost:8080/getAllProfiles")
            .success(function (data) {
                $scope.profiles = data;

            }).error(function () {

            });
});
