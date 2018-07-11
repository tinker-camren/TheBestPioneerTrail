/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pioneertrail.view;

import java.util.Scanner;
import pioneertrail.control.GameControl;
import pioneertrail.model.InventoryItem;

/**
 *
 * @author Danica
 */
class GatherResources extends View {

    public GatherResources() {
        super("*********************"
                + "\nGather Resources MENU"
                + "\n*********************\n"
                + "C - Chop wood"
                + "\nH - Hunt for meat"
                + "\nQ - Quit\n"
                + "Enter your selection: ");
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

}
