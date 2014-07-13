var web_ca = angular.module('world_app', []);

web_ca.controller("WorldGetCtr", function ($scope, $http) {
    var app = this;

    $http.get("http://localhost:8080/getAllWorlds")
        .success(function (data) {
            $scope.worlds = data;

        }).error(function () {
            alert("fail");
        });
});
