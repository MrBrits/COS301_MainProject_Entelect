
var scene = new THREE.Scene();
var camera = new THREE.PerspectiveCamera(30, $(window).width() / $(window).height(), 1, 1000);
var renderer = new THREE.WebGLRenderer();
var cubes = new Array();
var controls;
var play=false;
var projector;
var realSpeed = 0;

//FUNCTIONS FOR THE CONTROLS
var methods= new function()	{
    var callTeee = null;

    this.Rotate = function()	{
        controls.autoRotater();
    }

    this.Start_Stop = function()	{

        realSpeed = (10 - this.Speed) * 100;
        clearInterval(callTeee);
        if (play)	{
            clearInterval(callTeee);
            play = false;
        }
        else	{
            callTeee = setInterval(function(){StartAndStop()}, realSpeed);
            play = true;
        }
    }

    this.Change_Layer=function()	{
        temp();
    }

    this.Change_speed=function()	{
        if(this.Speed != 0)	{
            realSpeed = (10 - this.Speed) * 100;
            if (play)	{
                clearInterval(callTeee);
                callTeee = setInterval(function(){StartAndStop()}, realSpeed);
            }
        }
        else	{
            clearInterval(callTeee);
        }
    }

    this.Change_rotation_speed;

    this.Speed = 1;
    this.Rotation_Speed = 0.02;
}

//var doc=document.getElementById("canvas");
//document.getElementById("canvas").add(renderer.domElement);
//document.body.appendChild(renderer.domElement);
//$("#canvas").appendChild("hello");
var container = document.getElementById( 'canvas').appendChild(renderer.domElement);
//container.appendChild();
//document.getElementById("canvas").appendChild(gui.domElement);
var h=0;
var sizex = 1, sizey = 50,sizez = 50;
for(var z = 0; z < sizez; z++){
    var i = 0;
    cubes[h] = new Array();
    for(var x = 0; x < sizex; x ++) {
        var j = 0;
        cubes[h][i] = new Array();
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
            cubes[h][i][j] = new THREE.Mesh(geometry, material);
            cubes[h][i][j].position = new THREE.Vector3(x*1.509, y*1.509, z*1.509);
            scene.add(cubes[h][i][j]);
            j++;
        }
        i++;
    }
    h++;
}

var light = new THREE.AmbientLight(0x505050);
scene.add(light);
projector = new THREE.Projector();

var directionalLight = new THREE.DirectionalLight(0xffffff, 0.7);
directionalLight.position.set(0, 1, 1);
scene.add(directionalLight);

directionalLight = new THREE.DirectionalLight(0xffffff, 0.7);
directionalLight.position.set(1, 1, 0);
scene.add(directionalLight);

directionalLight = new THREE.DirectionalLight(0xffffff, 0.7);
directionalLight.position.set(0, -1, -1);
scene.add(directionalLight);

directionalLight = new THREE.DirectionalLight(0xffffff, 0.7);
directionalLight.position.set(-1, -1, 0);
scene.add(directionalLight);

camera.position.z = 50;
camera.position.y = 50;
camera.position.x = 50;

controls = new THREE.OrbitControls(camera);
controls.addEventListener('change', render);

var gui = new dat.GUI();
gui.add(methods, 'Rotate');
gui.add(methods, 'Start_Stop');
gui.add(methods, 'Rotate');
gui.add(methods, 'Start_Stop');
gui.add(methods, 'Change_Layer');
gui.add(methods, 'Rotation_Speed',0,0.5);
gui.add(methods, 'Speed',0,10).onFinishChange(function()	{
    methods.Change_speed();
});

for(var i = 0; i < 7; i++) {
    controls.pan(new THREE.Vector3( 1, 0, 0 ));
    controls.pan(new THREE.Vector3( 0, 1, 0 ));
}
function StartAndStop()	{
    if(play == true) {
        for (var i3 = 0; i3 < sizez; i3++) {
            for (var i = 0; i < sizex; i++) {
                for (var i2 = 0; i2 < sizey; i2++) {
                    //cubes[i2][i].material.color.setHex(randomFairColor() );
                    if (Math.random() < 0.5)	{
                        cubes[i3][i][i2].material.opacity =0;
                    }
                    else {
                        cubes[i3][i][i2].material.opacity =1;
                        cubes[i3][i][i2].material.color.setHex(randomFairColor());
                    }
                }
            }
        }
    }
}

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

function randomFairColor() {
    var min = 64;
    var max = 224;
    var r = (Math.floor(Math.random() * (max - min + 1)) + min) * 1;
    var g = (Math.floor(Math.random() * (max - min + 1)) + min) * 256;
    var b = (Math.floor(Math.random() * (max - min + 1)) + min);
    return r + g + b;
}

var layer=-1;

function temp()	{
    for (var i3 = 0; i3 < sizez; i3++) {
        for (var i = 0; i < sizex; i++) {
            for (var i2 = 0; i2 < sizey; i2++) {
                if(layer==-1)
                    cubes[i3][i][i2].visible = true;
                else if(layer==i2)
                    cubes[i3][i][i2].visible = true;
                else	{
                    cubes[i3][i][i2].visible = false;
                    //scene.remove(cubes[i3][i][i2]);
                }
            }
        }
    }
    layer++;
    if(layer>7)
        layer=-1;
}

function player()	{
    play=true;
}

function stop()	{
    play=false;
}

document.addEventListener( 'mousedown', mouseDowner, false );
document.addEventListener( 'mouseup', mouseUpper, false );
document.addEventListener( 'mousemove', tempers, false );



var mouseclick=false;

function mouseDowner()
{
    mouseclick=true;
}
function mouseUpper()
{
    mouseclick=false;
}
//Colouring of Blocks
function tempers(event)
{
    if(event.button==0) {
        if(mouseclick)	{
            var vector = new THREE.Vector3(( event.clientX / window.innerWidth ) * 2 - 1, -( event.clientY / window.innerHeight ) * 2 + 1, 0.5);
            projector.unprojectVector(vector, camera);

            var raycaster = new THREE.Raycaster(camera.position, vector.sub(camera.position).normalize());

            var intersects = raycaster.intersectObjects(scene.children);

            if (intersects.length > 0) {

                //if (intersects[0].object.visible==false)
                //{

                intersects[0].object.material.color.setHex(0xDA4D1A);
                /*
                 intersects[0].object.visible=true;
                 }
                 else if (intersects[0].object.visible==true)
                 {

                 intersects[0].object.visible=false;
                 }*/
            }
        }
    }
}
