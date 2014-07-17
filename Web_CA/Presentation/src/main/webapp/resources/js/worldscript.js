var web_ca = angular.module('world_app', []);

web_ca.controller("WorldGetCtr", function ($scope, $http) {
    var app = this;

    $http.get("http://localhost:8080/getAllWorlds")
        .success(function (data) {
            $scope.worlds = data;

        }).error(function () {
            alert("fail--world");
        });
});

web_ca.controller("GetWorldByUserId", function ($scope, $http) {
    var app = this;

    $http.get("http://localhost:8080/getWorldByUserId/"+23)
        .success(function (data) {
            $scope.worlds = data;


        }).error(function () {
            alert("error");
        });

});