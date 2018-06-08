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
            System.out.println("The Pioneer Trail game is a text based role playing game. "
                    + "In this game, you will be a pioneer family who leads a wagon train "
                    + "preparing to go west. You have suffered constant religious persecution "
                    + "and wish to find freedom and a new life in a better place. "
                    + "You have heard of a place called Zion in the mountains that offers "
                    + "such freedom and are eager to start your journey.\n"
                    + "Your family is composed of both parents and three children. "
                    + "Before starting the long journey of 1,500 miles, you must buy "
                    + "a series of items necessary for the trip, such as: food, water, tools, "
                    + "spare parts for the wagon, weapons, ammunition, etc. "
                    + "You must plan carefully so that you will have the items you need "
                    + "before you begin your journey.\n"
                    + "Problems may arise during the trip, such as illness or death of family members, "
                    + "snake bites, broken wagons, adverse weather conditions, etc. "
                    + "You will have the opportunity to hunt if you have weapons and ammunition "
                    + "when you spot a bison, or an elk. If you have the needed supplies"
                    + " you could repair your damaged wagon, and fish when arriving at a lake or river. "
                    + "You will also have to stop to rest from time to time, due to weak animals or "
                    + "to obtain food. The game is over when at least two family members have reached Zion.");
            
            System.out.println("Please enter your name: ");
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
        
        System.out.println("================================================="
                + "Welcome to the game " + playersName
                + " We hope you have a lot of fun!"
                + "=================================================");

        MainMenuView mainMenuView = new MainMenuView();
        mainMenuView.displayMainMenuView();

        
        return true;
    }
}
