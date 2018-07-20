/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pioneertrail.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import pioneertrail.PioneerTrail;
import pioneertrail.exceptions.ActorControlException;
import pioneertrail.model.ActorEnum;
import pioneertrail.model.ActorObject;
import pioneertrail.model.Game;
import pioneertrail.model.InventoryItem;
import pioneertrail.model.InventoryItemEnum;
import pioneertrail.model.Scene;
import pioneertrail.model.SicknessScene;

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
    
    public static void createSplint(ActorObject actor) 
            throws ActorControlException {
        ArrayList<InventoryItem> items = PioneerTrail.getCurrentGame().getWagon().getItems();
        InventoryItem wood = items.get(InventoryItemEnum.Wood.ordinal());
        ActorObject[] actors = PioneerTrail.getCurrentGame().getActors();
        
        //Error checking
        if (wood.getCount() < 1) {
            throw new ActorControlException("Wood quantity is less than 1");
        }
        if (wood.getItemType() != "Wood") {
            throw new ActorControlException("Item type is not wood");
        }
        if (actor.getSickness()!= "Broken Bone"){
            throw new ActorControlException("The actor doesn't have a broken bone");
        }
        if (actor.getHealth() < 1) {
            throw new ActorControlException("The actor is deceased");
        }
        
        int woodCount = wood.getCount();
        int newWoodCount = woodCount -2;
        int actorHealth = actor.getHealth();
        int newActorHealth = actorHealth + 5;
        
        actor.setHealth(newActorHealth);
        actor.setSickness("Healthy");
        
        wood.setCount(newWoodCount);
        items.set(InventoryItemEnum.Wood.ordinal(), wood);
    }
    
    public static String rest(ActorObject actor)
                    throws ActorControlException {
        ArrayList<InventoryItem> items = PioneerTrail.getCurrentGame().getWagon().getItems();
        InventoryItem meat = items.get(InventoryItemEnum.Meat.ordinal());
        InventoryItem potatoes = items.get(InventoryItemEnum.Potatoes.ordinal());
        InventoryItem water = items.get(InventoryItemEnum.Water.ordinal());
        String output = "";
        double multiplier = 1;
        boolean noMeat = false;
        boolean noPotatoes = false;
        boolean noWater = false;
        
        //Error checking
        if (meat.getCount() < 1) {
            output += "Not enough meat, effect decreased by 33%";
            multiplier = multiplier = 0.33;
            noMeat = true;
            //throw new ActorControlException("Meat quantity is less than 1");
        }
        if (!"Meat".equals(meat.getItemType())) {
            throw new ActorControlException("Item isn't meat");
        } 
        
        if (potatoes.getCount() < 1) {
            output += "Not enough potatoes, effect decreased by 33%";
            multiplier = multiplier - 0.33;
            noPotatoes = true;
            //throw new ActorControlException("Potatoes quantity is less than 1");
        }
        if (!"Potatoes".equals(potatoes.getItemType())) {
            throw new ActorControlException("Item isn't potatoes");
        } 
        
        if (water.getCount() < 1) {
            output += "Not enough water, effect decreased by 34%";
            multiplier = multiplier - 0.34;
            noWater = true;
            //throw new ActorControlException("Potatoes quantity is less than 1");
        }
        if (!"Water".equals(water.getItemType())) {
            throw new ActorControlException("Item isn't water");
        } 
        if (actor.getHealth() < 1) {
            throw new ActorControlException("Actor is deceased");
        }
        if (!actor.getSickness().equals("Fatigue")) {
            throw new ActorControlException("Actor isn't fatigued");
        }
        if (multiplier == 0) {
            throw new ActorControlException("You don't have any food or water to use");
        }

        if (noMeat = false) {
            meat.setCount(meat.getCount() - 1);
        }
        if (noPotatoes = false) {
            potatoes.setCount(potatoes.getCount() - 1);
        }
        if (noWater = false) {
            water.setCount(water.getCount() - 1);
        }
        
        int newActorHealth = (int) (actor.getHealth() + (5 * multiplier));
        actor.setHealth(newActorHealth);
        
        //If the actor is fatigued, set them back to healthy
        if (actor.getSickness().equals("Fatigue"))
            actor.setSickness("Healthy");
        
        output += (actor.getName() + " is done resting");
        
        return output;
    }

    public static String medicalSupplies(ActorObject actor) 
        throws ActorControlException {
        ArrayList<InventoryItem> items = PioneerTrail.getCurrentGame().getWagon().getItems();
        InventoryItem medicalSupplies = items.get(InventoryItemEnum.MedicalSupplies.ordinal());
        String output = "";
        
        //Error checking
        if (medicalSupplies.getCount() < 1) {
            throw new ActorControlException("Not enough medical supplies");
        }
        if (!"Medical Supplies".equals(medicalSupplies.getItemType())) {
            throw new ActorControlException("Invalid item type stored");
        } 

        if (actor.getHealth() < 1) {
            throw new ActorControlException("Actor is deceased");
        }

        medicalSupplies.setCount(medicalSupplies.getCount() - 1);
        actor.setHealth(actor.getHealth() + 15);
        
        //Medical Supplies get rid of any sickness
        actor.setSickness("Healthy");
        
        output += (actor.getName() + " Used medical supplies");
        
        return output;
    }
    
    public static ActorObject catchSickness(Scene scene) {
        
        ActorObject[] actors = PioneerTrail.getCurrentGame().getActors();
        ActorObject actor = actors[0]; //set to 1st actor - it will change later
        SicknessScene sScene = (SicknessScene) scene;
        Random randomActor = new Random();
        
        for (int i = 0; i < (actors.length); i++ ) {
            actor = actors[i];
            
            //Check actor to see if they're sick
            if (actor.getSickness().equals("Healthy"))
                break;
            else
                actor = null;
        }
        
        // If all actors are sick, then it just picks a random one 
        // and gives them a new illness
        if (actor == null) {
            int randomIndex = randomActor.nextInt(actors.length);
            actor = actors[randomIndex]; 
        } else {
            // Use random generator to get only healthy actors
            do {
                int randomIndex = randomActor.nextInt(actors.length);
                actor = actors[randomIndex];        
            } while (!actor.getSickness().equals("Healthy"));        
        }
        actor.setSickness(sScene.getSicknessType());
        return actor;
    }

    public static String sicknessPain() {
        
        /* This class subtracts or adds health everytime you move depending
           on what sickness status the actor(s) have */
        ActorObject[] actors = PioneerTrail.getCurrentGame().getActors();
        ActorObject actor;
        String output = "";
        
        for (int i = 0; i < (actors.length) ; i++ ) {
            actor = actors[i];
            
            if (actor.getSickness().equals("Malaria")) {
                actor.setHealth(actor.getHealth() - 10);
                output += "\n" + actor.getName() + " Has lost 10 health due to " 
                        + actor.getSickness();
            }
            if (actor.getSickness().equals("Broken Bone")) {
                actor.setHealth(actor.getHealth() - 8);
                output += "\n" + actor.getName() + " Has lost 8 health due to " 
                        + actor.getSickness();
            }
            if (actor.getSickness().equals("Flu")) {
                actor.setHealth(actor.getHealth() - 7);
                output += "\n" + actor.getName() + " Has lost 7 health due to " 
                        + actor.getSickness();
            }
            if (actor.getSickness().equals("Fatigue")) {
                actor.setHealth(actor.getHealth() - 5);
                output += "\n" + actor.getName() + " Has lost 5 health due to " 
                        + actor.getSickness();
            }
            if (actor.getSickness().equals("Healthy")) {
                actor.setHealth(actor.getHealth() + 3);
                output += "\n" + actor.getName() + " Has gained 3 health due to being " 
                        + actor.getSickness();
            }
        }
        
        return output;
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

//    public static String rest(ActorObject actor)
//                    throws ActorControlException {
//        ArrayList<InventoryItem> items = PioneerTrail.getCurrentGame().getWagon().getItems();
//        InventoryItem meat = items.get(InventoryItemEnum.Meat.ordinal());
//        InventoryItem potatoes = items.get(InventoryItemEnum.Potatoes.ordinal());
//        InventoryItem water = items.get(InventoryItemEnum.Water.ordinal());
//        ActorObject[] actors = PioneerTrail.getCurrentGame().getActors();
//        ActorObject[] deceased = PioneerTrail.getCurrentGame().getDeceased();
//        String output = "";
//        double multiplier = 1;
//        
//        //Error checking
//        if (meat.getCount() < (actors.length - deceased.length)) {
//            output += "Not enough meat, effect decreased by 33%";
//            multiplier = multiplier = 0.33;
//            //throw new ActorControlException("Meat quantity is less than 1");
//        }
//        if (!"Meat".equals(meat.getItemType())) {
//            throw new ActorControlException("Item isn't meat");
//        } 
//        
//        if (potatoes.getCount() < (actors.length - deceased.length)) {
//            output += "Not enough potatoes, effect decreased by 33%";
//            multiplier = multiplier - 0.33;
//            //throw new ActorControlException("Potatoes quantity is less than 1");
//        }
//        if (!"Potatoes".equals(potatoes.getItemType())) {
//            throw new ActorControlException("Item isn't potatoes");
//        } 
//        
//        if (water.getCount() < (actors.length - deceased.length)) {
//            output += "Not enough water, effect decreased by 34%";
//            multiplier = multiplier - 0.34;
//            //throw new ActorControlException("Potatoes quantity is less than 1");
//        }
//        if (!"Water".equals(water.getItemType())) {
//            throw new ActorControlException("Item isn't water");
//        } 
//
//        int newMeatCount = meat.getCount() - (actors.length - deceased.length);
//        int newPotatoesCount = potatoes.getCount() - (actors.length - deceased.length);
//        int newWaterCount = water.getCount() - (actors.length - deceased.length);
//        
//        for (int i = 0; i < (actors.length - deceased.length) ; i++ ) {
//            actor = actors[i];
//            int newActorHealth = (actor.getHealth() + 5);
//            actor.setHealth(newActorHealth);
//            //If the actor is fatigued, set them back to healthy
//            if (actor.getSickness().equals("Fatigue"))
//                actor.setSickness("Healthy");
//        }
//        
//        meat.setCount(newMeatCount);
//        potatoes.setCount(newPotatoesCount);
//        water.setCount(newWaterCount);
//        
//        return output;
//    }



}
