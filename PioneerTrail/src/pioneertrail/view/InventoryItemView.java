/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pioneertrail.view;

import java.util.ArrayList;
import java.util.Scanner;
import pioneertrail.PioneerTrail;
import pioneertrail.model.InventoryItem;

/**
 *
 * @author Kathy
 */
class InventoryItemView {

    private String InventoryItem;
        void displayInventoryItemView() {
        boolean endView = false;
        
        ArrayList<InventoryItem> item = PioneerTrail.getCurrentGame().getWagon().getItems();
        
        do {

            String[] inputs = this.getInputs();
            String toUpperCase = inputs[0].toUpperCase();
            if (toUpperCase.equals("Q") || inputs[0].length() < 1) {
                return;
            }
            endView = doAction(inputs);
        } while (endView != true);
    }
         

    private String[] getInputs() {
        String[] inputs = new String[1];
        boolean valid = false;
        
        while (valid == false) {
            System.out.println("**********"
                    + "\nInventory Item List"
                    + "\n**********");
            int count = 0;
            for (InventoryItem item : PioneerTrail.getCurrentGame().getWagon().getItems()){
                count++;
                System.out.println("\t"+count+" - "+ item.getItemType());
            }
            System.out.println("Enter your selection(Press Q to quit): ");
            Scanner scanner = new Scanner(System.in);
            inputs[0] = scanner.nextLine();
            inputs[0] = inputs[0].trim();
            
            if (inputs[0].length() < 1) {
                System.out.println("You must enter a non-blank value");
                continue; //Move to the top of the loop and repeat
            }
            valid = true;
            return inputs;
    }
        return inputs;
    }
    private boolean doAction(String[] inputs) {

        String item = inputs[0].toUpperCase();

        int value = Integer.parseInt(item);
        if ((value < 1) || (value > item.length())) {
            System.out.println("Invalid menu item");
            
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
        System.out.println("Description: " + item.length());
        System.out.println("Count: " + item.length());
        System.out.println("Type: " + item.length());
        System.out.println("Weight: " + item.length());
        
        return false;
    }
}

    

    
