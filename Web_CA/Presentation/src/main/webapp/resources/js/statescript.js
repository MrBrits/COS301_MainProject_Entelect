var web_ca = angular.module('state_app', []);

var site = "localhost:8080";

web_ca.controller("StateManager", function ($scope, $http) {
    var app = this;

    var userId = document.getElementById("userId").value;


    $scope.getStates = function(){
        $http.get("http://" + site + "/getStateByUserId/"+userId)
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

    $scope.editState = function(stateId)
    {
        alert(stateId);
        $http.get("http://" + site + "/getStateById/"+stateId)
            .success(function (data) {
                alert(JSON.stringify(data));
                $scope.Ustate=data;
            }).error(function () {
                alert("UPDATE STATE: SERVER ERROR");
            });
    };

    $scope.deleteStateFinalize = function() {

        var stateId=document.getElementById("stateIdhidden").value;
        $http.get("http://" + site + "/deleteState/"+stateId)
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
    document.getElementById("stateIdhidden").value=stateId;
}

web_ca.controller("UpdateStateManager", function ($scope, $http) {



});

