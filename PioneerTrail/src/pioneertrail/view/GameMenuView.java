/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pioneertrail.view;

import java.util.Scanner;
import pioneertrail.control.GameControl;
import pioneertrail.model.InventoryItem;
import pioneertrail.model.Player;
import pioneertrail.model.Wagon;

/**
 *
 * @author Danica
 */
class GameMenuView extends View {

    public GameMenuView() {
        super("**********"
                + "\nGame MENU"
                + "\n**********\n"
                + "V - View Map"
                + "\nI - View inventory items"
                + "\nT - View Tool List"
                + "\nP - Purchase supplies"
                + "\nM - Move to new location"
                + "\nF - View Family Members"
                + "\nG - Gather resources"
                + "\nR - Repair wagon"
                + "\nD - Deal with sickness"
                + "\nH - Help"
                + "\nS - Save game"
                + "\nQ - Quit");
    }
    
    @Override
    public boolean doAction(String inputs) {

        String menuItem = inputs.toUpperCase();

        switch (menuItem) {
            case "V":
                mapView();
                break;
            case "I":
                inventoryItemView();
                break;
            case "T":
                ToolView();
                break;
            case "P":
                supplyPurchase();
                break;
            case "M":
                moveLocation();
                break;
            case "F":
                familyMembers();
                break;
            case "G":
                gatherResources();
                break;
            case "R":
                repairWagon();
                break;
            case "D":
                sicknessMenu();
                break;
            case "H":
                getHelp();
            case "S":
                saveGame();
                break;
            case "Q":
                //mainMenuView();
                return true;

            default:
                ErrorView.display(this.getClass().getName(), "Invalid menu item");
        }
        return false;
    }

    private void mapView() {
        MapView mapView = new MapView();
        mapView.displayMapView();
    }

    private void inventoryItemView() {
        InventoryItemView inventoryItemView = new InventoryItemView();
        inventoryItemView.display();
    }

    private void supplyPurchase() {
        SupplyPurchase supplyPurchase = new SupplyPurchase();
        supplyPurchase.display();
    }

    private void moveLocation() {
        MoveLocation moveLocation = new MoveLocation();
        moveLocation.display();
    }

    private void familyMembers() {
        FamilyMembers familyMembers = new FamilyMembers();
        familyMembers.display();
    }

    private void gatherResources() {
        GatherResources gatherResources = new GatherResources();
        gatherResources.display();
    }

    private void repairWagon() {
        RepairWagon repairWagon = new RepairWagon();
        repairWagon.display();
    }

    private void sicknessMenu() {
        SicknessMenu sicknessMenu = new SicknessMenu();
        sicknessMenu.display();
    }

    private void getHelp() {
        HelpMenuView helpMenuView = new HelpMenuView();
        helpMenuView.display();
    }

    private void saveGame() {
        SaveGameView saveGameView = new SaveGameView();
        saveGameView.display();
        //GameControl.saveGame();
    }

    private void ToolView() {
        ToolView toolView = new ToolView();
        toolView.display();
    }

}
