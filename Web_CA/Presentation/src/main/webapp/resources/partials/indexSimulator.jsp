
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
            <ul class="nav navbar-nav">
                <li><input id="colorValue" value="0"type="text"></li>
                <li>About</li>
                <li>Contact</li>
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
                <button onclick="methods.Start_Stop()" class="btn btn-default"><img id="play_stop" src= "resources/img/play.png"style="width:15px;height:15px"/> </button>
                <label class="range inline"><input id="speed" type="range"  class ="help-inline"value=1 min=1 max=10/></label>
                <button onclick="methods.Rotate()" class="btn btn-default"><img src= "resources/img/rotate.png"style="width:15px;height:15px"/> </button>
                <label class="range inline"><input  id="Rotation_Speed" type="range" value=1 min=1 max=5/></label>
                <button class="btn btn-default"><img src= "resources/img/startpos.png"style="width:15px;height:15px"/> </button>
            </div>
        </div>
    </div>
</div>
<!--Bottom navigation bar-->
<div id = "canvas" ng-controller="worldManager" class = "cover"></div>
<link href="resources/css/stylesheet.css" rel="stylesheet" type="text/css">
<link href="resources/css/flash.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="resources/js/dat.gui.js"></script>
<script type="text/javascript" src="resources/js/lib/pace.min.js"></script>
<script type="text/javascript" src="resources/js/OrbitControls.js"></script>
<script type="text/javascript" src="resources/js/cellclass.js"></script>
<script type="text/javascript" src="resources/js/worldclass.js"></script>
<script type="text/javascript" src="resources/js/visualizer.js"></script>

