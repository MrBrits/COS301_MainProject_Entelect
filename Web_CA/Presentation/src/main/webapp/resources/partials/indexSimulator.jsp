<div  ng-controller="CoordinateManager as web_ca">

<!--Top navigation bar-->

<!--Bottom navigation bar-->
<div class="navbar navbar-inverse navbar-fixed-bottom" role="navigation" style="min-height:15px">

</div>
<!--Bottom navigation bar-->
<div id = "canvas" style="position:fixed;left:0px;" class = "cover"></div>
    <div  class="pull-left pull-top" style="position:fixed;left:0;top:55px;width:150px" >
        <div class="btn-group-vertical">
            <button type="button" class="btn btn-default" data-toggle="tooltip" data-placement="right" title="World">
                <span class="glyphicon glyphicon-globe"></span>
            </button>
            <button type="button" class="btn btn-default" data-toggle="tooltip" data-placement="right" title="Edit">
                <span class="glyphicon glyphicon-pencil"></span>
            </button>
            <button type="button" class="btn btn-default" data-toggle="tooltip" data-placement="right" title="Simulate">
                <span class="glyphicon glyphicon-play"></span>
            </button>
            <button type="button" class="btn btn-default" data-toggle="tooltip" data-placement="right" title="States">
                <span class="glyphicon glyphicon-record"></span>
            </button>
            <button type="button" class="btn btn-default" data-toggle="tooltip" data-placement="right" title="Rules">
                <span class="glyphicon glyphicon-registration-mark"></span>
            </button>
            <button type="button" class="btn btn-default" data-toggle="tooltip" data-placement="right" title="Settings">
                <span class="glyphicon glyphicon-cog" ></span>
            </button>
        </div>
    </div>

    <div class="submenu">
        <button style="margin-left:5px; margin-top:5px;" type="button" id="slide-submenu" class="btn btn-default pull-left" data-toggle="tooltip" data-placement="bottom" title="Close">
            <span id = "menu-button" class="glyphicon glyphicon-remove" ></span>
        </button>
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
    $('.btn-group-vertical .btn').tooltip({container: 'body'});
    $('#slide-submenu').tooltip();
    var enabled = true;
    $("#slide-submenu").click(function(e) {
        e.preventDefault();
        if(enabled) {
            $( ".submenu" ).animate({
                right: "-=240"
            }, 600, function() {
            });
            $("#menu-button").removeClass("glyphicon glyphicon-remove");
            $("#menu-button").addClass("glyphicon glyphicon-th-list");
            enabled = !enabled;
        }
        else    {
            $( ".submenu" ).animate({
                right: "+=240"
            }, 600, function() {
            });
            $("#menu-button").removeClass("glyphicon glyphicon-th-list");
            $("#menu-button").addClass("glyphicon glyphicon-remove");

            enabled = !enabled;
        }
    });
</script>

