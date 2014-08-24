var web_ca = angular.module('world_app', []);

var site = "localhost:8080";
this.Worldidtobedeleted=0;
web_ca.controller("WorldGetCtr", function ($scope, $http) {
    var app = this;

    $http.get("http://" + site + "/getAllWorlds")
        .success(function (data) {
            $scope.worlds = data;

        }).error(function () {
            alert("fail--world");
        });
});

web_ca.controller("GetWorldByUserId", function ($scope, $http) {
    var app = this;
    var userId=document.getElementById("userId").value;

    $http.get("http://" + site + "/getWorldByUserId/"+userId)
        .success(function (data) {
            $scope.worlds = data;


        }).error(function () {
            alert("error");
        });

});
/*
*/
web_ca.controller("AddWorldController", function($http) {
    var app = this;
    app.addWorld = function(world) {

        world.ownerId=document.getElementById("userId").value;
        alert(JSON.stringify(world));
        $http.post("http://" + site + "/AddWorld",world)
            .success(function(data) {
                alert(data);
            }).error(function () {
                alert("SERVER ERROR");
            });
    };
});
function deleteWorld(toBeDeleted)
{
    toBeDeleted=toBeDeleted.substr(1);
    var worldId= toBeDeleted.split(";")[0];
    var worldName= toBeDeleted.split(";")[1];
    document.getElementById("DeleteNameWorld").innerHTML="<h3>Delete World:"+worldName+ "</h3>";
    document.getElementById("worldIdhidden").value=worldId;
}
web_ca.controller("deleteWorldController", function ($scope, $http) {
    var app = this;

    app.deleteWorldFinalize = function() {
        var worldid=document.getElementById("worldIdhidden").value;
        $http.get("http://" + site + "/deleteWorld/"+worldid)
            .success(function (data) {

                alert(data);

            }).error(function () {
                alert("error");
            });

    };


});