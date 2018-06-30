/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pioneertrail.control;

import java.util.ArrayList;
import java.util.Collections;
import pioneertrail.PioneerTrail;
import pioneertrail.model.ActorEnum;
import pioneertrail.model.ActorObject;
import pioneertrail.model.Game;
import pioneertrail.model.InventoryItem;
import pioneertrail.model.InventoryItemEnum;

/**
 *
 * @author Suckafish
 */
public class ActorControl {
    public static String listActorSickness() {

        String output = "";

        ActorObject[] actors = PioneerTrail.getCurrentGame().getActors();
        for (int i = 0; i < actors.length ; i++ ) {
            ActorObject actor = actors[i];
            output += ("\n\nName: " + actor.getName() +
                               "\nHealth: " + actor.getHealth() +
                               "\nSickness Status: " + actor.getSickness());
        }
        return output;
    }
    
    public static int createSplint(ActorObject actor) {
        ArrayList<InventoryItem> items = PioneerTrail.getCurrentGame().getWagon().getItems();
        InventoryItem wood = items.get(InventoryItemEnum.Wood.ordinal());
        ActorObject[] actors = PioneerTrail.getCurrentGame().getActors();
        
        //Error checking
        if (wood.getCount() < 1) {
            return -1;
        }
        if (wood.getItemType() != "Wood") {
            return -2;
        }
        if (actor.getSickness()!= "Broken Bone"){
            return -3;
        }
        if (actor.getHealth() < 1) {
            return -4;
        }
        
        int woodCount = wood.getCount();
        int newWoodCount = woodCount -2;
        int actorHealth = actor.getHealth();
        int newActorHealth = actorHealth + 5;
        
        actor.setHealth(newActorHealth);
        actor.setSickness("Healthy");
        
        wood.setCount(newWoodCount);
        items.set(InventoryItemEnum.Wood.ordinal(), wood);
        
        return 1;
    }

//    public static void ListActorsBySickness() {
//        
//        ActorObject[] actors = PioneerTrail.getCurrentGame().getActors();
//        
//        //Sorting based on Actor Name
//	   System.out.println("Actor Name Sorting:");
//	   Collections.sort(actors, ActorObject.NameComparator);
//
//	   for(Student str: arraylist){
//			System.out.println(str);
//	   }
//    }
}
