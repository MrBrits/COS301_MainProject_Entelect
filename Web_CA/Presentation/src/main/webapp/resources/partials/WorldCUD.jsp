<div class="modal fade" id="confirm-deleteWorld"  tabindex="-1" role="dialog" aria-labelledby="purchaseLabel" aria-hidden="true" ng-controller="deleteWorldController as web_ca">
    <div class="modal-dialog">
        <div class="modal-content">
            <div id="DeleteNameWorld" class="modal-header">

            </div>
            <div class="modal-body">
                <input id ="worldIdhidden" type="hidden" class="form-control"  ng-model="web_ca.DeleteWorld.worldId"/>
                <p>Are you sure you want to delete?</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                <button type="submit" class="btn btn-warning" ng-click="web_ca.deleteWorldFinalize()">Delete</button>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="AddWorldModal" tabindex="-1" role="dialog" aria-labelledby="purchaseLabel" aria-hidden="true" ng-controller="AddWorldController as web_ca">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header modal-success">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="purchaseLabel">Add World</h4>
            </div>
            <div class = "container">
                <br/>
                <form class="form-horizontal">
                    <div class="form-group">
                        <label class="col-xs-2 control-label">Name</label>
                        <div class="col-xs-4">
                            <input type="text" class="form-control" ng-model="web_ca.newWorld.worldName" placeholder="Name">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-2 control-label">Description</label>
                        <div class="col-xs-4">
                            <textarea ng-maxlength="140" class="form-control" ng-model="web_ca.newWorld.worldDesc" placeholder="Description"></textarea>
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-2 control-label">Dimension</label>
                        <div class="col-xs-4">
                            <select class="form-control" ng-model="web_ca.newWorld.worldDimension">
                                <option value="1">1D</option>
                                <option value="2">2D</option>
                                <option value="3">3D</option>
                            </select>
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-2 control-label">Width</label>
                        <div class="col-xs-4">
                            <input type="number" class="form-control"  ng-model="web_ca.newWorld.worldWidth" placeholder="Width">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-2 control-label">Height</label>
                        <div class="col-xs-4">
                            <input type="number" class="form-control"  ng-model="web_ca.newWorld.worldHeight" placeholder="Height">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-2 control-label">Depth</label>
                        <div class="col-xs-4">
                            <input type="number" class="form-control"  ng-model="web_ca.newWorld.worldDepth" placeholder="Depth">
                            <span class="help-block"></span>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-xs-offset-2 col-xs-4">
                            <button type="submit" class="btn btn-primary" ng-click="web_ca.addWorld(web_ca.newWorld)">Add</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>