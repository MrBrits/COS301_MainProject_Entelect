<div class="container marketing">
    <div class="row">
        <div class="panel-group navbar-left col-md-4" id="accordion">
            <div class="panel panel-default" ng-controller="StateManager">
                <div class="panel-heading">
                    <h4 class="panel-title">
                        <a data-toggle="collapse" data-parent="#accordion" href="#state" ng-click="getStates()">
                            States
                        </a>
                    </h4>
                </div>
                <div id="state" class="panel-collapse collapse" >
                    <div>
                        <input class="form-control" placeholder="Search State" ng-model="search.stateName"/>
                        <button type="button" class="btn btn-primary btn-large" data-toggle="modal" data-target="#AddstateModal">Add new State</button>
                        <table class="table" >
                            <tr ng-repeat="state in states | filter:search">
                                <td><button type="button" ng-style="{'background-color':state.stateHex}" class="btn btn-default btn-lg" ></button> <label>{{state.stateName}}</label>
                                    <button type="button" class="btn btn-default btn-sm pull-right" data-toggle="modal" data-target=""><img style="width: 15px; height: 15px" src="resources/img/glyphicons_030_pencil.png"/></button>
                                    <button type="button" onclick="deleteState(id)" id=s{{state.stateId}};{{state.stateName}} class="btn btn-default btn-sm pull-right" data-toggle="modal" data-target="#confirm-deleteState"><img style="width: 15px; height: 15px" src="resources/img/glyphicons_016_bin.png"/></button><br>
                                    <p>{{state.stateDesc}}</p>
                                </td>
                            </tr>
                        </table>
                    </div>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h4 class="panel-title">
                        <a data-toggle="collapse" data-parent="#accordion" href="#rule">
                            Rules
                        </a>
                    </h4>
                </div>
                <div id="rule" class="panel-collapse collapse">
                    <div ng-controller="GetRuleByUserId">
                        <input class="form-control" placeholder="Search Rule" ng-model="search.ruleName"/>
                        <button type="button" class="btn btn-primary btn-large" data-toggle="modal" data-target="#AddRuleModal">Add new Rule</button>

                        <table class="table">
                            <tr ng-repeat="rule in rules | filter:search">
                                <td><button type="button" class="btn btn-default btn-lg" ></button> <label>{{rule.ruleName}}</label>
                                    <button type="button" class="btn btn-default btn-sm pull-right" data-toggle="modal" data-target=""><img style="width: 15px; height: 15px" src="resources/img/glyphicons_030_pencil.png"/></button>
                                    <button type="button" onclick="deleteRule(id)" id=r{{rule.ruleId}};{{rule.ruleName}} class="btn btn-default btn-sm pull-right" data-toggle="modal" data-target="#confirm-deleteRule"><img style="width: 15px; height: 15px" src="resources/img/glyphicons_016_bin.png"/></button><br>
                                    <p>{{rule.ruleDesc}}</p>  </td>
                            </tr>
                        </table>
                    </div>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h4 class="panel-title">
                        <a data-toggle="collapse" data-parent="#accordion" href="#world">
                            Worlds
                        </a>
                    </h4>
                </div>
                <div id="world" class="panel-collapse collapse">
                    <div ng-controller="GetWorldByUserId">
                        <input class="form-control" placeholder="Search World" ng-model="search.worldName"/>
                        <button type="button" class="btn btn-primary btn-large" data-toggle="modal" data-target="#AddWorldModal">Add new World</button>
                        <table class="table">
                            <tr ng-repeat="world in worlds | filter:search">
                                <td>
                                    <button type="button" class="btn btn-default btn-lg" ></button>
                                    <label>{{world.worldName}}</label>
                                    <button type="button" class="btn btn-default btn-sm pull-right" data-toggle="modal" data-target=""><img style="width: 15px; height: 15px" src="resources/img/glyphicons_030_pencil.png"/></button>
                                    <button type="button" onclick="deleteWorld(id)" id=w{{world.worldId}};{{world.worldName}} class="btn btn-default btn-sm pull-right" data-toggle="modal" data-target="#confirm-deleteWorld"><img style="width: 15px; height: 15px" src="resources/img/glyphicons_016_bin.png"/></button><br>
                                    <p>{{world.worldDesc}}</p>
                                </td>
                            </tr>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <!--
        *
        *   Add newsFeed
        *
        -->

    </div>
</div>
<!--Adding a new state to your profile-->
<div class="modal fade" id="AddstateModal" tabindex="-1" role="dialog" aria-labelledby="purchaseLabel" aria-hidden="true" ng-controller="AddStateController as web_ca">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header modal-success">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="purchaseLabel8">Add State</h4>
            </div>
            <div class = "container">
                <br/>
                <form class="form-horizontal">
                    <div class="form-group">
                        <label class="col-xs-2 control-label">State Name</label>
                        <div class="col-xs-4">
                            <input type="text" class="form-control" ng-model="web_ca.newState.stateName" placeholder="Name">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-2 control-label">State Description</label>
                        <div class="col-xs-4">
                            <textarea class="form-control" ng-model="web_ca.newState.stateDesc" placeholder="Description"></textarea>
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-2 control-label">State Value</label>
                        <div class="col-xs-4">
                            <input type="number" class="form-control"  ng-model="web_ca.newState.stateValue" placeholder="Value">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-2 control-label">State Colour</label>
                        <div class="col-xs-4">
                            <input type="color" id ="colour" class="form-control"  ng-model="web_ca.newState.stateHex" placeholder="Colour">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-xs-offset-2 col-xs-4">
                            <button type="submit" class="btn btn-primary" ng-click="web_ca.addState(web_ca.newState)">Add</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<!-- Add new World-->
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
<!-- Add new Rule-->
<div class="modal fade" id="AddRuleModal" tabindex="-1" role="dialog" aria-labelledby="purchaseLabel" aria-hidden="true" ng-controller="AddRuleController as web_ca">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header modal-success">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="purchaseLabel3">Add Rule</h4>
            </div>
            <div class = "container">
                <br/>
                <form class="form-horizontal">
                    <div class="form-group">
                        <label class="col-xs-2 control-label">Name</label>
                        <div class="col-xs-4">
                            <input type="text" class="form-control" ng-model="web_ca.newRule.ruleName" placeholder="Name">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-2 control-label">Description</label>
                        <div class="col-xs-4">
                            <textarea class="form-control" ng-model="web_ca.newRule.ruleDesc" placeholder="Description"></textarea>
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-2 control-label">Priority</label>
                        <div class="col-xs-4">
                            <input type="number" class="form-control"  ng-model="web_ca.newRule.priority" placeholder="1 - Highest, 100 - Lowest">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label>Condition of Rule</label>
                        <div class="form-group">
                            <label class="col-xs-2 control-label" >Is Not</label>
                            <div class="col-xs-4">
                                <select class="form-control" ng-model="web_ca.newRuleCon.isNot">
                                    <option value="true">TRUE</option>
                                    <option value="false">FALSE</option>
                                </select>
                                <span class="help-block"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-xs-2 control-label">Operator</label>
                            <div class="col-xs-4">
                                <select class="form-control" ng-model="web_ca.newRuleCon.operation">
                                    <option value="SUM">SUM</option>
                                    <option value="AVG">AVG</option>
                                    <option value="MIN">MIN</option>
                                    <option value="MAX">MAX</option>
                                    <option value="COUNT">COUNT</option>
                                    <option value="EXACT">EXACT</option>
                                </select>
                                <span class="help-block"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-xs-2 control-label">Condition Neighbours</label>
                            <div class="col-xs-4">
                                <select class="form-control" ng-model="web_ca.newRuleConNeigh.neighbours">
                                    <option value="00000000000000000000000000"> 00000000000000000000000000 </option>
                                </select>
                                <span class="help-block"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-xs-2 control-label">Operand</label>
                            <div class="col-xs-4">
                                <select class="form-control" ng-model="web_ca.newRuleCon.operand">
                                    <option value="<"> < </option>
                                    <option value=">"> > </option>
                                    <option value=">="> >= </option>
                                    <option value="<="> <= </option>
                                    <option value="=="> == </option>
                                </select>
                                <span class="help-block"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-xs-2 control-label">Compare Value</label>
                            <div class="col-xs-4">
                                <input type="number" class="form-control"  ng-model="web_ca.newRuleCon.compareValue" placeholder="Choose State">
                                <span class="help-block"></span>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label>Result of Rule</label>
                        <div class="form-group">
                            <label class="col-xs-2 control-label">Operand</label>
                            <div class="col-xs-4">
                                <select class="form-control" ng-model="web_ca.newRuleRes.operand">
                                    <option value="=="> == </option>
                                </select>
                                <span class="help-block"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-xs-2 control-label">Operator</label>
                            <div class="col-xs-4">
                                <select class="form-control" ng-model="web_ca.newRuleRes.operation">
                                    <option value="SUM">SUM</option>
                                    <option value="AVG">AVG</option>
                                    <option value="MIN">MIN</option>
                                    <option value="MAX">MAX</option>
                                    <option value="COUNT">COUNT</option>
                                    <option value="EXACT">EXACT</option>
                                </select>
                                <span class="help-block"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-xs-2 control-label">Result Neighbours</label>
                            <div class="col-xs-4">
                                <select class="form-control" ng-model="web_ca.newRuleResNeigh.neighbours">
                                    <option value="00000000000000000000000000"> 00000000000000000000000000 </option>
                                </select>
                                <span class="help-block"></span>
                            </div>
                        </div>
                        <label align="center">OR</label>
                        <div class="form-group">
                            <label class="col-xs-2 control-label">Result Value</label>
                            <div class="col-xs-4">
                                <input type="number" class="form-control"  ng-model="web_ca.newRuleRes.resultValue" placeholder="Choose State">
                                <span class="help-block"></span>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-xs-offset-2 col-xs-4">
                            <button type="submit" class="btn btn-primary" ng-click="web_ca.addRule(web_ca.newRule, web_ca.newRuleCon, web_ca.newRuleRes, web_ca.newRuleConNeigh, web_ca.newRuleResNeigh)">Add</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="confirm-deleteWorld"  tabindex="-1" role="dialog" aria-labelledby="purchaseLabel" aria-hidden="true" ng-controller="deleteWorldController as web_ca">
    <div class="modal-dialog">
        <div class="modal-content">
            <div id="DeleteNameWorld" class="modal-header">

            </div>
            <div class="modal-body">
                <p>Are you sure you want to delete?</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                <button type="submit" class="btn btn-warning" ng-click="web_ca.deleteWorldFinalize()">Delete</button>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="confirm-deleteState"  tabindex="-1" role="dialog" aria-labelledby="purchaseLabel" aria-hidden="true" ng-controller="deleteStateController as web_ca">
    <div class="modal-dialog">
        <div class="modal-content">
            <div id="DeleteNameState" class="modal-header">

            </div>
            <div class="modal-body">
                <p>Are you sure you want to delete?</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                <button type="submit" class="btn btn-default" ng-click="web_ca.deleteStateFinalize()">Delete</button>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="confirm-deleteRule"  tabindex="-1" role="dialog" aria-labelledby="purchaseLabel" aria-hidden="true" ng-controller="deleteRuleController as web_ca">
    <div class="modal-dialog">
        <div class="modal-content">
            <div id="DeleteNameRule" class="modal-header">

            </div>
            <div class="modal-body">
                <p>Are you sure you want to delete?</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                <button type="submit" class="btn btn-warning" ng-click="web_ca.deleteRuleFinalize()">Delete</button>
            </div>
        </div>
    </div>
</div>