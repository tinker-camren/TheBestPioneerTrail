/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pioneertrail.view;

import pioneertrail.PioneerTrail;
import pioneertrail.control.GameControl;
import pioneertrail.exceptions.GameControlException;
import pioneertrail.model.Game;

/**
 *
 * @author Danica
 */
public class StartExistingGameView extends View{

    public StartExistingGameView() {
        super("**********"
                + "\nStart Saved Game Menu"
                + "\n**********\n"
                + "\nEnter the name of your saved game"
                + ", or enter Q to quit: ");
    }

    @Override
    public boolean doAction(String inputs) {

        String filePath = inputs;

        try {
            GameControl.getGame(filePath);
        } catch (GameControlException ex) {
            ErrorView.display(this.getClass().getName(), ex.getMessage());
            return false;

        }
        this.console.println("game was retrieved from " + filePath);
        GameMenuView gameMenuView = new GameMenuView();
        gameMenuView.display();
        return true;
    }

}
