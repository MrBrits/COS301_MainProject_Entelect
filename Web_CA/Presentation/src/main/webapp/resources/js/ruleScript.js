/**
 * Created by Laptop on 7/15/2014.
 */
var User ="";
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

//alert("Done");

    var userId=document.getElementById("userId").value;
    $http.get("http://localhost:8080/getRuleByUserId/"+userId)
        .success(function (data) {
            $scope.rules = data;
            // alert(JSON.stringify(data));
            //   alert("done");

        }).error(function () {
            alert("error");
        });

});