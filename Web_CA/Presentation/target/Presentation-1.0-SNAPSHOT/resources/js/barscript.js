function barClass(c) {
    this.active = false;
    this.cube = c;

    this.toggleVisible = function()    {
        this.active = !this.active;
        if(this.active)  {
            this.cube.material.opacity = 0.03;
        }
        else    {
            this.cube.material.opacity = 1;
        }
    }
}