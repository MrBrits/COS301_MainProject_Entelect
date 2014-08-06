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
    //alert("Ddf");
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

web_ca.controller("AddRuleController", function($http) {
    var app = this;
    app.addRule = function(rule, con, res, conNeigh, resNeigh) {
        rule.ownerId=document.getElementById("userId").value;

        alert(JSON.stringify(rule));

        alert(JSON.stringify(con));
        alert(JSON.stringify(res));

        alert(JSON.stringify(conNeigh));
        alert(JSON.stringify(resNeigh));
        /*
        $http.post("http://" + site + "/AddRule",rule)
            .success(function(data) {
                alert(data);
            }).error(function () {
                alert("SERVER ERROR");
        });
        */
    };

});