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
public class StartProgramView {

    public StartProgramView() {
    }
    
    public void displayStartProgramView() {
        boolean endOfView = false;
        do {
                
       String[] inputs = this.getInputs();
       String toUpperCase = inputs[0].toUpperCase();
            if (toUpperCase.equals("Q") || inputs[0].length() < 1) {
                java.lang.System.exit(0);
            } 
        endOfView = doAction(inputs);
        }while (endOfView != true); 
        
}

    private String[] getInputs() {
        System.out.println("getInputs() called");
        
        String[] inputs = new String[1];
        boolean valid = false;
        
        while (valid == false) {
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
            
            System.out.println("\nPlease enter your name: ");
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
        
        String playersName = inputs[0];
        Player player = GameControl.savePlayer(playersName);
        if (player == null) {
            System.out.println("Could not create the player." + 
                    "Enter a different name.");
            return false;
        }
        
        System.out.println("\n=========================================="
                + "Welcome to the game " + playersName
                + " We hope you have a lot of fun!"
                + "===========================================");

        MainMenuView mainMenuView = new MainMenuView();
        mainMenuView.displayMainMenuView();

        
        return true;
    }
}
