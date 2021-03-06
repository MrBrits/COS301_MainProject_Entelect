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
            <button type="button" id = "rules-tab-button" class="btn btn-default" data-toggle="tooltip" data-placement="right" title="Rules">
                <span class="glyphicon glyphicon-registration-mark"></span>
            </button>
        </div>
    </div>

    <div class="submenu">
        <button style="margin-left:5px; margin-top:5px;" type="button" id="slide-submenu" class="btn btn-default pull-left" data-toggle="tooltip" data-placement="bottom" title="Close">
            <span id = "menu-button" class="glyphicon glyphicon-arrow-left" ></span>
        </button>

        <div id = "world-menu-tab" class = "submenu-display">
            <br/>
            <h3 style = "padding-left:0;text-align: center;">World</h3>

            <h4>Options</h4>

            <p>Save</p><button  type="button" class="btn btn-default " ng-click="SaveCoordinates()" data-toggle="tooltip" data-placement="left" title="Save">
            <span class="glyphicon glyphicon-floppy-disk" ></span>
        </button>

            <p>Restart</p><button type="button" class="btn btn-default" onclick="addCoordinates()" data-toggle="tooltip" data-placement="right" title="Restart">
            <span class="glyphicon glyphicon-arrow-left" ></span>
        </button>





            <h4>Select World</h4>

            <div id="simulatorWorld" style=" overflow-y:auto;height: 350px;width:90%;"ng-controller="WorldSimulator">

                <table class="table">
                    <tr ng-repeat="world in worlds | filter:search">
                        <td data-toggle="tooltip" data-placement="left" title="Load World">
                            <button type="button" ng-style="{'background-color':state.stateHex}" class="btn btn-default btn-lg" ></button>
                            <a href="#simulator/"  id={{world.worldId}} onclick="setWorldID(id)" > {{world.worldName}}</a><br>
                            <p>{{world.worldDesc}}</p>
                        </td>
                    </tr>
                </table>
            </div>
        </div>

        <div id = "edit-menu-tab" class = "submenu-display">
            <br/>
            <h3 style = "padding-left:0;text-align: center;">Edit</h3>


            <br/>
            <h4>Options</h4>

            <p>Draw</p><button  type="button" class="btn btn-default " data-toggle="tooltip" data-placement="left" title="Draw">
            <span class="glyphicon glyphicon-pencil" ></span>
        </button>
            <br>
            <p>Erase</p><button type="button" class="btn btn-default " onclick="methods.Delete_State()" data-toggle="tooltip" data-placement="right" title="Erase">
            <span class="glyphicon glyphicon-remove-circle" ></span>
        </button>

            <br/>
            <label style = "width: 90%; margin-left:auto; margin-right: auto;" class="range inline">Brush Size<input id="Brush_Size" type="range" min=0 max=6 step=1 value=0 /></label>
            <br/>

            <br/>

            <h4>Select State</h4>


            <div class="form-group" style = "width:90%;">
                <div class="input-group">
                    <input class="form-control" type="number" id = "colorValue" value = "0" placeholder="State Value">

                </div>
            </div>
            <div id="worldState" style=" overflow-y:auto;height: 350px;width:90%;"></div>
        </div>

        <div id = "simulate-menu-tab" class = "submenu-display">
            <br/>
            <h3 style = "padding-left:0;padding-right:0;text-align: center;">Simulation</h3>
            <br/>

            <br/>
            <p>Play</p><button onclick="methods.Start_Stop()" class="btn btn-default"><img id="play_stop" src= "resources/img/play.png"style="width:15px;height:15px"/> </button>
            <br/>

            <p>Rotate</p><button onclick="methods.Rotate()" class="btn btn-default"><span class="glyphicon glyphicon-repeat"></span></button>
            <br/>

            <h4>Options</h4>

            <label class="range inline">Play Speed<input id="speed" type="range"  class ="help-inline" value=1 min=1 max=10 step=1 /></label>
            <br/>

            <label class="range inline">Rotation Speed<input  id="Rotation_Speed" type="range" value=1 min=1 max=4 step="0.5"/></label>
            <br/>

            <label class="range inline">Cube Scale<input  id="Cube_Scale" type="range" min=0 max=1 step=0.1 value=1 /></label>
            <br/>

            <h4>Toggle Sidebars</h4>
            <ul style="list-style-type:none;">
                <li role="presentation"> <input id="x" onclick="hider()" checked="true" type="checkbox">x-axis</li>
                <li role="presentation"> <input id="y" onclick="hider()" checked="true" type="checkbox">y-axis</li>
                <li role="presentation"> <input id="z" onclick="hider()" checked="true"type="checkbox">z-axis</li>
                <li role="presentation">  <input id="mid" onclick="hider()" checked="true" type="checkbox">overall</li>
            </ul>




            <br/>

        </div>

        <div id = "rules-menu-tab" class = "submenu-display">
            <br/>
            <h3 style = "padding-left:0;text-align: center;">Rules</h3>
            <br/>


            <h4>Select Rules</h4>
            <div id="worldRule" style=" overflow-y:auto;height: 350px;width:90%;"></div>
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
        enabled = false;
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
        $('#rules-menu-tab').hide();

        if(!enabled) {
            $("#slide-submenu").click();
        }
    });

    $("#edit-tab-button").on("click", function(){
        $('#edit-menu-tab').show();
        $('#world-menu-tab').hide();
        $('#simulate-menu-tab').hide();
        $('#rules-menu-tab').hide();

        if(!enabled) {
            $("#slide-submenu").click();
        }
    });

    $("#simulate-tab-button").on("click", function(){
        $('#edit-menu-tab').hide();
        $('#world-menu-tab').hide();
        $('#simulate-menu-tab').show();
        $('#rules-menu-tab').hide();

        if(!enabled) {
            $("#slide-submenu").click();
        }
    });

    $("#rules-tab-button").on("click", function(){
        $('#edit-menu-tab').hide();
        $('#world-menu-tab').hide();
        $('#simulate-menu-tab').hide();
        $('#rules-menu-tab').show();

        if(!enabled) {
            $("#slide-submenu").click();
        }
    });



    $('#edit-menu-tab').hide();
    $('#world-menu-tab').show();
    $('#simulate-menu-tab').hide();
    $('#rules-menu-tab').hide();


    $('.btn').tooltip({container: 'body'});


    $("#slide-submenu").click(function(e) {
        e.preventDefault();
        if(enabled) {
            $( ".submenu" ).animate({
                right: "-=200"
            }, 600, function() {
            });
            $("#menu-button").removeClass("glyphicon glyphicon-arrow-right");
            $("#menu-button").addClass("glyphicon glyphicon-arrow-left");
            enabled = !enabled;
        }
        else    {
            $( ".submenu" ).animate({
                right: "+=200"
            }, 600, function() {
            });
            $("#menu-button").removeClass("glyphicon glyphicon-arrow-left");
            $("#menu-button").addClass("glyphicon glyphicon-arrow-right");

            enabled = !enabled;
        }
    });
</script>

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