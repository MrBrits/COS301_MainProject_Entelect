
<script src="resources/js/app.js"></script>

<div ng-controller="mycon">
    <input  ng-model="searchText"/>
    <table class="table">
        <tr ng-repeat="profile in profiles | filter:searchText | orderBy:'userFirstName' ">
            <td>{{profile.userFirstName}} </td>
            <td>{{profile.userLastName}}</td>
            <td>{{profile.userEmail}}</td>
        </tr>
    </table>

</div>