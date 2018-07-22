/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pioneertrail.view;

import java.util.ArrayList;
import java.util.Scanner;
import pioneertrail.PioneerTrail;
import pioneertrail.control.InventoryControl;
import pioneertrail.exceptions.InventoryControlException;
import pioneertrail.model.InventoryItem;

/**
 *
 * @author Kathy
 */
class InventoryItemView extends View {

    public InventoryItemView() {
        displayMessage = buildMenu();
    }

    private String buildMenu() {
        String input = "**********"
                + "\nInventory Item List"
                + "\n**********";

        int count = 0;
        for (InventoryItem item : PioneerTrail.getCurrentGame().getWagon().getItems()) {
            count++;
            input += ("\n\t" + count + " - " + item.getItemType() + "\t - Qty: " + item.getCount());
        }
        
        //InventoryControl.listItemsAlphabetically();
        
        input += ("\n\nEnter your selection(Press Q to quit): ");

        return input;
    }

    @Override
    public boolean doAction(String inputs) {
//        try {
//            InventoryControl.calcNewWeight(InventoryItem, Wagon);
//        } catch (InventoryControlException ie) {
//            this.console.println(ie.getMessage());
//        }

        String item = inputs.toUpperCase();

        int value = Integer.parseInt(item);
        if ((value < 1) || (value > item.length())) {
            ErrorView.display(this.getClass().getName(), "Invalid menu item");

            return false;
        }
//        item = new InventoryItem();
//        item.setDescription("water");
//        item.setCount(5);
//        item.setItemType("drink");
//        item.setWeight(3);
//        items.add(item);
//        game.setItems(items);

        value--;
        this.console.println("Description: " + item.length());
        this.console.println("Count: " + item.length());
        this.console.println("Type: " + item.length());
        this.console.println("Weight: " + item.length());

        return false;
    }
}
