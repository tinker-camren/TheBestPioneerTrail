/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pioneertrail.control;

import java.util.ArrayList;
import pioneertrail.PioneerTrail;
import pioneertrail.model.ActorObject;
import pioneertrail.model.InventoryItem;

/**
 *
 * @author Suckafish
 */
public class ActorControl {
        public static void listActorSickness() {
        
        ActorObject[] actors = PioneerTrail.getCurrentGame().getActors();
        for (int i = 0; i < actors.length ; i++ ) {
            ActorObject actor = actors[i];
            System.out.println("\nName: " + actor.getName() +
                               "\nHealth: " + actor.getHealth() +
                               "\nSickness Status: " + actor.getSickness());
        }
    }
}
