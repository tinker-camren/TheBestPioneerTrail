/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pioneertrail.view;

import java.util.ArrayList;
import java.util.Scanner;
import pioneertrail.PioneerTrail;
import pioneertrail.control.ToolControl;
import pioneertrail.model.Game;
import pioneertrail.model.InventoryItem;
import pioneertrail.model.Tool;
import pioneertrail.model.Wagon;

/**
 *
 * @author Camren
 */
public class RepairWagon extends View {

    public RepairWagon() {
        displayMessage = buildMenu();
    }

    private String buildMenu() {

        ArrayList<InventoryItem> items = new ArrayList<InventoryItem>();
        Game game = PioneerTrail.getCurrentGame();
        Wagon wagon = game.getWagon();
        items = wagon.getItems();
        InventoryItem item = items.get(0);
        Tool tool = wagon.getTools().get(0);

        String input = "\n**********"
                + "\nRepair Wagon"
                + "\n**********";
        input += ("\n\nWagon Health: " + wagon.getHealth());

        if (tool.getToolType().equalsIgnoreCase("Hammer")) {
            if (tool.getDurability() > 0) {
                input += ("\nHammer Durability: " + tool.getDurability());
            } else {
                input += ("\nHammer broken or non-existent");
            }
        } else {
            input += ("\nHammer broken or non-existent");
        }
        if (item.getItemType().equalsIgnoreCase("Wood")) {
            if (item.getCount() > 0) {
                input += ("\nWood Amount: " + item.getCount());
            } else {
                input += ("\nNo wood. You must gather wood before repairing"
                        + " your wagon");
            }
        } else {
            input += ("\nNo wood. You must gather wood before repairing"
                    + " your wagon");
        }
        input += ("\n\nR - Repair Wagon "
                + "\nQ - Quit ");
        input += this.getInput("Enter your selection: ");
        //input = input;

        return input;

//        String[] inputs = new String[1];
//
//        ArrayList<InventoryItem> items = new ArrayList<InventoryItem>();
//        Game game = PioneerTrail.getCurrentGame();
//        Wagon wagon = game.getWagon();
//        items = wagon.getItems();
//        InventoryItem item = items.get(0);
//        Tool tool = wagon.getTools().get(0);
//
//        System.out.println("**********"
//                + "\nRepair Wagon"
//                + "\n**********");
//        System.out.println("\nWagon Health: " + wagon.getHealth());
//
//        if (tool.getToolType().equalsIgnoreCase("Hammer")) {
//            if (tool.getDurability() > 0) {
//                System.out.println("Hammer Durability: " + tool.getDurability());
//            } else {
//                System.out.println("Hammer broken or non-existent");
//            }
//        } else {
//            System.out.println("Hammer broken or non-existent");
//        }
//        if (item.getItemType().equalsIgnoreCase("Wood")) {
//            if (item.getCount() > 0) {
//                System.out.println("Wood Amount: " + item.getCount());
//            } else {
//                System.out.println("No wood. You must gather wood before repairing"
//                        + " your wagon");
//            }
//        } else {
//            System.out.println("No wood. You must gather wood before repairing"
//                    + " your wagon");
//        }
//        System.out.println("\nR - Repair Wagon "
//                + "\nQ - Quit");
//        String input = this.getInput("Enter your selection: ");
//        inputs[0] = input;
//
//        if (inputs[0].length() < 1) {
//            System.out.println("You must enter a non-blank value");
//        }
//
//        return inputs;
    }

    @Override
    public boolean doAction(String inputs) {

        String menuItem = inputs.toUpperCase();

        if ("R".equals(menuItem)) {
            repairWagonMenu();
        } else if ("Q".equals(menuItem)) {
            return true;
        } else {
            System.out.println("Invalid menu item");
        }

        return false;
    }

    private void repairWagonMenu() {
        RepairWagonMenu repairWagonMenu = new RepairWagonMenu();
        repairWagonMenu.display();
    }
}
