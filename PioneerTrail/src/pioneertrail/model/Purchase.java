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
public class Purchase implements Serializable {

    //class instance variables
    private String name;
    private double price;
    private String type;
    private int weight;
    private int count;
    private String description;
    private ArrayList<InventoryItem> items;
    private Tool[] tools;
    private int money;
    private InventoryItem currentItem;

    public Tool[] getTools() {
        return tools;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setTools(Tool[] tools) {
        this.tools = tools;
    }

    public ArrayList<InventoryItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<InventoryItem> items) {
        this.items = items;
    }

    public Purchase() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public InventoryItem getCurrentItem() {
        return currentItem;
    }

    public void setCurrentItem(InventoryItem currentItem) {
        this.currentItem = currentItem;
    }

    @Override
    public String toString() {
        return "Purchase Items{" + "price=" + price + ", weight=" + weight + ", type=" + type + ", count=" + count + ", description=" + description + '}';
    }

}
