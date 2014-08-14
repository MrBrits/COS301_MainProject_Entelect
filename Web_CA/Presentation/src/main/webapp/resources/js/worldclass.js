this.cellArray;
this.projector;

function world(xSize, ySize, zSize, scene)	{
    //Variables
    this.xSize = xSize;
    this.ySize = ySize;
    this.zSize = zSize;
    this.layer = -1;
    this.scene = scene;
    this.play = false;
    var height =0;
    var sizex = 10, sizey = 10,sizez = 10;
    this.makeGrid = function()	{
        cellArray = new Array();
        for(var z = 0; z < zSize; z++){
            var length = 0;
            cellArray [height] = new Array();
            for(var y = 0; y < ySize; y++) {
                var depth = 0;
                cellArray [height][length] = new Array();
                for(var x = 0; x < xSize; x++)	{
                    var geometry = new THREE.CubeGeometry(1.5, 1.5, 1.5);
                    var colour = randomFairColor();
                    var material = new THREE.MeshPhongMaterial({
                        color: colour,
                        ambient: 0x808080,
                        specular: 0xffffff,
                        shininess: 20,
                        transparent:true,
                        opacity:1
                    });
                    var cubes = new THREE.Mesh(geometry, material);
                    cellArray [height][length][depth] = new cell(x,y,z,cubes);
                    cellArray [height][length][depth].cube.position = new THREE.Vector3(x*1.509, y*1.509, z*1.509);
                    this.scene.add(cellArray [height][length][depth].cube);
                    cellArray [height][length][depth].invis = true;
                    cellArray [height][length][depth].colour = colour;
                    depth++;
                }
                length++;
            }
            height++;
        }
        projector = new THREE.Projector();
    }


    this.StartAndStop = function()	{
        if(this.play == true) {
            var z2 = 0;
            for (var z = 0; z < zSize; z++) {
                var y2 = 0;
                for (var y = 0; y < ySize; y++) {
                    var x2 = 0;
                    for (var x = 0; x < xSize; x++) {
                        if (Math.random() < 0.5)	{
                            cellArray[z][y][x].cube.material.opacity = 0.05;
                            cellArray[z][y][x].cube.material.color.setHex("0xffffff");
                            cellArray[z][y][x].colour = 0;
                        }
                        else {
                            if(cellArray[z][y][x].invis == true)
                                cellArray[z][y][x].cube.material.opacity = 1;
                            var c = randomFairColor();
                            cellArray[z][y][x].cube.material.color.setHex(c);
                            cellArray[z][y][x].colour = c;
                        }
                    }
                    x2+=1;
                }
                y2+=1;
            }
            z2+=1;
        }
    }

    /*Changing of layers, which layer is being viewed and used
     layer = -1 -> The entire world
     layer = 0 -> The bottom most layer of the world, regarding the y-axis*/
    this.changeWorldLayer = function()	{
        this.layer++;
        for (var z = 0; z < zSize; z++) {
            for (var y = 0; y < ySize; y++) {
                for (var x = 0; x < xSize; x++) {
                    if(this.layer==-1)	{
                        cellArray[z][y][x].invis = true;
                        if(cellArray[z][y][x].colour != 0)
                            cellArray[z][y][x].toggleInvis();
                    }
                    else if(this.layer==y)	{
                        cellArray[z][y][x].invis = true;
                        if(cellArray[z][y][x].colour != 0)
                            cellArray[z][y][x].toggleInvis();
                    }
                    else	{
                        cellArray[z][y][x].invis = false;
                        if(cellArray[z][y][x].colour != 0)
                            cellArray[z][y][x].toggleInvis();
                    }
                }
            }
        }
        if(this.layer > ySize - 2)
            this.layer = -2;
    }
}

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

/*Finding which cubes intersects with mouse cursor when left mouse button is clicked
 Changing of the state of cube that intersects which is also visible
 This function is only called when left mouse button is clicked*/
function changeState()
{
    var vector = new THREE.Vector3(( event.layerX / window.innerWidth ) * 2 - 1, -( event.layerY / window.innerHeight ) * 2 + 1, 0.5);
    projector.unprojectVector(vector, camera);

    var raycaster = new THREE.Raycaster(camera.position, vector.sub(camera.position).normalize());

    //Finds all elements that are in the position of the cursor
    var intersects = raycaster.intersectObjects(scene.children, true);

    if(this.layer == -1)	{
        if(typeof intersects[0] !== 'undefined')
            var tx = Math.floor(intersects[0].object.position.x/1.5);
        var ty = Math.floor(intersects[0].object.position.y/1.5);
        var tz = Math.floor(intersects[0].object.position.z/1.5);
        //intersects[0].object.material.color.setHex(0xDA4D1A);
        this.cellArray[tz][ty][tx].cube.material.color.setHex(0xDA4D1A);
    }
    else	{
        for(var i =0; i < intersects.length; i++) {
            if(typeof intersects[i] !== 'undefined')
                var tx=Math.floor(intersects[i].object.position.x/1.5);
            var ty=Math.floor(intersects[i].object.position.y/1.5);
            var tz=Math.floor(intersects[i].object.position.z/1.5);
            if(this.cellArray[tz][ty][tx].invis == true)	{
                this.cellArray[tz][ty][tx].cube.material.color.setHex(0xDA4D1A);
                this.cellArray[tz][ty][tx].cube.material.opacity = 1;
                this.cellArray[tz][ty][tx].colour = 0xDA4D1A;
                break;
            }
        }
    }
}

document.addEventListener('mousedown', mouseDowner, false);
document.addEventListener('mouseup', mouseUpper, false);
document.addEventListener('mousemove', mouseDrag, false);

//Random colour creation and returned as RGB value
function randomFairColor() {
    var min = 64;
    var max = 224;
    var r = (Math.floor(Math.random() * (max - min + 1)) + min) * 1;
    var g = (Math.floor(Math.random() * (max - min + 1)) + min) * 256;
    var b = (Math.floor(Math.random() * (max - min + 1)) + min);
    return r + g + b;
}







