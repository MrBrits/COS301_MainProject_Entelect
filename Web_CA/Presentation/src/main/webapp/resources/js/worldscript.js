var web_ca = angular.module('world_app', []);

var site=new config().getSite();
this.Worldidtobedeleted=0;

var twoDimensional = false;


function evaluateDim(){
    var dim = document.getElementById("addWorldDim").value;
    if (dim == 2){
        document.getElementById("addWorldDepth").value = parseFloat(1);
        document.getElementById("addWorldDepth").disabled = true;
        twoDimensional = true;
    }
    if (dim == 3){
        document.getElementById("addWorldDepth").disabled = false;
        document.getElementById("addWorldDepth").value = null;
        twoDimensional = false;
    }
}

web_ca.controller("WorldSimulator", function($scope, $http) {
    var app = this;
    var userId = document.getElementById("userId").value;
        $http.post("http://" + site + "/getWorldByUserId", userId)
            .success(function (data) {
                $scope.worlds = data;

            }).error(function () {
                document.getElementById("datavalue").innerHTML="<p>World could not be found. Please contact support.</p>";
                $('#Information').modal('show');

            });

});
web_ca.controller("WorldManager", function($scope, $http) {
    var app = this;
    var userId = document.getElementById("userId").value;

    $scope.getWorlds = function () {
        $http.post("http://" + site + "/getWorldByUserId",userId)
            .success(function (data) {

                $scope.worlds = data;
            }).error(function () {
                document.getElementById("datavalue").innerHTML="<p>World could not be found. Please contact support.</p>";
                $('#Information').modal('show');
            });
    };

    $scope.ImportWorlds = function (id) {
        var UserWorld = userId+";"+id;

        $http.post("http://" + site + "/importWorld",UserWorld)
            .success(function (data) {
                document.getElementById("datavalue").innerHTML="<p>World Imported</p>";
                $('#Information').modal('show');
            }).error(function () {
                document.getElementById("datavalue").innerHTML="<p>World could not be found. Please contact support.</p>";
                $('#Information').modal('show');
            });

    };
    $scope.getNotWorlds = function () {
        $http.post("http://" + site + "/getWorldNotByUserId",userId)
            .success(function (data) {
                $scope.worlds = data;
            }).error(function () {
                document.getElementById("datavalue").innerHTML="<p>World could not be found. Please contact support.</p>";
                $('#Information').modal('show');
            });
    };
    $scope.addWorld = function(world) {
        if (twoDimensional) {
            world.worldDepth = 1;
        }

        if ((typeof world.worldHeight === "number") && (typeof world.worldWidth === "number") && (typeof world.worldDepth === "number")) {
            var cellTotal = world.worldHeight * world.worldWidth * world.worldDepth;
            if (parseInt(cellTotal) <= parseInt(10000)) {

                if (parseInt(cellTotal) > parseInt(8000)){
                    document.getElementById("datavalue").innerHTML="<p>Performance issues might occur.</p>";
                    $('#Information').modal('show');

                }
                world.ownerId = document.getElementById("userId").value;
                $http.post("http://" + site + "/AddWorld", world)
                    .success(function (data) {
                        document.getElementById("datavalue").innerHTML="<p>World Added</p>";
                        document.getElementById("informationClose").onclick=close_information;
                        $('#Information').modal('show');
                        //
                    }).error(function () {
                        document.getElementById("datavalue").innerHTML="<p>Please enter a value for all fields of the World.</p>";
                        $('#Information').modal('show');
                        return;
                    });
            }
            else{
                document.getElementById("datavalue").innerHTML="<p>World too large. Please create smaller world.</p>";
                $('#Information').modal('show');

            }
        }
        else {
            document.getElementById("datavalue").innerHTML="<p>Incorrect values have been entered!</p>";
            $('#Information').modal('show');

        }
    };

    $scope.getEditWorld = function(worldId) {
        $http.post("http://" + site + "/getWorldById/",worldId)
            .success(function(data){
                document.getElementById("editWorldIdHidden").value = data.worldId;
                document.getElementById("editWorldName").value = data.worldName;
                document.getElementById("editWorldDesc").value = data.worldDesc;
                document.getElementById("editWorldDimension").value = data.worldDimension;
                document.getElementById("editWorldWidth").value = data.worldWidth;
                document.getElementById("editWorldHeight").value = data.worldHeight;
                document.getElementById("editWorldDepth").value = data.worldDepth;
            }).error(function(){
                document.getElementById("datavalue").innerHTML="<p>World could not be found. Please contact support.</p>";
                $('#Information').modal('show');
            });
    };

    $scope.editWorld = function() {
        id = document.getElementById("editWorldIdHidden").value;
        name = document.getElementById("editWorldName").value;
        desc = document.getElementById("editWorldDesc").value;
        dim = document.getElementById("editWorldDimension").value;
        width = document.getElementById("editWorldWidth").value;
        height = document.getElementById("editWorldHeight").value;
        depth = document.getElementById("editWorldDepth").value;

        world = "{\"worldId\":" + id + ",\"worldName\":\"" + name + "\",\"worldDesc\":\"" + desc + "\",\"worldDimension\":" + dim + ",\"worldWidth\":" + width + ",\"worldHeight\":" + height + ",\"worldDepth\":" + depth + ", \"ownerId\":" + userId + "}";
        $http.post("http://" + site + "/editWorld", world)
            .success(function (data) {
                document.getElementById("datavalue").innerHTML="<p>World Updated.</p>";
                document.getElementById("informationClose").onclick=close_information;
                $('#Information').modal('show');

                $scope.getStates();
            }).error(function () {
                document.getElementById("datavalue").innerHTML="<p>Please enter a value for all fields of the World.</p>";
                $('#Information').modal('show');
                return
            });

    };


    $scope.deleteWorldFinalize = function() {
        var worldId = document.getElementById("worldIdhidden").value;
        $http.post("http://" + site + "/deleteWorld",worldId)
            .success(function (data) {
                document.getElementById("datavalue").innerHTML="<p>World Deleted</p>";
                document.getElementById("informationClose").onclick=close_information;
                $('#Information').modal('show');
            }).error(function () {
                document.getElementById("datavalue").innerHTML="<p>World could not be found. Please contact support.</p>";
                $('#Information').modal('show');
            });

    };

});
function deleteWorld(toBeDeleted)
{
    toBeDeleted=toBeDeleted.substr(1);
    var worldId= toBeDeleted.split(";")[0];
    var worldName= toBeDeleted.split(";")[1];
    document.getElementById("DeleteNameWorld").innerHTML="<h3>Delete World: " + worldName + "</h3>";
    document.getElementById("worldIdhidden").value=worldId;
}
function setWorldID(id)
{
    document.getElementById("worldId").value=id;
}
function close_information()
{
    location.reload();
}