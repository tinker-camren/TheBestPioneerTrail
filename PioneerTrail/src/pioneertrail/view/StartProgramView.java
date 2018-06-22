/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pioneertrail.view;

import java.util.Scanner;
import pioneertrail.control.GameControl;
import pioneertrail.model.Player;

/**
 *
 * @author tinkerc
 */
public class StartProgramView extends View {

    public StartProgramView() {
    }

    @Override
    public String[] getInputs() {
        String[] inputs = new String[1];
        System.out.println("\n*****************************"
                + "*******************************"
                + "*******************************"
                + "\nThe Pioneer Trail game is a text based role playing game. "
                + "\nIn this game, you will be a pioneer family who leads a wagon train preparing to go west."
                + "\nYou have suffered constant religious persecution and wish to find freedom and a new life "
                + "\nin a better place. You have heard of a place called Zion in the mountains that offers such "
                + "\nfreedom and are eager to start your journey. "
                + "\nYour family is composed of both parents and three children. Before starting the long journey "
                + "\nof 1,500 miles, you must buy a series of items necessary for the trip, such as: food, water, "
                + "\ntools, spare parts for the wagon, weapons, ammunition, etc. You must plan carefully so that "
                + "\nyou will have the items you need before you begin your journey. "
                + "\nProblems may arise during the trip, such as illness or death of family members, snake bites, "
                + "\nbroken wagons, adverse weather conditions, etc. You will have the opportunity to hunt if you "
                + "\nhave weapons and ammunition when you spot a bison, or an elk. If you have the needed supplies "
                + "\nyou could repair your damaged wagon, and fish when arriving at a lake or river. You will also "
                + "\nhave to stop to rest from time to time, due to weak animals or to obtain food. The game is over "
                + "\nwhen at least two family members have reached Zion."
                + "\n*******************************"
                + "*******************************"
                + "*******************************");

        String playersName = this.getInput("\nPlease enter your name:");
        inputs[0] = playersName;

        return inputs;
    }

    @Override
    public boolean doAction(String[] inputs) {

        String playersName = inputs[0];
        Player player = GameControl.savePlayer(playersName);
        if (player == null) {
            System.out.println("Could not create the player."
                    + "Enter a different name.");
            return false;
        }

        System.out.println("\n======================================"
                + "Welcome to the Best Pioneer Trail game "
                + playersName + "!"
                + " We hope you have a lot of fun!"
                + "=======================================");

        MainMenuView mainMenuView = new MainMenuView();
        mainMenuView.display();

        return true;
    }
}
