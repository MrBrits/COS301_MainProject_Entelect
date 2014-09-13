this.cellArray;
this.ruleArray=new Array();
this.projector;
this.camera;
this.tmx = 0;
this.tmy = 0;
this.tmz = 0;
this.xbar;
this.ybar;
this.zbar;
this.midpoint;
this.colorsUsed = new Array();
this.colorsUsedName = new Array();
this.colourCounter=0;
this.coordinate;
this.states;
this.arryColour;
this.counter=0;
//controller to add the coordinates
var web_ca = angular.module('coordinate_app', []);
web_ca.controller("CoordinateManager", function ($scope, $http) {

    var userId = document.getElementById("userId").value;
    var worldId=document.getElementById("worldId").value;
    $http.post("http://" + site + "/getCoordinatesByWorldId/", worldId)
        .success(function (data) {
            this.coordinate = data;
        }).error(function () {
            alert("GET COORDINATES: SERVER ERROR");
        });
    $http.post("http://" + site + "/getStateByUserId/", userId)
        .success(function (data) {
            //this.coordinate = data;

            arryColour = ["0xFFFFFF", "0xFFFFCC", "0xFFFF99", "0xFFFF66", "0xFFFF33", "0xFFFF00", "0xFFCCFF", "0xFFCCCC", "0xFFCC99", "0xFFCC66", "0xFFCC33", "0xFFCC00", "0xFF99FF", "0xFF99CC", "0xFF9999", "0xFF9966", "0xFF9933", "0xFF9900", "0xFF66FF", "0xFF66CC", "0xFF6699", "0xFF6666", "0xFF6633", "0xFF6600", "0xFF33FF", "0xFF33CC", "0xFF3399", "0xFF3366", "0xFF3333", "0xFF3300", "0xFF00FF", "0xFF00CC", "0xFF0099", "0xFF0066", "0xFF0033", "0xFF0000", "0x66FFFF", "0x66FFCC", "0x66FF99", "0x66FF66", "0x66FF33", "0x66FF00", "0x66CCFF", "0x66CCCC", "0x66CC99", "0x66CC66", "0x66CC33", "0x66CC00", "0x6699FF", "0x6699CC", "0x669999", "0x669966", "0x669933", "0x669900", "0x6666FF", "0x6666CC", "0x666699", "0x666666", "0x666633", "0x666600", "0x6633FF", "0x6633CC", "0x663399", "0x663366", "0x663333", "0x663300", "0x6600FF", "0x6600CC", "0x660099", "0x660066", "0x660033", "0x660000", "0xCCFFFF", "0xCCFFCC", "0xCCFF99", "0xCCFF66", "0xCCFF33", "0xCCFF00", "0xCCCCFF", "0xCCCCCC", "0xCCCC99", "0xCCCC66", "0xCCCC33", "0xCCCC00", "0xCC99FF", "0xCC99CC", "0xCC9999", "0xCC9966", "0xCC9933", "0xCC9900", "0xCC66FF", "0xCC66CC", "0xCC6699", "0xCC6666", "0xCC6633", "0xCC6600", "0xCC33FF", "0xCC33CC", "0xCC3399", "0xCC3366", "0xCC3333", "0xCC3300", "0xCC00FF", "0xCC00CC", "0xCC0099", "0xCC0066", "0xCC0033", "0xCC0000", "0x33FFFF", "0x33FFCC", "0x33FF99", "0x33FF66", "0x33FF33", "0x33FF00", "0x33CCFF", "0x33CCCC", "0x33CC99", "0x33CC66", "0x33CC33", "0x33CC00", "0x3399FF", "0x3399CC", "0x339999", "0x339966", "0x339933", "0x339900", "0x3366FF", "0x3366CC", "0x336699", "0x336666", "0x336633", "0x336600", "0x3333FF", "0x3333CC", "0x333399", "0x333366", "0x333333", "0x333300", "0x3300FF", "0x3300CC", "0x330099", "0x330066", "0x330033", "0x330000", "0x99FFFF", "0x99FFCC", "0x99FF99", "0x99FF66", "0x99FF33", "0x99FF00", "0x99CCFF", "0x99CCCC", "0x99CC99", "0x99CC66", "0x99CC33", "0x99CC00", "0x9999FF", "0x9999CC", "0x999999", "0x999966", "0x999933", "0x999900", "0x9966FF", "0x9966CC", "0x996699", "0x996666", "0x996633", "0x996600", "0x9933FF", "0x9933CC", "0x993399", "0x993366", "0x993333", "0x993300", "0x9900FF", "0x9900CC", "0x990099", "0x990066", "0x990033", "0x990000", "0x00FFFF", "0x00FFCC", "0x00FF99", "0x00FF66", "0x00FF33", "0x00FF00", "0x00CCFF", "0x00CCCC", "0x00CC99", "0x00CC66", "0x00CC33", "0x00CC00", "0x0099FF", "0x0099CC", "0x009999", "0x009966", "0x009933", "0x009900", "0x0066FF", "0x0066CC", "0x006699", "0x006666", "0x006633", "0x006600", "0x0033FF", "0x0033CC", "0x003399", "0x003366", "0x003333", "0x003300", "0x0000FF", "0x0000CC", "0x000099", "0x000066", "0x000033", "0x000000"];
            for (var i = (data.length - 1); i >= 0; i--) {
                arryColour.unshift("0x" + data[i].stateHex.substring(1));
            }
            for (var i = 0; i < data.length; i++) {
                colorsUsed[data[i].stateValue] = arryColour[counter];
                colorsUsedName[counter] = data[i].stateValue;
                counter++;
            }

        }).error(function () {
            alert("GET States: SERVER ERROR");
        });


    $http.post("http://" + site + "/getRuleByUserId", userId)
        .success(function (data) {
            ruleArray.push(new rule());
            for(var i=0;i<data.length;i++)
            ruleArray[0].name = data[i].ruleName;
            ruleArray[0].ruleDesc = data[i].ruleDesc;
            ruleArray[0].priority = data[i].priority;
        }).error(function () {
            alert("RETRIEVE RULES BY USER ID: SERVER ERROR");
        });


});
//function to add world
function world(scene,cameras) {


    ruleArray = new Array();
    ruleArray.push(new rule());
    ruleArray[0].name = "GameOfLifeRule1";
    ruleArray[0].ruleDesc = "Under Population";
    ruleArray[0].enabled = true;

    ruleArray[0].ruleCond = new condition();
    ruleArray[0].ruleCond.isNot = false;
    ruleArray[0].ruleCond.conditionOperation = "SUM";
    ruleArray[0].ruleCond.conditionNeighbours = "000000000000010000000000000";
    ruleArray[0].ruleCond.conditionOperand = "==";
    ruleArray[0].ruleCond.compareValueOne = 1;
    ruleArray[0].ruleCond.compareValueTwo = null;

    ruleArray[0].RuleCondAND = new condition();
    ruleArray[0].RuleCondAND.isNot = false;
    ruleArray[0].RuleCondAND.conditionOperation = "SUM";
    ruleArray[0].RuleCondAND.conditionNeighbours = "111111111111101111111111111";
    ruleArray[0].RuleCondAND.conditionOperand = "<";
    ruleArray[0].RuleCondAND.compareValueOne = 2;
    ruleArray[0].RuleCondAND.compareValueTwo = null;

    ruleArray[0].resultOperand = "";
    ruleArray[0].resultOperator = "";
    ruleArray[0].resultValue = 0;

    ruleArray.push(new rule());
    ruleArray[1].name = "GameOfLifeRule2";
    ruleArray[1].ruleDesc = "Next Generation";
    ruleArray[1].enabled = true;

    ruleArray[1].ruleCond = new condition();
    ruleArray[1].ruleCond.isNot = false;
    ruleArray[1].ruleCond.conditionOperation = "SUM";
    ruleArray[1].ruleCond.conditionNeighbours = "000000000000010000000000000";
    ruleArray[1].ruleCond.conditionOperand = "==";
    ruleArray[1].ruleCond.compareValueOne = 1;

    ruleArray[1].RuleCondAND = new condition();
    ruleArray[1].RuleCondAND.isNot = false;
    ruleArray[1].RuleCondAND.conditionOperation = "SUM";
    ruleArray[1].RuleCondAND.conditionNeighbours = "111111111111101111111111111";
    ruleArray[1].RuleCondAND.conditionOperand = "BETWEEN";
    ruleArray[1].RuleCondAND.compareValueOne = 2;
    ruleArray[1].RuleCondAND.compareValueTwo = 3;

    ruleArray[1].resultOperand = "";
    ruleArray[1].resultOperator = "";
    ruleArray[1].resultValue = 1;

    ruleArray.push(new rule());
    ruleArray[2].name = "GameOfLifeRule3";
    ruleArray[2].ruleDesc = "Over Crowding";
    ruleArray[2].enabled = true;

    ruleArray[2].ruleCond = new condition();
    ruleArray[2].ruleCond.isNot = false;
    ruleArray[2].ruleCond.conditionOperation = "SUM";
    ruleArray[2].ruleCond.conditionNeighbours = "000000000000010000000000000";
    ruleArray[2].ruleCond.conditionOperand = "==";
    ruleArray[2].ruleCond.compareValueOne = 1;
    ruleArray[2].ruleCond.compareValueTwo = null;

    ruleArray[2].RuleCondAND = new condition();
    ruleArray[2].RuleCondAND.isNot = false;
    ruleArray[2].RuleCondAND.conditionOperation = "SUM";
    ruleArray[2].RuleCondAND.conditionNeighbours = "111111111111101111111111111";
    ruleArray[2].RuleCondAND.conditionOperand = ">";
    ruleArray[2].RuleCondAND.compareValueOne = 3;
    ruleArray[2].RuleCondAND.compareValueTwo = null;

    ruleArray[2].resultOperand = "";
    ruleArray[2].resultOperator = "";
    ruleArray[2].resultValue = 0;

    ruleArray.push(new rule());
    ruleArray[3].name = "GameOfLifeRule4";
    ruleArray[3].ruleDesc = "Reproduction";
    ruleArray[3].enabled = true;

    ruleArray[3].ruleCond = new condition();
    ruleArray[3].ruleCond.isNot = false;
    ruleArray[3].ruleCond.conditionOperation = "SUM";
    ruleArray[3].ruleCond.conditionNeighbours = "000000000000010000000000000";
    ruleArray[3].ruleCond.conditionOperand = "==";
    ruleArray[3].ruleCond.compareValueOne = 0;
    ruleArray[3].ruleCond.compareValueTwo = null;

    ruleArray[3].RuleCondAND = new condition();
    ruleArray[3].RuleCondAND.isNot = false;
    ruleArray[3].RuleCondAND.conditionOperation = "SUM";
    ruleArray[3].RuleCondAND.conditionNeighbours = "111111111111101111111111111";
    ruleArray[3].RuleCondAND.conditionOperand = "==";
    ruleArray[3].RuleCondAND.compareValueOne = 3;
    ruleArray[3].RuleCondAND.compareValueTwo = null;

    ruleArray[3].resultOperand = "";
    ruleArray[3].resultOperator = "";
    ruleArray[3].resultValue = 1;

    worldRules();
    //variables for the layer system
    xbar = new Array();
    ybar = new Array();
    zbar = new Array();
    this.layer = -1;
    this.scene = scene;
    camera = cameras;
    this.play = false;
    var height = 0;
    var group = new THREE.Object3D();
    var geometry = new THREE.CubeGeometry(1.5, 1.5, 1.5);
    var material = new THREE.MeshBasicMaterial({ color: 0xFFFFFF,
        ambient: 0x808080,
        specular: 0xffffff,
        shininess: 20,
        transparent: true,
        opacity: 0.05});
    this.makeGrid = function () {
        var zSize = 0;
        var xSize = 0;
        var ySize = 0;
        //getting sizes of world
        for (var z = 0; z < coordinate.length; z++) {
            if (zSize < coordinate[z].coordinateZ)
                zSize = coordinate[z].coordinateZ;

            if (xSize < coordinate[z].coordinateX)
                xSize = coordinate[z].coordinateX;

            if (ySize < coordinate[z].coordinateY)
                ySize = coordinate[z].coordinateY;
        }
        zSize++;
        xSize++;
        ySize++;
        tmx = xSize;
        tmz = zSize;
        tmy = ySize;
        cellArray = new Array();
        for (var z = 0; z < zSize; z++) {
            cellArray [z] = new Array();
            for (var y = 0; y < ySize; y++) {
                cellArray [z][y] = new Array();
            }
        }

        //adding coordinates
        for (var z = 0; z < coordinate.length; z++) {
            var nowz = coordinate[z].coordinateZ;
            var nowx = coordinate[z].coordinateX;
            var nowy = coordinate[z].coordinateY;
            var cubes = new THREE.Mesh(geometry, material.clone());
            cellArray[nowz][nowy][nowx] = new cell(nowx, nowy, nowz, cubes);
            cellArray[nowz][nowy][nowx].cube.position = new THREE.Vector3(nowx * 1.509, nowy * 1.509, nowz * 1.509);
            group.add(cellArray[nowz][nowy][nowx].cube);

        }

        material = new THREE.MeshBasicMaterial({ color: 0x000000,
            ambient: 0x808080,
            specular: 0xffffff,
            shininess: 20,
            opacity: 0.4
        });

        for (var i = 0; i < xSize; i++) {
            material.color.setHex(0x81bf48);
            var cubes = new THREE.Mesh(geometry, material.clone());
            cubes.position = new THREE.Vector3((xSize) * 1.509, i * 1.509, (zSize) * 1.509);
            xbar[i] = cubes;
            group.add(cubes);
        }

        for (var i = 0; i < ySize; i++) {
            material.color.setHex(0x418df2);
            var cubes = new THREE.Mesh(geometry, material.clone());
            cubes.position = new THREE.Vector3(i * 1.509, -1.509, (zSize) * 1.509);
            group.add(cubes);
            ybar[i] = cubes;
        }


        for (var i = 0; i < zSize; i++) {
            material.color.setHex(0xf24623);
            var cubes = new THREE.Mesh(geometry, material.clone());
            cubes.position = new THREE.Vector3((xSize) * 1.509, -1.509, i * 1.509);
            group.add(cubes);
            zbar[i] = cubes;
        }

        material.color.setHex(0xe6f222);
        var cubes = new THREE.Mesh(geometry, material.clone());
        cubes.position = new THREE.Vector3((xSize) * 1.509, -1.509, (zSize) * 1.509);
        group.add(cubes);
        midpoint = cubes;
        this.scene.add(group);

    }

    this.StartAndStop = function () {
        if(this.play == true) {
            var z2 = 0;
            for (var z = 0; z < tmz; z++) {
                var y2 = 0;
                for (var y = 0; y < tmy; y++) {
                    var x2 = 0;
                    for (var x = 0; x < tmx; x++) {
                        for(var rule = 0; rule < ruleArray.length; rule++)	{
                            var satisfied = false;
                            if(ruleArray[rule].enabled)	{
                                if(typeof ruleArray[rule].ruleCond != undefined && ruleArray[rule].ruleCond != null)	{
                                    if(checkCondition(ruleArray[rule].ruleCond,x,y,z))	{
                                        satisfied = true;
                                    }
                                    else if(!checkCondition(ruleArray[rule].ruleCond,x,y,z) && ruleArray[rule].ruleCond.isNot)	{
                                        satisfied = true;
                                    }
                                    else satisfied = false;
                                }
                                if(typeof ruleArray[rule].RuleCondAND != undefined && ruleArray[rule].RuleCondAND != null && satisfied)	{
                                    if(checkCondition(ruleArray[rule].RuleCondAND,x,y,z))	{
                                        satisfied = true
                                    }
                                    else if(!checkCondition(ruleArray[rule].RuleCondAND,x,y,z) && ruleArray[rule].RuleCondAND.isNot && satisfied)	{
                                        satisfied = true;
                                    }
                                    else satisfied = false;
                                }
                                else satisfied = false;
                                if(typeof ruleArray[rule].RuleCondOR != undefined && ruleArray[rule].RuleCondOR != null)	{
                                    if(checkCondition(ruleArray[rule].RuleCondOR,x,y,z))	{
                                        satisfied = true;
                                    }
                                    else if(!checkCondition(ruleArray[rule].RuleCondOR,x,y,z) && ruleArray[rule].RuleCondOR.isNot)	{
                                        satisfied = true;
                                    }
                                    else if(!satisfied)	{
                                        satisfied = false;
                                    }
                                }
                            }
                            if(satisfied)	{
                                cellArray[z][y][x].nextValue = ruleArray[rule].resultValue;
                                satisfied = false;
                                break;
                            }
                        }
                    }
                    x2+=1;
                }
                y2+=1;
            }
            z2+=1;
            for(var z = 0; z < tmz; z++)	{
                for(var y = 0; y < tmy; y++)	{
                    for(var x = 0; x < tmx; x++)	{
                        if(cellArray[z][y][x].value != cellArray[z][y][x].nextValue)
                            cellArray[z][y][x].changeValue();
                    }
                }
            }
        }
    }

    /*Changing of layers, which layer is being viewed and used
     layer = -1 -> The entire world
     layer = 0 -> The bottom most layer of the world, regarding the y-axis*/
    this.changeWorldLayer = function () {
        this.layer++;
        for (var z = 0; z < tmz; z++) {
            for (var y = 0; y < tmz; y++) {
                for (var x = 0; x < tmx; x++) {
                    if (this.layer == -1) {
                        cellArray[z][y][x].invis = true;
                        cellArray[z][y][x].toggleInvis();
                    }
                    else if (this.layer == y) {
                        cellArray[z][y][x].invis = true;
                        cellArray[z][y][x].toggleInvis();
                    }
                    else {
                        cellArray[z][y][x].invis = false;
                        cellArray[z][y][x].toggleInvis();
                    }
                }
            }
        }
        if (this.layer > tmy - 2)
            this.layer = -2;
    }
}

//Boolean to check if mouse button is being clicked
//Used mainly to test for click and drag functionality
var leftMouseClick = false;

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
function mouseUpper(event) {
    leftMouseClick = false;
}

//Calls change state if mouse is moving whilst left mouse button is being held down
//Mouse move event not explicitly being used. This function is triggered when mouse is moved
function mouseDrag() {
    if (leftMouseClick) {
        changeState();
    }
}

/*Finding which cubes intersects with mouse cursor when left mouse button is clicked
 Changing of the state of cube that intersects which is also visible
 This function is only called when left mouse button is clicked*/
function changeState() {
    var vector = new THREE.Vector3(( event.layerX / window.innerWidth ) * 2 - 1, -( event.layerY / window.innerHeight ) * 2 + 1, 0.5);
    projector = new THREE.Projector();
    projector.unprojectVector(vector, camera);

    var raycaster = new THREE.Raycaster(camera.position, vector.sub(camera.position).normalize());
    var tempcolor = document.getElementById("colorValue").value;

    //Finds all elements that are in the position of the cursor
    var intersects = raycaster.intersectObjects(scene.children, true);

    if (this.layer == -1) {
        if (typeof intersects[0] !== 'undefined')
            var tx = Math.floor(intersects[0].object.position.x / 1.5);
        var ty = Math.floor(intersects[0].object.position.y / 1.5);
        var tz = Math.floor(intersects[0].object.position.z / 1.5);

        //Yellow Box - All
        if (tx == tmx && ty < 0 && tz == tmz) {
            for (var z = 0; z < tmz; z++) {
                for (var y = 0; y < tmy; y++) {
                    for (var x = 0; x < tmx; x++) {
                        if (cellArray[z][y][x].invis == true) {
                            cellArray[z][y][x].invis = false;
                            cellArray[z][y][x].toggleInvis();
                        }
                        else if (cellArray[z][y][x].invis == false) {
                            cellArray[z][y][x].invis = true;
                            cellArray[z][y][x].toggleInvis();
                        }
                    }
                }
            }
        }
        //Red Bar   - X
        else if (tx == tmx && ty < 0)
            toggleXLayer(tz);
        //Green Bar - Y
        else if (tx == tmx && tz == tmz)
            toggleYLayer(ty);
        //Blue Bar  - Z
        else if (ty < 0 && tz == tmz)
            toggleZLayer(tx);
        else {

            if(colorsUsed[tempcolor]!=null)
            {
                this.cellArray[tz][ty][tx].cube.material.color.setHex(colorsUsed[tempcolor]);


            }
            else
            {

                colorsUsed[tempcolor]=arryColour[counter];
                colorsUsedName[counter]=tempcolor;

                counter++;

            }worldStates();

        }
    }
    else {
        for (var i = 0; i < intersects.length; i++) {
            if (typeof intersects[i] !== 'undefined') {
                var tx = Math.floor(intersects[i].object.position.x / 1.5);
                var ty = Math.floor(intersects[i].object.position.y / 1.5);
                var tz = Math.floor(intersects[i].object.position.z / 1.5);

                //Yellow Box - All
                if (tx == tmx && ty < 0 && tz == tmz) {

                    for (var z = 0; z < tmz; z++) {
                        for (var y = 0; y < tmy; y++) {
                            for (var x = 0; x < tmx; x++) {
                                if (this.isTrue == true) {
                                    cellArray[z][y][x].invis = false;
                                    cellArray[z][y][x].toggleInvis();
                                }
                                else {
                                    cellArray[z][y][x].invis = true;
                                    cellArray[z][y][x].toggleInvis();
                                }
                            }
                        }
                    }
                    if (this.isTrue == true)
                        this.isTrue = false;
                    else
                        this.isTrue = true;
                    break;
                }
                //Red Bar   - X
                else if (tx == tmx && ty < 0) {
                    toggleXLayer(tz);
                    break;
                }
                //Green Bar - Y
                else if (tx == tmx && tz == tmz) {
                    toggleYLayer(ty);
                    break;
                }
                //Blue Bar  - Z
                else if (ty < 0 && tz == tmz) {
                    toggleZLayer(tx);
                    break;
                }
                else if (this.cellArray[tz][ty][tx].invis == true) {
                    if(colorsUsed[tempcolor]!=null) {
                        this.cellArray[tz][ty][tx].cube.material.color.setHex(colorsUsed[tempcolor]);
                    }
                    else    {
                        colorsUsed[tempcolor]=arryColour[counter];
                        colorsUsedName[counter]=tempcolor;
                        counter++;
                    }
                    worldStates();
                    this.cellArray[tz][ty][tx].cube.material.opacity = 1;
                    this.cellArray[tz][ty][tx].colour = tempcolor;
                    this.cellArray[tz][ty][tx].value = parseInt(tempcolor) ;

                    break;
                }
            }
        }
    }
}
this.isTrue = true;
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

function getSmallestNeighbour(x, y, z, positions, checkValue)	{
    var val;
    if(z - 1 >= 0)	{
        if(y - 1 >= 0 && x - 1 >= 0 && positions.charAt(0) == '1')	{
            if(typeof val == undefined)	{
                val = cellArray[z - 1][y - 1][x - 1].value;
            }
            else if(cellArray[z - 1][y - 1][x - 1].value < val)
                val = cellArray[z - 1][y - 1][x - 1].value;
        }
        if(y + 1 <= tmy - 1 && positions.charAt(19) == '1')	{
            if(typeof val == undefined)	{
                val = cellArray[z - 1][y + 1][x].value;
            }
            else if(cellArray[z - 1][y + 1][x].value < val)
                val = cellArray[z - 1][y + 1][x].value;
        }
        if(y - 1 >= 0  && positions.charAt(1) == '1')	{
            if(typeof val == undefined)	{
                val = cellArray[z - 1][y - 1][x].value;
            }
            else if(cellArray[z - 1][y - 1][x].value < val)
                val = cellArray[z - 1][y - 1][x].value;
        }
        if(x + 1 <= tmx - 1 && positions.charAt(11) == '1')	{
            if(typeof val == undefined)	{
                val = cellArray[z - 1][y][x + 1].value;
            }
            else if(cellArray[z - 1][y][x + 1].value < val)
                val = cellArray[z - 1][y][x + 1].value;
        }
        if(x - 1 >= 0 && positions.charAt(9) == '1')	{
            if(typeof val == undefined)	{
                val = cellArray[z - 1][y][x - 1].value;
            }
            else if(cellArray[z - 1][y][x - 1].value < val)
                val = cellArray[z - 1][y][x - 1].value;
        }
        if(y + 1 <= tmy - 1 && x + 1 <= tmx - 1  && positions.charAt(20) == '1')	{
            if(typeof val == undefined)	{
                val = cellArray[z - 1][y + 1][x + 1].value;
            }
            else if(cellArray[z - 1][y + 1][x + 1].value < val)
                val = cellArray[z - 1][y + 1][x + 1].value;
        }
        if(y + 1 <= tmy - 1 && x - 1 >= 0  && positions.charAt(18) == '1')	{
            if(typeof val == undefined)	{
                val = cellArray[z - 1][y + 1][x - 1].value;
            }
            else if(cellArray[z - 1][y + 1][x - 1].value < val)
                val = cellArray[z - 1][y + 1][x - 1].value;
        }
        if(y - 1 >= 0 && x + 1 <= tmx - 1  && positions.charAt(2) == '1')	{
            if(typeof val == undefined)	{
                val = cellArray[z - 1][y - 1][x + 1].value;
            }
            else if(cellArray[z - 1][y - 1][x + 1].value < val)
                val = cellArray[z - 1][y - 1][x + 1].value;
        }
        if(positions.charAt(10) == '1')	{
            if(typeof val == undefined)	{
                val = cellArray[z - 1][y][x].value;
            }
            else if(cellArray[z - 1][y][x].value < val)
                val = cellArray[z - 1][y][x].value;
        }
    }

    if(z + 1 <= tmz - 1)	{
        if(y + 1 <= tmy - 1 && positions.charAt(25) == '1')	{
            if(typeof val == undefined)	{
                val = cellArray[z + 1][y + 1][x].value;
            }
            else if(cellArray[z + 1][y + 1][x].value < val)
                val = cellArray[z + 1][y + 1][x].value;
        }
        if(y - 1 >= 0  && positions.charAt(7) == '1')	{
            if(typeof val == undefined)	{
                val = cellArray[z + 1][y - 1][x].value;
            }
            else if(cellArray[z + 1][y - 1][x].value < val)
                val = cellArray[z + 1][y - 1][x].value;
        }
        if(x + 1 <= tmx - 1 && positions.charAt(17) == '1')	{
            if(typeof val == undefined)	{
                val = cellArray[z + 1][y][x + 1].value;
            }
            else if(cellArray[z + 1][y][x + 1].value < val)
                val = cellArray[z + 1][y][x + 1].value;
        }
        if(x - 1 >= 0 && positions.charAt(15) == '1')	{
            if(typeof val == undefined)	{
                val = cellArray[z + 1][y][x - 1].value;
            }
            else if(cellArray[z + 1][y][x - 1].value < val)
                val = cellArray[z + 1][y][x - 1].value;
        }
        if(y + 1 <= tmy - 1 && x + 1 <= tmx - 1 && positions.charAt(26) == '1')	{
            if(typeof val == undefined)	{
                val = cellArray[z + 1][y + 1][x + 1].value;
            }
            else if(cellArray[z + 1][y + 1][x + 1].value < val)
                val = cellArray[z + 1][y + 1][x + 1].value;
        }
        if(y - 1 >= 0 && x - 1 >= 0 && positions.charAt(6) == '1')	{
            if(typeof val == undefined)	{
                val = cellArray[z + 1][y - 1][x - 1].value;
            }
            else if(cellArray[z + 1][y - 1][x - 1].value < val)
                val = cellArray[z + 1][y - 1][x - 1].value;
        }
        if(y + 1 <= tmy - 1 && x - 1 >= 0 && positions.charAt(24) == '1')	{
            if(typeof val == undefined)	{
                val = cellArray[z + 1][y + 1][x].value;
            }
            else if(cellArray[z + 1][y + 1][x].value < val)
                val = cellArray[z + 1][y + 1][x].value;
        }
        if(y - 1 >= 0 && x + 1 <= tmx - 1 && positions.charAt(8) == '1')	{
            if(typeof val == undefined)	{
                val = cellArray[z + 1][y - 1][x + 1].value;
            }
            else if(cellArray[z + 1][y - 1][x + 1].value < val)
                val = cellArray[z + 1][y - 1][x + 1].value;
        }
        if(positions.charAt(16) == '1')	{
            if(cellArray[z + 1][y][x].value == checkValue)
                count += 1;
            if(typeof val == undefined)	{
                val = cellArray[z + 1][y][x].value;
            }
            else if(cellArray[z + 1][y][x].value < val)
                val = cellArray[z + 1][y][x].value;
        }
    }

    if(y + 1 <= tmy - 1 && positions.charAt(22) == '1') 	{
        if(typeof val == undefined)	{
            val = cellArray[z][y + 1][x].value;
        }
        else if(cellArray[z][y + 1][x].value < val)
            val = cellArray[z][y + 1][x].value;
    }
    if(y - 1 >= 0 && positions.charAt(4) == '1')	{
        if(typeof val == undefined)	{
            val = cellArray[z][y - 1][x].value;
        }
        else if(cellArray[z][y - 1][x].value < val)
            val = cellArray[z][y - 1][x].value;
    }
    if(x + 1 <= tmx - 1 && positions.charAt(14) == '1')	{
        if(typeof val == undefined)	{
            val = cellArray[z][y][x + 1].value;
        }
        else if(cellArray[z][y][x + 1].value < val)
            val = cellArray[z][y][x + 1].value;
    }
    if(x - 1 >= 0 && positions.charAt(12) == '1')	{
        if(typeof val == undefined)	{
            val = cellArray[z][y][x - 1].value;
        }
        else if(cellArray[z][y][x - 1].value < val)
            val = cellArray[z][y][x - 1].value;
    }
    if(y + 1 <= tmy - 1 && x + 1 <= tmx - 1 && positions.charAt(23) == '1')	{
        if(typeof val == undefined)	{
            val = cellArray[z][y + 1][x + 1].value;
        }
        else if(cellArray[z][y + 1][x + 1].value < val)
            val = cellArray[z][y + 1][x + 1].value;
    }
    if(y - 1 >= 0 && x - 1 >= 0 && positions.charAt(3) == '1')	{
        if(typeof val == undefined)	{
            val = cellArray[z][y - 1][x - 1].value;
        }
        else if(cellArray[z][y - 1][x - 1].value < val)
            val = cellArray[z][y - 1][x - 1].value;
    }
    if(y + 1 <= tmy - 1 && x - 1 >= 0 && positions.charAt(21) == '1')	{
        if(typeof val == undefined)	{
            val = cellArray[z][y + 1][x - 1].value;
        }
        else if(cellArray[z][y + 1][x - 1].value < val)
            val = cellArray[z][y + 1][x - 1].value;
    }
    if(y - 1 >= 0 && x + 1 <= tmx - 1 && positions.charAt(5) == '1')	{
        if(typeof val == undefined)	{
            val = cellArray[z][y - 1][x + 1].value;
        }
        else if(cellArray[z][y - 1][x + 1].value < val)
            val = cellArray[z][y - 1][x + 1].value;
    }
    if(positions.charAt(13) == '1')	{
        if(cellArray[z][y][x].value == checkValue)
            count += 1;
        if(typeof val == undefined)	{
            val = cellArray[z][y][x].value;
        }
        else if(cellArray[z][y][x].value < val)
            val = cellArray[z][y][x].value;
    }
    if(typeof val == undefined)	{
        return null;
    }
    else return val;
}

function getBiggestNeighbour(x, y, z, positions, checkValue)	{
    var val;
    if(z - 1 >= 0)	{
        if(y - 1 >= 0 && x - 1 >= 0 && positions.charAt(0) == '1')	{
            if(typeof val == undefined)	{
                val = cellArray[z - 1][y - 1][x - 1].value;
            }
            else if(cellArray[z - 1][y - 1][x - 1].value > val)
                val = cellArray[z - 1][y - 1][x - 1].value;
        }
        if(y + 1 <= tmy - 1 && positions.charAt(19) == '1')	{
            if(typeof val == undefined)	{
                val = cellArray[z - 1][y + 1][x].value;
            }
            else if(cellArray[z - 1][y + 1][x].value > val)
                val = cellArray[z - 1][y + 1][x].value;
        }
        if(y - 1 >= 0  && positions.charAt(1) == '1')	{
            if(typeof val == undefined)	{
                val = cellArray[z - 1][y - 1][x].value;
            }
            else if(cellArray[z - 1][y - 1][x].value > val)
                val = cellArray[z - 1][y - 1][x].value;
        }
        if(x + 1 <= tmx - 1 && positions.charAt(11) == '1')	{
            if(typeof val == undefined)	{
                val = cellArray[z - 1][y][x + 1].value;
            }
            else if(cellArray[z - 1][y][x + 1].value > val)
                val = cellArray[z - 1][y][x + 1].value;
        }
        if(x - 1 >= 0 && positions.charAt(9) == '1')	{
            if(typeof val == undefined)	{
                val = cellArray[z - 1][y][x - 1].value;
            }
            else if(cellArray[z - 1][y][x - 1].value > val)
                val = cellArray[z - 1][y][x - 1].value;
        }
        if(y + 1 <= tmy - 1 && x + 1 <= tmx - 1  && positions.charAt(20) == '1')	{
            if(typeof val == undefined)	{
                val = cellArray[z - 1][y + 1][x + 1].value;
            }
            else if(cellArray[z - 1][y + 1][x + 1].value > val)
                val = cellArray[z - 1][y + 1][x + 1].value;
        }
        if(y + 1 <= tmy - 1 && x - 1 >= 0  && positions.charAt(18) == '1')	{
            if(typeof val == undefined)	{
                val = cellArray[z - 1][y + 1][x - 1].value;
            }
            else if(cellArray[z - 1][y + 1][x - 1].value > val)
                val = cellArray[z - 1][y + 1][x - 1].value;
        }
        if(y - 1 >= 0 && x + 1 <= tmx - 1  && positions.charAt(2) == '1')	{
            if(typeof val == undefined)	{
                val = cellArray[z - 1][y - 1][x + 1].value;
            }
            else if(cellArray[z - 1][y - 1][x + 1].value > val)
                val = cellArray[z - 1][y - 1][x + 1].value;
        }
        if(positions.charAt(10) == '1')	{
            if(typeof val == undefined)	{
                val = cellArray[z - 1][y][x].value;
            }
            else if(cellArray[z - 1][y][x].value > val)
                val = cellArray[z - 1][y][x].value;
        }
    }

    if(z + 1 <= tmz - 1)	{
        if(y + 1 <= tmy - 1 && positions.charAt(25) == '1')	{
            if(typeof val == undefined)	{
                val = cellArray[z + 1][y + 1][x].value;
            }
            else if(cellArray[z + 1][y + 1][x].value > val)
                val = cellArray[z + 1][y + 1][x].value;
        }
        if(y - 1 >= 0  && positions.charAt(7) == '1')	{
            if(typeof val == undefined)	{
                val = cellArray[z + 1][y - 1][x].value;
            }
            else if(cellArray[z + 1][y - 1][x].value > val)
                val = cellArray[z + 1][y - 1][x].value;
        }
        if(x + 1 <= tmx - 1 && positions.charAt(17) == '1')	{
            if(typeof val == undefined)	{
                val = cellArray[z + 1][y][x + 1].value;
            }
            else if(cellArray[z + 1][y][x + 1].value > val)
                val = cellArray[z + 1][y][x + 1].value;
        }
        if(x - 1 >= 0 && positions.charAt(15) == '1')	{
            if(typeof val == undefined)	{
                val = cellArray[z + 1][y][x - 1].value;
            }
            else if(cellArray[z + 1][y][x - 1].value > val)
                val = cellArray[z + 1][y][x - 1].value;
        }
        if(y + 1 <= tmy - 1 && x + 1 <= tmx - 1 && positions.charAt(26) == '1')	{
            if(typeof val == undefined)	{
                val = cellArray[z + 1][y + 1][x + 1].value;
            }
            else if(cellArray[z + 1][y + 1][x + 1].value > val)
                val = cellArray[z + 1][y + 1][x + 1].value;
        }
        if(y - 1 >= 0 && x - 1 >= 0 && positions.charAt(6) == '1')	{
            if(typeof val == undefined)	{
                val = cellArray[z + 1][y - 1][x - 1].value;
            }
            else if(cellArray[z + 1][y - 1][x - 1].value > val)
                val = cellArray[z + 1][y - 1][x - 1].value;
        }
        if(y + 1 <= tmy - 1 && x - 1 >= 0 && positions.charAt(24) == '1')	{
            if(typeof val == undefined)	{
                val = cellArray[z + 1][y + 1][x].value;
            }
            else if(cellArray[z + 1][y + 1][x].value > val)
                val = cellArray[z + 1][y + 1][x].value;
        }
        if(y - 1 >= 0 && x + 1 <= tmx - 1 && positions.charAt(8) == '1')	{
            if(typeof val == undefined)	{
                val = cellArray[z + 1][y - 1][x + 1].value;
            }
            else if(cellArray[z + 1][y - 1][x + 1].value > val)
                val = cellArray[z + 1][y - 1][x + 1].value;
        }
        if(positions.charAt(16) == '1')	{
            if(cellArray[z + 1][y][x].value == checkValue)
                count += 1;
            if(typeof val == undefined)	{
                val = cellArray[z + 1][y][x].value;
            }
            else if(cellArray[z + 1][y][x].value > val)
                val = cellArray[z + 1][y][x].value;
        }
    }

    if(y + 1 <= tmy - 1 && positions.charAt(22) == '1') 	{
        if(typeof val == undefined)	{
            val = cellArray[z][y + 1][x].value;
        }
        else if(cellArray[z][y + 1][x].value > val)
            val = cellArray[z][y + 1][x].value;
    }
    if(y - 1 >= 0 && positions.charAt(4) == '1')	{
        if(typeof val == undefined)	{
            val = cellArray[z][y - 1][x].value;
        }
        else if(cellArray[z][y - 1][x].value > val)
            val = cellArray[z][y - 1][x].value;
    }
    if(x + 1 <= tmx - 1 && positions.charAt(14) == '1')	{
        if(typeof val == undefined)	{
            val = cellArray[z][y][x + 1].value;
        }
        else if(cellArray[z][y][x + 1].value > val)
            val = cellArray[z][y][x + 1].value;
    }
    if(x - 1 >= 0 && positions.charAt(12) == '1')	{
        if(typeof val == undefined)	{
            val = cellArray[z][y][x - 1].value;
        }
        else if(cellArray[z][y][x - 1].value > val)
            val = cellArray[z][y][x - 1].value;
    }
    if(y + 1 <= tmy - 1 && x + 1 <= tmx - 1 && positions.charAt(23) == '1')	{
        if(typeof val == undefined)	{
            val = cellArray[z][y + 1][x + 1].value;
        }
        else if(cellArray[z][y + 1][x + 1].value > val)
            val = cellArray[z][y + 1][x + 1].value;
    }
    if(y - 1 >= 0 && x - 1 >= 0 && positions.charAt(3) == '1')	{
        if(typeof val == undefined)	{
            val = cellArray[z][y - 1][x - 1].value;
        }
        else if(cellArray[z][y - 1][x - 1].value > val)
            val = cellArray[z][y - 1][x - 1].value;
    }
    if(y + 1 <= tmy - 1 && x - 1 >= 0 && positions.charAt(21) == '1')	{
        if(typeof val == undefined)	{
            val = cellArray[z][y + 1][x - 1].value;
        }
        else if(cellArray[z][y + 1][x - 1].value > val)
            val = cellArray[z][y + 1][x - 1].value;
    }
    if(y - 1 >= 0 && x + 1 <= tmx - 1 && positions.charAt(5) == '1')	{
        if(typeof val == undefined)	{
            val = cellArray[z][y - 1][x + 1].value;
        }
        else if(cellArray[z][y - 1][x + 1].value > val)
            val = cellArray[z][y - 1][x + 1].value;
    }
    if(positions.charAt(13) == '1')	{
        if(cellArray[z][y][x].value == checkValue)
            count += 1;
        if(typeof val == undefined)	{
            val = cellArray[z][y][x].value;
        }
        else if(cellArray[z][y][x].value > val)
            val = cellArray[z][y][x].value;
    }
    if(typeof val == undefined)	{
        return null;
    }
    else return val;
}

function countNeighboursAndCompare(x, y, z, positions, checkValue)	{
    var count = 0;
    if(z - 1 >= 0)	{
        if(y - 1 >= 0 && x - 1 >= 0 && positions.charAt(0) == '1')	{
            if(cellArray[z - 1][y - 1][x - 1].value == checkValue)
                count += 1;
        }
        if(y + 1 <= tmy - 1 && positions.charAt(19) == '1')	{
            if(cellArray[z - 1][y + 1][x].value == checkValue)
                count += 1;
        }
        if(y - 1 >= 0  && positions.charAt(1) == '1')	{
            if(cellArray[z - 1][y - 1][x].value == checkValue)
                count += 1;
        }
        if(x + 1 <= tmx - 1 && positions.charAt(11) == '1')	{
            if(cellArray[z - 1][y][x + 1].value == checkValue)
                count += 1;
        }
        if(x - 1 >= 0 && positions.charAt(9) == '1')	{
            if(cellArray[z - 1][y][x - 1].value == checkValue)
                count += 1;
        }
        if(y + 1 <= tmy - 1 && x + 1 <= tmx - 1  && positions.charAt(20) == '1')	{
            if(cellArray[z - 1][y + 1][x + 1].value == checkValue)
                count += 1;
        }
        if(y + 1 <= tmy - 1 && x - 1 >= 0  && positions.charAt(18) == '1')	{
            if(cellArray[z - 1][y + 1][x - 1].value == checkValue)
                count += 1;
        }
        if(y - 1 >= 0 && x + 1 <= tmx - 1  && positions.charAt(2) == '1')	{
            if(cellArray[z - 1][y - 1][x + 1].value == checkValue)
                count += 1;
        }
        if(positions.charAt(10) == '1')	{
            if(cellArray[z - 1][y][x].value == checkValue)
                count += 1;
        }
    }

    if(z + 1 <= tmz - 1)	{
        if(y + 1 <= tmy - 1 && positions.charAt(25) == '1')	{
            if(cellArray[z + 1][y + 1][x].value == checkValue)
                count += 1;
        }
        if(y - 1 >= 0  && positions.charAt(7) == '1')	{
            if(cellArray[z + 1][y - 1][x].value == checkValue)
                count += 1;
        }
        if(x + 1 <= tmx - 1 && positions.charAt(17) == '1')	{
            if(cellArray[z + 1][y][x + 1].value == checkValue)
                count += 1;
        }
        if(x - 1 >= 0 && positions.charAt(15) == '1')	{
            if(cellArray[z + 1][y][x - 1].value == checkValue)
                count += 1;
        }
        if(y + 1 <= tmy - 1 && x + 1 <= tmx - 1 && positions.charAt(26) == '1')	{
            if(cellArray[z + 1][y + 1][x + 1].value == checkValue)
                count += 1;
        }
        if(y - 1 >= 0 && x - 1 >= 0 && positions.charAt(6) == '1')	{
            if(cellArray[z + 1][y - 1][x - 1].value == checkValue)
                count += 1;
        }
        if(y + 1 <= tmy - 1 && x - 1 >= 0 && positions.charAt(24) == '1')	{
            if(cellArray[z + 1][y + 1][x].value == checkValue)
                count += 1;
        }
        if(y - 1 >= 0 && x + 1 <= tmx - 1 && positions.charAt(8) == '1')	{
            if(cellArray[z + 1][y - 1][x + 1].value == checkValue)
                count += 1;
        }
        if(positions.charAt(16) == '1')	{
            if(cellArray[z + 1][y][x].value == checkValue)
                count += 1;
        }
    }

    if(y + 1 <= tmy - 1 && positions.charAt(22) == '1') 	{
        if(cellArray[z ][y + 1][x].value == checkValue)
            count += 1;
    }
    if(y - 1 >= 0 && positions.charAt(4) == '1')	{
        if(cellArray[z][y - 1][x].value == checkValue)
            count += 1;
    }
    if(x + 1 <= tmx - 1 && positions.charAt(14) == '1')	{
        if(cellArray[z][y][x + 1].value == checkValue)
            count += 1;
    }
    if(x - 1 >= 0 && positions.charAt(12) == '1')	{
        if(cellArray[z][y][x - 1].value == checkValue)
            count += 1;
    }
    if(y + 1 <= tmy - 1 && x + 1 <= tmx - 1 && positions.charAt(23) == '1')	{
        if(cellArray[z][y + 1][x + 1].value == checkValue)
            count += 1;
    }
    if(y - 1 >= 0 && x - 1 >= 0 && positions.charAt(3) == '1')	{
        if(cellArray[z][y - 1][x - 1].value == checkValue)
            count += 1;
    }
    if(y + 1 <= tmy - 1 && x - 1 >= 0 && positions.charAt(21) == '1')	{
        if(cellArray[z][y + 1][x - 1].value == checkValue)
            count += 1;
    }
    if(y - 1 >= 0 && x + 1 <= tmx - 1 && positions.charAt(5) == '1')	{
        if(cellArray[z][y - 1][x + 1].value == checkValue)
            count += 1;
    }
    if(positions.charAt(13) == '1')	{
        if(cellArray[z][y][x].value == checkValue)
            count += 1;
    }
    return count;
}

function sumNeighboursAtPositions(x, y, z, positions)	{
    var count = 0;
    if(z - 1 >= 0)	{
        if(y - 1 >= 0 && x - 1 >= 0 && positions.charAt(0) == '1')
            count += cellArray[z - 1][y - 1][x - 1].value;
        if(y + 1 <= tmy - 1 && positions.charAt(19) == '1')
            count += cellArray[z - 1][y + 1][x].value;
        if(y - 1 >= 0  && positions.charAt(1) == '1')
            count += cellArray[z - 1][y - 1][x].value;
        if(x + 1 <= tmx - 1 && positions.charAt(11) == '1')
            count += cellArray[z - 1][y][x + 1].value;
        if(x - 1 >= 0 && positions.charAt(9) == '1')
            count += cellArray[z - 1][y][x - 1].value;
        if(y + 1 <= tmy - 1 && x + 1 <= tmx - 1  && positions.charAt(20) == '1')
            count += cellArray[z - 1][y + 1][x + 1].value;
        if(y + 1 <= tmy - 1 && x - 1 >= 0  && positions.charAt(18) == '1')
            count += cellArray[z - 1][y + 1][x - 1].value;
        if(y - 1 >= 0 && x + 1 <= tmx - 1  && positions.charAt(2) == '1')
            count += cellArray[z - 1][y - 1][x + 1].value;
        if(positions.charAt(10) == '1')
            count += cellArray[z - 1][y][x].value;
    }

    if(z + 1 <= tmz - 1)	{
        if(y + 1 <= tmy - 1 && positions.charAt(25) == '1')
            count += cellArray[z + 1][y + 1][x].value;
        if(y - 1 >= 0  && positions.charAt(7) == '1')
            count += cellArray[z + 1][y - 1][x].value;
        if(x + 1 <= tmx - 1 && positions.charAt(17) == '1')
            count += cellArray[z + 1][y][x + 1].value;
        if(x - 1 >= 0 && positions.charAt(15) == '1')
            count += cellArray[z + 1][y][x - 1].value;
        if(y + 1 <= tmy - 1 && x + 1 <= tmx - 1 && positions.charAt(26) == '1')
            count += cellArray[z + 1][y + 1][x + 1].value;
        if(y - 1 >= 0 && x - 1 >= 0 && positions.charAt(6) == '1')
            count += cellArray[z + 1][y - 1][x - 1].value;
        if(y + 1 <= tmy - 1 && x - 1 >= 0 && positions.charAt(24) == '1')
            count += cellArray[z + 1][y + 1][x - 1].value;
        if(y - 1 >= 0 && x + 1 <= tmx - 1 && positions.charAt(8) == '1')
            count += cellArray[z + 1][y - 1][x + 1].value;
        if(positions.charAt(16) == '1')
            count += cellArray[z + 1][y][x].value;
    }

    if(y + 1 <= tmy - 1 && positions.charAt(22) == '1')
        count += cellArray[z][y + 1][x].value;
    if(y - 1 >= 0 && positions.charAt(4) == '1')
        count += cellArray[z][y - 1][x].value;
    if(x + 1 <= tmx - 1 && positions.charAt(14) == '1')
        count += cellArray[z][y][x + 1].value;
    if(x - 1 >= 0 && positions.charAt(12) == '1')
        count += cellArray[z][y][x - 1].value;
    if(y + 1 <= tmy - 1 && x + 1 <= tmx - 1 && positions.charAt(23) == '1')
        count += cellArray[z][y + 1][x + 1].value;
    if(y - 1 >= 0 && x - 1 >= 0 && positions.charAt(3) == '1')
        count += cellArray[z][y - 1][x - 1].value;
    if(y + 1 <= tmy - 1 && x - 1 >= 0 && positions.charAt(21) == '1')
        count += cellArray[z][y + 1][x - 1].value;
    if(y - 1 >= 0 && x + 1 <= tmx - 1 && positions.charAt(5) == '1')
        count += cellArray[z][y - 1][x + 1].value;
    if(positions.charAt(13) == '1')
        count += cellArray[z][y][x].value;
    return count;
}

function toggleXLayer(zlayer) {  console.log("1"+zlayer);
    for (var y = 0; y < tmz; y++) {
        for (var x = 0; x < tmx; x++) {
            if (cellArray[zlayer][y][x].invis == true) {
                cellArray[zlayer][y][x].invis = false;
                cellArray[zlayer][y][x].toggleInvis();
            }
            else if (cellArray[zlayer][y][x].invis == false) {
                cellArray[zlayer][y][x].invis = true;
                cellArray[zlayer][y][x].toggleInvis();
            }
        }
    }
}

function toggleYLayer(ylayer) {
    for (var z = 0; z < tmz; z++) {
        for (var x = 0; x < tmx; x++) {
            if (cellArray[z][ylayer][x].invis == true) {
                cellArray[z][ylayer][x].invis = false;
                cellArray[z][ylayer][x].toggleInvis();
            }
            else if (cellArray[z][ylayer][x].invis == false) {
                cellArray[z][ylayer][x].invis = true;
                cellArray[z][ylayer][x].toggleInvis();
            }
        }
    }
}

function toggleZLayer(xlayer) {
    for (var z = 0; z < tmz; z++) {
        for (var y = 0; y < tmy; y++) {
            if (cellArray[z][y][xlayer].invis == true) {
                cellArray[z][y][xlayer].invis = false;
                cellArray[z][y][xlayer].toggleInvis();
            }
            else if (cellArray[z][y][xlayer].invis == false) {
                cellArray[z][y][xlayer].invis = true;
                cellArray[z][y][xlayer].toggleInvis();
            }
        }
    }
}

function hider() {
    for (var i = 0; i < tmz; i++) {
        zbar[i].visible = document.getElementById("z").checked;
    }
    for (var i = 0; i < tmx; i++) {
        xbar[i].visible = document.getElementById("x").checked;
    }
    for (var i = 0; i < tmy; i++) {
        ybar[i].visible = document.getElementById("y").checked;
    }
    midpoint.visible = document.getElementById("mid").checked;
}

function performOperation(neightbours, expected, conditionOperand)	{
    var result = false;
    if(conditionOperand == "==")	{
        if(neightbours == expected)
            result = true;
    }
    else if(conditionOperand == ">")	{
        if(neightbours > expected)
            result = true;
    }
    else if(conditionOperand == "<")	{
        if(neightbours < expected)
            result = true;
    }
    else if(conditionOperand == "<=")	{
        if(neightbours <= expected)
            result = true;
    }
    else if(conditionOperand == ">=")	{
        if(neightbours >= expected)
            result = true;
    }
    return result;
}

function performBetween(neightbours, valueOne, valueTwo)	{
    var result = false;
    if(neightbours > valueOne && neightbours < valueTwo) result = true;
    return result;
}

function worldStates()
{

    var s='<table class="table">';
    for(var i=0;i<counter;i++){
        s+="<tr><td><button  onclick='setColor("+colorsUsedName[i]+")' style="+'"background-color:#'+arryColour[i].substring(2)+'"'+'class="btn btn-default btn-lg" ></button>';
        s+= "<label>   State Value:"+colorsUsedName[i]+"</label></td></tr>";

    }
    s+="</tr></table>";
    document.getElementById("worldState").innerHTML=s;


}
function worldRules()
{


    var s='<table class="table">';
    for(var i=0;i<ruleArray.length;i++){
        s+="<tr><td><button  class='btn btn-default btn-lg' ></button>";
        s+= "<label>"+ ruleArray[i].name+"</label></td></tr>";

    }
    s+="</tr></table>";
    document.getElementById("worldRule").innerHTML=s;



}
function setColor(value)
{

    var tempcolor = document.getElementById("colorValue").value=value;
}

function checkCondition(c,x,y,z)	{
    if(typeof c != null)	{
        if(c.conditionOperand == "BETWEEN")	{
            if(c.conditionOperation == "SUM")	{
                var neightbours = sumNeighboursAtPositions(x,y,z,c.conditionNeighbours);
                return performBetween(neightbours, c.compareValueOne, c.compareValueTwo);
            }
            else if(ruleArray[rule].conditionArray[cond].conditionOperation == "MIN")	{
                var neightbour = getSmallestNeighbour(x,y,z,c.conditionNeighbours);
                return performBetween(neightbour,  c.compareValueOne, c.compareValueTwo);
            }
            else if(ruleArray[rule].conditionArray[cond].conditionOperation == "MAX")	{
                var neightbour = getBiggestNeighbour(x,y,z,c.conditionNeighbours);
                return performBetween(neightbour,  c.compareValueOne, c.compareValueTwo);
            }
        }
        else	{
            if(c.conditionOperation == "SUM")	{
                var neightbours = sumNeighboursAtPositions(x,y,z,c.conditionNeighbours);
                return performOperation(neightbours, c.compareValueOne, c.conditionOperand);
            }
            else if(c.conditionOperation == "COUNT")	{
                var neightbour = countNeighboursAndCompare(x, y, z, c.conditionNeighbours, c.compareValueOne);
                return performOperation(neightbour, c.compareValueTwo, c.conditionOperand);
            }
            else if(c.conditionOperation == "MIN")	{
                var neightbour = getSmallestNeighbour(x,y,z,c.conditionNeighbours);
                return performOperation(neightbour, c.compareValueOne, c.conditionOperand);
            }
            else if(c.conditionOperation == "MAX")	{
                var neightbour = getBiggestNeighbour(x,y,z,c.conditionNeighbours);
                return performOperation(neightbour, c.compareValueOne, c.conditionOperand);
            }
        }
    }
    return false;
}