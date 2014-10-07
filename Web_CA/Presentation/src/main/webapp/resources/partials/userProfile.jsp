<div class="container">
    <h1 class="">My Profile
        <a class="pull-right"><img title="profile image" class="img-circle img-responsive" src="http://www.rlsandbox.com/img/profile.jpg"></a>
        <br class=""></h1>


    <br class="">
    <hr class="">
    <div class="row">
        <!-- left column -->
        <div class="col-md-3">
            <div class="text-center">
                <img src="//placehold.it/100" class="avatar img-circle" alt="avatar">
                <h6 class="">Upload a different photo...</h6>

                <input class="form-control" type="file">
            </div>
        </div>
        <!-- edit form column -->
        <div class="col-md-9 personal-info">
            <div class="alert alert-info alert-dismissable" style="display: none;"> <a class="panel-close close" data-dismiss="alert">×</a>  <i class="fa fa-coffee"></i>
                This
                is an <strong class="">.alert</strong>. Use this to show important messages
                to the user.</div>
            <h3 class="">Personal info</h3>

            <form class="form-horizontal" role="form">
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
                    <button type="button" class="btn btn-default btn-sm pull-left" data-toggle="modal" data-target="#editPassword">Change Password</button>
                </div>

                <div class="form-group">
                    <label class="col-md-3 control-label"></label>
                    <div class="col-md-8">
                        Keep Tutorials Active<input type="checkbox" name="tutorial"><br>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-md-3 control-label"></label>
                    <div class="col-md-8">
                        <input class="btn btn-primary" value="Save Changes" type="button"> <span class=""></span>

                        <input class="btn btn-default" value="Cancel" type="reset">
                    </div>
                </div>
            </form>
        </div>

        <div class="row"></div>
    </div>

</div>


<div class="modal fade" id="editPassword" tabindex="-1" role="dialog" aria-labelledby="purchaseLabel" aria-hidden="true" ng-controller="UserManager">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="container"></br>
                <div class="modal-header modal-success">
                    <h4>Change password</h4>
                </div>
                <form class="form-horizontal">
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
                            <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                            <button type="submit" class="btn btn-primary" data-dismiss="modal" ng-click="changePassword(newPass)">Confirm</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>