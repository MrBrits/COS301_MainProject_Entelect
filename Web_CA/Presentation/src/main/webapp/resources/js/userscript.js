var web_ca = angular.module('user_app', []);

web_ca.controller("UserSetCtr", function($http) {
    var app = this;
    app.addUser = function(user) {
        user.userRole="User";
        alert(JSON.stringify(user))
        $http.post("http://localhost:8080/UserSet",user)
            .success(function(data) {
                alert(data);
            }).error(function () {
                alert("SERVER ERROR");
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
