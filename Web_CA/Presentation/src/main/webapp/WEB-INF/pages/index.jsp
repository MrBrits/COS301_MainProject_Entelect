<!DOCTYPE html>
<html >
<head>

    <link rel="stylesheet" href="resources/css/lib/bootstrap.min.css">
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script type="text/javascript" src="resources/js/lib/angular.min.js"></script>
    <script type="text/javascript" src="resources/js/input.js"></script>
</head>
<body  ng-app="app" ng-controller="AppCtrl as app">

<input name="firstname"type="text" ng-model="app.person.firstName" />
<input name="lastname" type="text" ng-model="app.person.lastName" />
<input type="button" ng-click="app.addPerson(app.person)" />




</body>
</html>