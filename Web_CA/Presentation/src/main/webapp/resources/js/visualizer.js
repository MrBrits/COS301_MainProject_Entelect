
var scene = new THREE.Scene();
var camera = new THREE.PerspectiveCamera(30, $(window).width() / $(window).height(), 1, 1000);
var renderer = new THREE.WebGLRenderer();
var cubes = new Array();
var controls;
var play = false;
var projector;
var realSpeed = 0;

//FUNCTIONS FOR THE CONTROL WINDOW
var methods= new function()	{
    var runSimulation = null;
    this.Rotate = function()	{
        controls.autoRotater();
    }

    this.Start_Stop = function()	{

        realSpeed = (10 - this.Speed) * 100;
        clearInterval(runSimulation);
        if (play)	{
            clearInterval(runSimulation);
            play = false;
        }
        else	{
            runSimulation = setInterval(function(){StartAndStop()}, realSpeed);
            play = true;
        }
    }

    this.Change_Layer=function()	{
        changeWorldLayer();
    }

    this.Change_speed=function()	{
        if(this.Speed != 0)	{
            realSpeed = (10 - this.Speed) * 100;
            if (play)	{
                clearInterval(runSimulation);
                runSimulation = setInterval(function(){StartAndStop()}, realSpeed);
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

//var doc=document.getElementById("canvas");
//document.getElementById("canvas").add(renderer.domElement);
//document.body.appendChild(renderer.domElement);
//$("#canvas").appendChild("hello");
var container = document.getElementById( 'canvas').appendChild(renderer.domElement);
//container.appendChild();


//Creation of cube array and adding the array to the scene
var height =0;
var sizex = 10, sizey = 10,sizez = 10;
for(var z = 0; z < sizez; z++){
    var length = 0;
    cubes[height] = new Array();
    for(var x = 0; x < sizex; x ++) {
        var depth = 0;
        cubes[height][length] = new Array();
        for(var y = 0; y < sizey; y ++)	{
            var geometry = new THREE.CubeGeometry(1.5, 1.5, 1.5);
            var material = new THREE.MeshPhongMaterial({
                color: randomFairColor(),
                ambient: 0x808080,
                specular: 0xffffff,
                shininess: 20,
                transparent:true,
                opacity:1
            });
            cubes[height][length][depth] = new THREE.Mesh(geometry, material);
            cubes[height][length][depth].position = new THREE.Vector3(((sizex)/2+1.509)+(x*1.509), (y*1.509), (z*1.509));
            scene.add(cubes[height][length][depth]);
            depth++;
        }
        length++;
    }
    height++;
}

//Creation of a light source
var light = new THREE.AmbientLight(0x505050);
scene.add(light);
projector = new THREE.Projector();

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

controls = new THREE.OrbitControls(camera);
controls.addEventListener('change', render);

for(var i = 0; i < 7; i++) {
    controls.pan(new THREE.Vector3( 1, 0, 0 ));
    controls.pan(new THREE.Vector3( 0, 1, 0 ));
}

//Start and Stop of simulation
function StartAndStop()	{
    if(play == true) {
        for (var height = 0; height < sizez; height++) {
            for (var length = 0; length < sizex; length++) {
                for (var depth = 0; depth < sizey; depth++) {
                    //cubes[i2][i].material.color.setHex(randomFairColor() );
                    if (Math.random() < 0.5)	{
                        cubes[height][length][depth].material.opacity =0;
                    }
                    else {
                        cubes[height][length][depth].material.opacity =1;
                        cubes[height][length][depth].material.color.setHex(randomFairColor());
                    }
                }
            }
        }
    }
}

//Rendering of ALL cubes
var render = function () {
    if(typeof array === 'object' && array.length > 0) {
        var k = 0;
        for(var i = 0; i < cubes.length; i++) {
            for(var j = 0; j < cubes[i].length; j++) {
                var scale = (array[k] + boost) / 30;
                cubes[i][j].scale.z = (scale < 1 ? 1 : scale);
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

//Random colour creation and returned as RGB value
function randomFairColor() {
    var min = 64;
    var max = 224;
    var r = (Math.floor(Math.random() * (max - min + 1)) + min) * 1;
    var g = (Math.floor(Math.random() * (max - min + 1)) + min) * 256;
    var b = (Math.floor(Math.random() * (max - min + 1)) + min);
    return r + g + b;
}

//Changing of layers, which layer is being viewed and used
//layer = -1 -> The entire world
//layer = 0 -> The bottom most layer of the world, regarding the y-axis
var layer=-1;
function changeWorldLayer()	{
    layer++;
    for (var height = 0; height < sizez; height++) {
        for (var length = 0; length < sizex; length++) {
            for (var depth = 0; depth < sizey; depth++) {
                if(layer == -1)
                    cubes[height][length][depth].visible = true;
                else if(layer == depth)
                    cubes[height][length][depth].visible = true;
                else{
                    cubes[height][length][depth].visible = false;
                }
            }
        }
    }

    if(layer>sizey-2)
        layer=-2;
}

//Event Listeners for mouse controls
document.addEventListener( 'mousedown', mouseDowner, false );
document.addEventListener( 'mouseup', mouseUpper, false );
document.addEventListener( 'mousemove', mouseDrag, false );

//Boolean to check if mouse button is being clicked
//Used mainly to test for click and drag functionality
var leftMouseClick=false;
//Click any mouse button
function mouseDowner(event) {
    //Left - 0
    //Middle - 1
    //Right - 2
    if (event.button == 0) {
        leftMouseClick = true;
        changeState();
    }

}
//Release any mouse button
function mouseUpper(event){
    leftMouseClick=false;
}
//Calls change state if mouse is moving whilst left mouse button is being held down
//Mouse move event not explicitly being used. This function is triggered when mouse is moved
function mouseDrag(){
    if(leftMouseClick) {
        changeState();
    }
}

//Finding which cubes intersects with mouse cursor when left mouse button is clicked
//Changing of the state of cube that intersects which is also visible
//This function is only called when left mouse button is clicked
function changeState()
{
    var vector = new THREE.Vector3(( event.clientX / window.innerWidth ) * 2 - 1, -( event.clientY / window.innerHeight ) * 2 + 1, 0.5);
    projector.unprojectVector(vector, camera);

    var raycaster = new THREE.Raycaster(camera.position, vector.sub(camera.position).normalize());

    //Finds all elements that are in the position of the cursor
    var intersects = raycaster.intersectObjects(scene.children, true);


    if(layer==-1)
    {
        //If entire world (all layers) are being viewed. Only change what user can see
        if(typeof intersects[0] !== 'undefined')
            intersects[0].object.material.color.setHex(0xDA4D1A);
    }
    else
    {
        //When individual layers are being viewed. Only changes elements that are visible
        //Removing the visibility check will change the state of all elements that are in position with the cursor
        for(var i =0;i<intersects.length;i++) {
            if(typeof intersects[i] !== 'undefined')
                if (intersects[i].object.visible == true) {
                    intersects[i].object.material.color.setHex(0xDA4D1A);
                    break;
                }
        }
    }

}

function onWindowResize() {
	camera.aspect = window.innerWidth / window.innerHeight;
	renderer.setSize( window.innerWidth, window.innerHeight );
}
window.addEventListener( 'resize', onWindowResize, false );
