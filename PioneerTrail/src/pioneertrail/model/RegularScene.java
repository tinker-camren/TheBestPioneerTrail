/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pioneertrail.model;

import java.util.Objects;

/**
 *
 * @author tinkerc
 */
public class RegularScene {
    
    //Class instance variables
    private String sceneName;
    private String description;
    private String terrainEffect;
    private String terrainType;
    private String sicknessType;
    private String sicknessEffect;
    private double mortalityRate;
    private Location location;
    

    public RegularScene() {
    }

    public String getSceneName() {
        return sceneName;
    }

    public void setSceneName(String sceneName) {
        this.sceneName = sceneName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTerrainEffect() {
        return terrainEffect;
    }

    public void setTerrainEffect(String terrainEffect) {
        this.terrainEffect = terrainEffect;
    }

    public String getTerrainType() {
        return terrainType;
    }

    public void setTerrainType(String terrainType) {
        this.terrainType = terrainType;
    }

    public String getSicknessType() {
        return sicknessType;
    }

    public void setSicknessType(String sicknessType) {
        this.sicknessType = sicknessType;
    }

    public String getSicknessEffect() {
        return sicknessEffect;
    }

    public void setSicknessEffect(String sicknessEffect) {
        this.sicknessEffect = sicknessEffect;
    }

    public double getMortalityRate() {
        return mortalityRate;
    }

    public void setMortalityRate(double mortalityRate) {
        this.mortalityRate = mortalityRate;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.sceneName);
        hash = 97 * hash + Objects.hashCode(this.description);
        hash = 97 * hash + Objects.hashCode(this.terrainEffect);
        hash = 97 * hash + Objects.hashCode(this.terrainType);
        hash = 97 * hash + Objects.hashCode(this.sicknessType);
        hash = 97 * hash + Objects.hashCode(this.sicknessEffect);
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.mortalityRate) ^ (Double.doubleToLongBits(this.mortalityRate) >>> 32));
        return hash;
    }

    @Override
    public String toString() {
        return "RegularScene{" + "sceneName=" + sceneName + ", description=" + description + ", terrainEffect=" + terrainEffect + ", terrainType=" + terrainType + ", sicknessType=" + sicknessType + ", sicknessEffect=" + sicknessEffect + ", mortalityRate=" + mortalityRate + '}';
    }
    
    

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RegularScene other = (RegularScene) obj;
        if (Double.doubleToLongBits(this.mortalityRate) != Double.doubleToLongBits(other.mortalityRate)) {
            return false;
        }
        if (!Objects.equals(this.sceneName, other.sceneName)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.terrainEffect, other.terrainEffect)) {
            return false;
        }
        if (!Objects.equals(this.terrainType, other.terrainType)) {
            return false;
        }
        if (!Objects.equals(this.sicknessType, other.sicknessType)) {
            return false;
        }
        if (!Objects.equals(this.sicknessEffect, other.sicknessEffect)) {
            return false;
        }
        return true;
    }
    
    
            
}
