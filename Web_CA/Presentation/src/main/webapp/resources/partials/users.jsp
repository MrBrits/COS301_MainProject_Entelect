<div ng-controller="UserGetCtr">
    <input class="form-control" placeholder="Search User" ng-model="searchText"/>
    <table class="table">
        <tr ng-repeat="profile in profiles | filter:search | orderBy:'userFirstName' ">
            <td>{{profile.userFirstName}} </td>
            <td>{{profile.userLastName}}</td>
            <td>{{profile.userEmail}}</td>
        </tr>
    </table>

</div>


