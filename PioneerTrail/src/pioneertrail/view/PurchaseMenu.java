/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pioneertrail.view;

import pioneertrail.PioneerTrail;
import pioneertrail.control.InventoryControl;
import pioneertrail.model.Game;
import pioneertrail.model.InventoryItem;
import pioneertrail.model.Purchase;
import pioneertrail.model.Wagon;

/**
 *
 * @author Danica
 */
class PurchaseMenu extends View {

    public PurchaseMenu(InventoryItem item) {
        displayMessage = buildMenu(item);
    }
    
    private String buildMenu(InventoryItem item) {
    String input = "**************************\n"
            + item.getItemType() + " purchase menu"
            + "\n**************************\n\n"
            + item.getItemType() 
            + "\nA - Purchase 1"
            + "\nB - Purchase 10"
            + "\nC - Purchase 20"
            + "\n\nQ - Return to Previous MENU";
    
            InventoryControl.listPriceSort();
    
    return input;
}
    
@Override
 public boolean doAction(String inputs) {
     
        Game game = PioneerTrail.getCurrentGame();
        Wagon wagon = game.getWagon();
        InventoryItem item = new InventoryItem();
        
        double equation = item.getPrice() - item.getCount();
        
        String menuItem = inputs.toUpperCase();

//        String menuItem = inputs[0].toUpperCase();
//
//        if (menuItem.compareToIgnoreCase("Y") == 0) {
//            System.out.println("You chopped some wood!");
//            return false;
//        }
//        else if (menuItem.compareToIgnoreCase("N") == 0) {
//            System.out.println("You decided not to chop wood.");
//            return false;
//        } else {
//            System.out.println("Invalid menu item");
//        }
//        return false;
        
        if (menuItem.compareToIgnoreCase("A") == 0) {
            item.setCount(item.getCount());
            this.console.println("Purchase 1" + item.getCount());
            return false;
        } else if (menuItem.compareToIgnoreCase("B") == 0) {
            item.setCount(item.getCount() * 10);
            this.console.println("Purchase 10" + item.getCount());
            return false;
        }  else if (menuItem.compareToIgnoreCase("C") == 0) {
            item.setCount(item.getCount() * 20);
            this.console.println("Purchase 20" + item.getCount());
            return false;
        } else {
            this.console.println("Invalid menu item");
        }
        //return false;
        
        switch (menuItem) {
            case "Q":
                //mainMenuView();
                return true;  

            default:
                ErrorView.display(this.getClass().getName(), "Invalid menu item");
        }
        
        //this.console.println("amount: " + item.getCount());
        
        return false;
    }
}
