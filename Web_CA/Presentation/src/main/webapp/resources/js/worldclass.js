this.cellArray;
this.ruleArray = new Array();
this.projector;
this.camera;
this.tmx = 0;
this.tmy = 0;
this.ruleWorldList;
this.tmz = 0;
this.xbar;
this.ybar;
this.zbar;
this.midpoint;
this.colorsUsed = new Array();
this.colorsUsedName = new Array();
this.colourCounter = 0;
this.coordinate;
this.states = "";
this.arryColour;
this.scene;
this.counter = 0;
this.cond1Val;
var site= new config().getSite();
gggg = true;
canvasFocus = true;
tempcolor = 0;
currentGeneration = 0;


//controller to add the coordinates
var web_ca = angular.module('coordinate_app', []);

web_ca.controller("CoordinateManager", function ($scope, $http) {
    val1 = 0;
    val2 = 0;
    val3 = 0;
    val4 = 0;
    val5 = 0;

    var userId = document.getElementById("userId").value;
    var worldId = document.getElementById("worldId").value;
    $scope.SaveCoordinates = function () {


        for (var z = 0; z < coordinate.length; z++) {
            var nowz = parseInt(coordinate[z].coordinateZ);
            var nowx = parseInt(coordinate[z].coordinateX);
            var nowy = parseInt(coordinate[z].coordinateY);
            coordinate[z].value = cellArray[nowz][nowy][nowx].value;

        }



        $http.post("http://" + site + "/saveCoordinates", coordinate)
            .success(function (data) {
                //alert(data);
            }).error(function () {
                alert("USER REGISTER: SERVER ERROR");
            });
        var theworldRules = new Array();
        var thecounter=0;
        for(var i=0;i<ruleArray.length;i++)
        {
            if(ruleArray[i].enabled)
            {
                theworldRules[thecounter]= {ruleId:ruleArray[i].ruleId,worldId:worldId};
                thecounter++;
            }
        }

        $http.post("http://" + site + "/SaveWorldRules", theworldRules)
            .success(function (data) {
               // alert(data);
            }).error(function () {
                document.getElementById("datavalue").innerHTML="<p>World could not be saved</p>";
                $('#Information').modal('show');

            });
    };

    $http.post("http://" + site + "/getCoordinatesByWorldId/", worldId)
        .success(function (data) {
            this.coordinate = data;

        }).error(function () {
            alert("GET COORDINATES: SERVER ERROR");
        });
    if (gggg) {
        $http.post("http://" + site + "/getStateByUserId/", userId)
            .success(function (data) {
                //this.coordinate = data;

                // arryColour = ["0xFFFFFF", "0xFFFF00", "0xFFCCFF", "0xFFCCCC", "0xFFCC99", "0xFFCC66", "0xFFCC33", "0xFFCC00", "0xFF99FF", "0xFF99CC", "0xFF9999", "0xFF9966", "0xFF9933", "0xFF9900", "0xFF66FF", "0xFF66CC", "0xFF6699", "0xFF6666", "0xFF6633", "0xFF6600", "0xFF33FF", "0xFF33CC", "0xFF3399", "0xFF3366", "0xFF3333", "0xFF3300", "0xFF00FF", "0xFF00CC", "0xFF0099", "0xFF0066", "0xFF0033", "0xFF0000", "0x66FFFF", "0x66FFCC", "0x66FF99", "0x66FF66", "0x66FF33", "0x66FF00", "0x66CCFF", "0x66CCCC", "0x66CC99", "0x66CC66", "0x66CC33", "0x66CC00", "0x6699FF", "0x6699CC", "0x669999", "0x669966", "0x669933", "0x669900", "0x6666FF", "0x6666CC", "0x666699", "0x666666", "0x666633", "0x666600", "0x6633FF", "0x6633CC", "0x663399", "0x663366", "0x663333", "0x663300", "0x6600FF", "0x6600CC", "0x660099", "0x660066", "0x660033", "0x660000", "0xCCFFFF", "0xCCFFCC", "0xCCFF99", "0xCCFF66", "0xCCFF33", "0xCCFF00", "0xCCCCFF", "0xCCCCCC", "0xCCCC99", "0xCCCC66", "0xCCCC33", "0xCCCC00", "0xCC99FF", "0xCC99CC", "0xCC9999", "0xCC9966", "0xCC9933", "0xCC9900", "0xCC66FF", "0xCC66CC", "0xCC6699", "0xCC6666", "0xCC6633", "0xCC6600", "0xCC33FF", "0xCC33CC", "0xCC3399", "0xCC3366", "0xCC3333", "0xCC3300", "0xCC00FF", "0xCC00CC", "0xCC0099", "0xCC0066", "0xCC0033", "0xCC0000", "0x33FFFF", "0x33FFCC", "0x33FF99", "0x33FF66", "0x33FF33", "0x33FF00", "0x33CCFF", "0x33CCCC", "0x33CC99", "0x33CC66", "0x33CC33", "0x33CC00", "0x3399FF", "0x3399CC", "0x339999", "0x339966", "0x339933", "0x339900", "0x3366FF", "0x3366CC", "0x336699", "0x336666", "0x336633", "0x336600", "0x3333FF", "0x3333CC", "0x333399", "0x333366", "0x333333", "0x333300", "0x3300FF", "0x3300CC", "0x330099", "0x330066", "0x330033", "0x330000", "0x99FFFF", "0x99FFCC", "0x99FF99", "0x99FF66", "0x99FF33", "0x99FF00", "0x99CCFF", "0x99CCCC", "0x99CC99", "0x99CC66", "0x99CC33", "0x99CC00", "0x9999FF", "0x9999CC", "0x999999", "0x999966", "0x999933", "0x999900", "0x9966FF", "0x9966CC", "0x996699", "0x996666", "0x996633", "0x996600", "0x9933FF", "0x9933CC", "0x993399", "0x993366", "0x993333", "0x993300", "0x9900FF", "0x9900CC", "0x990099", "0x990066", "0x990033", "0x990000", "0x00FFFF", "0x00FFCC", "0x00FF99", "0x00FF66", "0x00FF33", "0x00FF00", "0x00CCFF", "0x00CCCC", "0x00CC99", "0x00CC66", "0x00CC33", "0x00CC00", "0x0099FF", "0x0099CC", "0x009999", "0x009966", "0x009933", "0x009900", "0x0066FF", "0x0066CC", "0x006699", "0x006666", "0x006633", "0x006600", "0x0033FF", "0x0033CC", "0x003399", "0x003366", "0x003333", "0x003300", "0x0000FF", "0x0000CC", "0x000099", "0x000066", "0x000033", "0x000000"];
                arryColour = ["0xFFFFFF", "0xFFFF00", "0xFF33FF", "0xFF9900", "0xFF0000", "0x993300", "0x66FFFF", "0x6666FF", " 0x660066", "0x663300", "0x66FF33", "0x669900"];
                for (var i = (data.length - 1); i >= 0; i--) {
                    arryColour.unshift("0x" + data[i].stateHex.substring(1));
                }
                for (var i = 0; i < data.length; i++) {
                    colorsUsed[data[i].stateValue] = arryColour[counter];
                    colorsUsedName[counter] = data[i].stateValue;
                    counter++;
                }
                colorsUsed[0] = arryColour[counter];
                colorsUsedName[counter] = "0";
                counter++;
            }).error(function () {
                alert("GET States: SERVER ERROR");
            });
        gggg = false;
    }

    $http.post("http://" + site + "/findNeighbours/")
        .success(function (data8) {

          ruleNeighbours=data8;
            //alert(JSON.stringify(data8));
//ruleNeighboursId
            //neighbours
        }).error(function () {
            alert("GET COORDINATES: SERVER ERROR");
     });

    $http.post("http://" + site + "/findRuleByWorldId/", worldId)
        .success(function (data7) {

            ruleWorldList = data7;

        }).error(function () {
            alert("GET COORDINATES: SERVER ERROR");
        });

    $http.post("http://" + site + "/getConditions")
        .success(function (data1) {

            var conditionsList;
            conditionsList=data1;
            $http.post("http://" + site + "/getRuleByUserId", userId)
                .success(function (data) {

                    this.ruleArray = new Array();


                    for (var i = 0; i < data.length; i++) {
                        add1(data[i], i);
                        if (data[i].ruleConId != null) {


                            var con1 = parseInt(data[i].ruleConId);

                            for(var i5 =0;i< conditionsList.length;i5++)
                            {
                                if( parseInt(conditionsList[i5].ruleConditionId)==con1)
                                {
                                    add2(data,conditionsList[i5]);
                                    break;
                                }
                            }
                        }
                        if (data[i].ruleConAndid != null) {

                            var con1 = parseInt(data[i].ruleConAndid);
                            for(var i5 =0;i< conditionsList.length;i5++)
                            {
                                if( parseInt(conditionsList[i5].ruleConditionId)==con1)
                                {
                                    add3(data,conditionsList[i5]);
                                    break;
                                }
                            }
                        }

                        if (data[i].ruleConOrid != null) {

                            var con1 = parseInt(data[i].ruleConOrid);
                            for(var i5 =0;i< conditionsList.length;i5++)
                            {
                                if( parseInt(conditionsList[i5].ruleConditionId)==con1)
                                {
                                    add4(data,conditionsList[i5]);
                                    break;
                                }
                            }
                        }
                        var ruleResid = parseInt(data[i].ruleResId);
                        $http.post("http://" + site + "/getRuleResById", ruleResid)
                            .then(function (data2) {

                                add5(data, data2, i - 1);

                            });


                    }

                }).error(function () {
                    alert("RETRIEVE RULES BY USER ID: SERVER ERROR");
                });
    });





});
var val1 = 0;
var val2 = 0;
var val3 = 0;
var val4 = 0;
var val5 = 0;
function add1(data, i) {
    //alert("1");
   // alert(JSON.stringify(data));
    this.ruleArray.push(new rule());
    this.ruleArray[val1].ruleId = data.ruleId;
    this.ruleArray[val1].ruleName = data.ruleName;
    this.ruleArray[val1].ruleDesc = data.ruleDesc;
    this.ruleArray[val1].enabled = false;
    val1++;
    //alert("t"+JSON.stringify(ruleArray[0]));
}
function add2(data, data1, i) {
    // alert("2");

    for (var i2 = 0; i2 < ruleArray.length; i2++) {
        if (data[i2].ruleConId == data1.ruleConditionId) {
            this.ruleArray[i2].ruleCond = new condition();
            this.ruleArray[i2].ruleCond.isNot = data1.not;
            this.ruleArray[i2].ruleCond.conditionOperation = data1.operation;
            for(var t= 0;t<ruleNeighbours.length;t++)
            {
                if(ruleNeighbours[t].ruleNeighboursId==data1.neighboursId)
                {
                   // alert(ruleNeighbours[t].neighbours);
                    this.ruleArray[i2].ruleCond.conditionNeighbours=ruleNeighbours[t].neighbours.toString();
                }
            }
            this.ruleArray[i2].ruleCond.conditionOperand = data1.operand;
            this.ruleArray[i2].ruleCond.compareValueOne = data1.compareValueOne;
            if (data1.compareValueTwo != 0)
                this.ruleArray[i2].ruleCond.compareValueTwo = data1.compareValueTwo;

        }
    }


}
function add3(data, data1, i) {



    for (var i2 = 0; i2 < ruleArray.length; i2++) {
        if (data[i2].ruleConAndid == data1.ruleConditionId) {

            this.ruleArray[i2].RuleCondAND = new condition();
            this.ruleArray[i2].RuleCondAND.isNot = data1.not;
            this.ruleArray[i2].RuleCondAND.conditionOperation = data1.operation;
            for(var t= 0;t<ruleNeighbours.length;t++)
            {
                if(ruleNeighbours[t].ruleNeighboursId==data1.neighboursId)
                {
                  //  alert(ruleNeighbours[t].neighbours);
                    this.ruleArray[i2].RuleCondAND.conditionNeighbours=ruleNeighbours[t].neighbours.toString();
                }
            }
            this.ruleArray[i2].RuleCondAND.conditionOperand = data1.operand;
            this.ruleArray[i2].RuleCondAND.compareValueOne = data1.compareValueOne;
            if (data1.compareValueTwo != 0)
                this.ruleArray[i2].RuleCondAND.compareValueTwo = data1.compareValueTwo;

        }
    }
    //
}
function addCoordinates()
{

    for (var z = 0; z < coordinate.length; z++) {
        var nowz = coordinate[z].coordinateZ;
        var nowx = coordinate[z].coordinateX;
        var nowy = coordinate[z].coordinateY;
        cellArray[nowz][nowy][nowx].cube.material.opacity=1;
        cellArray[nowz][nowy][nowx].value=coordinate[z].value;

        if(coordinate[z].value!=0)
        {
            cellArray[nowz][nowy][nowx].cube.material.color.setHex(colorsUsed[coordinate[z].value]);
            cellArray[nowz][nowy][nowx].colour = colorsUsed[coordinate[z].value];
            cellArray[nowz][nowy][nowx].cube.material.opacity=1;
        }
        else
        {
            cellArray[nowz][nowy][nowx].cube.material.color.setHex(0xffffff);
            cellArray[nowz][nowy][nowx].colour = "";
            cellArray[nowz][nowy][nowx].cube.material.opacity = 0.03;
        }
    }
}
function add4(data, data1, i) {



    for (var i2 = 0; i2 < ruleArray.length; i2++) {
        if (data[i2].ruleConOrid == data1.ruleConditionId) {

            this.ruleArray[i2].RuleCondOR = new condition();
            this.ruleArray[i2].RuleCondOR.isNot = data1.not;
            this.ruleArray[i2].RuleCondOR.conditionOperation = data1.operation;
            for(var t= 0;t<ruleNeighbours.length;t++)
            {
                if(ruleNeighbours[t].ruleNeighboursId==data1.neighboursId)
                {
                    this.ruleArray[i2].RuleCondOR.conditionNeighbours=ruleNeighbours[t].neighbours.toString();
                }
            }
            this.ruleArray[i2].RuleCondOR.conditionOperand = data1.operand;
            this.ruleArray[i2].RuleCondOR.compareValueOne = data1.compareValueOne;
            if (data1.compareValueTwo != 0)
                this.ruleArray[i2].RuleCondOR.compareValueTwo = data1.compareValueTwo;

        }
    }

}
function add5(data, data1, i) {
    data1 = data1.data;
    //alert(JSON.stringify(data1.neighboursId));
    for (var i2 = 0; i2 < ruleArray.length; i2++) {
        if (data[i2].ruleResId == data1.ruleResultId) {
            ruleArray[i2].resultOperation = data1.operation;
            for(var t= 0;t<ruleNeighbours.length;t++)
            {
                if(ruleNeighbours[t].ruleNeighboursId==data1.neighboursId)
                {
                    //  alert(ruleNeighbours[t].neighbours);
                    ruleArray[i2].resultNeighbours=ruleNeighbours[t].neighbours.toString();
                }
            }
            ruleArray[i2].resultValue = data1.resultValue;


        }
    }


    /*ruleArray[i].resultOperand = "";
     ruleArray[i].resultOperator = "";
     ruleArray[i].resultValue = 0;*/
    //  alert(JSON.stringify(ruleArray[0].resultValue+" "+ruleArray[0].resultValue+" "+ruleArray[0].resultOperator));

}
//function to add world
function world(scene1, cameras) {
    this.Y = "";
    this.X = "";
    this.Z = "";
    //alert(JSON.stringify(ruleArray[4]));
    worldRules();
    //variables for the layer system
    xbar = new Array();
    ybar = new Array();
    zbar = new Array();
    this.layer = -1;
    scene = scene1;
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
        opacity: 0.03});
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
        this.Y = ySize;
        this.X = xSize;
        this.Z = zSize;

        tmx = xSize;
        tmz = zSize;
        this.tmx = xSize;
        this.tmz = zSize;
        this.tmy = ySize;
        tmy = ySize;
        cellArray = new Array();
        for (var z = 0; z < zSize; z++) {
            cellArray [z] = new Array();
            for (var y = 0; y < ySize; y++) {
                cellArray [z][y] = new Array();
            }
        }

        //adding coordinates - RESET
        for (var z = 0; z < coordinate.length; z++) {
            var nowz = coordinate[z].coordinateZ;
            var nowx = coordinate[z].coordinateX;
            var nowy = coordinate[z].coordinateY;

            var cubes = new THREE.Mesh(geometry, material.clone());
            cellArray[nowz][nowy][nowx] = new cell(nowx, nowy, nowz, cubes);
            cellArray[nowz][nowy][nowx].cube.position = new THREE.Vector3(nowx * 1.509, nowy * 1.509, nowz * 1.509);
            cellArray[nowz][nowy][nowx].value = coordinate[z].value;
            // alert(JSON.stringify(coordinate[z]));
            if (coordinate[z].value != 0) {
                if (colorsUsed[coordinate[z].value] == null) {

                    colorsUsed[coordinate[z].value] = arryColour[counter];
                    colorsUsedName[counter] = coordinate[z].value;

                    counter++;

                }
                cellArray[nowz][nowy][nowx].cube.material.color.setHex(colorsUsed[coordinate[z].value]);
                cellArray[nowz][nowy][nowx].colour = colorsUsed[coordinate[z].value];
                cellArray[nowz][nowy][nowx].cube.material.opacity = 1;
            }
            else {
                cellArray[nowz][nowy][nowx].cube.material.color.setHex(0xffffff);
                cellArray[nowz][nowy][nowx].colour = "";
                cellArray[nowz][nowy][nowx].cube.material.opacity = 0.03;
            }
            group.add(cellArray[nowz][nowy][nowx].cube);
        }

        material = new THREE.MeshBasicMaterial({ color: 0x000000,
            ambient: 0x808080,
            specular: 0xffffff,
            shininess: 20,
            opacity: 1
        });

        //Green Bar Creation
        if (ySize > 1) {
            for (var i = 0; i < ySize; i++) {
                material.color.setHex(0x81bf48);
                var cubes = new THREE.Mesh(geometry, material.clone());
                var bar = new barClass(cubes);
                cubes.position = new THREE.Vector3((xSize) * 1.509, i * 1.509, (zSize) * 1.509);
                cubes.scale.x = 0.5;
                cubes.scale.z = 0.5;
                ybar[i] = bar;
                group.add(bar.cube);
            }
        }

        //Blue Bar Creation
        if (xSize > 1) {
            for (var i = 0; i < xSize; i++) {
                material.color.setHex(0x418df2);
                var cubes = new THREE.Mesh(geometry, material.clone());
                var bar = new barClass(cubes);
                cubes.position = new THREE.Vector3(i * 1.509, -1.509, (zSize) * 1.509);
                cubes.scale.y = 0.5;
                cubes.scale.z = 0.5;
                group.add(bar.cube);
                xbar[i] = bar;
            }
        }

        //Red Bar Creation
        if(zSize > 1) {
            for (var i = 0; i < zSize; i++) {
                material.color.setHex(0xf24623);
                var cubes = new THREE.Mesh(geometry, material.clone());
                var bar = new barClass(cubes);
                cubes.position = new THREE.Vector3((xSize) * 1.509, -1.509, i * 1.509);
                cubes.scale.x = 0.5;
                cubes.scale.y = 0.5;
                group.add(bar.cube);
                zbar[i] = bar;
            }
        }

        material.color.setHex(0xe6f222);
        var cubes = new THREE.Mesh(geometry, material.clone());
        var bar = new barClass(cubes);
        cubes.position = new THREE.Vector3((xSize) * 1.509, -1.509, (zSize) * 1.509);
        midpoint = bar;
        group.add(bar.cube);
        scene.add(group);
    }

    this.StartAndStop = function () {
        if (this.play == true) {

            for (var z = 0; z < tmz; z++) {
                for (var y = 0; y < tmy; y++) {
                    for (var x = 0; x < tmx; x++) {
                        for (var rule = 0; rule < ruleArray.length; rule++) {
                            var satisfied = false;
                            if (ruleArray[rule].enabled) {
                                if (typeof ruleArray[rule].ruleCond != undefined && ruleArray[rule].ruleCond != null) {
                                    if (checkCondition(ruleArray[rule].ruleCond, x, y, z)) {
                                        satisfied = true;
                                    }
                                    else if (!checkCondition(ruleArray[rule].ruleCond, x, y, z) && ruleArray[rule].ruleCond.isNot) {
                                        satisfied = true;
                                    }
                                    else satisfied = false;
                                }
                                if (typeof ruleArray[rule].RuleCondAND != undefined && ruleArray[rule].RuleCondAND != null && satisfied) {
                                    if (checkCondition(ruleArray[rule].RuleCondAND, x, y, z)) {
                                        satisfied = true
                                    }
                                    else if (!checkCondition(ruleArray[rule].RuleCondAND, x, y, z) && ruleArray[rule].RuleCondAND.isNot && satisfied) {
                                        satisfied = true;
                                    }
                                    else satisfied = false;
                                }
                                if (typeof ruleArray[rule].RuleCondOR != undefined && ruleArray[rule].RuleCondOR != null) {
                                    if (checkCondition(ruleArray[rule].RuleCondOR, x, y, z)) {
                                        satisfied = true;
                                    }
                                    else if (!checkCondition(ruleArray[rule].RuleCondOR, x, y, z) && ruleArray[rule].RuleCondOR.isNot) {
                                        satisfied = true;
                                    }
                                    else if (!satisfied) {
                                        satisfied = false;
                                    }
                                }
                            }
                            if (satisfied) {
                                if (typeof ruleArray[rule].resultValue != undefined && ruleArray[rule].resultValue != null) {
                                    cellArray[z][y][x].nextValue = ruleArray[rule].resultValue;
                                } else if (typeof ruleArray[rule].resultOperation != undefined && ruleArray[rule].resultOperation != null) {
                                    if (ruleArray[rule].resultOperation == "SUM") {
                                        cellArray[z][y][x].nextValue = sumNeighboursAtPositions(x, y, z, ruleArray[rule].resultNeighbours);
                                    }
                                    else if (c.resultOperation == "MIN") {
                                        cellArray[z][y][x].nextValue = getSmallestNeighbour(x, y, z, ruleArray[rule].resultNeighbours);
                                    }
                                    else if (c.resultOperation == "MAX") {
                                        cellArray[z][y][x].nextValue = getBiggestNeighbour(x, y, z, ruleArray[rule].resultNeighbours);
                                    }
                                    else if (c.resultOperation == "AVG") {
                                        cellArray[z][y][x].nextValue = getAverage(x, y, z, ruleArray[rule].resultNeighbours);
                                    }
                                }
                                cellArray[z][y][x].triggerChange = true;
                                satisfied = false;
                                break;
                            }
                        }
                    }
                }
            }
            for (var z = 0; z < tmz; z++) {
                for (var y = 0; y < tmy; y++) {
                    for (var x = 0; x < tmx; x++) {
                        if (cellArray[z][y][x].triggerChange) {
                            if (colorsUsed[cellArray[z][y][x].nextValue] == null){

                                colorsUsed[cellArray[z][y][x].nextValue] = arryColour[counter];
                                colorsUsedName[counter] = cellArray[z][y][x].nextValue;

                                counter++;

                            }
                            cellArray[z][y][x].changeValue(colorsUsed[cellArray[z][y][x].nextValue]);
                        }
                    }
                }
            }
        }
        currentGeneration++;
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
    if (event.button == 0 && canvasFocus) {
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
    if (leftMouseClick && canvasFocus) {
        changeState();
    }
    else if(!leftMouseClick && canvasFocus)    {
        clearHover();
        mouseOverChange();
    }
}

function clearHover()   {
    if(tmx > 1 || tmy > 1 || tmz > 1)
        for (var z = 0; z < tmz; z++) {
            for (var y = 0; y < tmy; y++) {
                for (var x = 0; x < tmx; x++) {
                    cellArray[z][y][x].resetHover();
                }
            }
        }
}

/*Finding which cubes intersects with mouse cursor when left mouse button is clicked
 Changing of the state of cube that intersects which is also visible
 This function is only called when left mouse button is clicked*/
function changeState() {
    if(typeof camera != 'undefined')
    {
    var vector = new THREE.Vector3(( event.layerX / window.innerWidth ) * 2 - 1, -( event.layerY / window.innerHeight ) * 2 + 1, 0.5);
    projector = new THREE.Projector();
    projector.unprojectVector(vector, camera);

    var raycaster = new THREE.Raycaster(camera.position, vector.sub(camera.position).normalize());
    if (document.getElementById("colorValue") != null)
        tempcolor = document.getElementById("colorValue").value;

    //Finds all elements that are in the position of the cursor
    var intersects = raycaster.intersectObjects(scene.children, true);

    if (this.layer == -1) {
        if (typeof intersects[0] !== 'undefined')
            var tx = Math.floor(intersects[0].object.position.x / 1.5);
        var ty = Math.floor(intersects[0].object.position.y / 1.5);
        var tz = Math.floor(intersects[0].object.position.z / 1.5);

        //Yellow Box - All

        if (tx == tmx && ty < 0 && tz == tmz && $("#mid").checked) {
                midpoint.toggleVisible();
                for (var z = 0; z < tmz; z++) {
                    if (zbar[z].active)
                        continue;
                    for (var y = 0; y < tmy; y++) {
                        if (ybar[y].active)
                            continue;
                        for (var x = 0; x < tmx; x++) {
                            if (xbar[x].active)
                                continue;
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
        //Red Bar   - Z
        else if (tx == tmx && ty < 0 && $("#z").checked) {
            toggleZLayer(tz);
            zbar[tz].toggleVisible();
        }
        //Green Bar - Y
        else if (tx == tmx && tz == tmz  && $("#y").checked) {
            toggleYLayer(ty);
            ybar[ty].toggleVisible();
        }
        //Blue Bar  - Z
        else if (ty < 0 && tz == tmz  && $("#x").checked) {
            toggleXLayer(tx);
            xbar[tx].toggleVisible();
        }
        else if (this.cellArray[tz][ty][tx].invis == true) {
            colour($("#Brush_Size").val(),tx,ty,tz,false);
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
                    if(!$("#mid").is(":checked"))
                        continue;
                    midpoint.toggleVisible();
                    for (var z = 0; z < tmz; z++) {
                        if(zbar[z].active)
                            continue;
                        for (var y = 0; y < tmy; y++) {
                            if(ybar[y].active)
                                continue;
                            for (var x = 0; x < tmx; x++) {
                                if(xbar[x].active)
                                    continue;
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
                    if (this.isTrue == true)
                        this.isTrue = false;
                    else
                        this.isTrue = true;
                    break;
                }
                //Red Bar   - Z
                else if (tx == tmx && ty < 0) {
                    if(!$("#z").is(":checked"))
                        continue;
                    toggleZLayer(tz);
                    zbar[tz].toggleVisible();
                    break;
                }
                //Green Bar - Y
                else if (tx == tmx && tz == tmz) {
                    if(!$("#y").is(":checked"))
                        continue;
                    toggleYLayer(ty);
                    ybar[ty].toggleVisible();
                    break;
                }
                //Blue Bar  - Z
                else if (ty < 0 && tz == tmz) {
                    if(!$("#x").is(":checked"))
                        continue;
                    toggleXLayer(tx);
                    xbar[tx].toggleVisible();
                    break;
                }
                else if (this.cellArray[tz][ty][tx].invis == true) {
                    colour($("#Brush_Size").val(),tx,ty,tz,false);
                    break;
                }
            }
        }
    }}
}
this.isTrue = true;

function mouseOverChange() {
    if(typeof camera != 'undefined')
    {
        var vector = new THREE.Vector3(( event.layerX / window.innerWidth ) * 2 - 1, -( event.layerY / window.innerHeight ) * 2 + 1, 0.5);
        projector = new THREE.Projector();
        projector.unprojectVector(vector, camera);

        var raycaster = new THREE.Raycaster(camera.position, vector.sub(camera.position).normalize());
        if (document.getElementById("colorValue") != null)
            tempcolor = document.getElementById("colorValue").value;

        //Finds all elements that are in the position of the cursor
        var intersects = raycaster.intersectObjects(scene.children, true);

        if (this.layer == -1) {
            if (typeof intersects[0] !== 'undefined')
                var tx = Math.floor(intersects[0].object.position.x / 1.5);
            var ty = Math.floor(intersects[0].object.position.y / 1.5);
            var tz = Math.floor(intersects[0].object.position.z / 1.5);

            if (this.cellArray[tz][ty][tx].invis == true) {
                colour($("#Brush_Size").val(),tx,ty,tz,true);
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
                        continue;
                    }
                    //Red Bar   - Z
                    else if (tx == tmx && ty < 0) {
                        continue;
                    }
                    //Green Bar - Y
                    else if (tx == tmx && tz == tmz) {
                        continue;
                    }
                    //Blue Bar  - Z
                    else if (ty < 0 && tz == tmz) {
                        continue;
                    }
                    else if (this.cellArray[tz][ty][tx].invis == true) {
                        colour($("#Brush_Size").val(),tx,ty,tz,true);
                        break;
                    }
                }
            }
        }}
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

function getAverage(x, y, z, positions) {
    var count = 0;
    if (z - 1 >= 0) {
        if (y - 1 >= 0 && x - 1 >= 0 && positions.charAt(0) == '1') {
                count += 1;
        }
        if (y + 1 <= tmy - 1 && positions.charAt(19) == '1') {
                count += 1;
        }
        if (y - 1 >= 0 && positions.charAt(1) == '1') {
                count += 1;
        }
        if (x + 1 <= tmx - 1 && positions.charAt(11) == '1') {
                count += 1;
        }
        if (x - 1 >= 0 && positions.charAt(9) == '1') {
                count += 1;
        }
        if (y + 1 <= tmy - 1 && x + 1 <= tmx - 1 && positions.charAt(20) == '1') {
                count += 1;
        }
        if (y + 1 <= tmy - 1 && x - 1 >= 0 && positions.charAt(18) == '1') {
                count += 1;
        }
        if (y - 1 >= 0 && x + 1 <= tmx - 1 && positions.charAt(2) == '1') {
                count += 1;
        }
        if (positions.charAt(10) == '1') {
                count += 1;
        }
    }

    if (z + 1 <= tmz - 1) {
        if (y + 1 <= tmy - 1 && positions.charAt(25) == '1') {
                count += 1;
        }
        if (y - 1 >= 0 && positions.charAt(7) == '1') {
                count += 1;
        }
        if (x + 1 <= tmx - 1 && positions.charAt(17) == '1') {
                count += 1;
        }
        if (x - 1 >= 0 && positions.charAt(15) == '1') {
                count += 1;
        }
        if (y + 1 <= tmy - 1 && x + 1 <= tmx - 1 && positions.charAt(26) == '1') {
                count += 1;
        }
        if (y - 1 >= 0 && x - 1 >= 0 && positions.charAt(6) == '1') {
                count += 1;
        }
        if (y + 1 <= tmy - 1 && x - 1 >= 0 && positions.charAt(24) == '1') {
                count += 1;
        }
        if (y - 1 >= 0 && x + 1 <= tmx - 1 && positions.charAt(8) == '1') {
                count += 1;
        }
        if (positions.charAt(16) == '1') {
                count += 1;
        }
    }

    if (y + 1 <= tmy - 1 && positions.charAt(22) == '1') {
            count += 1;
    }
    if (y - 1 >= 0 && positions.charAt(4) == '1') {
            count += 1;
    }
    if (x + 1 <= tmx - 1 && positions.charAt(14) == '1') {
            count += 1;
    }
    if (x - 1 >= 0 && positions.charAt(12) == '1') {
            count += 1;
    }
    if (y + 1 <= tmy - 1 && x + 1 <= tmx - 1 && positions.charAt(23) == '1') {
            count += 1;
    }
    if (y - 1 >= 0 && x - 1 >= 0 && positions.charAt(3) == '1') {
            count += 1;
    }
    if (y + 1 <= tmy - 1 && x - 1 >= 0 && positions.charAt(21) == '1') {
            count += 1;
    }
    if (y - 1 >= 0 && x + 1 <= tmx - 1 && positions.charAt(5) == '1') {
            count += 1;
    }
    if (positions.charAt(13) == '1') {
            count += 1;
    }
    return (sumNeighboursAtPositions(x, y, z, positions) / count);
}

function getSmallestNeighbour(x, y, z, positions, checkValue) {
    var val;
    if (z - 1 >= 0) {
        if (y - 1 >= 0 && x - 1 >= 0 && positions.charAt(0) == '1') {
            if (typeof val == undefined) {
                val = cellArray[z - 1][y - 1][x - 1].value;
            }
            else if (cellArray[z - 1][y - 1][x - 1].value < val)
                val = cellArray[z - 1][y - 1][x - 1].value;
        }
        if (y + 1 <= tmy - 1 && positions.charAt(19) == '1') {
            if (typeof val == undefined) {
                val = cellArray[z - 1][y + 1][x].value;
            }
            else if (cellArray[z - 1][y + 1][x].value < val)
                val = cellArray[z - 1][y + 1][x].value;
        }
        if (y - 1 >= 0 && positions.charAt(1) == '1') {
            if (typeof val == undefined) {
                val = cellArray[z - 1][y - 1][x].value;
            }
            else if (cellArray[z - 1][y - 1][x].value < val)
                val = cellArray[z - 1][y - 1][x].value;
        }
        if (x + 1 <= tmx - 1 && positions.charAt(11) == '1') {
            if (typeof val == undefined) {
                val = cellArray[z - 1][y][x + 1].value;
            }
            else if (cellArray[z - 1][y][x + 1].value < val)
                val = cellArray[z - 1][y][x + 1].value;
        }
        if (x - 1 >= 0 && positions.charAt(9) == '1') {
            if (typeof val == undefined) {
                val = cellArray[z - 1][y][x - 1].value;
            }
            else if (cellArray[z - 1][y][x - 1].value < val)
                val = cellArray[z - 1][y][x - 1].value;
        }
        if (y + 1 <= tmy - 1 && x + 1 <= tmx - 1 && positions.charAt(20) == '1') {
            if (typeof val == undefined) {
                val = cellArray[z - 1][y + 1][x + 1].value;
            }
            else if (cellArray[z - 1][y + 1][x + 1].value < val)
                val = cellArray[z - 1][y + 1][x + 1].value;
        }
        if (y + 1 <= tmy - 1 && x - 1 >= 0 && positions.charAt(18) == '1') {
            if (typeof val == undefined) {
                val = cellArray[z - 1][y + 1][x - 1].value;
            }
            else if (cellArray[z - 1][y + 1][x - 1].value < val)
                val = cellArray[z - 1][y + 1][x - 1].value;
        }
        if (y - 1 >= 0 && x + 1 <= tmx - 1 && positions.charAt(2) == '1') {
            if (typeof val == undefined) {
                val = cellArray[z - 1][y - 1][x + 1].value;
            }
            else if (cellArray[z - 1][y - 1][x + 1].value < val)
                val = cellArray[z - 1][y - 1][x + 1].value;
        }
        if (positions.charAt(10) == '1') {
            if (typeof val == undefined) {
                val = cellArray[z - 1][y][x].value;
            }
            else if (cellArray[z - 1][y][x].value < val)
                val = cellArray[z - 1][y][x].value;
        }
    }

    if (z + 1 <= tmz - 1) {
        if (y + 1 <= tmy - 1 && positions.charAt(25) == '1') {
            if (typeof val == undefined) {
                val = cellArray[z + 1][y + 1][x].value;
            }
            else if (cellArray[z + 1][y + 1][x].value < val)
                val = cellArray[z + 1][y + 1][x].value;
        }
        if (y - 1 >= 0 && positions.charAt(7) == '1') {
            if (typeof val == undefined) {
                val = cellArray[z + 1][y - 1][x].value;
            }
            else if (cellArray[z + 1][y - 1][x].value < val)
                val = cellArray[z + 1][y - 1][x].value;
        }
        if (x + 1 <= tmx - 1 && positions.charAt(17) == '1') {
            if (typeof val == undefined) {
                val = cellArray[z + 1][y][x + 1].value;
            }
            else if (cellArray[z + 1][y][x + 1].value < val)
                val = cellArray[z + 1][y][x + 1].value;
        }
        if (x - 1 >= 0 && positions.charAt(15) == '1') {
            if (typeof val == undefined) {
                val = cellArray[z + 1][y][x - 1].value;
            }
            else if (cellArray[z + 1][y][x - 1].value < val)
                val = cellArray[z + 1][y][x - 1].value;
        }
        if (y + 1 <= tmy - 1 && x + 1 <= tmx - 1 && positions.charAt(26) == '1') {
            if (typeof val == undefined) {
                val = cellArray[z + 1][y + 1][x + 1].value;
            }
            else if (cellArray[z + 1][y + 1][x + 1].value < val)
                val = cellArray[z + 1][y + 1][x + 1].value;
        }
        if (y - 1 >= 0 && x - 1 >= 0 && positions.charAt(6) == '1') {
            if (typeof val == undefined) {
                val = cellArray[z + 1][y - 1][x - 1].value;
            }
            else if (cellArray[z + 1][y - 1][x - 1].value < val)
                val = cellArray[z + 1][y - 1][x - 1].value;
        }
        if (y + 1 <= tmy - 1 && x - 1 >= 0 && positions.charAt(24) == '1') {
            if (typeof val == undefined) {
                val = cellArray[z + 1][y + 1][x].value;
            }
            else if (cellArray[z + 1][y + 1][x].value < val)
                val = cellArray[z + 1][y + 1][x].value;
        }
        if (y - 1 >= 0 && x + 1 <= tmx - 1 && positions.charAt(8) == '1') {
            if (typeof val == undefined) {
                val = cellArray[z + 1][y - 1][x + 1].value;
            }
            else if (cellArray[z + 1][y - 1][x + 1].value < val)
                val = cellArray[z + 1][y - 1][x + 1].value;
        }
        if (positions.charAt(16) == '1') {
            if (cellArray[z + 1][y][x].value == checkValue)
                count += 1;
            if (typeof val == undefined) {
                val = cellArray[z + 1][y][x].value;
            }
            else if (cellArray[z + 1][y][x].value < val)
                val = cellArray[z + 1][y][x].value;
        }
    }

    if (y + 1 <= tmy - 1 && positions.charAt(22) == '1') {
        if (typeof val == undefined) {
            val = cellArray[z][y + 1][x].value;
        }
        else if (cellArray[z][y + 1][x].value < val)
            val = cellArray[z][y + 1][x].value;
    }
    if (y - 1 >= 0 && positions.charAt(4) == '1') {
        if (typeof val == undefined) {
            val = cellArray[z][y - 1][x].value;
        }
        else if (cellArray[z][y - 1][x].value < val)
            val = cellArray[z][y - 1][x].value;
    }
    if (x + 1 <= tmx - 1 && positions.charAt(14) == '1') {
        if (typeof val == undefined) {
            val = cellArray[z][y][x + 1].value;
        }
        else if (cellArray[z][y][x + 1].value < val)
            val = cellArray[z][y][x + 1].value;
    }
    if (x - 1 >= 0 && positions.charAt(12) == '1') {
        if (typeof val == undefined) {
            val = cellArray[z][y][x - 1].value;
        }
        else if (cellArray[z][y][x - 1].value < val)
            val = cellArray[z][y][x - 1].value;
    }
    if (y + 1 <= tmy - 1 && x + 1 <= tmx - 1 && positions.charAt(23) == '1') {
        if (typeof val == undefined) {
            val = cellArray[z][y + 1][x + 1].value;
        }
        else if (cellArray[z][y + 1][x + 1].value < val)
            val = cellArray[z][y + 1][x + 1].value;
    }
    if (y - 1 >= 0 && x - 1 >= 0 && positions.charAt(3) == '1') {
        if (typeof val == undefined) {
            val = cellArray[z][y - 1][x - 1].value;
        }
        else if (cellArray[z][y - 1][x - 1].value < val)
            val = cellArray[z][y - 1][x - 1].value;
    }
    if (y + 1 <= tmy - 1 && x - 1 >= 0 && positions.charAt(21) == '1') {
        if (typeof val == undefined) {
            val = cellArray[z][y + 1][x - 1].value;
        }
        else if (cellArray[z][y + 1][x - 1].value < val)
            val = cellArray[z][y + 1][x - 1].value;
    }
    if (y - 1 >= 0 && x + 1 <= tmx - 1 && positions.charAt(5) == '1') {
        if (typeof val == undefined) {
            val = cellArray[z][y - 1][x + 1].value;
        }
        else if (cellArray[z][y - 1][x + 1].value < val)
            val = cellArray[z][y - 1][x + 1].value;
    }
    if (positions.charAt(13) == '1') {
        if (cellArray[z][y][x].value == checkValue)
            count += 1;
        if (typeof val == undefined) {
            val = cellArray[z][y][x].value;
        }
        else if (cellArray[z][y][x].value < val)
            val = cellArray[z][y][x].value;
    }
    if (typeof val == undefined) {
        return null;
    }
    else return val;
}

function getBiggestNeighbour(x, y, z, positions, checkValue) {
    var val;
    if (z - 1 >= 0) {
        if (y - 1 >= 0 && x - 1 >= 0 && positions.charAt(0) == '1') {
            if (typeof val == undefined) {
                val = cellArray[z - 1][y - 1][x - 1].value;
            }
            else if (cellArray[z - 1][y - 1][x - 1].value > val)
                val = cellArray[z - 1][y - 1][x - 1].value;
        }
        if (y + 1 <= tmy - 1 && positions.charAt(19) == '1') {
            if (typeof val == undefined) {
                val = cellArray[z - 1][y + 1][x].value;
            }
            else if (cellArray[z - 1][y + 1][x].value > val)
                val = cellArray[z - 1][y + 1][x].value;
        }
        if (y - 1 >= 0 && positions.charAt(1) == '1') {
            if (typeof val == undefined) {
                val = cellArray[z - 1][y - 1][x].value;
            }
            else if (cellArray[z - 1][y - 1][x].value > val)
                val = cellArray[z - 1][y - 1][x].value;
        }
        if (x + 1 <= tmx - 1 && positions.charAt(11) == '1') {
            if (typeof val == undefined) {
                val = cellArray[z - 1][y][x + 1].value;
            }
            else if (cellArray[z - 1][y][x + 1].value > val)
                val = cellArray[z - 1][y][x + 1].value;
        }
        if (x - 1 >= 0 && positions.charAt(9) == '1') {
            if (typeof val == undefined) {
                val = cellArray[z - 1][y][x - 1].value;
            }
            else if (cellArray[z - 1][y][x - 1].value > val)
                val = cellArray[z - 1][y][x - 1].value;
        }
        if (y + 1 <= tmy - 1 && x + 1 <= tmx - 1 && positions.charAt(20) == '1') {
            if (typeof val == undefined) {
                val = cellArray[z - 1][y + 1][x + 1].value;
            }
            else if (cellArray[z - 1][y + 1][x + 1].value > val)
                val = cellArray[z - 1][y + 1][x + 1].value;
        }
        if (y + 1 <= tmy - 1 && x - 1 >= 0 && positions.charAt(18) == '1') {
            if (typeof val == undefined) {
                val = cellArray[z - 1][y + 1][x - 1].value;
            }
            else if (cellArray[z - 1][y + 1][x - 1].value > val)
                val = cellArray[z - 1][y + 1][x - 1].value;
        }
        if (y - 1 >= 0 && x + 1 <= tmx - 1 && positions.charAt(2) == '1') {
            if (typeof val == undefined) {
                val = cellArray[z - 1][y - 1][x + 1].value;
            }
            else if (cellArray[z - 1][y - 1][x + 1].value > val)
                val = cellArray[z - 1][y - 1][x + 1].value;
        }
        if (positions.charAt(10) == '1') {
            if (typeof val == undefined) {
                val = cellArray[z - 1][y][x].value;
            }
            else if (cellArray[z - 1][y][x].value > val)
                val = cellArray[z - 1][y][x].value;
        }
    }

    if (z + 1 <= tmz - 1) {
        if (y + 1 <= tmy - 1 && positions.charAt(25) == '1') {
            if (typeof val == undefined) {
                val = cellArray[z + 1][y + 1][x].value;
            }
            else if (cellArray[z + 1][y + 1][x].value > val)
                val = cellArray[z + 1][y + 1][x].value;
        }
        if (y - 1 >= 0 && positions.charAt(7) == '1') {
            if (typeof val == undefined) {
                val = cellArray[z + 1][y - 1][x].value;
            }
            else if (cellArray[z + 1][y - 1][x].value > val)
                val = cellArray[z + 1][y - 1][x].value;
        }
        if (x + 1 <= tmx - 1 && positions.charAt(17) == '1') {
            if (typeof val == undefined) {
                val = cellArray[z + 1][y][x + 1].value;
            }
            else if (cellArray[z + 1][y][x + 1].value > val)
                val = cellArray[z + 1][y][x + 1].value;
        }
        if (x - 1 >= 0 && positions.charAt(15) == '1') {
            if (typeof val == undefined) {
                val = cellArray[z + 1][y][x - 1].value;
            }
            else if (cellArray[z + 1][y][x - 1].value > val)
                val = cellArray[z + 1][y][x - 1].value;
        }
        if (y + 1 <= tmy - 1 && x + 1 <= tmx - 1 && positions.charAt(26) == '1') {
            if (typeof val == undefined) {
                val = cellArray[z + 1][y + 1][x + 1].value;
            }
            else if (cellArray[z + 1][y + 1][x + 1].value > val)
                val = cellArray[z + 1][y + 1][x + 1].value;
        }
        if (y - 1 >= 0 && x - 1 >= 0 && positions.charAt(6) == '1') {
            if (typeof val == undefined) {
                val = cellArray[z + 1][y - 1][x - 1].value;
            }
            else if (cellArray[z + 1][y - 1][x - 1].value > val)
                val = cellArray[z + 1][y - 1][x - 1].value;
        }
        if (y + 1 <= tmy - 1 && x - 1 >= 0 && positions.charAt(24) == '1') {
            if (typeof val == undefined) {
                val = cellArray[z + 1][y + 1][x].value;
            }
            else if (cellArray[z + 1][y + 1][x].value > val)
                val = cellArray[z + 1][y + 1][x].value;
        }
        if (y - 1 >= 0 && x + 1 <= tmx - 1 && positions.charAt(8) == '1') {
            if (typeof val == undefined) {
                val = cellArray[z + 1][y - 1][x + 1].value;
            }
            else if (cellArray[z + 1][y - 1][x + 1].value > val)
                val = cellArray[z + 1][y - 1][x + 1].value;
        }
        if (positions.charAt(16) == '1') {
            if (cellArray[z + 1][y][x].value == checkValue)
                count += 1;
            if (typeof val == undefined) {
                val = cellArray[z + 1][y][x].value;
            }
            else if (cellArray[z + 1][y][x].value > val)
                val = cellArray[z + 1][y][x].value;
        }
    }

    if (y + 1 <= tmy - 1 && positions.charAt(22) == '1') {
        if (typeof val == undefined) {
            val = cellArray[z][y + 1][x].value;
        }
        else if (cellArray[z][y + 1][x].value > val)
            val = cellArray[z][y + 1][x].value;
    }
    if (y - 1 >= 0 && positions.charAt(4) == '1') {
        if (typeof val == undefined) {
            val = cellArray[z][y - 1][x].value;
        }
        else if (cellArray[z][y - 1][x].value > val)
            val = cellArray[z][y - 1][x].value;
    }
    if (x + 1 <= tmx - 1 && positions.charAt(14) == '1') {
        if (typeof val == undefined) {
            val = cellArray[z][y][x + 1].value;
        }
        else if (cellArray[z][y][x + 1].value > val)
            val = cellArray[z][y][x + 1].value;
    }
    if (x - 1 >= 0 && positions.charAt(12) == '1') {
        if (typeof val == undefined) {
            val = cellArray[z][y][x - 1].value;
        }
        else if (cellArray[z][y][x - 1].value > val)
            val = cellArray[z][y][x - 1].value;
    }
    if (y + 1 <= tmy - 1 && x + 1 <= tmx - 1 && positions.charAt(23) == '1') {
        if (typeof val == undefined) {
            val = cellArray[z][y + 1][x + 1].value;
        }
        else if (cellArray[z][y + 1][x + 1].value > val)
            val = cellArray[z][y + 1][x + 1].value;
    }
    if (y - 1 >= 0 && x - 1 >= 0 && positions.charAt(3) == '1') {
        if (typeof val == undefined) {
            val = cellArray[z][y - 1][x - 1].value;
        }
        else if (cellArray[z][y - 1][x - 1].value > val)
            val = cellArray[z][y - 1][x - 1].value;
    }
    if (y + 1 <= tmy - 1 && x - 1 >= 0 && positions.charAt(21) == '1') {
        if (typeof val == undefined) {
            val = cellArray[z][y + 1][x - 1].value;
        }
        else if (cellArray[z][y + 1][x - 1].value > val)
            val = cellArray[z][y + 1][x - 1].value;
    }
    if (y - 1 >= 0 && x + 1 <= tmx - 1 && positions.charAt(5) == '1') {
        if (typeof val == undefined) {
            val = cellArray[z][y - 1][x + 1].value;
        }
        else if (cellArray[z][y - 1][x + 1].value > val)
            val = cellArray[z][y - 1][x + 1].value;
    }
    if (positions.charAt(13) == '1') {
        if (cellArray[z][y][x].value == checkValue)
            count += 1;
        if (typeof val == undefined) {
            val = cellArray[z][y][x].value;
        }
        else if (cellArray[z][y][x].value > val)
            val = cellArray[z][y][x].value;
    }
    if (typeof val == undefined) {
        return null;
    }
    else return val;
}

function countNeighboursAndCompare(x, y, z, positions, checkValue) {
    var count = 0;
    if (z - 1 >= 0) {
        if (y - 1 >= 0 && x - 1 >= 0 && positions.charAt(0) == '1') {
            if (cellArray[z - 1][y - 1][x - 1].value == checkValue)
                count += 1;
        }
        if (y + 1 <= tmy - 1 && positions.charAt(19) == '1') {
            if (cellArray[z - 1][y + 1][x].value == checkValue)
                count += 1;
        }
        if (y - 1 >= 0 && positions.charAt(1) == '1') {
            if (cellArray[z - 1][y - 1][x].value == checkValue)
                count += 1;
        }
        if (x + 1 <= tmx - 1 && positions.charAt(11) == '1') {
            if (cellArray[z - 1][y][x + 1].value == checkValue)
                count += 1;
        }
        if (x - 1 >= 0 && positions.charAt(9) == '1') {
            if (cellArray[z - 1][y][x - 1].value == checkValue)
                count += 1;
        }
        if (y + 1 <= tmy - 1 && x + 1 <= tmx - 1 && positions.charAt(20) == '1') {
            if (cellArray[z - 1][y + 1][x + 1].value == checkValue)
                count += 1;
        }
        if (y + 1 <= tmy - 1 && x - 1 >= 0 && positions.charAt(18) == '1') {
            if (cellArray[z - 1][y + 1][x - 1].value == checkValue)
                count += 1;
        }
        if (y - 1 >= 0 && x + 1 <= tmx - 1 && positions.charAt(2) == '1') {
            if (cellArray[z - 1][y - 1][x + 1].value == checkValue)
                count += 1;
        }
        if (positions.charAt(10) == '1') {
            if (cellArray[z - 1][y][x].value == checkValue)
                count += 1;
        }
    }

    if (z + 1 <= tmz - 1) {
        if (y + 1 <= tmy - 1 && positions.charAt(25) == '1') {
            if (cellArray[z + 1][y + 1][x].value == checkValue)
                count += 1;
        }
        if (y - 1 >= 0 && positions.charAt(7) == '1') {
            if (cellArray[z + 1][y - 1][x].value == checkValue)
                count += 1;
        }
        if (x + 1 <= tmx - 1 && positions.charAt(17) == '1') {
            if (cellArray[z + 1][y][x + 1].value == checkValue)
                count += 1;
        }
        if (x - 1 >= 0 && positions.charAt(15) == '1') {
            if (cellArray[z + 1][y][x - 1].value == checkValue)
                count += 1;
        }
        if (y + 1 <= tmy - 1 && x + 1 <= tmx - 1 && positions.charAt(26) == '1') {
            if (cellArray[z + 1][y + 1][x + 1].value == checkValue)
                count += 1;
        }
        if (y - 1 >= 0 && x - 1 >= 0 && positions.charAt(6) == '1') {
            if (cellArray[z + 1][y - 1][x - 1].value == checkValue)
                count += 1;
        }
        if (y + 1 <= tmy - 1 && x - 1 >= 0 && positions.charAt(24) == '1') {
            if (cellArray[z + 1][y + 1][x].value == checkValue)
                count += 1;
        }
        if (y - 1 >= 0 && x + 1 <= tmx - 1 && positions.charAt(8) == '1') {
            if (cellArray[z + 1][y - 1][x + 1].value == checkValue)
                count += 1;
        }
        if (positions.charAt(16) == '1') {
            if (cellArray[z + 1][y][x].value == checkValue)
                count += 1;
        }
    }

    if (y + 1 <= tmy - 1 && positions.charAt(22) == '1') {
        if (cellArray[z ][y + 1][x].value == checkValue)
            count += 1;
    }
    if (y - 1 >= 0 && positions.charAt(4) == '1') {
        if (cellArray[z][y - 1][x].value == checkValue)
            count += 1;
    }
    if (x + 1 <= tmx - 1 && positions.charAt(14) == '1') {
        if (cellArray[z][y][x + 1].value == checkValue)
            count += 1;
    }
    if (x - 1 >= 0 && positions.charAt(12) == '1') {
        if (cellArray[z][y][x - 1].value == checkValue)
            count += 1;
    }
    if (y + 1 <= tmy - 1 && x + 1 <= tmx - 1 && positions.charAt(23) == '1') {
        if (cellArray[z][y + 1][x + 1].value == checkValue)
            count += 1;
    }
    if (y - 1 >= 0 && x - 1 >= 0 && positions.charAt(3) == '1') {
        if (cellArray[z][y - 1][x - 1].value == checkValue)
            count += 1;
    }
    if (y + 1 <= tmy - 1 && x - 1 >= 0 && positions.charAt(21) == '1') {
        if (cellArray[z][y + 1][x - 1].value == checkValue)
            count += 1;
    }
    if (y - 1 >= 0 && x + 1 <= tmx - 1 && positions.charAt(5) == '1') {
        if (cellArray[z][y - 1][x + 1].value == checkValue)
            count += 1;
    }
    if (positions.charAt(13) == '1') {
        if (cellArray[z][y][x].value == checkValue)
            count += 1;
    }
    return count;
}

function sumNeighboursAtPositions(x, y, z, positions) {
    var count = 0;
    if (z - 1 >= 0) {
        if (y - 1 >= 0 && x - 1 >= 0 && positions.charAt(0) == '1')
            count += cellArray[z - 1][y - 1][x - 1].value;
        if (y + 1 <= tmy - 1 && positions.charAt(19) == '1')
            count += cellArray[z - 1][y + 1][x].value;
        if (y - 1 >= 0 && positions.charAt(1) == '1')
            count += cellArray[z - 1][y - 1][x].value;
        if (x + 1 <= tmx - 1 && positions.charAt(11) == '1')
            count += cellArray[z - 1][y][x + 1].value;
        if (x - 1 >= 0 && positions.charAt(9) == '1')
            count += cellArray[z - 1][y][x - 1].value;
        if (y + 1 <= tmy - 1 && x + 1 <= tmx - 1 && positions.charAt(20) == '1')
            count += cellArray[z - 1][y + 1][x + 1].value;
        if (y + 1 <= tmy - 1 && x - 1 >= 0 && positions.charAt(18) == '1')
            count += cellArray[z - 1][y + 1][x - 1].value;
        if (y - 1 >= 0 && x + 1 <= tmx - 1 && positions.charAt(2) == '1')
            count += cellArray[z - 1][y - 1][x + 1].value;
        if (positions.charAt(10) == '1')
            count += cellArray[z - 1][y][x].value;
    }

    if (z + 1 <= tmz - 1) {
        if (y + 1 <= tmy - 1 && positions.charAt(25) == '1')
            count += cellArray[z + 1][y + 1][x].value;
        if (y - 1 >= 0 && positions.charAt(7) == '1')
            count += cellArray[z + 1][y - 1][x].value;
        if (x + 1 <= tmx - 1 && positions.charAt(17) == '1')
            count += cellArray[z + 1][y][x + 1].value;
        if (x - 1 >= 0 && positions.charAt(15) == '1')
            count += cellArray[z + 1][y][x - 1].value;
        if (y + 1 <= tmy - 1 && x + 1 <= tmx - 1 && positions.charAt(26) == '1')
            count += cellArray[z + 1][y + 1][x + 1].value;
        if (y - 1 >= 0 && x - 1 >= 0 && positions.charAt(6) == '1')
            count += cellArray[z + 1][y - 1][x - 1].value;
        if (y + 1 <= tmy - 1 && x - 1 >= 0 && positions.charAt(24) == '1')
            count += cellArray[z + 1][y + 1][x - 1].value;
        if (y - 1 >= 0 && x + 1 <= tmx - 1 && positions.charAt(8) == '1')
            count += cellArray[z + 1][y - 1][x + 1].value;
        if (positions.charAt(16) == '1')
            count += cellArray[z + 1][y][x].value;
    }

    if (y + 1 <= tmy - 1 && positions.charAt(22) == '1')
        count += cellArray[z][y + 1][x].value;
    if (y - 1 >= 0 && positions.charAt(4) == '1')
        count += cellArray[z][y - 1][x].value;
    if (x + 1 <= tmx - 1 && positions.charAt(14) == '1')
        count += cellArray[z][y][x + 1].value;
    if (x - 1 >= 0 && positions.charAt(12) == '1')
        count += cellArray[z][y][x - 1].value;
    if (y + 1 <= tmy - 1 && x + 1 <= tmx - 1 && positions.charAt(23) == '1')
        count += cellArray[z][y + 1][x + 1].value;
    if (y - 1 >= 0 && x - 1 >= 0 && positions.charAt(3) == '1')
        count += cellArray[z][y - 1][x - 1].value;
    if (y + 1 <= tmy - 1 && x - 1 >= 0 && positions.charAt(21) == '1')
        count += cellArray[z][y + 1][x - 1].value;
    if (y - 1 >= 0 && x + 1 <= tmx - 1 && positions.charAt(5) == '1')
        count += cellArray[z][y - 1][x + 1].value;
    if (positions.charAt(13) == '1')
        count += cellArray[z][y][x].value;
    return count;
}

function toggleZLayer(zlayer) {
    for (var y = 0; y < tmz; y++) {
        for (var x = 0; x < tmx; x++) {
            if(midpoint.active)
                continue;
            if(xbar[x].active)
                continue;
            if(ybar[y].active)
                continue;
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
            if(midpoint.active)
                continue;
            if(zbar[z].active)
                continue;
            if(xbar[x].active)
                continue;
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

function toggleXLayer(xlayer) {
    for (var z = 0; z < tmz; z++) {
        for (var y = 0; y < tmy; y++) {
            if(midpoint.active)
                continue;
            if(zbar[z].active)
                continue;
            if(ybar[y].active)
                continue;
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
        zbar[i].cube.visible = document.getElementById("z").checked;
    }
    for (var i = 0; i < tmx; i++) {
        xbar[i].cube.visible = document.getElementById("x").checked;
    }
    for (var i = 0; i < tmy; i++) {
        ybar[i].cube.visible = document.getElementById("y").checked;
    }
    midpoint.cube.visible = document.getElementById("mid").checked;
}

function performOperation(neightbours, expected, conditionOperand) {
    var result = false;
    if (conditionOperand == "==") {
        if (neightbours == expected)
            result = true;
    }
    else if (conditionOperand == ">") {
        if (neightbours > expected)
            result = true;
    }
    else if (conditionOperand == "<") {
        if (neightbours < expected)
            result = true;
    }
    else if (conditionOperand == "<=") {
        if (neightbours <= expected)
            result = true;
    }
    else if (conditionOperand == ">=") {
        if (neightbours >= expected)
            result = true;
    }
    return result;
}

function performBetween(type, neightbours, valueOne, valueTwo) {
    var result = false;

    if(type == "BI")
        if (neightbours >= valueOne && neightbours <= valueTwo) result = true;
    if(type == "BE")
        if (neightbours > valueOne && neightbours < valueTwo) result = true;

    return result;
}

function worldStates() {

    var s = '<table class="table">';
    for (var i = 0; i < counter; i++) {
        if( colorsUsedName[i]!="0") {
            s += "<tr><td><button  onclick='setColor(" + colorsUsedName[i] + ")' style=" + '"background-color:#' + arryColour[i].substring(2) + '"' + 'class="btn btn-default btn-lg" ></button>';
            s += "<label>   State Value:" + colorsUsedName[i] + "</label></td></tr>";
        }

    }
    s += "</tr></table>";
    document.getElementById("worldState").innerHTML = s;

    $("#colorValue").on("change", function(){
        if(this.value == 0) {

        }
    });
}
function toggleRule(i)
{


    if (ruleArray[i].enabled==true) {
        document.getElementById("rule"+i).style.backgroundColor = "#FF3300";
        ruleArray[i].enabled=false;
    } else {
        document.getElementById("rule"+i).style.backgroundColor = "#006600";
        ruleArray[i].enabled=true;
    }

}
function worldRules() {

    for(var i=0;i<ruleArray.length;i++)
    {
        for(var i2=0;i2<ruleWorldList.length;i2++) {
            if (this.ruleArray[i].ruleId==ruleWorldList[i2].ruleId)
            {
                this.ruleArray[i].enabled=true;

            }
        }
    }

    var s = '<table class="table">';
    for (var i = 0; i < ruleArray.length; i++) {

        var x;
        if (this.ruleArray[i].enabled==true) {

        x = "#006600";

        }
        else {
            x = "#FF3300";
        }


        s += "<tr><td><button style = \"background-color:"+x+";\" id="+'"'+"rule"+i+'"'+" onclick='toggleRule("+i+")' class='btn btn-default btn-lg' ></button>";
        s += "<label>" + ruleArray[i].ruleName + "</label>";
        s += "<br/><label style=\"font-size:11px;\">" + ruleArray[i].ruleDesc + "</label></td></tr>";

    }
    s += "</tr></table>";
    document.getElementById("worldRule").innerHTML = s;



}
function setColor(value) {

    var tempcolor = document.getElementById("colorValue").value = value;
}

function checkCondition(c, x, y, z) {
    if (typeof c != null) {
        if (c.conditionOperand == "BI" || c.conditionOperand == "BE") {
            if (c.conditionOperation == "SUM") {
                var neightbours = sumNeighboursAtPositions(x, y, z, c.conditionNeighbours);
                return performBetween(c.conditionOperand, neightbours, c.compareValueOne, c.compareValueTwo);
            }
            else if (ruleArray[rule].conditionArray[cond].conditionOperation == "MIN") {
                var neightbour = getSmallestNeighbour(x, y, z, c.conditionNeighbours);
                return performBetween(c.conditionOperand, neightbour, c.compareValueOne, c.compareValueTwo);
            }
            else if (ruleArray[rule].conditionArray[cond].conditionOperation == "MAX") {
                var neightbour = getBiggestNeighbour(x, y, z, c.conditionNeighbours);
                return performBetween(c.conditionOperand, neightbour, c.compareValueOne, c.compareValueTwo);
            }
            else if (ruleArray[rule].conditionArray[cond].conditionOperation == "AVG") {
                var neightbour = getAverage(x, y, z, c.conditionNeighbours);
                return performBetween(c.conditionOperand, neightbour, c.compareValueOne, c.compareValueTwo);
            }
        }
        else {
            if (c.conditionOperation == "SUM") {
                var neightbours = sumNeighboursAtPositions(x, y, z, c.conditionNeighbours);
                return performOperation(neightbours, c.compareValueOne, c.conditionOperand);
            }
            else if (c.conditionOperation == "COUNT") {
                var neightbour = countNeighboursAndCompare(x, y, z, c.conditionNeighbours, c.compareValueOne);
                return performOperation(neightbour, c.compareValueTwo, c.conditionOperand);
            }
            else if (c.conditionOperation == "MIN") {
                var neightbour = getSmallestNeighbour(x, y, z, c.conditionNeighbours);
                return performOperation(neightbour, c.compareValueOne, c.conditionOperand);
            }
            else if (c.conditionOperation == "MAX") {
                var neightbour = getBiggestNeighbour(x, y, z, c.conditionNeighbours);
                return performOperation(neightbour, c.compareValueOne, c.conditionOperand);
            }
            else if (c.conditionOperation == "AVG") {
                var neightbour = getAverage(x, y, z, c.conditionNeighbours);
                return performOperation(neightbour, c.compareValueOne, c.conditionOperand);
            }
        }
    }
    return false;
}

function colour(size,x,y,z,hover)	{
    if(size <= 0)	{
        changeThisState(x, y, z, size, hover);
    }
    else	{
        changeThisState(x, y, z, size, hover);
        if(tmz > 1)	{
            var x1 = false, x2 = false, y1 = false, y2 = false, z1 = false, z2 = false;
            var count  = 0;
            if(x + 1 < tmx)
                if(cellArray[z][y][x + 1].invis)	{
                    x1 = true;
                    count++;
                }
            if(x - 1 >= 0)
                if(cellArray[z][y][x - 1].invis)	{
                    x2 = true;
                    count++;
                }
            if(y + 1 < tmy)
                if(cellArray[z][y + 1][x].invis)	{
                    y1 = true;
                    count++;
                }
            if(y - 1 >= 0)
                if(cellArray[z][y - 1][x].invis)	{
                    y2 = true;
                    count++;
                }
            if(z + 1 < tmz)
                if(cellArray[z + 1][y][x].invis)	{
                    z1 = true;
                    count++;
                }
            if(z - 1 >= 0)
                if(cellArray[z - 1][y][x].invis)	{
                    z2 = true;
                    count++;
                }

            if(count == 3)	{
                if(x1)
                    changeThisState(x + 1, y, z, size, hover);
                if(x2)
                    changeThisState(x - 1, y, z, size, hover);
                if(y1)
                    changeThisState(x, y + 1, z, size, hover);
                if(y2)
                    changeThisState(x, y - 1, z, size, hover);
                if(z1)
                    changeThisState(x, y, z + 1, size, hover);
                if(z2)
                    changeThisState(x, y, z - 1, size, hover);

                if(x1 && y1 && x + 1 <= tmx && y + 1 <= tmy)
                    changeThisState(x + 1, y + 1, z, size, hover);
                if(x2 && y1 && x - 1 >= 0 && y + 1 <= tmy)
                    changeThisState(x - 1, y + 1, z, size, hover);
                if(x1 && y2 && x + 1 <= tmx && y - 1 >= 0)
                    changeThisState(x + 1, y - 1, z, size, hover);
                if(x2 && y2 && x - 1 >= 0 && y - 1 >= 0)
                    changeThisState(x - 1, y - 1, z, size, hover);

                if(y1 && z1 && z + 1 <= tmz && y + 1 <= tmy)
                    changeThisState(x, y + 1, z + 1, size, hover);
                if(y2 && z1 && z + 1 <= tmz && y - 1 >= 0)
                    changeThisState(x, y - 1, z + 1, size, hover);
                if(y1 && z2 && z - 1 >= 0 && y + 1 <= tmy)
                    changeThisState(x, y + 1, z - 1, size, hover);
                if(y2 && z2 && z - 1 >= 0 && y - 1 >= 0)
                    changeThisState(x, y - 1, z - 1, size, hover);

                if(z1 && x1 && z + 1 <= tmz && x + 1 <= tmx)
                    changeThisState(x + 1, y, z + 1, size, hover);
                if(z2 && x1 && z - 1 >= 0 && x + 1 <= tmx)
                    changeThisState(x + 1, y, z - 1, size, hover);
                if(z1 && x2 && z + 1 <= tmz && x - 1 >= 0)
                    changeThisState(x - 1, y, z + 1, size, hover);
                if(z2 && x2 && z - 1 >= 0 && x - 1 >= 0)
                    changeThisState(x - 1, y, z - 1, size, hover);
            }
            if(count == 4)	{
                if(x1)
                    changeThisState(x + 1, y, z, size, hover);
                if(x2)
                    changeThisState(x - 1, y, z, size, hover);
                if(y1)
                    changeThisState(x, y + 1, z, size, hover);
                if(y2)
                    changeThisState(x, y - 1, z, size, hover);
                if(z1)
                    changeThisState(x, y, z + 1, size, hover);
                if(z2)
                    changeThisState(x, y, z - 1, size, hover);
                if(x1 == x2)	{
                    if(x1 && y1 && x + 1 <= tmx && y + 1 <= tmy)
                        changeThisState(x + 1, y + 1, z, size, hover);
                    if(x2 && y1 && x - 1 >= 0 && y + 1 <= tmy)
                        changeThisState(x - 1, y + 1, z, size, hover);
                    if(x1 && y2 && x + 1 <= tmx && y - 1 >= 0)
                        changeThisState(x + 1, y - 1, z, size, hover);
                    if(x2 && y2 && x - 1 >= 0 && y - 1 >= 0)
                        changeThisState(x - 1, y - 1, z, size, hover);

                    if(z1 && x1 && z + 1 <= tmz && x + 1 <= tmx)
                        changeThisState(x + 1, y, z + 1, size, hover);
                    if(z2 && x1 && z - 1 >= 0 && x + 1 <= tmx)
                        changeThisState(x + 1, y, z - 1, size, hover);
                    if(z1 && x2 && z + 1 <= tmz && x - 1 >= 0)
                        changeThisState(x - 1, y, z + 1, size, hover);
                    if(z2 && x2 && z - 1 >= 0 && x - 1 >= 0)
                        changeThisState(x - 1, y, z - 1, size, hover);
                }
                if(y1 == y2)	{
                    if(x1 && y1 && x + 1 <= tmx && y + 1 <= tmy)
                        changeThisState(x + 1, y + 1, z, size, hover);
                    if(x2 && y1 && x - 1 >= 0 && y + 1 <= tmy)
                        changeThisState(x - 1, y + 1, z, size, hover);
                    if(x1 && y2 && x + 1 <= tmx && y - 1 >= 0)
                        changeThisState(x + 1, y - 1, z, size, hover);
                    if(x2 && y2 && x - 1 >= 0 && y - 1 >= 0)
                        changeThisState(x - 1, y - 1, z, size, hover);

                    if(y1 && z1 && z + 1 <= tmz && y + 1 <= tmy)
                        changeThisState(x, y + 1, z + 1, size, hover);
                    if(y2 && z1 && z + 1 <= tmz && y - 1 >= 0)
                        changeThisState(x, y - 1, z + 1, size, hover);
                    if(y1 && z2 && z - 1 >= 0 && y + 1 <= tmy)
                        changeThisState(x, y + 1, z - 1, size, hover);
                    if(y2 && z2 && z - 1 >= 0 && y - 1 >= 0)
                        changeThisState(x, y - 1, z - 1, size, hover);
                }
                if(z1 == z2)	{
                    if(y1 && z1 && z + 1 <= tmz && y + 1 <= tmy)
                        changeThisState(x, y + 1, z + 1, size, hover);
                    if(y2 && z1 && z + 1 <= tmz && y - 1 >= 0)
                        changeThisState(x, y - 1, z + 1, size, hover);
                    if(y1 && z2 && z - 1 >= 0 && y + 1 <= tmy)
                        changeThisState(x, y + 1, z - 1, size, hover);
                    if(y2 && z2 && z - 1 >= 0 && y - 1 >= 0)
                        changeThisState(x, y - 1, z - 1, size, hover);

                    if(z1 && x1 && z + 1 <= tmz && x + 1 <= tmx)
                        changeThisState(x + 1, y, z + 1, size, hover);
                    if(z2 && x1 && z - 1 >= 0 && x + 1 <= tmx)
                        changeThisState(x + 1, y, z - 1, size, hover);
                    if(z1 && x2 && z + 1 <= tmz && x - 1 >= 0)
                        changeThisState(x - 1, y, z + 1, size, hover);
                    if(z2 && x2 && z - 1 >= 0 && x - 1 >= 0)
                        changeThisState(x - 1, y, z - 1, size, hover);
                }
            }
            if(count == 5)	{
                if(x1 == x2)	{
                    changeThisState(x + 1, y, z, size, hover);
                    changeThisState(x - 1, y, z, size, hover);
                }
                if(y1 == y2)	{
                    changeThisState(x, y + 1, z, size, hover);
                    changeThisState(x, y - 1, z, size, hover);
                }
                if(z1 == z2)	{
                    changeThisState(x, y, z + 1, size, hover);
                    changeThisState(x, y, z - 1, size, hover);
                }
                if((x1 && x2) && (y1 && y2))	{
                    changeThisState(x + 1, y + 1, z, size, hover);
                    changeThisState(x + 1, y - 1, z, size, hover);
                    changeThisState(x - 1, y - 1, z, size, hover);
                    changeThisState(x - 1, y + 1, z, size, hover);
                }
                if((x1 && x2) && (z1 && z2))	{
                    changeThisState(x + 1, y, z + 1, size, hover);
                    changeThisState(x - 1, y, z + 1, size, hover);
                    changeThisState(x + 1, y, z - 1, size, hover);
                    changeThisState(x - 1, y, z - 1, size, hover);
                }
                if((z1 && z2) && (y1 && y2))	{
                    changeThisState(x, y + 1, z + 1, size, hover);
                    changeThisState(x, y - 1, z - 1, size, hover);
                    changeThisState(x, y - 1, z + 1, size, hover);
                    changeThisState(x, y + 1, z - 1, size, hover);
                }
            }
        }
        else	{
            if(y + 1 <= tmy - 1)
                changeThisState(x, y + 1, z, size, hover);
            if(y - 1 >= 0)
                changeThisState(x, y - 1, z, size, hover);
            if(x + 1 <= tmx - 1)
                changeThisState(x + 1, y, z, size, hover);
            if(x - 1 >= 0)
                changeThisState(x - 1, y, z, size, hover);
            if(y + 1 <= tmy - 1 && x + 1 <= tmx - 1)
                changeThisState(x + 1, y + 1, z, size, hover);
            if(y - 1 >= 0 && x - 1 >= 0)
                changeThisState(x - 1, y - 1, z, size, hover);
            if(y + 1 <= tmy - 1 && x - 1 >= 0)
                changeThisState(x - 1, y + 1, z, size, hover);
            if(y - 1 >= 0 && x + 1 <= tmx - 1)
                changeThisState(x + 1, y - 1, z, size, hover);
        }
    }
}

function changeThisState(x, y, z, size, hover)	{
    if(typeof document.getElementById("colorValue").value != undefined)
        tempcolor = document.getElementById("colorValue").value;
    else tempcolor = 0;

    if (colorsUsed[tempcolor] != null) {
        cellArray[z][y][x].cube.material.color.setHex(colorsUsed[tempcolor]);
    }
    else {
        colorsUsed[tempcolor] = arryColour[counter];
        colorsUsedName[counter] = tempcolor;
        counter++;
        worldStates();
    }

    if(hover)
        cellArray[z][y][x].hoverCell(tempcolor);
    else {
        cellArray[z][y][x].cube.material.opacity = 1;

        cellArray[z][y][x].value = parseFloat(tempcolor);
        if (cellArray[z][y][x].value == 0) {
            cellArray[z][y][x].cube.material.opacity = 0.03;
            cellArray[z][y][x].colour = "";
            cellArray[z][y][x].invis = true;
        }
        else {
            cellArray[z][y][x].colour = colorsUsed[tempcolor];
            cellArray[z][y][x].cube.material.color.setHex(colorsUsed[tempcolor]);

        }
    }

    if(size > 1)
        colour(size - 1,x,y,z,hover);
}

