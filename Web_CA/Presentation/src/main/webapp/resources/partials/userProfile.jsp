<div class="container">
    <h1 class="">My Profile</h1>
    <br/>
    <div class="form-group">
        <div class="btn-group">
            <button type="button" class="btn btn-default btn-sm pull-left" data-toggle="modal" data-target="#editPassword">Change Password</button>
            <button type="button" class="btn btn-default btn-sm pull-left" data-toggle="modal" data-target="#editInfo">Edit Information</button>
            <button type="button" class="btn btn-default btn-sm pull-left" data-toggle="modal" data-target="#editSettings">Settings</button>
        </div>
    </div>
    <hr/>
</div>


<div class="modal fade" id="editPassword" tabindex="-1" role="dialog" aria-labelledby="purchaseLabel" aria-hidden="true" ng-controller="UserManager">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="container"></br>
                <div class="modal-header modal-success" style="width:50%;">
                    <h4>Change password</h4>
                </div>
                <br/>
                <form class="form-horizontal" style="width:60%;">
                    <div class="form-group">
                        <label class="col-md-3 control-label">Password:</label>
                        <div class="col-xs-offset-2 col-xs-4" ng-model="newPass.newOne">
                            <input class="form-control" type="password">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label">Confirm password:</label>
                        <div class="col-xs-offset-2 col-xs-4" ng-model="newPass.newTwo">
                            <input class="form-control" type="password">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-xs-offset-2 col-xs-4">
                            <button type="submit" class="btn btn-primary" data-dismiss="modal" ng-click="changePassword(newPass)">Confirm</button>
                            <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="editInfo" tabindex="-1" role="dialog" aria-labelledby="purchaseLabel" aria-hidden="true" ng-controller="UserManager">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="container"></br>
                <div class="modal-header modal-success" style="width:50%;">
                    <h4>Edit Information</h4>
                </div>
                <br/>
                <form class="form-horizontal" role="form" style="width:40%;">
                    <div class="form-group">
                        <label class="col-lg-3 control-label">First name:</label>
                        <div class="col-lg-8">
                            <input class="form-control" value="Stephan" type="text">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-lg-3 control-label">Last name:</label>
                        <div class="col-lg-8">
                            <input class="form-control" value="Viljoen" type="text">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-lg-3 control-label">Email:</label>
                        <div class="col-lg-8">
                            <input class="form-control" value="sv" type="text">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label"></label>
                        <div class="col-md-8">
                            <input class="btn btn-primary" value="Save Changes" type="button"> <span class=""></span>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="editSettings" tabindex="-1" role="dialog" aria-labelledby="purchaseLabel" aria-hidden="true" ng-controller="UserManager">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="container"></br>
                <div class="modal-header modal-success" style="width:50%;">
                    <h4>Settings</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal pull-left" role="form" style="width:30%;">
                        <div class="form-group">
                            <label class="col-md-3 control-label"></label>
                            <div class="col-md-8">
                                <input type="checkbox" name="tutorial">Keep Tutorials Active
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-md-3 control-label"></label>
                            <div class="col-md-8">
                                <input class="btn btn-primary" value="Confirm" type="button"> <span class=""></span>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>