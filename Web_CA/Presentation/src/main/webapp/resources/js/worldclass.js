this.cellArray;
this.projector;
this.tmx=0;
this.tmy=0;
this.tmz=0;
this.xbar ;
this.ybar ;
this.zbar;
this.midpoint;
function world(xSize, ySize, zSize, scene)	{
    //Variables
    tmx=xSize;
    tmz=zSize;
    tmy=ySize;
    xbar = new Array();
    ybar = new Array();
    zbar = new Array();
    this.xSize = xSize;
    this.ySize = ySize;
    this.zSize = zSize;
    this.layer = -1;
    this.scene = scene;
    this.play = false;
    var height =0;
    var group = new THREE.Object3D();
    var sizex = 20, sizey = 20,sizez = 20;
    var geometry = new THREE.CubeGeometry(1.5, 1.5, 1.5);
    /*var material = new THREE.MeshPhongMaterial({
     color: 0xFFFFFF,
     ambient: 0x808080,
     specular: 0xffffff,
     shininess: 20,
     transparent:true,
     opacity:0.09
     });*/
    var material =	new THREE.MeshBasicMaterial( { color: 0xFFFFFF,
        ambient: 0x808080,
        specular: 0xffffff,
        shininess: 20,
        transparent:true,
        opacity:0.05} );
    this.makeGrid = function()	{
        cellArray = new Array();
        for(var z = 0; z < zSize; z++){
            var length = 0;
            cellArray [height] = new Array();
            for(var y = 0; y < ySize; y++) {
                var depth = 0;
                cellArray [height][length] = new Array();
                for(var x = 0; x < xSize; x++)	{
                    var cubes = new THREE.Mesh(geometry, material.clone());
                    cellArray [height][length][depth] = new cell(x,y,z,cubes);
                    cellArray [height][length][depth].cube.position = new THREE.Vector3(x*1.509, y*1.509, z*1.509);
                    group.add( cellArray [height][length][depth].cube );
                    depth++;
                }
                length++;
            }
            height++;

        }

        material =	new THREE.MeshBasicMaterial( { color: 0x000000,
            ambient: 0x808080,
            specular: 0xffffff,
            shininess: 20,
            opacity: 0.4
        } );



        for(var i=0;i<xSize;i++)
        {
            material.color.setHex(0x81bf48);
            var cubes = new THREE.Mesh(geometry, material.clone());
            cubes.position = new THREE.Vector3((xSize)*1.509, i*1.509,(zSize)*1.509);
            xbar[i]=cubes;
            group.add( cubes );
        }

        for(var i=0;i<ySize;i++)
        {
            material.color.setHex(0x418df2);
            var cubes = new THREE.Mesh(geometry, material.clone());
            cubes.position = new THREE.Vector3(i*1.509, -1.509,(zSize)*1.509);
            group.add( cubes );
            ybar[i]=cubes;
        }


        for(var i=0;i<zSize;i++)
        {
            material.color.setHex(0xf24623);
            var cubes = new THREE.Mesh(geometry, material.clone());
            cubes.position = new THREE.Vector3((xSize)*1.509, -1.509,i*1.509);
            group.add( cubes );
            zbar[i]=cubes;
        }

        material.color.setHex(0xe6f222);
        var cubes = new THREE.Mesh(geometry, material.clone());
        cubes.position = new THREE.Vector3((xSize)*1.509, -1.509,(zSize)*1.509);
        group.add( cubes );
        midpoint=cubes;
        this.scene.add(group);
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
                        var neightbours = countNeighbours(x,y,z);
                        if(cellArray[z][y][x].value == 1 && neightbours < 2)
                            cellArray[z][y][x].nextValue = 0;
                        else if(cellArray[z][y][x].value == 1 && (neightbours == 2 || neightbours == 3))
                            cellArray[z][y][x].nextValue = 1;
                        else if(cellArray[z][y][x].value == 1 && (neightbours == 3))
                            cellArray[z][y][x].nextValue = 0;
                        else if(cellArray[z][y][x].value == 0 && neightbours == 3)
                            cellArray[z][y][x].nextValue = 1;
                    }
                    x2+=1;
                }
                y2+=1;
            }
            z2+=1;
            for(var z = 0; z < zSize; z++)	{
                for(var y = 0; y < ySize; y++)	{
                    for(var x = 0; x < xSize; x++)	{
                        cellArray[z][y][x].changeValue();
                    }
                }
            }
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
                        cellArray[z][y][x].toggleInvis();
                    }
                    else if(this.layer==y)	{
                        cellArray[z][y][x].invis = true;
                        cellArray[z][y][x].toggleInvis();
                    }
                    else	{
                        cellArray[z][y][x].invis = false;
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
        //Yellow Box - All
        if(tx == tmx && ty < 0 && tz == tmz)	{
            for (var z = 0; z < tmz; z++) {
                for (var y = 0; y < tmy; y++) {
                    for (var x = 0; x < tmx; x++) {
                        if(cellArray[z][y][x].invis == true)	{
                            cellArray[z][y][x].invis = false;
                            cellArray[z][y][x].toggleInvis();
                        }
                        else if(cellArray[z][y][x].invis == false)	{
                            cellArray[z][y][x].invis = true;
                            cellArray[z][y][x].toggleInvis();
                        }
                    }
                }
            }
        }
        //Red Bar   - X
        else if(tx == tmx && ty < 0)
            toggleXLayer(tz);
        //Green Bar - Y
        else if(tx == tmx && tz == tmz)
            toggleYLayer(ty);
        //Blue Bar  - Z
        else if(ty < 0 && tz == tmz)
            toggleZLayer(tx);
        else {
            this.cellArray[tz][ty][tx].cube.material.color.setHex(0xDA4D1A);
        }
    }
    else	{
        for(var i =0; i < intersects.length; i++) {
            if(typeof intersects[i] !== 'undefined')	{
                var tx=Math.floor(intersects[i].object.position.x/1.5);
                var ty=Math.floor(intersects[i].object.position.y/1.5);
                var tz=Math.floor(intersects[i].object.position.z/1.5);
                //Yellow Box - All
                if(tx == tmx && ty < 0 && tz == tmz)	{

                    for (var z = 0; z < tmz; z++) {
                        for (var y = 0; y < tmy; y++) {
                            for (var x = 0; x < tmx; x++) {
                                if(this.isTrue== true)	{
                                    cellArray[z][y][x].invis = false;
                                    cellArray[z][y][x].toggleInvis();
                                }
                                else
                                {
                                    cellArray[z][y][x].invis = true;
                                    cellArray[z][y][x].toggleInvis();
                                }
                            }
                        }
                    }
                    if(this.isTrue== true)
                        this.isTrue=false;
                    else
                        this.isTrue=true;
                    break;
                }
                //Red Bar   - X
                else if(tx == tmx && ty < 0)	{
                    toggleXLayer(tz);
                    break;
                }
                //Green Bar - Y
                else if(tx == tmx && tz == tmz)	{
                    toggleYLayer(ty);
                    break;
                }
                //Blue Bar  - Z
                else if(ty < 0 && tz == tmz)	{
                    toggleZLayer(tx);
                    break;
                }
                else if(this.cellArray[tz][ty][tx].invis == true )	{
                    this.cellArray[tz][ty][tx].cube.material.color.setHex(0x000000);
                    this.cellArray[tz][ty][tx].cube.material.opacity = 1;
                    this.cellArray[tz][ty][tx].colour = "0x000000";
                    this.cellArray[tz][ty][tx].value = 1;
                    break;
                }
            }
        }
    }
}
this.isTrue=true;
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

function countNeighbours(x, y, z)	{
    var count = 0;
    if(z - 1 >= 0)	{
        if(y + 1 <= tmy - 1)
            count += cellArray[z - 1][y + 1][x].value;
        if(y - 1 >= 0)
            count += cellArray[z - 1][y - 1][x].value;
        if(x + 1 <= tmx - 1)
            count += cellArray[z - 1][y][x + 1].value;
        if(x - 1 >= 0)
            count += cellArray[z - 1][y][x - 1].value;
        if(y + 1 <= tmy - 1 && x + 1 <= tmx - 1)
            count += cellArray[z - 1][y + 1][x + 1].value;
        if(y - 1 >= 0 && x - 1 >= 0)
            count += cellArray[z - 1][y - 1][x - 1].value;
        if(y + 1 <= tmy - 1 && x - 1 >= 0)
            count += cellArray[z - 1][y + 1][x - 1].value;
        if(y - 1 >= 0 && x + 1 <= tmx - 1)
            count += cellArray[z - 1][y - 1][x + 1].value;
    }

    if(z + 1 <= tmz - 1)	{
        if(y + 1 <= tmy - 1)
            count += cellArray[z + 1][y + 1][x].value;
        if(y - 1 >= 0)
            count += cellArray[z + 1][y - 1][x].value;
        if(x + 1 <= tmx - 1)
            count += cellArray[z + 1][y][x + 1].value;
        if(x - 1 >= 0)
            count += cellArray[z + 1][y][x - 1].value;
        if(y + 1 <= tmy - 1 && x + 1 <= tmx - 1)
            count += cellArray[z + 1][y + 1][x + 1].value;
        if(y - 1 >= 0 && x - 1 >= 0)
            count += cellArray[z + 1][y - 1][x - 1].value;
        if(y + 1 <= tmy - 1 && x - 1 >= 0)
            count += cellArray[z + 1][y + 1][x - 1].value;
        if(y - 1 >= 0 && x + 1 <= tmx - 1)
            count += cellArray[z + 1][y - 1][x + 1].value;
    }

    if(y + 1 <= tmy - 1)
        count += cellArray[z][y + 1][x].value;
    if(y - 1 >= 0)
        count += cellArray[z][y - 1][x].value;
    if(x + 1 <= tmx - 1)
        count += cellArray[z][y][x + 1].value;
    if(x - 1 >= 0)
        count += cellArray[z][y][x - 1].value;
    if(y + 1 <= tmy - 1 && x + 1 <= tmx - 1)
        count += cellArray[z][y + 1][x + 1].value;
    if(y - 1 >= 0 && x - 1 >= 0)
        count += cellArray[z][y - 1][x - 1].value;
    if(y + 1 <= tmy - 1 && x - 1 >= 0)
        count += cellArray[z][y + 1][x - 1].value;
    if(y - 1 >= 0 && x + 1 <= tmx - 1)
        count += cellArray[z][y - 1][x + 1].value;

    return count;
}

function toggleXLayer(zlayer)	{
    for (var y = 0; y < tmz; y++) {
        for (var x = 0; x < tmx; x++) {
            if(cellArray[zlayer][y][x].invis == true)	{
                cellArray[zlayer][y][x].invis = false;
                cellArray[zlayer][y][x].toggleInvis();
            }
            else if(cellArray[zlayer][y][x].invis == false)	{
                cellArray[zlayer][y][x].invis = true;
                cellArray[zlayer][y][x].toggleInvis();
            }
        }
    }
}

function toggleYLayer(ylayer)	{
    for (var z = 0; z < tmz; z++) {
        for (var x = 0; x < tmx; x++) {
            if(cellArray[z][ylayer][x].invis == true)	{
                cellArray[z][ylayer][x].invis = false;
                cellArray[z][ylayer][x].toggleInvis();
            }
            else if(cellArray[z][ylayer][x].invis == false)	{
                cellArray[z][ylayer][x].invis = true;
                cellArray[z][ylayer][x].toggleInvis();
            }
        }
    }
}

function toggleZLayer(xlayer)	{
    for (var z = 0; z < tmz; z++) {
        for (var y = 0; y < tmy; y++) {
            if(cellArray[z][y][xlayer].invis == true)	{
                cellArray[z][y][xlayer].invis = false;
                cellArray[z][y][xlayer].toggleInvis();
            }
            else if(cellArray[z][y][xlayer].invis == false)	{
                cellArray[z][y][xlayer].invis = true;
                cellArray[z][y][xlayer].toggleInvis();
            }
        }
    }
}
function hider()
{

    for (var i=0;i<tmz;i++)
    {

        zbar[i].visible= document.getElementById("z").checked;

    }for (var i=0;i<tmx;i++)
{
    xbar[i].visible= document.getElementById("x").checked;

}for (var i=0;i<tmy;i++)
{
    ybar[i].visible= document.getElementById("y").checked;


}
    midpoint.visible=document.getElementById("mid").checked;

}








