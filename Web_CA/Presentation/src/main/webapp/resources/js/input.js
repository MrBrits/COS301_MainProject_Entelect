var app = angular.module("app", []);

app.controller("AppCtrl", function($http) {
    var app = this;
    app.addUser = function(person) {
        $http.post("http://localhost:8080/getAllProfiles", person)
            .success(function(data) {
               alert("true")
            }.error(function () {
                    alert("fail");
            }));
    }
})