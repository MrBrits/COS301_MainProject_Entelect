<div class="container">
    <h1 class="">My Profile</h1>
    <br/>
    <hr/>


</div>


<div id="editInfo" ng-controller="UserManager">
    <div>
        <div>
            <div class="container"></br>
                <div style="width:50%;">
                    <h4>Edit Information</h4>
                </div>
                <br/>
                <form class="form-horizontal" role="form" style="width:60%;">
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

<div id="editPassword" ng-controller="UserManager">
    <div>
        <div>
            <div class="container"></br>
                <div style="width:50%;">
                    <h4>Change password</h4>
                </div>
                <br/>
                <form class="form-horizontal" style="width:60%;">
                    <div class="form-group">
                        <label class="col-lg-3 control-label">New Password:</label>
                        <div class="col-lg-8">
                            <input class="form-control" type="password">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-lg-3 control-label">Confirm Password</label>
                        <div class="col-lg-8">
                            <input class="form-control" type="password">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label"></label>
                        <div class="col-md-8">
                            <input class="btn btn-primary" value="Change Password" type="button"> <span class=""></span>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<div id="editSettings" ng-controller="UserManager">
    <div>
        <div>
            <div class="container"></br>
                <div style="width:50%;">
                    <h4>Settings</h4>
                </div>
                <div>
                    <form class="form-horizontal" style="width:60%;">
                        <div class="checkbox">
                            <label>
                                <input type="checkbox"> Tutorials
                            </label>
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
</div>