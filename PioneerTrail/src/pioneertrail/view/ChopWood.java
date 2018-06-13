/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pioneertrail.view;

import java.util.Scanner;
import pioneertrail.control.ToolControl;

/**
 *
 * @author Danica
 */
class ChopWood {

    public ChopWood() {
    }

    void displayChopWood() {
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
        System.out.println("\nChop wood resources menu view get inputs");
        String[] inputs = new String[1];
        boolean valid = false;

        while (valid == false) {
            System.out.println("*********************"
                    + "\nChop Wood MENU"
                    + "\n*********************");
            System.out.println("There are trees near the trail. "
                    + "You decide to investigate.");
            System.out.println(
                    "\nChop the trees with your axe?"
                    + "\nY - Yes"
                    + "\nN - No"
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

        if (menuItem.compareToIgnoreCase("Y") == 0) {
            System.out.println("You chopped some wood!");
            return false;
        }
        else if (menuItem.compareToIgnoreCase("N") == 0) {
            System.out.println("You decided not to chop wood.");
            return false;
        } else {
            System.out.println("Invalid menu item");
        }
        return false;
    }
}
