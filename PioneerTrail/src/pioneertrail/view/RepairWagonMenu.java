/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pioneertrail.view;

import java.util.Scanner;
import pioneertrail.control.ToolControl;
import pioneertrail.model.InventoryItem;
import pioneertrail.model.Tool;
import pioneertrail.model.Wagon;

/**
 *
 * @author Suckafish
 */
class RepairWagonMenu {

    void displayRepairWagonMenu() {
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
            String[] inputs = new String[1];
            boolean valid = false;
            
            while (valid == false) {
                System.out.println("**********"
                        + "\nRepair Wagon Menu"
                        + "\n**********");

                System.out.println("\nEnter the amount of wood you would like to use, or press enter to return to the previous menu: ");
                Scanner scanner = new Scanner(System.in);
                inputs[0] = scanner.nextLine();
                inputs[0] = inputs[0].trim();

                    if (inputs[0].length() < 1) {
                        return inputs;
                    }
                valid = true;
                return inputs;
        }

        return inputs;
    }

    private boolean doAction(String[] inputs) {
        
        try {
            int menuItem = Integer.parseInt(inputs[0]);
        }
        catch(Exception ex) {
          System.out.println("\nError: You must enter a number");
          return false;
        }
        
        int menuItem = Integer.parseInt(inputs[0]);

        //Create instances for testing
        Wagon wagon = new Wagon(); 
            wagon.setHealth(80);
            wagon.setMaxHealth(100);
            wagon.setWeight(250);

        Tool hammer = new Tool();
            hammer.setDurability(85);
            hammer.setMultiplier(2);
            hammer.setToolType("Hammer");

        InventoryItem wood = new InventoryItem();
            wood.setCount(25);
            wood.setDescription("Used to repair wagons");
            wood.setItemType("Wood");
        //End create instances
        
        if (menuItem <= wood.getCount()) {
            int woodUsage = (wood.getCount() - menuItem);
            System.out.println(woodUsage);
            wood.setCount(menuItem);
            int result = ToolControl.repairWagon(wood, hammer, wagon);
            System.out.println("Wagon new health is: " + result);
            wood.setCount(woodUsage);
            System.out.println("You now have " + wood.getCount() + " wood.");
            System.out.println("Tool Durability is now " + hammer.getDurability());
        } else {
            System.out.println("You don't have that much wood");   
        }
            
        return false;
    }
}
    

