<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="utf-8">
    <title>Egghead.io</title>
    <link rel="stylesheet" href="resources/css/lib/bootstrap.min.css">
</head>
<body ng-app="app" ng-controller="AppCtrl as app">

<input type="text" ng-model="app.person.firstName" />
<input type="text" ng-model="app.person.lastName" />
<input value="Submit" type="button" ng-click="addPerson(app.person)"/>

<ul>
    <li ng-repeat="person in app.people">
        {{person.firstName}} {{person.lastName}}
    </li>
</ul>

<script type="text/javascript" src="resources/js/lib/angular.min.js"></script>
<script type="text/javascript" src="resources/js/input.js"></script>
</body>
</html>