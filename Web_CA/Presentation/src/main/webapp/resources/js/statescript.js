var web_ca = angular.module('state_app', []);

web_ca.controller("StateGetCtr", function ($scope, $http) {
    var app = this;

    $http.get("http://localhost:8080/getAllStates")
        .success(function (data) {
            $scope.states = data;
            //alert("done---state");
        }).error(function () {
            //alert("fail---state");
        });
});
web_ca.controller("GetStateByUserId", function ($scope, $http) {
    var app = this;

    var userId=document.getElementById("userId").value;

    $http.get("http://localhost:8080/getStateByUserId/"+userId)
        .success(function (data) {
            $scope.states = data;
            // alert(JSON.stringify(data));
            //   alert("done");

        }).error(function () {
            alert("error");
        });

});