/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pioneertrail.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Danica
 */
public class Wagon implements Serializable {

    //class instance variables
    private int health;
    private int maxHealth;
    private double inventoryWeight;
    private Player player;

    public Wagon() {
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public double getInventoryWeight() {
        return inventoryWeight;
    }

    public void setInventoryWeight(double inventoryWeight) {
        this.inventoryWeight = inventoryWeight;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + this.health;
        hash = 83 * hash + this.maxHealth;
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.inventoryWeight) ^ (Double.doubleToLongBits(this.inventoryWeight) >>> 32));
        hash = 83 * hash + Objects.hashCode(this.player);
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
        if (this.maxHealth != other.maxHealth) {
            return false;
        }
        if (Double.doubleToLongBits(this.inventoryWeight) != Double.doubleToLongBits(other.inventoryWeight)) {
            return false;
        }
        if (!Objects.equals(this.player, other.player)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Wagon{" + "health=" + health + ", maxHealth=" + maxHealth + ", inventoryWeight=" + inventoryWeight + ", player=" + player + '}';
    }


}
