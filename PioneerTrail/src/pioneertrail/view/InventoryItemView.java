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
            input += ("\n\t" + count + " - " + item.getItemType());
        }
        
        //InventoryControl.listItemsAlphabetically();
        
        input += ("\nEnter your selection(Press Q to quit): ");

        return input;
    }

//    @Override
//    public String[] getInputs() {
//        String[] inputs = new String[1];
//        boolean valid = false;
//
//        while (valid == false) {
//            System.out.println("**********"
//                    + "\nInventory Item List"
//                    + "\n**********");
//            int count = 0;
//            for (InventoryItem item : PioneerTrail.getCurrentGame().getWagon().getItems()) {
//                count++;
//                System.out.println("\t" + count + " - " + item.getItemType());
//            }
//            System.out.println("Enter your selection(Press Q to quit): ");
//            Scanner scanner = new Scanner(System.in);
//            inputs[0] = scanner.nextLine();
//            inputs[0] = inputs[0].trim();
//
//            if (inputs[0].length() < 1) {
//                System.out.println("You must enter a non-blank value");
//                continue; //Move to the top of the loop and repeat
//            }
//            valid = true;
//            return inputs;
//        }
//        return inputs;
//    }
    @Override
    public boolean doAction(String inputs) {

        String item = inputs.toUpperCase();

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
