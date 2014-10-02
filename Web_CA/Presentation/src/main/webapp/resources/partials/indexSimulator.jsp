<div  ng-controller="CoordinateManager as web_ca">

<!--Top navigation bar-->

<!--Bottom navigation bar-->
<div class="navbar navbar-inverse navbar-fixed-bottom" role="navigation" style="min-height:15px">

</div>
<!--Bottom navigation bar-->
<div id = "canvas" style="position:fixed;left:0px;" class = "cover"></div>
    <div  class="pull-left pull-top" style="position:fixed;left:0;top:55px;width:150px" >
        <div class="btn-group-vertical">
            <button type="button" id = "world-tab-button" class="btn btn-default" data-toggle="tooltip" data-placement="right" title="World">
                <span class="glyphicon glyphicon-globe"></span>
            </button>
            <button type="button" id = "edit-tab-button" onclick="worldStates()" class="btn btn-default" data-toggle="tooltip" data-placement="right" title="Edit">
                <span class="glyphicon glyphicon-pencil"></span>
            </button>
            <button type="button" id = "simulate-tab-button"class="btn btn-default" data-toggle="tooltip" data-placement="right" title="Simulate">
                <span class="glyphicon glyphicon-play"></span>
            </button>
            <button type="button" id = "states-tab-button" class="btn btn-default" data-toggle="tooltip" data-placement="right" title="States">
                <span class="glyphicon glyphicon-record"></span>
            </button>
            <button type="button" id = "rules-tab-button" onclick="worldRules()" class="btn btn-default" data-toggle="tooltip" data-placement="right" title="Rules">
                <span class="glyphicon glyphicon-registration-mark"></span>
            </button>
            <button type="button" id = "settings-tab-button" class="btn btn-default" data-toggle="tooltip" data-placement="right" title="Settings">
                <span class="glyphicon glyphicon-cog" ></span>
            </button>
        </div>
    </div>

    <div class="submenu">
        <button style="margin-left:5px; margin-top:5px;" type="button" id="slide-submenu" class="btn btn-default pull-left" data-toggle="tooltip" data-placement="right" title="Close">
            <span id = "menu-button" class="glyphicon glyphicon-arrow-left" ></span>
        </button>

        <div id = "world-menu-tab" style="padding-left:50px;">
            <br/>
            <h3 style = "padding-left:0;text-align: center;">World</h3>

            <button style="margin-left:5px; margin-top:5px;" type="button" class="btn btn-default" ng-click="SaveCoordinates()">
                <span class="glyphicon glyphicon-floppy-disk" ></span>
            </button>
            <button style="margin-left:5px; margin-top:5px;" type="button" class="btn btn-default" onclick="addCoordinates()">
                <span class="glyphicon glyphicon-arrow-left" ></span>
            </button>
            <br/>
            <div id="simulatorWorld" style="overflow-y:auto;height: 350px;width:90%;"ng-controller="WorldSimulator">
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
        </div>
        <div id = "edit-menu-tab">
            <br/>
            <h3 style = "padding-left:0;text-align: center;">Edit</h3>
            <button style="margin-left:5px; margin-top:5px;" onclick="methods.Delete_State()" type="button" class="btn btn-default">
                <span class="glyphicon glyphicon-remove-circle" ></span>
            </button>
            <label class="range inline">Brush Size<input id="Brush_Size" type="range" min=0 max=6 step=1 value=0 /></label>
            <div id="worldState"></div>

        </div>
        <div id = "simulate-menu-tab">
            <br/>
            <h3 style = "padding-left:0;text-align: center;">Simulate</h3>

            <button onclick="methods.Start_Stop()" class="btn btn-default"><img id="play_stop" src= "resources/img/play.png"style="width:15px;height:15px"/> </button>
            <label class="range inline">Play Speed<input id="speed" type="range"  class ="help-inline" value=1 min=1 max=10 step=1 /></label>
        </div>
        <div id = "states-menu-tab">
            <br/>
            <h3 style = "padding-left:0;text-align: center;">States</h3>
        </div>
        <div id = "rules-menu-tab">
            <br/>
            <h3 style = "padding-left:0;text-align: center;">Rules</h3>
            <div id="worldRule"></div>
        </div>
        <div id = "settings-menu-tab">
            <br/>
            <h3 style = "padding-left:0;text-align: center;">Settings</h3>
        </div>
    </div>


</div>
<link href="resources/css/interface.css" rel="stylesheet" type="text/css">
<link href="resources/css/stylesheet.css" rel="stylesheet" type="text/css">
<link href="resources/css/flash.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="resources/js/dat.gui.js"></script>
<script type="text/javascript" src="resources/js/OrbitControls.js"></script>
<script type="text/javascript" src="resources/js/lib/pace.min.js"></script>
<script type="text/javascript" src="resources/js/cellclass.js"></script>
<script type="text/javascript" src="resources/js/ruleclass.js"></script>
<script type="text/javascript" src="resources/js/visualizer.js"></script>
<script>

    $( document ).ready(function() {
        $('#edit-menu-tab').show();
        $('.submenu').on("mouseenter", function(event){
            canvasFocus = false;
            controls.enabled = false;
        });

        $('.submenu').on("mouseleave", function(event){
            canvasFocus = true;
            controls.enabled = true;
        });
    });

    $("#world-tab-button").on("click", function(){
        $('#edit-menu-tab').hide();
        $('#world-menu-tab').show();
        $('#simulate-menu-tab').hide();
        $('#states-menu-tab').hide();
        $('#rules-menu-tab').hide();
        $('#settings-menu-tab').hide();
    });

    $("#edit-tab-button").on("click", function(){
        $('#edit-menu-tab').show();
        $('#world-menu-tab').hide();
        $('#simulate-menu-tab').hide();
        $('#states-menu-tab').hide();
        $('#rules-menu-tab').hide();
        $('#settings-menu-tab').hide();
    });

    $("#simulate-tab-button").on("click", function(){
        $('#edit-menu-tab').hide();
        $('#world-menu-tab').hide();
        $('#simulate-menu-tab').show();
        $('#states-menu-tab').hide();
        $('#rules-menu-tab').hide();
        $('#settings-menu-tab').hide();
    });

    $("#states-tab-button").on("click", function(){
        $('#edit-menu-tab').hide();
        $('#world-menu-tab').hide();
        $('#simulate-menu-tab').hide();
        $('#states-menu-tab').show();
        $('#rules-menu-tab').hide();
        $('#settings-menu-tab').hide();
    });

    $("#rules-tab-button").on("click", function(){
        $('#edit-menu-tab').hide();
        $('#world-menu-tab').hide();
        $('#simulate-menu-tab').hide();
        $('#states-menu-tab').hide();
        $('#rules-menu-tab').show();
        $('#settings-menu-tab').hide();
    });

    $("#settings-tab-button").on("click", function(){
        $('#edit-menu-tab').hide();
        $('#world-menu-tab').hide();
        $('#simulate-menu-tab').hide();
        $('#states-menu-tab').hide();
        $('#rules-menu-tab').hide();
        $('#settings-menu-tab').show();
    });

    $('#edit-menu-tab').hide();
    $('#world-menu-tab').hide();
    $('#simulate-menu-tab').hide();
    $('#states-menu-tab').hide();
    $('#rules-menu-tab').hide();
    $('#settings-menu-tab').hide();

    $('.btn-group-vertical .btn').tooltip({container: 'body'});
    $('.submenu .btn').tooltip();

    var enabled = false;
    $("#slide-submenu").click(function(e) {
        e.preventDefault();
        if(enabled) {
            $( ".submenu" ).animate({
                right: "-=240"
            }, 600, function() {
            });
            $("#menu-button").removeClass("glyphicon glyphicon-arrow-right");
            $("#menu-button").addClass("glyphicon glyphicon-arrow-left");
            enabled = !enabled;
        }
        else    {
            $( ".submenu" ).animate({
                right: "+=240"
            }, 600, function() {
            });
            $("#menu-button").removeClass("glyphicon glyphicon-arrow-left");
            $("#menu-button").addClass("glyphicon glyphicon-arrow-right");

            enabled = !enabled;
        }
    });
</script>

