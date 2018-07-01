/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pioneertrail.model;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;

/**
 *
 * @author Danica
 */
public class InventoryItem implements Serializable {

    //class instance variables
    private double weight;
    private String description;
    private String itemType;
    private int count;
    private Game game;
    private int price;

    public InventoryItem() {
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
    
    public static Comparator<InventoryItem> itemTypeComparator = new Comparator<InventoryItem>() {

	public int compare(InventoryItem item1, InventoryItem item2) {
	   String ItemType1 = item1.getItemType().toUpperCase();
	   String ItemType2 = item2.getItemType().toUpperCase();

	   //ascending order
	   return ItemType2.compareTo(ItemType1);

	   //descending order
	   //return ItemType2.compareTo(ItemType1);
    }};
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.weight) ^ (Double.doubleToLongBits(this.weight) >>> 32));
        hash = 59 * hash + Objects.hashCode(this.description);
        hash = 59 * hash + Objects.hashCode(this.itemType);
        hash = 59 * hash + this.count;
        hash = 59 * hash + Objects.hashCode(this.game);
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
        final InventoryItem other = (InventoryItem) obj;
        if (Double.doubleToLongBits(this.weight) != Double.doubleToLongBits(other.weight)) {
            return false;
        }
        if (this.count != other.count) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.itemType, other.itemType)) {
            return false;
        }
        if (!Objects.equals(this.game, other.game)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "InventoryItem{" + "weight=" + weight + ", description=" + description + ", itemType=" + itemType + ", count=" + count + ", game=" + game + '}';
    }

    public void displayInventoryItem() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("List of inventory items will be here.");
    }

}
