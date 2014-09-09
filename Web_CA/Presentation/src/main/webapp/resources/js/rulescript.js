var User ="";
var site = "localhost:8080";
var web_ca = angular.module('rule_app', []);
this.Ruleidtobedeleted=0;

web_ca.controller("RuleManager", function($scope, $http) {
    var app = this;
    var userId=document.getElementById("userId").value;

    $scope.getRules = function(){
        $http.post("http://" + site + "/getRuleByUserId",userId)
            .success(function (data) {
                $scope.rules = data;

            }).error(function () {
                alert("RETRIEVE RULES BY USER ID: SERVER ERROR");
            });
    }

    $scope.addRule = function(rule, con, res, conNeigh, resNeigh) {
        //Add RuleConditionNeighbour
        $http.post("http://" + site + "/AddRuleConNeigh", conNeigh)
            .success(function(data) {
                con.neighboursId = data;
                if (con.compareValueTwo == null) {
                    con.compareValueTwo = -9999;
                }
                if (data == 0) {
                    //This alert should never happen
                    //If it does, then it doesn't find the right object or creates it.
                    alert("Rule Condition Neighbours could not be found");
                }
                else {
                    //Add RuleCondition
                    $http.post("http://" + site + "/AddRuleCon", con)
                        .success(function (data) {
                            rule.ruleConId = data;
                            if (rule.ruleConAndId == null) {
                                rule.ruleConAndId = -9999;
                            }
                            if (rule.ruleConOrId == null) {
                                rule.ruleConOrId = -9999;
                            }
                            if (data == 0) {
                                //This alert should never happen
                                //If it does, then it doesn't find the right object or creates it.
                                alert("Rule Condition could not be found");
                            }
                            else {
                                //Add RuleResultNeighbour
                                $http.post("http://" + site + "/AddRuleResNeigh", resNeigh, false)
                                    .success(function (data) {
                                        res.neighboursId = data;
                                        if (data == 0) {
                                            //This alert should never happen
                                            //If it does, then it doesn't find the right object or creates it.
                                            alert("Rule Result Neighbours could not be found");
                                        }
                                        else {
                                            //Add RuleResult
                                            $http.post("http://" + site + "/AddRuleRes", res, false)
                                                .success(function (data) {
                                                    rule.ruleResId = data;
                                                    if (data == 0) {
                                                        //This alert should never happen
                                                        //If it does, then it doesn't find the right object or creates it.
                                                        alert("Rule Result could not be found");
                                                    }
                                                    else {
                                                        //Add Rule
                                                        rule.ownerId = userId;
                                                        alert(JSON.stringify(rule));
                                                        $http.post("http://" + site + "/AddRule", rule, false)
                                                            .success(function (data) {
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

    $scope.getEditRule = function(ruleId){

        var successBool = false;

        $http.post("http://" + site + "/getRuleById",ruleId)
            .success(function (rule) {
                conId = rule.ruleConId;
                conAndId = rule.ruleConAndId;
                conOrId = rule.ruleConOrId;
                resId = rule.ruleResId;
                $http.post("http://" + site + "/getRuleConById",conId)
                    .success(function (con) {
                        conNeighId = con.neighboursId;

                        $http.post("http://" + site + "/getRuleNeighById",conNeighId)
                            .success(function(conNeigh){
                                document.getElementById("editRuleConNeighIdHidden").value = conNeigh.ruleNeighboursId;
                                document.getElementById("editRuleConNeigh").value = conNeigh.neighbours;

                            }).error(function(){
                                alert("GET EDIT RULE CONDITION NEIGHBOURS: SERVER ERROR");
                            });
                        document.getElementById("editRuleConIdHidden").value = con.ruleConditionId;
                        document.getElementById("editRuleConIsNot").value = con.not;
                        document.getElementById("editRuleConOperation").value = con.operation;
                        document.getElementById("editRuleConOperand").value = con.operand;
                        document.getElementById("editRuleConCompareValueOne").value = con.compareValueOne;
                        document.getElementById("editRuleConCompareValueTwo").value = con.compareValueTwo;

                    }).error(function (){
                        alert("GET EDIT RULE CONDITION: SERVER ERROR");
                    });


                if (conAndId != null)
                {
                    $http.post("http://" + site + "/getRuleConById",conAndId)
                        .success(function (con) {
                            conNeighId = con.neighboursId;

                            $http.post("http://" + site + "/getRuleNeighById",conNeighId)
                                .success(function(conNeigh){
                                    document.getElementById("editRuleConNeighIdHidden").value = conNeigh.ruleNeighboursId;
                                    document.getElementById("editRuleConNeigh").value = conNeigh.neighbours;

                                }).error(function(){
                                    alert("GET EDIT RULE CONDITION AND NEIGHBOURS: SERVER ERROR");
                                });
                            document.getElementById("editRuleConIdHidden").value = con.ruleConditionId;
                            document.getElementById("editRuleConIsNot").value = con.isNot;
                            document.getElementById("editRuleConOperation").value = con.operation;
                            document.getElementById("editRuleConOperand").value = con.operand;
                            document.getElementById("editRuleConCompareValueOne").value = con.compareValueOne;
                            document.getElementById("editRuleConCompareValueTwo").value = con.compareValueTwo;

                        }).error(function (){
                            alert("GET EDIT RULE CONDITION AND: SERVER ERROR");
                        });
                }

                if (conOrId != null)
                {
                    $http.post("http://" + site + "/getRuleConById",conOrId)
                        .success(function (con) {
                            conNeighId = con.neighboursId;

                            $http.post("http://" + site + "/getRuleNeighById",conNeighId)
                                .success(function(conNeigh){
                                    document.getElementById("editRuleConNeighIdHidden").value = conNeigh.ruleNeighboursId;
                                    document.getElementById("editRuleConNeigh").value = conNeigh.neighbours;

                                }).error(function(){
                                    alert("GET EDIT RULE CONDITION OR NEIGHBOURS: SERVER ERROR");
                                });
                            document.getElementById("editRuleConIdHidden").value = con.ruleConditionId;
                            document.getElementById("editRuleConIsNot").value = con.isNot;
                            document.getElementById("editRuleConOperation").value = con.operation;
                            document.getElementById("editRuleConOperand").value = con.operand;
                            document.getElementById("editRuleConCompareValueOne").value = con.compareValueOne;
                            document.getElementById("editRuleConCompareValueTwo").value = con.compareValueTwo;

                        }).error(function (){
                            alert("GET EDIT RULE CONDITION OR: SERVER ERROR");
                        });
                }

                $http.post("http://" + site + "/getRuleResById",resId)
                    .success(function(res){
                        resNeighId = res.neighboursId;

                        alert("OP " + JSON.stringify(res.operation));
                        alert("VAL " + JSON.stringify(res.resultValue));

                        $http.post("http://" + site + "/getRuleNeighById",resNeighId)
                            .success(function(resNeigh){
                                document.getElementById("editRuleResNeighIdHidden").value = resNeigh.ruleNeighboursId;
                                document.getElementById("editRuleResNeigh").value = resNeigh.neighbours;

                            }).error(function(){
                                alert("GET EDIT RULE CONDITION OR NEIGHBOURS: SERVER ERROR");
                            });
                        document.getElementById("editRuleRedIdHidden").value = res.ruleConditionId;
                        document.getElementById("editRuleResOperation").value = res.operation;
                        document.getElementById("editRuleResValue").value = res.resultValue;

                    }).error(function(){
                        alert("GET EDIT RULE RESULT: SERVER ERROR");
                    });
                document.getElementById("editRuleIdHidden").value = rule.ruleId;
                document.getElementById("editRuleName").value = rule.ruleName;
                document.getElementById("editRuleDesc").value = rule.ruleDesc;

            }).error(function () {
                alert("GET EDIT RULE: SERVER ERROR");
            });

    };

    /*
    $scope.editRule = function(){

    };*/

    $scope.deleteRuleFinalize = function() {
        var ruleId=document.getElementById("ruleIdhidden").value;
        $http.post("http://" + site + "/deleteRule",ruleId)
            .success(function (data) {
                alert(data);
            }).error(function () {
                alert("DELETE RULE: SERVER ERROR");
            });
    };
});


/**
 *
 * @param toBeDeleted
 */
function deleteRule(toBeDeleted)
{
    toBeDeleted=toBeDeleted.substr(1);
    var ruleId= toBeDeleted.split(";")[0];
    var ruleName= toBeDeleted.split(";")[1];
    document.getElementById("DeleteNameRule").innerHTML="<h3>Delete Rule: " + ruleName +"</h3>";
    document.getElementById("ruleIdhidden").value=ruleId;
}
