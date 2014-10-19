var web_ca = angular.module('state_app', []);

var site = new config().getSite();
web_ca.controller("StateSimulator", function ($scope, $http) {
    var app = this;

    var userId = document.getElementById("userId").value;
        $http.post("http://" + site + "/getStateByUserId", userId)
            .success(function (data) {
                $scope.states = data;
            }).error(function () {
                document.getElementById("datavalue").innerHTML="<p>State could not be found. Please contact support.</p>";
                $('#Information').modal('show');
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
                document.getElementById("datavalue").innerHTML="<p>State could not be found. Please contact support.</p>";
                $('#Information').modal('show');
            });
    }

    $scope.addState = function(state) {

        if (state.stateValue != undefined) {
            state.stateHex = document.getElementById("colour").value;
            state.ownerId = userId;
            $http.post("http://" + site + "/AddState", state)
                .success(function (data) {
                    document.getElementById("datavalue").innerHTML="<p>"+data+"</p>";
                    document.getElementById("informationClose").onclick=close_information;
                    $('#Information').modal('show');
                }).error(function () {
                    document.getElementById("datavalue").innerHTML="<p>Please enter a correct value for all fields of the State.</p>";
                    $('#Information').modal('show');

                });
        }
        else {
            document.getElementById("datavalue").innerHTML="<p>Please enter a correct value for all fields of the State.</p>";
            $('#Information').modal('show');
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
                document.getElementById("datavalue").innerHTML="<p>State could not be found. Please contact support.</p>";
                $('#Information').modal('show');
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
                        document.getElementById("datavalue").innerHTML="<p>State Updated</p>";
                        document.getElementById("informationClose").onclick=close_information;
                        $('#Information').modal('show');
                        $scope.getStates();

                    }).error(function () {
                        document.getElementById("datavalue").innerHTML="<p>Please enter a correct value for all fields of the State.</p>";
                        $('#Information').modal('show');
                    });
    };

    $scope.deleteStateFinalize = function() {

        var stateId=document.getElementById("deleteStateIdHidden").value;
        $http.post("http://" + site + "/deleteState",stateId)
            .success(function (data) {
                document.getElementById("datavalue").innerHTML="<p>State Deleted.</p>";
                document.getElementById("informationClose").onclick=close_information;
                $('#Information').modal('show');
            }).error(function () {
                document.getElementById("datavalue").innerHTML="<p>State could not be found. Please contact support.</p>";
                $('#Information').modal('show');
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
function close_information()
{
    location.reload();
}


