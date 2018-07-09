/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pioneertrail.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Danica
 */
public class Game implements Serializable {

    private double milesTraveled;
    private int numPeople;
    private Player player;
    private Wagon wagon;
    private Tool tool;
    private InventoryItem item;
    private ActorObject[] actors = new ActorObject[4];
    private ArrayList<InventoryItem> items;
    private Map map;
    private Purchase purchase;
    private ActorObject sickActor;

    public Purchase getPurchase() {
        return purchase;
    }

    public ActorObject getSickActor() {
        return sickActor;
    }

    public void setSickActor(ActorObject sickActor) {
        this.sickActor = sickActor;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

    /**
     * Get the value of items
     *
     * @return the value of items
     */
    public ArrayList<InventoryItem> getItems() {
        return items;
    }

    /**
     * Set the value of items
     *
     * @param items new value of items
     */
    public void setItems(ArrayList<InventoryItem> items) {
        this.items = items;
    }

    public Game() {
//        //Create instances for testing
//        wagon = new Wagon(); 
//            wagon.setHealth(80);
//            wagon.setMaxHealth(100);
//            wagon.setWeight(250);
//
//        Tool hammer = new Tool();
//            hammer.setDurability(85);
//            hammer.setMultiplier(2);
//            hammer.setToolType("Hammer");
//            
//        Tool gun = new Tool();
//            gun.setDurability(60);
//            gun.setMultiplier(2);
//            gun.setToolType("Gun");
//            
//        Tool axe = new Tool();
//            axe.setDurability(70);
//            axe.setMultiplier(2);
//            axe.setToolType("Axe");
//
//
//        InventoryItem wood = new InventoryItem();
//            wood.setCount(25);
//            wood.setDescription("Used to repair wagons");
//            wood.setItemType("Wood");
//            
//        InventoryItem water = new InventoryItem();
//            water.setCount(10);
//            water.setDescription("Powerhouse of life");
//            water.setItemType("Water");
//            water.setWeight(water.getCount() * 5);
//            
//        //add to InventoryItems arraylist in the wagon class
//        wagon.getItems().add(0, wood);
//        wagon.getItems().add(1, water);
//        
//        //add tools to arraylist in the wagon class
//        wagon.getTools().add(0, hammer);
//        wagon.getTools().add(1, gun);
//        wagon.getTools().add(2, axe);
//        //End create instances
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public ActorObject[] getActors() {
        return actors;
    }

    public void setActors(ActorObject[] actors) {
        this.actors = actors;
    }

    public Wagon getWagon() {
        return wagon;
    }

    public void setWagon(Wagon wagon) {
        this.wagon = wagon;
    }

    public Tool getTool() {
        return tool;
    }

    public void setTool(Tool tool) {
        this.tool = tool;
    }

    public InventoryItem getItem() {
        return item;
    }

    public void setItem(InventoryItem item) {
        this.item = item;
    }

    public double getMilesTraveled() {
        return milesTraveled;
    }

    public void setMilesTraveled(double milesTraveled) {
        this.milesTraveled = milesTraveled;
    }

    public int getNumPeople() {
        return numPeople;
    }

    public void setNumPeople(int numPeople) {
        this.numPeople = numPeople;
    }
    
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.milesTraveled) ^ (Double.doubleToLongBits(this.milesTraveled) >>> 32));
        hash = 97 * hash + this.numPeople;
        return hash;
    }

    @Override
    public String toString() {
        return "Game{" + "milesTraveled=" + milesTraveled + ", numPeople=" + numPeople + ", player=" + player + '}';
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
        final Game other = (Game) obj;
        if (Double.doubleToLongBits(this.milesTraveled) != Double.doubleToLongBits(other.milesTraveled)) {
            return false;
        }
        if (this.numPeople != other.numPeople) {
            return false;
        }
        return true;
    }

}
