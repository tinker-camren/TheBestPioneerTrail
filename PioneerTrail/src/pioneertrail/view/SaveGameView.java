/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pioneertrail.view;

import java.io.IOException;
import pioneertrail.PioneerTrail;
import pioneertrail.control.GameControl;
import pioneertrail.exceptions.GameControlException;
import pioneertrail.model.Game;

/**
 *
 * @author Guest
 */
class SaveGameView extends View {

    public SaveGameView() {
        super("**********"
                + "\nSave Game Menu"
                + "\n**********\n"
                + "\nEnter the path where you would like to save "
                + "your game, or enter Q to quit: ");
    }

//    @Override
//    public String getInputs() {
//        String inputs = new String();
//        String message = ("\nS - Save Game"
//                + "\nQ - Quit"
//                + "\nEnter the path where you want to store your save game:");
//        String input1 = getInput(message);
//
//        input1 = inputs;
//        return inputs;
//    }
    @Override
    public boolean doAction(String inputs) {

        String filePath = inputs;
        Game game = PioneerTrail.getCurrentGame();

        try {
            GameControl.saveGame(game, filePath);
        } catch (GameControlException ex) {
            ErrorView.display(this.getClass().getName(), ex.getMessage());
            return false;

        }
        this.console.println("game was saved to " + filePath);
        return false;
    }
}
