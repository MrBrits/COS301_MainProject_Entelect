//Variables
this.scene = new THREE.Scene();
this.camera = new THREE.PerspectiveCamera(30, $(window).width() / $(window).height(), 1, 1000);
this.renderer = new THREE.WebGLRenderer();
this.controls;
this.worlds;
realSpeed = 0;

$("#Cube_Scale").on("input", function(){
    for(var z = 0; z < tmz; z++)    {
        for(var y = 0; y < tmy; y++)    {
            for(var x = 0; x < tmx; x++)    {
                cellArray[z][y][x].cube.scale.z = this.value;
                cellArray[z][y][x].cube.scale.y = this.value;
                cellArray[z][y][x].cube.scale.x = this.value;
            }
        }
    }
});

$("#speed").on("change", function(){
    methods.Speed = this.value;
    var realSpeed = (10 - methods.Speed) * 100;
    if(methods.Speed != 0)	{
        if (worlds.play)	{
            clearInterval(methods.runSimulation);
            methods.runSimulation = setInterval(function(){worlds.StartAndStop()}, realSpeed);
            document.getElementById("play_stop").src="resources/img/pause.png";
        }
    }
    else	{
        worlds.play = false;
        document.getElementById("play_stop").src="resources/img/play.png";
        clearInterval(methods.runSimulation);
    }
});

$("#Rotation_Speed").on("change", function(){
    controls.autoRotateSpeed = this.value * 2;
});

//FUNCTIONS FOR THE CONTROLS
var methods= new function()	{
    var runSimulation = null;

    this.Rotate = function()	{
        controls.autoRotateSpeed = this.Rotation_Speed * 2;
        controls.autoRotater();
    }

    this.Start_Stop = function()	{
        clearInterval(this.runSimulation);
        if (worlds.play) {
            clearInterval(this.runSimulation);
            worlds.play = false;
            document.getElementById("play_stop").src = "resources/img/play.png";
        }
        else	{
            if(this.Speed != 0) {
                realSpeed = (10 - this.Speed) * 100;
                this.runSimulation = setInterval(function () {
                    worlds.StartAndStop()
                }, realSpeed);
                worlds.play = true;
                document.getElementById("play_stop").src = "resources/img/pause.png";
            }
            else    {
                clearInterval(this.runSimulation);
                worlds.play = false;
                document.getElementById("play_stop").src = "resources/img/play.png";
            }
        }
    }

    this.Change_Layer=function()	{
        worlds.changeWorldLayer();
    }

    this.Delete_State=function()    {
        document.getElementById("colorValue").value = 0;
    }

    this.Speed = 0;
    this.Rotation_Speed = 0;
}


var bool=true;
Pace.on("done", function(){

    if(bool==true) {

//Creation of a light source
        var light = new THREE.AmbientLight(0x505050);
        scene.add(light);


        /*LIGHT SOURCES*/

//POSITION.SET(x,y,z)
//Adding light source from a certain angle
        var directionalLight = new THREE.DirectionalLight(0xffffff, 0.7);
        directionalLight.position.set(0, 1, 1);
        scene.add(directionalLight);

//Adding light source from a certain angle
        directionalLight = new THREE.DirectionalLight(0xffffff, 0.7);
        directionalLight.position.set(1, 1, 0);
        scene.add(directionalLight);

//Adding light source from a certain angle
        directionalLight = new THREE.DirectionalLight(0xffffff, 0.7);
        directionalLight.position.set(0, -1, -1);
        scene.add(directionalLight);

//Adding light source from a certain angle
        directionalLight = new THREE.DirectionalLight(0xffffff, 0.7);
        directionalLight.position.set(-1, -1, 0);
        scene.add(directionalLight);

//Starting position of camera
        camera.position.z = 100;
        camera.position.y = 100;
        camera.position.x = 100;
        container = document.getElementById('canvas').appendChild(renderer.domElement);
        worlds = new world(scene, camera);
        worlds.makeGrid();
        controls = new THREE.OrbitControls(camera,Math.ceil(worlds.X/2),Math.ceil(worlds.Y/2),Math.ceil(worlds.Z/2));
        controls.addEventListener('change', render);

        for(var i = 0; i < 7; i++) {
            controls.pan(new THREE.Vector3( 1, 0, 0 ));
            controls.pan(new THREE.Vector3( 0, 1, 0 ));
        }

//Rendering of ALL cubes
        var render = function () {
            if(typeof array === 'object' && array.length > 0) {
                var k = 0;
                for(var i = 0; i < worlds.length; i++) {
                    for(var j = 0; j < worlds[i].length; j++) {
                        var scale = (array[k] + boost) / 30;
                        worlds[i][j].scale.z = (scale < 1 ? 1 : scale);
                        k += (k < array.length ? 1 : 0);
                    }
                }
            }

            requestAnimationFrame(render);
            controls.update();

            renderer.render(scene, camera);
        };

        render();
        renderer.setSize($(window).width(), $(window).height());

        function onWindowResize() {
            camera.aspect = window.innerWidth / window.innerHeight;
            camera.updateProjectionMatrix();
            renderer.setSize( window.innerWidth, window.innerHeight );
        }
        window.addEventListener( 'resize', onWindowResize, false );

        bool=false;
    }

});
