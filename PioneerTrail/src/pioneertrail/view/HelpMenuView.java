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
class HelpMenuView {
    void displayHelpMenuView(){
        boolean endView = false;
        
        do{
        
       String[] inputs = this.getInputs();
       String toUpperCase = inputs[0].toUpperCase();
            if (toUpperCase.equals("Q") || inputs[0].length() < 1) {
                return;
            } 
        endView = doAction(inputs);
        }while (endView != true);
    }
    
        private String[] getInputs() {
        System.out.println("Main Menu view get inputs");
        String[] inputs = new String[1];
        boolean valid = false;
        
        while (valid == false) {
        System.out.println("**********"
                + "\nhelp MENU"
                + "\n**********");
        System.out.println(
            "G - What is the goal of the game?"
            + "\nM - How to move"
            + "\nR - Using the resources"
            + "\nQ - Quit");
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
             
        switch (menuItem){
            case "G": gameGoal();
                break;
            case "M": moveHelp();
                break;
            case "R": resourceHelp();
                break;
            case "Q": mainMenuView();
            
            default: System.out.println("Invalid menu item");                
        }
        return false; 
}

    private void gameGoal() {
        GameGoal gameGoal = new GameGoal();
        gameGoal.displayGameGoal();
    }
    
    private void moveHelp() {
        MoveHelp moveHelp = new MoveHelp();
        moveHelp.displayMoveHelp();
    }

    private void resourceHelp() {
        ResourceHelp resourceHelp = new ResourceHelp();
        resourceHelp.displayResourceHelp();
    }

    private void mainMenuView() {
        MainMenuView mainMenuView = new MainMenuView();
        mainMenuView.displayMainMenuView();
    }
}