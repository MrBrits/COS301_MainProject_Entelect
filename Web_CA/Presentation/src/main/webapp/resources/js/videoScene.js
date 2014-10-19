var cameraTut, sceneTut, rendererTut;
var player;
rendererTut = new THREE.CSS3DRenderer();
rendererTut.setSize( window.innerWidth, window.innerHeight );
rendererTut.domElement.style.position = 'absolute';
rendererTut.domElement.style.top = 0;
document.getElementById( 'myContainer' ).appendChild( rendererTut.domElement );
var auto = true;
var number= 0;
var number2= 0;
var tempArr= ["1.jpg","2.jpg","3.jpg","4.jpg","5.jpg","6.jpg"];
var tempVid= ["1.mp4","2.mp4","3.mp4","4.mp4","5.mp4","6.mp4"];
var Element = function ( entry ) {

    var dom = document.createElement( 'div' );
    dom.style.width = '480px';
    dom.style.height = '360px';

    var image = document.createElement( 'img' );
    image.style.position = 'absolute';
    image.style.width = '480px';
    image.style.height = '360px';
    image.src = "resources/img/"+tempArr[number++];
    if(number==6)
        number=0;
    dom.appendChild( image );



    var blocker = document.createElement( 'div' );
    blocker.style.position = 'absolute';
    blocker.style.width = '480px';
    blocker.style.height = '360px';
    blocker.style.background = 'rgba(0,0,0,0.2)';
    blocker.style.cursor = 'pointer';
    dom.appendChild( blocker );

    var object = new THREE.CSS3DObject( dom );
    object.position.x = Math.random() * 4000 - 2000;
    object.position.y = Math.random() * 2000 - 1000;
    object.position.y = 3000;
    object.position.z = Math.random() * - 5000;

    //

    image.addEventListener( 'load', function ( event ) {



        new TWEEN.Tween( object.position )
            .to( { y: Math.random() * 2000 - 1000 }, 2000 )
            .easing( TWEEN.Easing.Exponential.Out )
            .start();

    }, false );

   dom.addEventListener( 'mouseover', function () {


        blocker.style.background = 'rgba(0,0,0,0)';

    }, false );

    dom.addEventListener( 'mouseout', function () {

        blocker.style.background = 'rgba(0,0,0,0.2)';

    }, false );

    dom.addEventListener( 'click', function ( event ) {

        event.stopPropagation();

        auto = false;

        if ( player !== undefined ) {

            player.parentNode.removeChild( player );
            player = undefined;

        }

        player = document.createElement( 'iframe' );
        player.style.position = 'absolute';
        player.style.width = '480px';
        player.style.height = '360px';
        player.style.border = '0px';
        player.src = "resources/img/"+tempVid[number2++];
        this.appendChild( player );
        if(number2==6)
            number2=0;


        var prev = object.position.z + 400;

        new TWEEN.Tween( cameraTut.position )
            .to( { x: object.position.x, y: object.position.y - 25 }, 1500 )
            .easing( TWEEN.Easing.Exponential.Out )
            .start();

        new TWEEN.Tween( { value: prev } )
            .to( { value: 0  }, 2000 )
            .onUpdate( function () {

                move( this.value - prev );
                prev = this.value;

            } )
            .easing( TWEEN.Easing.Exponential.Out )
            .start();

    }, false );

    return object;

};

init();
animate();

function init() {


    cameraTut = new THREE.PerspectiveCamera( 75, window.innerWidth / window.innerHeight, 1, 5000 );
    cameraTut.position.y = - 25;

    sceneTut = new THREE.Scene();


    onData();

    document.body.addEventListener( 'mousewheel', onMouseWheel, false );

    document.body.addEventListener( 'click', function ( event ) {

        auto = true;

        if ( player !== undefined ) {

            player.parentNode.removeChild( player );
            player = undefined;

        }

        new TWEEN.Tween( cameraTut.position )
            .to( { x: 0, y: - 25 }, 1500 )
            .easing( TWEEN.Easing.Exponential.Out )
            .start();

    }, false );

    window.addEventListener( 'resize', onWindowResize, false );

}
//
function onData(  ) {


    for ( var i = 0; i < 18; i ++ ) {

        ( function ( data, time ) {

            setTimeout( function () {

                sceneTut.add( new Element(  ) );

            }, time );

        } )( );

    }

}

function move( delta ) {

    for ( var i = 0; i < sceneTut.children.length; i ++ ) {

        var object = sceneTut.children[ i ];

        object.position.z += delta;

        if ( object.position.z > 0 ) {

            object.position.z -= 5000;

        } else if ( object.position.z < - 5000 ) {

            object.position.z += 5000;

        }

    }

}

function onMouseWheel( event ) {

    move( event.wheelDelta );

}

function onWindowResize() {

    cameraTut.aspect = window.innerWidth / window.innerHeight;
    cameraTut.updateProjectionMatrix();

    rendererTut.setSize( window.innerWidth, window.innerHeight );

}

function animate() {


    requestAnimationFrame( animate );

    TWEEN.update();

    if ( auto === true ) {

        move( 1 );

    }

    rendererTut.render( sceneTut, cameraTut );

}

if(document.getElementById("tut").value=="false")
{

    document.getElementById("myContainer").style.visibility="hidden";
}
else
{

    document.getElementById("myContainer").style.visibility="visible";
}


