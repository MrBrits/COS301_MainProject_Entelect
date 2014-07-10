<!DOCTYPE html>
<html >
<head>

    <link rel="stylesheet" href="resources/css/lib/bootstrap.min.css">
    <script type="text/javascript" src="resources/js/lib/angular.min.js"></script>
    <script type="text/javascript" src="resources/js/input.js"></script>
</head>
<body  ng-app="app" ng-controller="AppCtrl as app">

<input type="text" ng-model="app.person.firstName" />
<input type="text" ng-model="app.person.lastName" />
<input type="button" ng-click="app.addPerson(app.person)" />




</body>
</html>