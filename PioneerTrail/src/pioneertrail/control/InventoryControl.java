/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pioneertrail.control;

import java.util.ArrayList;
import java.util.Collections;
import pioneertrail.PioneerTrail;
import pioneertrail.exceptions.InventoryControlException;
import pioneertrail.model.ActorObject;
import pioneertrail.model.InventoryItem;
import pioneertrail.model.Purchase;
import pioneertrail.model.Wagon;

/**
 *
 * @author tinkerc
 */
public class InventoryControl {

    public static double calcNewWeight(InventoryItem InventoryItem, Wagon Wagon)
            throws InventoryControlException {

//        BEGIN
//            IF (inventoryItem.getWeight < 1) THEN
//                RETURN -1
// 
//            IF (inventoryItem.getCount < 1) THEN
//                RETURN -2
//
//            IF wagon.getWeight +  (inventoryItem.getWeight * inventoryItem.getCount) > maxWeight THEN
//                RETURN -3
//            RETURN wagon.getWeight + (inventoryItem.getWeight * inventoryItem.getCount)
//        END 	
        if (InventoryItem.getWeight() < 1) {
            throw new InventoryControlException("Inventory Weight cannot be less than 1");
        }

        if (InventoryItem.getCount() < 1) {
            throw new InventoryControlException("Inventory amount cannot be less than 1");
        }

        if (Wagon.getWeight() + (InventoryItem.getWeight() * InventoryItem.getCount()) > Wagon.getMaxWeight()) {
            throw new InventoryControlException("Inventory Weight cannot exceed wagon weight");
        }

        return Wagon.getWeight() + (InventoryItem.getWeight() * InventoryItem.getCount());
    }

    public static String listItems() {

        ArrayList<InventoryItem> items = PioneerTrail.getCurrentGame().getWagon().getItems();
        String output = "";
        for (int i = 0; i < items.size(); i++) {
            InventoryItem item = items.get(i);
            output += ("\n\nItem: " + item.getItemType()
                    + "\nPrice: $" + item.getPrice()
                    + "\nQuantity: " + item.getCount()
                    + "\nWeight: " + item.getWeight() + " lbs"
                    + "\nDescription: " + item.getDescription());
        }
        return output;
    }

    public static void listItemsAlphabetically(ArrayList<InventoryItem> items) {

        //ArrayList<InventoryItem> items = PioneerTrail.getCurrentGame().getWagon().getItems();
        //Sorting based on Actor Name
        Collections.sort(items, InventoryItem.itemTypeComparator);

        for (InventoryItem item : items) {
            System.out.println("\nItem: " + item.getItemType()
                    + "\nQuantity: " + item.getCount()
                    + "\nWeight: " + item.getWeight() + " lbs"
                    + "\nDescription: " + item.getDescription());
        }
    }

    public static void listPriceSort() {
        ArrayList<InventoryItem> items = PioneerTrail.getCurrentGame().getWagon().getItems();
        System.out.println("******************************"
                + "\nPrices from lowest to highest:"
                + "\n******************************");
        Collections.sort(items, InventoryItem.PriceSort);
        for (InventoryItem item : items) {
            System.out.println("| ... $"
                    + item.getPrice()
                    + " : "
                    + item.getItemType());
        }
    }

    public static double money(InventoryItem item, Purchase purchase, Wagon wagon)
            throws InventoryControlException {
//        
        if (purchase.getMoney() < 1) {
            throw new InventoryControlException("Money cannot be less than 1");
        }

        if (purchase.getMoney() > 100) {
            throw new InventoryControlException("Money cannot be greater than 100");
        }
//        
        purchase.setMoney(purchase.getMoney() - item.getPrice() * item.getCount());
        //purchase.setMoney(purchase.getMoney() - item.getPrice());

        return purchase.getMoney();
    }

    public static double purchase(InventoryItem item, Wagon Wagon, Purchase purchase)
            throws InventoryControlException {

        if (item.getCount() < 1) { //is item count 0 or negative?
            throw new InventoryControlException("Item count cannot be less than 1");
        }

        if (item.getCount() > 100) { //is item count greater than 100?
            throw new InventoryControlException("Item count cannot be greater than 100");
        }

        item.setCount(purchase.getCount() + item.getCount());

        return item.getCount();
    }

}

//    public int getPriceItems(int[] prices) {
//        
//        int total = 0;
//        
//        for (int price : prices ) {
//            total += price;
//            System.out.println("\nPrice: $" + prices.getPrice());
//        }
//        return total;
//    }
