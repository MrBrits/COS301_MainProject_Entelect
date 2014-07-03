package za.co.tera.Domain.impl;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Christo on 2014/07/03.
 */
@Entity
public class World {
    private int worldId;
    private String worldName;
    private String worldDesc;
    private int worldDimension;
    private int worldWidth;
    private int worldHeight;
    private int worldLength;
    private int ruleId;
    private int coordinateId;
    private int ownerId;

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
    @Column(name = "WorldDesc", nullable = false, insertable = true, updatable = true, length = 100)
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
    @Column(name = "WorldLength", nullable = false, insertable = true, updatable = true)
    public int getWorldLength() {
        return worldLength;
    }

    public void setWorldLength(int worldLength) {
        this.worldLength = worldLength;
    }

    @Basic
    @Column(name = "RuleID", nullable = false, insertable = true, updatable = true)
    public int getRuleId() {
        return ruleId;
    }

    public void setRuleId(int ruleId) {
        this.ruleId = ruleId;
    }

    @Basic
    @Column(name = "CoordinateID", nullable = false, insertable = true, updatable = true)
    public int getCoordinateId() {
        return coordinateId;
    }

    public void setCoordinateId(int coordinateId) {
        this.coordinateId = coordinateId;
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

        if (coordinateId != world.coordinateId) return false;
        if (ownerId != world.ownerId) return false;
        if (ruleId != world.ruleId) return false;
        if (worldDimension != world.worldDimension) return false;
        if (worldHeight != world.worldHeight) return false;
        if (worldId != world.worldId) return false;
        if (worldLength != world.worldLength) return false;
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
        result = 31 * result + worldLength;
        result = 31 * result + ruleId;
        result = 31 * result + coordinateId;
        result = 31 * result + ownerId;
        return result;
    }
}
