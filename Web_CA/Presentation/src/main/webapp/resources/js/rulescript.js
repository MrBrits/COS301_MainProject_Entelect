var User ="";
var site = "localhost:8080";
var web_ca = angular.module('rule_app', []);
this.Ruleidtobedeleted=0;
web_ca.controller("RuleGetCtr", function ($scope, $http) {
    var app = this;

    $http.get("http://" + site + "/getAllRules")
        .success(function (data) {
            //alert(data);
            $scope.rules = data;

        }).error(function () {
            alert("RETRIEVE ALL RULES: SERVER ERROR");
        });
});

web_ca.controller("GetRuleByUserId", function ($scope, $http) {
    var app = this;

    var userId=document.getElementById("userId").value;
    $http.get("http://" + site + "/getRuleByUserId/"+userId)
        .success(function (data) {
            $scope.rules = data;

        }).error(function () {
            alert("RETRIEVE RULES BY USER ID: SERVER ERROR");
        });
});

web_ca.controller("AddRuleController", function($http) {
    var app = this;
    app.addRule = function(rule, con, res, conNeigh, resNeigh) {
        rule.ownerId=document.getElementById("userId").value;

        //Add RuleConditionNeighbour
        $http.post("http://" + site + "/AddRuleConNeigh", conNeigh)
            .success(function(data) {
                con.neighboursId = data;
                if (data == 0)
                {
                    //This alert should never happen
                    //If it does, then it doesn't find the right object or creates it.
                    alert("Rule Condition Neighbours could not be found");
                }
                else
                {
                    //Add RuleCondition
                    $http.post("http://" + site + "/AddRuleCons",con)
                        .success(function(data) {
                            rule.ruleConditionId = data;
                            if (data == 0)
                            {
                                //This alert should never happen
                                //If it does, then it doesn't find the right object or creates it.
                                alert("Rule Condition could not be found");
                            }
                            else
                            {
                                //Add RuleResultNeighbour
                                $http.post("http://" + site + "/AddRuleResNeigh", resNeigh, false)
                                    .success(function(data) {
                                        res.neighboursId = data;
                                        if (data == 0)
                                        {
                                            //This alert should never happen
                                            //If it does, then it doesn't find the right object or creates it.
                                            alert("Rule Result Neighbours could not be found");
                                        }
                                        else
                                        {
                                            //Add RuleResult
                                            $http.post("http://" + site + "/AddRuleRes", res, false)
                                                .success(function(data) {
                                                    rule.ruleResultId = data;
                                                    if (data == 0)
                                                    {
                                                        //This alert should never happen
                                                        //If it does, then it doesn't find the right object or creates it.
                                                        alert("Rule Result could not be found");
                                                    }
                                                    else
                                                    {
                                                        //Add Rule
                                                        $http.post("http://" + site + "/AddRule",rule, false)
                                                            .success(function(data) {
                                                                alert(data);
                                                            }).error(function () {
                                                                alert("RULE: SERVER ERROR");
                                                            });
                                                    }
                                                }).error(function () {
                                                    alert("RULE RESULT: SERVER ERROR");
                                                });
                                        }
                                    }).error(function () {
                                        alert("RULE RESULT NEIGHBOUR: SERVER ERROR");
                                    });
                            }
                        }).error(function () {
                            alert("RULE CONDITION: SERVER ERROR");
                        });
                }
            }).error(function () {
                alert("RULE CONDITION NEIGHBOUR: SERVER ERROR");
            });
    };

});
function deleteRule(toBeDeleted)
{
    toBeDeleted=toBeDeleted.substr(1);
    var ruleId= toBeDeleted.split(";")[0];
    var ruleName= toBeDeleted.split(";")[1];
    this.Ruleidtobedeleted=ruleId;
    document.getElementById("DeleteNameRule").innerHTML="<h3>Delete State:"+ruleName+ "</h3>";
}
web_ca.controller("deleteRuleController", function ($scope, $http) {
    var app = this;

    app.deleteRuleFinalize = function() {
        $http.get("http://" + site + "/deleteRule/"+2)
            .success(function (data) {

                alert(data);

            }).error(function () {
                alert("error");
            });
    };

});