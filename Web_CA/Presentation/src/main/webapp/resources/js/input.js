var app = angular.module("app", []);

app.controller("AppCtrl", function($http) {
    var app = this;

    app.addPerson = function(person) {

        $http.post("/http://localhost:8080/tempies",person)
            .success(function(data) {
                alert("wen");
            }).error(function () {
                alert("fail");
            });
    }
});