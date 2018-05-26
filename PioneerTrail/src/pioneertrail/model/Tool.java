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
public class Tool implements Serializable {

    //class instance variables
    private char action;
    private int durability;
    private String toolType;
    private int multiplier;

    public Tool() {
    }

    public char getAction() {
        return action;
    }

    public void setAction(char action) {
        this.action = action;
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        if (durability < 0)
            this.durability = 0;
        else
            this.durability = durability;
    }

    public String getToolType() {
        return toolType;
    }

    public void setToolType(String toolType) {
        this.toolType = toolType;
    }

    public int getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(int multiplier) {
        this.multiplier = multiplier;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + this.action;
        hash = 23 * hash + this.durability;
        hash = 23 * hash + Objects.hashCode(this.toolType);
        hash = 23 * hash + this.multiplier;
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
        final Tool other = (Tool) obj;
        if (this.action != other.action) {
            return false;
        }
        if (this.durability != other.durability) {
            return false;
        }
        if (this.multiplier != other.multiplier) {
            return false;
        }
        if (!Objects.equals(this.toolType, other.toolType)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tool{" + "action=" + action + ", durability=" + durability + ", toolType=" + toolType + ", multiplier=" + multiplier + '}';
    }


}
