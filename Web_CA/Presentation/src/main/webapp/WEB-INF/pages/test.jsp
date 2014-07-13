<html ng-app = "app">
<head>
<link href="resources/css/lib/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/jumbotron.css" rel="stylesheet">
<script src="resources/js/lib/jquery-1.11.1.min.js"></script>
<script src="resources/js/lib/bootstrap.min.js"></script>
<script src="resources/js/lib/angular.min.js"></script>
<script src="resources/js/lib/angular-route.min.js"></script>
<script src="resources/js/lib/angular-resource.min.js"></script>
<script src="resources/js/rulescript.js"></script>
</head>
<body>
<div ng-controller="WorldGetCtr">
    <table class="table">
        <tr ng-repeat="world in worlds">
            <td><button type="button" class="btn btn-default btn-lg" ></button> <label>{{world.worldName}}</label><br>
                <p>{{world.worldDesc}}</p>  </td>
        </tr>
    </table>
</div>
</body>
</html>