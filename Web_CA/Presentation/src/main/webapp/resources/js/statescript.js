var web_ca = angular.module('state_app', []);

var site = "localhost:8080";

web_ca.controller("StateManager", function ($scope, $http) {
    var app = this;

    var userId = document.getElementById("userId").value;

    $scope.getStates = function(){

        $http.post("http://" + site + "/getStateByUserId",userId)
            .success(function (data) {
                $scope.states = data;
            }).error(function () {
                alert("RETRIEVE STATES BY USER ID: SERVER ERROR");
            });
    }

    $scope.addState = function(state) {
        state.stateHex=document.getElementById("colour").value;
        state.ownerId=userId;
        $http.post("http://" + site + "/AddState",state)
            .success(function(data) {
                alert(data);
            }).error(function () {
                alert("ADD STATE: SERVER ERROR");
            });
    };

    $scope.getEditState = function(stateId)
    {
        $http.post("http://" + site + "/getStateById",stateId)
            .success(function (data) {

                document.getElementById("editStateTitle").innerHTML = "<h3>Edit State</h3>";
                document.getElementById("editStateIdHidden").value = data.stateId;

                document.getElementById("editStateName").value = data.stateName;
                document.getElementById("editStateDesc").value = data.stateDesc;
                document.getElementById("editStateValue").value = data.stateValue;
                document.getElementById("editStateHex").value = data.stateHex;

            }).error(function () {
                alert("GET EDIT STATE: SERVER ERROR");
            });
    };

    $scope.editState = function()
    {
        id = document.getElementById("editStateIdHidden").value;
        name = document.getElementById("editStateName").value;
        desc = document.getElementById("editStateDesc").value;
        value = document.getElementById("editStateValue").value;
        hex = document.getElementById("editStateHex").value;


        state = "{\"stateId\":"+id+",\"stateName\":\"" + name + "\",\"stateDesc\":\"" + desc + "\",\"stateValue\":" + value + ",\"stateHex\":\"" + hex + "\", \"ownerId\":" + userId + "}";

        $http.post("http://" + site + "/editState",state)
            .success(function (data) {
                alert(data);
                $scope.getStates();
            }).error(function () {
                alert("EDIT STATE: SERVER ERROR");
            });
    };

    $scope.deleteStateFinalize = function() {

        var stateId=document.getElementById("deleteStateIdHidden").value;
        $http.post("http://" + site + "/deleteState",stateId)
            .success(function (data) {
                alert(data);
            }).error(function () {
                alert("DELETE STATE: SERVER ERROR");
            });
    };

});

/**
 * 
 * @param toBeDeleted
 */
function deleteState(toBeDeleted)
{
    toBeDeleted=toBeDeleted.substr(1);
    var stateId= toBeDeleted.split(";")[0];
    var stateName= toBeDeleted.split(";")[1];
    document.getElementById("DeleteNameState").innerHTML="<h3>Delete State: " + stateName +"</h3>";
    document.getElementById("deleteStateIdHidden").value=stateId;
}


