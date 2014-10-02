var web_ca = angular.module('user_app', []);

var site =new config().getSite();
var mainUser;

web_ca.controller("UserRegisterController", function($http) {
    var app = this;
    app.addUser = function(userReg) {
        userReg.userRole="User";
        alert(JSON.stringify(userReg));
        $http.post("http://" + site + "/UserSet",userReg)
            .success(function(data) {
                alert(data);
            }).error(function () {
                alert("USER REGISTER: SERVER ERROR");
            });
    };
});

web_ca.controller("UserLoginController", function($http) {
    var app = this;


    app.loginUser = function(userLogin,$location) {
        $http.post("http://" + site + "/UserLogin",userLogin)
            .success(function(data) {
                if (data == "") {
                    alert("Invalid credentials.");
                }
                else    {
                    window.location='/'+data.userId;
                }

            }).error(function () {
                alert("USER LOGIN: SERVER ERROR");
            });
    };
});

web_ca.controller("UserGetCtr", function ($scope, $http) {
    var app = this;

    $http.get("http://localhost:8080/getAllUsers")
        .success(function (data) {
            $scope.profiles = data;

        })
        .error(function () {

        });
});

web_ca.controller("UserByIdGet", function ($scope, $http) {
    var app = this;

    $http.get("http://localhost:8080/getUserById/")
        .success(function (data) {
           // $scope.User = data;
            // alert(JSON.stringify(data));
            //   alert("done");

        })
        .error(function () {
           // alert("error");
        });
});
