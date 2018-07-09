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
import pioneertrail.model.InventoryItemEnum;
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
        System.out.println(items.toString());
        InventoryItem item = items.get(InventoryItemEnum.Wood.ordinal());
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
        input += ("\nEnter your selection:");

        return input;

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
        //This refreshes the Repair Wagon view
        displayMessage = buildMenu();
    }
}
