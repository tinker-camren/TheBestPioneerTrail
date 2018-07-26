/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pioneertrail.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import pioneertrail.PioneerTrail;

/**
 *
 * @author Danica
 */
public abstract class View implements ViewInterface {

    protected String displayMessage;

    protected final BufferedReader keyboard = pioneertrail.PioneerTrail.getInFile();
    protected final PrintWriter console = pioneertrail.PioneerTrail.getOutFile();

    public View() {
    }
    
    public void display(String menu){

        boolean  endOfView = false;

        do {

            String inputs = getInput(menu);

            if (inputs.length() < 1 || inputs.toUpperCase().equals("Q")) {

                endOfView = true;

                continue;

            }

            doAction(inputs);

           if (PioneerTrail.getCurrentGame().isGameOver())

             return;          

           

        } while (endOfView != true);

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
    }

    ;
    @Override
    public String getInput(String promptMessage) {
        
        //Scanner keyboard = new Scanner(this.keyboard);
        boolean valid = false;
        String inputs = null;
        try {
            while (valid == false) {
                this.console.println(promptMessage);
                inputs = this.keyboard.readLine();
                inputs = inputs.trim();

                if (inputs.length() < 1) {
                    ErrorView.display(this.getClass().getName(), "You must enter a non-blank value");
                    continue; //Move to the top of the loop and repeat
                }
                break;
            }

            valid = true;
            return inputs;
        } catch (IOException ex) {
            ErrorView.display(this.getClass().getName(), "Error reading input: " + ex.getMessage());
        }

        return inputs;
    }
}
