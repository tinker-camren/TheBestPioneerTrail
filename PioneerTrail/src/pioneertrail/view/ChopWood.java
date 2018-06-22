/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pioneertrail.view;

import java.util.Scanner;
//import pioneertrail.control.ToolControl;

/**
 *
 * @author Danica
 */
class ChopWood extends View {

    public ChopWood() {
    }

    @Override
    public String[] getInputs() {
        String[] inputs = new String[1];

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
        String input = this.getInput("Enter your selection: ");
        inputs[0] = input;

        return inputs;
    }

    @Override
    public boolean doAction(String[] inputs) {

        String menuItem = inputs[0].toUpperCase();

        if (menuItem.compareToIgnoreCase("Y") == 0) {
            System.out.println("You chopped some wood!");
            return false;
        } else if (menuItem.compareToIgnoreCase("N") == 0) {
            System.out.println("You decided not to chop wood.");
            return false;
        } else {
            System.out.println("Invalid menu item");
        }
        return false;
    }
}
