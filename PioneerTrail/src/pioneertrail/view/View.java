/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pioneertrail.view;

import java.util.Scanner;

/**
 *
 * @author Danica
 */
public abstract class View implements ViewInterface {
    protected String displayMessage;
    public View() {
    }
    public View(String msg) {
        displayMessage = msg;
    }
    @Override
    public void display() {
        boolean endOfView = false;
        do {

            String inputs = this.getInputs();
            String toUpperCase = inputs.toUpperCase();
            if (toUpperCase.equals("Q") || inputs.length() < 1) {
                return;
            }
            endOfView = doAction(inputs);
        } while (endOfView != true);
    }

    @Override
    public String getInputs() {
        return getInput(displayMessage);
    };
    @Override
    public String getInput(String promptMessage) {

        boolean valid = false;
        String inputs = new String();
        while (valid == false) {
            System.out.println(promptMessage);
            Scanner scanner = new Scanner(System.in);
            inputs = scanner.nextLine();
            inputs = inputs.trim();

            if (inputs.length() < 1) {
                System.out.println("You must enter a non-blank value");
                continue; //Move to the top of the loop and repeat
            }

            valid = true;
            return inputs;
        }

        return inputs;
    }
}

