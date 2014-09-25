<div  ng-controller="CoordinateManager as web_ca">
<!--Top navigation bar-->
<div class="navbar navbar-inverse navbar-fixed-top"  style="margin-top: 43px" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>

        </div>
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav pull-left row">
                <li><button type="button" ng-click="SaveCoordinates()" class="btn btn-default ">Save World</button></li>

            </ul>
        </div>
    </div>
</div>
<!--Top navigation bar-->

<!--Bottom navigation bar-->
<div class="navbar navbar-inverse navbar-fixed-bottom" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>
        <div class="dropdown">
            <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">Show/Hide Bars<span class="caret"></span></button>
            <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
                <li role="presentation"> <input id="y" onclick="hider()" checked="true" type="checkbox">x-axis/></li>
                <li role="presentation" class="divider"></li>
                <li role="presentation"> <input id="x" onclick="hider()" checked="true" type="checkbox">y-axis/></li>
                <li role="presentation" class="divider"></li>
                <li role="presentation"> <input id="z" onclick="hider()" checked="true"type="checkbox">z-axis /></li>
                <li role="presentation" class="divider"></li>
                <li role="presentation">  <input id="mid" onclick="hider()" checked="true" type="checkbox">overall/></li>
            </ul>
            <button  class="btn btn-default" onclick="methods.Change_Layer()">Toggle Layer</button>

            <div class="pull-right ">
                <label class="range inline">Brush Size<input id="Brush_Size" type="range" min=0 max=6 step=1 value=0 /></label>
                <label class="range inline">Cube Scale<input  id="Cube_Scale" type="range" min=0 max=1 step=0.1 value=1 /></label>
                <button onclick="methods.Delete_State()" class="btn btn-default"><img src= "resources/img/glyphicons_016_bin.png"style="width:15px;height:15px"/> </button>
                <button onclick="methods.Start_Stop()" class="btn btn-default"><img id="play_stop" src= "resources/img/play.png"style="width:15px;height:15px"/> </button>
                <label class="range inline">Play Speed<input id="speed" type="range"  class ="help-inline" value=1 min=1 max=10 step=1 /></label>
                <button onclick="methods.Rotate()" class="btn btn-default"><img src= "resources/img/rotate.png"style="width:15px;height:15px"/> </button>
                <label class="range inline">Rotation Speed<input  id="Rotation_Speed" type="range" value=1 min=1 max=4 step="0.5"/></label>
                <button onclick="addCoordinates()" class="btn btn-default"><img src= "resources/img/startpos.png"style="width:15px;height:15px"/> </button>
            </div>
        </div>
    </div>
</div>
<!--Bottom navigation bar-->
<div id = "canvas" style="position:fixed;left:0px;" class = "cover"></div>
    <link rel="stylesheet" href="resources/css/bootstrap.vertical-tabs.css">


    <div  class="col-sm-6 pull-left" style="position:fixed;left:30px;width:150px" >
            <!-- Nav tabs -->
            <ul class="nav nav-stacked tabs-left vertical-text " style="color: #000000" role="tablist">

                <ul class="nav nav-stacked tabs-left vertical-text " role="tablist">
                    <li ><a data-target="#simulatorWorld" data-toggle="tab">World</a></li>
                    <li><a data-target="#simulatorState" data-toggle="tab">States</a></li>
                    <li><a data-target="#simulatorRule" data-toggle="tab">Rule</a></li>
                </ul>
            </ul>
    </div>
    <div class="col-xs-9" style="position:absolute;left:20px; top:150px;width:250px">
            <!-- Tab panes -->
            <div class="tab-content">
                <div class="tab-pane fade "style="overflow-y:auto;height: 350px"  id="simulatorRule" ng-controller="RuleSimulator">

                    <table class="table">
                        <tr ng-repeat="rule in rules | filter:search">
                            <td>
                                <button type="button" class="btn btn-default btn-lg" ></button>
                                <label>{{rule.ruleName}}</label><br>
                                <p>{{rule.ruleDesc}}</p>
                            </td>
                        </tr>
                    </table>
                </div>

                <div class="tab-pane fade "style="overflow-y:auto;height: 350px"  id="simulatorWorld" ng-controller="WorldSimulator">

                    <table class="table">
                        <tr ng-repeat="world in worlds | filter:search">
                            <td>
                                <button type="button" ng-style="{'background-color':state.stateHex}" class="btn btn-default btn-lg"  ></button>
                                <a href="#simulator/"  id={{world.worldId}} onclick="setWorldID(id)" > {{world.worldName}}</a><br>
                                <p>{{world.worldDesc}}</p>
                            </td>
                        </tr>
                    </table>
                </div>


                <div class="tab-pane fade " style="overflow-y:auto;height: 350px"  id="simulatorState" ng-controller="StateSimulator">

                    <table class="table" >
                        <tr ng-repeat="state in states | filter:search">
                            <td>
                                <button onclick="setColor(id)" id={{state.stateValue}} type="button" ng-style="{'background-color':state.stateHex}" class="btn btn-default btn-lg"  ></button>
                                <label>{{state.stateName}}</label><br>
                                <p>{{state.stateDesc}}</p>
                            </td>
                        </tr>
                    </table>
                </div>
            </div>
     </div>


    <div  class="col-sm-6 pull-right" style="position:fixed;left:100%;width:150px;">
            <!-- Nav tabs -->
            <ul class="nav nav-stacked tabs-left black vertical-text " role="tablist">

                <ul class="nav nav-stacked tabs-left vertical-text " role="tablist">
                    <li><a data-target="#worldState" onclick="worldStates()" data-toggle="tab">World States</a></li>
                    <li><a href data-target="#worldRule" data-toggle="tab">World Rules</a></li>
                </ul>
            </ul>
    </div>
    <div class="col-xs-9" style="position:fixed;left:78%; top:150px; width:250px;">
            <!-- Tab panes -->
            <div class="tab-content">
                <div class="tab-pane fade " style="height: 400px;overflow-y:auto;" id ="worldRule">

                </div>
                <div class="tab-pane fade " style="height: 400px;overflow-y:auto;"  id="worldState">
                </div>
            </div>
     </div>



</div>
<link href="resources/css/stylesheet.css" rel="stylesheet" type="text/css">
<link href="resources/css/flash.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="resources/js/dat.gui.js"></script>
<script type="text/javascript" src="resources/js/OrbitControls.js"></script>
<script type="text/javascript" src="resources/js/lib/pace.min.js"></script>
<script type="text/javascript" src="resources/js/cellclass.js"></script>
<script type="text/javascript" src="resources/js/ruleclass.js"></script>
<script type="text/javascript" src="resources/js/visualizer.js"></script>

