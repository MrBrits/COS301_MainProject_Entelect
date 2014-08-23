
<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
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
                <li>Home</li>
                <li>About</li>
                <li>Contact</li>
            </ul>
        </div>
    </div>
</div>
<div class="navbar navbar-inverse navbar-fixed-bottom" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div><div class="dropdown">
        <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
            Show/Hide Bars
            <span class="caret"></span>
        </button>
        <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
            <li role="presentation"> <input id="y" onclick="hider()" checked="true" type="checkbox">x-axis</input></li>
            <li role="presentation" class="divider"></li>
            <li role="presentation"> <input id="x" onclick="hider()" checked="true" type="checkbox">y-axis</input></li>
            <li role="presentation" class="divider"></li>
            <li role="presentation"> <input id="z" onclick="hider()" checked="true"type="checkbox">z-axis</input></li>
            <li role="presentation" class="divider"></li>
            <li role="presentation">  <input id="mid" onclick="hider()" checked="true" type="checkbox">overall</input></li>



        </ul>
    </div>

    </div>
</div>
<div id = "canvas" ng-controller="worldManager" class = "cover"></div>
<link href="resources/css/stylesheet.css" rel="stylesheet" type="text/css">
<link href="resources/css/flash.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="resources/js/dat.gui.js"></script>
<script type="text/javascript" src="resources/js/lib/pace.min.js"></script>
<script type="text/javascript" src="resources/js/OrbitControls.js"></script>
<script type="text/javascript" src="resources/js/cellclass.js"></script>
<script type="text/javascript" src="resources/js/worldclass.js"></script>
<script type="text/javascript" src="resources/js/visualizer.js"></script>

