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
class HelpMenuView extends View {
    
    public HelpMenuView() {
        super("**********"
                + "\nhelp MENU"
                + "\n**********\n"
                + "G - What is the goal of the game?"
                + "\nM - How to move"
                + "\nR - Using the resources"
                + "\nQ - Quit"
                + "\nEnter your selection: ");
    }



    @Override
    public boolean doAction(String inputs) {

        String menuItem = inputs.toUpperCase();

        switch (menuItem) {
            case "G":
                gameGoal();
                break;
            case "M":
                moveHelp();
                break;
            case "R":
                resourceHelp();
                break;
            case "Q":
                //main menu view
                return true;

            default:
                ErrorView.display(this.getClass().getName(), "Invalid menu item");
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
        mainMenuView.display();
    }
}
