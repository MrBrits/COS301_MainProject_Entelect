/**
 * Created by Laptop on 7/15/2014.
 */
var web_ca = angular.module('rule_app', []);

web_ca.controller("RuleGetCtr", function ($scope, $http) {
    var app = this;

    $http.get("http://localhost:8080/getAllRules")
        .success(function (data) {
            //alert(data);
            $scope.rules = data;

        }).error(function () {
            alert("fail--rule");
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
web_ca.controller("GetRuleByUserId", function ($scope, $http) {
    var app = this;

    $http.get("http://localhost:8080/getRuleByUserId/"+23)
        .success(function (data) {
            $scope.rules = data;
            // alert(JSON.stringify(data));
            //   alert("done");

        }).error(function () {
            alert("error");
        });

});