var web_ca = angular.module('user_app', []);

web_ca.controller("UserSetCtr", function($http) {
    var app = this;

    app.addUser = function(user) {

        var User = user;
        User.userRole="User";
        var jsonstr = JSON.stringify(User);

        $http.post("http://localhost:8080/createUser",jsonstr)
            .success(function(data) {
                alert("Saved");
            }).error(function () {

            });
    };
});
web_ca.controller("UserGetCtr", function ($scope, $http) {
    var app = this;

    $http.get("http://localhost:8080/getAllUsers")
        .success(function (data) {
            $scope.profiles = data;

        }).error(function () {

        });
});
