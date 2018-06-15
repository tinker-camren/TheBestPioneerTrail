/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pioneertrail.view;

import java.util.Scanner;
import pioneertrail.PioneerTrail;
import pioneertrail.control.ToolControl;
import pioneertrail.model.Game;
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

            System.out.println("\nEnter the amount of wood you would like "
                    + "to use, or press enter to return to the previous menu: ");
            Scanner scanner = new Scanner(System.in);
            inputs[0] = scanner.nextLine();
            inputs[0] = inputs[0].trim();

            if (inputs[0].length() < 1) {
                return inputs;
            }
            try {
                int menuItem = 0;
                menuItem = Integer.parseInt(inputs[0]);
            } catch (Exception ex) {
                System.out.println("\nError: You must enter a number or press "
                        + "Enter to return to the previous menu");
                continue;
            }
            //Check for negative values
            if (Integer.parseInt(inputs[0]) < 1) {
                System.out.println("\nError: You must enter a positive value");
                continue;
            }
            valid = true;
            return inputs;
        }

        return inputs;
    }

    private boolean doAction(String[] inputs) {
        Game game = PioneerTrail.getCurrentGame();
        Wagon wagon = game.getWagon();
        InventoryItem item = wagon.getInventoryItems().get(0);
        Tool tool = wagon.getTools().get(0);
        int menuItem = Integer.parseInt(inputs[0]);
        if (menuItem > item.getCount()) {
            System.out.println("You cannot enter more wood than you have.");
            return false;
        }
        if (item.getItemType().equalsIgnoreCase("Wood")) {
            int originalCount = (item.getCount());
            int woodUsage = (item.getCount() - menuItem);
            item.setCount(menuItem);
            int result = ToolControl.repairWagon(item, tool, wagon);
            if (result == -1) {
                System.out.println("Incorrect item type");
                item.setCount(originalCount);
            } else if (result == -2) {
                System.out.println("Tool durability too low");
                item.setCount(originalCount);
            } else if (result == -3) {
                System.out.println("Not enough wood");
                item.setCount(originalCount);
            } else if (result == -4) {
                System.out.println("Incorrect tool type");
                item.setCount(originalCount);
            } else {
                System.out.println("Wagon new health is: " + result);
                item.setCount(woodUsage);
                System.out.println("You now have " + item.getCount() + " wood.");
                System.out.println("Tool Durability is now " + tool.getDurability());
            }
        }
        return false;
    }
}
