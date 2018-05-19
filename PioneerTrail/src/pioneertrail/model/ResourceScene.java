/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pioneertrail.model;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author tinkerc
 */
public class ResourceScene {

    //Class instance variables
    private int amount;
    private String sceneItemType;
    private ArrayList<InventoryItem> inventoryItems = new ArrayList<InventoryItem>();

    public ResourceScene() {
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getSceneItemType() {
        return sceneItemType;
    }

    public void setSceneItemType(String sceneItemType) {
        this.sceneItemType = sceneItemType;
    }

    public ArrayList<InventoryItem> getInventoryItems() {
        return inventoryItems;
    }

    public void setInventoryItems(ArrayList<InventoryItem> inventoryItems) {
        this.inventoryItems = inventoryItems;
    }



    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.amount;
        hash = 71 * hash + Objects.hashCode(this.sceneItemType);
        hash = 71 * hash + Objects.hashCode(this.inventoryItems);
        return hash;
    }

    @Override
    public String toString() {
        return "ResourceScene{" + "amount=" + amount + ", sceneItemType=" + sceneItemType + ", inventoryItems=" + inventoryItems + '}';
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
        final ResourceScene other = (ResourceScene) obj;
        if (this.amount != other.amount) {
            return false;
        }
        if (!Objects.equals(this.sceneItemType, other.sceneItemType)) {
            return false;
        }
        if (!Objects.equals(this.inventoryItems, other.inventoryItems)) {
            return false;
        }
        return true;
    }

}
