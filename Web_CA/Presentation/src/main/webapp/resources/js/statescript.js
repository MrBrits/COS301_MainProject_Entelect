var web_ca = angular.module('state_app', []);

var site = "localhost:8080";

web_ca.controller("StateGetCtr", function ($scope, $http) {
    var app = this;

    $http.get("http://" + site + "/getAllStates")
        .success(function (data) {
            $scope.states = data;
            //alert("done---state");
        }).error(function () {
            //alert("fail---state");
        });
});
web_ca.controller("GetStateByUserId", function ($scope, $http) {
    var app = this;

    var userId = document.getElementById("userId").value;

    $http.get("http://" + site + "/getStateByUserId/"+userId)
        .success(function (data) {
            $scope.states = data;
            // alert(JSON.stringify(data));
            //   alert("done");

        }).error(function () {
            alert("SERVER ERROR");
        });

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
                alert("SERVER ERROR");
            });
    };
});