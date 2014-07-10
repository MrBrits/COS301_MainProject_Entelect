var app = angular.module("app", []);

app.controller("AppCtrl", function($http) {
    var app = this;

    app.addPerson = function(person) {
        var User = new Object();
        User.UserId ="NULL";
        User.UerFirstName =person.firstName;
        User.UserLastName = person.lastName;
        User.UserEmail = "email";
        User.UserPassword="1300";
        User.UserRole="1300";
        $http.post("http://localhost:8080/getAllProfiles",User)
            .success(function(data) {
                alert("wen");
            }).error(function () {
                alert("fail");
            });
    };
});