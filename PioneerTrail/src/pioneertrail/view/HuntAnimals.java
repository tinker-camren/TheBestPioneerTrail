/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pioneertrail.view;

import java.util.ArrayList;
import java.util.Scanner;
import pioneertrail.PioneerTrail;
import pioneertrail.model.Game;
import pioneertrail.model.InventoryItem;
import pioneertrail.model.Wagon;
import pioneertrail.control.GameControl;
import pioneertrail.model.Tool;

/**
 *
 * @author Camren
 * Kathy updated
 */
public class HuntAnimals extends View {

    public HuntAnimals() {
        displayMessage = buildMenu();
    }

    private String buildMenu() {

        ArrayList<InventoryItem> items = new ArrayList<InventoryItem>();
        Game game = PioneerTrail.getCurrentGame();
        Wagon wagon = game.getWagon();
        InventoryItem animal = items.get(0);
        

        String input = "\n**********"
                + "\nHunt Animals"
                + "\n**********";
        input += ("\n\nAnimal Description: " + animal.getDescription());

        if (animal.getItemType().equalsIgnoreCase("Duck")) {
            if (animal.getWeight() > 0) {
                input += ("\nDuck's Weight: " + animal.getWeight());
            } else {
                input += ("\nNo Weight Available");
            }
        } else {
            input += ("\nHunt some more");
        }
        if (animal.getItemType().equalsIgnoreCase("Buffalo")) {
            if (animal.getCount() > 0) {
                input += ("\nBuffalo Count: " + animal.getCount());
            } else {
                input += ("\nNo Animal hunted. You must gather more animals");
            }
        } else {
            input += ("\nNo Animal hunted. You must gather more animals");
        }
        input += ("\nQ - Quit ");
        
        return input;
    }
    
    @Override
    public boolean doAction(String inputs) {

        String menuItem = inputs.toUpperCase();

        if ("I".equals(menuItem)) {
            InventoryItemView();
        } else if ("Q".equals(menuItem)) {
            return true;
        } else {
            System.out.println("Invalid menu item");
        }

        return false;
    }

    private void InventoryItemView() {
        InventoryItemView inventoryItemView = new InventoryItemView();
        inventoryItemView.display();
    }
}
