/**
 * Created by Laptop on 7/15/2014.
 */
var User ="";
var site = "localhost:8080";
var web_ca = angular.module('rule_app', []);

web_ca.controller("RuleGetCtr", function ($scope, $http) {
    var app = this;

    $http.get("http://" + site + "/getAllRules")
        .success(function (data) {
            //alert(data);
            $scope.rules = data;

        }).error(function () {
            alert("fail--rule");
        });
});

web_ca.controller("GetRuleByUserId", function ($scope, $http) {
    var app = this;

    var userId=document.getElementById("userId").value;
    $http.get("http://" + site + "/getRuleByUserId/"+userId)
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

        //alert(JSON.stringify(rule));
        //alert(JSON.stringify(res));

        //alert(JSON.stringify(resNeigh));

        //Add RuleCondition
        $http.post("http://" + site + "/AddRuleCons",con)
            .success(function(data) {
                conNeigh.ruleConditionId = data;
                rule.ruleConditionId = data;
                if (data == 0)
                {
                    alert("Rule Condition could not be found");
                }
                //Add RuleConditionNeighbour
                $http.post("http://" + site + "/AddRuleConNeigh", conNeigh)
                    .success(function(data) {
                    }).error(function () {
                        alert("RULE CONDITION NEIGHBOUR: SERVER ERROR");
                });
            }).error(function () {
                alert("RULE CONDITION: SERVER ERROR");
        });

        alert(JSON.stringify("NEIGH " + conNeigh));

        /*
        //Add RuleResult
        $http.post("http://" + site + "/AddRuleRes", res, false)
            .success(function(data) {
                resNeigh.ruleResultId = data;
                rule.ruleResultId = data;
                 if (data == 0)
                 {
                    alert("Rule Result could not be found");
                 }
                 //Add RuleResultNeighbour
                 $http.post("http://" + site + "/AddRuleResNeigh", resNeigh, false)
                     .success(function(data) {
                     alert(data);
                    }).error(function () {
                     alert("RULE RESULT NEIGHBOUR: SERVER ERROR");
                 });
            }).error(function () {
                alert("RULE RESULT: SERVER ERROR");
            });


        //Add Rule
        $http.post("http://" + site + "/AddRule",rule, false)
            .success(function(data) {
                alert(data);
            }).error(function () {
                alert("RULE: SERVER ERROR");
        });
        */

    };

});