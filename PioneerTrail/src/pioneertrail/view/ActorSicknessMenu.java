/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pioneertrail.view;

import java.util.ArrayList;
import pioneertrail.PioneerTrail;
import pioneertrail.control.ActorControl;
import pioneertrail.control.InventoryControl;
import pioneertrail.exceptions.ActorControlException;
import pioneertrail.model.ActorEnum;
import pioneertrail.model.ActorObject;
import pioneertrail.model.Game;
import pioneertrail.model.InventoryItem;
import pioneertrail.model.Wagon;

/**
 *
 * @author tinkerc
 */
class ActorSicknessMenu extends View  {
    
    public ActorSicknessMenu(ActorObject actor) {
        displayMessage = buildMenu(actor);
    }
            
        private String buildMenu(ActorObject actor) {
        String input = "********************\n"
                + actor.getName() + " Sickness Menu"
                + "\n********************";

        Game game = PioneerTrail.getCurrentGame();
        Wagon wagon = game.getWagon();
        ArrayList<InventoryItem> items = new ArrayList<>();
        game.setSickActor(actor);

        InventoryControl.listItemsAlphabetically(items);
        
        input += ("\n\nS - Make Splint"
                + "\n\tCost: 2 wood"
                + "\n\tEffect: Fixes broken bones and restores 5 health"
                + "\nR - Rest"
                + "\n\tCost: 1 unit of potatoes 1 unit of  meat and 1 unit of water"
                + "\n\tEffect: Removes the Fatigue sickness and restores 5 health if meat, potatoes, and water are available"
                + "\n\tif something is missing, it only restores a percentage of the health"
                + "\nM - Medical Supplies "
                + "\n\tCost: 1 unit of medical supplies"
                + "\n\tEffect: Removes any illness and restores 15 health"
                + "\nE - Exit");
        input += ("\nEnter the action you want to take");
        
        return input;
    }
        
    @Override
    public boolean doAction(String inputs) {
        
        Game game = PioneerTrail.getCurrentGame();
        ActorObject actor = game.getSickActor();
        String menuItem = inputs.toUpperCase();

        switch (menuItem) {
            case "S":
                createSplint(actor);
                break;
            case "R":
                rest(actor);
                break;
            case "M":
                medicalSupplies(actor);
                break;
            case "E":
                //mainMenuView();
                return true;

            default:
                ErrorView.display(this.getClass().getName(), "Invalid menu item");
        }
        return true;
    }

    private void createSplint(ActorObject actor) {
        try {
            this.console.println("Attempting to create a splint...");
            ActorControl.createSplint(actor);
        } catch(ActorControlException te) {
            ErrorView.display(this.getClass().getName(), te.getMessage());
        }
        this.console.println("Splint created successfully");
        displayMessage = buildMenu(actor);
    }

    private void rest(ActorObject actor) {
        try {
            this.console.println("Resting...");
            this.console.println(ActorControl.rest(actor));
            
        } catch(ActorControlException te) {
            ErrorView.display(this.getClass().getName(), te.getMessage());
        }
        displayMessage = buildMenu(actor);
    }

    private void medicalSupplies(ActorObject actor) {
        try {
            this.console.println("Using Medical Supplies...");
            this.console.println(ActorControl.medicalSupplies(actor));
            
        } catch(ActorControlException te) {
            ErrorView.display(this.getClass().getName(), te.getMessage());
        }
        displayMessage = buildMenu(actor);
    }
}
