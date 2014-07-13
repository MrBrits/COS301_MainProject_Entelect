var web_ca = angular.module('state_app', []);

web_ca.controller("StateGetCtr", function ($scope, $http) {
    var app = this;

    $http.get("http://localhost:8080/getAllStates")
        .success(function (data) {
            $scope.states = data;

        }).error(function () {
            alert("fail");
        });
});
