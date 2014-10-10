<script>
    $("#tutorials").on("click",function(){
       if(this.value=="Enabled")
        this.value="Disabled";
       else
           this.value="Enabled";
    });
</script>
<div id="editInfo" ng-controller="UserManager">
    <div>
        <div>
            <div class="container"></br>
                <br/><br/><br/>
                <h1 class="">Edit Profile</h1>
                <br/>
                <hr/>
                <br/>
                <form class="form-horizontal" role="form" style="width:60%;">
                    <div class="form-group">
                        <label class="col-md-3 control-label" >First name:</label>
                        <div class="col-lg-8">
                            <input id="firstName" class="form-control"  type="text">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label">Last name:</label>
                        <div class="col-lg-8">
                            <input id="lastName" class="form-control"   type="text">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-md-3 control-label">Email:</label>
                        <div class="col-lg-8">
                            <input id="email" class="form-control"    type="text">
                        </div>
                    </div>
                   <!-- <div class="form-group">
                        <label class="col-md-3 control-label">New Password:</label>
                        <div class="col-lg-8">
                            <input class="form-control" type="password">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label">Confirm Password</label>
                        <div class="col-lg-8">
                            <input class="form-control" type="password">
                        </div>
                    </div>-->
                    <div class="form-group">
                        <label class="col-md-3 control-label">Tutorials</label>
                        <div class="col-lg-8">
                            <input class="form-control" id="tutorials" type="button">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label"></label>
                        <div class="col-md-8">
                            <button type="submit" class="btn btn-success"  ng-click="editUser()">Save Changes</button>
                        </div>
                    </div>
                </form>
            </div>

            <hr/>

        </div>
    </div>
</div>
