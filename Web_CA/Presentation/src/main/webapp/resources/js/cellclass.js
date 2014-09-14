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
    this.triggerChange = false
    this.toggleInvis = function()	{
        if(this.invis == true)	{
            if(this.colour != "")
                this.cube.material.opacity = 1;
        }
        else{
            this.cube.material.opacity = 0.003;
        }
    }
    this.changeValue =function()	{
        this.value = this.nextValue;
        this.nextValue = 0;
        this.triggerChange = false;
        if(this.value == 1)	{
            this.cube.material.color.setHex(0x000000);
            this.colour = "0x000000";
            this.toggleInvis();
        }
        else	{
            this.cube.material.color.setHex(0xffffff);
            this.colour = "";
            this.cube.material.opacity = 0.03;
        }
    }
}

