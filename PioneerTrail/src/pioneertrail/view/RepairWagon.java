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
public class RepairWagon {
    
    public void testInstances() {

    }
        
        public void displayRepairWagon() {
        boolean endView = false;
        
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
            System.out.println("\ngetInputs() called");
            String[] inputs = new String[1];
            boolean valid = false;
            
            ArrayList<InventoryItem> items = new ArrayList<InventoryItem>();
            Game game = PioneerTrail.getCurrentGame();
            Wagon wagon = game.getWagon();
            System.out.println(wagon.getItems());
            items = wagon.getItems();
            InventoryItem item = items.get(0);
            Tool tool = wagon.getTools().get(0);

            while (valid == false) {
                System.out.println("**********"
                        + "\nRepair Wagon"
                        + "\n**********");
                System.out.println("\nWagon Health: " + wagon.getHealth());
                
                if (tool.getToolType().equalsIgnoreCase("Hammer")) {
                    if (tool.getDurability() > 0) {
                        System.out.println("Hammer Durability: " + tool.getDurability());
                    } else {
                        System.out.println("Hammer broken or non-existent");
                    }
                } else {
                    System.out.println("Hammer broken or non-existent");
                }
                if (item.getItemType().equalsIgnoreCase("Wood")) {
                    if (item.getCount() > 0) {
                        System.out.println("Wood Amount: " + item.getCount());
                    } else {
                        System.out.println("No wood. You must gather wood before repairing"
                                + " your wagon");
                    }
                } else {
                    System.out.println("No wood. You must gather wood before repairing"
                            + " your wagon");
                }
                System.out.println("\nR - Repair Wagon "
                        + "\nQ - Quit");
                
                System.out.println("Enter your selection: ");
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

        String menuItem = inputs[0].toUpperCase();
        
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
        repairWagonMenu.displayRepairWagonMenu();
    }
}

