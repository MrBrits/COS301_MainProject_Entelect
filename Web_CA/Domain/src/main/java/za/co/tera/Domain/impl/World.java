package za.co.tera.Domain.impl;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Christo on 2014/07/04.
 */
@Entity
public class World {
    private int worldId;
    private String worldName;
    private String worldDesc;
    private int worldDimension;
    private int worldWidth;
    private int worldHeight;
    private int worldDepth;
    private int ownerId;

    public World(String worldName,String worldDesc,int worldDimension,int worldWidth,int worldHeight,int worldDepth,int ownerId)
    {
        this.worldName=worldName;
        this.worldDesc=worldDesc;
        this.worldDimension=worldDimension;
        this.worldWidth=worldWidth;
        this.worldHeight=worldHeight;
        this.worldDepth=worldDepth;
        this.ownerId=ownerId;
    }

    public World()
    {}

    @Id
    @Column(name = "WorldID", nullable = false, insertable = true, updatable = true)
    public int getWorldId() {
        return worldId;
    }

    public void setWorldId(int worldId) {
        this.worldId = worldId;
    }

    @Basic
    @Column(name = "WorldName", nullable = false, insertable = true, updatable = true, length = 20)
    public String getWorldName() {
        return worldName;
    }

    public void setWorldName(String worldName) {
        this.worldName = worldName;
    }

    @Basic
    @Column(name = "WorldDesc", nullable = false, insertable = true, updatable = true, length = 300)
    public String getWorldDesc() {
        return worldDesc;
    }

    public void setWorldDesc(String worldDesc) {
        this.worldDesc = worldDesc;
    }

    @Basic
    @Column(name = "WorldDimension", nullable = false, insertable = true, updatable = true)
    public int getWorldDimension() {
        return worldDimension;
    }

    public void setWorldDimension(int worldDimension) {
        this.worldDimension = worldDimension;
    }

    @Basic
    @Column(name = "WorldWidth", nullable = false, insertable = true, updatable = true)
    public int getWorldWidth() {
        return worldWidth;
    }

    public void setWorldWidth(int worldWidth) {
        this.worldWidth = worldWidth;
    }

    @Basic
    @Column(name = "WorldHeight", nullable = false, insertable = true, updatable = true)
    public int getWorldHeight() {
        return worldHeight;
    }

    public void setWorldHeight(int worldHeight) {
        this.worldHeight = worldHeight;
    }

    @Basic
    @Column(name = "WorldDepth", nullable = false, insertable = true, updatable = true)
    public int getWorldDepth() {
        return worldDepth;
    }

    public void setWorldDepth(int worldDepth) {
        this.worldDepth = worldDepth;
    }

    @Basic
    @Column(name = "OwnerID", nullable = false, insertable = true, updatable = true)
    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        World world = (World) o;

        if (ownerId != world.ownerId) return false;
        if (worldDepth != world.worldDepth) return false;
        if (worldDimension != world.worldDimension) return false;
        if (worldHeight != world.worldHeight) return false;
        if (worldId != world.worldId) return false;
        if (worldWidth != world.worldWidth) return false;
        if (worldDesc != null ? !worldDesc.equals(world.worldDesc) : world.worldDesc != null) return false;
        if (worldName != null ? !worldName.equals(world.worldName) : world.worldName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = worldId;
        result = 31 * result + (worldName != null ? worldName.hashCode() : 0);
        result = 31 * result + (worldDesc != null ? worldDesc.hashCode() : 0);
        result = 31 * result + worldDimension;
        result = 31 * result + worldWidth;
        result = 31 * result + worldHeight;
        result = 31 * result + worldDepth;
        result = 31 * result + ownerId;
        return result;
    }
}
