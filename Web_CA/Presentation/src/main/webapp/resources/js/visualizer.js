//Variables
var scene = new THREE.Scene();
var camera = new THREE.PerspectiveCamera(30, $(window).width() / $(window).height(), 1, 1000);
var renderer = new THREE.WebGLRenderer();
var cubes = new Array();
var controls;

var realSpeed = 0;

var world = new world(10,10,10,scene);
world.makeGrid();

//FUNCTIONS FOR THE CONTROLS
var methods= new function()	{
    var runSimulation = null;

    this.Rotate = function()	{
        controls.autoRotater();
    }

    this.Start_Stop = function()	{
        realSpeed = (10 - this.Speed) * 100;
        clearInterval(runSimulation);
        if (world.play)	{
            clearInterval(runSimulation);
            world.play = false;
        }
        else	{
            runSimulation = setInterval(function(){world.StartAndStop()}, realSpeed);
            world.play = true;
        }
    }

    this.Change_Layer=function()	{
        world.changeWorldLayer();
    }

    this.Change_speed=function()	{
        if(this.Speed != 0)	{
            realSpeed = (10 - this.Speed) * 100;
            if (world.play)	{
                clearInterval(runSimulation);
                runSimulation = setInterval(function(){world.StartAndStop()}, realSpeed);
            }
        }
        else	{
            clearInterval(runSimulation);
        }
    }

    this.Change_rotation_speed=function() {
        controls.autoRotateSpeed = this.Rotation_Speed * 2;
    }

    this.Speed = 1;
    this.Rotation_Speed = 2;
}

//Creation of control menu
var gui = new dat.GUI();
gui.add(methods, 'Rotate');
gui.add(methods, 'Start_Stop');
gui.add(methods, 'Change_Layer');
gui.add(methods, 'Rotation_Speed',0,10).onFinishChange(function()	{
    methods.Change_rotation_speed();
});
gui.add(methods, 'Speed',0,10).onFinishChange(function()	{
    methods.Change_speed();
});

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
camera.position.z = 50;
camera.position.y = 50;
camera.position.x = 50;

controls = new THREE.OrbitControls(camera,Math.ceil(this.world.xSize/2),Math.ceil(this.world.ySize/2),Math.ceil(this.world.zSize/2));
controls.addEventListener('change', render);

for(var i = 0; i < 7; i++) {
    controls.pan(new THREE.Vector3( 1, 0, 0 ));
    controls.pan(new THREE.Vector3( 0, 1, 0 ));
}

//Rendering of ALL cubes
var render = function () {
    if(typeof array === 'object' && array.length > 0) {
        var k = 0;
        for(var i = 0; i < world.length; i++) {
            for(var j = 0; j < world[i].length; j++) {
                var scale = (array[k] + boost) / 30;
                world[i][j].scale.z = (scale < 1 ? 1 : scale);
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
    renderer.setSize( window.innerWidth, window.innerHeight );
}
window.addEventListener( 'resize', onWindowResize, false );
$(document).ready(function()	{
    var container = document.getElementById('canvas').appendChild(renderer.domElement);
});