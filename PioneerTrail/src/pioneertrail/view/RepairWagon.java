/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pioneertrail.view;

import java.util.Scanner;
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
    }
        
        public void displayRepairWagonView() {
        boolean endView = false;
        
        do {

            String[] inputs = this.getInputs();
            String toUpperCase = inputs[0].toUpperCase();
            if (toUpperCase.equals("Q") || inputs[0].length() < 1) {
                java.lang.System.exit(0);
            }
            endView = doAction(inputs);
        } while (endView != true);

    }
        
        private String[] getInputs() {
            System.out.println("\ngetInputs() called");
            String[] inputs = new String[1];
            boolean valid = false;
            
            //Create instances for testing
            Wagon wagon = new Wagon(); 
                wagon.setHealth(80);
                wagon.setWeight(250);
            
            Tool hammer = new Tool();
                hammer.setDurability(85);
                hammer.setMultiplier(2);
                hammer.setToolType("Hammer");
                
            InventoryItem wood = new InventoryItem();
                wood.setCount(10);
                wood.setDescription("Wood");
                wood.setItemType("Wood");
                wood.setWeight(20);
            //End create instances
            
            int wagonHealth = wagon.getHealth();
            String tool = hammer.getToolType();

            while (valid == false) {
                System.out.println("**********"
                        + "\nRepair Wagon"
                        + "\n**********");
                System.out.println("\nWagon Health: " + wagonHealth
                        + " \nAvailable Tools: " + tool);
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

        switch (menuItem) {
            case "N":
                startNewGame();
                break;
            case "R":
                restartGame();
                break;
            case "H":
                getHelp();
                break;
            case "E":
                return true;

            default:
                System.out.println("Invalid menu item");

        }

        return false;
    }
}
}
