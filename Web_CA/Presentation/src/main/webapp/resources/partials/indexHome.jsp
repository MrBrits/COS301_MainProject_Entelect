<style>
    html, body {
        height: 100%;
    }

    body {
        background-color: #666666;
        margin: 0;
        font-family: Arial;
        overflow: hidden;
    }

    #search {
        position: absolute;
        bottom: 30px;
        width: 100%;
        text-align: center;
    }

    #search input {
        color: #ffffff;
        background-color: transparent;
        border: 1px solid #0080ff;
        padding: 10px;
        font-size: 20px;
        text-transform: uppercase;
        -webkit-border-radius: 0px; /* workaround for ios safari */
    }

    #search button {
        color: #0080ff;
        background-color: transparent;
        border: 1px solid #0080ff;
        padding: 10px;
        font-size: 20px;
        text-transform: uppercase;
        cursor: pointer;
    }
</style>

<div style="position:fixed;left:0px" id="myContainer"></div>
<script src="resources/js/videoScene.js">
    $('[data-toggle="tooltip"]').tooltip();
</script>
<div class="container marketing" style="position:relative;top:100px ">
    <div class="row">
        <div class="panel-group navbar-left col-md-4" id="accordion">
            <div class="panel panel-default" ng-controller="StateManager">
                <div class="panel-heading">
                    <h4 class="panel-title" style="height: 30px">
                        <label>&emsp;States</label>
                        <button class="btn btn-default btn-sm pull-right btn-info" data-toggle="collapse" data-parent="#accordion" data-target="#state" ng-click="getStates()"><img style="width: 15px; height: 15px" src="resources/img/glyphicons_113_justify.png"></button>
                    </h4>
                </div>
                <div id="state" style="height: auto;max-height: 200px;overflow-y: auto;"class="panel-collapse collapse" >
                    <div>
                        <input class="form-control" placeholder="Search State" ng-model="search.stateName"/>
                        <button type="button" class="btn btn-primary btn-large" data-toggle="modal" data-target="#addStateModal">Add new State</button>
                        <table class="table" >
                            <tr ng-repeat="state in states | filter:search">
                                <td>
                                    <button type="button" ng-style="{'background-color':state.stateHex}" class="btn btn-default btn-lg"  ></button>
                                    <label>{{state.stateName}}</label>
                                    <button type="button" class="btn btn-default btn-sm pull-right btn-danger" onclick="deleteState(id)" id=s{{state.stateId}};{{state.stateName}} class="btn btn-default btn-sm pull-right" data-toggle="modal" data-target="#deleteStateModal"><img style="width: 15px; height: 15px" src="resources/img/glyphicons_016_bin.png"/></button>
                                    <button type="button" class="btn btn-default btn-sm pull-right btn-success" data-toggle="modal" data-target="#editStateModal"  ng-click="getEditState(state.stateId)" id={{state.stateId}}><img style="width: 15px; height: 15px" src="resources/img/glyphicons_030_pencil.png"/></button>
                                    <br>
                                   <p>{{state.stateDesc}}</p>
                                </td>
                            </tr>
                        </table>
                    </div>
                </div>
            </div>
            <div class="panel panel-default" ng-controller="RuleManager">
                <div class="panel-heading">
                    <h4 class="panel-title" style="height: 30px">
                        <label>&emsp;Rules</label>
                        <button class="btn btn-default btn-sm pull-right btn-info" data-toggle="collapse" data-parent="#accordion" data-target="#rule" ng-click="getRules()"><img style="width: 15px; height: 15px" src="resources/img/glyphicons_113_justify.png"></button>
                    </h4>
                </div>
                <div id="rule" style="height: auto;max-height: 200px;overflow-y: auto;" class="panel-collapse collapse">
                    <div >
                        <input class="form-control" placeholder="Search Rule" ng-model="search.ruleName"/>
                        <button type="button"  class="btn btn-primary btn-large" data-toggle="modal" data-target="#addRuleModalTabs">Add new Rule(GUI)</button>
                        <button type="button" onclick="setDefualt()" class="btn btn-primary btn-large" data-toggle="modal" data-target="#addRuleModalDSL">Add new Rule(EDITOR)</button>
                        <table class="table">
                            <tr ng-repeat="rule in rules | filter:search">
                                <td>
                                    <button type="button" class="btn btn-default btn-lg" ></button>
                                    <label>{{rule.ruleName}}</label>
                                    <button type="button" onclick="deleteRule(id)" id=r{{rule.ruleId}};{{rule.ruleName}} class="btn btn-default btn-sm pull-right btn-danger" data-toggle="modal" data-target="#deleteRuleModal"><img style="width: 15px; height: 15px" src="resources/img/glyphicons_016_bin.png"/></button>
                                    <button type="button" class="btn btn-default btn-sm pull-right btn-success" data-toggle="modal" data-target="#editRuleModalTabs" ng-click="getEditRule(rule.ruleId)" id={{rule.ruleId}}><img style="width: 15px; height: 15px" src="resources/img/glyphicons_030_pencil.png"/></button>
                                    <br>
                                    <p>{{rule.ruleDesc}}</p>
                                </td>
                            </tr>
                        </table>
                    </div>
                </div>
            </div>
            <div class="panel panel-default"ng-controller="WorldManager">
                <div class="panel-heading">
                    <h4 class="panel-title" style="height: 30px">
                        <label>&emsp;Worlds</label>
                        <button class="btn btn-default btn-sm pull-right btn-info" data-toggle="collapse" data-parent="#accordion" data-target="#world" ng-click="getWorlds()"><img style="width: 15px; height: 15px" src="resources/img/glyphicons_113_justify.png"></button>
                    </h4>
                </div>
                <div id="world" style="height: auto;max-height: 200px;overflow-y: auto;"class="panel-collapse collapse">
                    <div >
                        <input class="form-control" placeholder="Search World" ng-model="search.worldName"/>
                        <button type="button" class="btn btn-primary btn-large" data-toggle="modal" data-target="#addWorldModal">Add new World</button>

                        <table class="table">
                            <tr ng-repeat="world in worlds | filter:search">
                                <td>
                                    <button type="button" class="btn btn-default btn-lg"></button>
                                    <a href="#simulator"  ><label id={{world.worldId}} onclick="setWorldID(id)"> {{world.worldName}}</label></a>
                                    <button type="button" onclick="deleteWorld(id)" id=w{{world.worldId}};{{world.worldName}} class="btn btn-default btn-sm pull-right btn-danger" data-toggle="modal" data-target="#deleteWorldModal"><img style="width: 15px; height: 15px" src="resources/img/glyphicons_016_bin.png"/></button>
                                    <button type="button" class="btn btn-default btn-sm pull-right btn-success" data-toggle="modal" data-target="#editWorldModal" ng-click="getEditWorld(world.worldId)" id={{world.worldId}}><img style="width: 15px; height: 15px" src="resources/img/glyphicons_030_pencil.png"/></button>
                                    <br>
                                    <p>{{world.worldDesc}}</p>
                                </td>
                            </tr>
                        </table>
                    </div>
                </div>
            </div>
            <div class="panel panel-default"ng-controller="WorldManager">
                <div class="panel-heading">
                    <h4 class="panel-title" style="height: 30px">
                        <label>&emsp;Import Worlds</label>
                        <button class="btn btn-default btn-sm pull-right btn-info" data-toggle="collapse" data-parent="#accordion" data-target="#worldImport" ng-click="getNotWorlds()"><img style="width: 15px; height: 15px" src="resources/img/glyphicons_113_justify.png"></button>
                    </h4>
                </div>
                <div id="worldImport" style="height: auto;max-height: 200px;overflow-y: auto;"class="panel-collapse collapse">
                    <div >
                        <input class="form-control" placeholder="Search World" ng-model="search.worldName"/>
                        <table class="table">
                            <tr ng-repeat="world in worlds | filter:search">
                                <td>
                                    <button type="button" class="btn btn-default btn-lg"></button>
                                    <a href="#simulator"  ><label  onclick="setWorldID(id)"> {{world.worldName}}</label></a>
                                    <button type="button" ng-click="ImportWorlds(world.worldId)"  class="btn btn-default btn-sm pull-right btn-success" data-toggle="modal" ><span class="glyphicon glyphicon-download"></span></button>
                                    <br>
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
<div class="modal fade" id="addStateModal" tabindex="-1" role="dialog" aria-labelledby="purchaseLabel" aria-hidden="true" ng-controller="StateManager">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header modal-success">
                <h4 class="modal-title" id="purchaseLabel8">Add State</h4>
            </div>
            <div class = "container">
                <br/>
                <form class="form-horizontal">
                    <div class="form-group">
                        <label class="col-xs-2 control-label">State Name</label>
                        <div class="col-xs-4">
                            <input type="text" class="form-control" ng-model="newState.stateName" placeholder="Name">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-2 control-label">State Description</label>
                        <div class="col-xs-4">
                            <textarea class="form-control" ng-model="newState.stateDesc" placeholder="Description"></textarea>
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-2 control-label">State Value</label>
                        <div class="col-xs-4">
                            <input type="number" step="0.1" class="form-control"  ng-model="newState.stateValue" placeholder="Value">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-2 control-label">State Colour</label>
                        <div class="col-xs-4">
                            <input type="color" id ="colour" class="form-control"  ng-model="newState.stateHex">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-xs-offset-2 col-xs-4">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                            <button type="submit" class="btn btn-primary" data-dismiss="modal" ng-click="addState(newState)">Add</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="editStateModal" tabindex="-1" role="dialog" aria-labelledby="purchaseLabel" aria-hidden="true" ng-controller="StateManager">
    <div class="modal-dialog">
        <div class="modal-content">
            <div id="editStateTitle" class="modal-header modal-success">

            </div>
            <div class = "container">
                <br/>
                <form class="form-horizontal">
                    <input id="editStateIdHidden" ng-model="oldState.stateId" type="hidden"/>
                    <div class="form-group">
                        <label class="col-xs-2 control-label">State Name</label>
                        <div class="col-xs-4">
                            <input id="editStateName" type=text class=form-control ng-model=oldState.stateName>
                            <span class=help-block></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-2 control-label">State Description</label>
                        <div class="col-xs-4">
                            <textarea id="editStateDesc" class="form-control" ng-model="oldState.stateDesc"></textarea>
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-2 control-label">State Value</label>
                        <div class="col-xs-4">
                            <input id="editStateValue" type="number" class="form-control"  ng-model="oldState.stateValue">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-2 control-label">State Colour</label>
                        <div class="col-xs-4">
                            <input id="editStateHex" type="color" class="form-control"  ng-model="oldState.stateHex">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-xs-offset-2 col-xs-4">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                            <button type="submit" class="btn btn-success" data-dismiss="modal" ng-click="editState(oldState)">Edit</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<!-- Add new World-->
<div class="modal fade" id="addWorldModal" tabindex="-1" role="dialog" aria-labelledby="purchaseLabel" aria-hidden="true" ng-controller="WorldManager">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header modal-success">
                <h4 class="modal-title" id="purchaseLabel">Add World</h4>
            </div>
            <div class = "container">
                <br/>
                <form class="form-horizontal">
                    <div class="form-group">
                        <label class="col-xs-2 control-label">Name</label>
                        <div class="col-xs-4">
                            <input type="text" class="form-control" ng-model="newWorld.worldName" placeholder="Name" >
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-2 control-label">Description</label>
                        <div class="col-xs-4">
                            <textarea ng-maxlength="140" class="form-control" ng-model="newWorld.worldDesc" placeholder="Description"></textarea>
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-2 control-label">Dimension</label>
                        <div class="col-xs-4">
                            <select class="form-control" id="addWorldDim" onchange="evaluateDim()" ng-model="newWorld.worldDimension" >
                                <option value="2" selected>2D</option>
                                <option value="3">3D</option>
                            </select>
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-2 control-label">Width</label>
                        <div class="col-xs-4">
                            <input type="number" min="1" class="form-control"  ng-model="newWorld.worldWidth" placeholder="Width" >
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-2 control-label">Height</label>
                        <div class="col-xs-4">
                            <input type="number" min="1" class="form-control"  ng-model="newWorld.worldHeight" placeholder="Height" >
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-2 control-label">Depth</label>
                        <div class="col-xs-4" >
                            <input type="number" min="1" class="form-control" id="addWorldDepth" ng-model="newWorld.worldDepth" placeholder="Depth" >
                            <span class="help-block"></span>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-xs-offset-2 col-xs-4">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                            <button type="submit" class="btn btn-primary" data-dismiss="modal" ng-click="addWorld(newWorld)">Add</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="editWorldModal" tabindex="-1" role="dialog" aria-labelledby="purchaseLabel" aria-hidden="true" ng-controller="WorldManager">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header modal-success">
                <h4 class="modal-title">Edit World</h4>
            </div>
            <div class = "container">
                <br/>
                <form class="form-horizontal">
                    <input id="editWorldIdHidden" ng-model="oldWorld.worldId" type="hidden"/>
                    <div class="form-group">
                        <label class="col-xs-2 control-label">Name</label>
                        <div class="col-xs-4">
                            <input type="text" id="editWorldName" class="form-control" ng-model="oldWorld.worldName">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-2 control-label">Description</label>
                        <div class="col-xs-4">
                            <textarea ng-maxlength="140" id="editWorldDesc" class="form-control" ng-model="oldWorld.worldDesc"></textarea>
                            <span class="help-block"></span>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-xs-offset-2 col-xs-4">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                            <button type="submit" class="btn btn-success" data-dismiss="modal" ng-click="editWorld(oldWorld)">Edit</button>
                        </div>
                    </div>
                    <input id="editWorldDimension" ng-model="oldWorld.worldId" type="hidden"/>
                    <input id="editWorldWidth" ng-model="oldWorld.worldId" type="hidden"/>
                    <input id="editWorldHeight" ng-model="oldWorld.worldId" type="hidden"/>
                    <input id="editWorldDepth" ng-model="oldWorld.worldId" type="hidden"/>
                </form>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="addRuleModalDSL" tabindex="-1" role="dialog" aria-labelledby="purchaseLabel" aria-hidden="true" ng-controller="RuleManager">
    <div class="modal-dialog ">
        <div class="modal-content">
            <div class="modal-header modal-success">
                <h4 class="modal-title">Rule editor</h4>
            </div>
            <div class = "container">
                <br/>
                <form class="form-horizontal">
                    <div class="form-group">

                            <label class="col-xs-1 control-label">when</label>
                            <div class="col-md-5">
                                <input type="text" class="form-control" placeholder="(if condition and/or condition)| (if condition ) " ng-model="ruleeditor.line1" data-toggle="tooltip" data-placement="top" title="Tooltip on top">
                                <span class="help-block"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-xs-1 control-label">then</label>
                            <div class="col-md-5">
                                <input type="text" class="form-control" placeholder="(then operation of neighbours)|(then = value)" data-toggle="popover" title="Popover title" data-content="And here's some amazing content. It's very engaging. Right?"ng-model="ruleeditor.line2">
                                <span class="help-block"></span>
                            </div>
                            <a href="#" tabindex="0" class="btn btn-lg btn-danger" data-toggle="popover" data-trigger="focus" title="Dismissible popover" data-content="And here's some amazing content. It's very engaging. Right?">Dismissible popover</a>
                        </div>
                        <div class="form-group">
                            <label class="col-xs-1 control-label" >identifiedBy</label>
                            <div class="col-md-5">
                                <input type="text"  class="form-control" placeholder="(identifiedBy RuleName RuleDesc)" ng-model="ruleeditor.line3">

                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-xs-offset-3 col-xs-4">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                            <button type="submit" class="btn btn-success" data-dismiss="modal" ng-click="addRuleEditor(ruleeditor)">Add</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="addRuleModalTabs" tabindex="-1" role="dialog" aria-labelledby="purchaseLabel" aria-hidden="true" ng-controller="RuleManager">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header modal-success">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">Add Rule</h4>
            </div>
            <div class = "container">
                <div class="col-xs-6">
                    <ul class="nav nav-tabs">
                        <li class="active"><a data-target="#detailsAdd" data-toggle="tab">Details</a></li>
                        <li><a data-target="#conditionAdd" data-toggle="tab">Condition</a></li>
                        <li><a data-target="#conditionAndOrAdd" data-toggle="tab">AND/OR Condition</a></li>
                        <li><a data-target="#resultAdd" data-toggle="tab">Result</a></li>
                    </ul>
                </div></br></br></br>

                <form class="form-horizontal">
                    <div class="tab-content">
                        <div class="tab-pane active" id="detailsAdd">
                                <div class="form-group">
                                    <label class="col-xs-2 control-label">Name</label>
                                    <div class="col-xs-4">
                                        <input type="text" class="form-control" ng-model="newRule.ruleName" placeholder="Name">
                                        <span class="help-block"></span>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-xs-2 control-label">Description</label>
                                    <div class="col-xs-4">
                                        <textarea class="form-control" ng-model="newRule.ruleDesc" placeholder="Description"></textarea>
                                        <span class="help-block"></span>
                                    </div>
                                </div>
                        </div>
                        <div class="tab-pane fade" id="conditionAdd">
                            <div class="form-group">
                                <div class="form-group">
                                    <label class="col-xs-2 control-label" >Is Not</label>
                                    <div class="col-xs-4">
                                        <select class="form-control" ng-model="newRuleCon.isNot">
                                            <option value="true">TRUE</option>
                                            <option value="false">FALSE</option>
                                        </select>
                                        <span class="help-block"></span>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-xs-2 control-label">Operation</label>
                                    <div class="col-xs-4">
                                        <select class="form-control" id="addRuleCon1Operation" onchange="evaluateAdd1Operation()" ng-model="newRuleCon.operation">
                                            <option value="SUM">SUM</option>
                                            <option value="AVG">AVG</option>
                                            <option value="MIN">MIN</option>
                                            <option value="MAX">MAX</option>
                                            <option id="addRule1Count" value="COUNT">COUNT</option>
                                        </select>
                                        <span class="help-block"></span>
                                    </div>
                                </div>
                                <!--
                                <div class="form-group">
                                    <label class="col-xs-2 control-label">Condition Neighbours</label>
                                    <div class="col-xs-4">
                                        <input type="text" class="form-control" ng-model="newRuleConNeigh.neighbours" required>
                                        <span class="help-block"></span>
                                    </div>
                                </div>
                                -->
                                <div class="form-group">
                                    <label class="col-xs-2 control-label">Neighbours</label>
                                    <div class="col-xs-4">
                                        <label class="col-xs-2">TOP&emsp;</label><label class="col-xs-2">MID&emsp;</label><label class="col-xs-2">BOT</label><br><br>
                                        &emsp;<input type="checkbox" id="addCon1Neigh25"><input type="checkbox" id="addCon1Neigh26"><input type="checkbox" id="addCon1Neigh27">&emsp;<input type="checkbox" id="addCon1Neigh16"><input type="checkbox" id="addCon1Neigh17"><input type="checkbox" id="addCon1Neigh18">&emsp;<input type="checkbox" id="addCon1Neigh7"><input type="checkbox" id="addCon1Neigh8"><input type="checkbox" id="addCon1Neigh9"><br>
                                        &emsp;<input type="checkbox" id="addCon1Neigh22"><input type="checkbox" id="addCon1Neigh23"><input type="checkbox" id="addCon1Neigh24">&emsp;<input type="checkbox" id="addCon1Neigh13"><input type="checkbox" id="addCon1Neigh14"><input type="checkbox" id="addCon1Neigh15">&emsp;<input type="checkbox" id="addCon1Neigh4"><input type="checkbox" id="addCon1Neigh5"><input type="checkbox" id="addCon1Neigh6"><br>
                                        &emsp;<input type="checkbox" id="addCon1Neigh19"><input type="checkbox" id="addCon1Neigh20"><input type="checkbox" id="addCon1Neigh21">&emsp;<input type="checkbox" id="addCon1Neigh10"><input type="checkbox" id="addCon1Neigh11"><input type="checkbox" id="addCon1Neigh12">&emsp;<input type="checkbox" id="addCon1Neigh1"><input type="checkbox" id="addCon1Neigh2"><input type="checkbox" id="addCon1Neigh3"><br>
                                        <span class="help-block"></span>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-xs-2 control-label">Operand</label>
                                    <div class="col-xs-4">
                                        <select class="form-control" id="addRuleCon1Operand" onchange="evaluateAdd1Operand()" ng-model="newRuleCon.operand">
                                            <option value="<"> < </option>
                                            <option value=">"> > </option>
                                            <option value=">="> >= </option>
                                            <option value="<="> <= </option>
                                            <option value="=="> == </option>
                                            <option id="addRule1BE" value="BE"> BETWEEN (excludes) </option>
                                            <option id="addRule1BI" value="BI"> BETWEEN (includes) </option>
                                        </select>
                                        <span class="help-block"></span>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-xs-2 control-label">Compare Value One</label>
                                    <div class="col-xs-4">
                                        <input type="number" step="0.1" class="form-control" id="addRule1CompareValueOne" onchange="evaluateAddCompareValue()" ng-model="newRuleCon.compareValueOne" placeholder="Choose State Value">
                                        <span class="help-block"></span>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-xs-2 control-label">Compare Value Two</label>
                                    <div class="col-xs-4">
                                        <input type="number" step="0.1" class="form-control" id="addRule1CompareValueTwo" onchange="evaluateAddCompareValue()" ng-model="newRuleCon.compareValueTwo" placeholder="Used with COUNT or BETWEEN" disabled>
                                        <span class="help-block"></span>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="tab-pane fade" id="conditionAndOrAdd">
                            <div class="form-group">
                                <div class="form-group">
                                    <label class="col-xs-2 control-label" >AND/OR</label>
                                    <div class="col-xs-4">
                                        <select class="form-control" ng-model="newRuleConAndOr.AndOr">
                                            <option value=""></option>
                                            <option value="AND">AND</option>
                                            <option value="OR">OR</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-xs-2 control-label" >Is Not</label>
                                    <div class="col-xs-4">
                                        <select class="form-control" ng-model="newRuleConAndOr.isNot">
                                            <option value="true">TRUE</option>
                                            <option value="false">FALSE</option>
                                        </select>
                                        <span class="help-block"></span>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-xs-2 control-label">Operation</label>
                                    <div class="col-xs-4">
                                        <select class="form-control" id="addRuleCon2Operation" onchange="evaluateAdd2Operation()" ng-model="newRuleConAndOr.operation">
                                            <option value="SUM">SUM</option>
                                            <option value="AVG">AVG</option>
                                            <option value="MIN">MIN</option>
                                            <option value="MAX">MAX</option>
                                            <option id="addRule2Count" value="COUNT">COUNT</option>
                                        </select>
                                        <span class="help-block"></span>
                                    </div>
                                </div>
                                <!--
                                <div class="form-group">
                                    <label class="col-xs-2 control-label">Condition Neighbours</label>
                                    <div class="col-xs-4">
                                        <input type="text" class="form-control" ng-model="newRuleConNeighAndOr.neighbours">
                                        <span class="help-block"></span>
                                    </div>
                                </div>
                                -->
                                <div class="form-group">
                                    <label class="col-xs-2 control-label">Neighbours</label>
                                    <div class="col-xs-4">
                                        <label class="col-xs-2">TOP&emsp;</label><label class="col-xs-2">MID&emsp;</label><label class="col-xs-2">BOT</label><br><br>
                                        &emsp;<input type="checkbox" id="addCon2Neigh25"><input type="checkbox" id="addCon2Neigh26"><input type="checkbox" id="addCon2Neigh27">&emsp;<input type="checkbox" id="addCon2Neigh16"><input type="checkbox" id="addCon2Neigh17"><input type="checkbox" id="addCon2Neigh18">&emsp;<input type="checkbox" id="addCon2Neigh7"><input type="checkbox" id="addCon2Neigh8"><input type="checkbox" id="addCon2Neigh9"><br>
                                        &emsp;<input type="checkbox" id="addCon2Neigh22"><input type="checkbox" id="addCon2Neigh23"><input type="checkbox" id="addCon2Neigh24">&emsp;<input type="checkbox" id="addCon2Neigh13"><input type="checkbox" id="addCon2Neigh14"><input type="checkbox" id="addCon2Neigh15">&emsp;<input type="checkbox" id="addCon2Neigh4"><input type="checkbox" id="addCon2Neigh5"><input type="checkbox" id="addCon2Neigh6"><br>
                                        &emsp;<input type="checkbox" id="addCon2Neigh19"><input type="checkbox" id="addCon2Neigh20"><input type="checkbox" id="addCon2Neigh21">&emsp;<input type="checkbox" id="addCon2Neigh10"><input type="checkbox" id="addCon2Neigh11"><input type="checkbox" id="addCon2Neigh12">&emsp;<input type="checkbox" id="addCon2Neigh1"><input type="checkbox" id="addCon2Neigh2"><input type="checkbox" id="addCon2Neigh3"><br>
                                        <span class="help-block"></span>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-xs-2 control-label">Operand</label>
                                    <div class="col-xs-4">
                                        <select class="form-control" id="addRuleCon2Operand" onchange="evaluateAdd2Operand()" ng-model="newRuleConAndOr.operand">
                                            <option value="<"> < </option>
                                            <option value=">"> > </option>
                                            <option value=">="> >= </option>
                                            <option value="<="> <= </option>
                                            <option value="=="> == </option>
                                            <option id="addRule2BE" value="BE"> BETWEEN (excludes) </option>
                                            <option id="addRule2BI" value="BI"> BETWEEN (includes) </option>
                                        </select>
                                        <span class="help-block"></span>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-xs-2 control-label">Compare Value One</label>
                                    <div class="col-xs-4">
                                        <input type="number" step="0.1" class="form-control" id="addRule2CompareValueOne" onchange="evaluateAddCompareValue()" ng-model="newRuleConAndOr.compareValueOne" placeholder="Choose State Value">
                                        <span class="help-block"></span>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-xs-2 control-label">Compare Value Two</label>
                                    <div class="col-xs-4">
                                        <input type="number" step="0.1" class="form-control" id="addRule2CompareValueTwo" onchange="evaluateAddCompareValue()" ng-model="newRuleConAndOr.compareValueTwo" placeholder="Used with COUNT or BETWEEN" disabled>
                                        <span class="help-block"></span>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="tab-pane fade" id="resultAdd">
                            <div class="form-group">
                                <div class="form-group">
                                    <label class="col-xs-2 control-label">Operator</label>
                                    <div class="col-xs-4">
                                        <select class="form-control" id="addRuleResOperation" onchange="evaluateAddResult()" ng-model="newRuleRes.operation">
                                            <option value=""></option>
                                            <option value="SUM">SUM</option>
                                            <option value="AVG">AVG</option>
                                            <option value="MIN">MIN</option>
                                            <option value="MAX">MAX</option>
                                        </select>
                                        <span class="help-block"></span>
                                    </div>
                                </div>
                                <!--
                                <div class="form-group">
                                    <label class="col-xs-2 control-label">Result Neighbours</label>
                                    <div class="col-xs-4">
                                        <input type="text" class="form-control" id="addRuleResNeigh" onchange="evaluateAddResult()" ng-model="newRuleResNeigh.neighbours">
                                        <span class="help-block"></span>
                                    </div>
                                </div>
                                -->
                                <div class="form-group" id="addRuleResNeigh">
                                    <label class="col-xs-2 control-label">Neighbours</label>
                                    <div class="col-xs-4">
                                        <label class="col-xs-2">TOP&emsp;</label><label class="col-xs-2">MID&emsp;</label><label class="col-xs-2">BOT</label><br><br>
                                        &emsp;<input type="checkbox" id="addResNeigh25" onchange="evaluateAddResult()"><input type="checkbox" id="addResNeigh26" onchange="evaluateAddResult()"><input type="checkbox" id="addResNeigh27" onchange="evaluateAddResult()">&emsp;
                                        <input type="checkbox" id="addResNeigh16" onchange="evaluateAddResult()"><input type="checkbox" id="addResNeigh17" onchange="evaluateAddResult()"><input type="checkbox" id="addResNeigh18" onchange="evaluateAddResult()">&emsp;
                                        <input type="checkbox" id="addResNeigh7" onchange="evaluateAddResult()"><input type="checkbox" id="addResNeigh8" onchange="evaluateAddResult()"><input type="checkbox" id="addResNeigh9" onchange="evaluateAddResult()"><br>
                                        &emsp;<input type="checkbox" id="addResNeigh22" onchange="evaluateAddResult()"><input type="checkbox" id="addResNeigh23" onchange="evaluateAddResult()"><input type="checkbox" id="addResNeigh24" onchange="evaluateAddResult()">&emsp;
                                        <input type="checkbox" id="addResNeigh13" onchange="evaluateAddResult()"><input type="checkbox" id="addResNeigh14" onchange="evaluateAddResult()"><input type="checkbox" id="addResNeigh15" onchange="evaluateAddResult()">&emsp;
                                        <input type="checkbox" id="addResNeigh4" onchange="evaluateAddResult()"><input type="checkbox" id="addResNeigh5" onchange="evaluateAddResult()"><input type="checkbox" id="addResNeigh6" onchange="evaluateAddResult()"><br>
                                        &emsp;<input type="checkbox" id="addResNeigh19" onchange="evaluateAddResult()"><input type="checkbox" id="addResNeigh20" onchange="evaluateAddResult()"><input type="checkbox" id="addResNeigh21" onchange="evaluateAddResult()">&emsp;
                                        <input type="checkbox" id="addResNeigh10" onchange="evaluateAddResult()"><input type="checkbox" id="addResNeigh11" onchange="evaluateAddResult()"><input type="checkbox" id="addResNeigh12" onchange="evaluateAddResult()">&emsp;
                                        <input type="checkbox" id="addResNeigh1" onchange="evaluateAddResult()"><input type="checkbox" id="addResNeigh2" onchange="evaluateAddResult()"><input type="checkbox" id="addResNeigh3" onchange="evaluateAddResult()"><br>
                                        <span class="help-block"></span>
                                    </div>
                                </div>

                                <label align="center">OR</label>
                                <div class="form-group">
                                    <label class="col-xs-2 control-label">Result Value</label>
                                    <div class="col-xs-4">
                                        <input type="number" step="0.1" class="form-control" id="addRuleResValue" onchange="evaluateAddResult()" ng-model="newRuleRes.resultValue" placeholder="Choose State Value">
                                        <span class="help-block"></span>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-xs-offset-2 col-xs-4">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                                    <button type="submit" class="btn btn-primary" data-dismiss="modal" ng-click="addRule(newRule, newRuleCon, newRuleConAndOr, newRuleRes)">Add</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="editRuleModalTabs" tabindex="-1" role="dialog" aria-labelledby="purchaseLabel" aria-hidden="true" ng-controller="RuleManager">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header modal-success">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">Edit Rule</h4>
            </div>
            <div class = "container">

                <div class="col-xs-6">
                    <ul class="nav nav-tabs">
                        <li class="active"><a data-target="#detailsEdit" data-toggle="tab">Details</a></li>
                        <li><a data-target="#conditionEdit" data-toggle="tab">Condition</a></li>
                        <li><a data-target="#conditionAndOrEdit" data-toggle="tab">AND/OR Condition</a></li>
                        <li><a data-target="#resultEdit" data-toggle="tab">Result</a></li>
                    </ul>
                </div></br></br></br>

                <form class="form-horizontal">
                    <div class="tab-content">
                        <div class="tab-pane active" id="detailsEdit">
                            <input id="editRuleIdHidden" ng-model="oldRule.ruleId" type="hidden"/>
                            <div class="form-group">
                                <label class="col-xs-2 control-label">Name</label>
                                <div class="col-xs-4">
                                    <input type="text" class="form-control" id="editRuleName" ng-model="oldRule.ruleName" placeholder="Name">
                                    <span class="help-block"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-xs-2 control-label">Description</label>
                                <div class="col-xs-4">
                                    <textarea class="form-control" id="editRuleDesc" ng-model="oldRule.ruleDesc" placeholder="Description"></textarea>
                                    <span class="help-block"></span>
                                </div>
                            </div>
                        </div>
                        <div class="tab-pane fade" id="conditionEdit">
                            <div class="form-group">
                                <input id="editRuleConIdHidden" ng-model="oldRule.ruleConId" type="hidden"/>
                                <div class="form-group">
                                    <label class="col-xs-2 control-label" >Is Not</label>
                                    <div class="col-xs-4">
                                        <select class="form-control" id="editRuleConIsNot" ng-model="oldRuleCon.isNot">
                                            <option value="true">TRUE</option>
                                            <option value="false">FALSE</option>
                                        </select>
                                        <span class="help-block"></span>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-xs-2 control-label">Operation</label>
                                    <div class="col-xs-4">
                                        <select class="form-control" id="editRuleCon1Operation" onchange="evaluateEditOperation('NEW')" ng-model="oldRuleCon.operation">
                                            <option value="SUM">SUM</option>
                                            <option value="AVG">AVG</option>
                                            <option value="MIN">MIN</option>
                                            <option value="MAX">MAX</option>
                                            <option id="editRule1Count" value="COUNT">COUNT</option>
                                        </select>
                                        <span class="help-block"></span>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <input id="editRuleConNeighIdHidden" ng-model="oldRule.ruleConNeighId" type="hidden"/>
                                    <label class="col-xs-2 control-label">Neighbours</label>
                                    <div class="col-xs-4">
                                        <label class="col-xs-2">TOP&emsp;</label><label class="col-xs-2">MID&emsp;</label><label class="col-xs-2">BOT</label><br><br>
                                        &emsp;<input type="checkbox" id="editCon1Neigh25"><input type="checkbox" id="editCon1Neigh26"><input type="checkbox" id="editCon1Neigh27">&emsp;<input type="checkbox" id="editCon1Neigh16"><input type="checkbox" id="editCon1Neigh17"><input type="checkbox" id="editCon1Neigh18">&emsp;<input type="checkbox" id="editCon1Neigh7"><input type="checkbox" id="editCon1Neigh8"><input type="checkbox" id="editCon1Neigh9"><br>
                                        &emsp;<input type="checkbox" id="editCon1Neigh22"><input type="checkbox" id="editCon1Neigh23"><input type="checkbox" id="editCon1Neigh24">&emsp;<input type="checkbox" id="editCon1Neigh13"><input type="checkbox" id="editCon1Neigh14"><input type="checkbox" id="editCon1Neigh15">&emsp;<input type="checkbox" id="editCon1Neigh4"><input type="checkbox" id="editCon1Neigh5"><input type="checkbox" id="editCon1Neigh6"><br>
                                        &emsp;<input type="checkbox" id="editCon1Neigh19"><input type="checkbox" id="editCon1Neigh20"><input type="checkbox" id="editCon1Neigh21">&emsp;<input type="checkbox" id="editCon1Neigh10"><input type="checkbox" id="editCon1Neigh11"><input type="checkbox" id="editCon1Neigh12">&emsp;<input type="checkbox" id="editCon1Neigh1"><input type="checkbox" id="editCon1Neigh2"><input type="checkbox" id="editCon1Neigh3"><br>
                                        <span class="help-block"></span>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-xs-2 control-label">Operand</label>
                                    <div class="col-xs-4">
                                        <select class="form-control" id="editRuleCon1Operand" onchange="evaluateEditOperand('NEW')" ng-model="oldRuleCon.operand">
                                            <option value="<"> < </option>
                                            <option value=">"> > </option>
                                            <option value=">="> >= </option>
                                            <option value="<="> <= </option>
                                            <option value="=="> == </option>
                                            <option id="editRule1BE" value="BE"> BETWEEN (excludes) </option>
                                            <option id="editRule1BI" value="BI"> BETWEEN (includes) </option>
                                        </select>
                                        <span class="help-block"></span>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-xs-2 control-label">Compare Value One</label>
                                    <div class="col-xs-4">
                                        <input type="number" step="0.1" class="form-control" id="editRuleCon1CompareValueOne" onchange="evaluateEditCompareValue('NEW')" ng-model="oldRuleCon.compareValueOne" placeholder="Choose State Value">
                                        <span class="help-block"></span>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-xs-2 control-label">Compare Value Two</label>
                                    <div class="col-xs-4">
                                        <input type="number" step="0.1" class="form-control" id="editRuleCon1CompareValueTwo" onchange="evaluateEditCompareValue('NEW')" ng-model="oldRuleCon.compareValueTwo" placeholder="Used with COUNT or BETWEEN" disabled>
                                        <span class="help-block"></span>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="tab-pane fade" id="conditionAndOrEdit">
                            <div class="form-group">
                                <input id="editRuleCon2IdHidden" ng-model="oldRuleConAndOr.ruleConAndOrId" type="hidden"/>
                                <div class="form-group">
                                    <label class="col-xs-2 control-label" >AND/OR</label>
                                    <div class="col-xs-4">
                                        <select class="form-control" id="editRuleCon2AndOr" ng-model="oldRuleConAndOr.AndOr">
                                            <option value=""></option>
                                            <option value="AND">AND</option>
                                            <option value="OR">OR</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-xs-2 control-label" >Is Not</label>
                                    <div class="col-xs-4">
                                        <select class="form-control" id="editRuleCon2isNot" ng-model="oldRuleConAndOr.isNot">
                                            <option value="true">TRUE</option>
                                            <option value="false">FALSE</option>
                                        </select>
                                        <span class="help-block"></span>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-xs-2 control-label">Operation</label>
                                    <div class="col-xs-4">
                                        <select class="form-control" id="editRuleCon2Operation" onchange="evaluateEditOperation('NEW')" ng-model="oldRuleConAndOr.operation">
                                            <option value="SUM">SUM</option>
                                            <option value="AVG">AVG</option>
                                            <option value="MIN">MIN</option>
                                            <option value="MAX">MAX</option>
                                            <option id="editRule2Count" value="COUNT">COUNT</option>
                                        </select>
                                        <span class="help-block"></span>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <input id="editRuleCon2NeighIdHidden" ng-model="oldRuleConAndOr.neigh" type="hidden"/>
                                    <label class="col-xs-2 control-label">Neighbours</label>
                                    <div class="col-xs-4">
                                        <label class="col-xs-2">TOP&emsp;</label><label class="col-xs-2">MID&emsp;</label><label class="col-xs-2">BOT</label><br><br>
                                        &emsp;<input type="checkbox" id="editCon2Neigh25"><input type="checkbox" id="editCon2Neigh26"><input type="checkbox" id="editCon2Neigh27">&emsp;<input type="checkbox" id="editCon2Neigh16"><input type="checkbox" id="editCon2Neigh17"><input type="checkbox" id="editCon2Neigh18">&emsp;<input type="checkbox" id="editCon2Neigh7"><input type="checkbox" id="editCon2Neigh8"><input type="checkbox" id="editCon2Neigh9"><br>
                                        &emsp;<input type="checkbox" id="editCon2Neigh22"><input type="checkbox" id="editCon2Neigh23"><input type="checkbox" id="editCon2Neigh24">&emsp;<input type="checkbox" id="editCon2Neigh13"><input type="checkbox" id="editCon2Neigh14"><input type="checkbox" id="editCon2Neigh15">&emsp;<input type="checkbox" id="editCon2Neigh4"><input type="checkbox" id="editCon2Neigh5"><input type="checkbox" id="editCon2Neigh6"><br>
                                        &emsp;<input type="checkbox" id="editCon2Neigh19"><input type="checkbox" id="editCon2Neigh20"><input type="checkbox" id="editCon2Neigh21">&emsp;<input type="checkbox" id="editCon2Neigh10"><input type="checkbox" id="editCon2Neigh11"><input type="checkbox" id="editCon2Neigh12">&emsp;<input type="checkbox" id="editCon2Neigh1"><input type="checkbox" id="editCon2Neigh2"><input type="checkbox" id="editCon2Neigh3"><br>
                                        <span class="help-block"></span>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-xs-2 control-label">Operand</label>
                                    <div class="col-xs-4">
                                        <select class="form-control" id="editRuleCon2Operand" onchange="evaluateEditOperand('NEW')" ng-model="oldRuleConAndOr.operand">
                                            <option value="<"> < </option>
                                            <option value=">"> > </option>
                                            <option value=">="> >= </option>
                                            <option value="<="> <= </option>
                                            <option value="=="> == </option>
                                            <option id="editRule2BE" value="BE"> BETWEEN (excludes) </option>
                                            <option id="editRule2BI" value="BI"> BETWEEN (includes) </option>
                                        </select>
                                        <span class="help-block"></span>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-xs-2 control-label">Compare Value One</label>
                                    <div class="col-xs-4">
                                        <input type="number" step="0.1" class="form-control" id="editRuleCon2CompareValueOne" onchange="evaluateEditCompareValue('NEW')" ng-model="oldRuleConAndOr.compareValueOne" placeholder="Choose State Value">
                                        <span class="help-block"></span>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-xs-2 control-label">Compare Value Two</label>
                                    <div class="col-xs-4">
                                        <input type="number" step="0.1" class="form-control" id="editRuleCon2CompareValueTwo" onchange="evaluateEditCompareValue('NEW')" ng-model="oldRuleConAndOr.compareValueTwo" placeholder="Used with COUNT or BETWEEN" disabled>
                                        <span class="help-block"></span>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="tab-pane fade" id="resultEdit">
                            <div class="form-group">
                                <div class="form-group">
                                    <input id="editRuleResIdHidden" ng-model="oldRule.ruleResId" type="hidden"/>
                                    <label class="col-xs-2 control-label">Operator</label>
                                    <div class="col-xs-4">
                                        <select class="form-control" id="editRuleResOperation" onchange="evaluateEditResult('NEW')" ng-model="oldRuleRes.operation">
                                            <option value="SUM">SUM</option>
                                            <option value="AVG">AVG</option>
                                            <option value="MIN">MIN</option>
                                            <option value="MAX">MAX</option>
                                        </select>
                                        <span class="help-block"></span>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <input id="editRuleResNeighIdHidden" ng-model="oldRule.ruleConNeighId" type="hidden"/>
                                        <label class="col-xs-2 control-label">Neighbours</label>
                                        <div class="col-xs-4">
                                            <label class="col-xs-2">TOP&emsp;</label><label class="col-xs-2">MID&emsp;</label><label class="col-xs-2">BOT</label><br><br>
                                            &emsp;<input type="checkbox" id="editResNeigh25" onchange="evaluateEditResult()"><input type="checkbox" id="editResNeigh26" onchange="evaluateEditResult()"><input type="checkbox" id="editResNeigh27" onchange="evaluateEditResult()">&emsp;
                                            <input type="checkbox" id="editResNeigh16" onchange="evaluateEditResult()"><input type="checkbox" id="editResNeigh17" onchange="evaluateEditResult()"><input type="checkbox" id="editResNeigh18" onchange="evaluateEditResult()">&emsp;
                                            <input type="checkbox" id="editResNeigh7" onchange="evaluateEditResult()"><input type="checkbox" id="editResNeigh8" onchange="evaluateEditResult()"><input type="checkbox" id="editResNeigh9" onchange="evaluateEditResult()"><br>
                                            &emsp;<input type="checkbox" id="editResNeigh22" onchange="evaluateEditResult()"><input type="checkbox" id="editResNeigh23" onchange="evaluateEditResult()"><input type="checkbox" id="editResNeigh24" onchange="evaluateEditResult()">&emsp;
                                            <input type="checkbox" id="editResNeigh13" onchange="evaluateEditResult()"><input type="checkbox" id="editResNeigh14" onchange="evaluateEditResult()"><input type="checkbox" id="editResNeigh15" onchange="evaluateEditResult()">&emsp;
                                            <input type="checkbox" id="editResNeigh4" onchange="evaluateEditResult()"><input type="checkbox" id="editResNeigh5" onchange="evaluateEditResult()"><input type="checkbox" id="editResNeigh6" onchange="evaluateEditResult()"><br>
                                            &emsp;<input type="checkbox" id="editResNeigh19" onchange="evaluateEditResult()"><input type="checkbox" id="editResNeigh20" onchange="evaluateEditResult()"><input type="checkbox" id="editResNeigh21" onchange="evaluateEditResult()">&emsp;
                                            <input type="checkbox" id="editResNeigh10" onchange="evaluateEditResult()"><input type="checkbox" id="editResNeigh11" onchange="evaluateEditResult()"><input type="checkbox" id="editResNeigh12" onchange="evaluateEditResult()">&emsp;
                                            <input type="checkbox" id="editResNeigh1" onchange="evaluateEditResult()"><input type="checkbox" id="editResNeigh2" onchange="evaluateEditResult()"><input type="checkbox" id="editResNeigh3" onchange="evaluateEditResult()"><br>
                                            <span class="help-block"></span>
                                        </div>
                                </div>
                                <label align="center">OR</label>
                                <div class="form-group">
                                    <label class="col-xs-2 control-label">Result Value</label>
                                    <div class="col-xs-4">
                                        <input type="number" step="0.1" class="form-control" id="editRuleResValue" onchange="evaluateEditResult('NEW')" ng-model="oldRuleRes.resultValue" placeholder="Choose State Value">
                                        <span class="help-block"></span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-xs-offset-2 col-xs-4">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                            <button type="submit" class="btn btn-success" data-dismiss="modal" ng-click="editRule(oldRule, oldRuleCon, oldRuleRes, oldRuleConNeigh, oldRuleResNeigh)">Edit</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>


<div class="modal fade" id="deleteWorldModal"  tabindex="-1" role="dialog" aria-labelledby="purchaseLabel" aria-hidden="true" ng-controller="WorldManager">
    <div class="modal-dialog">
        <div class="modal-content">
            <div id="DeleteNameWorld" class="modal-header">

            </div>
            <div class="modal-body">
                <input id ="worldIdhidden" type="hidden" class="form-control"  ng-model="DeleteWorld.worldId"/>
                <p>Are you sure you want to delete this World?</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                <button type="submit" class="btn btn-danger" data-dismiss="modal" ng-click="deleteWorldFinalize()">Delete</button>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="deleteStateModal"  tabindex="-1" role="dialog" aria-labelledby="purchaseLabel" aria-hidden="true" ng-controller="StateManager">
    <div class="modal-dialog">
        <div class="modal-content">
            <div id="DeleteNameState" class="modal-header">

            </div>
            <div class="modal-body">
                <input id ="deleteStateIdHidden" type="hidden" class="form-control"  ng-model="DeleteState.stateId"/>
                <p>Are you sure you want to delete this State?</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                <button type="submit" class="btn btn-danger" data-dismiss="modal" ng-click="deleteStateFinalize()">Delete</button>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="deleteRuleModal"  tabindex="-1" role="dialog" aria-labelledby="purchaseLabel" aria-hidden="true" ng-controller="RuleManager">
    <div class="modal-dialog">
        <div class="modal-content">
            <div id="DeleteNameRule" class="modal-header">
            </div>
            <div class="modal-body">
                <input id ="ruleIdhidden" type="hidden" class="form-control"  ng-model="DeleteRule.ruleId"/>
                <p>Are you sure you want to delete this Rule?</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                <button type="submit" class="btn btn-danger" data-dismiss="modal" ng-click="deleteRuleFinalize()">Delete</button>
            </div>
        </div>
    </div>
</div>

<div id="alertMessage" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-header">
        <h3 id="myModalLabel">Error</h3>
    </div>
    <div class="modal-body">
        <p>...</p>
    </div>
    <div class="modal-footer">
        <button class="btn btn-danger" data-dismiss="modal" aria-hidden="true">Ok</button>
    </div>
</div>
