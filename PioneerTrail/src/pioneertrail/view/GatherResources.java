/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pioneertrail.view;

import java.util.ArrayList;
import java.util.Scanner;
import pioneertrail.PioneerTrail;
import pioneertrail.control.GameControl;
import pioneertrail.model.Game;
import pioneertrail.model.InventoryItem;
import pioneertrail.model.InventoryItemEnum;
import pioneertrail.model.Location;
import pioneertrail.model.Scene;
import pioneertrail.model.Tool;
import pioneertrail.model.Wagon;

/**
 *
 * @author Danica
 */
class GatherResources extends View {

    public GatherResources() {
        displayMessage = buildMenu();
    }
    
    private String buildMenu() {

        ArrayList<InventoryItem> items = new ArrayList<>();
        Game game = PioneerTrail.getCurrentGame();
        Wagon wagon = game.getWagon();
        items = wagon.getItems();
        Location location = game.getMap().getCurrentLocation();
        Scene scene = location.getScene();
        
        String input = ("*********************"
                + "\nGather Resources MENU"
                + "\n*********************\n"
                + "\nC - Chop wood"
                + "\nH - Hunt for meat"
                + "\nG - Gather other resources"
                + "\nQ - Quit\n"
                + "Enter your selection: ");
        
        
        
        return input;

    }


    @Override
    public boolean doAction(String inputs) {

        String menuItem = inputs.toUpperCase();

        switch (menuItem) {
            case "C":
                chopWood();
                break;
            case "H":
                huntAnimals();
                break;
            case "G":
                gather();
                break;
            case "Q":
                //gameMenuView();
                return true;

            default:
                ErrorView.display(this.getClass().getName(), "Invalid menu item");
        }
        return false;
    }

    private void chopWood() {
        ChopWood chopWood = new ChopWood();
        chopWood.display();
    }

    private void huntAnimals() {
        HuntAnimals huntAnimals = new HuntAnimals();
        huntAnimals.display();
    }

    private void gather() {
        System.out.println("Gather Called");
    }

}
