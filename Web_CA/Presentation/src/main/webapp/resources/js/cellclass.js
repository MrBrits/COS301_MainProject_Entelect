
/**
 *
 * @param x
 * @param y
 * @param z
 * @param c
 */
function cell(x,y,z,c)	{
    //Variables
    this.x = x;
    this.y = y;
    this.z = z;
    this.value = 0;
    this.colour = 0;
    this.cube = c;
    this.invis = true;
    this.toggleInvis = function()	{
        if(this.invis == true)	{
            this.cube.material.opacity = 1;
        }
        else{
            this.cube.material.opacity = 0.1;
        }
    }
}

