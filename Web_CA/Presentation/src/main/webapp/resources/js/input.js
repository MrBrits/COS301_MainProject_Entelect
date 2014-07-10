var app = angular.module("app", []);

app.controller("AppCtrl", function($http) {
    var app = this;

    app.addPerson = function(person) {
        var User = new Object();

        User.userFirstName =person.firstName;
        User.userLastName = person.lastName;
        User.userEmail = "email";
        User.userPassword="1300";
        User.userRole="1300";
        var string = JSON.stringify(User);
        alert(string);
        $http.post("http://localhost:8080/getAll",string)
            .success(function(data) {
                alert("wen");
            }).error(function () {
                alert("fail");
            });
    };
});