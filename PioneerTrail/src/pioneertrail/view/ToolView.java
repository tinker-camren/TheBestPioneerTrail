/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pioneertrail.view;

import java.util.ArrayList;
import java.util.Scanner;
import pioneertrail.control.ToolControl;
import pioneertrail.model.InventoryItem;
import pioneertrail.model.Tool;

/**
 *
 * @author Camren
 */
class ToolView {
    void displayToolView() {
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
        
        //Create test instances
        Tool gun = new Tool();
            gun.setToolType("Gun");
            gun.setDurability(80);
        Tool hammer = new Tool();
            hammer.setToolType("Hammer");
            hammer.setDurability(75);
        Tool axe = new Tool();
            axe.setToolType("Axe");
            axe.setDurability(20);
        //End test instances

        while (valid == false) {
            System.out.println("**********"
                    + "\nTool List"
                    + "\n**********");
            
            if (axe.getDurability() > 0) {
                System.out.println("Tool Type: " + axe.getToolType());
                System.out.println("\tTool Durability: " + axe.getDurability());
            } else {
                System.out.println("Axe broken or non-existent");
            }

            if (hammer.getDurability() > 0) {
                System.out.println("Tool Type: " + hammer.getToolType());
                System.out.println("\tTool Durability: " + hammer.getDurability());
            } else {
                System.out.println("Hammer broken or non-existent");
            }

            if (gun.getDurability() > 0) {
                System.out.println("Tool Type: " + gun.getToolType());
                System.out.println("\tTool Durability: " + gun.getDurability());
            } else {
                System.out.println("Gun broken or non-existent");
            }

            System.out.println("\nPress Enter or enter Q to quit");
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

        String menuItem = inputs[0].toUpperCase();

        switch (menuItem) {
            case "Q":
                return true;

            default:
                System.out.println("Invalid input");

        }

        return false;
    }
}
