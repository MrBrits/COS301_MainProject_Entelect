var web_ca = angular.module('world_app', []);

var site = "localhost:8080";
this.Worldidtobedeleted=0;

web_ca.controller("WorldManager", function($scope, $http) {
    var app = this;
    var userId = document.getElementById("userId").value;

    $scope.getWorlds = function () {
        $http.get("http://" + site + "/getWorldByUserId/" + userId)
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
                alert(data);
            }).error(function () {
                alert("CREATE WORLD: SERVER ERROR");
            });
    };

    $scope.deleteWorldFinalize = function() {
        var worldid=document.getElementById("worldIdhidden").value;
        $http.get("http://" + site + "/deleteWorld/"+worldid)
            .success(function (data) {
                alert(data);
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
