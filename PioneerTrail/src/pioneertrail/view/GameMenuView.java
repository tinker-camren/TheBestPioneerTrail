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
class GameMenuView {

    public GameMenuView() {
    }

    public void display() {
        boolean endView = false;

        do {
            String[] inputs = this.getInputs();
            String toUpperCase = inputs[0].toUpperCase();
            if (toUpperCase.equals("Q") || inputs[0].length() < 1) {
                return;
            }
            endView = doAction(inputs);
        } while (endView != true);
    }

    private String[] getInputs() {
        System.out.println("\ngame menu view get inputs");
        String[] inputs = new String[1];
        boolean valid = false;

        while (valid == false) {
            System.out.println("**********"
                    + "\nGame MENU"
                    + "\n**********");
            System.out.println(
                    "V - View Map"
                    + "\nI - View inventory items"
                    + "\nP - Purchase supplies"
                    + "\nM - Move to new location"
                    + "\nF - View Family Members"
                    + "\nG - Gather resources"
                    + "\nR - Repair wagon"
                    + "\nD - Deal with sickness"
                    + "\nH - Help"
                    + "\nS - Save game"
                    + "\nQ - Quit");
            System.out.println("\nEnter your selection: ");
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
            case "V":
                mapView();
                break;
            case "I":
                inventoryItemView();
                break;
            case "I":
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
                handleSickness();
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
                System.out.println("Invalid menu item");
        }
        return false;
    }

    private void mapView() {
        MapView mapView = new MapView();
        mapView.displayMapView();
    }

    private void inventoryItemView() {
        InventoryItemView inventoryItemView = new InventoryItemView();
        inventoryItemView.displayInventoryItemView();
    }

    private void supplyPurchase() {
        SupplyPurchase supplyPurchase = new SupplyPurchase();
        supplyPurchase.displaySupplyPurchase();
    }

    private void moveLocation() {
        MoveLocation moveLocation = new MoveLocation();
        moveLocation.displayMoveLocation();
    }

    private void familyMembers() {
        FamilyMembers familyMembers = new FamilyMembers();
        familyMembers.displayFamilyMembers();
    }

    private void gatherResources() {
        GatherResources gatherResources = new GatherResources();
        gatherResources.displayGatherResources();
    }

    private void repairWagon() {
        RepairWagon repairWagon = new RepairWagon();
        repairWagon.displayRepairWagon();
    }

    private void handleSickness() {
        HandleSickness handleSickness = new HandleSickness();
        handleSickness.displayHandleSickness();
    }

    private void getHelp() {
        HelpMenuView helpMenuView = new HelpMenuView();
        helpMenuView.displayHelpMenuView();
    }

    private void saveGame() {
        GameControl.saveGame();
    }

    private void ToolView() {
        ToolView toolView = new ToolView();
        ToolView.displayToolView();
    }

}
