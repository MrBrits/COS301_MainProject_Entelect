var web_ca = angular.module('world_app', []);

var site="localhost:8080";
this.Worldidtobedeleted=0;
web_ca.controller("WorldSimulator", function($scope, $http) {
    var app = this;
    var userId = document.getElementById("userId").value;
        $http.post("http://" + site + "/getWorldByUserId", userId)
            .success(function (data) {
                $scope.worlds = data;
            }).error(function () {
                alert("GET WORLD BY USER ID: SERVER ERROR");
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
                alert("GET WORLD BY USER ID: SERVER ERROR");
            });
    }

    $scope.addWorld = function(world) {
        world.ownerId=document.getElementById("userId").value;
        $http.post("http://" + site + "/AddWorld",world)
            .success(function(data) {

                location.reload();
            }).error(function () {
                alert("CREATE WORLD: SERVER ERROR");
            });
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
                alert("GET EDIT WORLD: SERVER ERROR");
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

        world = "{\"worldId\":"+id+",\"worldName\":\"" + name + "\",\"worldDesc\":\"" + desc + "\",\"worldDimension\":" + dim + ",\"worldWidth\":" + width + ",\"worldHeight\":" + height + ",\"worldDepth\":" + depth + ", \"ownerId\":" + userId + "}";



        $http.post("http://" + site + "/editWorld",world)
            .success(function (data) {
                alert(data);
                location.reload();
                $scope.getStates();
            }).error(function () {
                alert("EDIT WORLD: SERVER ERROR");
            });
    };


    $scope.deleteWorldFinalize = function() {
        var worldId = document.getElementById("worldIdhidden").value;
        $http.post("http://" + site + "/deleteWorld",worldId)
            .success(function (data) {
                alert(data);
                location.reload();
            }).error(function () {
                alert("DELETE WORLD: SERVER ERROR");
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
