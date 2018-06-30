/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pioneertrail.view;

import java.util.ArrayList;
import pioneertrail.PioneerTrail;
import pioneertrail.control.InventoryControl;
import pioneertrail.model.Game;
import pioneertrail.model.InventoryItem;
import pioneertrail.model.InventoryItemEnum;
import pioneertrail.model.Purchase;

/**
 *
 * @author Danica
 */
class SupplyPurchase extends View {

    public SupplyPurchase() {
        displayMessage = buildMenu();
    }

    private String buildMenu() {

//        ArrayList<InventoryItem> items = new ArrayList<InventoryItem>();
//        Game game = PioneerTrail.getCurrentGame();
//        //Wagon wagon = game.getWagon();
//        //items = wagon.getItems();
//        InventoryItem item = items.get(0);
        String input = "\n************"
                + "\nStore Items"
                + "\n************";

        Game game = PioneerTrail.getCurrentGame();
        Purchase purchase = game.getPurchase();
        InventoryItem item = new InventoryItem();
        InventoryControl.listItems();

        input += "\n***********************"
                + "\nPurchase Supplies Menu"
                + "\n***********************";

        //InventoryControl.listItems();
        input += ("\nMoney $"
                + purchase.getMoney());

        ArrayList<InventoryItem> items = game.getWagon().getItems();
        int count = 0;
        double maxPrice = 0;
        double minPrice = 0;
        for (InventoryItem currentItem : items) {
            input += "\n" + count + " - $" + currentItem.getPrice() + ": " + currentItem.getItemType();
//            if (count == 0) {
//                maxPrice = currentItem.getPrice();
//                minPrice = currentItem.getPrice();
//            } else {
//                maxPrice = count[0];
//                for(int i = 1; i < count.length; i++) {
//                if(currentItem.count[i] > maxPrice){
//                    maxPrice = count()[i];
//                }
//            }
                
                //Math.max maxPrice = currentItem.getPrice();
               // math.max/min 
               //maxPrice = math.max maxprice, currentItem.getPrice
            //}
            count ++;
//            return maxPrice;
        }
        
        //////////////////////////
//        String buildMenuFromList(ArrayList<Item> items){
//     String myMenu = "";
//     int count = 0;
//     for( Item item : items) {
//        myMenu += "\n" + count + " - " item.getName();
//         count++;
//    }
        //////////////////////
        
//        +"\n\nT - Wood"
//                + "\nP - Potatoes"
//                + "\nW - Water"
//                + "\nM - Meat"
                input += "\nH = Highest priced item = " + maxPrice; 
                input += "\nL - Lowest priced item = " + minPrice;
        

        if (purchase.getMoney() > 0) {
            input += ("\n\nMoney: $" + purchase.getMoney());
        } else {
            input += ("\nYou are out of money");
        }

        input += ("\n\nEnter your selection or enter Q to quit:");

        return input;
        

//    void displaySupplyPurchase() {
//        
//        InventoryItem item = new InventoryItem();
//
//       InventoryControl.listItems();
    }

    @Override
    public boolean doAction(String inputs) {

        String menuItem = inputs.toUpperCase();

        switch (menuItem) {
//            case "T":
//                purchaseMenu();
//                break;
//            case "P":
//                purchaseMenu();
//                break;
//            case "W":
//                purchaseMenu();
//                break;
//            case "M":
//                purchaseMenu();
//                break;
            case "H":
                highPricedItem();
                break;
            case "L":
                lowPricedItem();
                break;

            default:
                System.out.println("Invalid menu item");
        }

            //items.get(inputs);
        return false;
    }
//        try {
//            int menuItem = Integer.parseInt(inputs);
//        } catch (Exception ex) {
//            System.out.println("\nInvalid input, please enter a number");
//            return false;
//        }
////
//        int menuItem = Integer.parseInt(inputs);
//        InventoryItem item = new InventoryItem();
//        //InventoryItem[] item = pioneertrail.PioneerTrail.getCurrentGame().getItems();
//
//        switch (menuItem) {
//            case 1:
//                item = items[InventoryItemEnum.Wood.ordinal()];
//                purchaseMenu();
//                break;
//            case 2:
//                item = items[InventoryItemEnum.Potatoes.ordinal()];
//                purchaseMenu();
//                break;
//            case 3:
//                item = items[InventoryItemEnum.Water.ordinal()];
//                purchaseMenu();
//                break;
//            case 4:
//                item = items[InventoryItemEnum.Meat.ordinal()];
//                purchaseMenu();
//                break;
//
//            default:
//                System.out.println("Invalid menu item");
//
//        }
//
//        return false;
//    }

    private void purchaseMenu() {
        PurchaseMenu purchaseMenu = new PurchaseMenu();
        purchaseMenu.displayPurchaseMenu();
    }

    private void highPricedItem() {
        HighPricedItem highPricedItem = new HighPricedItem();
        highPricedItem.display();
    }

    private void lowPricedItem() {
        LowPricedItem lowPricedItem = new LowPricedItem();
        lowPricedItem.display();
    }
}
