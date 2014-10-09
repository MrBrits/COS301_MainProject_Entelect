var web_ca = angular.module('world_app', []);

var site=new config().getSite();
this.Worldidtobedeleted=0;

var twoDimensional = false;

/*
(function() {
    var proxied = window.alert;
    window.alert = function(message) {
        $("#alertMessage .modal-body").text(message);
        $("#alertMessage").modal('show');
    };
})();
*/


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
                alert("SERVER ERROR: World could not be found. Please contact support.");
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
                alert("SERVER ERROR: World could not be found. Please contact support.");
            });
    };

    $scope.ImportWorlds = function (id) {
        var UserWorld = userId+";"+id;

        $http.post("http://" + site + "/importWorld",UserWorld)
            .success(function (data) {
                //$scope.worlds = data;
                alert("World Imported");
            }).error(function () {
                alert("SERVER ERROR: World could not be found. Please contact support.");
            });

    };
    $scope.getNotWorlds = function () {
        $http.post("http://" + site + "/getWorldNotByUserId",userId)
            .success(function (data) {
                $scope.worlds = data;
            }).error(function () {
                alert("GET WORLD BY USER ID: SERVER ERROR");
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
                    alert("Performance issues might occur.");
                }
                world.ownerId = document.getElementById("userId").value;
                $http.post("http://" + site + "/AddWorld", world)
                    .success(function (data) {
                        alert(data);
                        location.reload();
                    }).error(function () {
                        alert("Please enter a value for all fields of the World.");
                        return;
                    });
            }
            else{
                alert("World too large. Please create smaller world.");
            }
        }
        else {
            alert("Incorrect values have been entered!");
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
                alert("SERVER ERROR: World could not be found. Please contact support.");
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
                alert(data);
                location.reload();
                $scope.getStates();
            }).error(function () {
                alert("Please enter a value for all fields of the World.");
                return
            });

    };


    $scope.deleteWorldFinalize = function() {
        var worldId = document.getElementById("worldIdhidden").value;
        $http.post("http://" + site + "/deleteWorld",worldId)
            .success(function (data) {
                location.reload();
            }).error(function () {
                alert("SERVER ERROR: World could not be found. Please contact support.");
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
