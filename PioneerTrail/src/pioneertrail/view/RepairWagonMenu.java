/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pioneertrail.view;

import java.util.Scanner;
import pioneertrail.PioneerTrail;
import pioneertrail.control.ToolControl;
import pioneertrail.exceptions.ToolControlException;
import pioneertrail.model.Game;
import pioneertrail.model.InventoryItem;
import pioneertrail.model.InventoryItemEnum;
import pioneertrail.model.Tool;
import pioneertrail.model.Wagon;

/**
 *
 * @author Tinkerc
 */
class RepairWagonMenu extends View {
    
    public RepairWagonMenu() {
        super("**********"
                + "\nRepair Wagon Menu"
                + "\n**********\n"
                + "\nEnter the amount of wood you would like "
                + "to use, or enter Q to quit: ");
}

    @Override
    public boolean doAction(String inputs) {
        try {
            int menuItem = Integer.parseInt(inputs);
        } catch(Exception ex) {
            ErrorView.display(this.getClass().getName(), "\nInvalid input, please enter a number");
            return false;
        }
        
        int menuItem = Integer.parseInt(inputs);
        Game game = PioneerTrail.getCurrentGame();
        Wagon wagon = game.getWagon();
        InventoryItem item = wagon.getItems().get(InventoryItemEnum.Wood.ordinal());
        Tool tool = wagon.getTools().get(0);
        //int menuItem = Integer.parseInt(inputs[0]);
        if (menuItem > item.getCount()) {
            ErrorView.display(this.getClass().getName(), "You cannot enter more wood than you have.");
            return false;
        }
        if (item.getItemType().equalsIgnoreCase("Wood")) {
            int originalCount = (item.getCount());
            int woodUsage = (item.getCount() - menuItem);
            item.setCount(menuItem);
            int result;
            try {
            result = ToolControl.repairWagon(item, tool, wagon);
            } catch (ToolControlException te) {
                ErrorView.display(this.getClass().getName(), te.getMessage());
                return false;
            }
//            if (result == -1) {
//                System.out.println("Incorrect item type");
//                item.setCount(originalCount);
//            } else if (result == -2) {
//                System.out.println("Tool durability too low");
//                item.setCount(originalCount);
//            } else if (result == -3) {
//                System.out.println("Not enough wood");
//                item.setCount(originalCount);
//            } else if (result == -4) {
//                System.out.println("Incorrect tool type");
//                item.setCount(originalCount);
//            } else {
                System.out.println("Wagon new health is: " + result);
                item.setCount(woodUsage);
                System.out.println("You now have " + item.getCount() + " wood.");
                System.out.println("Tool Durability is now " + tool.getDurability());
//            }
        }
        return false;
    }
}
