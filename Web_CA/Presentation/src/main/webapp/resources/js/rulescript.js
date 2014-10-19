var User ="";
var site = new config().getSite();
var web_ca = angular.module('rule_app', []);
this.Ruleidtobedeleted=0;


var countAdd1Selected = false;
var btwAdd1Selected = false;
var countAdd2Selected = false;
var btwAdd2Selected = false;

var countEdit1Selected = false;
var btwEdit1Selected = false;
var countEdit2Selected = false;
var btwEdit2Selected = false;

var resultAddValueSelected = false;
var resultEditValueSelected = false;


function evaluateAdd1Operation(){
    var operationAdd1 = document.getElementById("addRuleCon1Operation").value;

    if (operationAdd1 == "COUNT"){
        countAdd1Selected = true;
        document.getElementById("addRule1BE").disabled = true;
        document.getElementById("addRule1BI").disabled = true;
        document.getElementById("addRule1CompareValueTwo").disabled = false;
        document.getElementById("addRule1CompareValueTwo").value = null;

        $('#addRule1CompareValueOne').attr('placeholder','Value to be counted (What Value?)');
        $('#addRule1CompareValueTwo').attr('placeholder','Least amount to be counted (How many?)');

    }
    else{
        countAdd1Selected = false;
        if (btwAdd1Selected == false) {
            document.getElementById("addRule1BE").disabled = false;
            document.getElementById("addRule1BI").disabled = false;
            document.getElementById("addRule1CompareValueTwo").disabled = true;
            document.getElementById("addRule1CompareValueTwo").value = null;

            $('#addRule1CompareValueOne').attr('placeholder', 'Choose State Value');
            $('#addRule1CompareValueTwo').attr('placeholder', 'Used with COUNT or BETWEEN');
        }
    }
}
function evaluateAdd2Operation(){
    var operationAdd2 = document.getElementById("addRuleCon2Operation").value;

    if (operationAdd2 == "COUNT" ){
        countAdd2Selected = true;
        document.getElementById("addRule2BE").disabled = true;
        document.getElementById("addRule2BI").disabled = true;
        document.getElementById("addRule2CompareValueTwo").disabled = false;
        document.getElementById("addRule2CompareValueTwo").value = null;

        $('#addRule2CompareValueOne').attr('placeholder','Value to be counted (What Value?)');
        $('#addRule2CompareValueTwo').attr('placeholder','Least amount to be counted (How many?)');
    }
    else{
        countAdd2Selected = false;
        if (btwAdd2Selected == false) {
            document.getElementById("addRule2BE").disabled = false;
            document.getElementById("addRule2BI").disabled = false;
            document.getElementById("addRule2CompareValueTwo").disabled = true;
            document.getElementById("addRule2CompareValueTwo").value = null;

            $('#addRule2CompareValueOne').attr('placeholder', 'Choose State Value');
            $('#addRule2CompareValueTwo').attr('placeholder', 'Used with COUNT or BETWEEN');
        }
    }
}


function evaluateAdd1Operand(){
    var operandAdd1 = document.getElementById("addRuleCon1Operand").value;

    if (operandAdd1 == "BE" || operandAdd1 == "BI"){
        btwAdd1Selected = true;
        document.getElementById("addRule1Count").disabled = true;
        document.getElementById("addRule1CompareValueTwo").disabled = false;
        document.getElementById("addRule1CompareValueTwo").value = null;

        $('#addRule1CompareValueOne').attr('placeholder','Choose State Value (Lower Value)');
        $('#addRule1CompareValueTwo').attr('placeholder','Choose State Value (Upper Value)');
    }
    else{
        btwAdd1Selected = false;
        if (countAdd1Selected == false) {
            document.getElementById("addRule1Count").disabled = false;
            document.getElementById("addRule1CompareValueTwo").disabled = true;
            document.getElementById("addRule1CompareValueTwo").value = null;

            $('#addRule1CompareValueOne').attr('placeholder', 'Choose State Value');
            $('#addRule1CompareValueTwo').attr('placeholder', 'Used with COUNT or BETWEEN');
        }
    }
}
function evaluateAdd2Operand(){
    var operandAdd2 = document.getElementById("addRuleCon2Operand").value;

    if (operandAdd2 == "BE" || operandAdd2 == "BI"){
        btwAdd2Selected = true;
        document.getElementById("addRule2Count").disabled = true;
        document.getElementById("addRule2CompareValueTwo").disabled = false;
        document.getElementById("addRule2CompareValueTwo").value = null;

        $('#addRule2CompareValueOne').attr('placeholder','Choose State Value (Lower Value)');
        $('#addRule2CompareValueTwo').attr('placeholder','Choose State Value (Upper Value)');
    }
    else{
        btwAdd2Selected = false;
        if (countAdd2Selected == false) {
            document.getElementById("addRule2Count").disabled = false;
            document.getElementById("addRule2CompareValueTwo").disabled = true;
            document.getElementById("addRule2CompareValueTwo").value = null;

            $('#addRule2CompareValueOne').attr('placeholder', 'Choose State Value');
            $('#addRule2CompareValueTwo').attr('placeholder', 'Used with COUNT or BETWEEN');
        }
    }
}

function evaluateAddCompareValue(){
        var value1One = document.getElementById("addRule1CompareValueOne").value;
        var value1Two = document.getElementById("addRule1CompareValueTwo").value;
        var value2One = document.getElementById("addRule2CompareValueOne").value;
        var value2Two = document.getElementById("addRule2CompareValueTwo").value;

        if (btwAdd1Selected) {
            if (parseFloat(value1One) >= parseFloat(value1Two)) {
                document.getElementById("datavalue").innerHTML="<p>Incorrect values: Compare Value Two should be larger than Compare Value One</p>";
                $('#Information').modal('show');
                document.getElementById("addRule1CompareValueTwo").value = null;
            }
        }

        if (btwAdd2Selected) {
            if (parseFloat(value2One) >= parseFloat(value2Two)) {

                document.getElementById("datavalue").innerHTML="<p>Incorrect values: Compare Value Two should be larger than Compare Value One</p>";
                $('#Information').modal('show');
                document.getElementById("addRule2CompareValueTwo").value = null;
            }
        }
}

function evaluateAddResult(){
    var resultAddValue = document.getElementById("addRuleResValue").value;
    var resultAddOperation = document.getElementById("addRuleResOperation").value;

    var resNeighNameDefault = "addResNeigh";
    var resNeighID = "";
    var resIdNum = 0;

    if (resultAddValue != ""){
        document.getElementById("addRuleResOperation").disabled = true;
        document.getElementById("addRuleResOperation").value = null;
        for (var i = 0; i < 27; i++){
            resIdNum = i + 1;
            resNeighID = resNeighNameDefault.concat(resIdNum.toString());
            document.getElementById(resNeighID).checked = false;
            document.getElementById(resNeighID).disabled = true;
        }
        resultAddValueSelected = true;
    }
    else {
        document.getElementById("addRuleResOperation").disabled = false;
        for (var i = 0; i < 27; i++){
            resIdNum = i + 1;
            resNeighID = resNeighNameDefault.concat(resIdNum.toString());
            document.getElementById(resNeighID).disabled = false;
        }
        resultAddValueSelected = false;
    }

    if (resultAddOperation != ""){
        document.getElementById("addRuleResValue").value = null;
        document.getElementById("addRuleResValue").disabled = true;
        resultAddValueSelected = false;
    }
    else {
        document.getElementById("addRuleResValue").disabled = false;
        resultAddValueSelected = true;
        for (var i = 0; i < 27; i++){
            resIdNum = i + 1;
            resNeighID = resNeighNameDefault.concat(resIdNum.toString());
            var checked = document.getElementById(resNeighID).checked;
            if (checked){
                document.getElementById("addRuleResValue").disabled = true;
                document.getElementById("addRuleResValue").value = null;
                resultAddValueSelected = false;
                break;
            }
            else
            {
                document.getElementById("addRuleResValue").disabled = false;
                resultAddValueSelected = true;
            }
        }
    }


}


function evaluateEditOperation(data){
    var operationEdit1 = document.getElementById("editRuleCon1Operation").value;
    var operationEdit2 = document.getElementById("editRuleCon2Operation").value;

    if (data.equals("NEW")) {
        if (operationEdit1 == "COUNT") {
            countEdit1Selected = true;
            document.getElementById("editRule1BE").disabled = true;
            document.getElementById("editRule1BI").disabled = true;
            document.getElementById("editRuleCon1CompareValueTwo").disabled = false;
            document.getElementById("editRuleCon1CompareValueTwo").value = null;

            $('#editRuleCon1CompareValueOne').attr('placeholder', 'Value to be counted (What Value?)');
            $('#editRuleCon1CompareValueTwo').attr('placeholder', 'Least amount to be counted (How many?)');

        }
        else {
            countEdit1Selected = false;
            if (btwEdit1Selected == false) {
                document.getElementById("editRule1BE").disabled = false;
                document.getElementById("editRule1BI").disabled = false;
                document.getElementById("editRuleCon1CompareValueTwo").disabled = true;
                document.getElementById("editRuleCon1CompareValueTwo").value = null;

                $('#editRuleCon1CompareValueOne').attr('placeholder', 'Choose State Value');
                $('#editRuleCon1CompareValueTwo').attr('placeholder', 'Used with COUNT or BETWEEN');
            }
        }

        if (operationEdit2 == "COUNT") {
            countEdit2Selected = true;
            document.getElementById("editRule2BE").disabled = true;
            document.getElementById("editRule2BI").disabled = true;
            document.getElementById("editRuleCon2CompareValueTwo").disabled = false;
            document.getElementById("editRuleCon2CompareValueTwo").value = null;

            $('#editRuleCon2CompareValueOne').attr('placeholder', 'Value to be counted (What Value?)');
            $('#editRuleCon2CompareValueTwo').attr('placeholder', 'Least amount to be counted (How many?)');
        }
        else {
            countEdit2Selected = false;
            if (btwEdit2Selected == false) {
                document.getElementById("editRule2BE").disabled = false;
                document.getElementById("editRule2BI").disabled = false;
                document.getElementById("editRuleCon2CompareValueTwo").disabled = true;
                document.getElementById("editRuleCon2CompareValueTwo").value = null;

                $('#editRuleCon2CompareValueOne').attr('placeholder', 'Choose State Value');
                $('#editRuleCon2CompareValueTwo').attr('placeholder', 'Used with COUNT or BETWEEN');
            }
        }
    }
    else if (data.equals("OLD")) {

    }

}

function evaluateEditOperand(){
    var operandEdit1 = document.getElementById("editRuleCon1Operand").value;
    var operandEdit2 = document.getElementById("editRuleCon2Operand").value;

    if (operandEdit1 == "BE" || operandEdit1 == "BI"){
        btwEdit1Selected = true;
        document.getElementById("editRule1Count").disabled = true;
        document.getElementById("editRuleCon1CompareValueTwo").disabled = false;
        document.getElementById("editRuleCon1CompareValueTwo").value = null;

        $('#editRuleCon1CompareValueOne').attr('placeholder','Choose State Value (Lower Value)');
        $('#editRuleCon1CompareValueTwo').attr('placeholder','Choose State Value (Upper Value)');
    }
    else{
        btwEdit1Selected = false;
        if (countEdit1Selected == false) {
            document.getElementById("editRule1Count").disabled = false;
            document.getElementById("editRuleCon1CompareValueTwo").disabled = true;
            document.getElementById("editRuleCon1CompareValueTwo").value = null;

            $('#editRuleCon1CompareValueOne').attr('placeholder', 'Choose State Value');
            $('#editRuleCon1CompareValueTwo').attr('placeholder', 'Used with COUNT or BETWEEN');
        }
    }

    if (operandEdit2 == "BE" || operandEdit2 == "BI"){
        btwEdit2Selected = true;
        document.getElementById("editRule2Count").disabled = true;
        document.getElementById("editRuleCon2CompareValueTwo").disabled = false;
        document.getElementById("editRuleCon2CompareValueTwo").value = null;

        $('#editRuleCon2CompareValueOne').attr('placeholder','Choose State Value (Lower Value)');
        $('#editRuleCon2CompareValueTwo').attr('placeholder','Choose State Value (Upper Value)');
    }
    else{
        btwEdit2Selected = false;
        if (countEdit2Selected == false) {
            document.getElementById("editRule2Count").disabled = false;
            document.getElementById("editRuleCon2CompareValueTwo").disabled = true;
            document.getElementById("editRuleCon2CompareValueTwo").value = null;

            $('#editRuleCon2CompareValueOne').attr('placeholder', 'Choose State Value');
            $('#editRuleCon2CompareValueTwo').attr('placeholder', 'Used with COUNT or BETWEEN');
        }
    }
}


function evaluateEditResult(){
    var resultEditValue = document.getElementById("editRuleResValue").value;
    var resultEditOperation = document.getElementById("editRuleResOperation").value;

    var resNeighNameDefault = "editResNeigh";
    var resNeighID = "";
    var resIdNum = 0;

    if (resultEditValue != ""){
        document.getElementById("editRuleResOperation").disabled = true;
        document.getElementById("editRuleResOperation").value = null;
        for (var i = 0; i < 27; i++){
            resIdNum = i + 1;
            resNeighID = resNeighNameDefault.concat(resIdNum.toString());
            document.getElementById(resNeighID).checked = false;
            document.getElementById(resNeighID).disabled = true;
        }
        resultEditValueSelected = true;
    }
    else {
        document.getElementById("editRuleResOperation").disabled = false;
        for (var i = 0; i < 27; i++){
            resIdNum = i + 1;
            resNeighID = resNeighNameDefault.concat(resIdNum.toString());
            document.getElementById(resNeighID).disabled = false;
        }
        resultEditValueSelected = false;
    }

    if (resultEditOperation != ""){
        document.getElementById("editRuleResValue").value = null;
        document.getElementById("editRuleResValue").disabled = true;
        resultEditValueSelected = false;
    }
    else {
        document.getElementById("editRuleResValue").disabled = false;
        resultEditValueSelected = true;
        for (var i = 0; i < 27; i++){
            resIdNum = i + 1;
            resNeighID = resNeighNameDefault.concat(resIdNum.toString());
            var checked = document.getElementById(resNeighID).checked;
            if (checked){
                document.getElementById("editRuleResValue").disabled = true;
                document.getElementById("editRuleResValue").value = null;
                resultEditValueSelected = false;
                break;
            }
            else
            {
                document.getElementById("editRuleResValue").disabled = false;
                resultEditValueSelected = true;
            }
        }
    }


}


function evaluateEditCompareValue(){

        if (btwEdit1Selected) {
            var value1One = document.getElementById("editRule1CompareValueOne").value;
            var value1Two = document.getElementById("editRule1CompareValueTwo").value;

            if (parseFloat(value1One) >= parseFloat(value1Two)) {

                document.getElementById("datavalue").innerHTML="<p>Incorrect values: Compare Value Two should be larger than Compare Value One</p>";
                $('#Information').modal('show');
                document.getElementById("editRule1CompareValueTwo").value = null;
            }
        }

        if (btwEdit2Selected) {
            var value2One = document.getElementById("editRule2CompareValueOne").value;
            var value2Two = document.getElementById("editRule2CompareValueTwo").value;

            if (parseFloat(value2One) >= parseFloat(value2Two)) {
                document.getElementById("datavalue").innerHTML="<p>Incorrect values: Compare Value Two should be larger than Compare Value One</p>";
                $('#Information').modal('show');
                document.getElementById("editRule2CompareValueTwo").value = null;
            }
        }
}

web_ca.controller("RuleSimulator", function($scope, $http) {
    var userId=document.getElementById("userId").value;
        $http.post("http://" + site + "/getRuleByUserId", userId)
            .success(function (data) {
                $scope.rules = data;

            }).error(function () {
                document.getElementById("datavalue").innerHTML="<p>Rule could not be found. Please contact support.</p>";
                $('#Information').modal('show');
            });

});
web_ca.controller("RuleManager", function($scope, $http) {
    var app = this;
    var userId=document.getElementById("userId").value;

    $scope.getRules = function(){
        $http.post("http://" + site + "/getRuleByUserId",userId)
            .success(function (data) {
                $scope.rules = data;

            }).error(function () {
                document.getElementById("datavalue").innerHTML="<p>Rule could not be found. Please contact support.</p>";
                $('#Information').modal('show');
            });
    }

    $scope.addRuleEditor = function(s) {


        var tempStr= s.line1+"br";
        tempStr+= s.line2+"br";
        tempStr+= s.line3;
        alert(tempStr);
       $http.post("http://" + site + "/createRuleByString",tempStr)
            .success(function (data) {

               document.getElementById("datavalue").innerHTML="<p>"+s+"</p>";
               document.getElementById("informationClose").onclick=close_information;
               $('#Information').modal('show');

            }).error(function () {
               document.getElementById("datavalue").innerHTML="<p>Rule could not be found. Please contact support.</p>";
               $('#Information').modal('show');
            });

    }

    $scope.addRule = function(rule, con, conAndOr, res) {

        var addCon1NeighArray = new Array(27);
        var con1NeighNameDefault = "addCon1Neigh";
        var con1NeighID = "";
        var con1IdNum = 0;
        var conNeigh = "";
        for (var i = 0; i < 27; i++){
            con1IdNum = i + 1;
            con1NeighID = con1NeighNameDefault.concat(con1IdNum.toString());
            addCon1NeighArray[i] = document.getElementById(con1NeighID).checked;
        }
        for (var i = 0; i < 27; i++){
            if (addCon1NeighArray[i]){
                conNeigh += "1";
            }
            else{
                conNeigh += "0";
            }
        }


        if (conAndOr != undefined) {
            var addCon2NeighArray = new Array(27);
            var con2NeighNameDefault = "addCon2Neigh";
            var con2NeighID = "";
            var con2IdNum = 0;

            var conAndOrNeigh = "";

            for (var i = 0; i < 27; i++) {
                con2IdNum = i + 1;
                con2NeighID = con2NeighNameDefault.concat(con2IdNum.toString());
                addCon2NeighArray[i] = document.getElementById(con2NeighID).checked;
            }
            for (var i = 0; i < 27; i++) {
                if (addCon2NeighArray[i]) {
                    conAndOrNeigh += "1";
                }
                else {
                    conAndOrNeigh += "0";
                }
            }
        }

        if (resultAddValueSelected == false) {
            var addResNeighArray = new Array(27);
            var resNeighNameDefault = "addResNeigh";
            var resNeighID = "";
            var resIdNum = 0;

            var resNeigh = "";

            for (var i = 0; i < 27; i++) {
                resIdNum = i + 1;
                resNeighID = resNeighNameDefault.concat(resIdNum.toString());
                addResNeighArray[i] = document.getElementById(resNeighID).checked;
            }
            for (var i = 0; i < 27; i++) {
                if (addResNeighArray[i]) {
                    resNeigh += "1";
                }
                else {
                    resNeigh += "0";
                }
            }
        }
        //Test to see if Compare Values are actually numbers
        if (btwAdd1Selected || countAdd1Selected){
            if (con.compareValueOne == undefined || con.compareValueOne == undefined) {
                document.getElementById("datavalue").innerHTML="<p>Incorrect values have been entered!</p>";
                $('#Information').modal('show');
                return;
            }
        }
        else {
            if (con.compareValueOne == undefined) {

                document.getElementById("datavalue").innerHTML="<p>Incorrect values have been entered!</p>";
                $('#Information').modal('show');
                return;
            }
        }
        if (conAndOr != undefined) {
            if (conAndOr.AndOr != "") {
                if (btwAdd2Selected || countAdd2Selected) {
                    if (conAndOr.compareValueOne == undefined || conAndOr.compareValueTwo == undefined) {
                        document.getElementById("datavalue").innerHTML="<p>Incorrect values have been entered!</p>";
                        $('#Information').modal('show');
                        return;
                    }
                }
                else {
                    if (conAndOr.compareValueOne == undefined) {
                        document.getElementById("datavalue").innerHTML="<p>Incorrect values have been entered!</p>";
                        $('#Information').modal('show');
                        return;
                    }
                }
            }
        }
        if (resultAddValueSelected){
            if (res.resultValue == undefined) {
                document.getElementById("datavalue").innerHTML="<p>Incorrect values have been entered!</p>";
                $('#Information').modal('show');
                return;
            }
        }

        //Add RuleConditionNeighbour
        $http.post("http://" + site + "/AddRuleConNeigh", conNeigh, false)
            .success(function(data) {
                if (data == -9999){
                    document.getElementById("datavalue").innerHTML="<p>Incorrect first Condition Neighbour syntax</p>";
                    $('#Information').modal('show');
                    return;
                }
                con.neighboursId = data;
                if (con.compareValueTwo == null) {
                    con.compareValueTwo = -9999;
                }
                if (data == 0) {
                    //This alert should never happen
                    //If it does, then it doesn't find the right object nor creates it.
                    //Error at query
                    document.getElementById("datavalue").innerHTML="<p>Incorrect first Condition Neighbour syntax</p>";
                    $('#Information').modal('show');
                    return;
                }
                else {
                    //Add RuleConditions
                    if (conAndOr != undefined)
                    {
                        if (conAndOr.AndOr != "") {
                            $http.post("http://" + site + "/AddRuleConAndOrNeigh", conAndOrNeigh, false)
                                .success(function (data) {
                                    if (data == -9999){

                                        document.getElementById("datavalue").innerHTML="<p>Incorrect second Condition Neighbour syntax.</p>";
                                        $('#Information').modal('show');
                                        return;
                                    }
                                    conAndOr.neighboursId = data;
                                    if (conAndOr.compareValueTwo == null) {
                                        conAndOr.compareValueTwo = -9999;
                                    }
                                    if (data == 0) {
                                        //This alert should never happen
                                        //If it does, then it doesn't find the right object nor creates it.
                                        //Error at query

                                        document.getElementById("datavalue").innerHTML="<p>Rule could not be found. Please contact support.</p>";
                                        $('#Information').modal('show');
                                        return;
                                    }
                                    else {
                                        var key = "AndOr";
                                        var ANDOR = conAndOr[key];
                                        delete conAndOr[key];

                                        $http.post("http://" + site + "/AddRuleConAndOr", conAndOr, false)
                                            .success(function (data) {

                                                //alert(ANDOR);

                                                switch(ANDOR){
                                                    case "AND":
                                                        rule.ruleConAndId = data;
                                                        break;
                                                    case "OR":
                                                        rule.ruleConOrId = data;
                                                        break;
                                                }

                                                if (data == 0) {
                                                    //This alert should never happen
                                                    //If it does, then it doesn't find the right object nor creates it.
                                                    //Error at query
                                                    document.getElementById("datavalue").innerHTML="<p>Rule ConditionAndOr could not be found. Please contact support.</p>";
                                                    $('#Information').modal('show');

                                                    return;
                                                }
                                            }).error(function () {
                                                document.getElementById("datavalue").innerHTML="<p>Please enter a value for all fields for the second Condition of the Rule.</p>";
                                                $('#Information').modal('show');

                                                return;
                                            });
                                    }
                                }).error(function () {
                                    document.getElementById("datavalue").innerHTML="<p>Please enter a value for the Neighbours field for the second Condition of the Rule.</p>";
                                    $('#Information').modal('show');


                                    return;
                                });
                        }
                    }
                    $http.post("http://" + site + "/AddRuleCon", con, false)
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
                                //If it does, then it doesn't find the right object nor creates it.
                                //Error at query
                                document.getElementById("datavalue").innerHTML="<p>Rule Condition could not be found. Please contact support.</p>";
                                $('#Information').modal('show');
                                return;
                            }
                            else {
                                //Add RuleResultNeighbour
                                if (resNeigh != undefined) {
                                    $http.post("http://" + site + "/AddRuleResNeigh", resNeigh, false)
                                        .success(function (data) {
                                            if (data == -9999){

                                                document.getElementById("datavalue").innerHTML="<p>Incorrect Result Neighbour syntax.</p>";
                                                $('#Information').modal('show');
                                                return;
                                            }
                                            res.neighboursId = parseInt(data);
                                            if (data == 0) {
                                                //This alert should never happen
                                                //If it does, then it doesn't find the right object nor creates it.
                                                //Error at query

                                                document.getElementById("datavalue").innerHTML="<p>Rule Result Neighbours could not be found. Please contact support.</p>";
                                                $('#Information').modal('show');
                                                return;
                                            }
                                            else {
                                                //Add RuleResult

                                                res.resultValue = -9999;
                                                $http.post("http://" + site + "/AddRuleRes", res, false)
                                                    .success(function (data) {
                                                        rule.ruleResId = data;
                                                        if (data == 0) {
                                                            //This alert should never happen
                                                            //If it does, then it doesn't find the right object nor creates it.
                                                            //Error at query

                                                            document.getElementById("datavalue").innerHTML="<p>Rule Result could not be found. Please contact support.</p>";
                                                            $('#Information').modal('show');
                                                            return;
                                                        }
                                                        else {
                                                            //Add Rule
                                                            rule.ownerId = userId;
                                                            $http.post("http://" + site + "/AddRule", rule, false)
                                                                .success(function (data) {

                                                                    document.getElementById("datavalue").innerHTML="<p>Rule Udated</p>";
                                                                    document.getElementById("informationClose").onclick=close_information;
                                                                    $('#Information').modal('show');

                                                                }).error(function () {

                                                                    document.getElementById("datavalue").innerHTML="<p>Please enter a value for all fields for the Details of the Rule.</p>";
                                                                    $('#Information').modal('show');
                                                                    return;
                                                                });
                                                        }
                                                    }).error(function () {
                                                        document.getElementById("datavalue").innerHTML="<p>Please choose a value for the Operator field for the Result of the Rule</p>";
                                                        $('#Information').modal('show');
                                                        return;
                                                    });
                                            }
                                        }).error(function () {
                                            document.getElementById("datavalue").innerHTML="<p>Please enter a value for the Neighbours field for the Result of the Rule.</p>";
                                            $('#Information').modal('show');

                                            return;
                                        });
                                }
                                else{
                                    //Add RuleResult
                                    res.operation = "NULL";
                                    res.neighboursId = -9999;
                                    $http.post("http://" + site + "/AddRuleRes", res, false)
                                        .success(function (data) {
                                            rule.ruleResId = data;
                                            if (data == 0) {
                                                //This alert should never happen
                                                //If it does, then it doesn't find the right object nor creates it.
                                                //Error at query

                                                document.getElementById("datavalue").innerHTML="<p> Rule Result could not be found. Please contact support</p>";
                                                $('#Information').modal('show');
                                                return;
                                            }
                                            else {
                                                //Add Rule
                                                rule.ownerId = userId;
                                                $http.post("http://" + site + "/AddRule", rule, false)
                                                    .success(function (data) {
                                                        document.getElementById("datavalue").innerHTML="<p>Rule Added</p>";
                                                        document.getElementById("informationClose").onclick=close_information;
                                                        $('#Information').modal('show');
                                                    }).error(function () {
                                                        document.getElementById("datavalue").innerHTML="<p>Please enter a value for all fields for the Details of the Rule.</p>";
                                                        $('#Information').modal('show');
                                                        return;
                                                    });
                                            }
                                        }).error(function () {
                                            document.getElementById("datavalue").innerHTML="<p>Please choose a value for the Result Value field for the Result of the Rule.</p>";
                                            $('#Information').modal('show');

                                            return;
                                        })
                                }
                            }
                        }).error(function () {
                            document.getElementById("datavalue").innerHTML="<p>Please enter a value for all fields for the first Condition of the Rule.</p>";
                            $('#Information').modal('show');

                            return;
                        });

                }
            }).error(function () {
                document.getElementById("datavalue").innerHTML="<p>Please enter a value for the Neighbours field for the first Condition of the Rule.</p>";
                $('#Information').modal('show');
                return;
            });
    };

    $scope.getEditRule = function(ruleId){

        $http.post("http://" + site + "/getRuleById",ruleId)
            .success(function (rule) {
                conId = rule.ruleConId;
                conAndId = rule.ruleConAndid;
                conOrId = rule.ruleConOrid;
                resId = rule.ruleResId;
                $http.post("http://" + site + "/getRuleConById",conId,false)
                    .success(function (con) {
                        conNeighId = con.neighboursId;
                        $http.post("http://" + site + "/getRuleConNeighById",conNeighId,false)
                            .success(function(conNeigh){
                                document.getElementById("editRuleConNeighIdHidden").value = conNeigh.ruleNeighboursId;

                                var con1NeighNameDefault = "editCon1Neigh";
                                var con1NeighID = "";
                                var con1IdNum = 0;

                                for (var i = 0; i < 27; i++){
                                    con1IdNum = i + 1;
                                    con1NeighID = con1NeighNameDefault.concat(con1IdNum.toString());
                                    if (conNeigh.neighbours.charAt(i) == 1) {
                                        document.getElementById(con1NeighID).checked = true;
                                    }
                                }

                            }).error(function(){
                                document.getElementById("datavalue").innerHTML="<p>Rule Condition Neighbours not found. Please contact support.</p>";
                                $('#Information').modal('show');

                            });
                        document.getElementById("editRuleConIdHidden").value = con.ruleConditionId;
                        document.getElementById("editRuleConIsNot").value = con.not;
                        document.getElementById("editRuleCon1Operation").value = con.operation;
                        document.getElementById("editRuleCon1Operand").value = con.operand;
                        document.getElementById("editRuleCon1CompareValueOne").value = con.compareValueOne;
                        if (con.compareValueTwo != null) {
                            document.getElementById("editRuleCon1CompareValueTwo").value = con.compareValueTwo;
                        }
                        else{
                            document.getElementById("editRuleCon1CompareValueTwo").value = null;
                        }

                    }).error(function (){
                        document.getElementById("datavalue").innerHTML="<p>Rule Condition not found. Please contact support.</p>";
                        $('#Information').modal('show');

                    });
                if (conAndId != null)
                {
                    $http.post("http://" + site + "/getRuleConById",conAndId,false)
                        .success(function (con) {
                            conNeighId = con.neighboursId;
                            $http.post("http://" + site + "/getRuleConNeighById",conNeighId,false)
                                .success(function(conNeigh){
                                    document.getElementById("editRuleCon2NeighIdHidden").value = conNeigh.ruleNeighboursId;

                                    var con2NeighNameDefault = "editCon2Neigh";
                                    var con2NeighID = "";
                                    var con2IdNum = 0;

                                    for (var i = 0; i < 27; i++){
                                        con2IdNum = i + 1;
                                        con2NeighID = con2NeighNameDefault.concat(con2IdNum.toString());
                                        if (conNeigh.neighbours.charAt(i) == 1) {
                                            document.getElementById(con2NeighID).checked = true;
                                        }
                                    }

                                }).error(function(){
                                    document.getElementById("datavalue").innerHTML="<p>Rule Condition-AND Neighbours not found. Please contact support.</p>";
                                    $('#Information').modal('show');

                                });
                            document.getElementById("editRuleCon2IdHidden").value = con.ruleConditionId;
                            document.getElementById("editRuleCon2AndOr").value = "AND";
                            document.getElementById("editRuleCon2isNot").value = con.not;
                            document.getElementById("editRuleCon2Operation").value = con.operation;
                            document.getElementById("editRuleCon2Operand").value = con.operand;
                            document.getElementById("editRuleCon2CompareValueOne").value = con.compareValueOne;
                            if (con.compareValueTwo != null) {
                                document.getElementById("editRuleCon2CompareValueTwo").value = con.compareValueTwo;
                            }
                            else {
                                document.getElementById("editRuleCon2CompareValueTwo").value = null;
                            }

                        }).error(function (){
                            document.getElementById("datavalue").innerHTML="<p>Rule Condition-AND not found. Please contact support.</p>";
                            $('#Information').modal('show');

                        });
                }
                else if (conOrId != null)
                {
                    $http.post("http://" + site + "/getRuleConById",conOrId,false)
                        .success(function (con) {
                            conNeighId = con.neighboursId;

                            $http.post("http://" + site + "/getRuleConNeighById",conNeighId,false)
                                .success(function(conNeigh){
                                    document.getElementById("editRuleCon2NeighIdHidden").value = conNeigh.ruleNeighboursId;

                                    var con2NeighNameDefault = "editCon2Neigh";
                                    var con2NeighID = "";
                                    var con2IdNum = 0;

                                    for (var i = 0; i < 27; i++){
                                        con2IdNum = i + 1;
                                        con2NeighID = con2NeighNameDefault.concat(con2IdNum.toString());
                                        if (conNeigh.neighbours.charAt(i) == 1) {
                                            document.getElementById(con2NeighID).checked = true;
                                        }
                                    }

                                }).error(function(){
                                    document.getElementById("datavalue").innerHTML="<p>Rule Condition-OR Neighbours not found. Please contact support</p>";
                                    $('#Information').modal('show');

                                });
                            document.getElementById("editRuleCon2IdHidden").value = con.ruleConditionId;
                            document.getElementById("editRuleCon2AndOr").value = "OR";
                            document.getElementById("editRuleCon2isNot").value = con.isNot;
                            document.getElementById("editRuleCon2Operation").value = con.operation;
                            document.getElementById("editRuleCon2Operand").value = con.operand;
                            document.getElementById("editRuleCon2CompareValueOne").value = con.compareValueOne;
                            if (con.compareValueTwo != null) {
                                document.getElementById("editRuleCon2CompareValueTwo").value = con.compareValueTwo;
                            }
                            else {
                                document.getElementById("editRuleCon2CompareValueTwo").value = null;
                            }

                        }).error(function (){
                            document.getElementById("datavalue").innerHTML="<p>Rule Condition-OR not found. Please contact support.</p>";
                            $('#Information').modal('show');

                        });
                }

                $http.post("http://" + site + "/getRuleResById",resId,false)
                    .success(function(res){
                        resNeighId = res.neighboursId;
                        if (resNeighId == null)
                        {
                            resNeighId = -9999;
                        }
                        document.getElementById("editRuleResIdHidden").value = res.ruleConditionId;
                        if (JSON.stringify(res.operation) != null) {
                            document.getElementById("editRuleResOperation").value = res.operation;
                        }
                        if (JSON.stringify(res.resultValue) != null) {
                            document.getElementById("editRuleResValue").value = res.resultValue;
                        }

                        $http.post("http://" + site + "/getRuleResNeighById",resNeighId,false)
                            .success(function(resNeigh) {
                                if (resNeigh != null) {
                                    document.getElementById("editRuleResNeighIdHidden").value = resNeigh.ruleNeighboursId;

                                    var resNeighNameDefault = "editResNeigh";
                                    var resNeighID = "";
                                    var resIdNum = 0;

                                    for (var i = 0; i < 27; i++){
                                        resIdNum = i + 1;
                                        resNeighID = resNeighNameDefault.concat(resIdNum.toString());
                                        if (resNeigh.neighbours.charAt(i) == 1) {
                                            document.getElementById(resNeighID).checked = true;
                                        }
                                    }
                                }

                            }).error(function(){
                                document.getElementById("datavalue").innerHTML="<p>Rule Result Neighbours not found. Please contact support.</p>";
                                $('#Information').modal('show');

                            });
                    }).error(function(){
                        document.getElementById("datavalue").innerHTML="<p>Rule Result could not be found. Please contact support.</p>";
                        $('#Information').modal('show');
                    });
                document.getElementById("editRuleIdHidden").value = rule.ruleId;
                document.getElementById("editRuleName").value = rule.ruleName;
                document.getElementById("editRuleDesc").value = rule.ruleDesc;

            }).error(function () {
                document.getElementById("datavalue").innerHTML="<p>Rule could not be found. Please contact support.</p>";
                $('#Information').modal('show');
            });

        evaluateEditOperation("OLD");
        evaluateEditOperand("OLD");
        evaluateEditCompareValue("OLD");
        evaluateEditResult("OLD");

    };

    $scope.deleteRuleFinalize = function() {
        var ruleId=document.getElementById("ruleIdhidden").value;
        $http.post("http://" + site + "/deleteRule",ruleId)
            .success(function (data) {
                document.getElementById("datavalue").innerHTML="<p>Rule Deleted</p>";
                document.getElementById("informationClose").onclick=close_information;
                $('#Information').modal('show');
            }).error(function () {

                document.getElementById("datavalue").innerHTML="<p>Rule could not be found. Please contact support.</p>";
                $('#Information').modal('show');
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
function close_information()
{
    location.reload();
}
