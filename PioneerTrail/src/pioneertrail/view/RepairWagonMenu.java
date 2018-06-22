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
 * @author Tinkerc
 */
class RepairWagonMenu extends View {

    @Override
    public String[] getInputs() {
        String[] inputs = new String[1];

        System.out.println("**********"
                + "\nRepair Wagon Menu"
                + "\n**********");

        String input = this.getInput("\nEnter the amount of wood you would like "
                + "to use, or enter any character to quit: ");
        inputs[0] = input;

        if (inputs[0].equalsIgnoreCase("Q")) {
            return inputs;
        }

        try {
            int menuItem = 0;
            menuItem = Integer.parseInt(inputs[0]);
        } catch (Exception ex) {
            System.out.println("\nReturning to previous menu");
            inputs[0] = "Q"; //Forces menu to quit if anything except an int is entered
        }
        return inputs;
    }

    @Override
    public boolean doAction(String[] inputs) {
        Game game = PioneerTrail.getCurrentGame();
        Wagon wagon = game.getWagon();
        InventoryItem item = wagon.getItems().get(0);
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
