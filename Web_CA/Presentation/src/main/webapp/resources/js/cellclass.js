//Cell Class used to contain all of the information about a cell
function cell(x,y,z,c)	{
    //Variables
    this.x = x;
    this.y = y;
    this.z = z;
    this.value = 0;
    this.nextValue = 0;
    this.colour = 0;
    this.cube = c;
    this.invis = true;
    this.triggerChange = false;
    this.hovered = false;

    this.toggleInvis = function()	{
        if(this.invis == true)	{
            if(this.colour != "")
                this.cube.material.opacity = 1;
        }
        else{
            this.cube.material.opacity = 0.03;
        }
    }

    this.changeValue =function(colour)	{
        this.value = this.nextValue;
        this.nextValue = 0;
        this.triggerChange = false;
        if(this.value != 0)	{
            this.cube.material.color.setHex(colour);
            this.colour = colour;
            this.toggleInvis();
        }
        else	{
            this.cube.material.color.setHex(0xffffff);
            this.colour = "";
            this.cube.material.opacity = 0.03;
        }
    }

    this.hoverCell = function(colour) {
        this.hovered = true;
        this.cube.material.opacity = 0.3;
        if(colour != 0) {
            this.toggleInvis();
        }
    }

    this.resetHover = function() {
        if(this.hovered)    {
            this.hovered = false;
            if(this.value != 0)	{
                this.cube.material.color.setHex(this.colour);
                this.toggleInvis();
            }
            else	{
                this.cube.material.color.setHex(0xffffff);
                this.colour = "";
                this.cube.material.opacity = 0.03;
            }
        }
    }
}

