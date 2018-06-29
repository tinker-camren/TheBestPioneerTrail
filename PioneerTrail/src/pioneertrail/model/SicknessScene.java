/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pioneertrail.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author tinkerc
 */
public class SicknessScene extends Scene implements Serializable{

    // class instance variables
    private String description;
    private String sicknessType;
    private double mortalityRate;
    private ArrayList<InventoryItem> sicknessItems = new ArrayList<InventoryItem>();

    public SicknessScene() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSicknessType() {
        return sicknessType;
    }

    public void setSicknessType(String sicknessType) {
        this.sicknessType = sicknessType;
    }
    public double getMortalityRate() {
        return mortalityRate;
    }

    public void setMortalityRate(double mortalityRate) {
        this.mortalityRate = mortalityRate;
    }

    public ArrayList<InventoryItem> getSicknessItems() {
        return sicknessItems;
    }

    public void setSicknessItems(ArrayList<InventoryItem> sicknessItems) {
        this.sicknessItems = sicknessItems;
    }

    @Override
    public String toString() {
        return "SicknessScene{" + "description=" + description + ", sicknessType=" + sicknessType + ", mortalityRate=" + mortalityRate + ", sicknessItems=" + sicknessItems + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.description);
        hash = 17 * hash + Objects.hashCode(this.sicknessType);
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.mortalityRate) ^ (Double.doubleToLongBits(this.mortalityRate) >>> 32));
        hash = 17 * hash + Objects.hashCode(this.sicknessItems);
        return hash;
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
        final SicknessScene other = (SicknessScene) obj;
        if (Double.doubleToLongBits(this.mortalityRate) != Double.doubleToLongBits(other.mortalityRate)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.sicknessType, other.sicknessType)) {
            return false;
        }
        if (!Objects.equals(this.sicknessItems, other.sicknessItems)) {
            return false;
        }
        return true;
    }

}
