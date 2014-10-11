var web_ca = angular.module('state_app', []);

var site = new config().getSite();
web_ca.controller("StateSimulator", function ($scope, $http) {
    var app = this;

    var userId = document.getElementById("userId").value;
        $http.post("http://" + site + "/getStateByUserId", userId)
            .success(function (data) {
                $scope.states = data;
            }).error(function () {
                alert("SERVER ERROR: States could not be found. Please contact support.");
            });

} );
web_ca.controller("StateManager", function ($scope, $http) {
    var app = this;

    var userId = document.getElementById("userId").value;

    $scope.getStates = function(){

        $http.post("http://" + site + "/getStateByUserId",userId)
            .success(function (data) {
                $scope.states = data;
            }).error(function () {
                alert("SERVER ERROR: States could not be found. Please contact support.");
            });
    }

    $scope.addState = function(state) {

        if (state.stateValue != undefined) {
            state.stateHex = document.getElementById("colour").value;
            state.ownerId = userId;
            $http.post("http://" + site + "/AddState", state)
                .success(function (data) {
                    alert(data);
                    location.reload();
                }).error(function () {
                    alert("Please enter a correct value for all fields of the State.");
                });
        }
        else {
            alert("Please enter a correct value for all fields of the State.");
            return;
        }







    };

    $scope.getEditState = function(stateId)
    {
        $http.post("http://" + site + "/getStateById",stateId)
            .success(function (data) {

                document.getElementById("editStateTitle").innerHTML = "<h3>Edit State</h3>";
                document.getElementById("editStateIdHidden").value = data.stateId;

                document.getElementById("editStateName").value = data.stateName;
                document.getElementById("editStateDesc").value = data.stateDesc;
                document.getElementById("editStateValue").value = parseFloat(data.stateValue);
                document.getElementById("editStateHex").value = data.stateHex;

            }).error(function () {
                alert("SERVER ERROR: State could not be found. Please contact support.");
            });
    };

    $scope.editState = function()
    {

        var id = document.getElementById("editStateIdHidden").value;
        var name = document.getElementById("editStateName").value;
        var desc = document.getElementById("editStateDesc").value;
        var value = document.getElementById("editStateValue").value;
        var hex = document.getElementById("editStateHex").value;

                state = "{\"stateId\":" + id + ",\"stateName\":\"" + name + "\",\"stateDesc\":\"" + desc + "\",\"stateValue\":" + value + ",\"stateHex\":\"" + hex + "\", \"ownerId\":" + userId + "}";

                $http.post("http://" + site + "/editState", state)
                    .success(function (data) {
                        alert(data);
                        $scope.getStates();
                        location.reload();
                    }).error(function () {
                        alert("Please enter a correct value for all fields of the State.");
                    });
    };

    $scope.deleteStateFinalize = function() {

        var stateId=document.getElementById("deleteStateIdHidden").value;
        $http.post("http://" + site + "/deleteState",stateId)
            .success(function (data) {
                alert(data); location.reload();
            }).error(function () {
                alert("SERVER ERROR: State could not be found. Please contact support.");
            });
    };

});

function deleteState(toBeDeleted)
{
    toBeDeleted=toBeDeleted.substr(1);
    var stateId= toBeDeleted.split(";")[0];
    var stateName= toBeDeleted.split(";")[1];
    document.getElementById("DeleteNameState").innerHTML="<h3>Delete State: " + stateName +"</h3>";
    document.getElementById("deleteStateIdHidden").value=stateId;
}


