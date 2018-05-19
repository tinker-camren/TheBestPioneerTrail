/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pioneertrail.model;

import java.io.Serializable;

/**
 *
 * @author Danica
 */
public class Wagon implements Serializable{
    
    //class instance variables
    private int health;
    private double inventoryWeight;

    public Wagon() {
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }    

    public double getInventoryWeight() {
        return inventoryWeight;
    }

    public void setInventoryWeight(double inventoryWeight) {
        this.inventoryWeight = inventoryWeight;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + this.health;
        hash = 73 * hash + (int) (Double.doubleToLongBits(this.inventoryWeight) ^ (Double.doubleToLongBits(this.inventoryWeight) >>> 32));
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
        final Wagon other = (Wagon) obj;
        if (this.health != other.health) {
            return false;
        }
        if (Double.doubleToLongBits(this.inventoryWeight) != Double.doubleToLongBits(other.inventoryWeight)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Wagon{" + "health=" + health + ", inventoryWeight=" + inventoryWeight + '}';
    }
    
}
