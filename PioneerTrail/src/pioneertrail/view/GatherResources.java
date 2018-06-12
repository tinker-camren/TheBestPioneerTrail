/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pioneertrail.view;

import java.util.Scanner;
import pioneertrail.control.GameControl;
import pioneertrail.model.InventoryItem;

/**
 *
 * @author Danica
 */
class GatherResources {

    public GatherResources() {
    }

    public void displayGatherResources() {
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
        System.out.println("\nGather resources menu view get inputs");
        String[] inputs = new String[1];
        boolean valid = false;

        while (valid == false) {
            System.out.println("*********************"
                    + "\nGather Resources MENU"
                    + "\n*********************");
            System.out.println(
                    "C - Chop wood"
                    + "\nH - Hunt for meat"
                    + "\nQ - Quit");
            System.out.println("\nEnter your selection: ");
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
            case "C":
                chopWood();
                break;
            case "H":
                huntAnimals();
                break;
            case "Q":
                //gameMenuView();
                return true;

            default:
                System.out.println("Invalid menu item");
        }
        return false;
    }

    private void chopWood() {
        ChopWood chopWood = new ChopWood();
        chopWood.displayChopWood();
    }

    private void huntAnimals() {
        HuntAnimals huntAnimals = new HuntAnimals();
        huntAnimals.displayHuntAnimals();
    }

}
