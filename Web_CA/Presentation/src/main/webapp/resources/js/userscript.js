var web_ca = angular.module('user_app', []);

var site =new config().getSite();
var mainUser;

web_ca.controller("UserRegisterController", function($http) {
    var app = this;
    app.addUser = function(userReg) {
        userReg.userRole = "User";
        userReg.tutorials = 1;

        $http.post("http://" + site + "/UserSet",userReg)
            .success(function(data) {
                document.getElementById("datavalue").innerHTML="<p>User Registered.</p>";
                $('#Information').modal('show');
            }).error(function () {
                document.getElementById("datavalue").innerHTML="<p>User could not be created.</p>";
                $('#Information').modal('show');

            });
    };
});

web_ca.controller("UserManager", function($scope,$http) {
    var pass;
    var userRole;
    var userId = document.getElementById("userId").value;

    $scope.editUser = function ()
    {
        var tut = document.getElementById("tutorials").value;
        if(tut=="Enabled")
            tut=1;
        else
            tut=0;
        var user={userId: userId,userFirstName:document.getElementById("firstName").value,userLastName:document.getElementById("lastName").value,tutorials:tut,userEmail:document.getElementById("email").value,userPassword:pass,userRole:userRole};

        $http.post("http://" + site + "/editUser",user)
            .success(function(data) {
                document.getElementById("datavalue").innerHTML="<p>User Updated</p>";
                document.getElementById("informationClose").onclick=close_information;
                $('#Information').modal('show');


            }).error(function () {
                document.getElementById("datavalue").innerHTML="<p>User could not be found. Please contact support.</p>";
                $('#Information').modal('show');
            });
    };

    $http.post("http://" + site + "/getUserById",userId)
        .success(function(data) {
            document.getElementById("firstName").value=data.userFirstName;
            document.getElementById("lastName").value=data.userLastName;
            document.getElementById("email").value=data.userEmail;
            pass = data.userPassword;
            userRole =data.userRole;
            if(data.tutorials == true)
                document.getElementById("tutorials").value = "Enabled";
            else
                document.getElementById("tutorials").value = "Disabled";

        }).error(function () {
            document.getElementById("datavalue").innerHTML="<p>User could not be found. Please contact support.</p>";
            $('#Information').modal('show');
        });

});

web_ca.controller("UserLoginController", function($http) {
    var app = this;
    app.loginUser = function(userLogin,$location) {
        $http.post("http://" + site + "/UserLogin",userLogin)
            .success(function(data) {
                if (data == "") {
                    document.getElementById("datavalue").innerHTML="<p>Invalid credentials.</p>";
                    $('#Information').modal('show');

                }
                else    {
                    window.location='/'+data.userId;
                }

            }).error(function () {
                document.getElementById("datavalue").innerHTML="<p>Invalid credentials.</p>";
                $('#Information').modal('show');
            });
    };
});

web_ca.controller("UserGetCtr", function ($scope, $http) {
    var app = this;

    $http.get("http://" + site + "/getAllUsers")
        .success(function (data) {
            $scope.profiles = data;

        })
        .error(function () {

        });
});


function logout()
{

    window.location = "http://localhost:8080";
}
function close_information()
{
    location.reload();
}