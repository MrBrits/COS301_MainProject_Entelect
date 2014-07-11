<!DOCTYPE html>
<html lang="en" ng-app="myApp">
<head>
    <meta charset="UTF-8">
    <title>Angular Demo</title>

    <script type="text/javascript" src="resources/js/lib/angular.min.js"></script>
    <script src="resources/js/data.js"></script>
    <link href="resources/css/style.css" rel="stylesheet">
</head>
<body >

   <div class="main" ng-controller="mycon">
    <!--<ul class="artistlist">
        <li class="artist cf">{{temp.name}}</li>
        <li class="artist cf">{{temp.surname}}</li>
    </ul>-->
       <input  ng-model="searchText"/>
       <table class="table">

           <tr ng-repeat="profile in profiles | filter:searchText">
               <td>{{profile.userId}}</td>
               <td>{{profile.userFirstName}} </td>
               <td>{{profile.userLastName}}</td>
               <td>{{profile.userEmail}}</td>
               <td>{{profile.userPassword}}</td>
               <td>{{profile.useRole}}</td>
           </tr>
       </table>
   </div>
</body>
</html>
