/**
 * Created by Laptop on 7/9/2014.
 */
/*
var myApp =angular.module('myApp',[]);
myApp.controller('mycon',function mycon($scope) {
    $scope.temp = {
        'name': 'john',
        'surname': 'surname'
    }
});
*/

/*var myApp = angular.module("myApp", []);

myApp.controller("mycon", [ '$scope', '$http',
    function($scope, $http) {
        $http({method : 'GET',
            url : '/getAllProfiles'})
            .success(function(data) {
                $scope.profiles = data;
                alert(data);
            })
            .error(function() {
                alert("fail");
            });
    } ]);

*/
var myApp = angular.module("myApp", []);
myApp.controller("mycon", function($scope,$http) {
    var app = this;
    $http.get("http://localhost:8080/getAllProfiles")
        .success(function (data) {
            $scope.profiles = data;
            alert(data)
        }).error(function () {
            alert("fail");
        });
});