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
                    <div class="form-group">
                        <label class="col-md-3 control-label">Tutorials</label>
                        <div class="col-lg-8">
                            <input class="form-control" id="tutorials" type="button">
                        </div>
                    </div>
                    <div class="modal-footer  col-xs-11">
                        <button type="submit" class="btn btn-success" style="background-color:#267982"  ng-click="editUser()">Save Changes</button>
                    </div>
                </form>
            </div>

            <hr/>

        </div>
    </div>
</div>
<div class="modal fade" id="Information"  tabindex="-1" role="dialog" aria-labelledby="purchaseLabel" aria-hidden="true" >
    <div class="modal-dialog">
        <div class="modal-content col-xs-6">
            <div class="modal-header"><h4>Information</h4></div>
            <div class="modal-body">
                <div id="datavalue" ></div>
            </div>
            <div class="modal-footer">
                <button id="informationClose" type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>
