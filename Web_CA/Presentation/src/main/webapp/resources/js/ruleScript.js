var web_ca = angular.module('rule_app', []);

web_ca.controller("RuleGetCtr", function ($scope, $http) {
    var app = this;

    $http.get("http://localhost:8080/getAllRules")
        .success(function (data) {
            //alert(data);
            $scope.rules = data;

        }).error(function () {
            alert("fail");
        });
});
web_ca.controller("RuleSetCtr", function ($scope, $http) {
    var app = this;
/*
    $http.get("http://localhost:8080/getAllRules")
        .success(function (data) {
            //alert(data);
            $scope.rules = data;

        }).error(function () {
            alert("fail");
        });*/
    alert("Ddf");
});