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

    $scope.launch = function(object){
        alert(JSON.stringify(object));

    }; // end launch

});

web_ca.controller("AddStateController", function($http) {
    var app = this;
    app.addState = function(state) {

        state.stateHex=document.getElementById("colour").value;
        state.ownerId=document.getElementById("userId").value;
        alert(JSON.stringify(state));
        $http.post("http://" + site + "/AddState",state)
            .success(function(data) {
                alert(data);
            }).error(function () {
                alert("ADD STATE: SERVER ERROR");
            });
    };
});