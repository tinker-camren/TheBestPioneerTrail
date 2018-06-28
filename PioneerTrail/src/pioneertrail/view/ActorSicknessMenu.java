/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pioneertrail.view;

import pioneertrail.PioneerTrail;
import pioneertrail.model.ActorObject;
import pioneertrail.model.Game;

/**
 *
 * @author tinkerc
 */
class ActorSicknessMenu extends View  {
    
    public ActorSicknessMenu() {
        displayMessage = buildMenu();
    }
        public void displayActorSicknessMenu(ActorObject actor) {
            
        private String buildMenu() {
        String input = "**********\n"
                + actor.get
                + "\n**********";

        Game game = PioneerTrail.getCurrentGame();
        Wagon wagon = game.getWagon();
        Tool hammer = wagon.getTools().get(0);
        Tool gun = wagon.getTools().get(1);
        Tool axe = wagon.getTools().get(2);

        if (axe.getDurability() > 0) {
            input += ("\nTool Type: " + axe.getToolType());
            input += ("\n\tTool Durability: " + axe.getDurability());
        } else {
            input += ("\nAxe broken or non-existent");
        }

        if (hammer.getDurability() > 0) {
            input += ("\nTool Type: " + hammer.getToolType());
            input += ("\n\tTool Durability: " + hammer.getDurability());
        } else {
            input += ("\nHammer broken or non-existent");
        }

        if (gun.getDurability() > 0) {
            input += ("\nTool Type: " + gun.getToolType());
            input += ("\n\tTool Durability: " + gun.getDurability());
        } else {
            input += ("\nGun broken or non-existent");
        }

        input += ("\n\nPress Enter or enter Q to quit");

        return input;
    }
    }
}
