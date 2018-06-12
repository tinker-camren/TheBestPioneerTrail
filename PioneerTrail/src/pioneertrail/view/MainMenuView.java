/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pioneertrail.view;

import java.util.Scanner;
import pioneertrail.PioneerTrail;
import pioneertrail.control.GameControl;
import pioneertrail.model.Game;
import pioneertrail.model.Player;

/**
 *
 * @author Suckafish
 */
class MainMenuView {

    void displayMainMenuView() {
        boolean endView = false;

        do {

            String[] inputs = this.getInputs();
            String toUpperCase = inputs[0].toUpperCase();
            if (toUpperCase.equals("Q") || inputs[0].length() < 1) {
                java.lang.System.exit(0);
            }
            endView = doAction(inputs);
        } while (endView != true);

    }

    private String[] getInputs() {
        System.out.println("\nMain Menu view get inputs");
        String[] inputs = new String[1];
        boolean valid = false;

        while (valid == false) {
            System.out.println("**********"
                    + "\nMain MENU"
                    + "\n**********");
            System.out.println(
                    "N - Start new game\n"
                    + "R - Restart existing game\n"
                    + "H - Get help on how to play the game\n"
                    + "E - Exit");
            System.out.println("Enter your selection: ");
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
            case "N":
                startNewGame();
                break;
            case "R":
                restartGame();
                break;
            case "H":
                getHelp();
                break;
            case "E":
                return true;

            default:
                System.out.println("Invalid menu item");

        }

        return false;
    }

    private void startNewGame() {
        GameControl.createNewGame(PioneerTrail.getPlayer());
        GameMenuView gameMenuView = new GameMenuView();
        gameMenuView.display();
    }

    private void restartGame() {
        StartExistingGameView startExistingGameView = new StartExistingGameView();
        startExistingGameView.displayStartExistingGameView();
    }

    private void getHelp() {
        HelpMenuView helpMenuView = new HelpMenuView();
        helpMenuView.displayHelpMenuView();
    }

}
